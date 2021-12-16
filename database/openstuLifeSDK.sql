/*
 Navicat Premium Data Transfer

 Source Server         : mygirl
 Source Server Type    : MySQL
 Source Server Version : 50650
 Source Host           : 39.103.166.167:3306
 Source Schema         : openstuLifeSDK

 Target Server Type    : MySQL
 Target Server Version : 50650
 File Encoding         : 65001

 Date: 09/12/2021 23:33:54
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`
(
    `id`             int(255) NOT NULL,
    `activity_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    `promoter_id`    int(255) NULL DEFAULT NULL,
    `activity_des`   varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    `activity_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    `comment`        varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    `release_time`   datetime NULL DEFAULT NULL,
    `update_time`    datetime NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX            `id`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for activity_participate_info
-- ----------------------------
DROP TABLE IF EXISTS `activity_participate_info`;
CREATE TABLE `activity_participate_info`
(
    `id`               int(255) NOT NULL,
    `activity_id`      int(11) NULL DEFAULT NULL,
    `participate_u_id` int(11) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX              `id`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for csdn_download
-- ----------------------------
DROP TABLE IF EXISTS `csdn_download`;
CREATE TABLE `csdn_download`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `address`     varchar(6000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    `email`       varchar(6000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    `submit_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    INDEX         `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 75 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for university
-- ----------------------------
DROP TABLE IF EXISTS `university`;
CREATE TABLE `university`
(
    `id`              int(255) NOT NULL,
    `university_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    `location`        varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX             `id`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_body
-- ----------------------------
DROP TABLE IF EXISTS `user_body`;
CREATE TABLE `user_body`
(
    `id`          int(11) NOT NULL,
    `username`    varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    `password`    varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    `email`       varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_university
-- ----------------------------
DROP TABLE IF EXISTS `user_university`;
CREATE TABLE `user_university`
(
    ` u_id`         int(11) NOT NULL,
    `university_id` int(11) NULL DEFAULT NULL,
    PRIMARY KEY (` u_id`) USING BTREE,
    INDEX           `id`(` u_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for visited_data
-- ----------------------------
DROP TABLE IF EXISTS `visited_data`;
CREATE TABLE `visited_data`
(
    `id`            bigint(20) NOT NULL,
    `visited_count` bigint(20) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

SET
FOREIGN_KEY_CHECKS = 1;
