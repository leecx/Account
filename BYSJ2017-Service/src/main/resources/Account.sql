/*
Navicat MySQL Data Transfer

Source Server         : 服务器
Source Server Version : 50626
Source Host           : 115.159.188.223:3306
Source Database       : Account

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-05-17 14:07:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `Account`
-- ----------------------------
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `userId` int(11) DEFAULT NULL COMMENT '用户id',
  `type` varchar(255) DEFAULT NULL COMMENT '账户类型',
  `num` varchar(255) DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Account
-- ----------------------------

-- ----------------------------
-- Table structure for `Bill`
-- ----------------------------
DROP TABLE IF EXISTS `Bill`;
CREATE TABLE `Bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userId` int(11) DEFAULT NULL COMMENT '用户id',
  `accountid` int(11) DEFAULT NULL COMMENT '账户id',
  `type` varchar(255) DEFAULT NULL COMMENT '类型（收入/支出）',
  `typeid` int(11) DEFAULT NULL COMMENT '类别id',
  `time` time DEFAULT NULL COMMENT '时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `num` varchar(255) DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Bill
-- ----------------------------

-- ----------------------------
-- Table structure for `Budget`
-- ----------------------------
DROP TABLE IF EXISTS `Budget`;
CREATE TABLE `Budget` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `month` int(11) DEFAULT NULL COMMENT '月份',
  `num` varchar(255) DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Budget
-- ----------------------------

-- ----------------------------
-- Table structure for `ShareAccount`
-- ----------------------------
DROP TABLE IF EXISTS `ShareAccount`;
CREATE TABLE `ShareAccount` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT 'id',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `friendid` int(11) DEFAULT NULL COMMENT '对方id',
  `accountid` int(11) DEFAULT NULL COMMENT '账户id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ShareAccount
-- ----------------------------

-- ----------------------------
-- Table structure for `Sort`
-- ----------------------------
DROP TABLE IF EXISTS `Sort`;
CREATE TABLE `Sort` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT 'id',
  `parentid` int(11) DEFAULT NULL COMMENT '父id',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `type` varchar(255) DEFAULT NULL COMMENT '类型（收入/支出）',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Sort
-- ----------------------------

-- ----------------------------
-- Table structure for `User`
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT 'id',
  `username` varchar(255) NOT NULL DEFAULT '' COMMENT '账号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `icon` varchar(255) DEFAULT NULL COMMENT '头像',
  `phone` varchar(255) DEFAULT NULL COMMENT 's手机号',
  PRIMARY KEY (`id`,`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of User
-- ----------------------------
INSERT INTO `User` VALUES ('1', '111111', '111111', null, '123456');
