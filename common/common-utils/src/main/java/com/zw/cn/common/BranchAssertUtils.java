package com.zw.cn.common;

/**
 * 
 * @ClassName BranchAssertUtis 
 * @Description 
 * @author ZhaoWei
 * @date Aug 20, 2018 12:11:24 PM
 */
public abstract class  BranchAssertUtils extends BaseAssertUtils {

	/**
	 * targets 只要有一个为null，则执行callBack函数 </p>
	 * targets为空或空成员，执行backBack函数
	 * @param callBack
	 * @param targets
	 * @return
	 */
	public static Object ifNull(CallBackBranch<?> callBack, Object... targets) {

		if (checkEmptyNumber(true, targets)) {
			return callBack.doInBranchLogic();
		}

		for (Object t : targets) {
			if (t == null) {
				return callBack.doInBranchLogic();
			}
		}
		return null;
	}
	/**
	 * target 为null，则执行callBack函数 </p>
	 * @param callBack
	 * @param target
	 * @return
	 */
	public static Object ifNull(CallBackBranch<?> callBack, Object target) {

			if (target == null) {
				return callBack.doInBranchLogic();
			}
		return null;
	}
	/**
	 * targets 全部为为null，才执行callBack函数 </p>
	 * targets为空或空成员，执行backBack函数
	 * @param callBack
	 * @param targets
	 * @return
	 */
	public static Object ifAllNull(CallBackBranch<?> callBack, Object... targets) {

		if (checkEmptyNumber(true, targets)) {
			return callBack.doInBranchLogic();
		}

		for (Object t : targets) {
			if (t != null) {
				return null;
			}
		}
		return callBack.doInBranchLogic();
	}

	/**
	 * target为True，执行callback
	 * @param callBack
	 * @param target
	 * @return
	 */
	public  static Object ifTrue(CallBackBranch<?> callBack, boolean target) {
		if (target)
			return callBack.doInBranchLogic();
		return null;
	}
	/**
	 * target为Flase，执行callback
	 * @param callBack
	 * @param target
	 * @return
	 */
	public  static Object ifFalse(CallBackBranch<?> callBack, boolean target) {
		if (!target)
			return callBack.doInBranchLogic();
		return null;
	}

}
