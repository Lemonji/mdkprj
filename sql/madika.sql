/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : madika

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2019-03-27 17:07:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `area_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(64) NOT NULL DEFAULT '' COMMENT '区域名',
  `area_num` varchar(64) NOT NULL DEFAULT '' COMMENT '区域编号',
  `yl1` varchar(255) DEFAULT NULL,
  `yl2` varchar(255) DEFAULT NULL,
  `yl3` varchar(255) DEFAULT NULL,
  `yl4` varchar(255) DEFAULT NULL,
  `yl5` varchar(255) DEFAULT NULL,
  `yl6` varchar(255) DEFAULT NULL,
  `yl7` varchar(255) DEFAULT NULL,
  `yl8` varchar(255) DEFAULT NULL,
  `yl9` varchar(255) DEFAULT NULL,
  `yl10` varchar(255) DEFAULT NULL,
  `yl11` varchar(255) DEFAULT NULL,
  `yl12` varchar(255) DEFAULT NULL,
  `yl13` varchar(255) DEFAULT NULL,
  `yl14` varchar(255) DEFAULT NULL,
  `yl15` varchar(255) DEFAULT NULL,
  `yl16` varchar(255) DEFAULT NULL,
  `yl17` varchar(255) DEFAULT NULL,
  `yl18` varchar(255) DEFAULT NULL,
  `yl19` varchar(255) DEFAULT NULL,
  `yl20` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of area
-- ----------------------------

-- ----------------------------
-- Table structure for company_order
-- ----------------------------
DROP TABLE IF EXISTS `company_order`;
CREATE TABLE `company_order` (
  `company_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '单位ID',
  `company_name` varchar(64) DEFAULT '""' COMMENT '单位名称',
  `company_num` varchar(64) DEFAULT '""' COMMENT '单位编号',
  `company_code` varchar(64) DEFAULT '""' COMMENT '单位信用代码',
  `company_area` varchar(64) DEFAULT '""' COMMENT '单位区域',
  `yl1` varchar(255) DEFAULT NULL,
  `yl2` varchar(255) DEFAULT NULL,
  `yl3` varchar(255) DEFAULT NULL,
  `yl4` varchar(255) DEFAULT NULL,
  `yl5` varchar(255) DEFAULT NULL,
  `yl6` varchar(255) DEFAULT NULL,
  `yl7` varchar(255) DEFAULT NULL,
  `yl8` varchar(255) DEFAULT NULL,
  `yl9` varchar(255) DEFAULT NULL,
  `yl10` varchar(255) DEFAULT NULL,
  `yl11` varchar(255) DEFAULT NULL,
  `yl12` varchar(255) DEFAULT NULL,
  `yl13` varchar(255) DEFAULT NULL,
  `yl14` varchar(255) DEFAULT NULL,
  `yl15` varchar(255) DEFAULT NULL,
  `yl16` varchar(255) DEFAULT NULL,
  `yl17` varchar(255) DEFAULT NULL,
  `yl18` varchar(255) DEFAULT NULL,
  `yl19` varchar(255) DEFAULT NULL,
  `yl20` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_order
-- ----------------------------

