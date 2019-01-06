/*
Navicat MySQL Data Transfer

Source Server         : hrbnu
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : hrbnu

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-06 12:27:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `courseId` varchar(255) NOT NULL,
  `evaluateContent` varchar(255) DEFAULT NULL,
  `evaluateScore` double DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL COMMENT '1学生2督导3领导4教师5是学生历史评价',
  `flagId` varchar(255) NOT NULL,
  `alreadyEvaluate` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES ('1', '201603001', '这个课很好。', '85', '1', '2016040001', null);
INSERT INTO `evaluate` VALUES ('3', '201603001', '好', '85', '2', '100101', null);
INSERT INTO `evaluate` VALUES ('4', '201603001', '好', '90', '2', '100102', null);
INSERT INTO `evaluate` VALUES ('5', '201603001', '好', '95', '3', '100103', null);
INSERT INTO `evaluate` VALUES ('6', '201803001', '还不错哦', '64', '1', '2018080234', null);
INSERT INTO `evaluate` VALUES ('7', '201803001', '咯咯llll', '90', '1', '2018080234', null);
INSERT INTO `evaluate` VALUES ('8', '201803001', '还不错哦', '100', '1', '2018080234', null);
INSERT INTO `evaluate` VALUES ('9', '201603001', '还不错哦', '10', '1', '2016040001', null);
INSERT INTO `evaluate` VALUES ('10', '201603003', '好', '10', '1', '2016020755', null);
INSERT INTO `evaluate` VALUES ('11', '201603004', '好', '100', '1', '2016020755', null);
INSERT INTO `evaluate` VALUES ('12', '201603003', '讲的很号', '100', '2', '100101', null);
INSERT INTO `evaluate` VALUES ('13', '201603003', '好', '100', '3', '100103', null);
INSERT INTO `evaluate` VALUES ('14', '201603001', '这个课我就是不喜欢。', '10', '1', '2016040001', null);
INSERT INTO `evaluate` VALUES ('15', '201603001', '还不错哦', '6', '4', '100100', null);
INSERT INTO `evaluate` VALUES ('16', '201603001', '很好', '10', '1', '2016040001', null);
INSERT INTO `evaluate` VALUES ('17', '201603001', '我暗恋这个老师好久了', '6', '4', '100100', null);
INSERT INTO `evaluate` VALUES ('18', '201603001', 'lll', '10', '1', '2016040001', null);
INSERT INTO `evaluate` VALUES ('19', '201603001', '咯咯llll', '12', '1', '2016040001', null);
INSERT INTO `evaluate` VALUES ('20', '201603001', '这个课我就是不喜欢。', '8', '4', '100100', null);
INSERT INTO `evaluate` VALUES ('22', '201603001', '咯咯llll', '8', '4', '100100', null);
INSERT INTO `evaluate` VALUES ('30', '201603005', '号', '11', '3', '100100', null);
INSERT INTO `evaluate` VALUES ('31', '201603006', null, '0', '2', '100100', '0');
INSERT INTO `evaluate` VALUES ('32', '201603003', null, '0', '2', '100100', '0');
INSERT INTO `evaluate` VALUES ('33', '201603003', null, '0', '2', '100100', '0');
INSERT INTO `evaluate` VALUES ('34', '201603003', null, '0', '2', '100100', '0');
INSERT INTO `evaluate` VALUES ('35', '201603003', null, '0', '2', '100100', '0');
INSERT INTO `evaluate` VALUES ('64', '201603006', null, '0', '2', '100100', '0');
INSERT INTO `evaluate` VALUES ('65', '201603006', null, '0', '2', '100100', '0');
INSERT INTO `evaluate` VALUES ('66', '1016001003', null, '0', '2', '10', '0');
INSERT INTO `evaluate` VALUES ('67', '', 'kjjkdsfa', '20', '2', '10', '0');
INSERT INTO `evaluate` VALUES ('68', '6001006', 'dfsjaka', '24', '5', '2014020690', '0');
