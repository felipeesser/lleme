      program Lista1Ex1
        implicit none
        integer a,b
        OPEN(UNIT=1, FILE='resultado.txt')
        write (*,'(A20)') 'Digite o numeros:'
        read (*, '(I3,A1,I3)') a,b
        write (1,'(A10,I4)') 'Soma: ', a+b
        write (1,'(A10,I4)') 'Diferencas: ', a-b
        Close (UNIT=1, STATUS='Keep')
      end
