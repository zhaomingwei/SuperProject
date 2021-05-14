package com.zw.cn.common.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 参数签名算法工具类
 */
public class RSAUtils {

    final static Pattern BLANK_PATTERN = Pattern.compile("\\s*|\t|\r|\n");

    /**
     * 获取当前的时间戳参数
     *
     * @return
     */
    public static String getRtick() {
        long timestamp = System.currentTimeMillis();
        int rnd = (int) (Math.random() * 1000);
        return timestamp + "" + rnd;
    }


    public static void main(String[] args) {
        String body = "{\"fname\":\"KP1231231231231.pdf.pdf\",\"ftype\":\"pdf\",\"expireTime\":\"1709797372\",\"fmd5\":\"da2f8fd56f9c3f98bd98df21d9fb2ea2\",\"fpages\":2,\"fdata\":\"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c2NyaXB0b3IgNyAwIFIvVyBbMVsyMDddMTRbMzc1IDIzOF0xNyAyNSA0NjIgMjdbMjM4XTM0WzY4NF0zNls2OTVdNTlbNjA3XV0vRFcgMTAwMC9DSURTeXN0ZW1JbmZvPDwvUmVnaXN0cnkoQWRvYmUpL09yZGVyaW5nKEdCMSkvU3VwcGxlbWVudCA0Pj4+PgplbmRvYmoKMSAwIG9iago8PC9UeXBlL0ZvbnQvU3VidHlwZS9UeXBlMC9CYXNlRm9udC9TVFNvbmctTGlnaHQtVW5pR0ItVUNTMi1IL0VuY29kaW5nL1VuaUdCLVVDUzItSC9EZXNjZW5kYW50Rm9udHNbOCAwIFJdPj4KZW5kb2JqCjMgMCBvYmoKPDwvVHlwZS9QYWdlcy9Db3VudCAyL0tpZHNbNCAwIFIgNiAwIFJdPj4KZW5kb2JqCjkgMCBvYmoKPDwvVHlwZS9DYXRhbG9nL1BhZ2VzIDMgMCBSPj4KZW5kb2JqCjEwIDAgb2JqCjw8L1Byb2R1Y2VyKGlUZXh0riA1LjUuMTAgqTIwMDAtMjAxNSBpVGV4dCBHcm91cCBOViBcKEFHUEwtdmVyc2lvblwpKS9DcmVhdGlvbkRhdGUoRDoyMDIxMDMwODE1NDI1MiswOCcwMCcpL01vZERhdGUoRDoyMDIxMDMwODE1NDI1MiswOCcwMCcpPj4KZW5kb2JqCnhyZWYKMCAxMQowMDAwMDAwMDAwIDY1NTM1IGYgCjAwMDAwMDczNTMgMDAwMDAgbiAKMDAwMDAwMDAxNSAwMDAwMCBuIAowMDAwMDA3NDc3IDAwMDAwIG4gCjAwMDAwMDM3NjIgMDAwMDAgbiAKMDAwMDAwMzg3NCAwMDAwMCBuIAowMDAwMDA2ODI3IDAwMDAwIG4gCjAwMDAwMDY5MzkgMDAwMDAgbiAKMDAwMDAwNzEzMCAwMDAwMCBuIAowMDAwMDA3NTM0IDAwMDAwIG4gCjAwMDAwMDc1NzkgMDAwMDAgbiAKdHJhaWxlcgo8PC9TaXplIDExL1Jvb3QgOSAwIFIvSW5mbyAxMCAwIFIvSUQgWzxlNmQ0ZjFjMmNkZmU4ZWQzMTlkNjQ3MzBjMTBmZjZkZj48ZTZkNGYxYzJjZGZlOGVkMzE5ZDY0NzMwYzEwZmY2ZGY+XT4+CiVpVGV4dC01LjUuMTAKc3RhcnR4cmVmCjc3MzgKJSVFT0YK\",\"title\":\"KP1231231231231\",\"account\":\"t162\"}";
        JSONObject json = JSONObject.parseObject(body);
        System.out.println(json.toJSONString());
        System.out.println(RSAUtils.calcRsaSign("1542164508019347740", "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDHHXdhhbLanEIf4FazAyQPnNVEiMgjs5IUQUzA7t0tmhYWV/sPs99CvZVibh3fVnmO/uBlgepOrdYtLm13SzeGFa9kKmaZmAzuNbTuuzYXHglzUcAEuQAqD+538Z5QPuPgfpJdoWG3imj0mWhXxhtQTCDaOA7NEety0wS446zvQhqnwdt+iW5kfnSz9zGlaqJzGiHGe+PY+2pBjrcryv/Rvi74WAHeFxD3DCrjewV867pK0bLKFK8iN/651KvJkeHsvVGi2UiTvf+1IxVq9gVosybQ4M/baFpOxvfUIt16WyhRCcUaFpPfCRm/RT28KWCYYpFuPVM7bkgrpYwF+frnAgMBAAECggEBAKeCNJKIhcS/vClQ8985fzbbO9eiMq1GPlhn7whIay4X+QjnD0FQkzx0fZ4HAX6II0+XQHRk7Rcvy4TLEDBRyO42hA0CVrpUXlxwNjy4pnKgRFcNqTrP4EGCkZ26WPMtVUvhb4TxZWGhQVa1UEC3WvccdG7gxiLjNm6s88YPU8cbGOdKRAOeXp+uhg3Bliug4KtcOOKwHUCSh7EGmky/yExLQWcN8Ec8DSfXNTehTkBEf7mW+5Wwlgo4g2Qj16REaKR9SFXqTtnnOT/mIdiGfgh5vMg1OyE9TsPAqzhqZ13F211y0sDXR2ZJfoJZuvzMB4sDZq1/vMPMGhfqTKPF8pECgYEA/sE8HbNlmajMQsKh6ERosE3HX2ApuSXYsBKAZBxxzHe+4TWF4HKmPD43OTCagD/b/DR4/KDffnwvbiHKdlkQSx9rijzSjgGLS2ysbecemLM41jiFinNSpOY8+aQz0eMAdqlYBlIF5UPH8OlHtmlBkXkfS6fyY9AcP/dwyIJU6f0CgYEAyBackhxK6EWMX17spacktojs/0Sr5JVwRJ6FIRxuxKgSF3iM/JMoTUUmDBZEhIaDkpkuJXAEKwRow97okJ0Nmy5apMXlkpLDofvHWtyI84/9SQlFRklfV0tdFDzQ2yI1iJWQ9oxcwXNiMnK3h8IDaokbBGTIbAlVvOP/QKYmi7MCgYEAjU6iCdd4g8Mdiepr5GoNp7182Wp9ujVD/GZG0UD13nSNbF5D5Duz+baI6zAKgxjo7PwuH/McBQzdQjl8FClS4FiNTiBuqlYw7aVZ/5wzXIANBsZTTHirXsxXBiIOnF1N5IQKT3cvzfvK69Z58LRxqj+FHHIMAVFuWgzmglHIyAECgYBOAwLotL8/8F3akVgS/igCQ0CkBlI+vUUYe/XMAxns8tqa7BWMJJQCDIPZEpWEVi3WaoLjddkqLH3sYGysdY9ogZo1xDLOAwrjjRcdBf8fd3R5lXO9A754epm/2jZUOfJFXos2lWNUyXfv02pbM/nA/9PY0rKR7NHQ49QRkLZWoQKBgQDP4Baph1IhBKkFQByMnP0LFHMP8hMo/ANc+365QlT/6F0/BBDW5XtCXxW5qJ5zFEVJ+CV8QgF/yWElrBHAGuHBprpy3V2QXZhJhyVpytjodExxk1Jjxnup2j7OwSiaANeaNpVsuCQJwXgoeCDc3Bq+SpEMkh858Je7gfNfMwxoSQ==",
                "https://openapi.bestsign.info/openapi/v2", "/storage/contract/upload/", "1615189372144112", null, json.toJSONString()));
    }

