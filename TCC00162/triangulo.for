      program eliminacao
        implicit none
        integer N, i, j, k, estrategia/2/
        parameter (N=2)
        integer incog(N)
        real*8 matriz(N,N+1), solucao(N), pivot, coef

       do i=1,N
          incog(i)=i
        end do
 
    
        OPEN(UNIT=1, FILE='trab2.txt', STATUS='UNKNOWN')
         call imprime_matriz(matriz,N)
           do k=1,N
          call maxmizar_pivot(matriz,incog,N,k,estrategia)
          pivot=matriz(k,k)
          do i=k+1,N
            coef = - matriz(i,k)/ pivot
            do j=k,n
                matriz(i,j) = matriz(i,j) + matriz(k,j)*coef
            end do
                write (1,'(A5,I2,A9,I2,A3,1PE15.5E4,A3,1PE15.5E4)') 
     +      'linha',i,' - linha ',k,' / ',matriz(k,k),' * ',coef
            write (1,'(/\)')
            call imprime_matriz(matriz,N)
          end do
        end do
        call imprime_incog(incog,N)
        call resolver(matriz,solucao,N)
        call imprime_solucao(incog,solucao,N)
        Close (UNIT=1, STATUS='Keep')
      end
          
      subroutine resolver(matriz,solucao,N)
        implicit none
        integer i, j, N
        Real*8 matriz(N,N+1), solucao(N)
        do i=N,1,-1
          solucao(i)=matriz(i,N+1)
          do j=N,i+1,-1
            solucao(i)=solucao(i)-matriz(i,j)*solucao(j)
          end do
          solucao(i)=solucao(i)/matriz(i,i)
        end do            
      end
      
      subroutine maxmizar_pivot(matriz,incog,N,k,estrategia)
        implicit none
        integer N, i, j, k, linha, coluna, estrategia, incog(N)
        Real*8  matriz(N,N+1)
        linha = k
        coluna = k
        if (estrategia .EQ. 1) then
          do i=k+1,N
            do j=k,N
             if(abs(matriz(i,j)).gt.abs(matriz(linha,k))) then
              linha = i
             end if 
            end do
          end do
        else
          if (estrategia .EQ. 2) then
            do i=k,N
              do j=k,N
            if(abs(matriz(i,j)) .gt. abs(matriz(linha,coluna))) then
              linha  = i
              coluna = j
            end if          
              end do
            end do
          end if
        end if
        if ((linha .NE. k) .OR. (coluna .NE. k)) then
          call troca_pivot(matriz,incog,N,k,linha,coluna)
          call imprime_matriz(matriz,N)
        end if
      end
      
      subroutine troca_pivot(matriz,incog,N,k,linha,coluna)
        implicit none
        integer N, i, j, k, linha, coluna, aux2, incog(N)
        Real*8 matriz(N,N+1), aux1, aux3
        if (linha .NE. k) then
          i=k
          do j=k,N+1
             aux1 = matriz(i,j)
             matriz(i,j) = matriz(linha,j)
             matriz(linha,j) = aux1
          end do
          write (1,'(A16,I2,A15,I2)') 'troca da linha ',k,
     +    ' com a linha ',linha
        end if
        if (coluna .NE. K) then
          aux2=incog(k)
          incog(k)=incog(coluna)
          incog(coluna)=aux2
          j=k
          do i=1,N
             aux3 = matriz(i,j)
             matriz(i,j) = matriz(i,coluna)
             matriz(i,coluna) = aux3
          end do
          write (1,'(A16,I2,A15,I2)') 'troca da coluna ',k,
     +    ' com a coluna ',coluna
        end if
        if ((linha .NE. k) .OR. (coluna .NE. K)) then
          write (1,'(/\)')
        end if
      end
          
      subroutine imprime_matriz(mat,N)
        implicit none
       integer a, c, b, x, N, i, j
       Real*8 mat(N,N+1) , Q(10),u, w,lny(10)
      
        Q(1)= 1980.D0
        Q(2)= 1985.D0
        Q(3)= 1990.D0
        Q(4)= 1993.D0
        Q(5)= 1997.D0
        Q(6)= 2000.D0
        Q(7)= 2006.D0

        lny(1)= 7.43
        lny(2)= 7.36
        lny(3)= 7.24
        lny(4)= 7.27
        lny(5)= 7.25
        lny(6)= 7.23
        lny(7)= 7.25
        
        u=0
        b=0
        Do a=1,2
             do c=1,2
                if(a.eq.1) then
               
                    q(a)=1
                    
                       do b=1,7
                       u=u+q(a)*q(b)
                       end do
                    mat(a,c) = u
                     
                 else

                       do b=1,7
                       u=u+q(a)*q(b)
                       end do
                    mat(a,c) = u
              
                 end if
             end do
           u=0
         end do
       
       
       do x=1,2
           b=0
           if(X.eq.1) then
              q(X)=1
                 do b=1,7
                    u=u+(q(X)*lny(b))
       
                 end do
                mat(1,X+1) = u
               
           else
                  do b=1,7
                    u=u+(q(X)*lny(b))
               
                  end do
              mat(1,X+1) = u
         
              end if 
       end do
       
       
       
       
       
        J=0
        I=0
        do i=1,N
          
          do j=1,N+1
            write (1,'(\1PE15.5E4)') mat(i,j)
          end do
          
          write (1,'(/\)')
        end do
        write (1,'(/)')
      end 
          
      subroutine imprime_incog(incog,N)
        implicit none
        integer N,incog(N), i
        write (1,'(\A21)') 'Ordem da incognitas: '
        do i=1,N
          if (i .EQ. N) then
            write (1,'(A1,I2)') 'x',incog(i)
          else
            write (1,'(\A1,I2,A2)') 'x',incog(i),', '
          end if
        end do
      end
          
      subroutine imprime_solucao(incog,solucao,N)
        implicit none
        integer i, N, incog(N)
        Real*8 solucao(N)
        write (1,'(A9)') 'Solucao: '
        do i=1,N
          write (1,'(A1,I2,A1,1PE20.11E4)') 'x',incog(i),'=',solucao(i)
        end do
      end
  
       
