package com.zw.cn.common;

import com.zw.cn.exception.BaseException;
import com.zw.cn.reflect.ReflectUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @version 2014年11月21日下午5:32:17
 */
public class BaseAssertUtils {

    public static final String Ids_Pattern = "^,([1-9][0-9]*,)([1-9][0-9]*,)*";
//	String pattern = "^,([1-9][0-9]*,)+";

    /**
     * check the ids must be match the patter:
     *
     * @param code if ids is not match the pattern then throw exception
     * @param ids  need check string
     * @
     * @see #Ids_Pattern<p>
     * for example : ,1,2,3,4,
     */
    public static void isIds(int code, String ids) {
        if (ids == null)
            ExceptionUtils.throwSimpleEx(code);
        if (!ids.matches(Ids_Pattern))
            ExceptionUtils.throwSimpleEx(code);
    }

    /**
     * check targets cannot be null, and targets number cannot be null <br>
     * if result is null, throw  code,<br>
     * code must be register in message.props
     *
     * @param code    message.props code
     * @param targets needed check value
     * @
     */
    public static void allNotNull(int code, Object... targets) {
        notEmptyNumber(code, targets);
        for (Object t : targets) {
            if (t == null)
                ExceptionUtils.throwSimpleEx(code);
        }
    }

    /**
     * check target cannot be null </p>
     * if result is null, throw  code</p>
     * code must be register in message.props</p>
     *
     * @param code   message.props code
     * @param target needed check value
     * @
     */
    public static void notNull(int code, Object target) {
        if (target == null)
            ExceptionUtils.throwSimpleEx(code);
    }

    /**
     * check target cannot be null </p>
     * if result is null, throw  code</p>
     * code must be register in message.props</p>
     *
     * @param code
     * @param target
     * @param args   variable parameter
     * @author Marvis
     * @date 2016年8月22日 上午10:59:34
     */
    public static void notNull(int code, Object target, Object... args) {
        if (target == null)
            ExceptionUtils.throwSimpleEx(code, args);
    }

    /**
     * check list cannot be null, and list number cannot be null <br>
     * if result is  null, throw  code,<br>
     * code must be register in message.props
     *
     * @param code    message.props code
     * @param targets needed check value
     * @
     */
    public static void notNull(int code, List<?> targets) {

        notEmptyNumber(code, targets);
        for (Object t : targets) {
            if (t == null)
                ExceptionUtils.throwSimpleEx(code);
        }
    }

    public static void notNull(int code, List<?> targets, Object... args) {

        notEmptyNumber(code, targets);
        for (Object t : targets) {
            if (t == null)
                ExceptionUtils.throwSimpleEx(code, args);
        }
    }

    /**
     * check targets cannot be null, and field value of targets number cannot be null <br>
     * if result is  null, throw  code,<br>
     *
     * @param code
     * @param fieldName needed check field name
     * @param targets
     */
    public static void notNullField(int code, String fieldName, Object... targets) {
        if (fieldName == null)
            notNull(code, targets);
        notEmptyNumber(code, targets);
        for (Object t : targets) {
            if (ReflectUtils.getValue(t, fieldName, true) == null)
                ExceptionUtils.throwSimpleEx(code);
        }
    }

    /**
     * check list cannot be null, and field value of list number cannot be null <br>
     * if result is  null, throw  code,<br>
     *
     * @param code
     * @param fieldName needed check field name
     * @param list
     */
    public static void notNullField(int code, String fieldName, List<?> list) {
        if (fieldName == null)
            notNull(code, list);
        notEmptyNumber(code, list);
        for (Object t : list) {
            if (ReflectUtils.getValue(t, fieldName, true) == null)
                ExceptionUtils.throwSimpleEx(code);
        }
    }

    /**
     * check targets is null, and targets number is null <br>
     * if result is not null, throw  code,<br>
     * code must be register in message.props
     *
     * @param code   message.props code
     * @param target needed check value
     * @
     */
    public static void isNull(int code, Object target) {
        if (target != null)
            ExceptionUtils.throwSimpleEx(code);
    }

    public static void isNull(int code, Object target, Object... args) {
        if (target != null)
            ExceptionUtils.throwSimpleEx(code, args);
    }

