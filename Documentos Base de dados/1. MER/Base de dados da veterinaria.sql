-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 21-Out-2022 às 22:01
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `veterinaria`
--
CREATE DATABASE IF NOT EXISTS `veterinaria` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `veterinaria`;

DELIMITER $$
--
-- Procedimentos
--
DROP PROCEDURE IF EXISTS `proc_add_animal`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_add_animal` (`nom` VARCHAR(35), `esp` VARCHAR(7), `sexo` CHAR(1), `rac` VARCHAR(35), `pelo` VARCHAR(11), `peso` FLOAT, `dat` VARCHAR(10), `id_cli` INT, `id_vet` INT)   begin
if(nom!='' and esp!=''and rac!=''and peso>0.5 and dat>'' and id_cli in( select ID from cliente) and id_vet in(select idVeterinaria from veterinaria) and sexo!='')
then
insert into animal (nome,especie,sexo,raca,cor_pelo,peso,dt_nascimento,idCliente,idVeterinaria) values
(nom,esp,sexo,rac,pelo,peso,dat,id_cli,id_vet);
else select 'Ocorreu um erro ao adicionar o animal' as msg;
end if;
end$$

DROP PROCEDURE IF EXISTS `proc_add_cliente`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_add_cliente` (`nome` VARCHAR(35), `cell` VARCHAR(9), `casa` VARCHAR(35), `id_vet` INT)   begin
if( (nome!='') and(cell!='') and(casa!='') and(id_vet in (select idVeterinaria from veterinaria))) then
insert into cliente(nome,telefone,morada,idVeterinaria) values(nome,cell,casa,id_vet);
else
select 'Ocorreu um erro ao inserir o cliente' as msg;
end if;
end$$

DROP PROCEDURE IF EXISTS `proc_delete_animal`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_delete_animal` (`id` INT)   begin 
if(id in(select IdAnimal from animal)) then
delete from animal where idAnimal=id;
else 
select'Ococrreu um erro ao remover o animal ' as msg;
end if;
end$$

DROP PROCEDURE IF EXISTS `proc_delete_cliente`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_delete_cliente` (`id` INT)   begin
if(id in(select ID from cliente )) then
delete from cliente where ID=id;
else 
select'Ocorreu um erro ao remover o cliente' as msg;
end if;
end$$

DROP PROCEDURE IF EXISTS `proc_update_animal`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_update_animal` (`id` INT, `nom` VARCHAR(20), `especie` VARCHAR(6), `sexo` CHAR(1), `raca` VARCHAR(15), `pelo` VARCHAR(15), `peso` FLOAT, `dat` VARCHAR(10), `cli_id` INT, `vet_id` INT)   begin
if(id in (select idAnimal from animal) and nom!='' and especie!='' and raca!=''and pelo!='' and peso>0,dat!='' and cli_id in(select idCliente from cliente) and vet_id in(select idveterinaria from veterinaria))then
update animal set nome=nom,especie=especie,sexo=sexo,raca=raca,cor_pelo=pelo,peso=peso,dt_nascimento=dat,idCliente=cli_id,idVeterinaria=vet_id 
where idAnimal=id;
else select 'Ocorreu um erro ao actualizar os dados do animal' as msg;
end if;
end$$

DROP PROCEDURE IF EXISTS `proc_update_gasto_vet`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_update_gasto_vet` (`id` INT, `despesa` FLOAT)   begin
if(id in(select idVeterinaria from veterinaria) and despesa > 0) then
update veterinaria set gasto_material= gasto_material+ despesa
where idVeterinaria=id;
else
select 'O Correu um erro na actualizacao do gasto' as msg;
end if;
end$$

