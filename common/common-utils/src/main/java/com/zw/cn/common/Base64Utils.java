package com.zw.cn.common;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;


/**
 * @Author:tien
 */
public class Base64Utils {
    private static final Log log = LogFactory.getLog(Base64Utils.class);

    private static int decode(char c) {
        if (c >= 'A' && c <= 'Z')
            return ((int) c) - 65;
        else if (c >= 'a' && c <= 'z')
            return ((int) c) - 97 + 26;
        else if (c >= '0' && c <= '9')
            return ((int) c) - 48 + 26 + 26;
        else
            switch (c) {
                case '+':
                    return 62;
                case '/':
                    return 63;
                case '=':
                    return 0;
                default:
                    throw new RuntimeException("unexpected code: " + c);
            }
    }

    private static void decode(String s, OutputStream os) throws IOException {
        int i = 0;

        int len = s.length();

        while (true) {
            while (i < len && s.charAt(i) <= ' ')
                i++;

            if (i == len)
                break;

            int tri = (decode(s.charAt(i)) << 18) + (decode(s.charAt(i + 1)) << 12) + (decode(s.charAt(i + 2)) << 6) + (decode(s.charAt(i + 3)));

            os.write((tri >> 16) & 255);
            if (s.charAt(i + 2) == '=')
                break;
            os.write((tri >> 8) & 255);
            if (s.charAt(i + 3) == '=')
                break;
            os.write(tri & 255);

            i += 4;
        }
    }

    @SuppressWarnings("restriction")
    @Deprecated
    public static String encode(byte[] bstr) {
        return new sun.misc.BASE64Encoder().encode(bstr);

    }

    @Deprecated
    public static String encode(String str) throws UnsupportedEncodingException {
        return encode(str.getBytes("UTF-8"));

    }

    @Deprecated
    public static String decode(String str) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            decode(str, bos);
        } catch (IOException e) {
            if (log.isErrorEnabled())
                log.error("throw Error while decoding BASE64: " + str.toString());
            throw new RuntimeException();
        }
        byte[] decodedBytes = bos.toByteArray();
        try {
            bos.close();
            bos = null;
        } catch (IOException ex) {
            if (log.isErrorEnabled())
                log.error("Error while decoding BASE64: " + ex.toString());
        }
        try {
            return new String(decodedBytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String apacheDecode(String data) {
        return apacheDecode(data.getBytes());
    }

    public static String apacheDecode(byte[] binaryData) {
        return new String(apacheDecode2(binaryData));
    }

    public static byte[] apacheDecode2(String data) {
        return apacheDecode2(data.getBytes());
    }

    public static byte[] apacheDecode2(byte[] binaryData) {

        byte[] decode = null;
        try {
            decode = Base64.decodeBase64(binaryData);
        } catch (Exception e) {
            if (log.isErrorEnabled())
                log.error("Error while apache decoding BASE64: " + binaryData, e);
            throw new RuntimeException(e);
        }
        return decode;
    }

    public static String apacheEecode(String data) {
        return apacheEecode(data.getBytes());
    }

    public static String apacheEecode(byte[] binaryData) {
        return new String(apacheEecode2(binaryData));
    }

    public static byte[] apacheEecode2(String data) {
        return apacheEecode2(data.getBytes());
    }

    public static byte[] apacheEecode2(byte[] binaryData) {

        byte[] decode = null;
        try {
            decode = Base64.encodeBase64(binaryData);
        } catch (Exception e) {
            if (log.isErrorEnabled())
                log.error("Error while apache decoding BASE64: " + binaryData, e);
            throw new RuntimeException(e);
        }
        return decode;
    }
}
