SELECT * FROM veterinaria.vw_animaiscliente;
#Contar quantos animais um determinado cliente que vive em uma morada tem
select cliente.nome,cliente.telefone,cliente.morada, count(animal.idAnimal) as 'numero animais'from cliente join animal where cliente.idCliente=animal.idCliente and morada='Matola' group by cliente.idCliente;
#Terminado com sucesso


#soma de todo valor gasto com cirurgia e exame
 select animal.idAnimal,animal.idCliente, sum(historico_cirurgia.preco ) as 'Valor gasto'  from animal join historico_cirurgia  where animal.idAnimal=historico_cirurgia.idAnimal   group by animal.idCliente;

create view vw_valorClienteCirurgia as  select animal.idAnimal,animal.idCliente, sum(historico_cirurgia.preco ) as 'Valor gasto'  from animal join historico_cirurgia  where animal.idAnimal=historico_cirurgia.idAnimal   group by animal.idCliente;

select*from vw_valorClienteCirurgia ;


#soma de todo valor gasto com exame
 select animal.idAnimal,animal.idCliente, sum(historico_exame.preco ) as 'Valor gasto'  from animal join historico_exame  where animal.idAnimal=historico_exame.idAnimal   group by animal.idCliente;
create view vw_valorClienteExame as  select animal.idAnimal,animal.idCliente, sum(historico_exame.preco ) as 'Valor gasto'  from animal join historico_exame  where animal.idAnimal=historico_exame.idAnimal   group by animal.idCliente;


#soma de todo valor gasto com vacina
 select animal.idAnimal,animal.idCliente, sum(historico_vacina.preco ) as 'Valor gasto'  from animal join historico_vacina  where animal.idAnimal=historico_vacina.idAnimal   group by animal.idCliente;
create view vw_valorClienteVacina as  select animal.idAnimal,animal.idCliente, sum(historico_vacina.preco ) as 'Valor gasto'  from animal join historico_vacina  where animal.idAnimal=historico_vacina.idAnimal   group by animal.idCliente;

#criar view para visualizar o preco de todas operacoes
create view vw_valorClienteTotal as select *from vw_valorClienteCirurgia join vw_valorClienteExame join vw_valorClienteVacina where vw_valorClienteCirurgia.idCliente=