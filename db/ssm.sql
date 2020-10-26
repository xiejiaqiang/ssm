/*
Navicat MySQL Data Transfer

Source Server         : 本地库
Source Server Version : 80022
Source Host           : 127.0.0.1:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2020-10-26 22:43:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `attachmentId` int NOT NULL AUTO_INCREMENT COMMENT ''附件ID'',
  `attachmentName` varchar(50) DEFAULT NULL COMMENT ''名称'',
  `attachmentPath` varchar(50) DEFAULT NULL COMMENT ''路径'',
  `attachmentTime` datetime DEFAULT NULL COMMENT ''时间'',
  PRIMARY KEY (`attachmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attachment
-- ----------------------------
INSERT INTO `attachment` VALUES (''1'', ''手动备份20171129142347.xls'', ''logs/backup'', ''2017-11-29 14:23:47'');
INSERT INTO `attachment` VALUES (''2'', ''手动备份20171129142641.xls'', ''logs/backup'', ''2017-11-29 14:26:41'');
INSERT INTO `attachment` VALUES (''3'', ''手动备份20171129142920.xls'', ''logs/backup'', ''2017-11-29 14:29:20'');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `logId` bigint NOT NULL AUTO_INCREMENT COMMENT ''日志'',
  `userName` varchar(30) DEFAULT NULL COMMENT ''操作人'',
  `createTime` datetime DEFAULT NULL COMMENT ''时间'',
  `content` text COMMENT ''详细'',
  `operation` varchar(300) DEFAULT NULL COMMENT ''操作类型（增删改）'',
  `ip` varchar(60) DEFAULT NULL COMMENT ''IP地址'',
  `module` varchar(40) DEFAULT NULL COMMENT ''所属模块'',
  PRIMARY KEY (`logId`)
) ENGINE=InnoDB AUTO_INCREMENT=254 DEFAULT CHARSET=utf8 COMMENT=''操作日志记录'';

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES (''1'', ''test'', ''2017-11-29 14:31:04'', null, ''退出'', null, null);
INSERT INTO `log` VALUES (''2'', ''test'', ''2017-11-29 14:31:14'', null, ''登录'', ''192.168.1.17'', null);
INSERT INTO `log` VALUES (''3'', ''admin'', ''2020-10-17 11:26:19'', ''管理员登录操作'', ''登录'', ''0:0:0:0:0:0:0:1'', ''6'');
INSERT INTO `log` VALUES (''4'', ''admin'', ''2020-10-17 11:27:38'', ''管理员登录操作'', ''登录'', ''0:0:0:0:0:0:0:1'', ''6'');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menuId` int NOT NULL AUTO_INCREMENT COMMENT ''菜单ID'',
  `menuName` varchar(50) DEFAULT NULL COMMENT ''名称'',
  `menuUrl` varchar(100) DEFAULT NULL COMMENT ''方法'',
  `parentId` int DEFAULT NULL COMMENT ''父ID'',
  `menuDescription` varchar(200) DEFAULT NULL COMMENT ''描述'',
  `state` varchar(20) DEFAULT NULL COMMENT ''状态/OPEN/CLOSED'',
  `iconCls` varchar(50) DEFAULT NULL COMMENT ''图标'',
  `seq` int DEFAULT NULL COMMENT ''顺序排序'',
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (''1'', ''上海佳一后台管理系统'', '''', ''-1'', ''主菜单'', ''isParent'', ''fa fa-university'', ''1'');
INSERT INTO `menu` VALUES (''2'', ''系统管理'', '''', ''1'', '''', ''isParent'', ''fa fa-desktop'', ''5'');
INSERT INTO `menu` VALUES (''3'', ''修改密码'', ''javascript:editPassword();//'', ''1'', '''', ''close'', ''fa fa-key'', ''98'');
INSERT INTO `menu` VALUES (''4'', ''安全退出'', ''logout.htm'', ''1'', '''', ''close'', ''fa fa-user-times'', ''99'');
INSERT INTO `menu` VALUES (''5'', ''菜单管理'', ''menu/menuIndex.htm'', ''2'', '''', '''', ''fa fa-sliders'', ''4'');
INSERT INTO `menu` VALUES (''6'', ''角色管理'', ''role/roleIndex.htm'', ''2'', '''', '''', ''fa fa-users'', ''3'');
INSERT INTO `menu` VALUES (''7'', ''用户管理'', ''user/userIndex.htm'', ''2'', '''', '''', ''fa fa-user'', ''2'');
INSERT INTO `menu` VALUES (''8'', ''日志管理'', ''log/logIndex.htm'', ''2'', '''', '''', ''fa fa-tags'', ''4'');
INSERT INTO `menu` VALUES (''9'', ''订单管理'', '''', ''1'', '''', ''isParent'', ''fa fa-list'', ''1'');
INSERT INTO `menu` VALUES (''10'', ''发票管理'', '''', ''1'', '''', ''close'', ''fa fa-money'', ''3'');
INSERT INTO `menu` VALUES (''12'', ''商品管理'', '''', ''1'', '''', ''isParent'', ''fa fa-optin-monster'', ''2'');
INSERT INTO `menu` VALUES (''13'', ''营销管理'', '''', ''1'', '''', ''isParent'', ''fa fa-superscript'', ''4'');
INSERT INTO `menu` VALUES (''14'', ''支付订单管理'', ''orderInfo/orderInfoIndex.htm'', ''9'', '''', null, ''fa fa-cart-plus'', ''1'');
INSERT INTO `menu` VALUES (''15'', ''售后订单'', '''', ''9'', '''', null, ''fa fa-close (alias)'', ''2'');
INSERT INTO `menu` VALUES (''16'', ''礼品订单'', '''', ''9'', '''', null, ''fa fa-user-secret'', ''3'');
INSERT INTO `menu` VALUES (''17'', ''礼品管理'', '''', ''13'', '''', null, ''fa fa-gift'', ''1'');
INSERT INTO `menu` VALUES (''18'', ''商品分类'', ''mdseCat/mdseCatIndex.htm'', ''12'', '''', null, ''fa fa-cubes'', ''3'');
INSERT INTO `menu` VALUES (''20'', ''商品分类'', ''1'', ''19'', ''1'', null, ''11'', ''1'');
INSERT INTO `menu` VALUES (''26'', ''商品管理'', ''mdseInfo/mdseInfoIndex.htm'', ''12'', '''', null, ''fa fa-glass'', ''1'');

-- ----------------------------
-- Table structure for operation
-- ----------------------------
DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation` (
  `operationId` int NOT NULL AUTO_INCREMENT COMMENT ''具体的方法'',
  `operationName` varchar(100) DEFAULT NULL COMMENT ''方法名'',
  `menuId` int DEFAULT NULL COMMENT ''所属菜单'',
  `menuName` varchar(50) NOT NULL,
  `operationCode` varchar(50) DEFAULT NULL,
  `iconCls` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`operationId`),
  KEY `menuId` (`menuId`),
  CONSTRAINT `operation_ibfk_1` FOREIGN KEY (`menuId`) REFERENCES `menu` (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=10053 DEFAULT CHARSET=utf8 COMMENT=''具体的页面按钮上的方法\r\n（此自增ID至少从10000开始）'';

-- ----------------------------
-- Records of operation
-- ----------------------------
INSERT INTO `operation` VALUES (''10000'', ''添加'', ''5'', ''菜单管理'', ''add'', '''');
INSERT INTO `operation` VALUES (''10001'', ''修改'', ''5'', ''菜单管理'', ''edit'', '''');
INSERT INTO `operation` VALUES (''10002'', ''删除'', ''5'', ''菜单管理'', ''del'', '''');
INSERT INTO `operation` VALUES (''10003'', ''添加'', ''7'', ''用户管理'', ''btn_add'', ''glyphicon glyphicon-plus'');
INSERT INTO `operation` VALUES (''10004'', ''修改'', ''7'', ''用户管理'', ''btn_edit'', ''glyphicon glyphicon-pencil'');
INSERT INTO `operation` VALUES (''10005'', ''删除'', ''7'', ''用户管理'', ''btn_delete'', ''glyphicon glyphicon-remove'');
INSERT INTO `operation` VALUES (''10006'', ''添加'', ''6'', ''角色管理'', ''btn_add'', ''glyphicon glyphicon-plus'');
INSERT INTO `operation` VALUES (''10007'', ''修改'', ''6'', ''角色管理'', ''btn_edit'', ''glyphicon glyphicon-pencil'');
INSERT INTO `operation` VALUES (''10008'', ''删除'', ''6'', ''角色管理'', ''btn_delete'', ''glyphicon glyphicon-remove'');
INSERT INTO `operation` VALUES (''10009'', ''授权'', ''6'', ''角色管理'', ''btn_rightCtrl'', ''glyphicon glyphicon-eye-open'');
INSERT INTO `operation` VALUES (''10010'', ''下载后台日志（log4j）'', ''8'', ''日志管理'', ''btn_downloadLog4j'', ''glyphicon glyphicon-download-alt'');
INSERT INTO `operation` VALUES (''10011'', ''手动备份（业务操作）'', ''8'', ''日志管理'', ''btn_manualBackup'', ''glyphicon glyphicon-inbox'');
INSERT INTO `operation` VALUES (''10012'', ''删除'', ''8'', ''日志管理'', ''btn_delete'', ''glyphicon glyphicon-remove'');
INSERT INTO `operation` VALUES (''10013'', ''按钮管理'', ''5'', ''菜单管理'', ''btnCtrl'', '''');
INSERT INTO `operation` VALUES (''10014'', ''备份日志记录'', ''8'', ''日志管理'', ''btn_downloadLogBus'', ''glyphicon glyphicon-download'');
INSERT INTO `operation` VALUES (''10015'', ''添加'', ''14'', ''支付订单管理'', ''btn_add'', ''glyphicon glyphicon-plus	'');
INSERT INTO `operation` VALUES (''10041'', ''修改'', ''14'', ''支付订单管理'', ''btn_edit'', ''glyphicon glyphicon-pencil'');
INSERT INTO `operation` VALUES (''10042'', ''删除'', ''14'', ''支付订单管理'', ''btn_delete'', ''glyphicon glyphicon-remove'');
INSERT INTO `operation` VALUES (''10043'', ''导出'', ''14'', ''支付订单管理'', ''btn_export'', ''glyphicon glyphicon-export'');
INSERT INTO `operation` VALUES (''10045'', ''批量导入'', ''14'', ''支付订单管理'', ''btn_import'', ''glyphicon glyphicon-import'');
INSERT INTO `operation` VALUES (''10046'', ''添加'', ''18'', ''商品分类'', ''btn_add'', ''glyphicon glyphicon-plus'');
INSERT INTO `operation` VALUES (''10047'', ''修改'', ''18'', ''商品分类'', ''btn_edit'', ''glyphicon glyphicon-pencil'');
INSERT INTO `operation` VALUES (''10048'', ''删除'', ''18'', ''商品分类'', ''btn_delete'', ''glyphicon glyphicon-remove'');
INSERT INTO `operation` VALUES (''10049'', ''添加'', ''26'', ''商品管理'', ''btn_add'', ''glyphicon glyphicon-plus	'');
INSERT INTO `operation` VALUES (''10050'', ''修改'', ''26'', ''商品管理'', ''btn_edit'', ''glyphicon glyphicon-pencil'');
INSERT INTO `operation` VALUES (''10051'', ''删除'', ''26'', ''商品管理'', ''btn_delete'', ''glyphicon glyphicon-remove'');
INSERT INTO `operation` VALUES (''10052'', ''价格管理'', ''26'', ''商品管理'', ''btn_price_adm'', ''glyphicon glyphicon-usd'');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` int NOT NULL AUTO_INCREMENT COMMENT ''角色ID'',
  `roleName` varchar(20) DEFAULT NULL COMMENT ''角色名称'',
  `menuIds` varchar(200) DEFAULT NULL COMMENT ''菜单IDs'',
  `operationIds` varchar(200) DEFAULT NULL COMMENT ''按钮IDS'',
  `roleDescription` varchar(200) DEFAULT NULL COMMENT ''描述'',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (''1'', ''超级管理员'', ''1,2,3,4,5,6,7,8,9,10,12,13,14,15,16,17,18,26'', ''10000,10001,10002,10013,10006,10007,10008,10009,10003,10004,10005,10010,10011,10012,10014,10015,10041,10042,10043,10045,10046,10047,10048,10049,10050,10051,10052'', ''拥有全部权限的超级管理员角色'');
INSERT INTO `role` VALUES (''2'', ''测试员'', ''1,2,3,4,6,7,8,9,10,12,13,14,15,16,17'', ''10006,10007,10008,10009,10003,10004,10005,10010,10011,10012,10014'', ''拥有系统所有业务功能的角色1'');

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token` (
  `tokenId` bigint NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL COMMENT ''用户ID'',
  `userAgent` varchar(50) DEFAULT NULL COMMENT ''用户（md5）'',
  `token` varchar(100) DEFAULT NULL COMMENT ''md5(username+md5(useragent))'',
  `createTime` datetime DEFAULT NULL COMMENT ''创建时间'',
  `expireTime` datetime DEFAULT NULL COMMENT ''到期时间'',
  PRIMARY KEY (`tokenId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT=''用户登录信息（用于自动登录）'';

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (''1'', ''1'', ''0b239ed7c13c034f6b834897f0b54bba'', ''66895df164cf660402ab453a53496cd6'', ''2017-11-29 14:26:21'', ''2017-12-13 14:26:21'');

-- ----------------------------
-- Table structure for t_after_sale
-- ----------------------------
DROP TABLE IF EXISTS `t_after_sale`;
CREATE TABLE `t_after_sale` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT ''主键'',
  `originalOrderNo` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ''原订单编号'',
  `afterSaleOrderNo` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ''售后订单编号'',
  `afterSaleAmount` decimal(10,2) NOT NULL COMMENT ''售后金额'',
  `afterSaleType` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ''售后类型 1-退货 2-换货 3-补差价'',
  `afterSalseReason` varchar(125) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''原因'',
  `afterSalseStatus` char(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ''售后处理状态 0-待审核 1-已审核 2-已拒绝'',
  `newLogisticsOrderNo` char(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''新物流单号'',
  `tradingTime` timestamp NULL DEFAULT NULL COMMENT ''交易时间'',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT ''更新时间'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT=''售后订单表'';

-- ----------------------------
-- Records of t_after_sale
-- ----------------------------

-- ----------------------------
-- Table structure for t_gift_info
-- ----------------------------
DROP TABLE IF EXISTS `t_gift_info`;
CREATE TABLE `t_gift_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT ''主键'',
  `giftNo` varchar(18) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ''礼品编号'',
  `giftName` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''礼品名称'',
  `giftLink` varchar(126) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''礼品链接'',
  `giftAmount` decimal(10,2) DEFAULT NULL COMMENT ''礼品金额'',
  `channel` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''进货渠道'',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UIN_INDEX` (`giftNo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT=''礼品信息表'';

-- ----------------------------
-- Records of t_gift_info
-- ----------------------------

-- ----------------------------
-- Table structure for t_mdse_cat
-- ----------------------------
DROP TABLE IF EXISTS `t_mdse_cat`;
CREATE TABLE `t_mdse_cat` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT ''主键'',
  `mdseCatNo` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ''商品分类编号'',
  `mdseCatName` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ''商品分类名称'',
  `parentId` bigint NOT NULL COMMENT ''父id'',
  `state` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''状态/OPEN/CLOSED'',
  `creationTime` timestamp NULL DEFAULT NULL COMMENT ''创建时间'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT=''商品分类表'';

-- ----------------------------
-- Records of t_mdse_cat
-- ----------------------------
INSERT INTO `t_mdse_cat` VALUES (''20'', ''xyj'', ''洗衣机'', ''-1'', ''isParent'', ''2020-10-24 20:45:34'');
INSERT INTO `t_mdse_cat` VALUES (''21'', ''xyj_xte'', ''小天鹅洗衣机'', ''20'', ''isParent'', ''2020-10-24 20:45:49'');
INSERT INTO `t_mdse_cat` VALUES (''23'', ''xyj_xte_gt'', ''小天鹅滚筒'', ''21'', null, ''2020-10-24 20:49:03'');
INSERT INTO `t_mdse_cat` VALUES (''24'', ''xyj_xte_bl'', ''小天鹅波轮'', ''21'', null, ''2020-10-24 20:49:40'');
INSERT INTO `t_mdse_cat` VALUES (''25'', ''xyj_md'', ''美的洗衣机'', ''20'', ''isParent'', ''2020-10-24 20:50:00'');
INSERT INTO `t_mdse_cat` VALUES (''26'', ''xyj_md_gt'', ''美的滚筒'', ''25'', null, ''2020-10-24 20:50:42'');
INSERT INTO `t_mdse_cat` VALUES (''27'', ''xyj_md_bl'', ''美的波轮'', ''25'', null, ''2020-10-24 20:51:06'');
INSERT INTO `t_mdse_cat` VALUES (''28'', ''gyj'', ''干衣机'', ''-1'', ''isParent'', ''2020-10-24 20:51:24'');
INSERT INTO `t_mdse_cat` VALUES (''29'', ''gyj_md'', ''美的干衣机'', ''28'', null, ''2020-10-24 20:51:47'');
INSERT INTO `t_mdse_cat` VALUES (''30'', ''gyj_xte'', ''小天鹅干衣机'', ''28'', null, ''2020-10-24 20:52:33'');
INSERT INTO `t_mdse_cat` VALUES (''31'', ''xyj_xte_xhyt'', ''小天鹅洗烘一体'', ''21'', null, ''2020-10-24 21:22:43'');
INSERT INTO `t_mdse_cat` VALUES (''32'', ''xyj_md_xhyt'', ''美的洗烘一体'', ''25'', null, ''2020-10-24 21:23:28'');
INSERT INTO `t_mdse_cat` VALUES (''33'', ''xyj_xte_xhtz'', ''小天鹅洗烘套装'', ''21'', '''', ''2020-10-24 21:24:01'');
INSERT INTO `t_mdse_cat` VALUES (''34'', ''xyj_md_xhtz'', ''美的洗烘套装'', ''25'', null, ''2020-10-24 21:24:23'');

-- ----------------------------
-- Table structure for t_mdse_info
-- ----------------------------
DROP TABLE IF EXISTS `t_mdse_info`;
CREATE TABLE `t_mdse_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT ''主键'',
  `mdseNo` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ''商品编号'',
  `mdseName` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ''商品名称'',
  `title` varchar(120) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''标题'',
  `colour` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''颜色'',
  `model` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ''型号'',
  `mdseCat` varchar(80) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ''商品分类'',
  `mdseSku` tinyint DEFAULT NULL COMMENT ''商品库存'',
  `mdseStatus` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ''商品状态 0-待上市;1-已上市;2-已下市'',
  `brand` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''品牌'',
  `series` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''系列'',
  `sellingPoint` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''卖点'',
  `pictureId` bigint DEFAULT NULL COMMENT ''图片ID'',
  `parameter1` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''参数1'',
  `parameter2` varchar(125) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''参数2'',
  `createTime` timestamp NULL DEFAULT NULL COMMENT ''创建时间'',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT ''更新时间'',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Uni_Index` (`mdseNo`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT=''商品信息表'';

-- ----------------------------
-- Records of t_mdse_info
-- ----------------------------
INSERT INTO `t_mdse_info` VALUES (''1'', ''TB100V23'', ''小天鹅洗衣机'', ''小天鹅（LittleSwan）10公斤 波轮洗衣机全自动 健康免清洗 品质电机 TB100V23'', ''金色'', ''TB100V23'', ''31'', ''123'', ''1'', ''小天鹅'', ''水魔方'', ''123213213'', ''1'', null, null, null, null);
INSERT INTO `t_mdse_info` VALUES (''2'', ''MD100V11D'', ''美的洗衣机'', ''美的 （Midea）滚筒洗衣机全自动 10公斤洗烘一体 祛味空气洗 智能烘干 BLDC静音变频 MD100V11D'', ''白色'', ''MD100V11D'', ''32'', ''12'', ''2'', ''美的'', ''水魔方'', ''1231321'', ''2'', null, null, null, null);

-- ----------------------------
-- Table structure for t_mdse_price
-- ----------------------------
DROP TABLE IF EXISTS `t_mdse_price`;
CREATE TABLE `t_mdse_price` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT ''主键'',
  `mdseNo` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ''商品编号'',
  `buyingPrice` decimal(10,2) NOT NULL COMMENT ''进货价'',
  `retailPrice` decimal(10,2) NOT NULL COMMENT ''零售指导价'',
  `floorPrice` decimal(10,2) NOT NULL COMMENT ''底价'',
  `tradePrice` decimal(10,2) DEFAULT NULL COMMENT ''批发价'',
  `profit` decimal(10,2) DEFAULT NULL COMMENT ''利润'',
  `profitMargin` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''利润率'',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNI_INDEX` (`mdseNo`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT=''商品价格表'';

-- ----------------------------
-- Records of t_mdse_price
-- ----------------------------
INSERT INTO `t_mdse_price` VALUES (''1'', ''MD100V11D'', ''123.00'', ''999.00'', ''321.00'', ''123.00'', ''12.00'', ''213123'');

-- ----------------------------
-- Table structure for t_order_gift
-- ----------------------------
DROP TABLE IF EXISTS `t_order_gift`;
CREATE TABLE `t_order_gift` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT ''主键'',
  `orderNo` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''订单编号'',
  `giftNo` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''礼品编号'',
  `logisticsNo` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''礼品单号'',
  `logisticsAmount` decimal(10,2) DEFAULT NULL COMMENT ''礼品金额'',
  `mark` varchar(156) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''说明'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT=''订单礼品表'';

-- ----------------------------
-- Records of t_order_gift
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_info
-- ----------------------------
DROP TABLE IF EXISTS `t_order_info`;
CREATE TABLE `t_order_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT ''主键'',
  `orderNo` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ''订单编号'',
  `mdseNo` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''商品编号'',
  `custName` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ''客户姓名'',
  `numberNo` char(13) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ''手机号'',
  `address` varchar(120) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ''收货地址'',
  `orderAmount` decimal(10,2) NOT NULL COMMENT ''订单金额'',
  `actPayAmount` decimal(10,2) NOT NULL COMMENT ''实付金额'',
  `discountType` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''优惠分类 1-店铺券,2-平台券,3-满减,4-客服优惠'',
  `orderStatus` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ''订单状态 0-待支付，1-已付款，2-已发货，3-已收货，4-退款中，5-已退款'',
  `logisticsNo` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''物流单号'',
  `invoiceFlg` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ''开票说明 1-已开票，2-未开票，3-开票中'',
  `invoiceType` varchar(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''开票类型 1-普票，2-专票'',
  `orderDate` date NOT NULL COMMENT ''订单日期'',
  `orderQuantity` bigint NOT NULL COMMENT ''订单数量'',
  `purchasePrice` decimal(10,2) DEFAULT NULL COMMENT ''进货价格'',
  `purchaseSource` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''进货来源'',
  `orderChannel` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''订单渠道 1-天猫 2-京东 3-淘宝 4-拼多多'',
  `remarks` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ''备注'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3771 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT=''订单信息表'';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int NOT NULL AUTO_INCREMENT COMMENT ''用户ID'',
  `userName` varchar(20) DEFAULT NULL COMMENT ''用户名'',
  `password` varchar(20) DEFAULT NULL COMMENT ''密码'',
  `userType` tinyint DEFAULT NULL COMMENT ''用户类型'',
  `roleId` int DEFAULT NULL COMMENT ''角色ID'',
  `userDescription` varchar(200) DEFAULT NULL COMMENT ''描述信息'',
  PRIMARY KEY (`userId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (''1'', ''admin'', ''admin'', null, ''1'', null);
INSERT INTO `user` VALUES (''25'', ''test'', ''test'', null, ''2'', '''');
INSERT INTO `user` VALUES (''26'', ''test8'', ''admin'', null, ''1'', '''');
