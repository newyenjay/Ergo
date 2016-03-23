DROP DATABASE IF EXISTS ErgoDB;
CREATE DATABASE ErgoDB;
USE ErgoDB;


DROP TABLE IF EXISTS `company`;
		
CREATE TABLE `company` (
  `companyId` INTEGER NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`companyId`)
);


DROP TABLE IF EXISTS `clientcompany`;
		
CREATE TABLE `clientcompany` (
  `companyId` INTEGER NOT NULL,
  `clientId` INTEGER NOT NULL
);

DROP TABLE IF EXISTS `location`;
		
CREATE TABLE `location` (
  `locationId` INTEGER NOT NULL AUTO_INCREMENT,
  `companyId` INTEGER NOT NULL,
  `address` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`locationId`)
);

DROP TABLE IF EXISTS `client`;
		
CREATE TABLE `client` (
  `clientId` INTEGER NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(30) NOT NULL,
  `lastName` VARCHAR(30) NOT NULL,
  `email` VARCHAR(50),
  `dateCreated` DATE,
  PRIMARY KEY (`clientId`)
);

DROP TABLE IF EXISTS `employee`;
		
CREATE TABLE `employee` (
  `username` VARCHAR(30) NOT NULL,
  `firstName` VARCHAR(30) NOT NULL,
  `lastName` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `phoneNumber` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`username`)
);


DROP TABLE IF EXISTS `clientemployee`;
		
CREATE TABLE `clientemployee` (
  `clientId` INTEGER NOT NULL,
  `username` VARCHAR(30) NOT NULL
);


DROP TABLE IF EXISTS `assessment`;
		
CREATE TABLE `assessment` (
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

DROP TABLE IF EXISTS `assessmentaccessory`;
		
CREATE TABLE `assessmentaccessory` (
  `assessmentId` INTEGER NOT NULL,
  `accessoryId` INTEGER NOT NULL
);

DROP TABLE IF EXISTS `accessory`;
		
CREATE TABLE `accessory` (
  `accessoryId` INTEGER NOT NULL AUTO_INCREMENT ,
  PRIMARY KEY (`accessoryId`)
);

DROP TABLE IF EXISTS `assessmentfollowup`;
		
CREATE TABLE `assessmentfollowup` (
  `assessmentId` INTEGER NOT NULL,
  `followUpId` INTEGER NOT NULL
);

DROP TABLE IF EXISTS `followup`;
		
CREATE TABLE `followup` (
  `followUpId` INTEGER NOT NULL AUTO_INCREMENT ,
  `note` VARCHAR(300) NULL DEFAULT NULL,
  `comments` VARCHAR(300) NULL DEFAULT NULL,
  `recommendations` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`followUpId`)
);

DROP TABLE IF EXISTS `monitor`;
		
CREATE TABLE `monitor` (
  `monitorId` INTEGER NOT NULL AUTO_INCREMENT ,
  `assessmentId` INTEGER NOT NULL,
  `size` INTEGER NOT NULL,
  `pre` INTEGER NULL DEFAULT NULL,
  `post` INTEGER NULL DEFAULT NULL,
  `recommendation` VARCHAR(300) NULL DEFAULT NULL,
  `notes` VARCHAR(300) NULL DEFAULT NULL,
  `type` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`monitorId`)
);

DROP TABLE IF EXISTS `log`;
		
CREATE TABLE `log` (
  `clientId` INTEGER NOT NULL,
  `employeeId` INTEGER NOT NULL,
  `action` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`clientId`)
);

		
CREATE TABLE `employeeprivilege` (
  `privilegeId` INTEGER NOT NULL,
  `username` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`username`, `privilegeId`)
);

		
CREATE TABLE `privilege` (
  `privilegeId` INTEGER NOT NULL,
  `description` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`privilegeId`)
);
		
CREATE TABLE `admin` (
  `assessmentId` INTEGER NOT NULL AUTO_INCREMENT ,
  `proactive` VARCHAR(20) NULL,
  `reactive` VARCHAR(20) NULL,
  `assessor` VARCHAR(20) NULL,
  `manager` VARCHAR(20) NULL,
  `businessUnit` VARCHAR(20) NULL,
  `workspace` VARCHAR(20) NULL,
  `jobTitle` VARCHAR(20) NULL,
  `gender` VARCHAR(6) NULL,
  `heightInFeet` INTEGER NULL,
  `heightInInches` INTEGER NULL,
  `handedness` VARCHAR(5) NULL,
  `daysPerWeek` INTEGER NULL,
  `hoursPerDay` INTEGER NULL,
  `hoursVDT` INTEGER NULL,
  `hoursOnPhone` INTEGER NULL,
  `discomfortPresent` VARCHAR(20) NULL,
  `discomfortReported` VARCHAR(20) NULL,
  `treatmentSought` VARCHAR(20) NULL,
  `maxDiscomfort` VARCHAR(20) NULL,
  `risks` VARCHAR(200) NULL,
  `equipmentRecommendations` VARCHAR(200) NULL,
  `generalNotes` VARCHAR(300) NULL DEFAULT NULL,
  `score` INTEGER NULL,
  `followUpNeeded` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`assessmentId`)
);

ALTER TABLE `clientcompany` ADD FOREIGN KEY (companyId) REFERENCES `company` (`companyId`);
ALTER TABLE `clientcompany` ADD FOREIGN KEY (clientId) REFERENCES `client` (`clientId`);
ALTER TABLE `location` ADD FOREIGN KEY (companyId) REFERENCES `company` (`companyId`);
ALTER TABLE `clientemployee` ADD FOREIGN KEY (clientId) REFERENCES `client` (`clientId`);
ALTER TABLE `clientemployee` ADD FOREIGN KEY (username) REFERENCES `employee` (`username`);
ALTER TABLE `assessment` ADD FOREIGN KEY (clientId) REFERENCES `client` (`clientId`);
ALTER TABLE `assessmentaccessory` ADD FOREIGN KEY (assessmentId) REFERENCES `assessment` (`assessmentId`);
ALTER TABLE `assessmentaccessory` ADD FOREIGN KEY (accessoryId) REFERENCES `accessory` (`accessoryId`);
ALTER TABLE `assessmentfollowup` ADD FOREIGN KEY (assessmentId) REFERENCES `assessment` (`assessmentId`);
ALTER TABLE `assessmentfollowup` ADD FOREIGN KEY (followUpId) REFERENCES `followup` (`followUpId`);
ALTER TABLE `monitor` ADD FOREIGN KEY (assessmentId) REFERENCES `assessment` (`assessmentId`);
ALTER TABLE `employeeprivilege` ADD FOREIGN KEY (privilegeId) REFERENCES `privilege` (`privilegeId`);
ALTER TABLE `employeeprivilege` ADD FOREIGN KEY (username) REFERENCES `employee` (`username`);

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
('Bankers Hall');
INSERT INTO `location` (`companyId`,`address`)VALUES
(1, '4th Street SW');
