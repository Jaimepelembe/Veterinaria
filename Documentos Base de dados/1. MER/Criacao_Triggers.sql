# criacao dos triggers
#Triggers do cliente
delimiter //
create trigger tgr_update_numero_cliente after insert on cliente
for each row
begin
update  veterinaria set num_clientes = num_clientes + 1
where veterinaria.idVeterinaria=new.idVeterinaria ;
end 

delimiter //

select*from cliente;
select*from animal;
select*from veterinaria;

show triggers;