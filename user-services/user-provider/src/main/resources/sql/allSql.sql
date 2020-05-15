CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(45) DEFAULT NULL COMMENT '用户名',
  `passwd` varchar(32) DEFAULT NULL COMMENT '用户密码',
  `age` int(3) NOT NULL DEFAULT '0' COMMENT '用户年龄',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户表';