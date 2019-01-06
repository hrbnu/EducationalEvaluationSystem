/*
Navicat MySQL Data Transfer

Source Server         : hrbnu
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : hrbnu

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-06 12:28:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for submitRequestsForm
-- ----------------------------
DROP TABLE IF EXISTS `submitRequestsForm`;
CREATE TABLE `submitRequestsForm` (
  `Id` int(255) NOT NULL AUTO_INCREMENT,
  `courseId` varchar(255) NOT NULL,
  `teacherId` varchar(255) NOT NULL,
  `examineFlag` tinyint(255) NOT NULL,
  `submitTime` datetime NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_course` (`courseId`),
  KEY `FK_teacher` (`teacherId`),
  CONSTRAINT `FK_course` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_teacher` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`teacherId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of submitRequestsForm
-- ----------------------------
