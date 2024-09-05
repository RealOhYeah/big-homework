/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : filesystem

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 05/09/2024 14:49:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for carousel
-- ----------------------------
DROP TABLE IF EXISTS `carousel`;
CREATE TABLE `carousel`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '轮播图状态',
  `max_number` int NULL DEFAULT NULL COMMENT '最大数量',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `status` int NULL DEFAULT 0 COMMENT '状态',
  `del_flag` int NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 84 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = REDUNDANT;

-- ----------------------------
-- Records of carousel
-- ----------------------------
INSERT INTO `carousel` VALUES (42, 'B3L大屏幕', 22, 1, '2024-03-27 07:06:42', 1, '2024-03-26 15:32:02', 0, 0);
INSERT INTO `carousel` VALUES (43, '测试通道', 100, 1, '2024-03-26 15:27:16', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (44, 'B教3楼大屏展示', 1000, 5, '2024-03-26 15:38:40', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (46, '2233', 3, 4, '2024-03-28 02:37:19', 4, '2024-04-02 12:09:23', 0, 0);
INSERT INTO `carousel` VALUES (50, '77777', 100, 3, '2024-04-01 10:50:50', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (52, 'w', 3, 7, '2024-04-01 13:04:49', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (57, '1', NULL, 7, '2024-04-01 13:40:00', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (58, '1', NULL, 7, '2024-04-01 13:40:02', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (59, '1', NULL, 7, '2024-04-01 13:40:04', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (60, '1', NULL, 7, '2024-04-01 13:40:09', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (61, '1', NULL, 7, '2024-04-01 13:40:15', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (62, '1', NULL, 7, '2024-04-01 13:40:17', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (63, '1', NULL, 7, '2024-04-01 13:40:18', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (64, '1', NULL, 7, '2024-04-01 13:40:21', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (65, '1', NULL, 7, '2024-04-01 13:40:23', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (66, '1', NULL, 7, '2024-04-01 13:40:25', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (67, '1', NULL, 7, '2024-04-01 13:40:27', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (68, '1', NULL, 7, '2024-04-01 13:40:30', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (69, '1', NULL, 7, '2024-04-01 13:40:33', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (70, '1', NULL, 7, '2024-04-01 13:40:37', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (71, '1', NULL, 7, '2024-04-01 13:40:39', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (72, '1', NULL, 7, '2024-04-01 13:40:41', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (73, '1', NULL, 7, '2024-04-01 13:40:46', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (74, '1', NULL, 7, '2024-04-01 13:40:47', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (75, '1', NULL, 7, '2024-04-01 13:40:49', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (76, '1', NULL, 7, '2024-04-01 13:40:50', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (77, '1', NULL, 7, '2024-04-01 13:40:56', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (78, '1', NULL, 7, '2024-04-01 13:41:03', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (79, '1', NULL, 7, '2024-04-01 13:41:04', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (80, '1', NULL, 7, '2024-04-01 13:41:06', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (81, '1', NULL, 7, '2024-04-01 13:41:10', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (82, '1', NULL, 7, '2024-04-01 13:41:12', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (83, '1', NULL, 7, '2024-04-01 13:41:14', NULL, NULL, 0, 0);
INSERT INTO `carousel` VALUES (84, '333', 1, 1, '2024-04-02 08:09:21', 1, '2024-04-02 00:12:44', 0, 0);

-- ----------------------------
-- Table structure for carousel_file
-- ----------------------------
DROP TABLE IF EXISTS `carousel_file`;
CREATE TABLE `carousel_file`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `carousel_id` bigint NULL DEFAULT NULL COMMENT '轮播图id',
  `file_id` bigint NULL DEFAULT NULL COMMENT '文件fileid 必须是图片',
  `soft` int NULL DEFAULT NULL COMMENT '排序id',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `status` int NULL DEFAULT NULL COMMENT '状态',
  `seconds` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '一个图片停留多少秒',
  `introduce_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '介绍',
  `font_color` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT ' 字体颜色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 289 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of carousel_file
-- ----------------------------
INSERT INTO `carousel_file` VALUES (65, 42, 153, 1, 1, '2024-03-26 15:09:57', 1, '2024-04-02 11:06:40', NULL, '1000', '123', '#000000');
INSERT INTO `carousel_file` VALUES (66, 42, 154, 2, 1, '2024-03-26 15:10:05', 1, '2024-04-02 11:06:44', NULL, '1000', '', '#000000');
INSERT INTO `carousel_file` VALUES (67, 42, 155, 3, 1, '2024-03-26 15:10:18', 1, '2024-04-02 11:07:03', NULL, '1000', '', '#000000');
INSERT INTO `carousel_file` VALUES (68, 42, 156, 4, 1, '2024-03-26 15:10:30', NULL, NULL, NULL, '3000', '', '425254');
INSERT INTO `carousel_file` VALUES (69, 42, 157, 5, 1, '2024-03-26 15:10:45', 1, '2024-04-02 11:07:16', NULL, '1000', '', '#000000');
INSERT INTO `carousel_file` VALUES (175, 46, 278, 1, 4, '2024-04-09 09:16:26', NULL, NULL, NULL, '5000', '鸿蒙', '#000000');
INSERT INTO `carousel_file` VALUES (176, 46, 279, 1, 4, '2024-04-09 09:16:51', NULL, NULL, NULL, '5000', '22', '#000000');
INSERT INTO `carousel_file` VALUES (189, 52, 292, 1, 7, '2024-04-18 10:14:06', NULL, NULL, NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (192, 50, 295, 2, 3, '2024-04-18 15:10:12', 3, '2024-04-22 15:20:25', NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (193, 50, 296, 4, 3, '2024-04-18 15:10:17', 3, '2024-04-22 15:20:29', NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (195, 50, 298, 5, 3, '2024-04-18 15:13:05', 3, '2024-04-22 15:20:39', NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (196, 50, 299, 6, 3, '2024-04-18 15:13:06', 3, '2024-04-22 15:20:56', NULL, '5000', '社团OA系统', '#000000');
INSERT INTO `carousel_file` VALUES (197, 50, 300, 1, 3, '2024-04-18 15:14:35', 3, '2024-04-22 15:20:19', NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (198, 50, 301, 7, 3, '2024-04-18 15:15:46', 3, '2024-04-22 15:21:24', NULL, '5000', 'OA办公系统', 'rgba(18, 39, 174, 1)');
INSERT INTO `carousel_file` VALUES (199, 50, 302, 0, 1, '2024-04-18 15:19:56', 3, '2024-04-22 15:20:08', NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (201, 50, 304, 7, 3, '2024-04-18 15:36:22', 3, '2024-04-22 15:21:31', NULL, '5000', 'By TLM Team 田雷宇', 'rgba(18, 39, 174, 1)');
INSERT INTO `carousel_file` VALUES (221, 44, 324, 0, 5, '2024-04-19 10:34:34', 5, '2024-04-19 10:49:23', NULL, '3000', '', '#000000');
INSERT INTO `carousel_file` VALUES (273, 50, 376, -1, 3, '2024-04-22 02:53:23', 3, '2024-04-22 15:19:53', NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (274, 44, 379, 15, 5, '2024-04-27 21:02:13', NULL, NULL, NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (275, 44, 380, 15, 5, '2024-04-27 21:02:13', NULL, NULL, NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (276, 44, 381, 15, 5, '2024-04-27 21:02:13', NULL, NULL, NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (277, 44, 382, 15, 5, '2024-04-27 21:02:14', NULL, NULL, NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (278, 44, 383, 15, 5, '2024-04-27 21:02:14', NULL, NULL, NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (279, 44, 384, 15, 5, '2024-04-27 21:02:14', NULL, NULL, NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (280, 44, 385, 15, 5, '2024-04-27 21:02:14', NULL, NULL, NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (281, 44, 386, 15, 5, '2024-04-27 21:02:14', NULL, NULL, NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (282, 44, 387, 15, 5, '2024-04-27 21:02:15', NULL, NULL, NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (283, 44, 388, 15, 5, '2024-04-27 21:02:15', NULL, NULL, NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (284, 44, 389, 15, 5, '2024-04-27 21:02:15', NULL, NULL, NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (285, 44, 390, 15, 5, '2024-04-27 21:02:15', NULL, NULL, NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (286, 44, 391, 15, 5, '2024-04-27 21:02:16', NULL, NULL, NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (287, 44, 392, 15, 5, '2024-04-27 21:02:16', NULL, NULL, NULL, '5000', '', '#000000');
INSERT INTO `carousel_file` VALUES (288, 50, 393, 9, 3, '2024-05-09 08:28:37', 3, '2024-05-09 15:19:32', NULL, '98000', '', '#000000');
INSERT INTO `carousel_file` VALUES (289, 50, 394, 8, 3, '2024-05-09 15:19:28', NULL, NULL, NULL, '3000', '', '#000000');

-- ----------------------------
-- Table structure for channel_files
-- ----------------------------
DROP TABLE IF EXISTS `channel_files`;
CREATE TABLE `channel_files`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `channel_id` bigint NULL DEFAULT NULL COMMENT '通道id',
  `file_id` bigint NULL DEFAULT NULL COMMENT '文件id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of channel_files
-- ----------------------------
INSERT INTO `channel_files` VALUES (29, 46, 165);
INSERT INTO `channel_files` VALUES (30, 46, 166);
INSERT INTO `channel_files` VALUES (31, 46, 167);
INSERT INTO `channel_files` VALUES (32, 47, 180);
INSERT INTO `channel_files` VALUES (33, 51, 153);
INSERT INTO `channel_files` VALUES (34, 51, 267);
INSERT INTO `channel_files` VALUES (35, 51, 156);
INSERT INTO `channel_files` VALUES (36, -1, 268);
INSERT INTO `channel_files` VALUES (37, 46, 166);
INSERT INTO `channel_files` VALUES (38, 46, 277);

-- ----------------------------
-- Table structure for channel_list
-- ----------------------------
DROP TABLE IF EXISTS `channel_list`;
CREATE TABLE `channel_list`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `channel_id` bigint NULL DEFAULT NULL,
  `show_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of channel_list
-- ----------------------------
INSERT INTO `channel_list` VALUES (1, 44, 1);
INSERT INTO `channel_list` VALUES (2, 50, 1);
INSERT INTO `channel_list` VALUES (3, 50, 2);

-- ----------------------------
-- Table structure for channels
-- ----------------------------
DROP TABLE IF EXISTS `channels`;
CREATE TABLE `channels`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '通道名字',
  `start_time` datetime NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '结束时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `del_flag` int NULL DEFAULT 0 COMMENT '逻辑删除',
  `status` int NULL DEFAULT 0 COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '通道' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of channels
-- ----------------------------
INSERT INTO `channels` VALUES (46, 'test', '2024-03-26 08:00:00', '2024-03-26 08:00:00', 4, '2024-03-26 16:21:01', NULL, NULL);
INSERT INTO `channels` VALUES (49, 'qq', '2024-04-02 08:00:00', '2024-04-11 08:00:00', 7, '2024-04-01 13:19:33', NULL, NULL);
INSERT INTO `channels` VALUES (50, 'qqq', '2024-04-02 08:00:00', '2024-04-11 08:00:00', 7, '2024-04-01 13:19:35', NULL, NULL);
INSERT INTO `channels` VALUES (51, '123345', '2024-04-02 08:00:00', '2024-04-17 08:00:00', 1, '2024-04-01 23:51:49', NULL, NULL);
INSERT INTO `channels` VALUES (52, 'qweczx', '2024-04-08 08:00:00', '2024-04-19 08:00:00', 1, '2024-04-02 00:08:06', NULL, NULL);
INSERT INTO `channels` VALUES (53, NULL, NULL, NULL, 1, '2024-08-18 10:57:46', NULL, NULL);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `cno` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程号',
  `cname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程名',
  `tno` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '教师编号',
  PRIMARY KEY (`cno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', NULL, NULL);
INSERT INTO `course` VALUES ('12332', NULL, NULL);
INSERT INTO `course` VALUES ('19-888', '高等数学', '831');
INSERT INTO `course` VALUES ('3-105', '计算机导论', '825');
INSERT INTO `course` VALUES ('3-245', '操作系统', '804');
INSERT INTO `course` VALUES ('6-166', '数据电路', '856');
INSERT INTO `course` VALUES ('7-485', '大学英语', '988');
INSERT INTO `course` VALUES ('789789', NULL, NULL);
INSERT INTO `course` VALUES ('asda', NULL, NULL);
INSERT INTO `course` VALUES ('eqw', NULL, NULL);

-- ----------------------------
-- Table structure for delete_log
-- ----------------------------
DROP TABLE IF EXISTS `delete_log`;
CREATE TABLE `delete_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `delete_by` bigint NOT NULL COMMENT '执行删除操作人的id',
  `delete_time` datetime NOT NULL COMMENT '删除时间',
  `table_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '执行的操作是删除哪个表数据',
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件名 ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 112 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of delete_log
-- ----------------------------
INSERT INTO `delete_log` VALUES (6, 5, '2024-03-26 15:47:11', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (7, 5, '2024-03-26 15:48:00', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (8, 1, '2024-03-26 16:05:00', 'carousel', NULL);
INSERT INTO `delete_log` VALUES (9, 4, '2024-03-26 17:13:27', 'file_uploads', NULL);
INSERT INTO `delete_log` VALUES (10, 5, '2024-03-27 09:24:15', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (11, 5, '2024-03-27 09:43:40', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (12, 5, '2024-03-27 18:08:27', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (13, 5, '2024-03-27 18:10:33', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (14, 5, '2024-03-27 18:15:42', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (15, 5, '2024-03-27 18:18:11', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (16, 5, '2024-03-27 18:19:12', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (17, 5, '2024-03-27 18:23:23', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (18, 4, '2024-03-27 19:33:40', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (19, 5, '2024-03-28 10:48:28', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (20, 5, '2024-03-28 10:48:30', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (21, 7, '2024-04-01 13:19:22', 'channels', NULL);
INSERT INTO `delete_log` VALUES (22, 7, '2024-04-01 13:20:03', 'file_uploads', NULL);
INSERT INTO `delete_log` VALUES (23, 7, '2024-04-01 13:20:14', 'file_uploads', NULL);
INSERT INTO `delete_log` VALUES (24, 7, '2024-04-01 13:21:08', 'carousel', NULL);
INSERT INTO `delete_log` VALUES (25, 7, '2024-04-01 13:21:11', 'channels', NULL);
INSERT INTO `delete_log` VALUES (26, 7, '2024-04-01 13:21:14', 'file_uploads', NULL);
INSERT INTO `delete_log` VALUES (27, 7, '2024-04-01 13:25:56', 'file_uploads', NULL);
INSERT INTO `delete_log` VALUES (28, 4, '2024-04-01 13:27:42', 'carousel', NULL);
INSERT INTO `delete_log` VALUES (29, 3, '2024-04-01 13:42:21', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (30, 3, '2024-04-01 13:42:23', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (31, 3, '2024-04-01 13:42:26', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (32, 3, '2024-04-01 13:42:29', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (33, 3, '2024-04-01 13:42:31', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (34, 3, '2024-04-01 13:42:32', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (35, 3, '2024-04-01 13:42:33', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (36, 3, '2024-04-01 13:42:35', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (37, 3, '2024-04-01 13:42:36', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (38, 3, '2024-04-01 13:42:39', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (39, 3, '2024-04-01 13:42:40', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (40, 3, '2024-04-01 13:42:42', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (41, 3, '2024-04-01 13:42:43', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (42, 3, '2024-04-01 13:42:45', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (43, 3, '2024-04-01 13:42:50', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (44, 3, '2024-04-01 13:42:52', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (45, 3, '2024-04-01 13:42:53', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (46, 3, '2024-04-01 13:42:55', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (47, 3, '2024-04-01 13:43:57', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (48, 3, '2024-04-01 13:43:58', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (49, 3, '2024-04-01 13:44:00', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (50, 3, '2024-04-01 13:44:03', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (51, 3, '2024-04-01 13:48:57', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (52, 3, '2024-04-01 13:48:59', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (53, 3, '2024-04-01 13:49:00', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (54, 3, '2024-04-01 13:49:01', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (55, 3, '2024-04-01 13:49:03', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (56, 3, '2024-04-01 13:49:04', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (57, 3, '2024-04-01 13:55:30', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (58, 3, '2024-04-01 13:55:32', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (59, 3, '2024-04-01 13:55:33', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (60, 3, '2024-04-01 13:55:35', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (61, 3, '2024-04-01 13:55:36', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (62, 3, '2024-04-01 13:55:37', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (63, 3, '2024-04-01 13:55:39', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (64, 3, '2024-04-01 13:55:40', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (65, 3, '2024-04-01 13:55:41', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (66, 3, '2024-04-01 13:55:43', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (67, 3, '2024-04-01 13:55:44', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (68, 3, '2024-04-01 13:55:46', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (69, 3, '2024-04-01 13:55:49', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (70, 3, '2024-04-01 13:55:53', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (71, 3, '2024-04-01 13:55:55', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (72, 3, '2024-04-01 13:55:56', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (73, 3, '2024-04-01 13:55:57', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (74, 3, '2024-04-01 13:55:58', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (75, 3, '2024-04-01 13:56:01', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (76, 3, '2024-04-01 13:56:02', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (77, 3, '2024-04-01 13:56:03', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (78, 3, '2024-04-01 13:56:05', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (79, 3, '2024-04-01 13:56:07', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (80, 3, '2024-04-01 13:56:08', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (81, 3, '2024-04-01 13:56:09', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (82, 3, '2024-04-01 13:56:11', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (83, 4, '2024-04-01 16:05:14', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (84, 4, '2024-04-01 16:07:09', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (85, 4, '2024-04-01 17:02:00', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (86, 4, '2024-04-01 17:12:48', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (87, 1, '2024-04-02 00:11:15', 'file_uploads', NULL);
INSERT INTO `delete_log` VALUES (88, 1, '2024-04-02 00:11:34', 'file_uploads', NULL);
INSERT INTO `delete_log` VALUES (89, 1, '2024-04-02 08:33:08', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (90, 1, '2024-04-02 08:33:09', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (91, 1, '2024-04-02 08:33:11', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (92, 1, '2024-04-02 08:33:13', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (93, 1, '2024-04-02 11:07:39', 'file_uploads', NULL);
INSERT INTO `delete_log` VALUES (94, 1, '2024-04-02 11:07:47', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (95, 4, '2024-04-09 09:11:00', 'file_uploads', NULL);
INSERT INTO `delete_log` VALUES (96, 4, '2024-04-09 09:11:03', 'file_uploads', NULL);
INSERT INTO `delete_log` VALUES (97, 4, '2024-04-09 09:14:24', 'file_uploads', NULL);
INSERT INTO `delete_log` VALUES (98, 4, '2024-04-09 09:30:12', 'file_uploads', NULL);
INSERT INTO `delete_log` VALUES (99, 4, '2024-04-09 09:30:14', 'file_uploads', NULL);
INSERT INTO `delete_log` VALUES (100, 3, '2024-04-17 11:06:17', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (101, 3, '2024-04-17 11:11:18', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (102, 3, '2024-04-17 11:11:20', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (103, 3, '2024-04-17 11:11:22', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (104, 3, '2024-04-18 09:30:50', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (105, 3, '2024-04-18 09:30:52', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (106, 3, '2024-04-18 09:30:53', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (107, 1, '2024-04-18 15:03:52', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (108, 1, '2024-04-18 15:18:43', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (109, 3, '2024-04-19 11:01:19', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (110, 5, '2024-04-21 19:07:51', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (111, 5, '2024-04-21 19:11:22', 'carousel_file', NULL);
INSERT INTO `delete_log` VALUES (112, 3, '2024-05-09 14:47:40', 'carousel_file', NULL);

-- ----------------------------
-- Table structure for file_uploads
-- ----------------------------
DROP TABLE IF EXISTS `file_uploads`;
CREATE TABLE `file_uploads`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成的文件名',
  `original_file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最开始的文件名',
  `file_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件类型',
  `role` tinyint NULL DEFAULT 0 COMMENT '文件权限（0：公开，1：私有）',
  `download_path` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '下载路径',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `status` tinyint NULL DEFAULT 0 COMMENT '状态',
  `del_flag` tinyint NULL DEFAULT 0 COMMENT '逻辑删除（0：未删除，1：被删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 394 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of file_uploads
-- ----------------------------
INSERT INTO `file_uploads` VALUES (153, 'e4b58e7f-ffc4-4ed3-bb85-c9622ff19866.png', 'qwe.png', '.png', 0, '1/e4b58e7f-ffc4-4ed3-bb85-c9622ff19866.png', 1, '2024-03-26 15:09:57', 1, '2024-03-26 15:09:57', 0, 0);
INSERT INTO `file_uploads` VALUES (154, '30c086a1-6a55-4d3c-a7ba-5df31adaf9cf.jpeg', '2.jpeg', '.jpeg', 0, '1/30c086a1-6a55-4d3c-a7ba-5df31adaf9cf.jpeg', 1, '2024-03-26 15:10:05', 1, '2024-03-26 15:10:05', 0, 0);
INSERT INTO `file_uploads` VALUES (155, '3c199dc3-13d4-439a-a3a0-d2cccfe705c2.png', '3.png', '.png', 0, '1/3c199dc3-13d4-439a-a3a0-d2cccfe705c2.png', 1, '2024-03-26 15:10:18', 1, '2024-03-26 15:10:18', 0, 0);
INSERT INTO `file_uploads` VALUES (156, '5ad0e3f5-77b4-42b7-8fe3-29cf18f346d9.png', '4.png', '.png', 0, '1/5ad0e3f5-77b4-42b7-8fe3-29cf18f346d9.png', 1, '2024-03-26 15:10:30', 1, '2024-03-26 15:10:30', 0, 0);
INSERT INTO `file_uploads` VALUES (157, '82953d56-3b15-4837-92a1-0c992e6d1a92.png', '4.1.png', '.png', 0, '1/82953d56-3b15-4837-92a1-0c992e6d1a92.png', 1, '2024-03-26 15:10:45', 1, '2024-03-26 15:10:45', 0, 0);
INSERT INTO `file_uploads` VALUES (163, '0c063e0d-ed37-428a-b225-bd6dc263d870.png', 'WechatIMG2246.png', '.png', 0, '5/0c063e0d-ed37-428a-b225-bd6dc263d870.png', 5, '2024-03-26 15:47:20', 5, '2024-03-26 15:47:20', 0, 0);
INSERT INTO `file_uploads` VALUES (164, '52d3b0d9-7778-4006-ac6c-42523f55aa08.png', '4.png', '.png', 0, '5/52d3b0d9-7778-4006-ac6c-42523f55aa08.png', 5, '2024-03-26 15:47:45', 5, '2024-03-26 15:47:45', 0, 0);
INSERT INTO `file_uploads` VALUES (167, '683705f9-b561-42d8-8688-6c0843b8af15.zip', '2021102349田雷宇.docx.zip', '.zip', 0, '4/683705f9-b561-42d8-8688-6c0843b8af15.zip', 4, '2024-03-26 16:35:56', 4, '2024-03-26 16:35:56', 0, 0);
INSERT INTO `file_uploads` VALUES (168, 'cb3d9e78-0071-44d1-bc55-b2026c2a97a1.png', '屏幕截图 2024-03-05 105117.png', '.png', 0, '5/cb3d9e78-0071-44d1-bc55-b2026c2a97a1.png', 5, '2024-03-27 09:24:41', 5, '2024-03-27 09:24:41', 0, 0);
INSERT INTO `file_uploads` VALUES (169, '6ea3efca-9a21-4410-880c-642dd39bfa4b.jpg', 'A15优秀寝室15.jpg', '.jpg', 0, '5/6ea3efca-9a21-4410-880c-642dd39bfa4b.jpg', 5, '2024-03-27 18:07:11', 5, '2024-03-27 18:07:11', 0, 0);
INSERT INTO `file_uploads` VALUES (170, '3cd36c76-689b-481a-b49f-474a9f087942.jpg', 'A.第二周.jpg', '.jpg', 0, '5/3cd36c76-689b-481a-b49f-474a9f087942.jpg', 5, '2024-03-27 18:09:31', 5, '2024-03-27 18:09:31', 0, 0);
INSERT INTO `file_uploads` VALUES (171, '3cbf3ddd-784b-426e-a40d-4a924b9f491f.jpg', 'A.第二周.jpg', '.jpg', 0, '5/3cbf3ddd-784b-426e-a40d-4a924b9f491f.jpg', 5, '2024-03-27 18:11:16', 5, '2024-03-27 18:11:16', 0, 0);
INSERT INTO `file_uploads` VALUES (172, '040a5539-17a2-4558-9c0e-ec5bbf2ffaf0.jpg', 'A1优秀寝室1.jpg', '.jpg', 0, '5/040a5539-17a2-4558-9c0e-ec5bbf2ffaf0.jpg', 5, '2024-03-27 18:11:43', 5, '2024-03-27 18:11:43', 0, 0);
INSERT INTO `file_uploads` VALUES (173, '3769e9a4-0df1-4988-ac86-00ba1c58e502.jpg', '2bb65dd4714f239ef72a2dadfe96d91.jpg', '.jpg', 0, '5/3769e9a4-0df1-4988-ac86-00ba1c58e502.jpg', 5, '2024-03-27 18:12:02', 5, '2024-03-27 18:12:02', 0, 0);
INSERT INTO `file_uploads` VALUES (174, 'ff69a790-9924-422c-adf4-35e288393eff.jpg', 'WechatIMG6013.jpg', '.jpg', 0, '5/ff69a790-9924-422c-adf4-35e288393eff.jpg', 5, '2024-03-27 18:13:27', 5, '2024-03-27 18:13:27', 0, 0);
INSERT INTO `file_uploads` VALUES (175, 'b92e719f-1ec0-4e40-a98a-78ce40eb87cf.jpg', 'A4优秀寝室4.jpg', '.jpg', 0, '5/b92e719f-1ec0-4e40-a98a-78ce40eb87cf.jpg', 5, '2024-03-27 18:15:38', 5, '2024-03-27 18:15:38', 0, 0);
INSERT INTO `file_uploads` VALUES (176, 'b5a14e85-4251-4436-a79f-6a13555d8607.jpg', 'WechatIMG389.jpg', '.jpg', 0, '5/b5a14e85-4251-4436-a79f-6a13555d8607.jpg', 5, '2024-03-27 18:19:09', 5, '2024-03-27 18:19:09', 0, 0);
INSERT INTO `file_uploads` VALUES (177, 'e8fd3a9d-3553-4d6e-9aa0-833f893b0397.jpg', 'A.第二周.jpg', '.jpg', 0, '5/e8fd3a9d-3553-4d6e-9aa0-833f893b0397.jpg', 5, '2024-03-27 18:19:12', 5, '2024-03-27 18:19:12', 0, 0);
INSERT INTO `file_uploads` VALUES (178, '71d210cc-ca83-4016-ae70-be7861e0106c.jpg', '鸿蒙认证.jpg', '.jpg', 0, '4/71d210cc-ca83-4016-ae70-be7861e0106c.jpg', 4, '2024-03-27 20:04:30', 4, '2024-03-27 20:04:30', 0, 0);
INSERT INTO `file_uploads` VALUES (179, 'd2c9fd03-8343-4490-9c8c-285607c052d8.png', '1.png', '.png', 0, '3/d2c9fd03-8343-4490-9c8c-285607c052d8.png', 3, '2024-04-01 10:53:57', 3, '2024-04-01 10:53:57', 0, 0);
INSERT INTO `file_uploads` VALUES (184, 'a1fb464a-60d1-4614-afbb-c284cdee8284.docx', '前端面试.docx', '.docx', 0, '7/a1fb464a-60d1-4614-afbb-c284cdee8284.docx', 7, '2024-04-01 13:24:58', 7, '2024-04-01 13:24:58', 0, 0);
INSERT INTO `file_uploads` VALUES (185, '8c13b448-caf7-444d-ad5f-1930a3029a83.png', '4.1.png', '.png', 0, '3/8c13b448-caf7-444d-ad5f-1930a3029a83.png', 3, '2024-04-01 13:28:13', 3, '2024-04-01 13:28:13', 0, 0);
INSERT INTO `file_uploads` VALUES (186, 'e589d84e-fbbd-4e75-8fa3-a8fb58640854.png', '42.png', '.png', 0, '3/e589d84e-fbbd-4e75-8fa3-a8fb58640854.png', 3, '2024-04-01 13:31:21', 3, '2024-04-01 13:31:21', 0, 0);
INSERT INTO `file_uploads` VALUES (187, '41d596c4-701a-42c6-9e38-61cfd174d153.png', '42.png', '.png', 0, '3/41d596c4-701a-42c6-9e38-61cfd174d153.png', 3, '2024-04-01 13:32:04', 3, '2024-04-01 13:32:04', 0, 0);
INSERT INTO `file_uploads` VALUES (188, '641bf453-4e07-40b8-9daa-18e6d5933c51.jpeg', '10.jpeg', '.jpeg', 0, '3/641bf453-4e07-40b8-9daa-18e6d5933c51.jpeg', 3, '2024-04-01 13:33:04', 3, '2024-04-01 13:33:04', 0, 0);
INSERT INTO `file_uploads` VALUES (189, 'bf151293-25f3-4d02-bf62-72024d748ef7.png', '4.1.png', '.png', 0, '3/bf151293-25f3-4d02-bf62-72024d748ef7.png', 3, '2024-04-01 13:36:22', 3, '2024-04-01 13:36:22', 0, 0);
INSERT INTO `file_uploads` VALUES (190, 'b29fa9b9-19f0-4853-8016-09ca144fe334.png', '4.png', '.png', 0, '3/b29fa9b9-19f0-4853-8016-09ca144fe334.png', 3, '2024-04-01 13:36:22', 3, '2024-04-01 13:36:22', 0, 0);
INSERT INTO `file_uploads` VALUES (191, 'b74b6906-f98b-4bbf-9ad3-e56d6761af34.png', '5.png', '.png', 0, '3/b74b6906-f98b-4bbf-9ad3-e56d6761af34.png', 3, '2024-04-01 13:36:22', 3, '2024-04-01 13:36:22', 0, 0);
INSERT INTO `file_uploads` VALUES (192, 'e8b8e6af-f88d-42a2-b23b-4e9a333f5a23.jpeg', '10.jpeg', '.jpeg', 0, '3/e8b8e6af-f88d-42a2-b23b-4e9a333f5a23.jpeg', 3, '2024-04-01 13:36:22', 3, '2024-04-01 13:36:22', 0, 0);
INSERT INTO `file_uploads` VALUES (193, '9d802f61-d6fb-418a-808c-11d2a6bdf9c9.png', '1.png', '.png', 0, '3/9d802f61-d6fb-418a-808c-11d2a6bdf9c9.png', 3, '2024-04-01 13:36:36', 3, '2024-04-01 13:36:36', 0, 0);
INSERT INTO `file_uploads` VALUES (194, '0ba9897e-9078-4429-ac79-2c07cf041603.jpeg', '2.jpeg', '.jpeg', 0, '3/0ba9897e-9078-4429-ac79-2c07cf041603.jpeg', 3, '2024-04-01 13:36:36', 3, '2024-04-01 13:36:36', 0, 0);
INSERT INTO `file_uploads` VALUES (195, '96fc27a7-ea61-4674-8825-28a51de5f4af.png', '3.png', '.png', 0, '3/96fc27a7-ea61-4674-8825-28a51de5f4af.png', 3, '2024-04-01 13:36:37', 3, '2024-04-01 13:36:37', 0, 0);
INSERT INTO `file_uploads` VALUES (196, 'ac59d86a-35e2-42ca-a2f5-d13ec7c58584.png', '4.1.png', '.png', 0, '3/ac59d86a-35e2-42ca-a2f5-d13ec7c58584.png', 3, '2024-04-01 13:36:37', 3, '2024-04-01 13:36:37', 0, 0);
INSERT INTO `file_uploads` VALUES (197, '94e2483c-9840-4156-acc3-1d451f086109.png', '4.png', '.png', 0, '3/94e2483c-9840-4156-acc3-1d451f086109.png', 3, '2024-04-01 13:36:37', 3, '2024-04-01 13:36:37', 0, 0);
INSERT INTO `file_uploads` VALUES (198, '688d0c0f-e27a-4e6e-8df5-149d55fd1982.png', '5.png', '.png', 0, '3/688d0c0f-e27a-4e6e-8df5-149d55fd1982.png', 3, '2024-04-01 13:36:37', 3, '2024-04-01 13:36:37', 0, 0);
INSERT INTO `file_uploads` VALUES (199, 'f33d7f58-7590-407c-a29b-f8c35af5de33.jpeg', '10.jpeg', '.jpeg', 0, '3/f33d7f58-7590-407c-a29b-f8c35af5de33.jpeg', 3, '2024-04-01 13:36:37', 3, '2024-04-01 13:36:37', 0, 0);
INSERT INTO `file_uploads` VALUES (200, '54fcbe4e-2df2-41ba-9651-6b7221e4aa8f.jpeg', '11.jpeg', '.jpeg', 0, '3/54fcbe4e-2df2-41ba-9651-6b7221e4aa8f.jpeg', 3, '2024-04-01 13:36:37', 3, '2024-04-01 13:36:37', 0, 0);
INSERT INTO `file_uploads` VALUES (201, 'ab60a4a0-08e5-4f57-82cf-6750f4a57cd2.png', '42.png', '.png', 0, '3/ab60a4a0-08e5-4f57-82cf-6750f4a57cd2.png', 3, '2024-04-01 13:36:37', 3, '2024-04-01 13:36:37', 0, 0);
INSERT INTO `file_uploads` VALUES (202, '1baa1836-57a2-46fd-82f2-5714bcd34aaf.png', '5.png', '.png', 0, '3/1baa1836-57a2-46fd-82f2-5714bcd34aaf.png', 3, '2024-04-01 13:43:54', 3, '2024-04-01 13:43:54', 0, 0);
INSERT INTO `file_uploads` VALUES (203, '521794c6-fdce-425b-ac17-7166785d6dd0.jpeg', '10.jpeg', '.jpeg', 0, '3/521794c6-fdce-425b-ac17-7166785d6dd0.jpeg', 3, '2024-04-01 13:43:54', 3, '2024-04-01 13:43:54', 0, 0);
INSERT INTO `file_uploads` VALUES (204, '3f3f0033-24a5-46ab-a185-34a84f6217fb.jpeg', '11.jpeg', '.jpeg', 0, '3/3f3f0033-24a5-46ab-a185-34a84f6217fb.jpeg', 3, '2024-04-01 13:43:54', 3, '2024-04-01 13:43:54', 0, 0);
INSERT INTO `file_uploads` VALUES (205, 'ce596ac0-b7a4-4380-8b4c-de555eb5b457.png', '42.png', '.png', 0, '3/ce596ac0-b7a4-4380-8b4c-de555eb5b457.png', 3, '2024-04-01 13:43:54', 3, '2024-04-01 13:43:54', 0, 0);
INSERT INTO `file_uploads` VALUES (206, '6007bd9d-1126-4a00-86b3-02cbc36c7265.jpeg', '2.jpeg', '.jpeg', 0, '3/6007bd9d-1126-4a00-86b3-02cbc36c7265.jpeg', 3, '2024-04-01 13:44:33', 3, '2024-04-01 13:44:33', 0, 0);
INSERT INTO `file_uploads` VALUES (207, '6b91ca7e-c351-4b55-b897-c5ec9fcb2974.png', '3.png', '.png', 0, '3/6b91ca7e-c351-4b55-b897-c5ec9fcb2974.png', 3, '2024-04-01 13:44:34', 3, '2024-04-01 13:44:34', 0, 0);
INSERT INTO `file_uploads` VALUES (208, '0a93e822-9f84-4c3a-8d20-81823c572f44.png', '4.1.png', '.png', 0, '3/0a93e822-9f84-4c3a-8d20-81823c572f44.png', 3, '2024-04-01 13:44:34', 3, '2024-04-01 13:44:34', 0, 0);
INSERT INTO `file_uploads` VALUES (209, 'dfd6e4a9-9664-4669-9326-34394891788b.png', '4.png', '.png', 0, '3/dfd6e4a9-9664-4669-9326-34394891788b.png', 3, '2024-04-01 13:44:34', 3, '2024-04-01 13:44:34', 0, 0);
INSERT INTO `file_uploads` VALUES (210, '8a4859b6-0044-43b7-9d3f-70f54f4e1e8a.png', '5.png', '.png', 0, '3/8a4859b6-0044-43b7-9d3f-70f54f4e1e8a.png', 3, '2024-04-01 13:44:34', 3, '2024-04-01 13:44:34', 0, 0);
INSERT INTO `file_uploads` VALUES (211, '067b755f-b86a-4f06-9a2d-129381291080.jpeg', '10.jpeg', '.jpeg', 0, '3/067b755f-b86a-4f06-9a2d-129381291080.jpeg', 3, '2024-04-01 13:44:34', 3, '2024-04-01 13:44:34', 0, 0);
INSERT INTO `file_uploads` VALUES (212, '56e3b40b-9325-4513-a887-dde5bf683a99.png', 'd2c9fd03-8343-4490-9c8c-285607c052d8.png', '.png', 0, '3/56e3b40b-9325-4513-a887-dde5bf683a99.png', 3, '2024-04-01 13:51:55', 3, '2024-04-01 13:51:55', 0, 0);
INSERT INTO `file_uploads` VALUES (213, 'a2e620b7-eb7e-4599-a3ec-f7e56bd5092e.png', '42.png', '.png', 0, '3/a2e620b7-eb7e-4599-a3ec-f7e56bd5092e.png', 3, '2024-04-01 13:52:05', 3, '2024-04-01 13:52:05', 0, 0);
INSERT INTO `file_uploads` VALUES (214, '4b6b2c98-73ee-4647-aa48-885adc472899.png', '42.png', '.png', 0, '3/4b6b2c98-73ee-4647-aa48-885adc472899.png', 3, '2024-04-01 13:52:49', 3, '2024-04-01 13:52:49', 0, 0);
INSERT INTO `file_uploads` VALUES (215, 'd5f92be8-987f-447a-a3d2-2a4251bac869.jpeg', '2.jpeg', '.jpeg', 0, '3/d5f92be8-987f-447a-a3d2-2a4251bac869.jpeg', 3, '2024-04-01 13:53:37', 3, '2024-04-01 13:53:37', 0, 0);
INSERT INTO `file_uploads` VALUES (216, '6e3b669a-a87f-496f-a003-96eb483749d2.png', '3.png', '.png', 0, '3/6e3b669a-a87f-496f-a003-96eb483749d2.png', 3, '2024-04-01 13:53:37', 3, '2024-04-01 13:53:37', 0, 0);
INSERT INTO `file_uploads` VALUES (217, '87e5fcba-1cbb-4f55-ab8c-6fbe1ae4fb1b.png', '4.1.png', '.png', 0, '3/87e5fcba-1cbb-4f55-ab8c-6fbe1ae4fb1b.png', 3, '2024-04-01 13:53:37', 3, '2024-04-01 13:53:37', 0, 0);
INSERT INTO `file_uploads` VALUES (218, '8346e39e-5236-41f6-abfb-d6798fed874c.png', '4.png', '.png', 0, '3/8346e39e-5236-41f6-abfb-d6798fed874c.png', 3, '2024-04-01 13:53:37', 3, '2024-04-01 13:53:37', 0, 0);
INSERT INTO `file_uploads` VALUES (219, '4cd989be-b6de-437e-a784-9bbd5c37090d.png', '5.png', '.png', 0, '3/4cd989be-b6de-437e-a784-9bbd5c37090d.png', 3, '2024-04-01 13:53:37', 3, '2024-04-01 13:53:37', 0, 0);
INSERT INTO `file_uploads` VALUES (220, '444ae39c-9dec-47bc-92b1-fefebdfacc65.jpeg', '10.jpeg', '.jpeg', 0, '3/444ae39c-9dec-47bc-92b1-fefebdfacc65.jpeg', 3, '2024-04-01 13:53:38', 3, '2024-04-01 13:53:38', 0, 0);
INSERT INTO `file_uploads` VALUES (221, '37546db4-a457-4266-92a4-f5e6fbe4b273.png', '3.png', '.png', 0, '3/37546db4-a457-4266-92a4-f5e6fbe4b273.png', 3, '2024-04-01 13:53:53', 3, '2024-04-01 13:53:53', 0, 0);
INSERT INTO `file_uploads` VALUES (222, '8b58af62-d485-4b3c-8e06-d1024253e528.png', '4.1.png', '.png', 0, '3/8b58af62-d485-4b3c-8e06-d1024253e528.png', 3, '2024-04-01 13:53:53', 3, '2024-04-01 13:53:53', 0, 0);
INSERT INTO `file_uploads` VALUES (223, 'fe297863-e090-4af4-acdd-dd03aa503d34.png', '4.png', '.png', 0, '3/fe297863-e090-4af4-acdd-dd03aa503d34.png', 3, '2024-04-01 13:53:53', 3, '2024-04-01 13:53:53', 0, 0);
INSERT INTO `file_uploads` VALUES (224, 'ec10e5ff-f220-47e8-bb37-7046ea210c9d.png', '5.png', '.png', 0, '3/ec10e5ff-f220-47e8-bb37-7046ea210c9d.png', 3, '2024-04-01 13:53:53', 3, '2024-04-01 13:53:53', 0, 0);
INSERT INTO `file_uploads` VALUES (225, '5b02934a-9187-4dbd-94db-d281938d2b1d.jpeg', '10.jpeg', '.jpeg', 0, '3/5b02934a-9187-4dbd-94db-d281938d2b1d.jpeg', 3, '2024-04-01 13:53:54', 3, '2024-04-01 13:53:54', 0, 0);
INSERT INTO `file_uploads` VALUES (226, '48f71d92-77cf-450e-85bc-10216b7b1fa5.jpeg', '11.jpeg', '.jpeg', 0, '3/48f71d92-77cf-450e-85bc-10216b7b1fa5.jpeg', 3, '2024-04-01 13:53:54', 3, '2024-04-01 13:53:54', 0, 0);
INSERT INTO `file_uploads` VALUES (227, '3bc9e30c-aa74-430a-9c43-f24276f63564.png', '4.1.png', '.png', 0, '3/3bc9e30c-aa74-430a-9c43-f24276f63564.png', 3, '2024-04-01 13:54:41', 3, '2024-04-01 13:54:41', 0, 0);
INSERT INTO `file_uploads` VALUES (228, 'ddf34559-5a92-45ba-af1c-f6385b61c355.png', '4.png', '.png', 0, '3/ddf34559-5a92-45ba-af1c-f6385b61c355.png', 3, '2024-04-01 13:54:41', 3, '2024-04-01 13:54:41', 0, 0);
INSERT INTO `file_uploads` VALUES (229, '5e72e92c-094a-4847-93a7-54cb5b8ecaa0.png', '5.png', '.png', 0, '3/5e72e92c-094a-4847-93a7-54cb5b8ecaa0.png', 3, '2024-04-01 13:54:41', 3, '2024-04-01 13:54:41', 0, 0);
INSERT INTO `file_uploads` VALUES (230, '24b7ad8c-ccd3-488b-908b-851bacbba0d8.jpeg', '10.jpeg', '.jpeg', 0, '3/24b7ad8c-ccd3-488b-908b-851bacbba0d8.jpeg', 3, '2024-04-01 13:54:41', 3, '2024-04-01 13:54:41', 0, 0);
INSERT INTO `file_uploads` VALUES (231, '34feb8a6-d5e9-4517-be3f-bc406a8ec1b6.jpeg', '11.jpeg', '.jpeg', 0, '3/34feb8a6-d5e9-4517-be3f-bc406a8ec1b6.jpeg', 3, '2024-04-01 13:54:41', 3, '2024-04-01 13:54:41', 0, 0);
INSERT INTO `file_uploads` VALUES (232, '33b95305-d4b1-493c-9ed6-21a377084600.png', '3.png', '.png', 0, '3/33b95305-d4b1-493c-9ed6-21a377084600.png', 3, '2024-04-01 13:55:25', 3, '2024-04-01 13:55:25', 0, 0);
INSERT INTO `file_uploads` VALUES (233, 'fcf95399-e025-4368-a712-e7316d56cef1.png', '4.1.png', '.png', 0, '3/fcf95399-e025-4368-a712-e7316d56cef1.png', 3, '2024-04-01 13:55:25', 3, '2024-04-01 13:55:25', 0, 0);
INSERT INTO `file_uploads` VALUES (234, '85d36c55-bca4-49be-8cf9-8e531a26f0fe.png', '4.png', '.png', 0, '3/85d36c55-bca4-49be-8cf9-8e531a26f0fe.png', 3, '2024-04-01 13:55:25', 3, '2024-04-01 13:55:25', 0, 0);
INSERT INTO `file_uploads` VALUES (235, '54b25871-bacf-4931-bbfc-04a1bf1542f3.png', '5.png', '.png', 0, '3/54b25871-bacf-4931-bbfc-04a1bf1542f3.png', 3, '2024-04-01 13:55:26', 3, '2024-04-01 13:55:26', 0, 0);
INSERT INTO `file_uploads` VALUES (236, '2f01461f-e3ae-4c98-a4f2-aa1410676250.jpeg', '10.jpeg', '.jpeg', 0, '3/2f01461f-e3ae-4c98-a4f2-aa1410676250.jpeg', 3, '2024-04-01 13:55:26', 3, '2024-04-01 13:55:26', 0, 0);
INSERT INTO `file_uploads` VALUES (237, 'ec6282e0-c72b-48d5-a6f4-0e7649239d21.jpeg', '11.jpeg', '.jpeg', 0, '3/ec6282e0-c72b-48d5-a6f4-0e7649239d21.jpeg', 3, '2024-04-01 13:55:26', 3, '2024-04-01 13:55:26', 0, 0);
INSERT INTO `file_uploads` VALUES (238, '205b4ba0-1a41-4cf9-b511-877332eda438.png', '1.png', '.png', 0, '3/205b4ba0-1a41-4cf9-b511-877332eda438.png', 3, '2024-04-01 13:56:24', 3, '2024-04-01 13:56:24', 0, 0);
INSERT INTO `file_uploads` VALUES (239, '1dbde6fa-fe9d-4975-bb4a-152c1375eb7b.jpeg', '2.jpeg', '.jpeg', 0, '3/1dbde6fa-fe9d-4975-bb4a-152c1375eb7b.jpeg', 3, '2024-04-01 13:56:24', 3, '2024-04-01 13:56:24', 0, 0);
INSERT INTO `file_uploads` VALUES (240, 'ed2dfc01-bd64-4aa6-bf75-e620bf6f9c2d.png', '3.png', '.png', 0, '3/ed2dfc01-bd64-4aa6-bf75-e620bf6f9c2d.png', 3, '2024-04-01 13:56:24', 3, '2024-04-01 13:56:24', 0, 0);
INSERT INTO `file_uploads` VALUES (241, 'd8085bdf-4cd5-4a27-a7d2-f6ec913c39a0.png', '4.1.png', '.png', 0, '3/d8085bdf-4cd5-4a27-a7d2-f6ec913c39a0.png', 3, '2024-04-01 13:56:24', 3, '2024-04-01 13:56:24', 0, 0);
INSERT INTO `file_uploads` VALUES (242, '82d898b4-7553-462b-9593-67bb758de715.png', '4.png', '.png', 0, '3/82d898b4-7553-462b-9593-67bb758de715.png', 3, '2024-04-01 13:56:24', 3, '2024-04-01 13:56:24', 0, 0);
INSERT INTO `file_uploads` VALUES (243, 'f2e65859-9933-4bc6-ad1d-72c00813882c.png', '5.png', '.png', 0, '3/f2e65859-9933-4bc6-ad1d-72c00813882c.png', 3, '2024-04-01 13:56:24', 3, '2024-04-01 13:56:24', 0, 0);
INSERT INTO `file_uploads` VALUES (244, 'a506afe8-0ac2-4065-935e-0e32b73762eb.jpeg', '10.jpeg', '.jpeg', 0, '3/a506afe8-0ac2-4065-935e-0e32b73762eb.jpeg', 3, '2024-04-01 13:56:24', 3, '2024-04-01 13:56:24', 0, 0);
INSERT INTO `file_uploads` VALUES (245, 'ac4f9c2e-56af-4753-a8c8-c0f4d8cb6f01.jpeg', '11.jpeg', '.jpeg', 0, '3/ac4f9c2e-56af-4753-a8c8-c0f4d8cb6f01.jpeg', 3, '2024-04-01 13:56:25', 3, '2024-04-01 13:56:25', 0, 0);
INSERT INTO `file_uploads` VALUES (246, '4a16e11b-9410-4410-a1a5-9a1771ced414.png', '42.png', '.png', 0, '3/4a16e11b-9410-4410-a1a5-9a1771ced414.png', 3, '2024-04-01 13:56:25', 3, '2024-04-01 13:56:25', 0, 0);
INSERT INTO `file_uploads` VALUES (247, 'bb94a741-691f-4188-a5bd-b791a669497d.png', 'd2c9fd03-8343-4490-9c8c-285607c052d8.png', '.png', 0, '3/bb94a741-691f-4188-a5bd-b791a669497d.png', 3, '2024-04-01 13:56:25', 3, '2024-04-01 13:56:25', 0, 0);
INSERT INTO `file_uploads` VALUES (248, '4c26df75-5724-406e-b3ae-534789413f48.png', '3.png', '.png', 0, '3/4c26df75-5724-406e-b3ae-534789413f48.png', 3, '2024-04-01 13:58:07', 3, '2024-04-01 13:58:07', 0, 0);
INSERT INTO `file_uploads` VALUES (249, 'b045d05e-2297-4048-a580-dcae783d2c4d.png', '4.1.png', '.png', 0, '3/b045d05e-2297-4048-a580-dcae783d2c4d.png', 3, '2024-04-01 13:58:07', 3, '2024-04-01 13:58:07', 0, 0);
INSERT INTO `file_uploads` VALUES (250, '41fae3a3-e83b-499e-b540-95f5d7aa26cb.png', '4.png', '.png', 0, '3/41fae3a3-e83b-499e-b540-95f5d7aa26cb.png', 3, '2024-04-01 13:58:07', 3, '2024-04-01 13:58:07', 0, 0);
INSERT INTO `file_uploads` VALUES (251, 'f59cd89d-d89c-44be-a7ae-b9fb4a0474f3.png', '5.png', '.png', 0, '3/f59cd89d-d89c-44be-a7ae-b9fb4a0474f3.png', 3, '2024-04-01 13:58:07', 3, '2024-04-01 13:58:07', 0, 0);
INSERT INTO `file_uploads` VALUES (252, '334ab187-e1b3-443f-ad32-cb1fca4c67c2.jpeg', '10.jpeg', '.jpeg', 0, '3/334ab187-e1b3-443f-ad32-cb1fca4c67c2.jpeg', 3, '2024-04-01 13:58:07', 3, '2024-04-01 13:58:07', 0, 0);
INSERT INTO `file_uploads` VALUES (253, 'd8e96b9a-c4a8-4095-845b-fa88ad1d5e8d.jpeg', '11.jpeg', '.jpeg', 0, '3/d8e96b9a-c4a8-4095-845b-fa88ad1d5e8d.jpeg', 3, '2024-04-01 13:58:07', 3, '2024-04-01 13:58:07', 0, 0);
INSERT INTO `file_uploads` VALUES (254, '8a81e45c-7bb2-4e37-a1e9-927f7f0f7547.jpg', '5fb95170-6780-40b1-bcfd-dbe9b329736e.jpg', '.jpg', 0, '3/8a81e45c-7bb2-4e37-a1e9-927f7f0f7547.jpg', 3, '2024-04-01 14:52:00', 3, '2024-04-01 14:52:00', 0, 0);
INSERT INTO `file_uploads` VALUES (255, 'a986a4b0-1063-4f16-98aa-67891f3ee939.png', '截屏2024-03-31 13.01.40.png', '.png', 0, '4/a986a4b0-1063-4f16-98aa-67891f3ee939.png', 4, '2024-04-01 15:50:48', 4, '2024-04-01 15:50:48', 0, 0);
INSERT INTO `file_uploads` VALUES (258, '709359b3-10fb-41fb-8099-38aa40cdcbd2.png', '截屏2024-03-30 19.49.03.png', '.png', 0, '4/709359b3-10fb-41fb-8099-38aa40cdcbd2.png', 4, '2024-04-01 16:57:20', 4, '2024-04-01 16:57:20', 0, 0);
INSERT INTO `file_uploads` VALUES (259, '95794695-4a5d-4b05-bbe2-341f5977434b.png', '截屏2024-03-31 12.16.56.png', '.png', 0, '4/95794695-4a5d-4b05-bbe2-341f5977434b.png', 4, '2024-04-01 17:13:00', 4, '2024-04-01 17:13:00', 0, 0);
INSERT INTO `file_uploads` VALUES (260, 'f0e70048-dcb0-44c4-95de-0a402f4bce8a.png', '截屏2024-03-31 12.16.56.png', '.png', 0, '4/f0e70048-dcb0-44c4-95de-0a402f4bce8a.png', 4, '2024-04-01 17:13:07', 4, '2024-04-01 17:13:07', 0, 0);
INSERT INTO `file_uploads` VALUES (261, '019dbb4f-8167-43c6-a101-1e4da04051ef.png', '截屏2024-03-31 12.16.56.png', '.png', 0, '4/019dbb4f-8167-43c6-a101-1e4da04051ef.png', 4, '2024-04-01 17:13:14', 4, '2024-04-01 17:13:14', 0, 0);
INSERT INTO `file_uploads` VALUES (262, 'a922125f-5353-415c-9fb4-4a1b24732cf6.png', '2.png', '.png', 0, '1/a922125f-5353-415c-9fb4-4a1b24732cf6.png', 1, '2024-04-01 23:53:41', 1, '2024-04-01 23:53:41', 0, 0);
INSERT INTO `file_uploads` VALUES (264, 'efdaa2a9-3ea8-45a1-aa8c-dc3029336ef9.png', '2.png', '.png', 0, '1/efdaa2a9-3ea8-45a1-aa8c-dc3029336ef9.png', 1, '2024-04-01 23:56:20', 1, '2024-04-01 23:56:20', 0, 0);
INSERT INTO `file_uploads` VALUES (265, 'd2649e4b-d0da-4518-bd9b-8b76856ceb37.png', '2.png', '.png', 0, '1/d2649e4b-d0da-4518-bd9b-8b76856ceb37.png', 1, '2024-04-02 00:07:15', 1, '2024-04-02 00:07:15', 0, 0);
INSERT INTO `file_uploads` VALUES (269, '43a7c8f0-4334-4101-991b-0948bd8c79c4.png', 'SCR-20240402-ihtu.png', '.png', 0, '3/43a7c8f0-4334-4101-991b-0948bd8c79c4.png', 3, '2024-04-02 08:55:01', 3, '2024-04-02 08:55:01', 0, 0);
INSERT INTO `file_uploads` VALUES (270, 'af2bb102-80a4-4573-aad1-45de5c5dfc66.png', 'SCR-20240402-ihvo.png', '.png', 0, '3/af2bb102-80a4-4573-aad1-45de5c5dfc66.png', 3, '2024-04-02 08:55:02', 3, '2024-04-02 08:55:02', 0, 0);
INSERT INTO `file_uploads` VALUES (271, '33729028-c7b6-4b09-afe5-44aeb624bb9e.png', 'SCR-20240402-ihtu.png', '.png', 0, '3/33729028-c7b6-4b09-afe5-44aeb624bb9e.png', 3, '2024-04-02 09:12:54', 3, '2024-04-02 09:12:54', 0, 0);
INSERT INTO `file_uploads` VALUES (272, '8472885c-dd29-456b-b876-3092781eada9.png', 'SCR-20240402-ihvo.png', '.png', 0, '3/8472885c-dd29-456b-b876-3092781eada9.png', 3, '2024-04-02 09:12:55', 3, '2024-04-02 09:12:55', 0, 0);
INSERT INTO `file_uploads` VALUES (273, '504e90b2-803b-41b2-960d-24c8f0dc89bc.jpg', '论文-高等教育前沿1.jpg', '.jpg', 0, '5/504e90b2-803b-41b2-960d-24c8f0dc89bc.jpg', 5, '2024-04-02 09:17:03', 5, '2024-04-02 09:17:03', 0, 0);
INSERT INTO `file_uploads` VALUES (274, 'f9fe0704-869d-41bd-aa3f-f5f312fe304b.jpg', '论文-高等教育前沿5.jpg', '.jpg', 0, '5/f9fe0704-869d-41bd-aa3f-f5f312fe304b.jpg', 5, '2024-04-02 09:17:04', 5, '2024-04-02 09:17:04', 0, 0);
INSERT INTO `file_uploads` VALUES (275, '1da5281f-e282-4f8b-b62c-418fe556b454.jpg', '鸿蒙认证.jpg', '.jpg', 0, '4/1da5281f-e282-4f8b-b62c-418fe556b454.jpg', 4, '2024-04-02 09:57:41', 4, '2024-04-02 09:57:41', 0, 0);
INSERT INTO `file_uploads` VALUES (276, '0561b6be-1594-41e3-bc4f-3043f76d1c49.png', '截屏2024-04-01 23.40.38.png', '.png', 0, '4/0561b6be-1594-41e3-bc4f-3043f76d1c49.png', 4, '2024-04-02 09:59:19', 4, '2024-04-02 09:59:19', 0, 0);
INSERT INTO `file_uploads` VALUES (277, '231ff759-5fed-4268-8b63-b0f41afedc63.docx', '2021102349田雷宇.docx', '.docx', 0, '4/231ff759-5fed-4268-8b63-b0f41afedc63.docx', 4, '2024-04-09 09:14:38', 4, '2024-04-09 09:14:38', 0, 0);
INSERT INTO `file_uploads` VALUES (278, 'da8d5318-31ad-4f25-b14a-db9a0b20f302.jpg', '鸿蒙认证.jpg', '.jpg', 0, '4/da8d5318-31ad-4f25-b14a-db9a0b20f302.jpg', 4, '2024-04-09 09:16:26', 4, '2024-04-09 09:16:26', 0, 0);
INSERT INTO `file_uploads` VALUES (279, '4f675a19-5715-431e-9ae7-cd8515693fef.JPG', 'IMG_7781.JPG', '.JPG', 0, '4/4f675a19-5715-431e-9ae7-cd8515693fef.JPG', 4, '2024-04-09 09:16:51', 4, '2024-04-09 09:16:51', 0, 0);
INSERT INTO `file_uploads` VALUES (280, '2c65a6bc-a303-4750-8349-6dd5f430c8c0.mov', 'Screen Recording 2024-04-03 at 10.51.51 AM.mov', '.mov', 0, '3/2c65a6bc-a303-4750-8349-6dd5f430c8c0.mov', 3, '2024-04-17 09:55:17', 3, '2024-04-17 09:55:17', 0, 0);
INSERT INTO `file_uploads` VALUES (281, 'e492f1ca-5222-4adf-af74-f4df7cc74c72.mov', 'Screen Recording 2024-04-03 at 10.51.51 AM.mov', '.mov', 0, '3/e492f1ca-5222-4adf-af74-f4df7cc74c72.mov', 3, '2024-04-17 11:06:28', 3, '2024-04-17 11:06:28', 0, 0);
INSERT INTO `file_uploads` VALUES (282, 'c0d3d226-0b55-40ef-9137-ceb0cdd8ce2d.png', 'Ojindex.png', '.png', 0, '3/c0d3d226-0b55-40ef-9137-ceb0cdd8ce2d.png', 3, '2024-04-17 11:11:47', 3, '2024-04-17 11:11:47', 0, 0);
INSERT INTO `file_uploads` VALUES (283, '175db080-5c59-42f4-badf-7abc6580c416.mov', 'Screen Recording 2024-04-03 at 10.51.51 AM.mov', '.mov', 0, '3/175db080-5c59-42f4-badf-7abc6580c416.mov', 3, '2024-04-17 11:12:08', 3, '2024-04-17 11:12:08', 0, 0);
INSERT INTO `file_uploads` VALUES (284, '04010301-912d-4d24-ab78-857efd234cd5.mov', 'Screen Recording 2024-04-01 at 10.40.47 PM.mov', '.mov', 0, '3/04010301-912d-4d24-ab78-857efd234cd5.mov', 3, '2024-04-17 11:20:09', 3, '2024-04-17 11:20:09', 0, 0);
INSERT INTO `file_uploads` VALUES (285, 'c58a4813-b9ff-451b-bd01-70b76e5b1895.png', 'SCR-20240402-ihvo.png', '.png', 0, '3/c58a4813-b9ff-451b-bd01-70b76e5b1895.png', 3, '2024-04-18 09:31:03', 3, '2024-04-18 09:31:03', 0, 0);
INSERT INTO `file_uploads` VALUES (286, '3b467d5b-6e6a-4810-9079-b7f284d2a609.png', 'SCR-20240402-ihtu.png', '.png', 0, '3/3b467d5b-6e6a-4810-9079-b7f284d2a609.png', 3, '2024-04-18 09:31:12', 3, '2024-04-18 09:31:12', 0, 0);
INSERT INTO `file_uploads` VALUES (287, '9353a41e-91ea-4580-b6c7-345de2e08a31.mov', 'Screen Recording 2024-04-01 at 10.40.47 PM.mov', '.mov', 0, '3/9353a41e-91ea-4580-b6c7-345de2e08a31.mov', 3, '2024-04-18 09:32:09', 3, '2024-04-18 09:32:09', 0, 0);
INSERT INTO `file_uploads` VALUES (288, '75024ec1-158b-4aa1-8451-0358d7067d80.mov', 'Screen Recording 2024-04-01 at 10.40.47 PM.mov', '.mov', 0, '3/75024ec1-158b-4aa1-8451-0358d7067d80.mov', 3, '2024-04-18 09:48:23', 3, '2024-04-18 09:48:23', 0, 0);
INSERT INTO `file_uploads` VALUES (289, 'f192bfa0-f405-471d-b4ad-586d8ab28119.png', 'SCR-20240402-ihtu.png', '.png', 0, '3/f192bfa0-f405-471d-b4ad-586d8ab28119.png', 3, '2024-04-18 09:48:34', 3, '2024-04-18 09:48:34', 0, 0);
INSERT INTO `file_uploads` VALUES (290, '409bd44a-35cb-4519-a4dc-9b317c98793e.jpg', '微信图片_20231124185520.jpg', '.jpg', 0, '3/409bd44a-35cb-4519-a4dc-9b317c98793e.jpg', 3, '2024-04-18 10:10:32', 3, '2024-04-18 10:10:32', 0, 0);
INSERT INTO `file_uploads` VALUES (291, '4ad0d2be-ba8d-4ac3-857a-62555fee3de0.mp4', '杨易达.mp4', '.mp4', 0, '3/4ad0d2be-ba8d-4ac3-857a-62555fee3de0.mp4', 3, '2024-04-18 10:11:47', 3, '2024-04-18 10:11:47', 0, 0);
INSERT INTO `file_uploads` VALUES (292, '40fbc933-662b-43d3-94f1-68457aa898ad.png', '专业社团纳新海报.png', '.png', 0, '7/40fbc933-662b-43d3-94f1-68457aa898ad.png', 7, '2024-04-18 10:14:06', 7, '2024-04-18 10:14:06', 0, 0);
INSERT INTO `file_uploads` VALUES (293, '8b41808a-450e-4905-ad41-14152d164f16.png', '1.png', '.png', 0, '1/8b41808a-450e-4905-ad41-14152d164f16.png', 1, '2024-04-18 15:03:36', 1, '2024-04-18 15:03:36', 0, 0);
INSERT INTO `file_uploads` VALUES (294, '1e58c35e-fb2d-4933-926f-64bc9a87174a.png', '1.png', '.png', 0, '3/1e58c35e-fb2d-4933-926f-64bc9a87174a.png', 3, '2024-04-18 15:04:09', 3, '2024-04-18 15:04:09', 0, 0);
INSERT INTO `file_uploads` VALUES (295, '00563281-fcc4-473f-9d44-be3b27b24692.png', '21.png', '.png', 0, '3/00563281-fcc4-473f-9d44-be3b27b24692.png', 3, '2024-04-18 15:10:12', 3, '2024-04-18 15:10:12', 0, 0);
INSERT INTO `file_uploads` VALUES (296, '2f702c14-0bea-4895-98d5-f5560e99372a.png', '22.png', '.png', 0, '3/2f702c14-0bea-4895-98d5-f5560e99372a.png', 3, '2024-04-18 15:10:17', 3, '2024-04-18 15:10:17', 0, 0);
INSERT INTO `file_uploads` VALUES (297, 'dca26754-f7b9-4f6f-94ef-4a64295cee59.jpeg', '20.jpeg', '.jpeg', 0, '3/dca26754-f7b9-4f6f-94ef-4a64295cee59.jpeg', 3, '2024-04-18 15:11:10', 3, '2024-04-18 15:11:10', 0, 0);
INSERT INTO `file_uploads` VALUES (298, '7346d7b6-b7ef-4070-b715-5cc2bf72860f.png', '32.png', '.png', 0, '3/7346d7b6-b7ef-4070-b715-5cc2bf72860f.png', 3, '2024-04-18 15:13:05', 3, '2024-04-18 15:13:05', 0, 0);
INSERT INTO `file_uploads` VALUES (299, '005dbf80-a371-443f-ae22-2bd2993a3157.png', '33.png', '.png', 0, '3/005dbf80-a371-443f-ae22-2bd2993a3157.png', 3, '2024-04-18 15:13:05', 3, '2024-04-18 15:13:05', 0, 0);
INSERT INTO `file_uploads` VALUES (300, '0502f1fd-421e-4cab-9b0b-5f9173441a2f.png', '555.png', '.png', 0, '3/0502f1fd-421e-4cab-9b0b-5f9173441a2f.png', 3, '2024-04-18 15:14:35', 3, '2024-04-18 15:14:35', 0, 0);
INSERT INTO `file_uploads` VALUES (301, 'cf1ff12b-2582-483e-ad94-4e6d61524c9d.png', '2222.png', '.png', 0, '3/cf1ff12b-2582-483e-ad94-4e6d61524c9d.png', 3, '2024-04-18 15:15:46', 3, '2024-04-18 15:15:46', 0, 0);
INSERT INTO `file_uploads` VALUES (302, 'a9a6b5f7-6bf1-4888-8f6a-775393bbdbee.png', '801.png', '.png', 0, '1/a9a6b5f7-6bf1-4888-8f6a-775393bbdbee.png', 1, '2024-04-18 15:19:56', 1, '2024-04-18 15:19:56', 0, 0);
INSERT INTO `file_uploads` VALUES (303, 'e22bc38f-7e8d-4677-aeae-ce75a49bf6bc.mov', 'Screen Recording 2024-04-18 at 3.33.24 PM.mov', '.mov', 0, '3/e22bc38f-7e8d-4677-aeae-ce75a49bf6bc.mov', 3, '2024-04-18 15:34:20', 3, '2024-04-18 15:34:20', 0, 0);
INSERT INTO `file_uploads` VALUES (304, 'c1fc3f50-e288-4a57-9f5f-45762cbb00db.jpeg', '799.jpeg', '.jpeg', 0, '3/c1fc3f50-e288-4a57-9f5f-45762cbb00db.jpeg', 3, '2024-04-18 15:36:22', 3, '2024-04-18 15:36:22', 0, 0);
INSERT INTO `file_uploads` VALUES (305, 'a51ac6c9-1950-4737-9071-88cf21f181a0.jpg', 'A封面.jpg', '.jpg', 0, '5/a51ac6c9-1950-4737-9071-88cf21f181a0.jpg', 5, '2024-04-19 10:31:27', 5, '2024-04-19 10:31:27', 0, 0);
INSERT INTO `file_uploads` VALUES (306, '338f061c-b7f7-4e5a-ae89-7194120701c0.jpg', 'B2优秀班级.jpg', '.jpg', 0, '5/338f061c-b7f7-4e5a-ae89-7194120701c0.jpg', 5, '2024-04-19 10:31:46', 5, '2024-04-19 10:31:46', 0, 0);
INSERT INTO `file_uploads` VALUES (307, '58939304-e824-4192-a1a5-0cf01f0bf49c.jpg', 'B2优秀班级1.jpg', '.jpg', 0, '5/58939304-e824-4192-a1a5-0cf01f0bf49c.jpg', 5, '2024-04-19 10:31:46', 5, '2024-04-19 10:31:46', 0, 0);
INSERT INTO `file_uploads` VALUES (308, '45ca4c96-45ce-4573-af38-761892400f6f.jpg', '优秀寝室1.jpg', '.jpg', 0, '5/45ca4c96-45ce-4573-af38-761892400f6f.jpg', 5, '2024-04-19 10:31:47', 5, '2024-04-19 10:31:47', 0, 0);
INSERT INTO `file_uploads` VALUES (309, '1117848d-c8fa-44b3-b58f-a620325cb955.jpg', '优秀寝室2.jpg', '.jpg', 0, '5/1117848d-c8fa-44b3-b58f-a620325cb955.jpg', 5, '2024-04-19 10:31:47', 5, '2024-04-19 10:31:47', 0, 0);
INSERT INTO `file_uploads` VALUES (310, 'd07b03a7-b0ba-4979-9d4c-ca9c4ca891d6.jpg', '优秀寝室3.jpg', '.jpg', 0, '5/d07b03a7-b0ba-4979-9d4c-ca9c4ca891d6.jpg', 5, '2024-04-19 10:31:47', 5, '2024-04-19 10:31:47', 0, 0);
INSERT INTO `file_uploads` VALUES (311, '426677c5-32d3-4635-8614-5f7206851942.jpg', '优秀寝室4.jpg', '.jpg', 0, '5/426677c5-32d3-4635-8614-5f7206851942.jpg', 5, '2024-04-19 10:31:47', 5, '2024-04-19 10:31:47', 0, 0);
INSERT INTO `file_uploads` VALUES (312, 'e4b8aec7-c3a4-4646-8ee2-d79f5dd02b1f.jpg', '优秀寝室5.jpg', '.jpg', 0, '5/e4b8aec7-c3a4-4646-8ee2-d79f5dd02b1f.jpg', 5, '2024-04-19 10:31:47', 5, '2024-04-19 10:31:47', 0, 0);
INSERT INTO `file_uploads` VALUES (313, '75fe6552-4f8f-4466-a398-fe7fd471f4cf.jpg', '优秀寝室6.jpg', '.jpg', 0, '5/75fe6552-4f8f-4466-a398-fe7fd471f4cf.jpg', 5, '2024-04-19 10:31:47', 5, '2024-04-19 10:31:47', 0, 0);
INSERT INTO `file_uploads` VALUES (314, '3882eaee-5051-4ae9-9302-9af7c97cd22d.jpg', '优秀寝室7.jpg', '.jpg', 0, '5/3882eaee-5051-4ae9-9302-9af7c97cd22d.jpg', 5, '2024-04-19 10:31:48', 5, '2024-04-19 10:31:48', 0, 0);
INSERT INTO `file_uploads` VALUES (315, 'ea122197-19ff-4678-8efa-14e8ddd9afbb.jpg', '优秀寝室9.jpg', '.jpg', 0, '5/ea122197-19ff-4678-8efa-14e8ddd9afbb.jpg', 5, '2024-04-19 10:31:48', 5, '2024-04-19 10:31:48', 0, 0);
INSERT INTO `file_uploads` VALUES (316, 'de70ec63-b5de-400f-ab12-9b2837ecaba5.jpg', '优秀寝室10.jpg', '.jpg', 0, '5/de70ec63-b5de-400f-ab12-9b2837ecaba5.jpg', 5, '2024-04-19 10:31:48', 5, '2024-04-19 10:31:48', 0, 0);
INSERT INTO `file_uploads` VALUES (317, '954b4b8d-785e-467c-928a-2386af3a7a92.jpg', '优秀寝室11.jpg', '.jpg', 0, '5/954b4b8d-785e-467c-928a-2386af3a7a92.jpg', 5, '2024-04-19 10:31:48', 5, '2024-04-19 10:31:48', 0, 0);
INSERT INTO `file_uploads` VALUES (318, '96017df7-32a0-448a-ac4e-9070a26924b0.jpg', '优秀寝室12.jpg', '.jpg', 0, '5/96017df7-32a0-448a-ac4e-9070a26924b0.jpg', 5, '2024-04-19 10:31:48', 5, '2024-04-19 10:31:48', 0, 0);
INSERT INTO `file_uploads` VALUES (319, '4445135d-387d-45a5-a0ba-c3a56b1e916c.jpg', '优秀寝室13.jpg', '.jpg', 0, '5/4445135d-387d-45a5-a0ba-c3a56b1e916c.jpg', 5, '2024-04-19 10:31:48', 5, '2024-04-19 10:31:48', 0, 0);
INSERT INTO `file_uploads` VALUES (320, 'deca6127-fa5a-4deb-8cbf-92c1818e5875.jpg', '优秀寝室14.jpg', '.jpg', 0, '5/deca6127-fa5a-4deb-8cbf-92c1818e5875.jpg', 5, '2024-04-19 10:31:48', 5, '2024-04-19 10:31:48', 0, 0);
INSERT INTO `file_uploads` VALUES (321, '97cce3d3-3254-425f-8e4c-2e7711768229.jpg', '优秀寝室15.jpg', '.jpg', 0, '5/97cce3d3-3254-425f-8e4c-2e7711768229.jpg', 5, '2024-04-19 10:31:49', 5, '2024-04-19 10:31:49', 0, 0);
INSERT INTO `file_uploads` VALUES (322, '4a866d3b-bbce-463c-9fd3-d3303bb68ab2.jpg', '优秀寝室16.jpg', '.jpg', 0, '5/4a866d3b-bbce-463c-9fd3-d3303bb68ab2.jpg', 5, '2024-04-19 10:31:49', 5, '2024-04-19 10:31:49', 0, 0);
INSERT INTO `file_uploads` VALUES (323, 'ee02c45b-d8ba-4d07-aebc-9a948509c5f6.jpg', '0封面.jpg', '.jpg', 0, '5/ee02c45b-d8ba-4d07-aebc-9a948509c5f6.jpg', 5, '2024-04-19 10:34:33', 5, '2024-04-19 10:34:33', 0, 0);
INSERT INTO `file_uploads` VALUES (324, 'ea63f3a3-34fc-4647-be82-a741a44832cf.jpg', '1.jpg', '.jpg', 0, '5/ea63f3a3-34fc-4647-be82-a741a44832cf.jpg', 5, '2024-04-19 10:34:34', 5, '2024-04-19 10:34:34', 0, 0);
INSERT INTO `file_uploads` VALUES (325, '5ebe8af8-ef3e-4873-be4c-2bf50a3c596b.jpg', '2.jpg', '.jpg', 0, '5/5ebe8af8-ef3e-4873-be4c-2bf50a3c596b.jpg', 5, '2024-04-19 10:34:34', 5, '2024-04-19 10:34:34', 0, 0);
INSERT INTO `file_uploads` VALUES (326, '005bdc8e-9483-413f-a835-6031a05c85cf.jpg', '3.jpg', '.jpg', 0, '5/005bdc8e-9483-413f-a835-6031a05c85cf.jpg', 5, '2024-04-19 10:34:34', 5, '2024-04-19 10:34:34', 0, 0);
INSERT INTO `file_uploads` VALUES (327, 'fc82f0cb-495a-41a0-bea0-d55f402b121b.jpg', '4.jpg', '.jpg', 0, '5/fc82f0cb-495a-41a0-bea0-d55f402b121b.jpg', 5, '2024-04-19 10:34:34', 5, '2024-04-19 10:34:34', 0, 0);
INSERT INTO `file_uploads` VALUES (328, 'f38251f8-ee7f-45ef-b2ec-4750b847946c.jpg', '5.jpg', '.jpg', 0, '5/f38251f8-ee7f-45ef-b2ec-4750b847946c.jpg', 5, '2024-04-19 10:34:34', 5, '2024-04-19 10:34:34', 0, 0);
INSERT INTO `file_uploads` VALUES (329, '6cf57657-a675-4a09-8fe7-a660cd251646.jpg', '6.jpg', '.jpg', 0, '5/6cf57657-a675-4a09-8fe7-a660cd251646.jpg', 5, '2024-04-19 10:34:34', 5, '2024-04-19 10:34:34', 0, 0);
INSERT INTO `file_uploads` VALUES (330, '3a70d590-2fb0-47fa-b87d-f6eba6c3b9ff.jpg', '7.jpg', '.jpg', 0, '5/3a70d590-2fb0-47fa-b87d-f6eba6c3b9ff.jpg', 5, '2024-04-19 10:34:35', 5, '2024-04-19 10:34:35', 0, 0);
INSERT INTO `file_uploads` VALUES (331, 'aee6dd3a-ba77-46dc-969d-11c7c4f56e1d.jpg', '8.jpg', '.jpg', 0, '5/aee6dd3a-ba77-46dc-969d-11c7c4f56e1d.jpg', 5, '2024-04-19 10:34:35', 5, '2024-04-19 10:34:35', 0, 0);
INSERT INTO `file_uploads` VALUES (332, '1a2ecbae-407d-4072-974a-755a2075866c.jpg', '9.jpg', '.jpg', 0, '5/1a2ecbae-407d-4072-974a-755a2075866c.jpg', 5, '2024-04-19 10:34:35', 5, '2024-04-19 10:34:35', 0, 0);
INSERT INTO `file_uploads` VALUES (333, '88640b56-5e41-475b-8460-ca84faacfd1a.jpg', '10.jpg', '.jpg', 0, '5/88640b56-5e41-475b-8460-ca84faacfd1a.jpg', 5, '2024-04-19 10:34:36', 5, '2024-04-19 10:34:36', 0, 0);
INSERT INTO `file_uploads` VALUES (334, 'eaab69a5-5ff9-44d7-bda2-1ffed8d32c70.jpg', '11.jpg', '.jpg', 0, '5/eaab69a5-5ff9-44d7-bda2-1ffed8d32c70.jpg', 5, '2024-04-19 10:34:36', 5, '2024-04-19 10:34:36', 0, 0);
INSERT INTO `file_uploads` VALUES (335, '26e10d19-243d-4022-afa5-beae924a8940.jpg', '12.jpg', '.jpg', 0, '5/26e10d19-243d-4022-afa5-beae924a8940.jpg', 5, '2024-04-19 10:34:36', 5, '2024-04-19 10:34:36', 0, 0);
INSERT INTO `file_uploads` VALUES (336, 'e6082808-5328-4e17-bf63-de6e6c264dc6.jpg', '13.jpg', '.jpg', 0, '5/e6082808-5328-4e17-bf63-de6e6c264dc6.jpg', 5, '2024-04-19 10:34:36', 5, '2024-04-19 10:34:36', 0, 0);
INSERT INTO `file_uploads` VALUES (337, 'ca25c306-2fa8-401c-b641-ccd812288be4.jpg', '14.jpg', '.jpg', 0, '5/ca25c306-2fa8-401c-b641-ccd812288be4.jpg', 5, '2024-04-19 10:34:36', 5, '2024-04-19 10:34:36', 0, 0);
INSERT INTO `file_uploads` VALUES (338, 'bd758cc0-8dda-4ba3-8ef7-0a35a14c26f3.jpg', '15.jpg', '.jpg', 0, '5/bd758cc0-8dda-4ba3-8ef7-0a35a14c26f3.jpg', 5, '2024-04-19 10:34:37', 5, '2024-04-19 10:34:37', 0, 0);
INSERT INTO `file_uploads` VALUES (339, 'e38df44f-18a1-4db7-90b9-e29f2816c27c.jpg', '16.jpg', '.jpg', 0, '5/e38df44f-18a1-4db7-90b9-e29f2816c27c.jpg', 5, '2024-04-19 10:34:37', 5, '2024-04-19 10:34:37', 0, 0);
INSERT INTO `file_uploads` VALUES (340, 'efb1fe3d-fc04-4d7a-ae92-be8952926d76.jpg', '17.jpg', '.jpg', 0, '5/efb1fe3d-fc04-4d7a-ae92-be8952926d76.jpg', 5, '2024-04-19 10:34:37', 5, '2024-04-19 10:34:37', 0, 0);
INSERT INTO `file_uploads` VALUES (341, '65ab79d2-e010-4117-a64c-711c7dcc3023.jpg', 'WechatIMG507.jpg', '.jpg', 0, '5/65ab79d2-e010-4117-a64c-711c7dcc3023.jpg', 5, '2024-04-20 19:25:07', 5, '2024-04-20 19:25:07', 0, 0);
INSERT INTO `file_uploads` VALUES (342, '83372323-37e3-43ff-a845-321cc1b4898f.jpg', 'WechatIMG508.jpg', '.jpg', 0, '5/83372323-37e3-43ff-a845-321cc1b4898f.jpg', 5, '2024-04-20 19:25:07', 5, '2024-04-20 19:25:07', 0, 0);
INSERT INTO `file_uploads` VALUES (343, 'a8357ae5-5ec8-4b0f-bb71-ca5c2af09a1e.jpg', 'WechatIMG509.jpg', '.jpg', 0, '5/a8357ae5-5ec8-4b0f-bb71-ca5c2af09a1e.jpg', 5, '2024-04-20 19:25:07', 5, '2024-04-20 19:25:07', 0, 0);
INSERT INTO `file_uploads` VALUES (344, '6b96af07-afc2-46ce-aeec-6dd5a84048bb.jpg', 'WechatIMG510.jpg', '.jpg', 0, '5/6b96af07-afc2-46ce-aeec-6dd5a84048bb.jpg', 5, '2024-04-20 19:25:07', 5, '2024-04-20 19:25:07', 0, 0);
INSERT INTO `file_uploads` VALUES (345, '15bf3dc1-ed20-4f71-a5ef-306b88ea7a59.jpg', 'WechatIMG511.jpg', '.jpg', 0, '5/15bf3dc1-ed20-4f71-a5ef-306b88ea7a59.jpg', 5, '2024-04-20 19:25:08', 5, '2024-04-20 19:25:08', 0, 0);
INSERT INTO `file_uploads` VALUES (346, '0a239c6d-2086-4bca-80f6-73ed4c2e8851.jpg', 'WechatIMG512.jpg', '.jpg', 0, '5/0a239c6d-2086-4bca-80f6-73ed4c2e8851.jpg', 5, '2024-04-20 19:25:08', 5, '2024-04-20 19:25:08', 0, 0);
INSERT INTO `file_uploads` VALUES (347, '8167f093-7bac-464c-978b-87a4dbd55a93.jpg', 'WechatIMG513.jpg', '.jpg', 0, '5/8167f093-7bac-464c-978b-87a4dbd55a93.jpg', 5, '2024-04-20 19:25:08', 5, '2024-04-20 19:25:08', 0, 0);
INSERT INTO `file_uploads` VALUES (348, 'd49d2c87-828c-4465-aaea-110f34d15d5c.jpg', 'WechatIMG514.jpg', '.jpg', 0, '5/d49d2c87-828c-4465-aaea-110f34d15d5c.jpg', 5, '2024-04-20 19:25:08', 5, '2024-04-20 19:25:08', 0, 0);
INSERT INTO `file_uploads` VALUES (349, 'e893a2af-5347-4749-9d11-191fd4514766.jpg', 'WechatIMG515.jpg', '.jpg', 0, '5/e893a2af-5347-4749-9d11-191fd4514766.jpg', 5, '2024-04-20 19:25:08', 5, '2024-04-20 19:25:08', 0, 0);
INSERT INTO `file_uploads` VALUES (350, '5e023003-c15b-48e0-81e4-71a4c605fbf1.jpg', 'WechatIMG516.jpg', '.jpg', 0, '5/5e023003-c15b-48e0-81e4-71a4c605fbf1.jpg', 5, '2024-04-20 19:25:09', 5, '2024-04-20 19:25:09', 0, 0);
INSERT INTO `file_uploads` VALUES (351, 'dae731ac-1218-4140-8ab5-1d854c0c4f54.jpg', 'WechatIMG517.jpg', '.jpg', 0, '5/dae731ac-1218-4140-8ab5-1d854c0c4f54.jpg', 5, '2024-04-20 19:25:09', 5, '2024-04-20 19:25:09', 0, 0);
INSERT INTO `file_uploads` VALUES (352, '8b138168-c19d-401c-952d-51ff497e4f31.jpg', 'WechatIMG518.jpg', '.jpg', 0, '5/8b138168-c19d-401c-952d-51ff497e4f31.jpg', 5, '2024-04-20 19:25:09', 5, '2024-04-20 19:25:09', 0, 0);
INSERT INTO `file_uploads` VALUES (353, 'afd051cc-ce62-43be-af89-718c71c61891.jpg', 'WechatIMG519.jpg', '.jpg', 0, '5/afd051cc-ce62-43be-af89-718c71c61891.jpg', 5, '2024-04-20 19:25:09', 5, '2024-04-20 19:25:09', 0, 0);
INSERT INTO `file_uploads` VALUES (354, 'bff4ed36-037f-4e15-acbe-29b1faf4d3b3.png', '截屏2024-04-21 10.22.19_副本.png', '.png', 0, '5/bff4ed36-037f-4e15-acbe-29b1faf4d3b3.png', 5, '2024-04-21 10:44:15', 5, '2024-04-21 10:44:15', 0, 0);
INSERT INTO `file_uploads` VALUES (355, '16916bb9-08dd-4ee6-a785-4aeadcf78cf2.png', '截屏2024-04-21 10.22.42_副本.png', '.png', 0, '5/16916bb9-08dd-4ee6-a785-4aeadcf78cf2.png', 5, '2024-04-21 10:44:15', 5, '2024-04-21 10:44:15', 0, 0);
INSERT INTO `file_uploads` VALUES (356, '24a12a89-66a7-4a44-9c60-3eb8ce2d495b.png', '截屏2024-04-21 10.30.28.png', '.png', 0, '5/24a12a89-66a7-4a44-9c60-3eb8ce2d495b.png', 5, '2024-04-21 10:44:16', 5, '2024-04-21 10:44:16', 0, 0);
INSERT INTO `file_uploads` VALUES (357, 'ef0cfb0b-cf9b-458f-8998-1f3fb55ff709.jpg', '微信图片_20240421181309.jpg', '.jpg', 0, '5/ef0cfb0b-cf9b-458f-8998-1f3fb55ff709.jpg', 5, '2024-04-21 18:15:26', 5, '2024-04-21 18:15:26', 0, 0);
INSERT INTO `file_uploads` VALUES (358, 'c1105a65-cebc-4075-9edc-d8e37810bed1.jpg', '微信图片_20240421181316.jpg', '.jpg', 0, '5/c1105a65-cebc-4075-9edc-d8e37810bed1.jpg', 5, '2024-04-21 18:15:26', 5, '2024-04-21 18:15:26', 0, 0);
INSERT INTO `file_uploads` VALUES (359, '848cf3a9-451f-492d-8a56-2b7e9d6a64ce.jpg', '微信图片_20240421181321.jpg', '.jpg', 0, '5/848cf3a9-451f-492d-8a56-2b7e9d6a64ce.jpg', 5, '2024-04-21 18:15:27', 5, '2024-04-21 18:15:27', 0, 0);
INSERT INTO `file_uploads` VALUES (360, '295d9801-9a9b-45ec-96b8-ea3661619b04.jpg', '微信图片_20240421181325.jpg', '.jpg', 0, '5/295d9801-9a9b-45ec-96b8-ea3661619b04.jpg', 5, '2024-04-21 18:15:27', 5, '2024-04-21 18:15:27', 0, 0);
INSERT INTO `file_uploads` VALUES (361, '6c995b26-f05f-4c23-9bb5-192064212906.jpg', '微信图片_20240421181331.jpg', '.jpg', 0, '5/6c995b26-f05f-4c23-9bb5-192064212906.jpg', 5, '2024-04-21 18:15:27', 5, '2024-04-21 18:15:27', 0, 0);
INSERT INTO `file_uploads` VALUES (362, '95f3da27-6806-4977-a684-df1603bc2494.jpg', '微信图片_20240421181336.jpg', '.jpg', 0, '5/95f3da27-6806-4977-a684-df1603bc2494.jpg', 5, '2024-04-21 18:15:27', 5, '2024-04-21 18:15:27', 0, 0);
INSERT INTO `file_uploads` VALUES (363, '5001e9dd-3b15-47d6-bb98-b0fab31cfacc.jpg', '微信图片_20240421181344.jpg', '.jpg', 0, '5/5001e9dd-3b15-47d6-bb98-b0fab31cfacc.jpg', 5, '2024-04-21 18:15:27', 5, '2024-04-21 18:15:27', 0, 0);
INSERT INTO `file_uploads` VALUES (364, '5dc16a92-12a9-4d7e-843d-5994d6b574ce.jpg', '微信图片_20240421181347.jpg', '.jpg', 0, '5/5dc16a92-12a9-4d7e-843d-5994d6b574ce.jpg', 5, '2024-04-21 18:15:27', 5, '2024-04-21 18:15:27', 0, 0);
INSERT INTO `file_uploads` VALUES (365, '02764075-adca-4269-9fb5-fa2f04ba0dbf.png', '微信图片_20240421181350.png', '.png', 0, '5/02764075-adca-4269-9fb5-fa2f04ba0dbf.png', 5, '2024-04-21 18:15:27', 5, '2024-04-21 18:15:27', 0, 0);
INSERT INTO `file_uploads` VALUES (366, '21dd3505-c343-4310-9b31-a5a65be430e6.png', '微信图片_20240421181355.png', '.png', 0, '5/21dd3505-c343-4310-9b31-a5a65be430e6.png', 5, '2024-04-21 18:15:27', 5, '2024-04-21 18:15:27', 0, 0);
INSERT INTO `file_uploads` VALUES (367, '14bbd79a-1507-40e3-8b89-beea45362f37.png', '微信图片_20240421181359.png', '.png', 0, '5/14bbd79a-1507-40e3-8b89-beea45362f37.png', 5, '2024-04-21 18:15:27', 5, '2024-04-21 18:15:27', 0, 0);
INSERT INTO `file_uploads` VALUES (368, 'f689eab1-8acb-4972-be64-ec114981f1f4.png', '微信图片_20240421181404.png', '.png', 0, '5/f689eab1-8acb-4972-be64-ec114981f1f4.png', 5, '2024-04-21 18:15:28', 5, '2024-04-21 18:15:28', 0, 0);
INSERT INTO `file_uploads` VALUES (369, '4bd828ef-6370-41e7-9a7a-5fb2178d6ef3.jpg', '微信图片_20240421181408.jpg', '.jpg', 0, '5/4bd828ef-6370-41e7-9a7a-5fb2178d6ef3.jpg', 5, '2024-04-21 18:15:28', 5, '2024-04-21 18:15:28', 0, 0);
INSERT INTO `file_uploads` VALUES (370, '2251588e-2c71-45a7-9810-39e36ad8e062.jpg', '微信图片_20240323173620.jpg', '.jpg', 0, '5/2251588e-2c71-45a7-9810-39e36ad8e062.jpg', 5, '2024-04-21 18:17:42', 5, '2024-04-21 18:17:42', 0, 0);
INSERT INTO `file_uploads` VALUES (371, '1e2d7aff-87bf-48fc-b211-66edf759a92f.jpg', '微信图片_20240421190650.jpg', '.jpg', 0, '5/1e2d7aff-87bf-48fc-b211-66edf759a92f.jpg', 5, '2024-04-21 19:07:18', 5, '2024-04-21 19:07:18', 0, 0);
INSERT INTO `file_uploads` VALUES (372, 'c09cc1c3-04c7-42da-b376-3786393be621.jpg', '微信图片_20240421190640.jpg', '.jpg', 0, '5/c09cc1c3-04c7-42da-b376-3786393be621.jpg', 5, '2024-04-21 19:07:19', 5, '2024-04-21 19:07:19', 0, 0);
INSERT INTO `file_uploads` VALUES (373, '4b3c7c54-455c-4ac6-8ffb-0d6d580a2b14.jpg', '微信图片_20240421190429.jpg', '.jpg', 0, '5/4b3c7c54-455c-4ac6-8ffb-0d6d580a2b14.jpg', 5, '2024-04-21 19:07:19', 5, '2024-04-21 19:07:19', 0, 0);
INSERT INTO `file_uploads` VALUES (374, 'ce7ea89f-820c-4da0-8ed9-74943bea95ea.jpg', '微信图片_20240421190429.jpg', '.jpg', 0, '5/ce7ea89f-820c-4da0-8ed9-74943bea95ea.jpg', 5, '2024-04-21 19:10:52', 5, '2024-04-21 19:10:52', 0, 0);
INSERT INTO `file_uploads` VALUES (375, '6b6305ad-ccdf-416c-93c1-2e17d6fc9a94.jpg', '微信图片_20240421190429.jpg', '.jpg', 0, '5/6b6305ad-ccdf-416c-93c1-2e17d6fc9a94.jpg', 5, '2024-04-21 19:10:52', 5, '2024-04-21 19:10:52', 0, 0);
INSERT INTO `file_uploads` VALUES (376, 'b4d9ac77-5726-4b5a-9c99-487d40755a2f.png', '2222222222222.png', '.png', 0, '3/b4d9ac77-5726-4b5a-9c99-487d40755a2f.png', 3, '2024-04-22 02:53:23', 3, '2024-04-22 02:53:23', 0, 0);
INSERT INTO `file_uploads` VALUES (377, '261feb46-491f-4211-bb04-30688339a536.jpg', '微信图片_20240427181857.jpg', '.jpg', 0, '5/261feb46-491f-4211-bb04-30688339a536.jpg', 5, '2024-04-27 18:25:05', 5, '2024-04-27 18:25:05', 0, 0);
INSERT INTO `file_uploads` VALUES (378, 'f8fc3d9c-c3bc-4a1b-8ecf-3e1f62a23315.jpg', '微信图片_20240427181857.jpg', '.jpg', 0, '5/f8fc3d9c-c3bc-4a1b-8ecf-3e1f62a23315.jpg', 5, '2024-04-27 18:27:33', 5, '2024-04-27 18:27:33', 0, 0);
INSERT INTO `file_uploads` VALUES (379, '4874c118-b189-49e9-b5b7-7e2c155541a2.jpg', '微信图片_20240427181857.jpg', '.jpg', 0, '5/4874c118-b189-49e9-b5b7-7e2c155541a2.jpg', 5, '2024-04-27 21:02:13', 5, '2024-04-27 21:02:13', 0, 0);
INSERT INTO `file_uploads` VALUES (380, '52a919ab-5981-4368-bf3e-03c9a48694cb.jpg', '微信图片_20240427181932.jpg', '.jpg', 0, '5/52a919ab-5981-4368-bf3e-03c9a48694cb.jpg', 5, '2024-04-27 21:02:13', 5, '2024-04-27 21:02:13', 0, 0);
INSERT INTO `file_uploads` VALUES (381, 'aff91bd6-b9e4-4759-ba68-91aacbb82113.jpg', '微信图片_20240427181945.jpg', '.jpg', 0, '5/aff91bd6-b9e4-4759-ba68-91aacbb82113.jpg', 5, '2024-04-27 21:02:13', 5, '2024-04-27 21:02:13', 0, 0);
INSERT INTO `file_uploads` VALUES (382, '286d0c42-6998-402c-9d5e-48a80c5adf13.jpg', '微信图片_20240427181956.jpg', '.jpg', 0, '5/286d0c42-6998-402c-9d5e-48a80c5adf13.jpg', 5, '2024-04-27 21:02:14', 5, '2024-04-27 21:02:14', 0, 0);
INSERT INTO `file_uploads` VALUES (383, 'ea21fc7e-f8bb-410d-9277-4887b7c157cf.jpg', '微信图片_20240427182013.jpg', '.jpg', 0, '5/ea21fc7e-f8bb-410d-9277-4887b7c157cf.jpg', 5, '2024-04-27 21:02:14', 5, '2024-04-27 21:02:14', 0, 0);
INSERT INTO `file_uploads` VALUES (384, 'a90e1020-1985-425c-b83a-8fe725beac2d.jpg', '微信图片_20240427182022.jpg', '.jpg', 0, '5/a90e1020-1985-425c-b83a-8fe725beac2d.jpg', 5, '2024-04-27 21:02:14', 5, '2024-04-27 21:02:14', 0, 0);
INSERT INTO `file_uploads` VALUES (385, 'f99536b4-4ba7-43ad-bc98-a78a1870a160.jpg', '微信图片_20240427182032.jpg', '.jpg', 0, '5/f99536b4-4ba7-43ad-bc98-a78a1870a160.jpg', 5, '2024-04-27 21:02:14', 5, '2024-04-27 21:02:14', 0, 0);
INSERT INTO `file_uploads` VALUES (386, 'c99a480b-864d-4998-a08c-352ce3faf900.jpg', '微信图片_20240427182052.jpg', '.jpg', 0, '5/c99a480b-864d-4998-a08c-352ce3faf900.jpg', 5, '2024-04-27 21:02:14', 5, '2024-04-27 21:02:14', 0, 0);
INSERT INTO `file_uploads` VALUES (387, '85b1102d-f27f-4c70-8fee-af112a73e95e.jpg', '微信图片_20240427182104.jpg', '.jpg', 0, '5/85b1102d-f27f-4c70-8fee-af112a73e95e.jpg', 5, '2024-04-27 21:02:15', 5, '2024-04-27 21:02:15', 0, 0);
INSERT INTO `file_uploads` VALUES (388, '7c7013f9-6987-4fe5-8e24-89ef3406396d.jpg', '微信图片_20240427182212.jpg', '.jpg', 0, '5/7c7013f9-6987-4fe5-8e24-89ef3406396d.jpg', 5, '2024-04-27 21:02:15', 5, '2024-04-27 21:02:15', 0, 0);
INSERT INTO `file_uploads` VALUES (389, '50bea107-9981-44a4-97ff-10a317ad5479.jpg', '微信图片_20240427182219.jpg', '.jpg', 0, '5/50bea107-9981-44a4-97ff-10a317ad5479.jpg', 5, '2024-04-27 21:02:15', 5, '2024-04-27 21:02:15', 0, 0);
INSERT INTO `file_uploads` VALUES (390, 'ecadd36f-5cf2-4015-9d3e-ae15138432fb.jpg', '微信图片_20240427182233.jpg', '.jpg', 0, '5/ecadd36f-5cf2-4015-9d3e-ae15138432fb.jpg', 5, '2024-04-27 21:02:15', 5, '2024-04-27 21:02:15', 0, 0);
INSERT INTO `file_uploads` VALUES (391, '204f7d27-8a5b-4064-adfd-2e7960ebbf27.jpg', '微信图片_20240427182240.jpg', '.jpg', 0, '5/204f7d27-8a5b-4064-adfd-2e7960ebbf27.jpg', 5, '2024-04-27 21:02:16', 5, '2024-04-27 21:02:16', 0, 0);
INSERT INTO `file_uploads` VALUES (392, '04623a98-1890-4d12-921e-97bb035e7d91.jpg', '微信图片_20240427182246.jpg', '.jpg', 0, '5/04623a98-1890-4d12-921e-97bb035e7d91.jpg', 5, '2024-04-27 21:02:16', 5, '2024-04-27 21:02:16', 0, 0);
INSERT INTO `file_uploads` VALUES (393, '7a7d78c6-4b78-4e4e-a8aa-fa5eef0688d4.mp4', '21121211221.mp4', '.mp4', 0, '3/7a7d78c6-4b78-4e4e-a8aa-fa5eef0688d4.mp4', 3, '2024-05-09 08:28:37', 3, '2024-05-09 08:28:37', 0, 0);
INSERT INTO `file_uploads` VALUES (394, '59eecec3-5e9d-4753-9a30-8bf7f9844d9b.png', '999999999.png', '.png', 0, '3/59eecec3-5e9d-4753-9a30-8bf7f9844d9b.png', 3, '2024-05-09 15:19:28', 3, '2024-05-09 15:19:28', 0, 0);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `sno` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学号',
  `cno` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程号',
  `degree` decimal(4, 1) NOT NULL COMMENT '成绩',
  PRIMARY KEY (`sno`, `cno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '1', 1.0);
INSERT INTO `score` VALUES ('101', '3-105', 64.0);
INSERT INTO `score` VALUES ('101', '6-166', 85.0);
INSERT INTO `score` VALUES ('103', '3-105', 92.0);
INSERT INTO `score` VALUES ('103', '3-245', 86.0);
INSERT INTO `score` VALUES ('105', '3-105', 88.0);
INSERT INTO `score` VALUES ('105', '3-245', 75.0);
INSERT INTO `score` VALUES ('107', '3-105', 91.0);
INSERT INTO `score` VALUES ('107', '6-166', 79.0);
INSERT INTO `score` VALUES ('108', '3-105', 78.0);
INSERT INTO `score` VALUES ('108', '6-166', 81.0);
INSERT INTO `score` VALUES ('109', '3-105', 76.0);
INSERT INTO `score` VALUES ('109', '3-245', 68.0);
INSERT INTO `score` VALUES ('123123', '12332', 99.0);
INSERT INTO `score` VALUES ('7989789', '789789', 99.0);
INSERT INTO `score` VALUES ('erg', 'asda', 89.0);
INSERT INTO `score` VALUES ('qwe', 'eqw', 88.0);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sno` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学号',
  `sname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `ssex` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '男' COMMENT '性别',
  `sbirthday` datetime NULL DEFAULT NULL COMMENT '生日',
  `sclass` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '班级',
  PRIMARY KEY (`sno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1', '男', NULL, '1');
INSERT INTO `student` VALUES ('101', '李军', '男', '1976-02-20 00:00:00', '95033');
INSERT INTO `student` VALUES ('103', '陆君', '男', '1974-06-03 00:00:00', '95031');
INSERT INTO `student` VALUES ('105', '匡明', '男', '1975-10-02 00:00:00', '95031');
INSERT INTO `student` VALUES ('107', '王丽', '女', '1976-01-23 00:00:00', '95033');
INSERT INTO `student` VALUES ('108', '曾华', '男', '1997-09-01 00:00:00', '95033');
INSERT INTO `student` VALUES ('109', '王芳', '女', '1975-02-10 00:00:00', '95031');
INSERT INTO `student` VALUES ('123123', '123123', '男', NULL, '123123');
INSERT INTO `student` VALUES ('7989789', '789789', '男', NULL, '789789');
INSERT INTO `student` VALUES ('erg', 'dfg', '男', NULL, 'asd');
INSERT INTO `student` VALUES ('qwe', 'eqwe', '男', NULL, 'qwe');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `tno` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '教师编号',
  `tname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `tsex` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '男' COMMENT '性别',
  `tbirthday` datetime NULL DEFAULT NULL COMMENT '生日',
  `prof` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '职称',
  `depart` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门',
  PRIMARY KEY (`tno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('804', '李诚', '男', '1958-12-02 00:00:00', '副教授', '计算机系');
INSERT INTO `teacher` VALUES ('825', '王萍', '女', '1972-05-05 00:00:00', '助教', '计算机系');
INSERT INTO `teacher` VALUES ('831', '刘冰', '女', '1977-08-14 00:00:00', '助教', '电子工程系');
INSERT INTO `teacher` VALUES ('856', '张旭', '男', '1969-03-12 00:00:00', '讲师', '电子工程系');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名字',
  `role` int NULL DEFAULT NULL COMMENT '权限',
  `org` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `status` int NULL DEFAULT NULL COMMENT '状态',
  `del_flag` int NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'root', 'admin', '小龙', 3, '21', NULL, NULL, 1, '2024-03-10 19:16:09', 0, 0);
INSERT INTO `user` VALUES (2, 'a', 'a', NULL, 3, NULL, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `user` VALUES (3, 'y51288033', 'admin', '杨易达', 3, '软件工程', 1, '2024-03-19 10:38:55', NULL, NULL, 0, 0);
INSERT INTO `user` VALUES (4, 'tian', 'tian', '田雷宇', 3, '计科6', 1, '2024-03-25 16:38:12', 1, '2024-03-25 16:38:16', 0, 0);
INSERT INTO `user` VALUES (5, 'counselorA', 'counselor', '导员', 3, '教师A组', 1, '2024-03-25 16:43:35', 1, '2024-03-25 16:43:37', 0, 0);
INSERT INTO `user` VALUES (6, '1', '1', '1', 1, '1', 1, '2024-03-25 19:18:55', 1, '2024-03-25 19:18:50', 0, 0);
INSERT INTO `user` VALUES (7, 'lichunying', 'admin', 'lcy', 3, '开发组', 1, '2024-04-01 11:06:01', NULL, NULL, 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
