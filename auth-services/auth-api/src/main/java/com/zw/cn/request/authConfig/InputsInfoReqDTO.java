package com.zw.cn.request.authConfig;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 赵威
 * @date 2021/4/16 9:15
 * @desc 信息输入控件实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InputsInfoReqDTO implements Serializable {

    /**
     * 信息标题
     */
    private String tt;

    /**
     * 信息输入控件类型
     */
    private String tp;

    /**
     * 校验策略
     */
    private String vs;

}