    /**
     * 计算参数签名
     *
     * @param developerId 开发者ID
     * @param privateKey  用户私钥
     * @param host        请求的HOST地址（http://ip:port/context）
     * @param methodName  请求的接口方法名
     * @param rtick       时间戳参数
     * @param urlParams   url参数（param1=value1&param2=value2&param3=value3）
     * @param requestBody request body 参数（JSON字符串）
     * @return
     */
    public static String calcRsaSign(String developerId, String privateKey, String host, String methodName,
                                     String rtick, String urlParams, String requestBody) {
        String url = host + methodName;

        Map<String, String> stringTreeMap = new TreeMap<String, String>();
        stringTreeMap.put("developerId", developerId);
        stringTreeMap.put("rtick", rtick);
        stringTreeMap.put("signType", "rsa");

        if (urlParams != null && !"".equals(urlParams)) {
            String[] params = urlParams.split("&");
            for (String p1 : params) {
                String[] p2 = p1.split("=");
                String key = p2[0];
                String value = "";
                if (p2.length == 2) {
                    value = p2[1];
                }
                stringTreeMap.put(key, value);
            }
        }

        String requestPath;
        try {
            requestPath = new URL(url).getPath();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        StringBuilder signStringBuilder = new StringBuilder();
        for (String name : stringTreeMap.keySet()) {
            String value = stringTreeMap.get(name);
            signStringBuilder.append(name);
            signStringBuilder.append("=");
            signStringBuilder.append(value);
        }
        signStringBuilder.append(requestPath);

        if (requestBody != null && !"".equals(requestBody)) {
            String requestMd5 = getRequestMd5(requestBody);
            signStringBuilder.append(requestMd5);
        }

        String signString = signStringBuilder.toString();
        String rsaSign = calcRsaSign(privateKey, signString);
        // rsa算出来的sign，需要urlencode
        try {
            rsaSign = URLEncoder.encode(rsaSign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            rsaSign = null;
        }
        return rsaSign;
    }


    /**
     * 获取request body 的MD5
     *
     * @param requestBody
     * @return
     */
    private static String getRequestMd5(final String requestBody) {
        byte[] data;

        String newRequestBody = convertToUtf8(requestBody);
        data = newRequestBody.getBytes(StandardCharsets.UTF_8);
        return md5(data);
    }

    /**
     * 计算参数RSA签名
     *
     * @param privateKey
     * @param signData
     * @return
     */
    private static String calcRsaSign(String privateKey, final String signData) {
        byte[] data;
        data = signData.getBytes(StandardCharsets.UTF_8);
        byte[] sign = null;
        // 解密由base64编码的私钥
        byte[] privateKeyBytes = base64decode(privateKey.getBytes());

        // 构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);

        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        // 取私钥匙对象
        PrivateKey priKey;
        try {
            priKey = keyFactory.generatePrivate(pkcs8KeySpec);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        // 用私钥对信息生成数字签名
        Signature signature;
        try {
            signature = Signature.getInstance("SHA1withRSA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        try {
            signature.initSign(priKey);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        try {
            signature.update(data);
            sign = signature.sign();
        } catch (SignatureException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return new String(base64encode(sign));
    }

    /**
     * 转换字符集到utf8
     *
     * @param src
     * @return
     */
    private static String convertToUtf8(String src) {
        if (src == null || src.length() == 0) {
            return src;
        }
        if ("UTF-8".equalsIgnoreCase(Charset.defaultCharset().name())) {
            return src;
        }

        byte[] srcData = src.getBytes();
        return new String(srcData, StandardCharsets.UTF_8);
    }

    /**
     * md5
     *
     * @param data
     * @return
     */
    public static String md5(byte[] data) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        // 获得MD5摘要算法的 MessageDigest 对象
        MessageDigest mdInst;
        try {
            mdInst = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        // 使用指定的字节更新摘要
        mdInst.update(data);
        // 获得密文
        byte[] md = mdInst.digest();
        // 把密文转换成十六进制的字符串形式
        int j = md.length;
        char[] str = new char[j * 2];
        int k = 0;
        for (int i = 0; i < md.length; i++) {
            byte byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }

    /**
     * base64编码
     *
     * @param data
     * @return
     */
    public static byte[] base64encode(byte[] data) {
        return Base64.encodeBase64(data);
    }

    /**
     * base64编码字符串
     *
     * @param data
     * @return
     */
    public static String base64encodeString(byte[] data) {
        String base64Str = Base64.encodeBase64String(data);
        base64Str = replaceBlank(base64Str);
        return base64Str;
    }

    /**
     * base64解码
     *
     * @param data
     * @return
     */
    public static byte[] base64decode(byte[] data) {
        try {
            return Base64.decodeBase64(data);
        } catch (Exception e) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            for (int i = 0; i < data.length; i++) {
                byte c = data[i];
                if (c == 13 || c == 10) {
                    continue;
                }
                outputStream.write(c);
            }
            try {
                outputStream.close();
            } catch (IOException e2) {

            }
            data = outputStream.toByteArray();
            return Base64.decodeBase64(data);
        }
    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (!isBlank(str)) {
            Matcher m = BLANK_PATTERN.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static boolean isBlank(final String value) {
        return (value == null || value.trim().length() < 1);
    }
}
