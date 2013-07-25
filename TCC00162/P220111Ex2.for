      program P220111Ex2
        implicit none
        real determinante
        
      
      
      
      end
      
      real function determinante(mat,n)
        implicit none
        integer n,i,j
        real mat(n,n),cof(n-1,n-1)
        
        if (n .eq. 1) then
          determinante = mat(1,1)
        else
          i=1
          do j=1,n,1
            call cofator(mat,i,j,cof)
            coef = (-1)**(i+j)*determinante(cof,n-1)
            s = s + mat(i,j)*coef
          end do
          determinante = s
        end if
      end 
      
      subroutine cofator (mat,m,n,d,cof)
        implicit none
        do i=1,d,1
          if (i .ne. m) then
            do j=1,d,1
              if (j .ne. n) then
                if (i .gt. m)
                  linha = i - 1
                end if
                if (j .gt. n) then
                  col = j -1
                end if
                cof(linha,col) = mat(i,j)
              end if
            end do
          end if
        end do
      end
      
      
      
      
      
      
      
      
      end 
      
      
      
      real function somaN (n)
        implicit none
        integer n
        
        if (n .eq. 1) then
          somaN = 1
        else
          somaN = n + somaN(n-1)
        end if
      end
     
      logical function palindromo(n)
        implicit none
        integer n,dd,de,dig
        if (n .lt. 10) then
          palindromo = .true.
        else
          dig = log10(n)
          de = n/(10**dig)
          dd = mod(n,10)
          centro = n - de*(10**dig)
          centro = centro/10
          if (dd .eq. de) then
            if (palindromo(centro)) then
              palindromo = .true.  
            else
              palidromo = .false.
            end if
          end if
        end if
      end
          
          
          
          
          
          
          
      
      end  
        
      
      
      
      
      
      
