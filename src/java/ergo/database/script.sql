-- ---
-- Globals
-- ---
DROP DATABASE IF EXISTS ErgoDB;
CREATE DATABASE ErgoDB;
USE ErgoDB;
-- ---
-- Globals
-- ---

-- SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
-- SET FOREIGN_KEY_CHECKS=0;

-- ---
-- Table 'COMPANY'
-- 
-- ---

DROP TABLE IF EXISTS `COMPANY`;
		
CREATE TABLE `COMPANY` (
  `companyId` INTEGER NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`companyId`)
);

-- ---
-- Table 'CLIENTCOMPANY'
-- 
-- ---

DROP TABLE IF EXISTS `CLIENTCOMPANY`;
		
CREATE TABLE `CLIENTCOMPANY` (
  `companyId` INTEGER NOT NULL,
  `clientId` INTEGER NOT NULL
);

-- ---
-- Table 'LOCATION'
-- 
-- ---

DROP TABLE IF EXISTS `LOCATION`;
		
CREATE TABLE `LOCATION` (
  `locationId` INTEGER NOT NULL AUTO_INCREMENT,
  `companyId` INTEGER NOT NULL,
  `address` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`locationId`)
);

-- ---
-- Table 'CLIENT'
-- 
-- ---

DROP TABLE IF EXISTS `CLIENT`;
		
CREATE TABLE `CLIENT` (
  `clientId` INTEGER NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(30) NOT NULL,
  `lastName` VARCHAR(30) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `phoneNumber` INTEGER(20) NULL DEFAULT NULL,
  PRIMARY KEY (`clientId`)
);

-- ---
-- Table 'EMPLOYEE'
-- 
-- ---

DROP TABLE IF EXISTS `EMPLOYEE`;
		
CREATE TABLE `EMPLOYEE` (
  `username` VARCHAR(30) NOT NULL,
  `firstName` VARCHAR(30) NOT NULL,
  `lastName` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `phoneNumber` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`username`)
);

-- ---
-- Table 'CLIENTEMPLOYEE'
-- 
-- ---

DROP TABLE IF EXISTS `CLIENTEMPLOYEE`;
		
CREATE TABLE `CLIENTEMPLOYEE` (
  `clientId` INTEGER NOT NULL,
  `username` VARCHAR(30) NOT NULL
);

-- ---
-- Table 'ASSESSMENT'
-- 
-- ---

DROP TABLE IF EXISTS `ASSESSMENT`;
		
CREATE TABLE `ASSESSMENT` (
  `assessmentId` INTEGER NOT NULL AUTO_INCREMENT,
  `assessor` VARCHAR(30) NOT NULL,
  `clientId` INTEGER NULL DEFAULT NULL,
  `date` DATE NOT NULL,
  `workerComments` VARCHAR(300) NULL DEFAULT NULL,
  `risks` VARCHAR(300) NULL DEFAULT NULL,
  `recommendations` VARCHAR(300) NULL DEFAULT NULL,
  `boolFollowUp` INTEGER NULL DEFAULT 0,
  `boolStretchBreak` INTEGER NULL DEFAULT 0,
  `boolMicro` INTEGER NULL DEFAULT 0,
  `boolSitStand` INTEGER NULL DEFAULT 0,
  `prepNotes` VARCHAR(300) NOT NULL,
  `boolStableBase` INTEGER NULL DEFAULT 0,
  `stableBaseNotes` VARCHAR(300) NULL DEFAULT NULL,
  `boolShoulderPos` INTEGER NULL DEFAULT 0,
  `shoulderPosNotes` VARCHAR(300) NULL DEFAULT NULL,
  `boolArmPos` INTEGER NULL DEFAULT 0,
  `armPosNotes` VARCHAR(300) NULL DEFAULT NULL,
  `generalNotes` VARCHAR(300) NULL DEFAULT NULL,
  `boolChair` INTEGER NULL DEFAULT 0,
  `chairNotes` VARCHAR(300) NULL DEFAULT NULL,
  `boolMonitor` INTEGER NULL DEFAULT 0,
  `monitorNotes` VARCHAR(300) NULL DEFAULT NULL,
  `boolDevices` INTEGER NULL DEFAULT 0,
  `devicesNotes` VARCHAR(300) NULL DEFAULT NULL,
  `boolDesk` INTEGER NULL DEFAULT 0,
  `deskNotes` VARCHAR(300) NULL DEFAULT NULL,
  `boolAccessories` INTEGER NULL DEFAULT 0,
  `accessoriesNotes` VARCHAR(300) NULL DEFAULT NULL,
  `confidentialNotes` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`assessmentId`)
);

