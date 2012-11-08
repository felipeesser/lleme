      program T_20102
        implicit none
        integer N
        parameter(N=7)
        real*8 dados(N,2),solucao(2),xi,xi1,zero,e,delta,f,f_newton
        data dados/1980,1985,1990,1993,1997,2000,2006,
     +             1.0D0,
     +             0.934241706D0,
     +             0.827606635D0,
     +             0.852488152D0,
     +             0.840047393D0,
     +             0.82049763D0,
     +             0.838270142D0/
        
        call ajustar(dados,N,solucao)
    
        OPEN(UNIT=1, FILE='T_20102.txt', STATUS='UNKNOWN')
        write(1,'(2(1PE16.5E5))') solucao(1),solucao(2)
        e=1.D-9
        xi=1980.D0
        write(1,'(2(1PE16.5E5))') xi,f(solucao(1),solucao(2),xi)
        loop
          xi1=f_newton(solucao(1),solucao(2),xi)
          delta=abs(xi1-xi)/abs(xi1)
          zero=abs(f(solucao(1),solucao(2),xi1))
          write(1,'(3(1PE16.5E5))') xi1,zero,delta
          xi=xi1
        until (delta.LT.e .and. zero.LT.e)
        write(1,*) 'levara ',xi1-1980,' anos'
        Close (UNIT=1, STATUS='Keep')
      end

      real*8 function f(a,b,x)
        implicit none
        real*8 a,b,x,tendencia
        f=tendencia(a,b,x)-(1688.D0*0.75D0)
      end
      
      real*8 function der_f(a,b,x)
        implicit none
        real*8 a,b,x
        der_f=1688.D0*a*b*exp(b*x)
      end
      
      real*8 function f_newton(a,b,x)
        implicit none
        real*8 a,b,x,f,der_f
        f_newton=x-f(a,b,x)/der_f(a,b,x)
      end

      real*8 function tendencia(a,b,x)
        implicit none
        real*8 a,b,x
        tendencia = 1688.D0*a*exp(b*x)
      end      
      
      subroutine ajustar(dados,N,solucao)
        implicit none
        integer N, k
        real*8 dados(N,2),sistema(2,3),solucao(2), f1, f2
        
        sistema(1,1)=0
        do k=1,N
            sistema(1,1)=sistema(1,1)+f1(dados(k,1))*f1(dados(k,1))
        end do
        
        sistema(1,2)=0
        do k=1,N
            sistema(1,2)=sistema(1,2)+f1(dados(k,1))*f2(dados(k,1))
        end do
        
        sistema(2,1)=0
        do k=1,N
            sistema(2,1)=sistema(2,1)+f2(dados(k,1))*f1(dados(k,1))
        end do
        
        sistema(2,2)=0
        do k=1,N
            sistema(2,2)=sistema(2,2)+f2(dados(k,1))*f2(dados(k,1))
        end do
        
        sistema(1,3)=0
        do k=1,N
            sistema(1,3)=sistema(1,3)+f1(dados(k,1))*log(dados(k,2))
        end do
        
        sistema(2,3)=0
        do k=1,N
            sistema(2,3)=sistema(2,3)+f2(dados(k,1))*log(dados(k,2))
        end do
        
        call triangularizar(sistema,2)
        call resolver(sistema,solucao,2)
        solucao(1)=exp(solucao(1))
      end 
      
      real*8 function f1(x)
        implicit none
        real*8 x
        f1=1.D0
      end 
      
      real*8 function f2(x)
        implicit none
        real*8 x
        f2=x
      end 

      subroutine triangularizar(matriz,N)
        implicit none
        integer N, i, j, k, estrategia
        real*8 matriz(N,N+1), pivot, coef
        do k=1,N
          call maxmizar_pivot(matriz,N,k,estrategia)
          pivot=matriz(k,k)
          do i=k+1,N
              coef=-matriz(i,k)/pivot
              do j=k,N+1
                matriz(i,j)=matriz(i,j)+matriz(k,j)*coef
              end do
          end do
        end do
      end
      
      subroutine maxmizar_pivot(matriz,N,k)
        implicit none
        integer N, i, k, linha
        real*8 matriz(N,N+1)
        linha = k
        do i=k+1,N
          if (abs(matriz(i,k)) .GT. abs(matriz(linha,k))) then
            linha = i
          end if
        end do
        if ((linha .NE. k)) then
          call trocar_pivot(matriz,N,k,linha)
        end if
      end
      
      subroutine trocar_pivot(matriz,N,k,linha)
        implicit none
        integer N, i, j, k, linha
        real*8 matriz(N,N+1), aux1
        if (linha .NE. k) then
          i=k
          do j=k,N+1
            aux1=matriz(i,j)
            matriz(i,j)=matriz(linha,j)
            matriz(linha,j)=aux1
          end do
        end if
      end
      
      subroutine resolver(matriz,solucao,N)
        implicit none
        integer i, j, N
        real*8 matriz(N,N+1), solucao(N)
        do i=N,1,-1
          solucao(i)=matriz(i,N+1)
          do j=N,i+1,-1
            solucao(i)=solucao(i)-matriz(i,j)*solucao(j)
          end do
          solucao(i)=solucao(i)/matriz(i,i)
        end do            
      end