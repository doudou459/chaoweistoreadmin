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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='管理员表';

-- 数据导出被取消选择。
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='预约项目表';

-- 数据导出被取消选择。
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

-- 数据导出被取消选择。
-- 导出  表 chaoweistore.store_carousel 结构
CREATE TABLE IF NOT EXISTS `store_carousel` (
  `id` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'id',
  `img_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '图片储存名称',
  `detail` text COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '富文本内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='轮播图片';

-- 数据导出被取消选择。
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

-- 数据导出被取消选择。
-- 导出  表 chaoweistore.store_promission 结构
CREATE TABLE IF NOT EXISTS `store_promission` (
  `id` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'id',
  `promission` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '权限',
  `roleid` int(9) unsigned zerofill DEFAULT '000000000' COMMENT '角色id',
  PRIMARY KEY (`id`),
  KEY `roleid` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='权限表';

-- 数据导出被取消选择。
-- 导出  表 chaoweistore.store_promissionlist 结构
CREATE TABLE IF NOT EXISTS `store_promissionlist` (
  `id` int(11) NOT NULL COMMENT 'id',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '权限名称',
  `des` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='权限名称列表';

-- 数据导出被取消选择。
-- 导出  表 chaoweistore.store_role 结构
CREATE TABLE IF NOT EXISTS `store_role` (
  `id` int(9) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `roleName` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '角色名称',
  `desc` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户角色表';

-- 数据导出被取消选择。
-- 导出  表 chaoweistore.store_server_to_user 结构
CREATE TABLE IF NOT EXISTS `store_server_to_user` (
  `id` int(9) NOT NULL COMMENT 'id',
  `serverid` int(9) NOT NULL COMMENT '客服id',
  `userid` int(9) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`),
  KEY `serverid` (`serverid`),
  KEY `userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 数据导出被取消选择。
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

-- 数据导出被取消选择。
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

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
