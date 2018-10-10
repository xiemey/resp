/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : classmanager

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-25 16:49:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `couId` bigint(20) NOT NULL AUTO_INCREMENT,
  `couNum` varchar(255) DEFAULT NULL,
  `couName` varchar(255) DEFAULT NULL,
  `couPro` varchar(255) DEFAULT NULL,
  `couCre` decimal(10,1) DEFAULT NULL,
  PRIMARY KEY (`couId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '111111', 'Java', '选修', '2.5');
INSERT INTO `course` VALUES ('2', '222222', 'C语言', '学位', '2.0');
INSERT INTO `course` VALUES ('3', '333333', '移动应用开发', '选修', '2.0');
INSERT INTO `course` VALUES ('4', '444444', '计算机网络', '必修', '3.0');
INSERT INTO `course` VALUES ('5', '555555', '操作系统', '必修', '2.5');
INSERT INTO `course` VALUES ('6', '666666', '编译原理', '学位', '3.5');
INSERT INTO `course` VALUES ('7', '777777', '软件体系架构', '学位', '3.0');
INSERT INTO `course` VALUES ('8', '888888', '软件过程与管理', '选修', '2.0');
