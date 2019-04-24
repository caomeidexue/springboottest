CREATE TABLE `big_data_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `income_code` varchar(100) DEFAULT NULL,
  `josn_param` varchar(1500) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `is_del` int(2) NOT NULL DEFAULT '0',
  `order_status` int(2) NOT NULL DEFAULT '1',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `income_code` (`income_code`) USING BTREE,
  FULLTEXT KEY `fulltext_josn_param` (`josn_param`),
  FULLTEXT KEY `json_param` (`josn_param`)
) 
