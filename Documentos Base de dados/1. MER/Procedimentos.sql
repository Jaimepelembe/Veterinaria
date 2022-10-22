select*from animal;
select*from veterinaria;
select* from cliente;

#Procedimento para actualizar dados da vterinaria
delimiter //
create procedure proc_update_gasto_vet( id int, gasto float)
begin
update veterinaria set gasto_material=gasto
where idVeterinaria=id;
end;
delimiter //
show procedure status;
call proc_update_gasto_vet(1,1000);

select*from veterinaria;

#Procedimento para actualizar o lucro da veterinaria
delimiter //
create procedure proc_update_lucro(id int, lucro float)
begin
if( id in(select idVeterinaria from veterinaria) and lucro>0) then
update veterinaria set lucro_total=lucro_total+lucro
where idVeterinaria=id;
else
select 'Ococreu um erro ao actualizar o lucro' as msg;
end if;
end//
delimiter;

call proc_update_lucro(1,100);
select*from veterinaria;


#Procedimento para adicionar um cliente
delimiter //
create procedure proc_add_cliente( nome varchar(35),cell varchar(9),casa varchar(35), id_vet int)
begin
if( (nome!='') and(cell!='') and(casa!='') and(id_vet in (select idVeterinaria from veterinaria))) then
insert into cliente(nome,telefone,morada,Veterinaria_idVeterinaria) values(nome,cell,casa,id_vet);
else
select 'Ocorreu um erro ao inserrir o cliente' as msg;
end if;
end;//
delimiter ;

call proc_add_cliente('Nyusi','844555432','Cidade da Matola',1);
select*from cliente;

#procedimento para deletar o cliente
delimiter //
create procedure proc_delete_cliente(id int)
begin
if(id in(select ID from cliente )) then
delete from cliente where ID=id;
else 
select'Ocorreu um erro ao remover o cliente' as msg;
end if;
end;//

call proc_delete_cliente(1);
select*from cliente;

#Procedimento para actualizar os dados  do cliente
delimiter //
create procedure proc_update_cliente( id int,nam varchar(35),cell varchar(9),casa varchar(35), id_vet int)
begin
if( id in(select*from cliente) and (nam!='') and(cell!='') and(casa!='') and(id_vet in (select idVeterinaria from veterinaria))) then
update cliente set nome=nam, telefone=cell,morada=casa,Veterinaria_idVeterinaria=id_vet 
where ID= id;
else 
select'Ocorreu um erro ao acualizar os dados do cleinte' as msg;
end if;
end//

delimiter ;
call proc_update_cliente(1,'Paulo Coelho','847777777','Namaacha',1);

call proc_update_cliente(1,'Paulo Coelho','84666667','Namaacha',1);
select*from cliente;


#Procedimentos do animal
#procedimento para adicionar o animal
delimiter //
create procedure proc_add_animal(nom varchar(35),esp varchar(7), rac varchar(35), pelo varchar(11), peso float, dat varchar(8), id_cli int,id_vet int)
begin
if(nom!='' and esp!=''and rac!=''and peso>0.5 and dat>'' and id_cli in( select ID from cliente) and id_vet in(select idVeterinaria from veterinaria))
then
insert into animal (nome,especie,raca,cor_pelo,peso,dt_nascimento,Cliente_ID,Veterinaria_idVeterinaria) values
(nom,esp,rac,pelo,peso,dat,id_cli,id_vet);
else select 'Ocorreu um erro ao adicionar o animal' as msg;
end if;
end//

call proc_add_animal('Bob','Canina','Pastor Belga','Branco',25,'10-12-2022',5,1);
select*from animal;
select*from cliente;

#procedimento para remover um animal
delimiter //
create procedure proc_delete_animal(id int)
begin 
if(id in(select IdAnimal from animal)) then
delete from animal where idAnimal=id;
else 
select'Ococrreu um erro ao remover o animal' as msg;
end if;
end;//
select*from animal;
call proc_delete_animal(2);
#procedimento para actualizar os dados do animal
delimiter //
create procedure proc_update_animal( id int,nom varchar(20),especie varchar(6), raca varchar(15), pelo varchar(15), peso float, dat varchar(10),cli_id int,vet_id int)
begin
if(id in (select idAnimal from animal) and nom!='' and especie!='' and raca!=''and pelo!='' and peso>0,dat!='' and cli_id in(select ID from cliente) and vet_id in(select idveterinaria from veterinaria))then
update animal set nome=nom,especie=especie,raca=raca,cor_pelo=pelo,peso=peso,st_nascimento=dat,ID=cli_id,idVeterinaria=vet_id 
where idAnimal=id;
else select 'Ocorreu um erro ao actualizar os dados do animal' as msg;
end if;
end;//

select*from animal;
call proc_update_animal(3,'Kira','Canino','Chiuaua','Preto',10,'21-09-2021',4,1);


