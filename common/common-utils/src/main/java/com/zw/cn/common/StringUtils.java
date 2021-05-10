package com.zw.cn.common;

public class StringUtils {
	
	/**
	 * apache split
	 * @author ZhaoWei
	 * @date 2017年6月7日 下午12:18:39
	 * @param Str  为null 返回 null
	 * @param separator
	 * @return
	 */
	public static String[] split(String Str,String separator) {
		String[] split = org.apache.commons.lang3.StringUtils.split(Str,separator);
		return split;
	}
	public static boolean isNotBlank(String Str) {
		boolean notBlank = org.apache.commons.lang3.StringUtils.isNotBlank(Str);
		return notBlank;
	}
	public static boolean isBlank(String Str) {
		boolean blank = org.apache.commons.lang3.StringUtils.isBlank(Str);
		return blank;
	}
	public static String[] isBlank(String str, String separatorChar) {
		String[] blank = org.apache.commons.lang3.StringUtils.split(str,separatorChar);
		return blank;
	}
	
	/**
     * 字符串空值转换为默认值
     *
     * @param ori Object 原始字符串
     * @param def String 默认字符串
     * @return String 转换结果
     */
    public static String nvl(Object ori, String def) {
        if (ori == null) {
            return def;
        } else {
            return ori.toString();
        }
    }
    /**
     * 字符串空值转换为默认值
     *
     * @param ori Object 原始字符串
     * @param def String 默认字符串
     * @return String 转换结果
     */
    public static String nvl(Object ori) {
    	return nvl(ori,"");
    }
	
	/**
	 * 将类似userName转换成user_name形式
	 *
	 * @param s
	 *            CameCase字符串
	 * @return 转换后的字符串
	 */
	public static String camelCaseToDb(String s) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isUpperCase(c) && i != 0) {
				builder.append("_");
			}
			builder.append(Character.toLowerCase(c));
		}
		return builder.toString();
	}
	
	/**
	 * 将电话号码设置隐私星号
	 * @author ZhaoWei
	 * @date 2017年5月26日 上午11:40:12
	 * @param mobile
	 * @return
	 */
	public static String setPrivateMobile(String mobile) {
		return mobile.substring(0, 2) + "****" + (mobile.length() <3 ? "" :mobile.substring(mobile.length() - 3));
	}
	

}