-- ----------------------------
-- Table structure for examination_audit
-- ----------------------------
DROP TABLE IF EXISTS `examination_audit`;
CREATE TABLE `examination_audit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `card_type` varchar(11) NOT NULL DEFAULT '' COMMENT '证件类型',
  `unit` varchar(64) NOT NULL DEFAULT '' COMMENT '颁证单位',
  `card_num` varchar(64) NOT NULL DEFAULT '' COMMENT '证照编号',
  `time` date NOT NULL COMMENT '颁证时间',
  `start_time` date NOT NULL COMMENT '有效期起始',
  `end_time` date NOT NULL COMMENT '有效期截至',
  `card_person` varchar(64) NOT NULL DEFAULT '' COMMENT '持证人',
  `idcard_num` varchar(64) NOT NULL DEFAULT '' COMMENT '身份证号',
  `age` int(11) NOT NULL DEFAULT '0' COMMENT '年龄',
  `gender` int(3) NOT NULL DEFAULT '0' COMMENT '性别',
  `e_result` varchar(64) NOT NULL DEFAULT '' COMMENT '体检结果',
  `yl1` varchar(255) DEFAULT NULL,
  `yl2` varchar(255) DEFAULT NULL,
  `yl3` varchar(255) DEFAULT NULL,
  `yl4` varchar(255) DEFAULT NULL,
  `yl5` varchar(255) DEFAULT NULL,
  `yl6` varchar(255) DEFAULT NULL,
  `yl7` varchar(255) DEFAULT NULL,
  `yl8` varchar(255) DEFAULT NULL,
  `yl9` varchar(255) DEFAULT NULL,
  `yl10` varchar(255) DEFAULT NULL,
  `yl11` varchar(255) DEFAULT NULL,
  `yl12` varchar(255) DEFAULT NULL,
  `yl13` varchar(255) DEFAULT NULL,
  `yl14` varchar(255) DEFAULT NULL,
  `yl15` varchar(255) DEFAULT NULL,
  `yl16` varchar(255) DEFAULT NULL,
  `yl17` varchar(255) DEFAULT NULL,
  `yl18` varchar(255) DEFAULT NULL,
  `yl19` varchar(255) DEFAULT NULL,
  `yl20` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examination_audit
-- ----------------------------

-- ----------------------------
-- Table structure for examination_project
-- ----------------------------
DROP TABLE IF EXISTS `examination_project`;
CREATE TABLE `examination_project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT '""' COMMENT '姓名',
  `idcard_num` varchar(64) DEFAULT '""' COMMENT '身份证',
  `subject` varchar(64) DEFAULT '""' COMMENT '体检科目',
  `e_time` datetime DEFAULT NULL COMMENT '体检时间',
  `yl1` varchar(255) DEFAULT NULL,
  `yl2` varchar(255) DEFAULT NULL,
  `yl3` varchar(255) DEFAULT NULL,
  `yl4` varchar(255) DEFAULT NULL,
  `yl5` varchar(255) DEFAULT NULL,
  `yl6` varchar(255) DEFAULT NULL,
  `yl7` varchar(255) DEFAULT NULL,
  `yl8` varchar(255) DEFAULT NULL,
  `yl9` varchar(255) DEFAULT NULL,
  `yl10` varchar(255) DEFAULT NULL,
  `yl11` varchar(255) DEFAULT NULL,
  `yl12` varchar(255) DEFAULT NULL,
  `yl13` varchar(255) DEFAULT NULL,
  `yl14` varchar(255) DEFAULT NULL,
  `y15` varchar(64) DEFAULT NULL,
  `y16` varchar(64) DEFAULT NULL,
  `y17` varchar(64) DEFAULT NULL,
  `y18` varchar(64) DEFAULT NULL,
  `y19` varchar(64) DEFAULT NULL,
  `y20` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examination_project
-- ----------------------------