-- ---
-- Table 'ASSESSMENTACCESSORY'
-- 
-- ---

DROP TABLE IF EXISTS `ASSESSMENTACCESSORY`;
		
CREATE TABLE `ASSESSMENTACCESSORY` (
  `assessmentId` INTEGER NOT NULL,
  `accessoryId` INTEGER NOT NULL
);

-- ---
-- Table 'ACCESSORY'
-- 
-- ---

DROP TABLE IF EXISTS `ACCESSORY`;
		
CREATE TABLE `ACCESSORY` (
  `accessoryId` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  PRIMARY KEY (`accessoryId`)
);

-- ---
-- Table 'ASSESSMENTFOLLOWUP'
-- 
-- ---

DROP TABLE IF EXISTS `ASSESSMENTFOLLOWUP`;
		
CREATE TABLE `ASSESSMENTFOLLOWUP` (
  `assessmentId` INTEGER NOT NULL,
  `followUpId` INTEGER NOT NULL
);

-- ---
-- Table 'FOLLOWUP'
-- 
-- ---

DROP TABLE IF EXISTS `FOLLOWUP`;
		
CREATE TABLE `FOLLOWUP` (
  `followUpId` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `note` VARCHAR(300) NULL DEFAULT NULL,
  `comments` VARCHAR(300) NULL DEFAULT NULL,
  `recommendations` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`followUpId`)
);

-- ---
-- Table 'MONITOR'
-- 
-- ---

DROP TABLE IF EXISTS `MONITOR`;
		
CREATE TABLE `MONITOR` (
  `monitorId` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `assessmentId` INTEGER NOT NULL,
  `size` INTEGER NOT NULL,
  `pre` INTEGER NULL DEFAULT NULL,
  `post` INTEGER NULL DEFAULT NULL,
  `recommendation` VARCHAR(300) NULL DEFAULT NULL,
  `notes` VARCHAR(300) NULL DEFAULT NULL,
  `type` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`monitorId`)
);

-- ---
-- Table 'LOG'
-- 
-- ---

DROP TABLE IF EXISTS `LOG`;
		
CREATE TABLE `LOG` (
  `clientId` INTEGER NOT NULL,
  `employeeId` INTEGER NOT NULL,
  `action` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`clientId`)
);

-- ---
-- Table 'EMPLOYEEPRIVILEGE'
-- 
-- ---

DROP TABLE IF EXISTS `EMPLOYEEPRIVILEGE`;
		
CREATE TABLE `EMPLOYEEPRIVILEGE` (
  `privilegeId` INTEGER NOT NULL,
  `username` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`username`, `privilegeId`)
);

-- ---
-- Table 'PRIVILEGE'
-- 
-- ---

DROP TABLE IF EXISTS `PRIVILEGE`;
		
CREATE TABLE `PRIVILEGE` (
  `privilegeId` INTEGER NOT NULL,
  `description` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`privilegeId`)
);

-- ---
-- Foreign Keys 
-- ---

ALTER TABLE `CLIENTCOMPANY` ADD FOREIGN KEY (companyId) REFERENCES `COMPANY` (`companyId`);
ALTER TABLE `CLIENTCOMPANY` ADD FOREIGN KEY (clientId) REFERENCES `CLIENT` (`clientId`);
ALTER TABLE `LOCATION` ADD FOREIGN KEY (companyId) REFERENCES `COMPANY` (`companyId`);
ALTER TABLE `CLIENTEMPLOYEE` ADD FOREIGN KEY (clientId) REFERENCES `CLIENT` (`clientId`);
ALTER TABLE `CLIENTEMPLOYEE` ADD FOREIGN KEY (username) REFERENCES `EMPLOYEE` (`username`);
ALTER TABLE `ASSESSMENT` ADD FOREIGN KEY (clientId) REFERENCES `CLIENT` (`clientId`);
ALTER TABLE `ASSESSMENTACCESSORY` ADD FOREIGN KEY (assessmentId) REFERENCES `ASSESSMENT` (`assessmentId`);
ALTER TABLE `ASSESSMENTACCESSORY` ADD FOREIGN KEY (accessoryId) REFERENCES `ACCESSORY` (`accessoryId`);
ALTER TABLE `ASSESSMENTFOLLOWUP` ADD FOREIGN KEY (assessmentId) REFERENCES `ASSESSMENT` (`assessmentId`);
ALTER TABLE `ASSESSMENTFOLLOWUP` ADD FOREIGN KEY (followUpId) REFERENCES `FOLLOWUP` (`followUpId`);
ALTER TABLE `MONITOR` ADD FOREIGN KEY (assessmentId) REFERENCES `ASSESSMENT` (`assessmentId`);
ALTER TABLE `EMPLOYEEPRIVILEGE` ADD FOREIGN KEY (privilegeId) REFERENCES `PRIVILEGE` (`privilegeId`);
ALTER TABLE `EMPLOYEEPRIVILEGE` ADD FOREIGN KEY (username) REFERENCES `EMPLOYEE` (`username`);