    public static void allIsNull(int code, Object... targets) {
        for (Object t : targets) {
            if (t != null)
                ExceptionUtils.throwSimpleEx(code);
        }
    }

    /**
     * check list is null, and list number is null <br>
     * if result is not null, throw  code,<br>
     * code must be register in message.props
     *
     * @param code message.props code
     * @param list needed check value
     * @
     */
    public static void isNull(int code, List<?> list) {

        if (list == null)
            return;
        for (Object t : list) {
            if (t != null)
                ExceptionUtils.throwSimpleEx(code);
        }
    }

    public static void isNull(int code, List<?> list, Object... args) {

        if (list == null)
            return;
        for (Object t : list) {
            if (t != null)
                ExceptionUtils.throwSimpleEx(code, args);
        }
    }

    /**
     * check targets is null, or field value of targets number is null <br>
     * if one of them (value of fieldName) is not null, throw  code,<br>
     *
     * @param code
     * @param fieldName needed check field name
     * @param targets
     */
    public static void isNullFleid(int code, String fieldName, Object... targets) {

        for (Object t : targets) {
            if (ReflectUtils.getValue(t, fieldName, true) != null)
                ExceptionUtils.throwSimpleEx(code);
        }
    }

    /**
     * check list is null, or field value of targets number  is null <br>
     * if one of them (value of fieldName) is not null, throw  code,<br>
     *
     * @param code
     * @param fieldName needed check field name
     * @param list
     */
    public static void isNullFleid(int code, String fieldName, List<?> list) {

        if (list == null)
            return;
        for (Object t : list) {
            if (ReflectUtils.getValue(t, fieldName, true) != null)
                ExceptionUtils.throwSimpleEx(code);
        }
    }

    /**
     * target must be true ,if not throw {@link BaseException}
     *
     * @param code    use this code to throw {@link BaseException}
     * @param targets
     */
    public static void isTrue(int code, Boolean... targets) {
        notEmptyNumber(code, (Object[]) targets);
        for (Boolean target : targets) {
            if (!target)
                ExceptionUtils.throwSimpleEx(code);

        }
    }

    /**
     * target must be false ,if not throw {@link BaseException}
     *
     * @param code
     * @param targets
     * @
     */
    public static void isFalse(int code, Boolean... targets) {
        notEmptyNumber(code, (Object[]) targets);
        for (Boolean target : targets) {
            if (target)
                ExceptionUtils.throwSimpleEx(code);
        }
    }

    /**
     * check if source is equals target.<p>
     * if source == null && target == null,will not throws Exception
     *
     * @param code
     * @param source
     * @param target
     */
    public static void eq(int code, Object source, Object target) {

        boolean eq = false;

        eq = source == null ? target == null ? true : false : target == null ? false : source.equals(target);

        if (!eq)
            ExceptionUtils.throwSimpleEx(code);
    }

    /**
     * check if source is equals target.<p>
     * if source == null && target == null,will not throws Exception
     *
     * @param code
     * @param source
     * @param target
     */
    public static void eq(int code, Object source, Object target, Object... args) {

        boolean eq = false;

        eq = source == null ? target == null ? true : false : target == null ? false : source.equals(target);

        if (!eq)
            ExceptionUtils.throwSimpleEx(code, args);
    }

    /**
     * check if source isn't equals target.<p>
     * if source == null(not null) && target != null(not null),will not throws Exception
     *
     * @param code
     * @param source
     * @param target
     */
    public static void notEq(int code, Object source, Object target) {

        boolean eq = false;

        eq = source == null ? target == null ? true : false : target == null ? false : source.equals(target);

        if (eq)
            ExceptionUtils.throwSimpleEx(code);
    }

    public static void notEq(int code, Object source, Object target, Object... args) {

        boolean eq = false;

        eq = source == null ? target == null ? true : false : target == null ? false : source.equals(target);

        if (eq)
            ExceptionUtils.throwSimpleEx(code, args);
    }

