package com.zw.cn.common;

import com.zw.cn.exception.BaseExceptionCode;
import com.zw.cn.exception.ExceptionUtils;
import com.zw.cn.exception.ServiceException;
import com.zw.cn.reflect.ReflectUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @version 2014年11月21日下午5:32:17
 */
public abstract class BaseAssertUtils {

	public static final String Ids_Pattern = "^,([1-9][0-9]*,)([1-9][0-9]*,)*";
//	String pattern = "^,([1-9][0-9]*,)+";
	/**
	 * check the ids must be match the patter:
	 * @see #Ids_Pattern
	 * for example : ,1,2,3,4,
	 * @param code if ids is not match the pattern then throw exception
	 * @param ids need check string
	 * @ 
	 */
	public static void isIds(BaseExceptionCode code, String ids) {
		if(ids==null)
			ExceptionUtils.throwSimpleEx(code);
		if(!ids.matches(Ids_Pattern))
			ExceptionUtils.throwSimpleEx(code);
	}
	public static void isIds( String ids) {
		isIds(null,ids);
	}

	/**
	 * check targets cannot be null, and targets number cannot be null <br>
	 * if result is null, throw  code,<br>
	 * code must be register in message.props
	 * @param code message.props code
	 * @param targets needed check value
	 * @ 
	 */
	public static void allNotNull(BaseExceptionCode code,Object... targets) {
		notEmptyNumber(code,targets);
		for (Object t : targets) {
			if(t==null)
				ExceptionUtils.throwSimpleEx(code);
		}
	}
	public static void allNotNull(Object... targets) {
		allNotNull(null,targets);
	}
	/**
	 * check target cannot be null </p>
	 * if result is null, throw  code</p>
	 * code must be register in message.props</p>
	 * @param code message.props code
	 * @param target needed check value
	 * @ 
	 */
	public static void notNull(BaseExceptionCode code,Object target) {
			if(target == null)
				ExceptionUtils.throwSimpleEx(code);
	}
	public static void notNull(Object target) {
			notNull(null,target);
	}
	/**
	 * check target cannot be null </p>
	 * if result is null, throw  code</p>
	 * code must be register in message.props</p>
	 * @author ZhaoWei
	 * @date 2016年8月22日 上午10:59:34
	 * @param code
	 * @param target
	 * @param args variable parameter
	 */
	public static void notNull(BaseExceptionCode code,Object target, Object... args) {
		if(target == null)
			ExceptionUtils.throwSimpleEx(code,args);
	}

	/**
	 * check list cannot be null, and list number cannot be null <br>
	 * if result is  null, throw  code,<br>
	 * code must be register in message.props
	 * @param code message.props code
	 * @param targets needed check value
	 * @ 
	 */
	public static void notNull(BaseExceptionCode code,List<?> targets) {
		
		notEmptyNumber(code,targets);
		for (Object t : targets) {
			if(t==null)
				ExceptionUtils.throwSimpleEx(code);
		}
	}
	public static void notNull(List<?> targets) {
		notNull(null,targets);
	}
	public static void notNull(BaseExceptionCode code,List<?> targets ,Object... args) {
		
		notEmptyNumber(code,targets);
		for (Object t : targets) {
			if(t==null)
				ExceptionUtils.throwSimpleEx(code,args);
		}
	}