-- ---
-- Table Properties
-- ---

-- ALTER TABLE `COMPANY` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `CLIENTCOMPANY` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `LOCATION` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `CLIENT` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `EMPLOYEE` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `CLIENTEMPLOYEE` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `ASSESSMENT` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `ASSESSMENTACCESSORY` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `ACCESSORY` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `ASSESSMENTFOLLOWUP` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `FOLLOWUP` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `MONITOR` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `LOG` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `EMPLOYEEPRIVILEGE` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `PRIVILEGE` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---
-- Test Data
-- ---

-- INSERT INTO `COMPANY` (`companyId`,`name`) VALUES
-- ('','');
-- INSERT INTO `CLIENTCOMPANY` (`companyId`,`clientId`) VALUES
-- ('','');
-- INSERT INTO `LOCATION` (`locationId`,`companyId`,`address`) VALUES
-- ('','','');
-- INSERT INTO `CLIENT` (`clientId`,`firstName`,`lastName`,`email`,`phoneNumber`) VALUES
-- ('','','','','');
-- INSERT INTO `EMPLOYEE` (`username`,`firstName`,`lastName`,`password`,`email`,`phoneNumber`) VALUES
-- ('','','','','','');
-- INSERT INTO `CLIENTEMPLOYEE` (`clientId`,`username`) VALUES
-- ('','');
-- INSERT INTO `ASSESSMENT` (`assessmentId`,`assessor`,`clientId`,`date`,`workerComments`,`risks`,`recommendations`,`boolFollowUp`,`boolStretchBreak`,`boolMicro`,`boolSitStand`,`prepNotes`,`boolStableBase`,`stableBaseNotes`,`boolShoulderPos`,`shoulderPosNotes`,`boolArmPos`,`armPosNotes`,`generalNotes`,`boolChair`,`chairNotes`,`boolMonitor`,`monitorNotes`,`boolDevices`,`devicesNotes`,`boolDesk`,`deskNotes`,`boolAccessories`,`accessoriesNotes`,`confidentialNotes`) VALUES
-- ('','','','','','','','','','','','','','','','','','','','','','','','','','','','','','');
-- INSERT INTO `ASSESSMENTACCESSORY` (`assessmentId`,`accessoryId`) VALUES
-- ('','');
-- INSERT INTO `ACCESSORY` (`accessoryId`) VALUES
-- ('');
-- INSERT INTO `ASSESSMENTFOLLOWUP` (`assessmentId`,`followUpId`) VALUES
-- ('','');
-- INSERT INTO `FOLLOWUP` (`followUpId`,`note`,`comments`,`recommendations`) VALUES
-- ('','','','');
-- INSERT INTO `MONITOR` (`monitorId`,`assessmentId`,`size`,`pre`,`post`,`recommendation`,`notes`,`type`) VALUES
-- ('','','','','','','','');
-- INSERT INTO `LOG` (`clientId`,`employeeId`,`action`) VALUES
-- ('','','');
-- INSERT INTO `EMPLOYEEPRIVILEGE` (`privilegeId`,`username`) VALUES
-- ('','');
-- INSERT INTO `PRIVILEGE` (`privilegeId`,`description`) VALUES
-- ('','');

--DUMMY ACCOUNT FOR LOGIN
INSERT INTO `PRIVILEGE` (`privilegeId`,`description`) VALUES
(1,'Admin Privilege');
INSERT INTO `PRIVILEGE` (`privilegeId`,`description`) VALUES
(0,'Employee Privilege');
INSERT INTO `EMPLOYEE` (`firstName`,`lastName`,`username`,`password`,`email`) VALUES
('adam','adam','adam','password','adam@gmail.com');
INSERT INTO `EMPLOYEE` (`firstName`,`lastName`,`username`,`password`,`email`) VALUES
('betty','betty','betty','password','betty@gmail.com');
INSERT INTO `EMPLOYEEPRIVILEGE` (`privilegeId`,`username`)VALUES
(1, 'adam');
INSERT INTO `EMPLOYEEPRIVILEGE` (`privilegeId`,`username`)VALUES
(0, 'betty');