/*
Navicat MySQL Data Transfer

Source Server         : book
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : xuqiu

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-04-12 16:57:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hangye
-- ----------------------------
DROP TABLE IF EXISTS `hangye`;
CREATE TABLE `hangye` (
  `name` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hangye
-- ----------------------------
INSERT INTO `hangye` VALUES ('医药', '1');
INSERT INTO `hangye` VALUES ('It', '2');
INSERT INTO `hangye` VALUES ('老师', '3');
INSERT INTO `hangye` VALUES ('经理', '4');
INSERT INTO `hangye` VALUES ('公务员', '5');

-- ----------------------------
-- Table structure for quanxian
-- ----------------------------
DROP TABLE IF EXISTS `quanxian`;
CREATE TABLE `quanxian` (
  `juese` varchar(255) DEFAULT NULL,
  `tianbao` int(2) DEFAULT NULL,
  `chakangerenshenhexuqiu` int(2) DEFAULT NULL,
  `chakanquanbushenhexuqiu` int(2) DEFAULT NULL,
  `xuqiuxiugai` int(2) DEFAULT NULL,
  `chakanquanbu` int(2) DEFAULT NULL,
  `chakangeren` int(2) DEFAULT NULL,
  `chakantuihui` int(2) DEFAULT NULL,
  `shenhexuqiu` int(2) DEFAULT NULL,
  `chakanuser` int(2) DEFAULT NULL,
  `xinxixiugai` int(2) DEFAULT NULL,
  `mimaxiugai` int(2) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of quanxian
-- ----------------------------
INSERT INTO `quanxian` VALUES ('用户', '1', '1', '0', '0', '0', '1', '1', '0', '0', '1', '1', '1', null);
INSERT INTO `quanxian` VALUES ('管理员', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '57', null);

-- ----------------------------
-- Table structure for tuihui
-- ----------------------------
DROP TABLE IF EXISTS `tuihui`;
CREATE TABLE `tuihui` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zhengjiid` int(11) DEFAULT NULL,
  `tuihui` text,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tuihui
-- ----------------------------
INSERT INTO `tuihui` VALUES ('1', '29', '字写的不好');
INSERT INTO `tuihui` VALUES ('2', '33', '333');
INSERT INTO `tuihui` VALUES ('3', '34', '56664');
INSERT INTO `tuihui` VALUES ('4', '35', 'ggggggg');
INSERT INTO `tuihui` VALUES ('5', '26', '6666');
INSERT INTO `tuihui` VALUES ('6', '25', '555');
INSERT INTO `tuihui` VALUES ('7', '24', '555');
INSERT INTO `tuihui` VALUES ('8', '37', '6');
INSERT INTO `tuihui` VALUES ('9', '38', '6');
INSERT INTO `tuihui` VALUES ('10', '45', '98/6/96');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `shenfenhao` varchar(255) DEFAULT NULL,
  `shi` varchar(255) DEFAULT NULL,
  `danwei` varchar(255) DEFAULT NULL,
  `zhuanye` varchar(255) DEFAULT NULL,
  `hangye` varchar(255) DEFAULT NULL,
  `jiaoyu` varchar(255) DEFAULT NULL,
  `zhicheng` varchar(255) DEFAULT NULL,
  `tongxundizhi` varchar(255) DEFAULT NULL,
  `youzhengbianma` varchar(255) DEFAULT NULL,
  `shouji` varchar(255) DEFAULT NULL,
  `dianhua` varchar(255) DEFAULT NULL,
  `youxiang` varchar(255) DEFAULT NULL,
  `shenfen` varchar(255) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '20153268', '田会', '130626199605094879', '石家庄市', '百度', 'IT', '工程师', '本科', '董事长', '河北', '072650', '13663322632', '6994458', '493795071@qq.com', '管理员');
INSERT INTO `user` VALUES ('5', 'tianhui', '20153268', '田会', '130626199605094879', '承德市', '大学', '软件工程师', '计算机', '大学', '实习', '河北省', '072650', '13663322631', '6993332', '493795071@qq.com', '用户');
INSERT INTO `user` VALUES ('10', '123456', '123456', '张三', '130626199605094879', '石家庄市', '公司', '工程师', '计算机', '大学', '学生', '河北省石家庄', '072650', '13663322631', '6994858', '493795071@qq.com', '管理员');
INSERT INTO `user` VALUES ('12', '493795071', '196521', null, null, null, null, null, '铁路', null, '实习生', null, null, null, '6994850', null, '管理员');

-- ----------------------------
-- Table structure for xueke
-- ----------------------------
DROP TABLE IF EXISTS `xueke`;
CREATE TABLE `xueke` (
  `name` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xueke
-- ----------------------------
INSERT INTO `xueke` VALUES ('语文', '1');
INSERT INTO `xueke` VALUES ('数学', '2');
INSERT INTO `xueke` VALUES ('英语', '3');
INSERT INTO `xueke` VALUES ('化学', '4');
INSERT INTO `xueke` VALUES ('美术', '5');

-- ----------------------------
-- Table structure for zhengji
-- ----------------------------
DROP TABLE IF EXISTS `zhengji`;
CREATE TABLE `zhengji` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jiname` varchar(255) DEFAULT NULL,
  `guikou` varchar(255) DEFAULT NULL,
  `tongxundizhi` varchar(255) DEFAULT NULL,
  `suozaidiyu` varchar(255) DEFAULT NULL,
  `wangzhi` varchar(255) DEFAULT NULL,
  `dianzixinxiang` varchar(255) DEFAULT NULL,
  `farendaibiao` varchar(255) DEFAULT NULL,
  `youzhengbianma` varchar(255) DEFAULT NULL,
  `lianxi` varchar(255) DEFAULT NULL,
  `dianhua` varchar(255) DEFAULT NULL,
  `shouji` varchar(255) DEFAULT NULL,
  `chuangzhen` varchar(255) DEFAULT NULL,
  `jigoushuxing` varchar(255) DEFAULT NULL,
  `jigoujianjie` text,
  `jishuxuqiuname` varchar(255) DEFAULT NULL,
  `xuqiuqianyear` varchar(255) DEFAULT NULL,
  `xuqiuhouyear` varchar(255) DEFAULT NULL,
  `xuqiugaishu` text,
  `guanjian1` text,
  `guanjian2` text,
  `guanjian3` text,
  `guanjian4` text,
  `guanjian5` text,
  `jine` varchar(255) DEFAULT NULL,
  `xuqiujiejuefangshi` varchar(255) DEFAULT NULL,
  `hezuodanwei` varchar(255) DEFAULT NULL,
  `kejihuodongleixing` varchar(255) DEFAULT NULL,
  `xuekenfenlei` varchar(255) DEFAULT NULL,
  `lingyu` varchar(255) DEFAULT NULL,
  `hangye` varchar(255) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `twoxueke` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  `createdate` datetime DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zhengji
-- ----------------------------
INSERT INTO `zhengji` VALUES ('45', '微软', '中国', '河北省石家庄', '石家庄市', '', '493795071@qq.com', '田会', '072650', '张三', '6994858', '13663322631', '', '企业', '综合实力强大的软件公司', '软件设计', '2018-1-11', '2018-1-31', '解决用户的需求', '1', '2', '3', '4', '5', '2', '独立开发', '石家庄铁道大学', '应用研究', '0', '电子信息', '0', '10', 'null', '3', '2018-01-11 22:27:40');
INSERT INTO `zhengji` VALUES ('46', '大学', '', '河北省', '承德市', '', '493795071@qq.com', '李四', '072650', '田会', '6993332', '13663322631', '', '研究机构', '石家庄铁道大学', '软件构造', '2018-1-12', '2018-1-31', '解决用户问题', '4', '5', '6', '7', '8', '5', '独立开发', '石家庄铁道大学', '应用研究', '2', '电子信息', '4', '5', 'null', '2', '2018-01-12 08:27:43');
