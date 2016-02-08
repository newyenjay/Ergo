
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
  `companyId` INTEGER NULL AUTO_INCREMENT,
  `name` INTEGER NULL,
  PRIMARY KEY (`companyId`)
);

-- ---
-- Table 'CLIENTCOMPANY'
-- 
-- ---

DROP TABLE IF EXISTS `CLIENTCOMPANY`;
		
CREATE TABLE `CLIENTCOMPANY` (
  `companyId` INTEGER NULL,
  `clientId` INTEGER NULL AUTO_INCREMENT,
  PRIMARY KEY (`clientId`, `companyId`)
);

-- ---
-- Table 'LOCATION'
-- 
-- ---

DROP TABLE IF EXISTS `LOCATION`;
		
CREATE TABLE `LOCATION` (
  `locationId` INTEGER NULL AUTO_INCREMENT,
  `companyId` INTEGER NOT NULL,
  `address` VARCHAR NOT NULL,
  PRIMARY KEY (`locationId`)
);

-- ---
-- Table 'CLIENT'
-- 
-- ---

DROP TABLE IF EXISTS `CLIENT`;
		
CREATE TABLE `CLIENT` (
  `clientId` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `firstName` VARCHAR(30) NOT NULL,
  `lastName` VARCHAR(30) NOT NULL DEFAULT 'NULL',
  PRIMARY KEY (`clientId`)
);

-- ---
-- Table 'EMPLOYEE'
-- 
-- ---

DROP TABLE IF EXISTS `EMPLOYEE`;
		
CREATE TABLE `EMPLOYEE` (
  `employeeId` INTEGER NOT NULL AUTO_INCREMENT,
  `privilegeId` INTEGER NOT NULL,
  `firstName` VARCHAR NOT NULL,
  `lastName` VARCHAR NOT NULL,
  `username` VARCHAR NOT NULL,
  `password` VARCHAR NOT NULL,
  `email` VARCHAR NOT NULL,
  `phoneNumber` INTEGER NULL,
  `birthdate` DATE NULL,
  PRIMARY KEY (`employeeId`)
);

-- ---
-- Table 'PRIVILEGE'
-- 
-- ---

DROP TABLE IF EXISTS `PRIVILEGE`;
		
CREATE TABLE `PRIVILEGE` (
  `privilegeId` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `privilege` INTEGER NOT NULL,
  `description` INTEGER NOT NULL,
  PRIMARY KEY (`privilegeId`)
);

-- ---
-- Table 'CLIENTEMPLOYEE'
-- 
-- ---

DROP TABLE IF EXISTS `CLIENTEMPLOYEE`;
		
CREATE TABLE `CLIENTEMPLOYEE` (
  `clientId` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `employeeId` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`clientId`, `employeeId`)
);

-- ---
-- Foreign Keys 
-- ---

ALTER TABLE `CLIENTCOMPANY` ADD FOREIGN KEY (companyId) REFERENCES `COMPANY` (`companyId`);
ALTER TABLE `LOCATION` ADD FOREIGN KEY (companyId) REFERENCES `COMPANY` (`companyId`);
ALTER TABLE `CLIENT` ADD FOREIGN KEY (clientId) REFERENCES `CLIENTCOMPANY` (`clientId`);
ALTER TABLE `CLIENT` ADD FOREIGN KEY (clientId) REFERENCES `CLIENTEMPLOYEE` (`clientId`);
ALTER TABLE `EMPLOYEE` ADD FOREIGN KEY (employeeId) REFERENCES `CLIENTEMPLOYEE` (`employeeId`);
ALTER TABLE `EMPLOYEE` ADD FOREIGN KEY (privilegeId) REFERENCES `PRIVILEGE` (`privilegeId`);

-- ---
-- Table Properties
-- ---

-- ALTER TABLE `COMPANY` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `CLIENTCOMPANY` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `LOCATION` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `CLIENT` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `EMPLOYEE` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `PRIVILEGE` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `CLIENTEMPLOYEE` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---
-- Test Data
-- ---

-- INSERT INTO `COMPANY` (`companyId`,`name`) VALUES
-- ('','');
-- INSERT INTO `CLIENTCOMPANY` (`companyId`,`clientId`) VALUES
-- ('','');
-- INSERT INTO `LOCATION` (`locationId`,`companyId`,`address`) VALUES
-- ('','','');
-- INSERT INTO `CLIENT` (`clientId`,`firstName`,`lastName`) VALUES
-- ('','','');
-- INSERT INTO `EMPLOYEE` (`employeeId`,`privilegeId`,`firstName`,`lastName`,`username`,`password`,`email`,`phoneNumber`,`birthdate`) VALUES
-- ('','','','','','','','','');
-- INSERT INTO `PRIVILEGE` (`privilegeId`,`privilege`,`description`) VALUES
-- ('','','');
-- INSERT INTO `CLIENTEMPLOYEE` (`clientId`,`employeeId`) VALUES
-- ('','');