	/**
	 * check targets cannot be null, and field value of targets number cannot be null <br>
	 * if result is  null, throw  code,<br>
	 * @param code
	 * @param fieldName needed check field name
	 * @param targets
	 */
	public static void notNullField(BaseExceptionCode code, String fieldName ,Object... targets){
		if(fieldName == null)
			notNull(code,targets);
		notEmptyNumber(code,targets);
		for (Object t : targets) {
			if(ReflectUtils.getValue(t, fieldName, true)==null)
				ExceptionUtils.throwSimpleEx(code);
		}
	}
	public static void notNullField(String fieldName ,Object... targets){
		notNullField(null,fieldName,targets);
	}
	/**
	 * check list cannot be null, and field value of list number cannot be null <br>
	 * if result is  null, throw  code,<br>
	 * @param code
	 * @param fieldName needed check field name
	 * @param list
	 */
	public static void notNullField(BaseExceptionCode code, String fieldName ,List<?> list){
		if(fieldName == null)
			notNull(code,list);
		notEmptyNumber(code,list);
		for (Object t : list) {
			if(ReflectUtils.getValue(t, fieldName, true)==null)
				ExceptionUtils.throwSimpleEx(code);
		}
	}
	public static void notNullField( String fieldName ,List<?> list){
		notNullField(null,fieldName,list);
	}
	/**
	 * check targets is null, and targets number is null <br>
	 * if result is not null, throw  code,<br>
	 * code must be register in message.props
	 * @param code message.props code
	 * @param target needed check value
	 * @ 
	 */
	public static void isNull(BaseExceptionCode code,Object target) {
		if(target != null)
			ExceptionUtils.throwSimpleEx(code);
	}
	public static void isNull(Object target) {
		isNull(null,target);
	}
	public static void isNull(BaseExceptionCode code,Object target, Object... args) {
			if(target != null)
				ExceptionUtils.throwSimpleEx(code,args);
	}
	public static void allIsNull(BaseExceptionCode code,Object... targets) {
		for (Object t : targets) {
			if(t != null)
				ExceptionUtils.throwSimpleEx(code);
		}	
	}
	public static void allIsNull(Object... targets) {
		allIsNull(null,targets);
	}
	/**
	 * check list is null, and list number is null <br>
	 * if result is not null, throw  code,<br>
	 * code must be register in message.props
	 * @param code message.props code
	 * @param list needed check value
	 * @ 
	 */
	public static void isNull(BaseExceptionCode code,List<?> list) {
		
		if(list == null)
			return;
		for (Object t : list) {
			if(t != null)
				ExceptionUtils.throwSimpleEx(code);
		}	
	}
	public static void isNull(List<?> list) {

		isNull(null,list);
	}
	public static void isNull(BaseExceptionCode code,List<?> list, Object... args) {
		
		if(list == null)
			return;
		for (Object t : list) {
			if(t != null)
				ExceptionUtils.throwSimpleEx(code,args);
		}	
	}
	/**
	 * check targets is null, or field value of targets number is null <br>
	 * if one of them (value of fieldName) is not null, throw  code,<br>
	 * @param code
	 * @param fieldName needed check field name
	 * @param targets
	 */
	public static void isNullFleid(BaseExceptionCode code, String fieldName ,Object... targets){
		
		for (Object t : targets) {
			if(ReflectUtils.getValue(t, fieldName, true) != null)
				ExceptionUtils.throwSimpleEx(code);
		}	
	}
	public static void isNullFleid(String fieldName ,Object... targets){

		isNullFleid(null,fieldName,targets);
	}
	/**
	 * check list is null, or field value of targets number  is null <br>
	 * if one of them (value of fieldName) is not null, throw  code,<br>
	 * @param code
	 * @param fieldName needed check field name
	 * @param list
	 */
	public static void isNullFleid(BaseExceptionCode code, String fieldName ,List<?> list){
		
		if(list == null)
			return;
		for (Object t : list) {
			if(ReflectUtils.getValue(t, fieldName, true) != null)
				ExceptionUtils.throwSimpleEx(code);
		}	
	}

	public static void isNullFleid( String fieldName ,List<?> list){

		isNullFleid(null,fieldName,list);
	}

