package com.zw.cn.response.authBus;

import com.zw.cn.request.authConfig.InputsInfoReqDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 赵威
 * @date 2021/4/26 16:42
 * @desc 需要认证的内容项
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NeedAuthBusResponse {

    /**
     * 需要认证的输入框信息列表  tt:信息标题,tp:输入框类型,vs:验证策略
     */
    private List<InputsInfoReqDTO> inputsInfoReqDTOList;

    /**
     * 最终返回需要认证的内容项
     */
    private List<NeedAuthContentResponse> needAuthContentResponseList;

}
