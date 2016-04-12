-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ergodb
-- -----------------------------------------------------
DROP DATABASE IF EXISTS `ergodb` ;

-- -----------------------------------------------------
-- Schema ergodb
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS `ergodb` DEFAULT CHARACTER SET latin1 ;
USE `ergodb` ;

-- -----------------------------------------------------
-- Table `ergodb`.`admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`admin` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`admin` (
  `adminId` INT(45) NOT NULL AUTO_INCREMENT,
  `proactive` VARCHAR(20) NULL DEFAULT NULL,
  `reactive` VARCHAR(20) NULL DEFAULT NULL,
  `assessor` VARCHAR(20) NULL DEFAULT NULL,
  `manager` VARCHAR(20) NULL DEFAULT NULL,
  `businessUnit` VARCHAR(20) NULL DEFAULT NULL,
  `workspace` VARCHAR(20) NULL DEFAULT NULL,
  `jobTitle` VARCHAR(20) NULL DEFAULT NULL,
  `gender` VARCHAR(6) NULL DEFAULT NULL,
  `heightInFeet` INT(11) NULL DEFAULT NULL,
  `heightInInches` INT(11) NULL DEFAULT NULL,
  `handedness` VARCHAR(5) NULL DEFAULT NULL,
  `daysPerWeek` INT(11) NULL DEFAULT NULL,
  `hoursPerDay` INT(11) NULL DEFAULT NULL,
  `hoursVDT` INT(11) NULL DEFAULT NULL,
  `hoursOnPhone` INT(11) NULL DEFAULT NULL,
  `discomfortPresent` VARCHAR(20) NULL DEFAULT NULL,
  `discomfortReported` VARCHAR(20) NULL DEFAULT NULL,
  `treatmentSought` VARCHAR(20) NULL DEFAULT NULL,
  `maxDiscomfort` INT(1) NULL DEFAULT NULL,
  `workFit` INT(1) NULL DEFAULT NULL,
  `risks` VARCHAR(200) NULL DEFAULT NULL,
  `equipmentRecommendations` VARCHAR(200) NULL DEFAULT NULL,
  `generalNotes` VARCHAR(300) NULL DEFAULT NULL,
  `score` INT(11) NULL DEFAULT NULL,
  `followUpNeeded` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`adminId`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ergodb`.`discomfort`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`discomfort` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`discomfort` (
  `discomfortId` INT(11) NOT NULL AUTO_INCREMENT,
  `notes` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`discomfortId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ergodb`.`company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`company` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`company` (
  `companyId` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`companyId`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ergodb`.`client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`client` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`client` (
  `clientId` INT(11) NOT NULL AUTO_INCREMENT,
  `companyId` INT(11) NOT NULL,
  `assessmentId` VARCHAR(45) NULL DEFAULT NULL,
  `firstName` VARCHAR(30) NOT NULL,
  `lastName` VARCHAR(30) NOT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`clientId`),
  INDEX `companyId` (`companyId` ASC),
  CONSTRAINT `client_ibfk_1`
    FOREIGN KEY (`companyId`)
    REFERENCES `ergodb`.`company` (`companyId`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ergodb`.`followup`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`followup` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`followup` (
  `followUpId` INT(11) NOT NULL AUTO_INCREMENT,
  `note` VARCHAR(300) NULL DEFAULT NULL,
  `comments` VARCHAR(300) NULL DEFAULT NULL,
  `recommendations` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`followUpId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ergodb`.`pmb`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`pmb` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`pmb` (
  `pmbId` INT(11) NOT NULL AUTO_INCREMENT,
  `goalMetBool` TINYINT(1) NULL DEFAULT NULL,
  `goalMetNotes` VARCHAR(250) NULL DEFAULT NULL,
  `educBool` TINYINT(1) NULL DEFAULT NULL,
  `educNotes` VARCHAR(250) NULL DEFAULT NULL,
  `microBeBool` TINYINT(1) NULL DEFAULT NULL,
  `microBeNotes` VARCHAR(250) NULL DEFAULT NULL,
  `microAfBool` TINYINT(1) NULL DEFAULT NULL,
  `microAfNotes` VARCHAR(250) NULL DEFAULT NULL,
  PRIMARY KEY (`pmbId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ergodb`.`pwae`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`pwae` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`pwae` (
  `pwaeId` INT(11) NOT NULL AUTO_INCREMENT,
  `elbowCurr` VARCHAR(45) NULL DEFAULT NULL,
  `elbowRec` VARCHAR(45) NULL DEFAULT NULL,
  `elbowSit` VARCHAR(45) NULL DEFAULT NULL,
  `eyeCurr` VARCHAR(45) NULL DEFAULT NULL,
  `eyeRec` VARCHAR(45) NULL DEFAULT NULL,
  `eyeSit` VARCHAR(45) NULL DEFAULT NULL,
  `deskCurr` VARCHAR(45) NULL DEFAULT NULL,
  `deskRec` VARCHAR(45) NULL DEFAULT NULL,
  `deskSit` VARCHAR(45) NULL DEFAULT NULL,
  `chairNote` VARCHAR(45) NULL DEFAULT NULL,
  `monitorNote` VARCHAR(45) NULL DEFAULT NULL,
  `inputNote` VARCHAR(45) NULL DEFAULT NULL,
  `deskNote` VARCHAR(45) NULL DEFAULT NULL,
  `accessoriesNote` VARCHAR(45) NULL DEFAULT NULL,
  `keyboardCurr` VARCHAR(45) NULL DEFAULT NULL,
  `keyboardRec` VARCHAR(45) NULL DEFAULT NULL,
  `keyboardSit` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`pwaeId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ergodb`.`spm`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`spm` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`spm` (
  `spmId` INT(11) NOT NULL AUTO_INCREMENT,
  `baseBeBool` TINYINT(1) NULL DEFAULT NULL,
  `baseAfBool` TINYINT(1) NULL DEFAULT NULL,
  `shoulderBeBool` TINYINT(1) NULL DEFAULT NULL,
  `shoulderAfBool` TINYINT(1) NULL DEFAULT NULL,
  `armBeBool` TINYINT(1) NULL DEFAULT NULL,
  `armAfBool` TINYINT(1) NULL DEFAULT NULL,
  `baseBeNotes` VARCHAR(250) NULL DEFAULT NULL,
  `baseAfNotes` VARCHAR(250) NULL DEFAULT NULL,
  `shoulderBeNotes` VARCHAR(250) NULL DEFAULT NULL,
  `shoulderAfNotes` VARCHAR(250) NULL DEFAULT NULL,
  `armBeNotes` VARCHAR(250) NULL DEFAULT NULL,
  `armAfNotes` VARCHAR(250) NULL DEFAULT NULL,
  PRIMARY KEY (`spmId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ergodb`.`assessment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`assessment` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`assessment` (
  `assessmentId` INT(11) NOT NULL AUTO_INCREMENT,
  `clientId` INT(11) NOT NULL,
  `adminId` INT(11) NULL DEFAULT NULL,
  `pmbId` INT(11) NULL DEFAULT NULL,
  `spmId` INT(11) NULL DEFAULT NULL,
  `pwaId` INT(11) NULL DEFAULT NULL,
  `discomfortId` INT(11) NULL DEFAULT NULL,
  `followupId` INT(11) NULL DEFAULT NULL,
  `type` VARCHAR(45) NOT NULL,
  `createDate` DATE NOT NULL,
  `editDate` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`assessmentId`),
  INDEX `fk_assessment_client1_idx` (`clientId` ASC),
  INDEX `admin_idx` (`adminId` ASC),
  INDEX `discomfortId_idx` (`discomfortId` ASC),
  INDEX `pmbId_idx` (`pmbId` ASC),
  INDEX `spmId_idx` (`spmId` ASC),
  INDEX `pwaId_idx` (`pwaId` ASC),
  INDEX `followupId_idx` (`followupId` ASC),
  CONSTRAINT `admin`
    FOREIGN KEY (`adminId`)
    REFERENCES `ergodb`.`admin` (`adminId`),
  CONSTRAINT `discomfortId`
    FOREIGN KEY (`discomfortId`)
    REFERENCES `ergodb`.`discomfort` (`discomfortId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_assessment_client1`
    FOREIGN KEY (`clientId`)
    REFERENCES `ergodb`.`client` (`clientId`),
  CONSTRAINT `followupId`
    FOREIGN KEY (`followupId`)
    REFERENCES `ergodb`.`followup` (`followUpId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `pmbId`
    FOREIGN KEY (`pmbId`)
    REFERENCES `ergodb`.`pmb` (`pmbId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `pwaId`
    FOREIGN KEY (`pwaId`)
    REFERENCES `ergodb`.`pwae` (`pwaeId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `spmId`
    FOREIGN KEY (`spmId`)
    REFERENCES `ergodb`.`spm` (`spmId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ergodb`.`assessmentfollowup`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`assessmentfollowup` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`assessmentfollowup` (
  `assessmentId` INT(11) NOT NULL,
  `followUpId` INT(11) NOT NULL,
  INDEX `followUpId` (`followUpId` ASC),
  CONSTRAINT `assessmentfollowup_ibfk_2`
    FOREIGN KEY (`followUpId`)
    REFERENCES `ergodb`.`followup` (`followUpId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ergodb`.`employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`employee` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`employee` (
  `username` VARCHAR(30) NOT NULL,
  `firstName` VARCHAR(30) NOT NULL,
  `lastName` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `phoneNumber` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ergodb`.`clientemployee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`clientemployee` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`clientemployee` (
  `clientId` INT(11) NOT NULL,
  `username` VARCHAR(30) NOT NULL,
  INDEX `clientId` (`clientId` ASC),
  INDEX `username` (`username` ASC),
  CONSTRAINT `clientemployee_ibfk_1`
    FOREIGN KEY (`clientId`)
    REFERENCES `ergodb`.`client` (`clientId`),
  CONSTRAINT `clientemployee_ibfk_2`
    FOREIGN KEY (`username`)
    REFERENCES `ergodb`.`employee` (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ergodb`.`privilege`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`privilege` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`privilege` (
  `privilegeId` INT(11) NOT NULL,
  `description` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`privilegeId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ergodb`.`employeeprivilege`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`employeeprivilege` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`employeeprivilege` (
  `privilegeId` INT(11) NOT NULL,
  `username` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`username`, `privilegeId`),
  INDEX `privilegeId` (`privilegeId` ASC),
  CONSTRAINT `employeeprivilege_ibfk_1`
    FOREIGN KEY (`privilegeId`)
    REFERENCES `ergodb`.`privilege` (`privilegeId`),
  CONSTRAINT `employeeprivilege_ibfk_2`
    FOREIGN KEY (`username`)
    REFERENCES `ergodb`.`employee` (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ergodb`.`location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`location` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`location` (
  `locationId` INT(11) NOT NULL AUTO_INCREMENT,
  `companyId` INT(11) NOT NULL,
  `address` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`locationId`),
  INDEX `companyId` (`companyId` ASC),
  CONSTRAINT `location_ibfk_1`
    FOREIGN KEY (`companyId`)
    REFERENCES `ergodb`.`company` (`companyId`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ergodb`.`log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`log` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`log` (
  `clientId` INT(11) NOT NULL,
  `employeeId` INT(11) NOT NULL,
  `action` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`clientId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ergodb`.`monitor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`monitor` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`monitor` (
  `monitorId` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  `current` VARCHAR(45) NULL DEFAULT NULL,
  `recommand` VARCHAR(45) NULL DEFAULT NULL,
  `sitStand` VARCHAR(45) NULL DEFAULT NULL,
  `pwaeId` INT(11) NOT NULL,
  PRIMARY KEY (`monitorId`),
  INDEX `pwaeId_idx` (`pwaeId` ASC),
  CONSTRAINT `pwaeId`
    FOREIGN KEY (`pwaeId`)
    REFERENCES `ergodb`.`pwae` (`pwaeId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ergodb`.`siteRec`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`siteRec` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`siteRec` (
  `siteRecId` INT(11) NOT NULL AUTO_INCREMENT,
  `recommand` VARCHAR(45) NULL DEFAULT NULL,
  `accessoryType` VARCHAR(45) NULL DEFAULT NULL,
  `completeDate` DATETIME NULL DEFAULT NULL,
  `pwaeId_site` INT(11) NOT NULL,
  PRIMARY KEY (`siteRecId`),
  INDEX `pwaeId_idx` (`pwaeId_site` ASC),
  CONSTRAINT `pwaeId_site`
    FOREIGN KEY (`pwaeId_site`)
    REFERENCES `ergodb`.`pwae` (`pwaeId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
