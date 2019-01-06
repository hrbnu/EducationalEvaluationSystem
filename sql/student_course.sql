/*
Navicat MySQL Data Transfer

Source Server         : hrbnu
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : hrbnu

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-06 12:28:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `studentId` varchar(255) NOT NULL,
  `courseId` varchar(255) NOT NULL,
  `courseTime` int(11) DEFAULT NULL,
  `history` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`studentId`,`courseId`),
  KEY `courseId` (`courseId`,`studentId`),
  CONSTRAINT `course` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES ('2014020690', '1016001003', '0', '0');
INSERT INTO `student_course` VALUES ('2014020690', '1016001004', '0', '0');
INSERT INTO `student_course` VALUES ('2014020690', '6001006', '20', '1');
