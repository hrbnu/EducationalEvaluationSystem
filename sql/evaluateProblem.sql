/*
Navicat MySQL Data Transfer

Source Server         : hrbnu
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : hrbnu

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-06 12:28:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for evaluateProblem
-- ----------------------------
DROP TABLE IF EXISTS `evaluateProblem`;
CREATE TABLE `evaluateProblem` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '该条评价的id',
  `evaluateProblemContent` varchar(255) NOT NULL COMMENT '评价的问题',
  `forWho` int(255) NOT NULL COMMENT '用来问谁的评价问题，教师，学生，领导，督导',
  `score` int(255) NOT NULL COMMENT '用来存这道题对应的分数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluateProblem
-- ----------------------------
INSERT INTO `evaluateProblem` VALUES ('1', '这个老师上课打电话吗？', '1', '20');
INSERT INTO `evaluateProblem` VALUES ('2', '这个老师上课有课件吗？', '1', '20');
INSERT INTO `evaluateProblem` VALUES ('3', '这个老师讲课关注学生吗？', '1', '20');
INSERT INTO `evaluateProblem` VALUES ('4', '这个老师上课有激情吗？', '1', '20');
INSERT INTO `evaluateProblem` VALUES ('5', '你认为这个老师上课课件做的怎么样？', '1', '20');
INSERT INTO `evaluateProblem` VALUES ('6', '你认为这个老师的讲课方式怎么样？', '0', '20');
INSERT INTO `evaluateProblem` VALUES ('7', '你认为这个老师上课讲的知识透彻吗？', '0', '20');
INSERT INTO `evaluateProblem` VALUES ('8', '这个老师讲课专注吗？', '0', '20');
INSERT INTO `evaluateProblem` VALUES ('9', '这个老师作业布置的怎么样？', '0', '20');
INSERT INTO `evaluateProblem` VALUES ('10', 'tercher', '0', '20');
