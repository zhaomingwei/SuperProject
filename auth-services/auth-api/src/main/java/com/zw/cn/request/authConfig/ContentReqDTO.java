package com.zw.cn.request.authConfig;

import com.zw.cn.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 赵威
 * @date 2021/4/14 14:18
 * @desc 认证内容请求实体
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentReqDTO extends BaseEntity implements Serializable {

    /**
     * id
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
     * 认证内容备注
     */
    private String remark;

}
