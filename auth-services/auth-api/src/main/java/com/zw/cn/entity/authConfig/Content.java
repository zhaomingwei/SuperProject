package com.zw.cn.entity.authConfig;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author 赵威
 * @date 2021/4/14 11:43
 * @desc 认证内容管理表映射实体
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Content {

    /**
     * 主键 自增id
     */
    private Long id;

    /**
     * 认证内容名称
     */
    private String name;

    /**
     * 认证内容类型
     */
    private String type;

    /**
     * 认证内容备注
     */
    private String remark;

    /**
     * 认证内容唯一识别码(全局唯一)
     * AC开头代表authentication content
     * AC000001:    个人身份证正面
     * AC000002:    个人身份证反面
     * AC000003:    营业执照照片
     * AC000004:    法人身份证正面
     * AC000005:    法人身份证反面
     * AC000006:    管理员身份证正面
     * AC000007:    管理员身份证反面
     * AC000008:    驾驶证图片
     */
    private String tagCode;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否有效：1 有效，0 无效
     */
    private Integer valid;

    /**
     * 创建人名称
     */
    private String createUserName;

    /**
     * 创建人用户代码
     */
    private String createUserCode;

    /**
     * 更新人名称
     */
    private String updateUserName;

    /**
     * 更新人用户代码
     */
    private String updateUserCode;

}