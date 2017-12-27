/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : jfinal_memo

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-12-27 21:40:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `content` mediumtext NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=257 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `module` varchar(255) DEFAULT NULL,
  `ext` varchar(255) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=386 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file
-- ----------------------------

-- ----------------------------
-- Table structure for memo
-- ----------------------------
DROP TABLE IF EXISTS `memo`;
CREATE TABLE `memo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `content` mediumtext NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of memo
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `sign` varchar(255) DEFAULT NULL,
  `experience` varchar(255) DEFAULT NULL,
  `score` varchar(255) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('153', 'username1', 'password1', 'nickname1', 'sex1', 'sign1', 'experience1', 'score1', '2017-12-27 21:40:36', '2017-12-27 21:40:36');
INSERT INTO `user` VALUES ('154', 'username2', 'password2', 'nickname2', 'sex2', 'sign2', 'experience2', 'score2', '2017-12-27 21:40:36', '2017-12-27 21:40:36');
INSERT INTO `user` VALUES ('155', 'username3', 'password3', 'nickname3', 'sex3', 'sign3', 'experience3', 'score3', '2017-12-27 21:40:36', '2017-12-27 21:40:36');
INSERT INTO `user` VALUES ('156', 'username4', 'password4', 'nickname4', 'sex4', 'sign4', 'experience4', 'score4', '2017-12-27 21:40:36', '2017-12-27 21:40:36');
INSERT INTO `user` VALUES ('157', 'username5', 'password5', 'nickname5', 'sex5', 'sign5', 'experience5', 'score5', '2017-12-27 21:40:36', '2017-12-27 21:40:36');
INSERT INTO `user` VALUES ('158', 'username6', 'password6', 'nickname6', 'sex6', 'sign6', 'experience6', 'score6', '2017-12-27 21:40:36', '2017-12-27 21:40:36');
INSERT INTO `user` VALUES ('159', 'username7', 'password7', 'nickname7', 'sex7', 'sign7', 'experience7', 'score7', '2017-12-27 21:40:36', '2017-12-27 21:40:36');
INSERT INTO `user` VALUES ('160', 'username8', 'password8', 'nickname8', 'sex8', 'sign8', 'experience8', 'score8', '2017-12-27 21:40:36', '2017-12-27 21:40:36');
INSERT INTO `user` VALUES ('161', 'username9', 'password9', 'nickname9', 'sex9', 'sign9', 'experience9', 'score9', '2017-12-27 21:40:37', '2017-12-27 21:40:37');
INSERT INTO `user` VALUES ('162', 'username10', 'password10', 'nickname10', 'sex10', 'sign10', 'experience10', 'score10', '2017-12-27 21:40:37', '2017-12-27 21:40:37');
INSERT INTO `user` VALUES ('163', 'username11', 'password11', 'nickname11', 'sex11', 'sign11', 'experience11', 'score11', '2017-12-27 21:40:37', '2017-12-27 21:40:37');
INSERT INTO `user` VALUES ('164', 'username12', 'password12', 'nickname12', 'sex12', 'sign12', 'experience12', 'score12', '2017-12-27 21:40:37', '2017-12-27 21:40:37');
INSERT INTO `user` VALUES ('165', 'username13', 'password13', 'nickname13', 'sex13', 'sign13', 'experience13', 'score13', '2017-12-27 21:40:37', '2017-12-27 21:40:37');
INSERT INTO `user` VALUES ('166', 'username14', 'password14', 'nickname14', 'sex14', 'sign14', 'experience14', 'score14', '2017-12-27 21:40:37', '2017-12-27 21:40:37');
INSERT INTO `user` VALUES ('167', 'username15', 'password15', 'nickname15', 'sex15', 'sign15', 'experience15', 'score15', '2017-12-27 21:40:37', '2017-12-27 21:40:37');
INSERT INTO `user` VALUES ('168', 'username16', 'password16', 'nickname16', 'sex16', 'sign16', 'experience16', 'score16', '2017-12-27 21:40:37', '2017-12-27 21:40:37');
INSERT INTO `user` VALUES ('169', 'username17', 'password17', 'nickname17', 'sex17', 'sign17', 'experience17', 'score17', '2017-12-27 21:40:37', '2017-12-27 21:40:37');
INSERT INTO `user` VALUES ('170', 'username18', 'password18', 'nickname18', 'sex18', 'sign18', 'experience18', 'score18', '2017-12-27 21:40:37', '2017-12-27 21:40:37');
INSERT INTO `user` VALUES ('171', 'username19', 'password19', 'nickname19', 'sex19', 'sign19', 'experience19', 'score19', '2017-12-27 21:40:37', '2017-12-27 21:40:37');
INSERT INTO `user` VALUES ('172', 'username20', 'password20', 'nickname20', 'sex20', 'sign20', 'experience20', 'score20', '2017-12-27 21:40:37', '2017-12-27 21:40:37');
INSERT INTO `user` VALUES ('173', 'username21', 'password21', 'nickname21', 'sex21', 'sign21', 'experience21', 'score21', '2017-12-27 21:40:37', '2017-12-27 21:40:37');
INSERT INTO `user` VALUES ('174', 'username22', 'password22', 'nickname22', 'sex22', 'sign22', 'experience22', 'score22', '2017-12-27 21:40:37', '2017-12-27 21:40:37');
INSERT INTO `user` VALUES ('175', 'username23', 'password23', 'nickname23', 'sex23', 'sign23', 'experience23', 'score23', '2017-12-27 21:40:38', '2017-12-27 21:40:38');
INSERT INTO `user` VALUES ('176', 'username24', 'password24', 'nickname24', 'sex24', 'sign24', 'experience24', 'score24', '2017-12-27 21:40:38', '2017-12-27 21:40:38');
INSERT INTO `user` VALUES ('177', 'username25', 'password25', 'nickname25', 'sex25', 'sign25', 'experience25', 'score25', '2017-12-27 21:40:38', '2017-12-27 21:40:38');
INSERT INTO `user` VALUES ('178', 'username26', 'password26', 'nickname26', 'sex26', 'sign26', 'experience26', 'score26', '2017-12-27 21:40:38', '2017-12-27 21:40:38');
INSERT INTO `user` VALUES ('179', 'username27', 'password27', 'nickname27', 'sex27', 'sign27', 'experience27', 'score27', '2017-12-27 21:40:38', '2017-12-27 21:40:38');
INSERT INTO `user` VALUES ('180', 'username28', 'password28', 'nickname28', 'sex28', 'sign28', 'experience28', 'score28', '2017-12-27 21:40:38', '2017-12-27 21:40:38');
INSERT INTO `user` VALUES ('181', 'username29', 'password29', 'nickname29', 'sex29', 'sign29', 'experience29', 'score29', '2017-12-27 21:40:38', '2017-12-27 21:40:38');
INSERT INTO `user` VALUES ('182', 'username30', 'password30', 'nickname30', 'sex30', 'sign30', 'experience30', 'score30', '2017-12-27 21:40:38', '2017-12-27 21:40:38');
