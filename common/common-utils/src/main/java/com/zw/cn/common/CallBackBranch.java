package com.zw.cn.common;
/**
 * 
 * @ClassName CallBackBranch 
 * @Description 
 * @author ZhaoWei
 * @date Aug 20, 2018 12:11:32 PM
 * @param <T>
 */
@FunctionalInterface
public  interface CallBackBranch<T> {
	
	 T doInBranchLogic();
	 
}
	