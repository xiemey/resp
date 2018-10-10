/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : classmanager

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-25 16:49:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `scoId` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_Id` bigint(20) NOT NULL DEFAULT '0',
  `course_Id` bigint(20) NOT NULL DEFAULT '0',
  `scoNum` decimal(10,1) DEFAULT NULL,
  PRIMARY KEY (`scoId`,`student_Id`,`course_Id`),
  KEY `student_Id` (`student_Id`),
  KEY `course_Id` (`course_Id`),
  CONSTRAINT `score_ibfk_1` FOREIGN KEY (`student_Id`) REFERENCES `student` (`stuId`),
  CONSTRAINT `score_ibfk_2` FOREIGN KEY (`course_Id`) REFERENCES `course` (`couId`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('2', '2', '1', '45.0');
INSERT INTO `score` VALUES ('4', '4', '1', '88.0');
INSERT INTO `score` VALUES ('5', '5', '1', '71.0');
INSERT INTO `score` VALUES ('6', '6', '1', '81.0');
INSERT INTO `score` VALUES ('24', '24', '1', '22.0');
INSERT INTO `score` VALUES ('25', '25', '1', '22222.0');
INSERT INTO `score` VALUES ('26', '26', '1', '22.0');
INSERT INTO `score` VALUES ('27', '27', '1', '22.0');
INSERT INTO `score` VALUES ('28', '28', '1', '88.0');
INSERT INTO `score` VALUES ('29', '29', '1', '88.0');
INSERT INTO `score` VALUES ('30', '30', '1', '88.0');
INSERT INTO `score` VALUES ('31', '31', '1', '45.0');
INSERT INTO `score` VALUES ('32', '32', '1', '45.0');
INSERT INTO `score` VALUES ('33', '33', '1', '66.0');
INSERT INTO `score` VALUES ('40', '40', '1', '66.0');
INSERT INTO `score` VALUES ('41', '41', '1', '66.0');
INSERT INTO `score` VALUES ('63', '2', '2', '66.0');
INSERT INTO `score` VALUES ('65', '4', '2', '6.0');
INSERT INTO `score` VALUES ('66', '5', '2', '66.0');
INSERT INTO `score` VALUES ('67', '6', '2', '66.0');
INSERT INTO `score` VALUES ('85', '24', '2', '22.0');
INSERT INTO `score` VALUES ('86', '25', '2', '22.0');
INSERT INTO `score` VALUES ('87', '26', '2', '22.0');
INSERT INTO `score` VALUES ('88', '27', '2', '66.0');
INSERT INTO `score` VALUES ('89', '28', '2', '66.0');
INSERT INTO `score` VALUES ('90', '29', '2', '99.0');
INSERT INTO `score` VALUES ('91', '30', '2', '6.0');
INSERT INTO `score` VALUES ('92', '31', '3', '66.0');
INSERT INTO `score` VALUES ('93', '32', '3', '666.0');
INSERT INTO `score` VALUES ('94', '33', '3', '6.0');
INSERT INTO `score` VALUES ('101', '40', '3', '66.0');
INSERT INTO `score` VALUES ('102', '41', '3', '77.0');
INSERT INTO `score` VALUES ('123', '29', '3', '87.0');
INSERT INTO `score` VALUES ('124', '29', '4', '76.0');
INSERT INTO `score` VALUES ('125', '29', '5', '85.0');
INSERT INTO `score` VALUES ('126', '29', '6', '45.0');
INSERT INTO `score` VALUES ('127', '29', '7', '36.0');
INSERT INTO `score` VALUES ('128', '29', '8', '76.0');
