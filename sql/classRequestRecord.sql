/*
Navicat MySQL Data Transfer

Source Server         : hrbnu
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : hrbnu

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-06 12:27:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for classRequestRecord
-- ----------------------------
DROP TABLE IF EXISTS `classRequestRecord`;
CREATE TABLE `classRequestRecord` (
  `isListenedTeacherId` varchar(255) NOT NULL,
  `teacherId` varchar(255) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` varchar(255) NOT NULL,
  `confirmed` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacherId` (`teacherId`),
  KEY `courseId` (`courseId`),
  KEY `temp3` (`isListenedTeacherId`),
  CONSTRAINT `classRequestRecord_ibfk_1` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`teacherId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `classRequestRecord_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `temp3` FOREIGN KEY (`isListenedTeacherId`) REFERENCES `teacher` (`teacherId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classRequestRecord
-- ----------------------------
INSERT INTO `classRequestRecord` VALUES ('1', '10', '20', '1016001003', '1');
