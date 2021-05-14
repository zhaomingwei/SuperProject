package com.zw.cn.common.util;

import com.zw.cn.common.enums.AuthConfigEnum;
import com.zw.cn.entity.dict.Dict;
import com.zw.cn.exception.ServiceException;
import com.zw.cn.request.authConfig.InputsInfoReqDTO;
import com.zw.cn.service.dict.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 赵威
 * @date 2021/4/21 14:20
 * @desc 输入控件信息校验
 */
@Component
public class InputInfoCheckUtil {

    @Autowired
    private DictService dictService;

    private static InputInfoCheckUtil inputInfoCheckUtil;

    @PostConstruct
    public void init(){
        inputInfoCheckUtil = this;
        inputInfoCheckUtil.dictService = this.dictService;
    }

    /**
     * 校验 校验策略是否存在
     * @param list
     */
    public static void checkVs(List<InputsInfoReqDTO> list) {
        List<String> tpList = new ArrayList<>();
        for (InputsInfoReqDTO reqDTO : list){
            tpList.add(reqDTO.getVs());
        }
        List<String> remDup = tpList.stream().distinct().collect(Collectors.toList());
        List<Dict> resList = inputInfoCheckUtil.dictService.queryItemListByItemValue(remDup);
        if (CollectionUtils.isEmpty(resList) || remDup.size() > resList.size()){
            throw new ServiceException(AuthConfigEnum.VERIFY_STRATEGY_NOT_EXIST);
        }
    }

    /**
     * 校验信息输入控件是否存在
     * @param list
     */
    public static void checkTp(List<InputsInfoReqDTO> list) {
        List<String> tpList = new ArrayList<>();
        for (InputsInfoReqDTO reqDTO : list) {
            tpList.add(reqDTO.getTp());
        }
        List<String> remDup = tpList.stream().distinct().collect(Collectors.toList());
        List<Dict> resList = inputInfoCheckUtil.dictService.queryItemListByItemValue(remDup);
        if (CollectionUtils.isEmpty(resList) || remDup.size() > resList.size()) {
            throw new ServiceException(AuthConfigEnum.INPUTS_INFO_NOT_EXIST);
        }

    }

    /**
     * 校验材料所填写信息是否有信息标题重复
     * @param list
     */
    public static void checkTt(List<InputsInfoReqDTO> list) {
        List<String> nameList = new ArrayList<>();
        for (InputsInfoReqDTO reqDTO : list){
            nameList.add(reqDTO.getTt());
        }
        long count = nameList.stream().distinct().count();
        if (count < list.size()){
            throw new ServiceException(AuthConfigEnum.MSG_TITLE_IS_REPETITION);
        }
    }

    /**
     * 校验数据字典里是否有该项内容
     * @param types 字典项
     */
    public static void checkType(List<String> types, AuthConfigEnum authConfigEnum){
        List<Dict> list = inputInfoCheckUtil.dictService.queryItemListByItemValue(types);
        if (CollectionUtils.isEmpty(list) || list.size() < types.size()){
            throw new ServiceException(authConfigEnum);
        }
    }

}
