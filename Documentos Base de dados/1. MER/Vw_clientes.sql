SELECT * FROM veterinaria.vw_animaiscliente;
#Contar quantos animais um determinado cliente que vive em uma morada tem
select cliente.nome,cliente.telefone,cliente.morada, count(animal.idAnimal) as 'numero animais'from cliente join animal where cliente.idCliente=animal.idCliente group by cliente.idCliente;
#Terminado com sucesso
#Valor gasto por um animal em com cirurgia, exame e vacinacao
select animal.idAnimal,animal.idCliente, sum(historico_cirurgia.preco and historico_vacina.preco and historico_exame.preco) as 'Valor gasto'  from animal join historico_cirurgia join historico_exame join historico_vacina where animal.idAnimal=historico_cirurgia.idAnimal or animal.idAnimal=historico_exame.idAnimal or animal.idAnimal= historico_vacina.idAnimal group by animal.idAnimal;

# animal.idAnimal,animal.idCliente, sum(historico_cirurgia.preco and historico_vacina.preco and historico_exame.preco) 

select animal.idAnimal,animal.idCliente, sum(historico_cirurgia.preco) as 'Valor gasto'  from animal join historico_cirurgia where animal.idAnimal=historico_cirurgia.idAnimal  group by animal.idCliente;
