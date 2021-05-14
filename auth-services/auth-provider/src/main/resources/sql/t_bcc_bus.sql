INSERT INTO `t_bcc_bus`(`id`, `bus_code`, `name`, `type`, `material_ids`, `inputs_info_str`, `remark`, `can_use_item_values`, `valid`) VALUES (1, 'JM000001', '个人货主快速认证', 'D004001', '', '[{\"tt\":\"姓名\",\"tp\":\"D002001\",\"vs\":\"D003002\"},{\"tt\":\"身份证号\",\"tp\":\"D002001\",\"vs\":\"D004001\"},{\"tt\":\"手机号\",\"tp\":\"D002001\",\"vs\":\"D003005\"},{\"tt\":\"所属地址（三级地址）\",\"tp\":\"D002001\",\"vs\":\"D003006\"},{\"tt\":\"详细地址\",\"tp\":\"D002001\",\"vs\":\"D003007\"}]', '个人货主快速认证', 'D005001', 1);
INSERT INTO `t_bcc_bus`(`id`, `bus_code`, `name`, `type`, `material_ids`, `inputs_info_str`, `remark`, `can_use_item_values`, `valid`) VALUES (2, 'JM000002', '个人货主认证', 'D004001', '1', '[{\"tt\":\"所属地址（三级地址）\",\"tp\":\"D002001\",\"vs\":\"D003006\"},{\"tt\":\"详细地址\",\"tp\":\"D002001\",\"vs\":\"D003007\"}]', '个人货主认证', 'D005001', 1);
INSERT INTO `t_bcc_bus`(`id`, `bus_code`, `name`, `type`, `material_ids`, `inputs_info_str`, `remark`, `can_use_item_values`, `valid`) VALUES (3, 'JM000003', '企业货主认证', 'D004002', '2,3,4', '[{\"tt\":\"所属地址（三级地址）\",\"tp\":\"D002001\",\"vs\":\"D003006\"},{\"tt\":\"详细地址\",\"tp\":\"D002001\",\"vs\":\"D003007\"},{\"tt\":\"公司类型（总公司/分公司）\",\"tp\":\"D002001\",\"vs\":\"D003001\"}]', '企业货主认证', 'D005001', 1);
INSERT INTO `t_bcc_bus`(`id`, `bus_code`, `name`, `type`, `material_ids`, `inputs_info_str`, `remark`, `can_use_item_values`, `valid`) VALUES (4, 'JM000004', '司机认证', 'D004001', '1,5', '', '运费代收人也是进行司机认证', 'D005002', 1);
INSERT INTO `t_bcc_bus`(`id`, `bus_code`, `name`, `type`, `material_ids`, `inputs_info_str`, `remark`, `can_use_item_values`, `valid`) VALUES (5, 'JM000005', '个人承运商认证', 'D004001', '1', '[{\"tt\":\"所属地址（三级地址）\",\"tp\":\"D002001\",\"vs\":\"D003006\"},{\"tt\":\"详细地址\",\"tp\":\"D002001\",\"vs\":\"D003007\"}]', '个人承运商认证', 'D005003', 1);
INSERT INTO `t_bcc_bus`(`id`, `bus_code`, `name`, `type`, `material_ids`, `inputs_info_str`, `remark`, `can_use_item_values`, `valid`) VALUES (6, 'JM000006', '企业承运商认证', 'D004002', '2,3,4', '[{\"tt\":\"所属地址（三级地址）\",\"tp\":\"D002001\",\"vs\":\"D003006\"},{\"tt\":\"详细地址\",\"tp\":\"D002001\",\"vs\":\"D003007\"}]', '企业承运商认证', 'D005003', 1);
