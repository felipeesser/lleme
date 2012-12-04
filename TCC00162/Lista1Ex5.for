       program Lista1Ex5
	     implicit none
		 real raio, diametro, circunferencia, area, pi
		 OPEN (UNIT=1, FILE= 'resultado5.txt')
		 
		 write (*, '(A20)') ' Digite o raio : '
		 read (*, '(F4.2)') raio
		 
		 write (1, '(A20,F)')