DROP PROCEDURE IF EXISTS `proc_update_lucro`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_update_lucro` (`id` INT, `lucro` FLOAT)   begin
if( id in(select idVeterinaria from veterinaria) and lucro>0) then
update veterinaria set lucro_total=lucro_total+lucro
where idVeterinaria=id;
else
select 'Ococreu um erro ao actualizar o lucro ' as msg;
end if;
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `animal`
--

DROP TABLE IF EXISTS `animal`;
CREATE TABLE `animal` (
  `idAnimal` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `especie` varchar(15) NOT NULL,
  `sexo` char(1) NOT NULL,
  `raca` varchar(15) NOT NULL,
  `cor_pelo` varchar(15) NOT NULL,
  `peso` float NOT NULL,
  `dt_nascimento` varchar(10) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idVeterinaria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELACIONAMENTOS PARA TABELAS `animal`:
--   `idCliente`
--       `cliente` -> `idCliente`
--   `idVeterinaria`
--       `veterinaria` -> `idVeterinaria`
--

--
-- Extraindo dados da tabela `animal`
--

INSERT INTO `animal` (`idAnimal`, `nome`, `especie`, `sexo`, `raca`, `cor_pelo`, `peso`, `dt_nascimento`, `idCliente`, `idVeterinaria`) VALUES
(9, 'Kira', 'Canina', 'F', 'Pastor', 'Castanho', 20, '10', 11, 1);

--
-- Acionadores `animal`
--
DROP TRIGGER IF EXISTS `tgr_update_delete_animal`;
DELIMITER $$
CREATE TRIGGER `tgr_update_delete_animal` AFTER INSERT ON `animal` FOR EACH ROW begin
update  veterinaria set num_animais = num_animais + 1
where veterinaria.idVeterinaria=new.idVeterinaria ;
end
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `tgr_update_diminui_num_animal`;
DELIMITER $$
CREATE TRIGGER `tgr_update_diminui_num_animal` AFTER DELETE ON `animal` FOR EACH ROW begin
update  veterinaria set num_animais = num_animais - 1
where veterinaria.idVeterinaria=old.idVeterinaria ;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cirurgia`
--

DROP TABLE IF EXISTS `cirurgia`;
CREATE TABLE `cirurgia` (
  `idCirurgia` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `idVeterinaria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELACIONAMENTOS PARA TABELAS `cirurgia`:
--   `idVeterinaria`
--       `veterinaria` -> `idVeterinaria`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nome` varchar(35) NOT NULL,
  `telefone` varchar(10) NOT NULL,
  `morada` varchar(35) NOT NULL,
  `idVeterinaria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELACIONAMENTOS PARA TABELAS `cliente`:
--   `idVeterinaria`
--       `veterinaria` -> `idVeterinaria`
--

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nome`, `telefone`, `morada`, `idVeterinaria`) VALUES
(11, 'CarlEx', '820074831', 'Matola', 1);

--
-- Acionadores `cliente`
--
DROP TRIGGER IF EXISTS `tgr_update_diminui_num_cliente`;
DELIMITER $$
CREATE TRIGGER `tgr_update_diminui_num_cliente` BEFORE DELETE ON `cliente` FOR EACH ROW begin
update  veterinaria set num_clientes = num_clientes - 1
where veterinaria.idVeterinaria=old.idVeterinaria ;
delete from animal where animal.idCliente=old.idCliente;
end
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `tgr_update_numero_cliente`;
DELIMITER $$
CREATE TRIGGER `tgr_update_numero_cliente` AFTER INSERT ON `cliente` FOR EACH ROW begin
update  veterinaria set num_clientes = num_clientes + 1
where veterinaria.idVeterinaria=new.idVeterinaria ;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `exame`
--

