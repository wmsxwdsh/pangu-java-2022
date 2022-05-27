/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : 127.0.0.1:3306
 Source Schema         : rabbit_mq_j2ee

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 27/05/2022 13:46:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_record
-- ----------------------------
DROP TABLE IF EXISTS `order_record`;
CREATE TABLE `order_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_no` varchar(255) NOT NULL COMMENT '订单编号',
  `order_type` varchar(255) DEFAULT NULL COMMENT '订单类型',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_no` (`order_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3 COMMENT='订单记录表-业务级别';

-- ----------------------------
-- Records of order_record
-- ----------------------------
BEGIN;
INSERT INTO `order_record` (`id`, `order_no`, `order_type`, `create_time`, `update_time`) VALUES (7, '10010', '物流2', '2018-07-31 20:59:18', '2018-07-31 23:35:43');
INSERT INTO `order_record` (`id`, `order_no`, `order_type`, `create_time`, `update_time`) VALUES (8, '10011', '供应商3', '2018-07-31 20:59:30', '2018-07-31 23:34:56');
INSERT INTO `order_record` (`id`, `order_no`, `order_type`, `create_time`, `update_time`) VALUES (9, '10012', '采购2', '2018-07-22 20:59:36', '2018-07-23 21:06:47');
INSERT INTO `order_record` (`id`, `order_no`, `order_type`, `create_time`, `update_time`) VALUES (12, '10013', '测试类型1', '2018-07-22 21:02:38', '2018-07-30 23:34:41');
INSERT INTO `order_record` (`id`, `order_no`, `order_type`, `create_time`, `update_time`) VALUES (13, '10014', '测试类型1', '2018-07-23 21:02:50', '2018-07-30 23:34:44');
INSERT INTO `order_record` (`id`, `order_no`, `order_type`, `create_time`, `update_time`) VALUES (14, '10015', '测试类型3', '2018-07-23 21:06:30', '2018-07-31 23:34:45');
INSERT INTO `order_record` (`id`, `order_no`, `order_type`, `create_time`, `update_time`) VALUES (15, '10016', '测试类型4', '2018-07-30 20:53:39', '2018-07-31 23:34:47');
INSERT INTO `order_record` (`id`, `order_no`, `order_type`, `create_time`, `update_time`) VALUES (16, 'orderNo_20180821001', '物流12', '2018-08-22 21:12:46', NULL);
INSERT INTO `order_record` (`id`, `order_no`, `order_type`, `create_time`, `update_time`) VALUES (20, 'orderNo_c8940b20-3282-4207-b0f9-9e738ba73721', '物流12', '2022-05-25 11:00:05', NULL);
INSERT INTO `order_record` (`id`, `order_no`, `order_type`, `create_time`, `update_time`) VALUES (21, 'orderNo_dc0f8b04-6032-4633-9f98-7a9e99884f49', '物流12', '2022-05-25 11:08:52', NULL);
INSERT INTO `order_record` (`id`, `order_no`, `order_type`, `create_time`, `update_time`) VALUES (22, 'orderNo_30de1e6e-9bab-4d2a-b8c9-12dde49f8aec', '物流12', '2022-05-25 11:09:08', NULL);
INSERT INTO `order_record` (`id`, `order_no`, `order_type`, `create_time`, `update_time`) VALUES (23, 'orderNo_46d089dc-23a5-4244-ade4-688ede0ce60a', '物流12', '2022-05-25 11:09:38', NULL);
INSERT INTO `order_record` (`id`, `order_no`, `order_type`, `create_time`, `update_time`) VALUES (24, 'orderNo_608ae959-17f1-4229-bc58-06ebbe535c60', '物流12', '2022-05-25 11:10:20', NULL);
COMMIT;