	/**
	 * target must be true ,if not throw {@link ServiceException}
	 * @param code use this code to throw {@link ServiceException}
	 * @param targets
	 */
	public static void isTrue(BaseExceptionCode code,Boolean... targets) {
		notEmptyNumber(code,(Object[])targets);
		for (Boolean target : targets) {
			if(!target)
				ExceptionUtils.throwSimpleEx(code);
			
		}
	}
	public static void isTrue(Boolean... targets) {
		isTrue(null,targets);
	}
	/**
	 * target must be false ,if not throw {@link ServiceException}
	 * @param code
	 * @param targets
	 * @ 
	 */
	public static void isFalse(BaseExceptionCode code,Boolean... targets) {
		notEmptyNumber(code,(Object[])targets);
		for (Boolean target : targets) {
			if(target)
				ExceptionUtils.throwSimpleEx(code);
		}
	}
	public static void isFalse(Boolean... targets) {
		isFalse(null,targets);
	}

	/**
	 * check if source is equals target.<p>
	 * if source == null && target == null,will not throws Exception
	 * @param code
	 * @param source
	 * @param target
	 */
	public static void eq(BaseExceptionCode code,Object source,Object target)  {
		
		boolean eq = false;
		
		eq = source == null ? target == null ? true : false : target == null ? false : source.equals(target) ;
		
		if(!eq)
			ExceptionUtils.throwSimpleEx(code);
	}
	public static void eq(Object source,Object target) {

		eq(null, source, target);
	}
	/**
	 * check if source is equals target.<p>
	 * if source == null && target == null,will not throws Exception
	 * @param code
	 * @param source
	 * @param target
	 */
	public static void eq(BaseExceptionCode code,Object source,Object target, Object... args)  {
		
		boolean eq = false;
		
		eq = source == null ? target == null ? true : false : target == null ? false : source.equals(target) ;
		
		if(!eq)
			ExceptionUtils.throwSimpleEx(code,args);
	}
	/**
	 * check if source isn't equals target.<p>
	 * if source == null(not null) && target != null(not null),will not throws Exception
	 * @param code
	 * @param source
	 * @param target
	 */
	public static void notEq(BaseExceptionCode code,Object source,Object target)  {
		
		boolean eq = false;
		
		eq = source == null ? target == null ? true : false : target == null ? false : source.equals(target) ;
		
		if(eq)
			ExceptionUtils.throwSimpleEx(code);
	}

	public static void notEq(Object source,Object target)  {

		notEq(source,target);
	}

	public static void notEq(BaseExceptionCode code,Object source,Object target, Object... args)  {
		
		boolean eq = false;
		
		eq = source == null ? target == null ? true : false : target == null ? false : source.equals(target) ;
		
		if(eq)
			ExceptionUtils.throwSimpleEx(code,args);
	}

	/**
	 * check if source is equals target,if all of targets not't equals source throws {@link ServiceException}<p>
	 * <b>must notice: </b>that if source and target is null in the same,this method will not throws exception
	 * @param code
	 * @param source
	 * @param targets
	 * @ 
	 */
	public static void contains(BaseExceptionCode code,Object source,Object... targets)  {
		
		if(source == null && targets == null)
			return;
		if(source == null && targets != null) {
			for (Object t : targets) {
				
				if(t == null)
					return;
			}
			ExceptionUtils.throwSimpleEx(code);
		}
		
		
		if(targets ==null)
			ExceptionUtils.throwSimpleEx(code);
		for (Object t : targets) {
			if(source.equals(t)) 
				return;
		}
		ExceptionUtils.throwSimpleEx(code);
	}
	public static void contains(Object source,Object... targets)  {

		contains(source,targets);
	}

	/**
	 * check if source isn't equals targets,if one for targets is euqals throws {@link ServiceException}<p>
	 * <b>must notice:</b> that if source and target is null in the same,this method will throws exception
	 * 
	 * @param code
	 * @param source
	 * @param targets
	 * @ 
	 */
	public static void notContains(BaseExceptionCode code,Object source,Object... targets)  {
		if(source == null && targets == null)
			ExceptionUtils.throwSimpleEx(code);
		if(source == null && targets != null) {
			
			for (Object t : targets) {
				AssertUtils.isNull(code, t);
			}
		}
		if(targets == null)
			return;
		for (Object t : targets) {
			if(source.equals(t)) 
				ExceptionUtils.throwSimpleEx(code);
		}
	}

