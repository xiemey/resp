/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : classmanager

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-25 16:49:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuId` bigint(20) NOT NULL AUTO_INCREMENT,
  `stuNum` varchar(255) DEFAULT NULL,
  `stuName` varchar(255) DEFAULT NULL,
  `stuSex` varchar(255) DEFAULT NULL,
  `stuBirth` date DEFAULT NULL,
  `stuPwd` varchar(255) DEFAULT NULL,
  `stuPhone` varchar(255) DEFAULT NULL,
  `stuAddress` varchar(255) DEFAULT NULL,
  `clas_Id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`stuId`),
  KEY `clas_Id` (`clas_Id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`clas_Id`) REFERENCES `clas` (`clasId`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1', 'admin', '男', '2018-06-05', 'admin', '123', '23', null);
INSERT INTO `student` VALUES ('2', '20153201', '袁国轩', '男', '1995-10-11', '20142862', '20132905', '信息科学与技术学院', '1');
INSERT INTO `student` VALUES ('4', '20153203', '郑亮亮', '男', '1995-10-13', '20142871', '20142867', '信息科学与技术学院', '1');
INSERT INTO `student` VALUES ('5', '20153204', '胡阳阳', '男', '1995-10-14', '20142878', '20142871', '信息科学与技术学院', '1');
INSERT INTO `student` VALUES ('6', '20153205', '朱继刚', '男', '1995-10-15', '20142894', '20142878', '信息科学与技术学院', '1');
INSERT INTO `student` VALUES ('24', '20153206', '井小普', '女', '1995-11-02', '20142996', '20142992', '信息科学与技术学院', '1');
INSERT INTO `student` VALUES ('25', '20153207', '田会', '男', '1995-11-03', '20142998', '20142996', '信息科学与技术学院', '1');
INSERT INTO `student` VALUES ('26', '20153208', '闫鹏', '男', '1995-11-04', '20143000', '20142998', '信息科学与技术学院', '1');
INSERT INTO `student` VALUES ('27', '20153209', '陈鹏', '男', '1995-11-05', '20143007', '20143000', '信息科学与技术学院', '1');
INSERT INTO `student` VALUES ('28', '20153210', '陈坤明', '男', '1995-11-06', '20143041', '20143007', '信息科学与技术学院', '1');
INSERT INTO `student` VALUES ('29', '20153211', '王思达', '男', '1995-11-07', '20143050', '20143041', '信息科学与技术学院', '1');
INSERT INTO `student` VALUES ('30', '20153212', '杨国力', '男', '1995-11-18', '20143055', '20143050', '信息科学与技术学院', '1');
INSERT INTO `student` VALUES ('31', '20153213', '王占京', '男', '1995-11-05', '20142861', '20142861', '信息科学与技术学院', '2');
INSERT INTO `student` VALUES ('32', '20153214', '杨程鑫', '男', '1995-11-06', '20142863', '20142863', '信息科学与技术学院', '2');
INSERT INTO `student` VALUES ('33', '20153215', '董浩男', '男', '1995-11-07', '20142868', '20142868', '信息科学与技术学院', '2');
INSERT INTO `student` VALUES ('40', '20153216', '何琳琳', '女', '1995-11-06', '20142920', '20142920', '信息科学与技术学院', '2');
INSERT INTO `student` VALUES ('41', '20153217', '高雪彤', '女', '2018-06-11', '20142923', '213214324', '信息科学与技术学院', '2');
