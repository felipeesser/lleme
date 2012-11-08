       Program preencheMatriz  
       implicit none
       real*8  Q(10), mat(20,20), u, w, lny(10)
       integer i, j, b, x

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
       
       OPEN(UNIT=1, FILE='soamtori.txt', STATUS='UNKNOWN')
            
        Do i=1,2
             do j=1,2
                if(i.eq.1) then
                    q(i)=1
                    w= q(i)*q(j)
                       do b=1,7
                       u=u+w
                       end do
                    mat(I,J) = u
               write (1,'(\1PE15.5E4)') mat(i,j)
                 else
                    w= q(i)*q(j)
                       do b=1,7
                       u=u+w
                       end do
                    mat(I,J) = u
               write (1,'(\1PE15.5E4)') mat(i,j)
                 end if
             end do
           u=0
         end do
       do x=1,2
           b=0
           if(X.eq.1) then
              q(X)=1
              w= q(X)*lny(j)
                 do b=1,7
                    u=u+w
                 end do
              mat(1,X+1) = u
                 write (1,'(\1PE15.5E4)') mat(1,X+1)
           else
                 w= q(X)*lny(j)
                  do b=1,7
                     u=u+w
                  end do
              mat(1,X+1) = u
                 write (1,'(\1PE15.5E4)') mat(1,X+1)
           end if 
       end do
       close (UNIT=1, STATUS='Keep')
       
       end 
   
