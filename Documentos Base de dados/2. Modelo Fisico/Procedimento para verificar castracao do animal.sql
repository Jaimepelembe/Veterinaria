SELECT * FROM veterinaria.historico_cirurgia;
SELECT * FROM veterinaria.historico_cirurgia where idcirurgia=1;
delimiter //
create procedure proc_verificaCastracao(idAni int ,  idCirur int, dat date,  preco float, obser varchar(60))
begin
if( idAni in(SELECT idAnimal FROM veterinaria.historico_cirurgia where idcirurgia=1)) then
select 'O animal ja foi castrado' as msg;
else
insert into historico_cirurgia (idAnimal,idCirurgia,data_realizacao,preco,observacao) values(idAni,idCirur,dat,preco,obser);
end if;
end;

delimiter //
call  proc_verificaCastracao(10,1,2020-10-27,800,'A');
