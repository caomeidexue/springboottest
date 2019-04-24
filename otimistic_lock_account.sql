CREATE TABLE `otimistic_lock_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `uniqueId` varchar(100) NOT NULL COMMENT '唯一标识',
  `amount` int(11) NOT NULL,
  `version_amount` int(11) NOT NULL COMMENT '版本号(金额作为版本号)',
  `last_modify_time` datetime NOT NULL COMMENT '最后修改时间',
  `remark` varchar(255) NOT NULL COMMENT '备注字段',
  PRIMARY KEY (`id`)
)
