/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50635
 Source Host           : localhost:3306
 Source Schema         : mybatis_plus

 Target Server Type    : MySQL
 Target Server Version : 50635
 File Encoding         : 65001

 Date: 06/04/2022 10:44:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `version` int(255) NULL DEFAULT 1 COMMENT '版本',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, 'Tom', 28, 'test3@baomidou.com', NULL, NULL, 1, NULL);
INSERT INTO `user` VALUES (4, 'Sandy', 21, 'test4@baomidou.com', NULL, NULL, 1, NULL);
INSERT INTO `user` VALUES (5, 'Billie', 24, 'test5@baomidou.com', NULL, NULL, 1, NULL);
INSERT INTO `user` VALUES (9, 'koko', 3, '2427886409@qq.com', '2022-03-31 13:01:51', '2022-03-31 13:01:51', 1, 1);
INSERT INTO `user` VALUES (10, 'koko', 3, '2427886409@qq.com', '2022-03-31 13:03:52', '2022-03-31 13:03:52', 1, 0);

SET FOREIGN_KEY_CHECKS = 1;
