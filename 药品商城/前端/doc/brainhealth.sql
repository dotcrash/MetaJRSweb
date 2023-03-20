/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : brainhealth

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 27/05/2022 17:51:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for f_article
-- ----------------------------
DROP TABLE IF EXISTS `f_article`;
CREATE TABLE `f_article`  (
  `uid` bigint(32) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `contentHtml` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `love_count` int(255) NULL DEFAULT NULL,
  `look_count` int(255) NULL DEFAULT NULL,
  `comment_count` int(255) NULL DEFAULT NULL,
  `create_time` timestamp(4) NULL DEFAULT NULL,
  `user_uid` bigint(32) NULL DEFAULT NULL,
  `imgs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of f_article
-- ----------------------------
INSERT INTO `f_article` VALUES (1, '1', '1', '1', 1, 1, 1, '2022-05-21 02:07:48.0000', 3, '1;2;3');
INSERT INTO `f_article` VALUES (2, 'retrtt', 'trey', '<p>trey</p>', 0, 0, 0, NULL, 1, 'null1;2;');
INSERT INTO `f_article` VALUES (3, 'retrtt', 'trey', '<p>trey</p>', 0, 0, 0, NULL, 1, '1;2;');
INSERT INTO `f_article` VALUES (4, '111111', '111111111111111111111111', '<p>111111111111111111111111</p>', 0, 0, 0, NULL, 1, '');

-- ----------------------------
-- Table structure for f_user
-- ----------------------------
DROP TABLE IF EXISTS `f_user`;
CREATE TABLE `f_user`  (
  `uid` int(23) NOT NULL AUTO_INCREMENT COMMENT '唯一uid\r\n',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账户',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `gender` tinyint(4) NULL DEFAULT NULL COMMENT '性别（1：男2：女）',
  ` nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `email` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birth` date NULL DEFAULT NULL,
  `mobile` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `summary` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_count` int(20) NULL DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of f_user
-- ----------------------------
INSERT INTO `f_user` VALUES (1, '2', '2', 1, '1', '1', '1', '2022-05-20', '1', '1', 1, '2022-05-21 02:06:48');
INSERT INTO `f_user` VALUES (2, '2', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-05-19 18:41:53');
INSERT INTO `f_user` VALUES (3, '3', '3', 1, '1', '1', '1', '2022-05-14', '1', '1', 1, '2022-05-21 02:07:06');
INSERT INTO `f_user` VALUES (4, '88888', '88888', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-05-20 20:19:14');

SET FOREIGN_KEY_CHECKS = 1;