-- ----------------------------
-- Table structure for order_report
-- ----------------------------
DROP TABLE IF EXISTS `order_report`;
CREATE TABLE `order_report` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_no` varchar(255) NOT NULL COMMENT '订单编号',
  `order_type` varchar(255) DEFAULT NULL COMMENT '订单类型',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_no` (`order_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3 COMMENT='订单报表表-分析级别';

-- ----------------------------
-- Records of order_report
-- ----------------------------
BEGIN;
INSERT INTO `order_report` (`id`, `order_no`, `order_type`, `create_time`, `update_time`) VALUES (28, '10010', '物流2', '2018-07-31 20:59:18', '2018-07-31 23:35:43');
INSERT INTO `order_report` (`id`, `order_no`, `order_type`, `create_time`, `update_time`) VALUES (29, '10011', '供应商3', '2018-07-31 20:59:30', '2018-07-31 23:34:56');
INSERT INTO `order_report` (`id`, `order_no`, `order_type`, `create_time`, `update_time`) VALUES (30, '10015', '测试类型3', '2018-07-23 21:06:30', '2018-07-31 23:34:45');
INSERT INTO `order_report` (`id`, `order_no`, `order_type`, `create_time`, `update_time`) VALUES (31, '10016', '测试类型4', '2018-07-30 20:53:39', '2018-07-31 23:34:47');
COMMIT;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_no` varchar(255) DEFAULT NULL COMMENT '商品编号',
  `total` int DEFAULT NULL COMMENT '库存量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='商品信息表';

-- ----------------------------
-- Records of product
-- ----------------------------
BEGIN;
INSERT INTO `product` (`id`, `product_no`, `total`, `create_time`, `update_time`) VALUES (1, 'product_10010', 0, '2018-08-24 21:16:20', '2022-05-27 09:14:43');
COMMIT;

-- ----------------------------
-- Table structure for product_bak
-- ----------------------------
DROP TABLE IF EXISTS `product_bak`;
CREATE TABLE `product_bak` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `stock` int DEFAULT NULL COMMENT '库存量',
  `purchase_date` date DEFAULT NULL COMMENT '采购日期',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_active` int DEFAULT '1' COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3 COMMENT='产品信息表';

-- ----------------------------
-- Records of product_bak
-- ----------------------------
BEGIN;
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (1, '戴尔笔记本', 100, '2018-06-01', '2018-07-21 11:28:50', '2018-07-21 11:28:50', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (2, '华硕笔记本', 200, '2018-07-10', '2018-07-21 11:28:50', '2018-07-21 11:28:50', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (3, '联想小新I', 15, '2018-05-10', '2018-07-21 11:28:50', '2018-07-21 11:28:50', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (4, '暗影精灵', 35, '2018-07-19', '2018-07-21 11:28:50', '2018-07-21 11:28:50', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (5, '外星人I', 1000, '2018-07-11', '2018-07-21 11:28:50', '2018-07-21 11:28:50', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (6, '戴尔XPS超极本', 200, '2018-02-07', '2018-07-21 11:28:50', '2018-07-21 11:28:50', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (7, '联想台式机', 123, '2018-07-12', '2018-07-21 11:28:50', '2018-07-21 11:28:50', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (8, '戴尔笔记本-二代', 100, '2018-06-01', '2018-07-21 11:28:50', '2018-07-21 11:28:50', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (9, '华硕笔记本', 200, '2018-07-10', '2018-07-21 11:28:50', '2018-07-21 11:28:50', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (10, '联想小新I', 15, '2018-05-10', '2018-07-21 11:28:50', '2018-07-21 11:28:50', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (11, '暗影精灵II', 35, '2018-06-12', '2018-07-21 11:28:50', '2018-07-21 11:28:50', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (12, '外星人II', 1000, '2018-07-11', '2018-07-21 11:28:50', '2018-07-21 11:28:50', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (13, '惠普战系列笔记本', 200, '2018-02-07', '2018-07-21 11:28:50', '2018-07-21 11:28:50', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (14, '海信笔记本', 123, '2018-06-19', '2018-07-21 11:28:50', '2018-07-21 11:28:50', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (15, '组装机', 100, '2018-06-01', '2018-07-21 11:28:50', '2018-07-21 11:28:50', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (16, '宏碁台式机', 200, '2018-07-10', '2018-07-21 11:28:50', '2018-07-21 11:28:50', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (17, '东芝笔记本', 15, '2018-05-10', '2018-07-21 11:28:50', '2018-07-21 11:28:50', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (18, '神州战船', 35, '2018-07-19', '2018-07-21 11:28:50', '2018-07-21 11:28:50', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (19, 'Mac笔记本', 150, NULL, '2018-07-21 21:43:30', '2018-07-21 21:43:30', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (20, '华硕笔记本2', 1520, '2018-07-01', '2018-07-21 21:46:14', '2018-07-21 22:08:52', 0);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (21, 'acer笔记本22', 1522, '2018-02-01', '2018-07-30 21:42:07', '2018-07-30 21:45:36', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (22, 'acer笔记本2', 152, '2018-01-01', '2018-07-30 21:44:00', '2018-07-30 21:44:00', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (23, '', 152, '2018-01-01', '2018-07-30 21:49:37', '2018-07-30 21:49:37', 1);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (24, '联想笔记本1010', 152, '2018-01-01', '2018-07-30 21:55:05', '2018-07-30 21:55:45', 0);
INSERT INTO `product_bak` (`id`, `name`, `stock`, `purchase_date`, `create_time`, `update_time`, `is_active`) VALUES (25, '外星人第四代', 152, '2018-03-01', '2018-07-30 21:58:20', '2018-07-30 22:00:08', 0);
COMMIT;

-- ----------------------------
-- Table structure for product_robbing_record
-- ----------------------------
DROP TABLE IF EXISTS `product_robbing_record`;
CREATE TABLE `product_robbing_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mobile` varchar(255) DEFAULT NULL COMMENT '手机号',
  `product_id` int DEFAULT NULL COMMENT '产品Id',
  `robbing_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '抢单时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb3 COMMENT='抢单记录表';

-- ----------------------------
-- Records of product_robbing_record
-- ----------------------------
BEGIN;
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (1, '46', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (2, '90', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (3, '82', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (4, '66', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (5, '92', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (6, '41', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (7, '70', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (8, '47', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (9, '106', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (10, '102', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (11, '50', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (12, '101', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (13, '28', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (14, '87', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (15, '97', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (16, '42', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (17, '2', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (18, '58', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (19, '110', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (20, '107', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (21, '32', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (22, '48', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (23, '55', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (24, '49', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (25, '80', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (26, '52', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (27, '36', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (28, '37', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (29, '57', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (30, '100', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (31, '174', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (32, '14', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (33, '9', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (34, '149', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (35, '160', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (36, '162', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (37, '115', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (38, '121', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (39, '120', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (40, '122', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (41, '11', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (42, '207', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (43, '72', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (44, '206', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (45, '17', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (46, '221', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (47, '296', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (48, '108', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (49, '181', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (50, '172', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (51, '179', 1, '2022-05-27 09:14:42', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (52, '180', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (53, '173', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (54, '191', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (55, '125', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (56, '135', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (57, '208', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (58, '190', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (59, '88', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (60, '159', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (61, '143', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (62, '285', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (63, '99', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (64, '69', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (65, '184', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (66, '293', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (67, '24', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (68, '313', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (69, '29', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (70, '18', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (71, '305', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (72, '30', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (73, '40', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (74, '283', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (75, '23', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (76, '109', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (77, '25', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (78, '163', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (79, '301', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (80, '226', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (81, '117', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (82, '211', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (83, '263', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (84, '234', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (85, '65', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (86, '213', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (87, '3', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (88, '231', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (89, '64', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (90, '374', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (91, '114', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (92, '247', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (93, '205', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (94, '248', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (95, '327', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (96, '20', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (97, '38', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (98, '21', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (99, '437', 1, '2022-05-27 09:14:43', NULL);
INSERT INTO `product_robbing_record` (`id`, `mobile`, `product_id`, `robbing_time`, `update_time`) VALUES (100, '133', 1, '2022-05-27 09:14:43', NULL);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `sex` int DEFAULT NULL COMMENT '性别（1=男；2=女）',
  `is_active` int DEFAULT '1' COMMENT '是否有效（1=是；0=否）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_name` (`user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='用户信息表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `user_name`, `password`, `sex`, `is_active`, `create_time`, `update_time`) VALUES (1, 'debug', 'linsen', 1, 1, '2018-07-22 16:48:25', NULL);
INSERT INTO `user` (`id`, `user_name`, `password`, `sex`, `is_active`, `create_time`, `update_time`) VALUES (2, 'jack', '123456', 1, 1, '2018-07-22 16:48:36', NULL);
INSERT INTO `user` (`id`, `user_name`, `password`, `sex`, `is_active`, `create_time`, `update_time`) VALUES (3, 'pangu', '123456', 1, 1, '2022-05-25 00:08:15', NULL);
COMMIT;

-- ----------------------------
-- Table structure for user_log
-- ----------------------------
DROP TABLE IF EXISTS `user_log`;
CREATE TABLE `user_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `module` varchar(255) DEFAULT NULL COMMENT '模块类型',
  `operation` varchar(255) DEFAULT NULL COMMENT '操作',
  `data` varchar(1000) DEFAULT NULL COMMENT '操作数据',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COMMENT='用户操作日志';

-- ----------------------------
-- Records of user_log
-- ----------------------------
BEGIN;
INSERT INTO `user_log` (`id`, `user_name`, `module`, `operation`, `data`, `create_time`, `update_time`) VALUES (1, 'jack', 'Login', 'login', '{\"id\":2,\"userName\":\"jack\",\"password\":\"123456\",\"sex\":1,\"isActive\":1,\"createTime\":1532249316000,\"updateTime\":null}', '2018-08-30 23:22:10', NULL);
INSERT INTO `user_log` (`id`, `user_name`, `module`, `operation`, `data`, `create_time`, `update_time`) VALUES (2, 'jack', 'Login', 'login', '{\"id\":2,\"userName\":\"jack\",\"password\":\"123456\",\"sex\":1,\"isActive\":1,\"createTime\":1532249316000,\"updateTime\":null}', '2018-08-30 23:29:04', NULL);
INSERT INTO `user_log` (`id`, `user_name`, `module`, `operation`, `data`, `create_time`, `update_time`) VALUES (3, 'debug', 'Login', 'login', '{\"id\":1,\"userName\":\"debug\",\"password\":\"linsen\",\"sex\":1,\"isActive\":1,\"createTime\":1532249305000,\"updateTime\":null}', '2018-08-30 23:31:13', NULL);
INSERT INTO `user_log` (`id`, `user_name`, `module`, `operation`, `data`, `create_time`, `update_time`) VALUES (4, 'debug', 'Login', 'login', '{\"id\":1,\"userName\":\"debug\",\"password\":\"linsen\",\"sex\":1,\"isActive\":1,\"createTime\":1532249305000,\"updateTime\":null}', '2018-09-01 09:26:54', NULL);
INSERT INTO `user_log` (`id`, `user_name`, `module`, `operation`, `data`, `create_time`, `update_time`) VALUES (5, 'debug', 'Login', 'login', '{\"id\":1,\"userName\":\"debug\",\"password\":\"linsen\",\"sex\":1,\"isActive\":1,\"createTime\":1532249305000,\"updateTime\":null}', '2018-09-01 09:28:03', NULL);
INSERT INTO `user_log` (`id`, `user_name`, `module`, `operation`, `data`, `create_time`, `update_time`) VALUES (6, 'debug', 'Login', 'login', '{\"id\":1,\"userName\":\"debug\",\"password\":\"linsen\",\"sex\":1,\"isActive\":1,\"createTime\":1532249305000,\"updateTime\":null}', '2018-09-01 09:29:29', NULL);
INSERT INTO `user_log` (`id`, `user_name`, `module`, `operation`, `data`, `create_time`, `update_time`) VALUES (7, 'pangu', 'Login', 'login', '{\"id\":3,\"userName\":\"pangu\",\"password\":\"123456\",\"sex\":1,\"isActive\":1,\"createTime\":1653408495000,\"updateTime\":null}', '2022-05-27 11:33:33', NULL);
COMMIT;

-- ----------------------------
-- Table structure for user_order
-- ----------------------------
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_no` varchar(255) NOT NULL COMMENT '订单编号',
  `user_id` int NOT NULL COMMENT '用户id',
  `status` int DEFAULT NULL COMMENT '状态(1=已保存；2=已付款；3=已取消)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3 COMMENT='用户订单表';

-- ----------------------------
-- Records of user_order
-- ----------------------------
BEGIN;
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (1, '10010', 1, 1, '2018-08-30 22:29:15', '2018-08-30 22:29:43');
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (2, '10011', 1, 1, '2018-08-30 22:29:54', NULL);
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (3, '10012', 1, 1, '2018-08-30 22:41:15', NULL);
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (4, '10013', 2, 1, '2018-08-30 22:51:35', NULL);
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (5, '10014', 3, 1, '2018-08-30 22:52:08', NULL);
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (6, '10015', 4, 1, '2018-08-30 22:53:43', NULL);
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (7, 'order_10010', 108, 1, '2018-09-01 16:18:14', NULL);
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (8, 'order_10011', 109, 1, '2018-09-01 16:35:24', NULL);
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (9, 'order_10011', 109, 1, '2018-09-01 16:36:28', NULL);
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (10, 'order_10012', 121, 3, '2018-09-01 16:44:57', '2018-09-01 16:45:07');
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (11, 'order_10013', 122, 2, '2018-09-01 16:45:32', '2018-09-01 16:45:38');
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (12, 'order_10014', 126, 3, '2018-09-01 16:55:14', '2018-09-01 16:55:25');
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (13, 'order_10015', 128, 3, '2018-09-01 16:56:02', '2018-09-01 16:56:13');
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (14, 'order_10015', 128, 1, '2018-09-01 16:57:45', NULL);
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (15, 'order_10016', 129, 1, '2018-09-01 17:01:33', NULL);
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (17, 'No9999', 112233, 1, '2022-05-27 11:10:35', NULL);
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (18, 'No9999', 112233, 1, '2022-05-27 11:11:27', NULL);
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (19, 'No9999', 112233, 1, '2022-05-27 11:14:00', NULL);
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (20, 'No达尔优111', 101, 3, '2022-05-27 13:27:29', '2022-05-27 13:31:25');
INSERT INTO `user_order` (`id`, `order_no`, `user_id`, `status`, `create_time`, `update_time`) VALUES (21, 'No达尔优111', 101, 1, '2022-05-27 13:40:38', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
