package com.zw.cn.user.PO;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2020/5/15
 * Time: 16:31
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
@Data
public class User {

    private String id;

    private String userName;

    private String passwd;

    private Integer age;

    private Date createdTime;

}
