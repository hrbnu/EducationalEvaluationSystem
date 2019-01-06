/*
Navicat MySQL Data Transfer

Source Server         : hrbnu
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : hrbnu

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-06 12:28:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacherId` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `teacherName` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `myselfEvaluateContent` varchar(255) DEFAULT NULL,
  `myselfEvaluateScore` double DEFAULT NULL,
  `helpTeacherName` varchar(255) DEFAULT NULL,
  `accepterTeacherName` varchar(255) DEFAULT NULL,
  `helpTeacherId` varchar(255) DEFAULT NULL,
  `accepterTeacherId` varchar(255) DEFAULT NULL,
  `teacherType` tinyint(255) NOT NULL,
  `leaderType` tinyint(255) NOT NULL,
  `monitorType` tinyint(255) NOT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `idCard` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '150012', '于延', null, null, null, null, null, null, null, '1', '1', '1', '2018-12-26 10:36:50', '410326196904150012');
INSERT INTO `teacher` VALUES ('10', '150012', '刘月兰', null, null, null, null, null, null, null, '1', '0', '0', '2018-12-26 10:20:11', '410326196904150012');
INSERT INTO `teacher` VALUES ('11', '150012', '张珑', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('12', '150012', '丁金凤', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('13', '150012', '张军', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('14', '150012', '付伟', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('15', '150012', '赵国生', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('16', '150012', '孙惠杰', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('17', '150012', '赵润东', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('18', '150012', '刘玉喜', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('19', '150012', '魏洪伟', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('2', '150012', '杨巨庆', null, null, null, null, null, null, null, '1', '1', '1', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('20', '150012', '黄玉妍', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('21', '150012', '肖鑫', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('22', '150012', '韩贤东', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('23', '150012', '季伟东', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('24', '150012', '蒋本天', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('25', '150012', '邸佳奇', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('26', '150012', '刘仁辉', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('27', '150012', '张明宇', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('28', '150012', '周国辉', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('29', '150012', '段喜萍', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('3', '150012', '李英梅', null, null, null, null, null, null, null, '1', '1', '1', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('30', '150012', '于丹', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('31', '150012', '赵国祥', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('32', '150012', '范雪琴', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('33', '150012', '常骥', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('34', '150012', '黄春梅', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('35', '150012', '姜春茂', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('36', '150012', '李志聪', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('37', '150012', '李峻灵', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('38', '150012', '李世明', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('39', '150012', '马瑞华', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('4', '150012', '邢恺', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('40', '150012', '倪蕴涛', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('41', '150012', '宋春雨', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('42', '150012', '王明华', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('43', '150012', '夏晓冬', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('44', '150012', '周英', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('45', '150012', '赵丽君', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('46', '150012', '张英俊', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('47', '150012', '樊丽梅', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('48', '150012', '伊波', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('49', '150012', '于晓红', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('5', '150012', '伦立军', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('50', '150012', '常晓娟', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('51', '150012', '贾成伟', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('52', '150012', '姜伟', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('53', '150012', '李红宇', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('54', '150012', '王冬', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('55', '150012', '王修林', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('56', '150012', '王秀珍', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('57', '150012', '姚艳雪', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('58', '150012', '吴瑕', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('59', '150012', '廖祎玮', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('6', '150012', '李晶', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('60', '150012', '张立君', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('61', '150012', '石晔琼', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('62', '150012', '尹启天', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('63', '150012', '何立晖', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('64', '150012', '吴雪', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('65', '150012', '张广玲', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('66', '150012', '王金江', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('67', '150012', '韩煦', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('68', '150012', '赵丽', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('69', '150012', '李玉霞', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('7', '150012', '任伟', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('70', '150012', '王洪侠', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('71', '150012', '赵微', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('72', '150012', '崔艳玲', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('73', '150012', '林琳', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('74', '150012', '马宁', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('75', '150012', '刁衣非', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('76', '150012', '付宝君', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('77', '150012', '贺裕', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('78', '150012', '张伟', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('79', '150012', '刘明宇', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('8', '150012', '孙鹏飞', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('80', '150012', '邵晶波', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('81', '150012', '丁云鸿', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('82', '150012', '刘靖宇', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('83', '150012', '朱海龙', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('84', '150012', '杜军', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('85', '150012', '边奕心', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('86', '150012', '姜涛', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('87', '150012', '翟德斌', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('88', '150012', '朱晓', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('89', '150012', '于梦', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('9', '150012', '赵松', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('90', '150012', '韩雷', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('91', '150012', '李锐', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
INSERT INTO `teacher` VALUES ('92', '150012', '刘琪', null, null, null, null, null, null, null, '1', '0', '0', '1970-01-01 08:00:00', '410326196904150012');
