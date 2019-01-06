/*
Navicat MySQL Data Transfer

Source Server         : hrbnu
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : hrbnu

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-06 12:27:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseId` varchar(255) NOT NULL,
  `courseName` varchar(255) NOT NULL,
  `teacherId` varchar(255) NOT NULL,
  `semester` int(11) NOT NULL,
  `score` double DEFAULT NULL,
  `classification` varchar(255) DEFAULT NULL,
  `courseClass` varchar(255) DEFAULT NULL,
  `startTime` varchar(255) NOT NULL COMMENT '第几周开始',
  `endTime` varchar(255) DEFAULT NULL COMMENT '第几周结束',
  `learnTime` int(255) NOT NULL,
  PRIMARY KEY (`courseId`),
  KEY `course_teacher` (`teacherId`),
  CONSTRAINT `course_teacher` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`teacherId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1016001003', '编译原理1', '1', '6', null, '1', '3', '1', '18', '52');
INSERT INTO `course` VALUES ('1016001004', '数据结构1', '1', '6', null, '1', '3', '1', '9', '26');
INSERT INTO `course` VALUES ('6001005', '课程2', '10', '6', null, '1', '3', '1', '9', '26');
INSERT INTO `course` VALUES ('6001006', '课程3', '5', '4', null, '1', '4', '1', '18', '52');
