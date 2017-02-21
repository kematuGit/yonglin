/*
Navicat MySQL Data Transfer

Source Server         : yonglin
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : yonglin

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2017-02-15 23:02:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `num` varchar(16) DEFAULT NULL COMMENT '区域编号',
  `name` varchar(32) DEFAULT NULL COMMENT '区域名称',
  `remark` varchar(32) DEFAULT NULL COMMENT '区域备注',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sort` int(11) DEFAULT NULL COMMENT '序号',
  `material_num` varchar(16) DEFAULT NULL COMMENT '材料牌号',
  `name` varchar(32) DEFAULT NULL COMMENT '产品名称',
  `pic_num` varchar(16) DEFAULT NULL COMMENT '图号',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for storage
-- ----------------------------
DROP TABLE IF EXISTS `storage`;
CREATE TABLE `storage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_num` varchar(16) NOT NULL COMMENT '入库单号',
  `excute_time` datetime NOT NULL COMMENT '(入库/出库/盘点)日期',
  `product_id` int(11) DEFAULT NULL COMMENT '产品ID',
  `material_report_num` varchar(16) DEFAULT NULL,
  `production_batch` varchar(32) DEFAULT NULL COMMENT '产品批次',
  `storage_num` int(11) DEFAULT NULL COMMENT '入库数量',
  `contract_num` varchar(32) DEFAULT NULL COMMENT '合同号',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  `storage_type` tinyint(1) DEFAULT NULL COMMENT '1:入库 2:出库 3：盘点',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for storage_rack
-- ----------------------------
DROP TABLE IF EXISTS `storage_rack`;
CREATE TABLE `storage_rack` (
  `id` int(11) DEFAULT NULL COMMENT 'id',
  `storage_id` int(11) DEFAULT NULL COMMENT '库存ID',
  `area_id` int(11) DEFAULT NULL,
  `row` int(3) DEFAULT NULL COMMENT '行',
  `column` int(3) DEFAULT NULL,
  `put_num` int(11) DEFAULT NULL COMMENT '放置数量',
  `remark` varchar(32) DEFAULT NULL COMMENT ' 备注',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/**20170221*/
ALTER TABLE `product`
	ADD COLUMN `in_storage_count` INT(10) NULL COMMENT '入库总数量' AFTER `remark`,
	ADD COLUMN `out_storage_count` INT(10) NULL COMMENT '出库总数量' AFTER `in_storage_count`,
	ADD COLUMN `check_storage_count` INT(10) NULL COMMENT '盘点总数量' AFTER `out_storage_count`;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='yonglin';