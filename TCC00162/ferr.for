      program m5_bissecao
        implicit none
        real*8 a,b,e,xi,xi1,f,xi_fp
        OPEN(UNIT=1, FILE='Nelo.txt', STATUS='UNKNOWN')
        
      
        a=1988.0
        b=2006.0
        e=1.D-9
        xi1=xi_fp(a,b)
        
         write (1,'(\A60,1PE15.5E2,A60)')  
     +     'F(X)=(213,79)*EXP(0.0009663*x)- 1266'

        write(1,'(5(1PE14.3E5))') a,b,xi1,f(xi1),abs(xi1-xi)/abs(xi1)
        loop
          call quebra(a,b)
          xi=xi1
          xi1=xi_fp(a,b)
          write(1,'(5(1PE14.3E5))') a,b,xi1,f(xi1),abs(xi1-xi)/abs(xi1)
          
        until ((abs(xi1-xi)/abs(xi1) .LT. e) .AND. (abs(f(xi1)) .LT. e))
         write (1,'(\A30,1PE15.5E2,A30)')  
     +     'Levara',1988-a, 'anos para atingir a meta!'
        
        
        CLOSE (UNIT=1, STATUS='Keep')
      end
      
      real*8 function f(x)
        implicit none
        real*8 x
           f=(213.79)*EXP(0.0009663*x)- 1266
      end
       
      real*8 function xi_fp(a,b)
        implicit none
        real*8 a,b,f
        xi_fp=(a*f(b)-b*f(a))/(f(b)-f(a))
      end
       
      real*8 function xi_bs(a,b)
        implicit none
        real*8 a,b
        xi_bs=(a+b)/2
      end
       
      subroutine quebra(a,b)
        implicit none
        real*8 a,b,c,f,xi_fp
        c=xi_fp(a,b)
        if ((f(c)*f(a)) .GE. 0.) then
          a=c
        else
          b=c
        end if
      end