DROP TABLE IF EXISTS `exame`;
CREATE TABLE `exame` (
  `idExame` int(11) NOT NULL,
  `nome` varchar(35) NOT NULL,
  `idVeterinaria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELACIONAMENTOS PARA TABELAS `exame`:
--   `idVeterinaria`
--       `veterinaria` -> `idVeterinaria`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `historico_cirurgia`
--

DROP TABLE IF EXISTS `historico_cirurgia`;
CREATE TABLE `historico_cirurgia` (
  `idAnimal` int(11) NOT NULL,
  `idcirurgia` int(11) NOT NULL,
  `preco` float NOT NULL,
  `data_realizacao` varchar(10) NOT NULL,
  `observacao` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELACIONAMENTOS PARA TABELAS `historico_cirurgia`:
--   `idAnimal`
--       `animal` -> `idAnimal`
--   `idcirurgia`
--       `cirurgia` -> `idCirurgia`
--

--
-- Acionadores `historico_cirurgia`
--
DROP TRIGGER IF EXISTS `trg_aumentarGanho_update_cirurgia`;
DELIMITER $$
CREATE TRIGGER `trg_aumentarGanho_update_cirurgia` AFTER INSERT ON `historico_cirurgia` FOR EACH ROW begin
update vaterinaria set valor_ganho = valor_ganho + new.preco;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `historico_exame`
--

DROP TABLE IF EXISTS `historico_exame`;
CREATE TABLE `historico_exame` (
  `idAnimal` int(11) NOT NULL,
  `idExame` int(11) NOT NULL,
  `preco` float NOT NULL,
  `data_realizacao` varchar(10) NOT NULL,
  `resultado` varchar(45) NOT NULL,
  `observacao` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELACIONAMENTOS PARA TABELAS `historico_exame`:
--   `idAnimal`
--       `animal` -> `idAnimal`
--   `idExame`
--       `exame` -> `idExame`
--

--
-- Acionadores `historico_exame`
--
DROP TRIGGER IF EXISTS `trg_aumentarGanho_update_exame`;
DELIMITER $$
CREATE TRIGGER `trg_aumentarGanho_update_exame` AFTER INSERT ON `historico_exame` FOR EACH ROW begin
update vaterinaria set valor_ganho = valor_ganho + new.preco;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `historico_vacina`
--

DROP TABLE IF EXISTS `historico_vacina`;
CREATE TABLE `historico_vacina` (
  `idAnimal` int(11) NOT NULL,
  `idVacina` int(11) NOT NULL,
  `preco` float NOT NULL,
  `data_realizacao` varchar(10) NOT NULL,
  `observacao` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELACIONAMENTOS PARA TABELAS `historico_vacina`:
--   `idAnimal`
--       `animal` -> `idAnimal`
--   `idVacina`
--       `vacina` -> `idVacina`
--

--
-- Extraindo dados da tabela `historico_vacina`
--

INSERT INTO `historico_vacina` (`idAnimal`, `idVacina`, `preco`, `data_realizacao`, `observacao`) VALUES
(9, 1, 500, '10', 'Saudavel'),
(9, 2, 600, '12-12-2019', 'Saudavel');

--
-- Acionadores `historico_vacina`
--
DROP TRIGGER IF EXISTS `tgr_update_diminui_num_vacinas`;
DELIMITER $$
CREATE TRIGGER `tgr_update_diminui_num_vacinas` AFTER INSERT ON `historico_vacina` FOR EACH ROW begin
update  veterinaria set num_vacinas = num_vacinas - 1;
update veterinaria set valor_ganho= valor_ganho + new.preco;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `vacina`
--

DROP TABLE IF EXISTS `vacina`;
CREATE TABLE `vacina` (
  `idVacina` int(11) NOT NULL,
  `marca` varchar(25) NOT NULL,
  `nome` varchar(25) NOT NULL,
  `quantidade(ml)` float NOT NULL,
  `preco` float NOT NULL,
  `data_validade` varchar(10) NOT NULL,
  `idVeterinaria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELACIONAMENTOS PARA TABELAS `vacina`:
--   `idVeterinaria`
--       `veterinaria` -> `idVeterinaria`
--

--
-- Extraindo dados da tabela `vacina`
--

INSERT INTO `vacina` (`idVacina`, `marca`, `nome`, `quantidade(ml)`, `preco`, `data_validade`, `idVeterinaria`) VALUES
(1, 'Zoetis', 'Raiva', 0, 100, '10', 1),
(2, 'Zoe', 'Pulga', 0.5, 120, '10-10-2020', 1);

--
-- Acionadores `vacina`
--
DROP TRIGGER IF EXISTS `tgr_update_aumenta_num_vacinas`;
DELIMITER $$
CREATE TRIGGER `tgr_update_aumenta_num_vacinas` AFTER INSERT ON `vacina` FOR EACH ROW begin
update  veterinaria set num_vacinas = num_vacinas + 1
where veterinaria.idVeterinaria=new.idVeterinaria ;
update veterinaria set investimento_material= investimento_material+ new.preco
where veterinaria.idVeterinaria=new.idVeterinaria;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `veterinaria`
--

DROP TABLE IF EXISTS `veterinaria`;
CREATE TABLE `veterinaria` (
  `idVeterinaria` int(11) NOT NULL,
  `nome` varchar(35) NOT NULL,
  `localizacao` varchar(35) NOT NULL,
  `investimento_material` float NOT NULL,
  `valor_ganho` float NOT NULL,
  `lucro` float NOT NULL,
  `num_clientes` int(11) NOT NULL,
  `num_animais` int(11) NOT NULL,
  `num_vacinas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELACIONAMENTOS PARA TABELAS `veterinaria`:
--

--
-- Extraindo dados da tabela `veterinaria`
--

INSERT INTO `veterinaria` (`idVeterinaria`, `nome`, `localizacao`, `investimento_material`, `valor_ganho`, `lucro`, `num_clientes`, `num_animais`, `num_vacinas`) VALUES
(1, 'Faculdade de Veterinaria', 'Junta de Maputo', 1000, 0, 0, 1, 1, 0);

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `vw_donos_animais_mais_3_cirurgia`
-- (Veja abaixo para a view atual)
--
DROP VIEW IF EXISTS `vw_donos_animais_mais_3_cirurgia`;
CREATE TABLE `vw_donos_animais_mais_3_cirurgia` (
`nome` varchar(35)
,`telefone` varchar(10)
,`morada` varchar(35)
);

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `vw_ganho_vacinas`
-- (Veja abaixo para a view atual)
--
DROP VIEW IF EXISTS `vw_ganho_vacinas`;
CREATE TABLE `vw_ganho_vacinas` (
`Valor ganho com vacinacao` double
);

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `vw_mostarar_animais_fizeram_cirurgia`
-- (Veja abaixo para a view atual)
--
DROP VIEW IF EXISTS `vw_mostarar_animais_fizeram_cirurgia`;
CREATE TABLE `vw_mostarar_animais_fizeram_cirurgia` (
`nome` varchar(20)
,`especie` varchar(15)
,`sexo` char(1)
,`raca` varchar(15)
,`preco` float
,`data_realizacao` varchar(10)
);

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `vw_mostrar_animais_sexo`
-- (Veja abaixo para a view atual)
--
DROP VIEW IF EXISTS `vw_mostrar_animais_sexo`;
CREATE TABLE `vw_mostrar_animais_sexo` (
`sexo` char(1)
,`count(idAnimal)` bigint(21)
);

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `vw_nome_animal`
-- (Veja abaixo para a view atual)
--
DROP VIEW IF EXISTS `vw_nome_animal`;
CREATE TABLE `vw_nome_animal` (
`nome` varchar(35)
,`telefone` varchar(10)
,`morada` varchar(35)
);

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `vw_nome_todos_animais`
-- (Veja abaixo para a view atual)
--
DROP VIEW IF EXISTS `vw_nome_todos_animais`;
CREATE TABLE `vw_nome_todos_animais` (
`nome` varchar(20)
);

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `vw_ordenar_animais_especie`
-- (Veja abaixo para a view atual)
--
DROP VIEW IF EXISTS `vw_ordenar_animais_especie`;
CREATE TABLE `vw_ordenar_animais_especie` (
`nome` varchar(20)
,`especie` varchar(15)
,`Sexo` char(1)
,`raca` varchar(15)
,`cor_pelo` varchar(15)
,`peso` float
,`dt_nascimento` varchar(10)
);

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `vw_valor_ganho_cirurgia`
-- (Veja abaixo para a view atual)
--
DROP VIEW IF EXISTS `vw_valor_ganho_cirurgia`;
CREATE TABLE `vw_valor_ganho_cirurgia` (
`Valor ganho com cirurgia` double
);

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `vw_valor_ganho_exames`
-- (Veja abaixo para a view atual)
--
DROP VIEW IF EXISTS `vw_valor_ganho_exames`;
CREATE TABLE `vw_valor_ganho_exames` (
`Valor ganho com exames` double
);

-- --------------------------------------------------------

--
-- Estrutura da view `vw_donos_animais_mais_3_cirurgia` exportado como tabela
--
DROP TABLE IF EXISTS `vw_donos_animais_mais_3_cirurgia`;
CREATE TABLE`vw_donos_animais_mais_3_cirurgia`(
    `nome` varchar(35) COLLATE utf8_general_ci NOT NULL,
    `telefone` varchar(10) COLLATE utf8_general_ci NOT NULL,
    `morada` varchar(35) COLLATE utf8_general_ci NOT NULL
);

-- --------------------------------------------------------

--
-- Estrutura da view `vw_ganho_vacinas` exportado como tabela
--
DROP TABLE IF EXISTS `vw_ganho_vacinas`;
CREATE TABLE`vw_ganho_vacinas`(
    `Valor ganho com vacinacao` double DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Estrutura da view `vw_mostarar_animais_fizeram_cirurgia` exportado como tabela
--
DROP TABLE IF EXISTS `vw_mostarar_animais_fizeram_cirurgia`;
CREATE TABLE`vw_mostarar_animais_fizeram_cirurgia`(
    `nome` varchar(20) COLLATE utf8_general_ci NOT NULL,
    `especie` varchar(15) COLLATE utf8_general_ci NOT NULL,
    `sexo` char(1) COLLATE utf8_general_ci NOT NULL,
    `raca` varchar(15) COLLATE utf8_general_ci NOT NULL,
    `preco` float NOT NULL,
    `data_realizacao` varchar(10) COLLATE utf8_general_ci NOT NULL
);

-- --------------------------------------------------------

--
-- Estrutura da view `vw_mostrar_animais_sexo` exportado como tabela
--
DROP TABLE IF EXISTS `vw_mostrar_animais_sexo`;
CREATE TABLE`vw_mostrar_animais_sexo`(
    `sexo` char(1) COLLATE utf8_general_ci NOT NULL,
    `count(idAnimal)` bigint(21) NOT NULL DEFAULT '0'
);

-- --------------------------------------------------------

--
-- Estrutura da view `vw_nome_animal` exportado como tabela
--
DROP TABLE IF EXISTS `vw_nome_animal`;
CREATE TABLE`vw_nome_animal`(
    `nome` varchar(35) COLLATE utf8_general_ci NOT NULL,
    `telefone` varchar(10) COLLATE utf8_general_ci NOT NULL,
    `morada` varchar(35) COLLATE utf8_general_ci NOT NULL
);

-- --------------------------------------------------------

--
-- Estrutura da view `vw_nome_todos_animais` exportado como tabela
--
DROP TABLE IF EXISTS `vw_nome_todos_animais`;
CREATE TABLE`vw_nome_todos_animais`(
    `nome` varchar(20) COLLATE utf8_general_ci NOT NULL
);

-- --------------------------------------------------------

--
-- Estrutura da view `vw_ordenar_animais_especie` exportado como tabela
--
DROP TABLE IF EXISTS `vw_ordenar_animais_especie`;
CREATE TABLE`vw_ordenar_animais_especie`(
    `nome` varchar(20) COLLATE utf8_general_ci NOT NULL,
    `especie` varchar(15) COLLATE utf8_general_ci NOT NULL,
    `Sexo` char(1) COLLATE utf8_general_ci NOT NULL,
    `raca` varchar(15) COLLATE utf8_general_ci NOT NULL,
    `cor_pelo` varchar(15) COLLATE utf8_general_ci NOT NULL,
    `peso` float NOT NULL,
    `dt_nascimento` varchar(10) COLLATE utf8_general_ci NOT NULL
);

-- --------------------------------------------------------

--
-- Estrutura da view `vw_valor_ganho_cirurgia` exportado como tabela
--
DROP TABLE IF EXISTS `vw_valor_ganho_cirurgia`;
CREATE TABLE`vw_valor_ganho_cirurgia`(
    `Valor ganho com cirurgia` double DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Estrutura da view `vw_valor_ganho_exames` exportado como tabela
--
DROP TABLE IF EXISTS `vw_valor_ganho_exames`;
CREATE TABLE`vw_valor_ganho_exames`(
    `Valor ganho com exames` double DEFAULT NULL
);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`idAnimal`),
  ADD KEY `idCliente` (`idCliente`),
  ADD KEY `idVeterinaria` (`idVeterinaria`);

--
-- Índices para tabela `cirurgia`
--
ALTER TABLE `cirurgia`
  ADD PRIMARY KEY (`idCirurgia`),
  ADD KEY `cirurgia_ibfk_1` (`idVeterinaria`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`),
  ADD KEY `idVeterinaria` (`idVeterinaria`);

--
-- Índices para tabela `exame`
--
ALTER TABLE `exame`
  ADD PRIMARY KEY (`idExame`),
  ADD KEY `idVeterinaria` (`idVeterinaria`);

--
-- Índices para tabela `historico_cirurgia`
--
ALTER TABLE `historico_cirurgia`
  ADD PRIMARY KEY (`idAnimal`,`idcirurgia`),
  ADD KEY `idcirurgia` (`idcirurgia`);

--
-- Índices para tabela `historico_exame`
--
ALTER TABLE `historico_exame`
  ADD PRIMARY KEY (`idAnimal`,`idExame`),
  ADD KEY `idExame` (`idExame`);

--
-- Índices para tabela `historico_vacina`
--
ALTER TABLE `historico_vacina`
  ADD PRIMARY KEY (`idAnimal`,`idVacina`),
  ADD KEY `idVacina` (`idVacina`);

--
-- Índices para tabela `vacina`
--
ALTER TABLE `vacina`
  ADD PRIMARY KEY (`idVacina`),
  ADD KEY `vacina_ibfk_1` (`idVeterinaria`);

--
-- Índices para tabela `veterinaria`
--
ALTER TABLE `veterinaria`
  ADD PRIMARY KEY (`idVeterinaria`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `animal`
--
ALTER TABLE `animal`
  MODIFY `idAnimal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `cirurgia`
--
ALTER TABLE `cirurgia`
  MODIFY `idCirurgia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de tabela `exame`
--
ALTER TABLE `exame`
  MODIFY `idExame` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `vacina`
--
ALTER TABLE `vacina`
  MODIFY `idVacina` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `veterinaria`
--
ALTER TABLE `veterinaria`
  MODIFY `idVeterinaria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `animal`
--
ALTER TABLE `animal`
  ADD CONSTRAINT `animal_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `animal_ibfk_2` FOREIGN KEY (`idVeterinaria`) REFERENCES `veterinaria` (`idVeterinaria`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `cirurgia`
--
ALTER TABLE `cirurgia`
  ADD CONSTRAINT `cirurgia_ibfk_1` FOREIGN KEY (`idVeterinaria`) REFERENCES `veterinaria` (`idVeterinaria`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`idVeterinaria`) REFERENCES `veterinaria` (`idVeterinaria`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `exame`
--
ALTER TABLE `exame`
  ADD CONSTRAINT `exame_ibfk_1` FOREIGN KEY (`idVeterinaria`) REFERENCES `veterinaria` (`idVeterinaria`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `historico_cirurgia`
--
ALTER TABLE `historico_cirurgia`
  ADD CONSTRAINT `historico_cirurgia_ibfk_1` FOREIGN KEY (`idAnimal`) REFERENCES `animal` (`idAnimal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `historico_cirurgia_ibfk_2` FOREIGN KEY (`idcirurgia`) REFERENCES `cirurgia` (`idCirurgia`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `historico_exame`
--
ALTER TABLE `historico_exame`
  ADD CONSTRAINT `historico_exame_ibfk_1` FOREIGN KEY (`idAnimal`) REFERENCES `animal` (`idAnimal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `historico_exame_ibfk_2` FOREIGN KEY (`idExame`) REFERENCES `exame` (`idExame`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `historico_vacina`
--
ALTER TABLE `historico_vacina`
  ADD CONSTRAINT `historico_vacina_ibfk_1` FOREIGN KEY (`idAnimal`) REFERENCES `animal` (`idAnimal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `historico_vacina_ibfk_2` FOREIGN KEY (`idVacina`) REFERENCES `vacina` (`idVacina`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `vacina`
--
ALTER TABLE `vacina`
  ADD CONSTRAINT `vacina_ibfk_1` FOREIGN KEY (`idVeterinaria`) REFERENCES `veterinaria` (`idVeterinaria`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
