package com.zw.cn.common;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;


/**
 * @author ZhaoWei
 * @ClassName DesUtils
 * @Description
 * @date Sep 7, 2017 10:51:00 AM
 */
public class DesUtils {

    public static final String KEY_ALGORITHM = "DES";
    //电码本模式
    public static final String CIPHER_ECB_ALGORITHM = "DES/ECB/PKCS5Padding";
    //加密块链模式
    public static final String CIPHER_CBC_ALGORITHM = "DES/CBC/PKCS5Padding";
    //输出反馈模式
    public static final String CIPHER_OFB_ALGORITHM = "DES/OFB/PKCS5Padding";
    //加密反馈模式
    public static final String CIPHER_CFB_ALGORITHM = "DES/CFB/PKCS5Padding";
    public static final String CIPHER_DEFAOULT_ALGORITHM = CIPHER_ECB_ALGORITHM;
    public static final String CIPHER_SSLDEFAOULT_ALGORITHM = CIPHER_CBC_ALGORITHM;

    public static String encryptAndEncodeBase64(String data, String secretKey) throws Exception {

        byte[] encrypt = encrypt(data, secretKey);

        return Base64Utils.apacheEecode(encrypt);
    }

    public static String encryptAndEncodeBase64(byte[] data, byte[] secretKey) throws Exception {

        byte[] encrypt = encrypt(data, secretKey);

        return Base64Utils.apacheEecode(encrypt);
    }

    public static String decodeBase64AndDecrypt(String data, String secretKey) throws Exception {
        return new String(decrypt(Base64Utils.apacheDecode(data), secretKey));
    }

    public static String decodeBase64AndDecrypt(byte[] data, byte[] secretKey) throws Exception {
        return new String(decrypt(Base64Utils.apacheDecode2(data), secretKey));
    }

    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_DEFAOULT_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, k);
        return cipher.doFinal(data);
    }

    public static byte[] encrypt(String data, String key) throws Exception {
        Key k = toKey(key.getBytes());
        Cipher cipher = Cipher.getInstance(CIPHER_DEFAOULT_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, k);
        return cipher.doFinal(data.getBytes());
    }

    public static byte[] decrypt(String data, String key) throws Exception {
        Key k = toKey(key.getBytes());
        Cipher cipher = Cipher.getInstance(CIPHER_DEFAOULT_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, k);
        return cipher.doFinal(data.getBytes());
    }

    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_DEFAOULT_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, k);
        return cipher.doFinal(data);
    }

    private static Key toKey(byte[] key) throws Exception {
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        SecretKey secretKey = keyFactory.generateSecret(dks);
        return secretKey;
    }

}
