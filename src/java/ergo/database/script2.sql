-- -----------------------------------------------------
-- Schema ergodb
-- -----------------------------------------------------
DROP DATABASE IF EXISTS ErgoDB;
CREATE DATABASE ErgoDB;
USE ErgoDB;


-- -----------------------------------------------------
-- Table `ergodb`.`accessory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ergodb`.`accessory` (
  `accessoryId` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`accessoryId`));


-- -----------------------------------------------------
-- Table `ergodb`.`company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ergodb`.`company` (
  `companyId` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`companyId`));

-- -----------------------------------------------------
-- Table `ergodb`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ergodb`.`client` (
  `clientId` INT(11) NOT NULL AUTO_INCREMENT,
  `companyId` INT(11) NOT NULL,
  `assessmentId` VARCHAR(45) NULL,
  `firstName` VARCHAR(30) NOT NULL,
  `lastName` VARCHAR(30) NOT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`clientId`),
  INDEX `companyId` (`companyId` ASC),
  CONSTRAINT `client_ibfk_1`
    FOREIGN KEY (`companyId`)
    REFERENCES `ergodb`.`company` (`companyId`));

-- -----------------------------------------------------
-- Table `ergodb`.`assessment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ergodb`.`assessment` (
  `assessmentId` INT NOT NULL,
  `adminId` INT NULL,
  `pmbId` INT NULL,
  `spmId` INT NULL,
  `pwaId` INT NULL,
  `discomfortId` INT NULL,
  `followupId` INT NULL,
  `client_clientId` INT(11) NOT NULL,
  PRIMARY KEY (`assessmentId`),
  INDEX `fk_assessment_client1_idx` (`client_clientId` ASC),
  CONSTRAINT `fk_assessment_client1`
    FOREIGN KEY (`client_clientId`)
    REFERENCES `ergodb`.`client` (`clientId`));


-- -----------------------------------------------------
-- Table `ergodb`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin` (
  `assessmentId` INT(11) NOT NULL AUTO_INCREMENT,
  `adminId` INT(45) NULL DEFAULT NULL,
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
  `maxDiscomfort` VARCHAR(20) NULL DEFAULT NULL,
  `risks` VARCHAR(200) NULL DEFAULT NULL,
  `equipmentRecommendations` VARCHAR(200) NULL DEFAULT NULL,
  `generalNotes` VARCHAR(300) NULL DEFAULT NULL,
  `score` INT(11) NULL DEFAULT NULL,
  `followUpNeeded` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`assessmentId`));


-- -----------------------------------------------------
-- Table `ergodb`.`assessmentaccessory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ergodb`.`assessmentaccessory` (
  `assessmentId` INT(11) NOT NULL,
  `accessoryId` INT(11) NOT NULL,
  INDEX `accessoryId` (`accessoryId` ASC),
  CONSTRAINT `assessmentaccessory_ibfk_2`
    FOREIGN KEY (`accessoryId`)
    REFERENCES `ergodb`.`accessory` (`accessoryId`));


-- -----------------------------------------------------
-- Table `ergodb`.`followup`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ergodb`.`followup` (
  `followUpId` INT(11) NOT NULL AUTO_INCREMENT,
  `note` VARCHAR(300) NULL DEFAULT NULL,
  `comments` VARCHAR(300) NULL DEFAULT NULL,
  `recommendations` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`followUpId`));


-- -----------------------------------------------------
-- Table `ergodb`.`assessmentfollowup`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ergodb`.`assessmentfollowup` (
  `assessmentId` INT(11) NOT NULL,
  `followUpId` INT(11) NOT NULL,
  INDEX `followUpId` (`followUpId` ASC),
  CONSTRAINT `assessmentfollowup_ibfk_2`
    FOREIGN KEY (`followUpId`)
    REFERENCES `ergodb`.`followup` (`followUpId`));


-- -----------------------------------------------------
-- Table `ergodb`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ergodb`.`employee` (
  `username` VARCHAR(30) NOT NULL,
  `firstName` VARCHAR(30) NOT NULL,
  `lastName` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `phoneNumber` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`username`));


-- -----------------------------------------------------
-- Table `ergodb`.`clientemployee`
-- -----------------------------------------------------
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
    REFERENCES `ergodb`.`employee` (`username`));

-- -----------------------------------------------------
-- Table `ergodb`.`privilege`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ergodb`.`privilege` (
  `privilegeId` INT(11) NOT NULL,
  `description` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`privilegeId`));


-- -----------------------------------------------------
-- Table `ergodb`.`employeeprivilege`
-- -----------------------------------------------------
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
    REFERENCES `ergodb`.`employee` (`username`));


-- -----------------------------------------------------
-- Table `ergodb`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ergodb`.`location` (
  `locationId` INT(11) NOT NULL AUTO_INCREMENT,
  `companyId` INT(11) NOT NULL,
  `address` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`locationId`),
  INDEX `companyId` (`companyId` ASC),
  CONSTRAINT `location_ibfk_1`
    FOREIGN KEY (`companyId`)
    REFERENCES `ergodb`.`company` (`companyId`));


-- -----------------------------------------------------
-- Table `ergodb`.`log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ergodb`.`log` (
  `clientId` INT(11) NOT NULL,
  `employeeId` INT(11) NOT NULL,
  `action` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`clientId`));

-- -----------------------------------------------------
-- Table `ergodb`.`monitor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ergodb`.`monitor` (
  `monitorId` INT(11) NOT NULL AUTO_INCREMENT,
  `assessmentId` INT(11) NOT NULL,
  `size` INT(11) NOT NULL,
  `pre` INT(11) NULL DEFAULT NULL,
  `post` INT(11) NULL DEFAULT NULL,
  `recommendation` VARCHAR(300) NULL DEFAULT NULL,
  `notes` VARCHAR(300) NULL DEFAULT NULL,
  `type` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`monitorId`));


  INSERT INTO `PRIVILEGE` (`privilegeId`,`description`) VALUES
  (1,'Admin Privilege');
  INSERT INTO `privilege` (`privilegeId`,`description`) VALUES
  (0,'Employee Privilege');
  INSERT INTO `employee` (`firstName`,`lastName`,`username`,`password`,`email`) VALUES
  ('adam','adam','adam','password','adam@gmail.com');
  INSERT INTO `employee` (`firstName`,`lastName`,`username`,`password`,`email`) VALUES
  ('betty','betty','betty','password','betty@gmail.com');
  INSERT INTO `employeeprivilege` (`privilegeId`,`username`)VALUES
  (1, 'adam');
  INSERT INTO `employeeprivilege` (`privilegeId`,`username`)VALUES
  (0, 'betty');

  INSERT INTO `company` (`name`)VALUES
  ('Sait');

  INSERT INTO `location`(`companyId`,`address`)VALUES
  (1,'123 Street');