	public static void notContains(BaseExceptionCode code, Object source,String fieldName ,List<?> list){
		
		if(source == null && list == null)
			ExceptionUtils.throwSimpleEx(code);
		if(fieldName == null)
			notNull(code,list);
		if(list == null)
			return;
		List<Object> values = new ArrayList<>(list.size());
		for (Object t : list) {
			values.add(ReflectUtils.getValue(t, fieldName, true));
		}
		AssertUtils.notContains(code, source,values.toArray());
	}
	public static void notContains( Object source,String fieldName ,List<?> list){

		notContains(source,fieldName,list);
	}

	/**
	 * if target is blank throws exception
	 * @param code
	 * @param target
	 * @ 
	 */
	public static void notBlank(BaseExceptionCode code, String target) {
		if(target==null||target.trim().isEmpty())
			ExceptionUtils.throwSimpleEx(code);
	}

	public static void notBlank(String target) {
		notBlank(target);
	}

	/**
	 * if target is blank throws exception
	 * @param code
	 * @param target
	 * @ 
	 */
	public static void notBlank(BaseExceptionCode code, String target, Object... args) {
		if(target==null||target.trim().isEmpty())
			ExceptionUtils.throwSimpleEx(code,args);
	}

	public static void isBlank(BaseExceptionCode code,String target) {
		if(target!=null&&!target.trim().isEmpty())
			ExceptionUtils.throwSimpleEx(code);
	}
	public static void isBlank( String target) {

		isBlank(null,target);
	}
	/**
	 *<p> check that the target must be blank, if not this will throws exception</p>
	 *<P> if target is null or empty this method will not throws exception</p>
	 * @param code
	 * @param target
	 * @ 
	 */
	public static void isBlank(BaseExceptionCode code, String target, Object... args) {
		if(target!=null&&!target.trim().isEmpty())
			ExceptionUtils.throwSimpleEx(code, args);
	}

	protected static boolean checkEmptyNumber(boolean checkEmpty,Object... arr){
		if(arr == null || (checkEmpty && arr.length == 0))
			return true;
		return false;
	}
	protected static boolean checkEmptyNumber(boolean checkEmpty,List<?> list){
		if(list == null || (checkEmpty && list.size() == 0))
			return true;
		return false;
	}
	
	/**
	 * if arr is null or length of arr is 0, throw exception;
	 * @param code
	 * @param arr
	 */
	public static void notEmptyNumber(BaseExceptionCode code,Object... arr) {
		notEmptyNumber(code,true,arr);
	}
	
	public static void notEmptyNumber( Object... arr) {
		notEmptyNumber(null,arr);
	}

	private static void notEmptyNumber(BaseExceptionCode code,boolean checkEmpty,Object... arr) {
		if(checkEmptyNumber(checkEmpty,arr))
			ExceptionUtils.throwSimpleEx(code);
	}
	
	
	/**
	 * if list is null or size of list is 0, throw exception;
	 * @param code
	 * @param list
	 */
	public static void notEmptyNumber(BaseExceptionCode code,List<?> list) {
		notEmptyNumber(code,true,list);
	}
	public static void notEmptyNumber(List<?> list) {
		notEmptyNumber(null,list);
	}
	private static void notEmptyNumber(BaseExceptionCode code,boolean checkEmpty,List<?> list) {
		if(checkEmptyNumber(checkEmpty,list))
			ExceptionUtils.throwSimpleEx(code);
	}
	/**
	 * if list is not  null and  size of list is not 0, throw exception;
	 * @param code
	 * @param list
	 */
	public static void isEmptyNumber(BaseExceptionCode code,List<?> list) {
		isEmptyNumber(code,true,list);
	}
	public static void isEmptyNumber(List<?> list) {
		isEmptyNumber(null,list);
	}
	public static void isEmptyNumber(BaseExceptionCode code,boolean checkEmpty,List<?> list) {
		if(!checkEmptyNumber(checkEmpty, list))
			ExceptionUtils.throwSimpleEx(code);
	}
	
}
