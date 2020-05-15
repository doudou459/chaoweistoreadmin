-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.57 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 chaoweistore 的数据库结构
CREATE DATABASE IF NOT EXISTS `chaoweistore` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `chaoweistore`;

-- 导出  表 chaoweistore.store_admin 结构
CREATE TABLE IF NOT EXISTS `store_admin` (
  `id` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'id',
  `loginID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '登录账号',
  `loginKey` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '登录密码',
  `roles` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '用户角色',
  `loginTime` bigint(13) unsigned zerofill DEFAULT '0000000000000' COMMENT '登录时间戳',
  `wrongTime` int(2) unsigned zerofill DEFAULT '00' COMMENT '密码错误次数',
  `lastLoginTime` bigint(13) unsigned zerofill DEFAULT '0000000000000' COMMENT '最后一次登录时间',
  `wx_openid_mp` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '微信公众号openid',
  `wx_openid_min` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '微信小程序openid',
  `wx_unionid` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '微信unionid',
  `nick_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '昵称',
  `touxiang` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '头像链接',
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginID` (`loginID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='管理员表';

-- 正在导出表  chaoweistore.store_admin 的数据：~4 rows (大约)
DELETE FROM `store_admin`;
/*!40000 ALTER TABLE `store_admin` DISABLE KEYS */;
INSERT INTO `store_admin` (`id`, `loginID`, `loginKey`, `roles`, `loginTime`, `wrongTime`, `lastLoginTime`, `wx_openid_mp`, `wx_openid_min`, `wx_unionid`, `nick_name`, `touxiang`) VALUES
	(000000001, 'root', 'e10adc3949ba59abbe56e057f20f883e', '1', 1589556268902, 00, 1589556268902, '', '', '', '', ''),
	(000000002, '2', 'e10adc3949ba59abbe56e057f20f883e', '6', 1588415572521, 00, 1588415572521, '', '', '', '', ''),
	(000000003, '3', 'e10adc3949ba59abbe56e057f20f883e', '3', 1588415266048, 00, 1588415266048, '', '', '', '', ''),
	(000000004, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '2', 1588415708330, 00, 1588415708330, '', '', '', '', '');
/*!40000 ALTER TABLE `store_admin` ENABLE KEYS */;

-- 导出  表 chaoweistore.store_appointment_item 结构
CREATE TABLE IF NOT EXISTS `store_appointment_item` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `itemName` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '项目名称',
  `startTime` time NOT NULL COMMENT '预约开始时间',
  `closeTime` time NOT NULL COMMENT '预约结束时间',
  `taktTime` int(4) NOT NULL COMMENT '时间间隔（10-180分钟）',
  `advanceDay` int(2) NOT NULL COMMENT '可提前多少天（1-30）',
  `max_people` int(2) NOT NULL COMMENT '单个时间段内最大预约人数（1-99）',
  `openAppointment` int(1) NOT NULL DEFAULT '1' COMMENT '0表示关闭，1表示开启',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='预约项目表';

-- 正在导出表  chaoweistore.store_appointment_item 的数据：~2 rows (大约)
DELETE FROM `store_appointment_item`;
/*!40000 ALTER TABLE `store_appointment_item` DISABLE KEYS */;
INSERT INTO `store_appointment_item` (`id`, `itemName`, `startTime`, `closeTime`, `taktTime`, `advanceDay`, `max_people`, `openAppointment`) VALUES
	(12, '美白（上午）', '06:00:00', '12:00:00', 30, 7, 3, 1),
	(13, '美白（下午）', '14:30:00', '18:00:00', 30, 30, 10, 1);
/*!40000 ALTER TABLE `store_appointment_item` ENABLE KEYS */;

-- 导出  表 chaoweistore.store_appointment_order 结构
CREATE TABLE IF NOT EXISTS `store_appointment_order` (
  `id` bigint(13) NOT NULL COMMENT 'id（订单创建时间）',
  `customerId` int(9) DEFAULT NULL COMMENT '预约用户id',
  `customerName` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '预约用户姓名',
  `phone` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '预约用户电话',
  `itemName` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '预约事项名称',
  `appointmentTime` bigint(13) DEFAULT NULL COMMENT '预约时间',
  `openid_min` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户微信小程序openid',
  `state` int(1) DEFAULT NULL COMMENT '预约状态（0：正常，1：修改待确认，2：已取消）',
  PRIMARY KEY (`id`),
  KEY `customerId` (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='预约订单';

-- 正在导出表  chaoweistore.store_appointment_order 的数据：~0 rows (大约)
DELETE FROM `store_appointment_order`;
/*!40000 ALTER TABLE `store_appointment_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `store_appointment_order` ENABLE KEYS */;

-- 导出  表 chaoweistore.store_carousel 结构
CREATE TABLE IF NOT EXISTS `store_carousel` (
  `id` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'id',
  `img_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '图片储存名称',
  `detail` text COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '富文本内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='轮播图片';

-- 正在导出表  chaoweistore.store_carousel 的数据：~3 rows (大约)
DELETE FROM `store_carousel`;
/*!40000 ALTER TABLE `store_carousel` DISABLE KEYS */;
INSERT INTO `store_carousel` (`id`, `img_name`, `detail`) VALUES
	(000000001, '1587300937209235064.png', '<p>sdfsdf<img src="/service/downloadFile?fileName=1587300677654756240.png" style="max-width: 100%;"></p>'),
	(000000003, '1587302293053292392.jpg', '<p><img src="/service/downloadFile?fileName=1587302299681558778.jpg" style="max-width:100%;"><br></p>'),
	(000000004, '1588413915794913867.png', '');
/*!40000 ALTER TABLE `store_carousel` ENABLE KEYS */;

-- 导出  表 chaoweistore.store_profile 结构
CREATE TABLE IF NOT EXISTS `store_profile` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `profile` text COLLATE utf8mb4_unicode_ci COMMENT '门店简介（富文本字符串）',
  `phone` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `maker` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '门店定位',
  `wx_appid_mp` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信公众号appid',
  `wx_appsecret` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信公众号appsecret(密钥)',
  `wx_appid_min` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信小程序appid',
  `wx_appsecrey_min` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信小程序密钥',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='门店简介';

-- 正在导出表  chaoweistore.store_profile 的数据：~1 rows (大约)
DELETE FROM `store_profile`;
/*!40000 ALTER TABLE `store_profile` DISABLE KEYS */;
INSERT INTO `store_profile` (`id`, `profile`, `phone`, `maker`, `wx_appid_mp`, `wx_appsecret`, `wx_appid_min`, `wx_appsecrey_min`) VALUES
	(1, '<p>奥斯卡的几哈按会计设定好看上的可适当卡时间的话可适当</p><p>阿克苏极好的看上的</p><p>奥斯卡讲得好</p><p>奥斯卡极好的我阿萨德开奖号奥斯卡讲得好</p><p>开具收到妇炎康几哈收到就好</p><p>卡时间的话，你</p><p>阿萨德开奖号</p><p>阿里卡时间的话45</p><p><img src="/service/downloadFile?fileName=1587295629635414038.jpg" style="max-width:100%;"><br></p>', '3456345', '104.283814,30.972046', '1111111111', '12222222222222222', '1111111111111', '12222222222222');
/*!40000 ALTER TABLE `store_profile` ENABLE KEYS */;

-- 导出  表 chaoweistore.store_promission 结构
CREATE TABLE IF NOT EXISTS `store_promission` (
  `id` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'id',
  `promission` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '权限',
  `roleid` int(9) unsigned zerofill DEFAULT '000000000' COMMENT '角色id',
  PRIMARY KEY (`id`),
  KEY `roleid` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='权限表';

-- 正在导出表  chaoweistore.store_promission 的数据：~7 rows (大约)
DELETE FROM `store_promission`;
/*!40000 ALTER TABLE `store_promission` DISABLE KEYS */;
INSERT INTO `store_promission` (`id`, `promission`, `roleid`) VALUES
	(000000001, 'root', 000000001),
	(000000002, 'admin', 000000002),
	(000000003, 'setAppointment', 000000003),
	(000000004, 'scanAppointment', 000000004),
	(000000005, 'carousel', 000000005),
	(000000006, 'profile', 000000006),
	(000000007, 'service', 000000007);
/*!40000 ALTER TABLE `store_promission` ENABLE KEYS */;

-- 导出  表 chaoweistore.store_promissionlist 结构
CREATE TABLE IF NOT EXISTS `store_promissionlist` (
  `id` int(11) NOT NULL COMMENT 'id',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '权限名称',
  `des` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='权限名称列表';

-- 正在导出表  chaoweistore.store_promissionlist 的数据：~7 rows (大约)
DELETE FROM `store_promissionlist`;
/*!40000 ALTER TABLE `store_promissionlist` DISABLE KEYS */;
INSERT INTO `store_promissionlist` (`id`, `name`, `des`) VALUES
	(1, 'root', '主管理员（admin+店铺设置+角色管理+账号管理）'),
	(2, 'admin', '管理员（店铺简介、轮播图、预约项目设置和查看）'),
	(3, 'profile', '店铺简介设置'),
	(4, 'carousel', '轮播图设置'),
	(5, 'setAppointment', '设置预约项目'),
	(6, 'scanAppointment', '查看预约订单'),
	(7, 'service', '客服');
/*!40000 ALTER TABLE `store_promissionlist` ENABLE KEYS */;

-- 导出  表 chaoweistore.store_role 结构
CREATE TABLE IF NOT EXISTS `store_role` (
  `id` int(9) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `roleName` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '角色名称',
  `desc` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户角色表';

-- 正在导出表  chaoweistore.store_role 的数据：~7 rows (大约)
DELETE FROM `store_role`;
/*!40000 ALTER TABLE `store_role` DISABLE KEYS */;
INSERT INTO `store_role` (`id`, `roleName`, `desc`) VALUES
	(1, '主管理员', '拥有所有权限'),
	(2, '管理员', '有用管理员权限'),
	(3, '预约设置员', '可对预约项目进行设置'),
	(4, '预约员', '可查看客户预约信息'),
	(5, '轮播图维护员', '可设置轮播图'),
	(6, '店铺简介维护员', '可设置店铺简介'),
	(7, '客服', '咨询客服');
/*!40000 ALTER TABLE `store_role` ENABLE KEYS */;

-- 导出  表 chaoweistore.store_server_to_user 结构
CREATE TABLE IF NOT EXISTS `store_server_to_user` (
  `id` int(9) NOT NULL COMMENT 'id',
  `serverid` int(9) NOT NULL COMMENT '客服id',
  `userid` int(9) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`),
  KEY `serverid` (`serverid`),
  KEY `userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 正在导出表  chaoweistore.store_server_to_user 的数据：~0 rows (大约)
DELETE FROM `store_server_to_user`;
/*!40000 ALTER TABLE `store_server_to_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `store_server_to_user` ENABLE KEYS */;

-- 导出  表 chaoweistore.store_service_news 结构
CREATE TABLE IF NOT EXISTS `store_service_news` (
  `id` bigint(13) NOT NULL COMMENT 'id(时间戳)',
  `userid` int(9) DEFAULT NULL COMMENT '用户id',
  `serverid` int(9) DEFAULT NULL COMMENT '客服id',
  `msgType` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '消息类型',
  `textContent` text COLLATE utf8mb4_unicode_ci COMMENT '文字消息内容',
  `pictureUrl` text COLLATE utf8mb4_unicode_ci COMMENT '图片链接',
  `msgId` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '消息id',
  `msgClass` int(1) DEFAULT NULL COMMENT '消息类型(0是用户发送消息，1是客服发送消息)',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `serverid` (`serverid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='客服消息';

-- 正在导出表  chaoweistore.store_service_news 的数据：~0 rows (大约)
DELETE FROM `store_service_news`;
/*!40000 ALTER TABLE `store_service_news` DISABLE KEYS */;
/*!40000 ALTER TABLE `store_service_news` ENABLE KEYS */;

-- 导出  表 chaoweistore.store_users 结构
CREATE TABLE IF NOT EXISTS `store_users` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `nick_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '微信昵称',
  `touxiang` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '微信头像图片',
  `sex` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT '未知' COMMENT '性别（男、女、未知）',
  `wx_openid_min` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '微信小程序openid',
  `wx_openid_mp` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '微信公众号openid',
  `wx_unionid` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '微信unionid',
  `user_level` int(2) NOT NULL DEFAULT '0' COMMENT '用户等级（默认0，数字越大vip等级越高）',
  PRIMARY KEY (`id`),
  KEY `wx_unionid` (`wx_unionid`),
  KEY `wx_openid_mp` (`wx_openid_mp`),
  KEY `wx_openid_min` (`wx_openid_min`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

-- 正在导出表  chaoweistore.store_users 的数据：~0 rows (大约)
DELETE FROM `store_users`;
/*!40000 ALTER TABLE `store_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `store_users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
