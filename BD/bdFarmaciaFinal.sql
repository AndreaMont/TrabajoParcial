-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema db_farmaceutico
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_farmaceutico
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_farmaceutico` DEFAULT CHARACTER SET utf8 ;
USE `db_farmaceutico` ;

-- -----------------------------------------------------
-- Table `db_farmaceutico`.`distrito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_farmaceutico`.`distrito` (
  `id_distrito` INT(11) NOT NULL AUTO_INCREMENT,
  `distrito` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_distrito`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_farmaceutico`.`farmacia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_farmaceutico`.`farmacia` (
  `id_farmacia` INT(11) NOT NULL AUTO_INCREMENT,
  `id_distrito` INT(11) NOT NULL,
  `ruc` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `telefono` INT(9) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_farmacia`),
  INDEX `fk_distrito_farmacia_idx` (`id_distrito` ASC),
  CONSTRAINT `fk_distrito_farmacia`
    FOREIGN KEY (`id_distrito`)
    REFERENCES `db_farmaceutico`.`distrito` (`id_distrito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_farmaceutico`.`tipomedicamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_farmaceutico`.`tipomedicamento` (
  `id_tipomedicamento` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tipomedicamento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_farmaceutico`.`medicamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_farmaceutico`.`medicamento` (
  `id_medicamento` INT(11) NOT NULL AUTO_INCREMENT,
  `id_tipomedicamento` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `f_creacion` DATE NOT NULL,
  `f_vencimiento` DATE NOT NULL,
  `composicion` VARCHAR(45) NOT NULL,
  `preciounitario` DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (`id_medicamento`),
  INDEX `fk_tipo_medicamento_idx` (`id_tipomedicamento` ASC),
  CONSTRAINT `fk_tipo_medicamento`
    FOREIGN KEY (`id_tipomedicamento`)
    REFERENCES `db_farmaceutico`.`tipomedicamento` (`id_tipomedicamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_farmaceutico`.`orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_farmaceutico`.`orden` (
  `id_orden` INT(11) NOT NULL AUTO_INCREMENT,
  `id_medicamento` INT(11) NOT NULL,
  `id_farmacia` INT(11) NOT NULL,
  `f_orden` DATE NOT NULL,
  `f_envio` DATE NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  `montototal` DECIMAL(8,2) NOT NULL,
  INDEX `farmacia_orden_idx` (`id_farmacia` ASC),
  PRIMARY KEY (`id_orden`),
  INDEX `fk_medicamento_orden_idx` (`id_medicamento` ASC),
  CONSTRAINT `fk_farmacia_orden`
    FOREIGN KEY (`id_farmacia`)
    REFERENCES `db_farmaceutico`.`farmacia` (`id_farmacia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_medicamento_orden`
    FOREIGN KEY (`id_medicamento`)
    REFERENCES `db_farmaceutico`.`medicamento` (`id_medicamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
