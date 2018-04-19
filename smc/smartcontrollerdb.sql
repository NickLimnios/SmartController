/*
 Navicat Premium Data Transfer

 Source Server         : MAMP
 Source Server Type    : MySQL
 Source Server Version : 50635
 Source Host           : localhost:3306
 Source Schema         : smartcontrollerdb

 Target Server Type    : MySQL
 Target Server Version : 50635
 File Encoding         : 65001

 Date: 20/04/2018 01:40:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for devices
-- ----------------------------
DROP TABLE IF EXISTS `devices`;
CREATE TABLE `devices` (
  `Id` int(10) unsigned NOT NULL,
  `RoomId` int(10) unsigned DEFAULT NULL,
  `ServiceId` int(10) unsigned DEFAULT NULL,
  `TypeId` int(10) unsigned DEFAULT NULL,
  `StatusId` int(10) unsigned DEFAULT NULL,
  `Code` varchar(45) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Information` varchar(45) DEFAULT NULL,
  `Image` blob,
  `IsInactive` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Code_UNIQUE` (`Code`),
  KEY `FK_Devices_Rooms_idx` (`RoomId`),
  KEY `FK_Devices_Services_idx` (`ServiceId`),
  KEY `FK_Devices_Types_idx` (`TypeId`),
  KEY `FK_Devices_Status_idx` (`StatusId`),
  CONSTRAINT `FK_Devices_Rooms` FOREIGN KEY (`RoomId`) REFERENCES `rooms` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Devices_Services` FOREIGN KEY (`ServiceId`) REFERENCES `services` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Devices_Status` FOREIGN KEY (`StatusId`) REFERENCES `devicesstatus` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Devices_Types` FOREIGN KEY (`TypeId`) REFERENCES `devicestypes` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for devicesstatus
-- ----------------------------
DROP TABLE IF EXISTS `devicesstatus`;
CREATE TABLE `devicesstatus` (
  `Id` int(10) unsigned NOT NULL,
  `Code` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Code_UNIQUE` (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for devicestypes
-- ----------------------------
DROP TABLE IF EXISTS `devicestypes`;
CREATE TABLE `devicestypes` (
  `Id` int(10) unsigned NOT NULL,
  `Code` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Code_UNIQUE` (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `Id` int(10) unsigned NOT NULL,
  `Code` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rooms
-- ----------------------------
DROP TABLE IF EXISTS `rooms`;
CREATE TABLE `rooms` (
  `Id` int(10) unsigned NOT NULL,
  `Code` varchar(45) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Code_UNIQUE` (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rooms
-- ----------------------------
BEGIN;
INSERT INTO `rooms` VALUES (1, 'asdfasdf', 'asdfasdf', 'asdfasdfasdfasdf');
COMMIT;

-- ----------------------------
-- Table structure for services
-- ----------------------------
DROP TABLE IF EXISTS `services`;
CREATE TABLE `services` (
  `Id` int(10) unsigned NOT NULL,
  `Url` varchar(45) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Url_UNIQUE` (`Url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `Id` int(10) unsigned NOT NULL,
  `RolesId` int(10) unsigned NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Firstname` varchar(45) NOT NULL,
  `Lastname` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Username_UNIQUE` (`Username`),
  KEY `FK_Users_Roles_idx` (`RolesId`),
  CONSTRAINT `FK_Users_Roles` FOREIGN KEY (`RolesId`) REFERENCES `roles` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for usersdevices
-- ----------------------------
DROP TABLE IF EXISTS `usersdevices`;
CREATE TABLE `usersdevices` (
  `UserId` int(10) unsigned NOT NULL,
  `DeviceId` int(10) unsigned NOT NULL,
  UNIQUE KEY `UserDevice_UNIQUE` (`UserId`,`DeviceId`),
  KEY `FK_UsersDevices_Devices_idx` (`DeviceId`),
  CONSTRAINT `FK_UsersDevices_Devices` FOREIGN KEY (`DeviceId`) REFERENCES `devices` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_UsersDevices_Users` FOREIGN KEY (`UserId`) REFERENCES `users` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
