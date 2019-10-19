use studentteacher_evaluation_system;
# Host: localhost  (Version 5.6.41)
# Date: 2019-09-18 12:09:01
# Generator: MySQL-Front 6.1  (Build 1.15)


#
# Structure for table "administrator"
#

DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "administrator"
#


#
# Structure for table "course"
#

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "course"
#

INSERT INTO `course` VALUES (1,'数据结构'),(2,'操作系统');

#
# Structure for table "grade"
#

DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Data for table "grade"
#

INSERT INTO `grade` VALUES (1,'1690008');

#
# Structure for table "record_s"
#

DROP TABLE IF EXISTS `record_s`;
CREATE TABLE `record_s` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `result_s_id` int(11) DEFAULT NULL,
  `subject` varchar(100) DEFAULT NULL,
  `answer` varchar(100) DEFAULT NULL,
  `score` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "record_s"
#


#
# Structure for table "record_t"
#

DROP TABLE IF EXISTS `record_t`;
CREATE TABLE `record_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `result_t_id` int(11) DEFAULT NULL,
  `subject` varchar(100) DEFAULT NULL,
  `answer` varchar(100) DEFAULT NULL,
  `score` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "record_t"
#


#
# Structure for table "relationship_tcg"
#

DROP TABLE IF EXISTS `relationship_tcg`;
CREATE TABLE `relationship_tcg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

#
# Data for table "relationship_tcg"
#

INSERT INTO `relationship_tcg` VALUES (1,1,1,1),(2,2,2,1);

#
# Structure for table "result_s"
#

DROP TABLE IF EXISTS `result_s`;
CREATE TABLE `result_s` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  `total` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "result_s"
#


#
# Structure for table "result_t"
#

DROP TABLE IF EXISTS `result_t`;
CREATE TABLE `result_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `t_id1` int(11) DEFAULT NULL,
  `t_id2` int(11) DEFAULT NULL,
  `total` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "result_t"
#


#
# Structure for table "student"
#

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "student"
#

INSERT INTO `student` VALUES (1,'169000818','qianxin','男','123456',1);

#
# Structure for table "teacher"
#

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(11) DEFAULT NULL,
  `namteachere` varchar(50) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "teacher"
#

INSERT INTO `teacher` VALUES (1,'001','张三','男','12345678911','123456'),(2,'002','李四',NULL,NULL,NULL);

#
# set utf8 to support Chinese
#

alter table teacher_evaluation_system.record_s default character set UTF8MB4; 
alter table teacher_evaluation_system.record_s change subject subject varchar(255) character set UTF8MB4; 
alter table teacher_evaluation_system.record_s change answer answer varchar(255) character set UTF8MB4; 

alter table teacher_evaluation_system.record_t default character set UTF8MB4; 
alter table teacher_evaluation_system.record_t change subject subject varchar(255) character set UTF8MB4; 
alter table teacher_evaluation_system.record_t change answer answer varchar(255) character set UTF8MB4; 
