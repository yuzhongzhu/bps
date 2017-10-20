/*
SQLyog Ultimate v8.32 
MySQL - 5.6.31-77.0-log : Database - tianjs_dev28_pfs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `in_product_log` */

DROP TABLE IF EXISTS `in_product_log`;

CREATE TABLE `in_product_log` (
  `id` varchar(60) NOT NULL COMMENT '登记批次ID',
  `product_cd` varchar(60) NOT NULL COMMENT '产品代码',
  `in_count` int(11) NOT NULL COMMENT '入库数量',
  `in_register_tm` varchar(20) NOT NULL COMMENT '入库登记时间',
  `batch_no` varchar(40) NOT NULL COMMENT '入库批次号',
  `product_address` varchar(100) DEFAULT NULL COMMENT '进货地址',
  `in_amount` decimal(18,6) NOT NULL COMMENT '进货款总额',
  `base_price` decimal(18,6) NOT NULL COMMENT '进货单价',
  `rmk` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `io_cust_b` */

DROP TABLE IF EXISTS `io_cust_b`;

CREATE TABLE `io_cust_b` (
  `id` varchar(60) NOT NULL COMMENT '主键',
  `cust_nm` varchar(60) DEFAULT NULL COMMENT '客户称呼',
  `contact` varchar(60) NOT NULL COMMENT '客户联系方式',
  `address` varchar(500) DEFAULT NULL COMMENT '客户地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `io_product_b` */

DROP TABLE IF EXISTS `io_product_b`;

CREATE TABLE `io_product_b` (
  `id` varchar(60) NOT NULL COMMENT '主键',
  `product_Cd` varchar(60) NOT NULL COMMENT '产品代码',
  `product_Nm` varchar(100) NOT NULL COMMENT '产品名称',
  `base_price` decimal(18,6) NOT NULL COMMENT '产品进价',
  `price` decimal(18,6) NOT NULL COMMENT '产品售价',
  `unit` varchar(20) DEFAULT NULL COMMENT '产品计量单位',
  `param` varchar(100) DEFAULT 'unknown' COMMENT '参数信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `io_warehouse_b` */

DROP TABLE IF EXISTS `io_warehouse_b`;

CREATE TABLE `io_warehouse_b` (
  `id` varchar(60) NOT NULL COMMENT '主键',
  `product_cd` varchar(60) NOT NULL COMMENT '产品代码',
  `remain_amt` int(11) NOT NULL COMMENT '产品库存',
  `update_tm` varchar(20) NOT NULL,
  `oper_id` varchar(60) DEFAULT NULL COMMENT '操作员ID',
  `version_no` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `out_product_log` */

DROP TABLE IF EXISTS `out_product_log`;

CREATE TABLE `out_product_log` (
  `id` varchar(60) NOT NULL COMMENT '出库登记主键',
  `out_batch_no` varchar(60) NOT NULL COMMENT '出库批次号',
  `out_register_tm` varchar(20) NOT NULL COMMENT '出库登记时间',
  `product_cd` varchar(60) NOT NULL COMMENT '出库产品代码',
  `out_count` int(11) NOT NULL COMMENT '出库产品的数量',
  `sale_price` decimal(18,6) NOT NULL COMMENT '出库产品价',
  `discount` decimal(18,2) DEFAULT NULL COMMENT '折扣',
  `out_sum_amt` decimal(18,6) DEFAULT NULL COMMENT '总价',
  `rmk` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `sta` char(2) NOT NULL DEFAULT '1' COMMENT '0:关闭 1:有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `out_send_rl` */

DROP TABLE IF EXISTS `out_send_rl`;

CREATE TABLE `out_send_rl` (
  `id` varchar(60) NOT NULL COMMENT '主键',
  `cust_id` varchar(60) NOT NULL COMMENT '客户编号',
  `out_batch_no` varchar(60) DEFAULT NULL COMMENT '出库批次号',
  `send_flag` char(1) NOT NULL DEFAULT '0' COMMENT '送货状态 0:初始 1：完成',
  `send_dt` varchar(20) NOT NULL COMMENT '送货时间',
  `create_tm` varchar(20) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


DROP TABLE IF EXISTS `io_menu_b`;

CREATE TABLE `io_menu_b` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `parent_id` int(11) NOT NULL COMMENT '父菜单ID',
  `menu_nm` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(300) DEFAULT NULL COMMENT '菜单访问url',
  `is_usable` int(11) DEFAULT '1' COMMENT '0:不可用 1:可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `io_menu_b` */

insert  into `io_menu_b`(`id`,`parent_id`,`menu_nm`,`url`,`is_usable`) values (1,-1,'产品管理',NULL,1),(2,1,'产品信息录入','back/prd/initSave',1),(3,1,'产品信息查询','back/prd/initQuery',1),(4,-1,'入库管理',NULL,1),(5,4,'进货订单入库','back/inPrd/initSave',1),(6,4,'进货订单查询','back/inPrd/initQuery',1),(7,-1,'出库管理',NULL,1),(8,7,'出库订单录入','back/outOrder/initSave',1),(9,7,'出库订单查询','back/outOrder/initQuery',1),(10,-1,'库存管理',NULL,1),(11,10,'库存信息查询','back/wareH/initQuery',1),(12,-1,'客户管理',NULL,1),(13,12,'客户信息查询','back/cus/initQuery',1),(14,12,'客户信息录入','back/cus/initSave',1),(15,7,'配送信息查询','back/outOrder/sendQuery',1);
