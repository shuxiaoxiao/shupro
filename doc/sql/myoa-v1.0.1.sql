/*
Navicat MySQL Data Transfer

Source Server         : mysql57
Source Server Version : 50703
Source Host           : 127.0.0.1:3306
Source Database       : myoa

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2016-12-08 22:51:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deptid` varchar(50) DEFAULT NULL COMMENT '部门id',
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `pid` varchar(50) DEFAULT '0' COMMENT '父id',
  `levels` varchar(2) DEFAULT NULL COMMENT '层级',
  `createtime` date DEFAULT NULL COMMENT '创建时间',
  `description` varchar(3000) DEFAULT NULL COMMENT '描述',
  `sotid` int(11) DEFAULT NULL COMMENT '排序号',
  `state` varchar(10) DEFAULT NULL COMMENT '节点状态，''open'' 或 ''closed''',
  `isenable` char(1) DEFAULT NULL COMMENT '状态, 0不可以 1可用',
  `type` varchar(20) DEFAULT NULL COMMENT '部门类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统表_部门';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT '0' COMMENT '父编码',
  `typeCode` varchar(50) DEFAULT NULL COMMENT '类型编码',
  `name` varchar(50) DEFAULT NULL COMMENT '显示的文字',
  `value` varchar(50) DEFAULT NULL COMMENT '存的具体值',
  `descs` varchar(500) DEFAULT NULL COMMENT '描述',
  `state` varchar(2) DEFAULT NULL COMMENT '状态，0不可用 1可用',
  `sotid` int(11) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统表_字典表';

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------
INSERT INTO `sys_dictionary` VALUES ('1', null, null, '性别', null, null, null, null);
INSERT INTO `sys_dictionary` VALUES ('2', null, null, '男', '1', null, null, null);
INSERT INTO `sys_dictionary` VALUES ('3', null, null, '女', '2', null, null, null);

-- ----------------------------
-- Table structure for sys_dictionary2
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary2`;
CREATE TABLE `sys_dictionary2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL COMMENT '字典编码',
  `pcode` varchar(50) DEFAULT '0' COMMENT '父编码',
  `name` varchar(50) DEFAULT NULL COMMENT '显示的文字',
  `value` varchar(50) DEFAULT NULL COMMENT '存的具体值',
  `descs` varchar(500) DEFAULT NULL COMMENT '描述',
  `state` varchar(2) DEFAULT NULL COMMENT '状态，0不可用 1可用',
  `sotid` int(11) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统表_字典表';

-- ----------------------------
-- Records of sys_dictionary2
-- ----------------------------
INSERT INTO `sys_dictionary2` VALUES ('1', null, null, '性别', null, null, null, null);
INSERT INTO `sys_dictionary2` VALUES ('2', null, null, '男', '1', null, null, null);
INSERT INTO `sys_dictionary2` VALUES ('3', null, null, '女', '2', null, null, null);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(100) DEFAULT NULL COMMENT '登录名',
  `roleName` varchar(100) DEFAULT NULL COMMENT '角色名',
  `content` varchar(4000) DEFAULT NULL COMMENT '内容',
  `clientIp` varchar(100) DEFAULT NULL COMMENT '客户端ip',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='系统表_操作日志表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initLinkButton,[请求路径]:/oa/initLinkButton,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 14:56:36');
INSERT INTO `sys_log` VALUES ('2', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initSwitchButton,[请求路径]:/oa/initSwitchButton,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 14:56:48');
INSERT INTO `sys_log` VALUES ('3', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initLinkButton,[请求路径]:/oa/initLinkButton,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 14:56:56');
INSERT INTO `sys_log` VALUES ('4', 'test', 'admin', '[类名]:com.shupro.oa.admin.controller.LoginController,[方法]:logoutAjax,[请求路径]:/oa/logout,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 15:57:43');
INSERT INTO `sys_log` VALUES ('5', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initSwitchButton,[请求路径]:/oa/initSwitchButton,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:00:07');
INSERT INTO `sys_log` VALUES ('6', 'test', 'admin', '[类名]:com.shupro.oa.admin.controller.LoginController,[方法]:logoutAjax,[请求路径]:/oa/logout,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:00:15');
INSERT INTO `sys_log` VALUES ('7', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initSwitchButton,[请求路径]:/oa/initSwitchButton,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:00:27');
INSERT INTO `sys_log` VALUES ('8', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initMessager,[请求路径]:/oa/initMessager,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:00:30');
INSERT INTO `sys_log` VALUES ('9', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initComboBox,[请求路径]:/oa/initComboBox,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:00:47');
INSERT INTO `sys_log` VALUES ('10', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initCombotree,[请求路径]:/oa/initCombotree,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:00:51');
INSERT INTO `sys_log` VALUES ('11', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initGrid,[请求路径]:/oa/initGrid,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:01:07');
INSERT INTO `sys_log` VALUES ('12', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initCombogrid,[请求路径]:/oa/initCombogrid,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:02:01');
INSERT INTO `sys_log` VALUES ('13', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initGrid,[请求路径]:/oa/initGrid,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:02:05');
INSERT INTO `sys_log` VALUES ('14', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initFormValide,[请求路径]:/oa/initForm-valide,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:02:29');
INSERT INTO `sys_log` VALUES ('15', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initDialog,[请求路径]:/oa/initDialog,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:04:16');
INSERT INTO `sys_log` VALUES ('16', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initTree,[请求路径]:/oa/initTree,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:04:21');
INSERT INTO `sys_log` VALUES ('17', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initTreegrid,[请求路径]:/oa/initTreegrid,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:04:26');
INSERT INTO `sys_log` VALUES ('18', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initSwitchButton,[请求路径]:/oa/initSwitchButton,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:12:08');
INSERT INTO `sys_log` VALUES ('19', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initFormValide,[请求路径]:/oa/initForm-valide,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:12:10');
INSERT INTO `sys_log` VALUES ('20', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initCombogrid,[请求路径]:/oa/initCombogrid,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:12:15');
INSERT INTO `sys_log` VALUES ('21', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initCombotree,[请求路径]:/oa/initCombotree,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:12:26');
INSERT INTO `sys_log` VALUES ('22', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initGrid,[请求路径]:/oa/initGrid,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:12:29');
INSERT INTO `sys_log` VALUES ('23', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initGrid2,[请求路径]:/oa/initGrid-js,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:12:31');
INSERT INTO `sys_log` VALUES ('24', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initPanel2,[请求路径]:/oa/initPanel-js,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:18:15');
INSERT INTO `sys_log` VALUES ('25', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initGrid,[请求路径]:/oa/initGrid,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:21:00');
INSERT INTO `sys_log` VALUES ('26', 'test', 'admin', '[类名]:com.shupro.oa.common.controller.DemoController,[方法]:initGrid2,[请求路径]:/oa/initGrid-js,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:21:03');
INSERT INTO `sys_log` VALUES ('27', 'test', 'admin', '[类名]:com.shupro.oa.admin.controller.LoginController,[方法]:logoutAjax,[请求路径]:/oa/logout,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-09-11 16:33:25');
INSERT INTO `sys_log` VALUES ('28', 'test', 'admin', '[类名]:com.shupro.oa.admin.controller.SysUserController,[方法]:update,[请求路径]:/oa/sysUser/update,[参数]:{\"createtime\":\"\",\"id\":\"1\",\"leavetime\":\"\",\"icon\":\"\",\"loginname\":\"test\",\"sex\":\"\",\"pwd\":\"123\",\"deptid\":\"\",\"address\":\"\",\"name\":\"测试账号\",\"phonenum2\":\"\",\"states\":\"\",\"sotid\":\"\",\"usertype\":\"\",\"phonenum\":\"1351233232\"}', '0:0:0:0:0:0:0:1', '2016-09-26 22:38:51');
INSERT INTO `sys_log` VALUES ('29', 'test', null, '[类名]:com.shupro.oa.admin.controller.LoginController,[方法]:logoutAjax,[请求路径]:/logout,[参数]:{}', '0:0:0:0:0:0:0:1', '2016-12-04 23:05:07');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL COMMENT '菜单名称',
  `pid` int(11) DEFAULT NULL COMMENT '父id',
  `levels` varchar(2) DEFAULT NULL COMMENT '层级',
  `createtime` date DEFAULT NULL COMMENT '创建时间',
  `requestUrl` varchar(200) DEFAULT NULL COMMENT '请求路径',
  `menuType` varchar(10) DEFAULT NULL COMMENT '菜单类型,1菜单 2按钮',
  `isenable` char(1) DEFAULT NULL COMMENT '状态，0不可用 1可用',
  `sotid` int(11) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='系统表_菜单';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', '1', null, null, 'menu', '1', null);
INSERT INTO `sys_menu` VALUES ('2', '员工管理', '1', '2', null, '/sysUser/init', 'menu', '1', null);
INSERT INTO `sys_menu` VALUES ('3', '组织结构管理', '1', '2', null, '/sysDept/init', 'menu', '1', null);
INSERT INTO `sys_menu` VALUES ('4', '角色管理', '1', '2', null, '/sysRole/init', 'menu', '1', null);
INSERT INTO `sys_menu` VALUES ('5', '资源菜单管理', '1', '2', null, '/sysMenu/init', 'menu', '1', null);
INSERT INTO `sys_menu` VALUES ('6', '字典管理', '1', '2', null, '/sysDictionary/init', 'menu', '1', null);
INSERT INTO `sys_menu` VALUES ('7', 'demo示例', '0', '1', null, null, 'menu', '1', null);
INSERT INTO `sys_menu` VALUES ('8', 'LinkButton（按钮）', '7', '2', null, '/initLinkButton', 'menu', '1', null);
INSERT INTO `sys_menu` VALUES ('9', 'SwitchButton（开关按钮）', '7', '2', null, '/initSwitchButton', 'menu', '1', null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL COMMENT '名称',
  `description` varchar(3000) DEFAULT NULL COMMENT '描述',
  `type` varchar(2) DEFAULT NULL COMMENT '角色类型',
  `isenable` char(1) DEFAULT NULL COMMENT '状态，0不可用 1可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统表_角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系统管理员', '最高权限的角色', null, null);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roleId` int(11) DEFAULT NULL COMMENT '角色表id',
  `menuId` int(11) DEFAULT NULL COMMENT '菜单表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单_中间表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `loginName` varchar(50) NOT NULL COMMENT '登录名',
  `pwd` varchar(50) DEFAULT NULL COMMENT '密码',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `icon` varchar(500) DEFAULT NULL COMMENT '图标',
  `phoneNum` varchar(20) DEFAULT NULL COMMENT '手机号',
  `phoneNum2` varchar(20) DEFAULT NULL COMMENT '备用号',
  `address` varchar(1000) DEFAULT NULL COMMENT '地址',
  `state` char(1) DEFAULT NULL COMMENT '用户状态',
  `deptid` varchar(50) DEFAULT NULL COMMENT '部门id',
  `createtime` date DEFAULT NULL COMMENT '入职时间',
  `leavetime` date DEFAULT NULL COMMENT '离职时间',
  `userType` varchar(2) DEFAULT NULL COMMENT '用户类型',
  `sotid` int(11) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_loginName` (`loginName`) USING BTREE COMMENT '登录名唯一'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统表_用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '测试账号', 'test', '123', null, null, '1351233232', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_user_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_menu`;
CREATE TABLE `sys_user_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL COMMENT '用户表id',
  `menuId` int(11) DEFAULT NULL COMMENT '菜单表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户菜单_中间表';

-- ----------------------------
-- Records of sys_user_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL COMMENT '用户表id',
  `roleId` int(11) DEFAULT NULL COMMENT '角色表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色_中间表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
