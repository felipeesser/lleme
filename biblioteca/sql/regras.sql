create or replace
trigger Emprestimo_regra1 
before insert or update on CLIENTE 
REFERENCING OLD AS antigo NEW AS novo 
for each row
declare 
  CONTAGEM number(8,0);
  usuario number(10,0);
begin
  select USUARIO_ID into USUARIO 
  from "Operacao" O 
  where o.numero=:NOVO.numero;

  select COUNT(*) into CONTAGEM 
  from Operacao o inner join "Emprestimo" E on o.
  inner join "Operacao" o on e.operacao_numero=o.numero where o.usuario_id=:NOVO. ;
  if (CONTAGEM > 100) then
    RAISE_APPLICATION_ERROR(-20001,'ERRO');
  else
    insert into "CAR"("license","model","year") values (:NOVO."numero"*100,'modelo',2012);
  end if;
END