    /**
     * check if source is equals target,if all of targets not't equals source throws {@link BaseException}<p>
     * <b>must notice: </b>that if source and target is null in the same,this method will not throws exception
     *
     * @param code
     * @param source
     * @param targets
     * @
     */
    public static void contains(int code, Object source, Object... targets) {

        if (source == null && targets == null)
            return;
        if (source == null && targets != null) {
            for (Object t : targets) {

                if (t == null)
                    return;
            }
            ExceptionUtils.throwSimpleEx(code);
        }


        if (targets == null)
            ExceptionUtils.throwSimpleEx(code);
        for (Object t : targets) {
            if (source.equals(t))
                return;
        }
        ExceptionUtils.throwSimpleEx(code);
    }

    /**
     * check if source isn't equals targets,if one for targets is euqals throws {@link BaseException}<p>
     * <b>must notice:</b> that if source and target is null in the same,this method will throws exception
     *
     * @param code
     * @param source
     * @param targets
     * @
     */
    public static void notContains(int code, Object source, Object... targets) {
        if (source == null && targets == null)
            ExceptionUtils.throwSimpleEx(code);
        if (source == null && targets != null) {

            for (Object t : targets) {
                AssertUtils.isNull(code, t);
            }
        }
        if (targets == null)
            return;
        for (Object t : targets) {
            if (source.equals(t))
                ExceptionUtils.throwSimpleEx(code);
        }


    }

    public static void notContains(int code, Object source, String fieldName, List<?> list) {

        if (source == null && list == null)
            ExceptionUtils.throwSimpleEx(code);
        if (fieldName == null)
            notNull(code, list);
        if (list == null)
            return;
        List<Object> values = new ArrayList<>(list.size());
        for (Object t : list) {
            values.add(ReflectUtils.getValue(t, fieldName, true));
        }
        AssertUtils.notContains(code, source, values.toArray());
    }

    /**
     * if target is blank throws exception
     *
     * @param code
     * @param target
     * @
     */
    public static void notBlank(int code, String target) {
        if (target == null || target.trim().isEmpty())
            ExceptionUtils.throwSimpleEx(code);
    }

    /**
     * if target is blank throws exception
     *
     * @param code
     * @param target
     * @
     */
    public static void notBlank(int code, String target, Object... args) {
        if (target == null || target.trim().isEmpty())
            ExceptionUtils.throwSimpleEx(code, args);
    }

    public static void isBlank(int code, String target) {
        if (target != null && !target.trim().isEmpty())
            ExceptionUtils.throwSimpleEx(code);
    }

    /**
     * <p> check that the target must be blank, if not this will throws exception</p>
     * <P> if target is null or empty this method will not throws exception</p>
     *
     * @param code
     * @param target
     * @
     */
    public static void isBlank(int code, String target, Object... args) {
        if (target != null && !target.trim().isEmpty())
            ExceptionUtils.throwSimpleEx(code, args);
    }

    private static boolean checkEmptyNumber(int code, boolean checkEmpty, Object... arr) {
        if (arr == null || (checkEmpty && arr.length == 0))
            return true;
        return false;
    }

    private static boolean checkEmptyNumber(int code, boolean checkEmpty, List<?> list) {
        if (list == null || (checkEmpty && list.size() == 0))
            return true;
        return false;
    }

    /**
     * if arr is null or length of arr is 0, throw exception;
     *
     * @param code
     * @param arr
     */
    public static void notEmptyNumber(int code, Object... arr) {
        notEmptyNumber(code, true, arr);
    }

    private static void notEmptyNumber(int code, boolean checkEmpty, Object... arr) {
        if (checkEmptyNumber(code, checkEmpty, arr))
            ExceptionUtils.throwSimpleEx(code);
    }


    /**
     * if list is null or size of list is 0, throw exception;
     *
     * @param code
     * @param list
     */
    public static void notEmptyNumber(int code, List<?> list) {
        notEmptyNumber(code, true, list);
    }

    private static void notEmptyNumber(int code, boolean checkEmpty, List<?> list) {
        if (checkEmptyNumber(code, checkEmpty, list))
            ExceptionUtils.throwSimpleEx(code);
    }

    /**
     * if list is not  null and  size of list is not 0, throw exception;
     *
     * @param code
     * @param list
     */
    public static void isEmptyNumber(int code, List<?> list) {
        isEmptyNumber(code, true, list);
    }

    public static void isEmptyNumber(int code, boolean checkEmpty, List<?> list) {
        if (!checkEmptyNumber(code, checkEmpty, list))
            ExceptionUtils.throwSimpleEx(code);
    }

}
