-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema hw
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hw
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hw` DEFAULT CHARACTER SET utf8 ;
USE `hw` ;

-- -----------------------------------------------------
-- Table `hw`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hw`.`customer` ;

CREATE TABLE IF NOT EXISTS `hw`.`customer` (
  `userid` VARCHAR(30) NOT NULL,
  `username` VARCHAR(20) NOT NULL,
  `userpwd` VARCHAR(45) NOT NULL,
  `address` VARCHAR(50) NULL,
  `contact1` VARCHAR(30) NULL,
  `contact2` VARCHAR(30) NULL,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hw`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hw`.`product` ;

CREATE TABLE IF NOT EXISTS `hw`.`product` (
  `productid` VARCHAR(20) NOT NULL,
  `productname` VARCHAR(50) NOT NULL,
  `price` INT NULL,
  `quantity` INT NULL DEFAULT 0,
  PRIMARY KEY (`productid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hw`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hw`.`order` ;

CREATE TABLE IF NOT EXISTS `hw`.`order` (
  `orderno` INT NOT NULL AUTO_INCREMENT,
  `orderprice` INT NOT NULL,
  `puchased` TINYINT NULL DEFAULT 0,
  `delivery` TINYINT NULL DEFAULT 0,
  `productid` VARCHAR(20) NULL,
  `userid` VARCHAR(30) NULL,
  PRIMARY KEY (`orderno`),
  INDEX `product_userid_fk_idx` (`userid` ASC) VISIBLE,
  INDEX `order_productid_fk_idx` (`productid` ASC) VISIBLE,
  CONSTRAINT `order_userid_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `hw`.`customer` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `order_productid_fk`
    FOREIGN KEY (`productid`)
    REFERENCES `hw`.`product` (`productid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
