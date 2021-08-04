package com.zw.cn.common;

import com.zw.cn.base.ResultEnum;
import com.zw.cn.exception.BaseException;
import com.zw.cn.exception.BaseExceptionCode;
import com.zw.cn.exception.ServiceException;
import com.zw.cn.exception.ServiceExtException;

/**
 * 
 * @author 
 */
public class ExceptionUtils {


	public static void throwSimpleEx() {
		throw new ServiceException(ResultEnum.SYS_ERROR.getMsg(),ResultEnum.SYS_ERROR.getCode());
	}
	public static void throwError() {
		throw new ServiceException(ResultEnum.SYS_ERROR.getMsg(),ResultEnum.SYS_ERROR.getCode());
	}

	public static void throwSimpleEx(BaseExceptionCode baseCode){
		if(baseCode == null)
			throwSimpleEx();
		throw new ServiceExtException(baseCode);
	}
	public static void throwSimpleEx(BaseExceptionCode baseCode,Object... args){
		if(baseCode == null)
			throwSimpleEx();
		throw new ServiceExtException(baseCode,args);
	}

	public static void throwError(BaseExceptionCode baseCode){
		if(baseCode == null)
			throwError();
		throw new ServiceExtException(baseCode);
	}


	/*public static void throwSimpleEx(int code){
		throw new BaseException(code);
	}
	public static void throwSimpleEx(JsonResult jsonResult){
		throw new BaseException(jsonResult);
	}
	public static void throwSimpleEx(int code,Object... args){
		throw new BaseException(code,args);
	}
	public static void throwSimpleEx(int code,String msg){
		throw new BaseException(code,msg);
	}
	
	public static void throwError(int code){
		throw new BaseException(code);
	}
	
	public static void throwError(JsonResult jsonResult){
		throw new BaseException(jsonResult);
	}
	public static void throwError(int code,Object... args){
		throw new BaseException(code,args);
	}
	public static void throwError(int code,String msg){
		throw new BaseException(code,msg);
	}
	*//**
	 * 默认900:内部错误
	 * @version 2015年8月6日下午2:17:50
	 * @throws BaseException
	 *//*
	public static void throwError() throws BaseException{
		throw new BaseException(900);
	}*/
	
}
