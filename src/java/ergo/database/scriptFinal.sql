
DROP SCHEMA IF EXISTS `ergodb` ;

-- -----------------------------------------------------
-- Schema ergodb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ergodb`;
USE `ergodb` ;

-- -----------------------------------------------------
-- Table `ergodb`.`accessory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`accessory` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`accessory` (
  `accessoryId` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`accessoryId`));



-- -----------------------------------------------------
-- Table `ergodb`.`admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`admin` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`admin` (
  `adminId` INT(45) NOT NULL AUTO_INCREMENT,
  `proactive` VARCHAR(20) NULL,
  `reactive` VARCHAR(20) NULL ,
  `assessor` VARCHAR(20) NULL,
  `manager` VARCHAR(20) NULL,
  `businessUnit` VARCHAR(20) NULL,
  `workspace` VARCHAR(20) NULL,
  `jobTitle` VARCHAR(20) NULL,
  `gender` VARCHAR(6) NULL,
  `heightInFeet` INT(11) NULL,
  `heightInInches` INT(11) NULL,
  `handedness` VARCHAR(5) NULL,
  `daysPerWeek` INT(11) NULL,
  `hoursPerDay` INT(11) NULL,
  `hoursVDT` INT(11) NULL,
  `hoursOnPhone` INT(11) NULL,
  `discomfortPresent` VARCHAR(20) NULL,
  `discomfortReported` VARCHAR(20) NULL,
  `treatmentSought` VARCHAR(20) NULL,
  `maxDiscomfort` INT(1) NULL,
  `workFit` INT(1) NULL, 
  `risks` VARCHAR(200) NULL,
  `equipmentRecommendations` VARCHAR(200),
  `generalNotes` VARCHAR(300) NULL,
  `score` INT(11) NULL,
  `followUpNeeded` VARCHAR(50),
  PRIMARY KEY (`adminId`));



-- -----------------------------------------------------
-- Table `ergodb`.`company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`company` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`company` (
  `companyId` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`companyId`));


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
    REFERENCES `ergodb`.`company` (`companyId`));



-- -----------------------------------------------------
-- Table `ergodb`.`assessment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`assessment` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`assessment` (
  `assessmentId` INT(11) NOT NULL,
  `clientId` INT(11) NOT NULL,
  `adminId` INT NULL,
  `pmbId` INT(11) NULL DEFAULT NULL,
  `spmId` INT(11) NULL DEFAULT NULL,
  `pwaId` INT(11) NULL DEFAULT NULL,
  `discomfortId` INT(11) NULL DEFAULT NULL,
  `followupId` INT(11) NULL,
  PRIMARY KEY (`assessmentId`),
  INDEX `fk_assessment_client1_idx` (`clientId` ASC),
  INDEX `admin_idx` (`adminId` ASC),
  CONSTRAINT `fk_assessment_client1`
    FOREIGN KEY (`clientId`)
    REFERENCES `ergodb`.`client` (`clientId`),
  CONSTRAINT `admin`
    FOREIGN KEY (`adminId`)
    REFERENCES `ergodb`.`admin` (`adminId`));



-- -----------------------------------------------------
-- Table `ergodb`.`assessmentaccessory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`assessmentaccessory` ;

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
DROP TABLE IF EXISTS `ergodb`.`followup` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`followup` (
  `followUpId` INT(11) NOT NULL AUTO_INCREMENT,
  `note` VARCHAR(300) NULL DEFAULT NULL,
  `comments` VARCHAR(300) NULL DEFAULT NULL,
  `recommendations` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`followUpId`));



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
    REFERENCES `ergodb`.`followup` (`followUpId`));



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
  PRIMARY KEY (`username`));



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
    REFERENCES `ergodb`.`employee` (`username`));



-- -----------------------------------------------------
-- Table `ergodb`.`privilege`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`privilege` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`privilege` (
  `privilegeId` INT(11) NOT NULL,
  `description` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`privilegeId`));



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
    REFERENCES `ergodb`.`employee` (`username`));



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
    REFERENCES `ergodb`.`company` (`companyId`));


-- -----------------------------------------------------
-- Table `ergodb`.`log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`log` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`log` (
  `clientId` INT(11) NOT NULL,
  `employeeId` INT(11) NOT NULL,
  `action` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`clientId`));




-- -----------------------------------------------------
-- Table `ergodb`.`discomfort`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`discomfort` ;
CREATE TABLE IF NOT EXISTS `ergodb`.`discomfort` (
  `discomfortId` INT(11) NOT NULL AUTO_INCREMENT,
  `notes` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`discomfortId`));

-- -----------------------------------------------------
-- Table `ergodb`.`assessmentdiscomfort`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ergodb`.`assessmentdiscomfort` ;

CREATE TABLE IF NOT EXISTS `ergodb`.`assessmentdiscomfort` (
  `assessmentId` INT(11) NOT NULL,
  `discomfortId` INT(11) NOT NULL,
  INDEX `discomfortId` (`discomfortId` ASC),
  CONSTRAINT `assessmentdiscomfort_ibfk_2`
    FOREIGN KEY (`discomfortId`)
    REFERENCES `ergodb`.`discomfort` (`discomfortId`));

-- -----------------------------------------------------
-- Table `ergodb`.`pmb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ergodb`.`pmb` (
  `pmbId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `goalMetBool` TINYINT(1) NULL DEFAULT NULL COMMENT '',
  `goalMetNotes` VARCHAR(250) NULL DEFAULT NULL COMMENT '',
  `educBool` TINYINT(1) NULL DEFAULT NULL COMMENT '',
  `educNotes` VARCHAR(250) NULL DEFAULT NULL COMMENT '',
  `microBeBool` TINYINT(1) NULL DEFAULT NULL COMMENT '',
  `microBeNotes` VARCHAR(250) NULL DEFAULT NULL COMMENT '',
  `microAfBool` TINYINT(1) NULL DEFAULT NULL COMMENT '',
  `microAfNotes` VARCHAR(250) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`pmbId`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `ergodb`.`spm`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ergodb`.`spm` (
  `spmId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `baseBeBool` TINYINT(1) NULL COMMENT '',
  `baseAfBool` TINYINT(1) NULL COMMENT '',
  `shoulderBeBool` TINYINT(1) NULL COMMENT '',
  `shoulderAfBool` TINYINT(1) NULL COMMENT '',
  `armBeBool` TINYINT(1) NULL COMMENT '',
  `armAfBool` TINYINT(1) NULL COMMENT '',
  `baseBeNotes` VARCHAR(250) NULL COMMENT '',
  `baseAfNotes` VARCHAR(250) NULL COMMENT '',
  `shoulderBeNotes` VARCHAR(250) NULL COMMENT '',
  `shoulderAfNotes` VARCHAR(250) NULL COMMENT '',
  `armBeNotes` VARCHAR(250) NULL COMMENT '',
  `armAfNotes` VARCHAR(250) NULL COMMENT '',
  PRIMARY KEY (`spmId`)  COMMENT '')
ENGINE = InnoDB;

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
AUTO_INCREMENT = 10
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
AUTO_INCREMENT = 4
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
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;



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
