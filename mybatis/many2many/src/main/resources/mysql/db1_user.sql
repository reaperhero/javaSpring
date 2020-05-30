
SET NAMES utf8 ;

DROP TABLE IF EXISTS `user`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` char(10) DEFAULT NULL COMMENT '性别',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

INSERT INTO `user` VALUES (41,'老王','2018-02-27 17:47:08','男','北京'),(42,'小二王','2018-03-02 15:09:37','女','北京金燕龙'),(43,'小二王','2018-03-04 11:34:34','女','北京金燕龙'),(45,'传智播客','2018-03-04 12:04:06','男','北京金燕龙'),(46,'老王','2018-03-07 17:37:26','男','北京'),(48,'小马宝莉','2018-03-08 11:44:00','女','北京修正');



CREATE TABLE `db1`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(45) NULL,
  `role_desc` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


INSERT INTO `db1`.`role` (`role_name`, `role_desc`) VALUES ('院长', '管理学院');
INSERT INTO `db1`.`role` (`role_name`, `role_desc`) VALUES ('总裁', '管理公司');
INSERT INTO `db1`.`role` (`role_name`, `role_desc`) VALUES ('校长', '管理学校');



CREATE TABLE `user_role` (
  `uid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  KEY `fk_reference-1` (`rid`),
  KEY `fk_reference-2` (`uid`),
  CONSTRAINT `fk_reference-1` FOREIGN KEY (`rid`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_reference-2` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into user_role values(41,1),(45,1),(41,2)