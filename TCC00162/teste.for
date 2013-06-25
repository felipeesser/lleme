      program teste
      
      
      
      
      
      
      
        n1=1000
        n2=1000
      
        delta1 = (b-a)/n1
        delta2 = (d-c)/n2
      
        do i=0,n1-1,1
          do j=0,n2-1,1
            
            volume = volume + delta1*delta2*f(a+j*delta1,c+i*delta2)
          
          end do
          
          volume = volume + (b-a+n2*delta1)*delta2*f(a+j*delta1,c+i*delta2)
        end do
        
        do j=0,n2-1,1
            
            volume = volume + delta1*delta2*f(a+j*delta1,c+i*delta2)
          
          end do
          
        volume = volume + (b-a+n2*delta1)*delta2*f(a+j*delta1,c+i*delta2)
      
      end
