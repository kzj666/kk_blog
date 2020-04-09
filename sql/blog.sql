/*
Navicat MySQL Data Transfer

Source Server         : 阿里云数据库
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : kk_blog

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-04-09 14:10:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键id',
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `user_password` varchar(50) NOT NULL COMMENT '用户密码',
  `version` int(10) DEFAULT '1' COMMENT '乐观锁',
  `user_nickname` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `id_deleted` int(1) DEFAULT '0' COMMENT '逻辑删除',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES ('1', 'admin', '123456', '1', 'kk', '0', null, null);

-- ----------------------------
-- Table structure for blog_comments
-- ----------------------------
DROP TABLE IF EXISTS `blog_comments`;
CREATE TABLE `blog_comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `phone` varchar(13) NOT NULL COMMENT '电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `comment` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `gmt_create` datetime DEFAULT NULL COMMENT '留言时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_comments
-- ----------------------------

-- ----------------------------
-- Table structure for blog_info
-- ----------------------------
DROP TABLE IF EXISTS `blog_info`;
CREATE TABLE `blog_info` (
  `blog_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `blog_title` varchar(255) NOT NULL COMMENT '博客标题',
  `blog_content` text NOT NULL COMMENT '博客内容',
  `blog_tags` varchar(200) NOT NULL COMMENT '博客标签',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_update` datetime DEFAULT NULL COMMENT '更新时间',
  `version` int(1) DEFAULT '1' COMMENT '乐观锁',
  `is_deleted` int(1) DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`blog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_info
-- ----------------------------
INSERT INTO `blog_info` VALUES ('22', '第一篇博客', '# 第一篇博客\r\n![](/upload/4月/pg-f385d95e9c4049c3b5b22cb512b2f6d3.jpg)', '技术类', '2020-04-09 12:05:16', '2020-04-09 12:05:16', '1', '0');
INSERT INTO `blog_info` VALUES ('23', '第二篇博客', '## 第二篇博客\r\n![](/upload/4月/pg-f1adbbd979f746b3b28c9cf4e7fa1164.jpg)', '科技类', '2020-04-09 12:05:54', '2020-04-09 12:05:54', '1', '0');
INSERT INTO `blog_info` VALUES ('24', '第三篇博客', '### 第三篇博客\r\n![](/upload/4月/pg-e7125462a15c459dac7ae389dc67ad25.jpg)', '生活类', '2020-04-09 12:06:19', '2020-04-09 12:06:19', '1', '0');
INSERT INTO `blog_info` VALUES ('25', '第四篇博客', '#### 第四篇博客\r\n![](/upload/4月/pg-79c2e7debe414082b197fa1e75476a37.jpg)', '财经类', '2020-04-09 12:06:44', '2020-04-09 12:06:44', '1', '0');
INSERT INTO `blog_info` VALUES ('26', '第五篇博客', '##### 第五篇博客\r\n![](/upload/4月/pg-ddd88120936441f9a5842df9284a6f1b.jpg)', '美食类', '2020-04-09 12:07:17', '2020-04-09 12:07:17', '1', '0');
INSERT INTO `blog_info` VALUES ('27', '第六篇博客', '###### 第六篇博客\r\n![](/upload/4月/pg-db3d8b030a4e4d4b8518d3c202f8623d.jpg)', '学习类', '2020-04-09 12:08:28', '2020-04-09 12:08:28', '1', '0');
