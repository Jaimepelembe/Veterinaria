#criacao da BD
CREATE SCHEMA IF NOT EXISTS `Veterinaria` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

#Criacao da tabela funcionario
CREATE TABLE IF NOT EXISTS `Funcionario` (
  `idFuncionario` INT NOT NULL auto_increment,
  `nome` VARCHAR(35) NOT NULL,
  `telefone` VARCHAR(12) NOT NULL,
  `morada` VARCHAR(35) NOT NULL,
  `salario` FLOAT NOT NULL,
  PRIMARY KEY (`idFuncionario`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS Veterinaria (
  idVeterinaria INT NOT NULL auto_increment,
  nome VARCHAR(35) NOT NULL,
  localizacao VARCHAR(35) NOT NULL,
  nome_proprietario VARCHAR(35) NOT NULL,
  numero_funcionarios INT NOT NULL,
  gasto_material FLOAT NOT NULL,
  lucro_total FLOAT NOT NULL,
  numero_vacinas INT NOT NULL,
  numero_brinquedos INT NOT NULL,
  quantidade_alimentos INT NOT NULL,
  Funcionario_idFuncionario INT NOT NULL,
  PRIMARY KEY (idVeterinaria),
    FOREIGN KEY (Funcionario_idFuncionario)
    REFERENCES Funcionario (idFuncionario))
ENGINE = InnoDB;


#Cliente
CREATE TABLE IF NOT EXISTS Cliente (
  ID INT NOT NULL  auto_increment,
  nome VARCHAR(35) NOT NULL,
  telefone VARCHAR(10) NOT NULL,
  `morada` VARCHAR(35) NOT NULL,
  `numero animais` INT NOT NULL,
  `Veterinaria_idVeterinaria` INT NOT NULL,
  PRIMARY KEY (`ID`),
    FOREIGN KEY (`Veterinaria_idVeterinaria`)
    REFERENCES Veterinaria (`idVeterinaria`)
  )
ENGINE = InnoDB;

#Animal
CREATE TABLE IF NOT EXISTS `Animal` (
  `idAnimal` INT NOT NULL auto_increment,
  `Especie` VARCHAR(15) NOT NULL,
  `nome` VARCHAR(20) NOT NULL,
  `dt_nascimento` VARCHAR(8) NOT NULL,
  `raca` VARCHAR(15) NOT NULL,
  `cor_pelo` VARCHAR(15) NOT NULL,
  `peso` FLOAT NOT NULL,
  `Cliente_ID` INT NOT NULL,
  `Veterinaria_idVeterinaria` INT NOT NULL,
     
  PRIMARY KEY (`idAnimal`),
   FOREIGN KEY (`Cliente_ID`)
    REFERENCES `Cliente` (`ID`),
FOREIGN KEY (`Veterinaria_idVeterinaria`)
    REFERENCES `Veterinaria` (`idVeterinaria`))
ENGINE = InnoDB;

#Alimentos
CREATE TABLE IF NOT EXISTS `Alimentos` (
  `idAlimentos` INT NOT NULL auto_increment,
  `tipo_alimento` VARCHAR(35) NOT NULL,
  `nome` VARCHAR(35) NOT NULL,
  `data_validade` VARCHAR(10) NOT NULL,
  `peso` DECIMAL NOT NULL,
  `preco` DECIMAL NOT NULL,
  `data_compra` VARCHAR(8) NOT NULL,
  `Cliente_ID` INT NOT NULL,
  PRIMARY KEY (`idAlimentos`),
    FOREIGN KEY (`Cliente_ID`)
    REFERENCES `Cliente` (`ID`))
ENGINE = InnoDB;

#Brinquedos
CREATE TABLE IF NOT EXISTS `Brinquedos` (
  `idBrinquedos` INT NOT NULL auto_increment,
  `nome` VARCHAR(25) NOT NULL,
  `tipo_material` VARCHAR(15) NOT NULL,
  `cor` VARCHAR(15) NOT NULL,
  `preco` DECIMAL NOT NULL,
  `data_compra` VARCHAR(8) NOT NULL,
  `Cliente_ID` INT NOT NULL,
  PRIMARY KEY (`idBrinquedos`),
    FOREIGN KEY (`Cliente_ID`)
    REFERENCES `Cliente` (`ID`))
ENGINE = InnoDB;

#Vacina
CREATE TABLE IF NOT EXISTS `Vacina` (
  `idVacina` INT NOT NULL auto_increment,
  `marca` VARCHAR(25) NOT NULL,
  `nome` VARCHAR(25) NOT NULL,
  `quantidade(ml)` FLOAT NOT NULL,
  `preco` FLOAT NOT NULL,
  `temperatura` FLOAT NOT NULL,
  `data_validade` VARCHAR(8) NOT NULL,
  `data_vacinacao` VARCHAR(8) NULL,
  `Animal_idAnimal` INT NOT NULL,
  `Funcionario_idFuncionario` INT NOT NULL,
  PRIMARY KEY (`idVacina`),
    FOREIGN KEY (`Animal_idAnimal`)
    REFERENCES `Animal` (`idAnimal`),
    FOREIGN KEY (`Funcionario_idFuncionario`)
    REFERENCES `Funcionario` (`idFuncionario`))
ENGINE = InnoDB;

#Exame
CREATE TABLE IF NOT EXISTS `Exame` (
  `idExame` INT NOT NULL auto_increment,
  `nome` VARCHAR(35) NOT NULL,
  `preco` FLOAT NOT NULL,
  `data_realizacao` VARCHAR(8) NULL,
  `Animal_idAnimal` INT NOT NULL,
  `Funcionario_idFuncionario` INT NOT NULL,
  PRIMARY KEY (`idExame`),
 FOREIGN KEY (`Animal_idAnimal`)
    REFERENCES `Animal` (`idAnimal`),
    FOREIGN KEY (`Funcionario_idFuncionario`)
    REFERENCES `Funcionario` (`idFuncionario`))
ENGINE = InnoDB;

#Cirurgia
CREATE TABLE IF NOT EXISTS `cirurgia` (
  `idcirurgia` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `Nome_Veterinario` VARCHAR(35) NOT NULL,
  `preco` FLOAT NOT NULL,
  `data_realizacao` VARCHAR(8) NULL,
  `Animal_idAnimal` INT NOT NULL,
  `Funcionario_idFuncionario` INT NOT NULL,
  PRIMARY KEY (`idcirurgia`),
FOREIGN KEY (`Animal_idAnimal`)
    REFERENCES `Animal` (`idAnimal`),
    FOREIGN KEY (`Funcionario_idFuncionario`)
    REFERENCES `Funcionario` (`idFuncionario`))
ENGINE = InnoDB;

#Funcionario que atende um  determinado cliente
CREATE TABLE IF NOT EXISTS `func_atende_cliente` (
  `id` INT NOT NULL,
  `data` VARCHAR(8) NOT NULL,
  `Cliente_ID` INT NOT NULL,
  `Funcionario_idFuncionario` INT NOT NULL,
  PRIMARY KEY (`id`),
    FOREIGN KEY (`Cliente_ID`)
    REFERENCES `Cliente` (`ID`),
    FOREIGN KEY (`Funcionario_idFuncionario`)
    REFERENCES `Funcionario` (`idFuncionario`))
ENGINE = InnoDB;

#Funcionario que atende um animal
CREATE TABLE IF NOT EXISTS `func_atende_animal` (
  `id` INT NOT NULL,
  `data` VARCHAR(8) NOT NULL,
  `Funcionario_idFuncionario` INT NOT NULL,
  `Animal_idAnimal` INT NOT NULL,
  PRIMARY KEY (`id`),
    FOREIGN KEY (`Funcionario_idFuncionario`)
    REFERENCES `Funcionario` (`idFuncionario`),
    FOREIGN KEY (`Animal_idAnimal`)
    REFERENCES `Animal` (`idAnimal`))
ENGINE = InnoDB;