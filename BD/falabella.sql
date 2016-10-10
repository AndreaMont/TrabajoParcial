-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema seguros_falabella
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema seguros_falabella
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `seguros_falabella` DEFAULT CHARACTER SET utf8 ;
USE `seguros_falabella` ;

-- -----------------------------------------------------
-- Table `seguros_falabella`.`Inspector`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seguros_falabella`.`Inspector` (
  `idInspector` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `DNI` SMALLINT(8) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `Contrasenia` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idInspector`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `seguros_falabella`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seguros_falabella`.`Cliente` (
  `idCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `DNI` SMALLINT(8) NOT NULL,
  `Telefono` SMALLINT(9) NOT NULL,
  `FechaNaciminento` DATE NOT NULL,
  `Usuario` VARCHAR(45) NULL,
  `Contrasenia` VARCHAR(45) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `seguros_falabella`.`Vehiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seguros_falabella`.`Vehiculo` (
  `idVehiculo` INT(11) NOT NULL AUTO_INCREMENT,
  `Modelo` VARCHAR(45) NOT NULL,
  `Marca` VARCHAR(45) NOT NULL,
  `Placa` VARCHAR(45) NOT NULL,
  `TipoCaja` VARCHAR(45) NOT NULL,
  `Año` YEAR(4) NOT NULL,
  `Kilometraje` DECIMAL(8,2) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idVehiculo`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `seguros_falabella`.`Cotizacion_inicial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seguros_falabella`.`Cotizacion_inicial` (
  `idCotizacion` INT(11) NOT NULL AUTO_INCREMENT,
  `idVehiculo` INT(11) NOT NULL,
  `Cotizacion_Inicial` DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (`idCotizacion`),
  INDEX `Cotizacion_Inicial_vehiculo_idx` (`idVehiculo` ASC),
  CONSTRAINT `Cotizacion_Inicial_vehiculo`
    FOREIGN KEY (`idVehiculo`)
    REFERENCES `seguros_falabella`.`Vehiculo` (`idVehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `seguros_falabella`.`Cita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seguros_falabella`.`Cita` (
  `idCita` INT(11) NOT NULL AUTO_INCREMENT,
  `idCliente` INT(11) NOT NULL,
  `idInspector` INT(11) NOT NULL,
  `Fecha_cita` DATETIME NOT NULL,
  `Lugar_inspeccion` VARCHAR(300) NOT NULL,
  `id_cotizacion_incial` INT(11) NOT NULL,
  PRIMARY KEY (`idCita`),
  INDEX `cita_inspector_idx` (`idInspector` ASC),
  INDEX `cita_cliente_idx` (`idCliente` ASC),
  INDEX `cita_cotiza_idx` (`id_cotizacion_incial` ASC),
  CONSTRAINT `cita_inspector`
    FOREIGN KEY (`idInspector`)
    REFERENCES `seguros_falabella`.`Inspector` (`idInspector`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cita_cliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `seguros_falabella`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cita_cotiza`
    FOREIGN KEY (`id_cotizacion_incial`)
    REFERENCES `seguros_falabella`.`Cotizacion_inicial` (`idCotizacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '	';


-- -----------------------------------------------------
-- Table `seguros_falabella`.`Cotizacion_final`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seguros_falabella`.`Cotizacion_final` (
  `id_CotizacionFinal` INT(11) NOT NULL,
  `idcita` INT(11) NOT NULL,
  `FechaCotizacion` DATE NOT NULL,
  `F_Aprobado` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id_CotizacionFinal`),
  CONSTRAINT `cotizacionFinal_Cita`
    FOREIGN KEY (`idcita`)
    REFERENCES `seguros_falabella`.`Cita` (`idCita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `seguros_falabella`.`Poliza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seguros_falabella`.`Poliza` (
  `idPoliza` INT(11) NOT NULL AUTO_INCREMENT,
  `idCFinal` INT(11) NOT NULL,
  `Fecha_Envio` DATE NOT NULL,
  `Monto` DECIMAL(8,2) NOT NULL,
  `T_Documento` BLOB NOT NULL,
  PRIMARY KEY (`idPoliza`),
  INDEX `Poliza_cotizacionFinal_idx` (`idCFinal` ASC),
  CONSTRAINT `Poliza_cotizacionFinal`
    FOREIGN KEY (`idCFinal`)
    REFERENCES `seguros_falabella`.`Cotizacion_final` (`idcita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
