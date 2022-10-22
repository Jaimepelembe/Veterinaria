#adicionar um cliente
delimiter //
create trigger tgr_update_numero_cliente after insert on cliente
for each row
begin
update  veterinaria set num_clientes = num_clientes + 1
where veterinaria.idVeterinaria=new.idVeterinaria ;
end 



#diminuir numero clientes vet
delimiter //
create trigger tgr_update_diminui_num_cliente before delete on cliente
for each row
begin
update  veterinaria set num_clientes = num_clientes - 1
where veterinaria.idVeterinaria=old.idVeterinaria ;
delete from animal where animal.idCliente=old.idCliente;
end ;

show triggers;



#Remover o animal depois de deletar ocliente
delimiter //
create trigger tgr_update_diminui_num_cliente after delete on cliente
for each row
begin
update  veterinaria set num_clientes = num_clientes - 1
where veterinaria.idVeterinaria=old.idVeterinaria ;
end ;

#Animal
#Aumentar numero
delimiter //
create trigger tgr_update_delete_animal after insert on animal
for each row
begin
update  veterinaria set num_animais = num_animais + 1
where veterinaria.idVeterinaria=new.idVeterinaria ;
end ;

#Diminuir numero animais da vet
delimiter //
create trigger tgr_update_diminui_num_animal after delete on animal
for each row
begin
update  veterinaria set num_animais = num_animais - 1
where veterinaria.idVeterinaria=old.idVeterinaria ;
end ;


# Triggers para vacina
# Adicionar uma vacina o numero de vac aumenta
delimiter //
create trigger tgr_update_aumenta_num_vacinas after insert on vacina
for each row
begin
update  veterinaria set num_vacinas = num_vacinas + 1
where veterinaria.idVeterinaria=new.idVeterinaria ;
update veterinaria set investimento_material= investimento_material+ new.preco
where veterinaria.idVeterinaria=new.idVeterinaria;
end ;

#diminuir numero de vacinas ao vacinar o animal
delimiter //
create trigger tgr_update_diminui_num_vacinas after insert on historico_vacina
for each row
begin
update  veterinaria set num_vacinas = num_vacinas - 1;
update veterinaria set valor_ganho= valor_ganho + new.preco;
end ;

# Ao criar um exame
#o ganho da veterinária deve aumentar
delimiter //
create trigger trg_aumentarGanho_update_exame after insert on historico_exame
for each row 
begin
update vaterinaria set valor_ganho = valor_ganho + new.preco;
end;

#Ao fazer uma cirurgia a um animal 
#aumentar o ganho da veterinária;
delimiter //
create trigger trg_aumentarGanho_update_cirurgia after insert on historico_cirurgia
for each row 
begin
update vaterinaria set valor_ganho = valor_ganho + new.preco;
end;




show triggers;
show triggers;
