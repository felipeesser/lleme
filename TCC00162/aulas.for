      program aulas
        implicit none 
        real p1, p2, p3
        integer ios
      
        OPEN(UNIT=1, FILE='aulas.txt', STATUS='UNKNOWN')
        OPEN(UNIT=2, FILE='aulas_saida.txt', STATUS='UNKNOWN')
        read (1,'(3F4.2)', IOSTAT = ios) p1, p2, p3
        while (ios .eq. 0) do
          write (2,'(F3.1,1H,,F3.1,1H,,F3.1))') p1, p2, p3
          read (1,'(3F4.2)', IOSTAT = ios) p1, p2, p3
        end while
        Close (UNIT=1, STATUS='Keep')
        Close (UNIT=2, STATUS='Keep')
      end
      
      real function pi(tol)
        integer i
        real s, termo, tol
        i = 0
        s = 0.0
        loop
          termo = ((-1)**i)/(2.0*i+1.0)
          s = s + termo
          i = i + 1
        until (abs(termo) .lt. tol)
        pi = 4.0*s
      end

      integer function primo(n)
        integer n, i
        if (n .lt. 2) then
          primo = 0
        else
          primo = 1
          do i = 2, n-1, 1
            if (resto(n,i) .eq. 0) then
              primo = 0
              exit
            end if
          end do
        end if
      end

      integer function mdcFor(x,y)
        implicit none
        integer x, y, r, resto
        r = -1
        do mdcFor = resto(x,y), 0, r
          x = y
          y = mdcFor
          r = -(mdcFor - resto(x,y))
        end do
      end

      integer function fatorialFor(n)
        integer n, i
        fatorialFor = 1
        do i = 2, n, 1
          fatorialFor = fatorialFor * i
        end do
      end

      
      integer function fatorial(x)
        real x
        while (x .gt. 1) do
          fatorial = fatorial * x
          x = x - 1
        end while
      end
      
      integer function mdc(x,y)
        integer x, y, resto
        mdc = resto(x,y)
        while (mdc .ne. 0) do
          x = y
          y = mdc
          mdc = resto(x,y)
        end while
      end

      real function maior(p1, p2)
        real p1, p2
        if (p1 .ge. p2) then
          maior = p1
        else
          maior = p2
        end if
      end
      
      real function calcVolume(raio,altura)
        implicit none
        real raio, altura, PI
        parameter (PI=3.141592653)
        calcVolume = PI * (raio ** 2) * altura
      end
      
      real function converteTemp(cels)
        implicit none
        real cels
        converteTemp = 1.8 * cels + 32
      end
      
      subroutine imprime(fahr)
        implicit none
        real fahr
        write (1,'(A22,f10.4)') 'Temperatura em oF: ',fahr
      end
      
      integer function resto(a,b)
        integer a, b
        resto = a - (a / b) * b
      end

