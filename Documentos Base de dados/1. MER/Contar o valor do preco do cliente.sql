SELECT * FROM veterinaria.historico_cirurgia;

SELECT * FROM veterinaria.cirurgia;

SELECT * FROM veterinaria.cliente;
SELECT * FROM veterinaria.animal;

select historico_cirurgia.preco from historico_cirurgia,cliente,animal  where historico_cirurgia.idAnimal=animal.idAnimal and animal.idCliente=11;