-- ----------------------------
-- Table structure for examination_table
-- ----------------------------
DROP TABLE IF EXISTS `examination_table`;
CREATE TABLE `examination_table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `e_num` bigint(20) DEFAULT '0' COMMENT '编号',
  `serial_num` varchar(64) DEFAULT '""' COMMENT '流水号',
  `time` datetime DEFAULT NULL COMMENT '体检日期',
  `name` varchar(255) DEFAULT '""' COMMENT '姓名',
  `gender` bigint(20) DEFAULT '0' COMMENT '性别',
  `age` bigint(20) DEFAULT '0' COMMENT '年龄',
  `idcard_num` varchar(255) DEFAULT '""' COMMENT '身份证',
  `nation` varchar(255) DEFAULT '""' COMMENT '民族',
  `standard_of_colture` varchar(255) DEFAULT '""' COMMENT '文化程度',
  `work_age` bigint(20) DEFAULT '0' COMMENT '工龄',
  `company` varchar(255) DEFAULT '""' COMMENT '单位名称',
  `adress` varchar(255) DEFAULT '""' COMMENT '地址',
  `area` varchar(255) DEFAULT '""' COMMENT '辖区',
  `type_work` varchar(255) DEFAULT '""' COMMENT '工种',
  `nature` varchar(255) DEFAULT '""' COMMENT '性质',
  `yl` varchar(64) DEFAULT NULL,
  `yl1` varchar(64) DEFAULT NULL,
  `y2` varchar(64) DEFAULT NULL,
  `y3` varchar(64) DEFAULT NULL,
  `y4` varchar(64) DEFAULT NULL,
  `y5` varchar(64) DEFAULT NULL,
  `y6` varchar(64) DEFAULT NULL,
  `y7` varchar(64) DEFAULT NULL,
  `y8` varchar(64) DEFAULT NULL,
  `y9` varchar(64) DEFAULT NULL,
  `y10` varchar(64) DEFAULT NULL,
  `y11` varchar(64) DEFAULT NULL,
  `y12` varchar(64) DEFAULT NULL,
  `y13` varchar(64) DEFAULT NULL,
  `y14` varchar(64) DEFAULT NULL,
  `y15` varchar(64) DEFAULT NULL,
  `y16` varchar(64) DEFAULT NULL,
  `y17` varchar(64) DEFAULT NULL,
  `y18` varchar(64) DEFAULT NULL,
  `y19` varchar(64) DEFAULT NULL,
  `y20` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examination_table
-- ----------------------------

-- ----------------------------
-- Table structure for health_certificate
-- ----------------------------
DROP TABLE IF EXISTS `health_certificate`;
CREATE TABLE `health_certificate` (
  `health_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '健康证Id',
  `name` varchar(64) DEFAULT '""' COMMENT '姓名',
  `age` bigint(20) DEFAULT '0' COMMENT '年龄',
  `gender` bigint(20) DEFAULT '0' COMMENT '1为男，2为女',
  `medical` varchar(64) DEFAULT '""' COMMENT '体检结果',
  `id_card` varchar(64) DEFAULT '""' COMMENT '身份证号',
  `health_num` varchar(64) DEFAULT '""' COMMENT '健康证号',
  `health_time` varchar(64) DEFAULT NULL COMMENT '健康证有效期',
  `y1` varchar(64) DEFAULT NULL,
  `y2` varchar(64) DEFAULT NULL,
  `y3` varchar(64) DEFAULT NULL,
  `y4` varchar(64) DEFAULT NULL,
  `y5` varchar(64) DEFAULT NULL,
  `y6` varchar(64) DEFAULT NULL,
  `y7` varchar(64) DEFAULT NULL,
  `y8` varchar(64) DEFAULT NULL,
  `y9` varchar(64) DEFAULT NULL,
  `y10` varchar(64) DEFAULT NULL,
  `y11` varchar(64) DEFAULT NULL,
  `y12` varchar(64) DEFAULT NULL,
  `y13` varchar(64) DEFAULT NULL,
  `y14` varchar(64) DEFAULT NULL,
  `y15` varchar(64) DEFAULT NULL,
  `y16` varchar(64) DEFAULT NULL,
  `y17` varchar(64) DEFAULT NULL,
  `y18` varchar(64) DEFAULT NULL,
  `y19` varchar(64) DEFAULT NULL,
  `y20` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`health_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of health_certificate
-- ----------------------------

-- ----------------------------
-- Table structure for hospital
-- ----------------------------
DROP TABLE IF EXISTS `hospital`;
CREATE TABLE `hospital` (
  `hospital_id` varchar(64) NOT NULL DEFAULT '' COMMENT '体检机构ID',
  `hospital_name` varchar(64) NOT NULL DEFAULT '' COMMENT '体检机构名称',
  `hospital_num` varchar(64) NOT NULL DEFAULT '' COMMENT '体检机构编号',
  `hospital_area` varchar(64) NOT NULL DEFAULT '' COMMENT '区域',
  `hospital_address` varchar(128) NOT NULL DEFAULT '' COMMENT '体检机构地址',
  `hospital_telphone` varchar(64) NOT NULL DEFAULT '' COMMENT '联系电话',
  `yl1` varchar(255) DEFAULT NULL,
  `yl2` varchar(255) DEFAULT NULL,
  `yl3` varchar(255) DEFAULT NULL,
  `yl4` varchar(255) DEFAULT NULL,
  `yl5` varchar(255) DEFAULT NULL,
  `yl6` varchar(255) DEFAULT NULL,
  `yl7` varchar(255) DEFAULT NULL,
  `yl8` varchar(255) DEFAULT NULL,
  `yl9` varchar(255) DEFAULT NULL,
  `yl10` varchar(255) DEFAULT NULL,
  `yl11` varchar(255) DEFAULT NULL,
  `yl12` varchar(255) DEFAULT NULL,
  `yl13` varchar(255) DEFAULT NULL,
  `yl14` varchar(255) DEFAULT NULL,
  `yl15` varchar(255) DEFAULT NULL,
  `yl16` varchar(255) DEFAULT NULL,
  `yl17` varchar(255) DEFAULT NULL,
  `yl18` varchar(255) DEFAULT NULL,
  `yl19` varchar(255) DEFAULT NULL,
  `yl20` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hospital_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hospital
-- ----------------------------

-- ----------------------------
-- Table structure for person_order
-- ----------------------------
DROP TABLE IF EXISTS `person_order`;
CREATE TABLE `person_order` (
  `pid` bigint(20) NOT NULL DEFAULT '0' COMMENT '预约人员id',
  `p_name` varchar(64) DEFAULT '""' COMMENT '姓名',
  `p_gender` bigint(20) DEFAULT '0' COMMENT '性别',
  `p_num` varchar(64) DEFAULT '""' COMMENT '身份证号码',
  `p_telphone` varchar(64) DEFAULT '""' COMMENT '电话',
  `company_num` varchar(64) DEFAULT '""' COMMENT '所在单位',
  `y1` varchar(64) DEFAULT NULL,
  `y2` varchar(64) DEFAULT NULL,
  `y3` varchar(64) DEFAULT NULL,
  `y4` varchar(64) DEFAULT NULL,
  `y5` varchar(64) DEFAULT NULL,
  `y6` varchar(64) DEFAULT NULL,
  `y7` varchar(64) DEFAULT NULL,
  `y8` varchar(64) DEFAULT NULL,
  `y9` varchar(64) DEFAULT NULL,
  `y10` varchar(64) DEFAULT NULL,
  `y11` varchar(64) DEFAULT NULL,
  `y12` varchar(64) DEFAULT NULL,
  `y13` varchar(64) DEFAULT NULL,
  `y14` varchar(64) DEFAULT NULL,
  `y15` varchar(64) DEFAULT NULL,
  `y16` varchar(64) DEFAULT NULL,
  `y17` varchar(64) DEFAULT NULL,
  `y18` varchar(64) DEFAULT NULL,
  `y19` varchar(64) DEFAULT NULL,
  `y20` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person_order
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(64) NOT NULL DEFAULT '' COMMENT '账号',
  `telphone` varchar(64) NOT NULL DEFAULT '' COMMENT '手机号',
  `register_mode` varchar(64) NOT NULL DEFAULT '' COMMENT 'byphone,bywechat,byalipay',
  `third_party_id` varchar(64) NOT NULL DEFAULT '' COMMENT '第三方ID',
  `yl1` varchar(255) DEFAULT NULL,
  `yl2` varchar(255) DEFAULT NULL,
  `yl3` varchar(255) DEFAULT NULL,
  `yl4` varchar(255) DEFAULT NULL,
  `yl5` varchar(255) DEFAULT NULL,
  `yl6` varchar(255) DEFAULT NULL,
  `yl7` varchar(255) DEFAULT NULL,
  `yl8` varchar(255) DEFAULT NULL,
  `yl9` varchar(255) DEFAULT NULL,
  `yl10` varchar(255) DEFAULT NULL,
  `yl11` varchar(255) DEFAULT NULL,
  `yl12` varchar(255) DEFAULT NULL,
  `yl13` varchar(255) DEFAULT NULL,
  `yl14` varchar(255) DEFAULT NULL,
  `yl15` varchar(255) DEFAULT NULL,
  `yl16` varchar(255) DEFAULT NULL,
  `yl17` varchar(255) DEFAULT NULL,
  `yl18` varchar(255) DEFAULT NULL,
  `yl19` varchar(255) DEFAULT NULL,
  `yl20` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------

-- ----------------------------
-- Table structure for user_password
-- ----------------------------
DROP TABLE IF EXISTS `user_password`;
CREATE TABLE `user_password` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `encrpt_password` varchar(128) NOT NULL DEFAULT '' COMMENT '加密密码',
  `userid` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_password
-- ----------------------------
