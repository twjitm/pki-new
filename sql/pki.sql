/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50650
 Source Host           : 127.0.0.1:3306
 Source Schema         : pki

 Target Server Type    : MySQL
 Target Server Version : 50650
 File Encoding         : 65001

 Date: 10/04/2022 16:15:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cabook
-- ----------------------------
DROP TABLE IF EXISTS `cabook`;
CREATE TABLE `cabook` (
  `ca_id` int(11) NOT NULL,
  `ca_CN` varchar(20) DEFAULT NULL,
  `ca_OU` varchar(20) DEFAULT NULL,
  `ca_O` varchar(20) DEFAULT NULL,
  `ca_L` varchar(20) DEFAULT NULL,
  `ca_ST` varchar(20) DEFAULT NULL,
  `ca_C` varchar(20) DEFAULT NULL,
  `ca_storepass` varchar(100) DEFAULT NULL,
  `ca_keypass` varchar(100) DEFAULT NULL,
  `ca_URL` varchar(200) NOT NULL,
  `u_id` int(11) DEFAULT NULL,
  `ca_start` varchar(20) DEFAULT NULL,
  `json` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ca_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `have_child` int(11) DEFAULT NULL,
  `is_hidden` int(11) DEFAULT NULL,
  `menu_img` varchar(255) DEFAULT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  `menu_url` varchar(255) DEFAULT NULL,
  `order_num` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for power
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(11) NOT NULL,
  `u_name` varchar(100) DEFAULT NULL,
  `u_type` varchar(50) DEFAULT NULL,
  `u_psd` varchar(100) DEFAULT NULL,
  `u_account` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
