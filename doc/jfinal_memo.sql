/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : jfinal_memo

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-12-27 22:10:01
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
) ENGINE=InnoDB AUTO_INCREMENT=287 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('257', 'title1', 'content1', '2017-12-27 21:45:51', '2017-12-27 21:45:51');
INSERT INTO `blog` VALUES ('258', 'title2', 'content2', '2017-12-27 21:45:51', '2017-12-27 21:45:51');
INSERT INTO `blog` VALUES ('259', 'title3', 'content3', '2017-12-27 21:45:51', '2017-12-27 21:45:51');
INSERT INTO `blog` VALUES ('260', 'title4', 'content4', '2017-12-27 21:45:51', '2017-12-27 21:45:51');
INSERT INTO `blog` VALUES ('261', 'title5', 'content5', '2017-12-27 21:45:51', '2017-12-27 21:45:51');
INSERT INTO `blog` VALUES ('262', 'title6', 'content6', '2017-12-27 21:45:51', '2017-12-27 21:45:51');
INSERT INTO `blog` VALUES ('263', 'title7', 'content7', '2017-12-27 21:45:51', '2017-12-27 21:45:51');
INSERT INTO `blog` VALUES ('264', 'title8', 'content8', '2017-12-27 21:45:51', '2017-12-27 21:45:51');
INSERT INTO `blog` VALUES ('265', 'title9', 'content9', '2017-12-27 21:45:51', '2017-12-27 21:45:51');
INSERT INTO `blog` VALUES ('266', 'title10', 'content10', '2017-12-27 21:45:51', '2017-12-27 21:45:51');
INSERT INTO `blog` VALUES ('267', 'title11', 'content11', '2017-12-27 21:45:51', '2017-12-27 21:45:51');
INSERT INTO `blog` VALUES ('268', 'title12', 'content12', '2017-12-27 21:45:51', '2017-12-27 21:45:51');
INSERT INTO `blog` VALUES ('269', 'title13', 'content13', '2017-12-27 21:45:51', '2017-12-27 21:45:51');
INSERT INTO `blog` VALUES ('270', 'title14', 'content14', '2017-12-27 21:45:51', '2017-12-27 21:45:51');
INSERT INTO `blog` VALUES ('271', 'title15', 'content15', '2017-12-27 21:45:52', '2017-12-27 21:45:52');
INSERT INTO `blog` VALUES ('272', 'title16', 'content16', '2017-12-27 21:45:52', '2017-12-27 21:45:52');
INSERT INTO `blog` VALUES ('273', 'title17', 'content17', '2017-12-27 21:45:52', '2017-12-27 21:45:52');
INSERT INTO `blog` VALUES ('274', 'title18', 'content18', '2017-12-27 21:45:52', '2017-12-27 21:45:52');
INSERT INTO `blog` VALUES ('275', 'title19', 'content19', '2017-12-27 21:45:52', '2017-12-27 21:45:52');
INSERT INTO `blog` VALUES ('276', 'title20', 'content20', '2017-12-27 21:45:52', '2017-12-27 21:45:52');
INSERT INTO `blog` VALUES ('277', 'title21', 'content21', '2017-12-27 21:45:52', '2017-12-27 21:45:52');
INSERT INTO `blog` VALUES ('278', 'title22', 'content22', '2017-12-27 21:45:52', '2017-12-27 21:45:52');
INSERT INTO `blog` VALUES ('279', 'title23', 'content23', '2017-12-27 21:45:52', '2017-12-27 21:45:52');
INSERT INTO `blog` VALUES ('280', 'title24', 'content24', '2017-12-27 21:45:52', '2017-12-27 21:45:52');
INSERT INTO `blog` VALUES ('281', 'title25', 'content25', '2017-12-27 21:45:52', '2017-12-27 21:45:52');
INSERT INTO `blog` VALUES ('282', 'title26', 'content26', '2017-12-27 21:45:52', '2017-12-27 21:45:52');
INSERT INTO `blog` VALUES ('283', 'title27', 'content27', '2017-12-27 21:45:52', '2017-12-27 21:45:52');
INSERT INTO `blog` VALUES ('284', 'title28', 'content28', '2017-12-27 21:45:52', '2017-12-27 21:45:52');
INSERT INTO `blog` VALUES ('285', 'title29', 'content29', '2017-12-27 21:45:52', '2017-12-27 21:45:52');
INSERT INTO `blog` VALUES ('286', 'title30', 'content30', '2017-12-27 21:45:52', '2017-12-27 21:45:52');

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
) ENGINE=InnoDB AUTO_INCREMENT=416 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('386', 'name1', 'url1', 'category1', 'module1', 'ext1', '2017-12-27 21:45:46', '2017-12-27 21:45:46');
INSERT INTO `file` VALUES ('387', 'name2', 'url2', 'category2', 'module2', 'ext2', '2017-12-27 21:45:46', '2017-12-27 21:45:46');
INSERT INTO `file` VALUES ('388', 'name3', 'url3', 'category3', 'module3', 'ext3', '2017-12-27 21:45:46', '2017-12-27 21:45:46');
INSERT INTO `file` VALUES ('389', 'name4', 'url4', 'category4', 'module4', 'ext4', '2017-12-27 21:45:46', '2017-12-27 21:45:46');
INSERT INTO `file` VALUES ('390', 'name5', 'url5', 'category5', 'module5', 'ext5', '2017-12-27 21:45:46', '2017-12-27 21:45:46');
INSERT INTO `file` VALUES ('391', 'name6', 'url6', 'category6', 'module6', 'ext6', '2017-12-27 21:45:46', '2017-12-27 21:45:46');
INSERT INTO `file` VALUES ('392', 'name7', 'url7', 'category7', 'module7', 'ext7', '2017-12-27 21:45:46', '2017-12-27 21:45:46');
INSERT INTO `file` VALUES ('393', 'name8', 'url8', 'category8', 'module8', 'ext8', '2017-12-27 21:45:46', '2017-12-27 21:45:46');
INSERT INTO `file` VALUES ('394', 'name9', 'url9', 'category9', 'module9', 'ext9', '2017-12-27 21:45:47', '2017-12-27 21:45:47');
INSERT INTO `file` VALUES ('395', 'name10', 'url10', 'category10', 'module10', 'ext10', '2017-12-27 21:45:47', '2017-12-27 21:45:47');
INSERT INTO `file` VALUES ('396', 'name11', 'url11', 'category11', 'module11', 'ext11', '2017-12-27 21:45:47', '2017-12-27 21:45:47');
INSERT INTO `file` VALUES ('397', 'name12', 'url12', 'category12', 'module12', 'ext12', '2017-12-27 21:45:47', '2017-12-27 21:45:47');
INSERT INTO `file` VALUES ('398', 'name13', 'url13', 'category13', 'module13', 'ext13', '2017-12-27 21:45:47', '2017-12-27 21:45:47');
INSERT INTO `file` VALUES ('399', 'name14', 'url14', 'category14', 'module14', 'ext14', '2017-12-27 21:45:47', '2017-12-27 21:45:47');
INSERT INTO `file` VALUES ('400', 'name15', 'url15', 'category15', 'module15', 'ext15', '2017-12-27 21:45:47', '2017-12-27 21:45:47');
INSERT INTO `file` VALUES ('401', 'name16', 'url16', 'category16', 'module16', 'ext16', '2017-12-27 21:45:47', '2017-12-27 21:45:47');
INSERT INTO `file` VALUES ('402', 'name17', 'url17', 'category17', 'module17', 'ext17', '2017-12-27 21:45:47', '2017-12-27 21:45:47');
INSERT INTO `file` VALUES ('403', 'name18', 'url18', 'category18', 'module18', 'ext18', '2017-12-27 21:45:47', '2017-12-27 21:45:47');
INSERT INTO `file` VALUES ('404', 'name19', 'url19', 'category19', 'module19', 'ext19', '2017-12-27 21:45:47', '2017-12-27 21:45:47');
INSERT INTO `file` VALUES ('405', 'name20', 'url20', 'category20', 'module20', 'ext20', '2017-12-27 21:45:48', '2017-12-27 21:45:48');
INSERT INTO `file` VALUES ('406', 'name21', 'url21', 'category21', 'module21', 'ext21', '2017-12-27 21:45:48', '2017-12-27 21:45:48');
INSERT INTO `file` VALUES ('407', 'name22', 'url22', 'category22', 'module22', 'ext22', '2017-12-27 21:45:48', '2017-12-27 21:45:48');
INSERT INTO `file` VALUES ('408', 'name23', 'url23', 'category23', 'module23', 'ext23', '2017-12-27 21:45:48', '2017-12-27 21:45:48');
INSERT INTO `file` VALUES ('409', 'name24', 'url24', 'category24', 'module24', 'ext24', '2017-12-27 21:45:48', '2017-12-27 21:45:48');
INSERT INTO `file` VALUES ('410', 'name25', 'url25', 'category25', 'module25', 'ext25', '2017-12-27 21:45:48', '2017-12-27 21:45:48');
INSERT INTO `file` VALUES ('411', 'name26', 'url26', 'category26', 'module26', 'ext26', '2017-12-27 21:45:48', '2017-12-27 21:45:48');
INSERT INTO `file` VALUES ('412', 'name27', 'url27', 'category27', 'module27', 'ext27', '2017-12-27 21:45:48', '2017-12-27 21:45:48');
INSERT INTO `file` VALUES ('413', 'name28', 'url28', 'category28', 'module28', 'ext28', '2017-12-27 21:45:48', '2017-12-27 21:45:48');
INSERT INTO `file` VALUES ('414', 'name29', 'url29', 'category29', 'module29', 'ext29', '2017-12-27 21:45:48', '2017-12-27 21:45:48');
INSERT INTO `file` VALUES ('415', 'name30', 'url30', 'category30', 'module30', 'ext30', '2017-12-27 21:45:48', '2017-12-27 21:45:48');

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
) ENGINE=InnoDB AUTO_INCREMENT=180 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of memo
-- ----------------------------
INSERT INTO `memo` VALUES ('150', 'title1', 'content1', 'category1', 'user1', '2017-12-27 21:45:53', '2017-12-27 21:45:53');
INSERT INTO `memo` VALUES ('151', 'title2', 'content2', 'category2', 'user2', '2017-12-27 21:45:53', '2017-12-27 21:45:53');
INSERT INTO `memo` VALUES ('152', 'title3', 'content3', 'category3', 'user3', '2017-12-27 21:45:53', '2017-12-27 21:45:53');
INSERT INTO `memo` VALUES ('153', 'title4', 'content4', 'category4', 'user4', '2017-12-27 21:45:53', '2017-12-27 21:45:53');
INSERT INTO `memo` VALUES ('154', 'title5', 'content5', 'category5', 'user5', '2017-12-27 21:45:53', '2017-12-27 21:45:53');
INSERT INTO `memo` VALUES ('155', 'title6', 'content6', 'category6', 'user6', '2017-12-27 21:45:53', '2017-12-27 21:45:53');
INSERT INTO `memo` VALUES ('156', 'title7', 'content7', 'category7', 'user7', '2017-12-27 21:45:53', '2017-12-27 21:45:53');
INSERT INTO `memo` VALUES ('157', 'title8', 'content8', 'category8', 'user8', '2017-12-27 21:45:54', '2017-12-27 21:45:54');
INSERT INTO `memo` VALUES ('158', 'title9', 'content9', 'category9', 'user9', '2017-12-27 21:45:54', '2017-12-27 21:45:54');
INSERT INTO `memo` VALUES ('159', 'title10', 'content10', 'category10', 'user10', '2017-12-27 21:45:54', '2017-12-27 21:45:54');
INSERT INTO `memo` VALUES ('160', 'title11', 'content11', 'category11', 'user11', '2017-12-27 21:45:54', '2017-12-27 21:45:54');
INSERT INTO `memo` VALUES ('161', 'title12', 'content12', 'category12', 'user12', '2017-12-27 21:45:54', '2017-12-27 21:45:54');
INSERT INTO `memo` VALUES ('162', 'title13', 'content13', 'category13', 'user13', '2017-12-27 21:45:54', '2017-12-27 21:45:54');
INSERT INTO `memo` VALUES ('163', 'title14', 'content14', 'category14', 'user14', '2017-12-27 21:45:54', '2017-12-27 21:45:54');
INSERT INTO `memo` VALUES ('164', 'title15', 'content15', 'category15', 'user15', '2017-12-27 21:45:54', '2017-12-27 21:45:54');
INSERT INTO `memo` VALUES ('165', 'title16', 'content16', 'category16', 'user16', '2017-12-27 21:45:54', '2017-12-27 21:45:54');
INSERT INTO `memo` VALUES ('166', 'title17', 'content17', 'category17', 'user17', '2017-12-27 21:45:54', '2017-12-27 21:45:54');
INSERT INTO `memo` VALUES ('167', 'title18', 'content18', 'category18', 'user18', '2017-12-27 21:45:54', '2017-12-27 21:45:54');
INSERT INTO `memo` VALUES ('168', 'title19', 'content19', 'category19', 'user19', '2017-12-27 21:45:54', '2017-12-27 21:45:54');
INSERT INTO `memo` VALUES ('169', 'title20', 'content20', 'category20', 'user20', '2017-12-27 21:45:54', '2017-12-27 21:45:54');
INSERT INTO `memo` VALUES ('170', 'title21', 'content21', 'category21', 'user21', '2017-12-27 21:45:54', '2017-12-27 21:45:54');
INSERT INTO `memo` VALUES ('171', 'title22', 'content22', 'category22', 'user22', '2017-12-27 21:45:55', '2017-12-27 21:45:55');
INSERT INTO `memo` VALUES ('172', 'title23', 'content23', 'category23', 'user23', '2017-12-27 21:45:55', '2017-12-27 21:45:55');
INSERT INTO `memo` VALUES ('173', 'title24', 'content24', 'category24', 'user24', '2017-12-27 21:45:55', '2017-12-27 21:45:55');
INSERT INTO `memo` VALUES ('174', 'title25', 'content25', 'category25', 'user25', '2017-12-27 21:45:55', '2017-12-27 21:45:55');
INSERT INTO `memo` VALUES ('175', 'title26', 'content26', 'category26', 'user26', '2017-12-27 21:45:55', '2017-12-27 21:45:55');
INSERT INTO `memo` VALUES ('176', 'title27', 'content27', 'category27', 'user27', '2017-12-27 21:45:56', '2017-12-27 21:45:56');
INSERT INTO `memo` VALUES ('177', 'title28', 'content28', 'category28', 'user28', '2017-12-27 21:45:56', '2017-12-27 21:45:56');
INSERT INTO `memo` VALUES ('178', 'title29', 'content29', 'category29', 'user29', '2017-12-27 21:45:56', '2017-12-27 21:45:56');
INSERT INTO `memo` VALUES ('179', 'title30', 'content30', 'category30', 'user30', '2017-12-27 21:45:56', '2017-12-27 21:45:56');

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
) ENGINE=InnoDB AUTO_INCREMENT=213 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('183', 'username1', 'password1', 'nickname1', 'sex1', 'sign1', 'experience1', 'score1', '2017-12-27 21:45:48', '2017-12-27 21:45:48');
INSERT INTO `user` VALUES ('184', 'username2', 'password2', 'nickname2', 'sex2', 'sign2', 'experience2', 'score2', '2017-12-27 21:45:48', '2017-12-27 21:45:48');
INSERT INTO `user` VALUES ('185', 'username3', 'password3', 'nickname3', 'sex3', 'sign3', 'experience3', 'score3', '2017-12-27 21:45:48', '2017-12-27 21:45:48');
INSERT INTO `user` VALUES ('186', 'username4', 'password4', 'nickname4', 'sex4', 'sign4', 'experience4', 'score4', '2017-12-27 21:45:48', '2017-12-27 21:45:48');
INSERT INTO `user` VALUES ('187', 'username5', 'password5', 'nickname5', 'sex5', 'sign5', 'experience5', 'score5', '2017-12-27 21:45:49', '2017-12-27 21:45:49');
INSERT INTO `user` VALUES ('188', 'username6', 'password6', 'nickname6', 'sex6', 'sign6', 'experience6', 'score6', '2017-12-27 21:45:49', '2017-12-27 21:45:49');
INSERT INTO `user` VALUES ('189', 'username7', 'password7', 'nickname7', 'sex7', 'sign7', 'experience7', 'score7', '2017-12-27 21:45:49', '2017-12-27 21:45:49');
INSERT INTO `user` VALUES ('190', 'username8', 'password8', 'nickname8', 'sex8', 'sign8', 'experience8', 'score8', '2017-12-27 21:45:49', '2017-12-27 21:45:49');
INSERT INTO `user` VALUES ('191', 'username9', 'password9', 'nickname9', 'sex9', 'sign9', 'experience9', 'score9', '2017-12-27 21:45:49', '2017-12-27 21:45:49');
INSERT INTO `user` VALUES ('192', 'username10', 'password10', 'nickname10', 'sex10', 'sign10', 'experience10', 'score10', '2017-12-27 21:45:49', '2017-12-27 21:45:49');
INSERT INTO `user` VALUES ('193', 'username11', 'password11', 'nickname11', 'sex11', 'sign11', 'experience11', 'score11', '2017-12-27 21:45:49', '2017-12-27 21:45:49');
INSERT INTO `user` VALUES ('194', 'username12', 'password12', 'nickname12', 'sex12', 'sign12', 'experience12', 'score12', '2017-12-27 21:45:49', '2017-12-27 21:45:49');
INSERT INTO `user` VALUES ('195', 'username13', 'password13', 'nickname13', 'sex13', 'sign13', 'experience13', 'score13', '2017-12-27 21:45:49', '2017-12-27 21:45:49');
INSERT INTO `user` VALUES ('196', 'username14', 'password14', 'nickname14', 'sex14', 'sign14', 'experience14', 'score14', '2017-12-27 21:45:49', '2017-12-27 21:45:49');
INSERT INTO `user` VALUES ('197', 'username15', 'password15', 'nickname15', 'sex15', 'sign15', 'experience15', 'score15', '2017-12-27 21:45:49', '2017-12-27 21:45:49');
INSERT INTO `user` VALUES ('198', 'username16', 'password16', 'nickname16', 'sex16', 'sign16', 'experience16', 'score16', '2017-12-27 21:45:49', '2017-12-27 21:45:49');
INSERT INTO `user` VALUES ('199', 'username17', 'password17', 'nickname17', 'sex17', 'sign17', 'experience17', 'score17', '2017-12-27 21:45:50', '2017-12-27 21:45:50');
INSERT INTO `user` VALUES ('200', 'username18', 'password18', 'nickname18', 'sex18', 'sign18', 'experience18', 'score18', '2017-12-27 21:45:50', '2017-12-27 21:45:50');
INSERT INTO `user` VALUES ('201', 'username19', 'password19', 'nickname19', 'sex19', 'sign19', 'experience19', 'score19', '2017-12-27 21:45:50', '2017-12-27 21:45:50');
INSERT INTO `user` VALUES ('202', 'username20', 'password20', 'nickname20', 'sex20', 'sign20', 'experience20', 'score20', '2017-12-27 21:45:50', '2017-12-27 21:45:50');
INSERT INTO `user` VALUES ('203', 'username21', 'password21', 'nickname21', 'sex21', 'sign21', 'experience21', 'score21', '2017-12-27 21:45:50', '2017-12-27 21:45:50');
INSERT INTO `user` VALUES ('204', 'username22', 'password22', 'nickname22', 'sex22', 'sign22', 'experience22', 'score22', '2017-12-27 21:45:50', '2017-12-27 21:45:50');
INSERT INTO `user` VALUES ('205', 'username23', 'password23', 'nickname23', 'sex23', 'sign23', 'experience23', 'score23', '2017-12-27 21:45:50', '2017-12-27 21:45:50');
INSERT INTO `user` VALUES ('206', 'username24', 'password24', 'nickname24', 'sex24', 'sign24', 'experience24', 'score24', '2017-12-27 21:45:50', '2017-12-27 21:45:50');
INSERT INTO `user` VALUES ('207', 'username25', 'password25', 'nickname25', 'sex25', 'sign25', 'experience25', 'score25', '2017-12-27 21:45:50', '2017-12-27 21:45:50');
INSERT INTO `user` VALUES ('208', 'username26', 'password26', 'nickname26', 'sex26', 'sign26', 'experience26', 'score26', '2017-12-27 21:45:50', '2017-12-27 21:45:50');
INSERT INTO `user` VALUES ('209', 'username27', 'password27', 'nickname27', 'sex27', 'sign27', 'experience27', 'score27', '2017-12-27 21:45:50', '2017-12-27 21:45:50');
INSERT INTO `user` VALUES ('210', 'username28', 'password28', 'nickname28', 'sex28', 'sign28', 'experience28', 'score28', '2017-12-27 21:45:50', '2017-12-27 21:45:50');
INSERT INTO `user` VALUES ('211', 'username29', 'password29', 'nickname29', 'sex29', 'sign29', 'experience29', 'score29', '2017-12-27 21:45:50', '2017-12-27 21:45:50');
INSERT INTO `user` VALUES ('212', 'username30', 'password30', 'nickname30', 'sex30', 'sign30', 'experience30', 'score30', '2017-12-27 21:45:51', '2017-12-27 21:45:51');
