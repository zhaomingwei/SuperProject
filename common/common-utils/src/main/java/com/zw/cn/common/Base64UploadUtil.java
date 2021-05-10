package com.zw.cn.common;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ase64 上传下载文件或图片
 *
 * @author ZhaoWei
 * @ClassName Base64UploadUtil
 * @Description
 * @date 2017年6月2日 上午10:21:49
 */
public class Base64UploadUtil {
    private static final Log log = LogFactory.getLog(Base64UploadUtil.class);

    /**
     * 物理路径key
     */
    public static final String pathDirKey = "pathDirKey";
    /**
     * url访问路径key
     */
    public static final String pathUrlKey = "pathUrlKey";

    /**
     * 单上传,文件将按自有规则命名<p>
     * 返回map,可根据<pre>
     *   Base64UploadUtil.pathDirKey<br/>
     *   Base64UploadUtil.pathUrlKey
     *   获取其物理路径和访问路径
     * @author ZhaoWei
     * @date 2017年6月2日 上午10:31:28
     * @param userId  用户
     * @param fileBase64Str  文件或图片base64编码字符串
     * @param prefixPath    文件路径前缀
     * @param fileformat    文件格式(txt,png,jpg,gif等)
     * @param picPreFixUrl    url访问前缀
     * @return map
     * @throws IllegalStateException
     * @throws IOException
     */
    public static Map<String, String> upload(Long userId, String fileBase64Str, String fileformat,
                                             String prefixPath, String picPreFixUrl) throws IllegalStateException, IOException {

        if (StringUtils.isBlank(fileBase64Str))
            return new HashMap<String, String>();

        String pathDir = getFolder(prefixPath, userId);
        String pathUrl = getUrlPath(picPreFixUrl, userId);

        String fileName = DateUtils.StampZipFmt.format(new Date());//生成文件名称
        fileName = fileName + "." + fileformat;


        String pathDirf = pathDir + File.separator + fileName;
        String pathUrlf = pathUrl + "/" + fileName;

        generateFile(fileBase64Str, pathDirf);

        if (log.isInfoEnabled())
            log.info("\r\n文件或图片已上传至: " + pathDirf + "\r\n访问路径: " + pathUrlf);
        Map<String, String> retMap = new HashMap<>();
        retMap.put(pathDirKey, pathDirf);
        retMap.put(pathUrlKey, pathUrlf);

        return retMap;
    }

    /**
     * 生成文件
     *
     * @param fileBase64Str
     * @param pathDir
     * @return
     * @throws IOException
     * @author ZhaoWei
     * @date 2017年6月2日 下午2:49:49
     */
    public static boolean generateFile(String fileBase64Str, String pathDir) throws IOException {

        byte[] b = Base64Utils.apacheDecode2(fileBase64Str);

        OutputStream out = null;
        try {
            out = new FileOutputStream(pathDir);
            out.write(b);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
        return true;
    }

    /**
     * 文件生成base64编码字符串
     *
     * @param fileDir
     * @return
     * @author ZhaoWei
     * @date 2017年6月2日 下午2:56:21
     */
    public static String generateBase64StrByFile(String fileDir) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(fileDir);
            data = new byte[inputStream.available()];
            inputStream.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
        return new String(Base64.encodeBase64(data));
    }


    private static String getDateFolder() {
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
        return formater.format(new Date());
    }

    /**
     * 根据字符串创建本地目录 并按照日期建立子目录字符串返回
     *
     * @return File
     * @author ZhaoWei
     * @version 2015年12月30日 下午2:51:56
     */
    private static String getFolder(String localPath, Long userId) {
        localPath = transforDir(localPath);
        localPath += getDateFolder();
        if (userId != null)
            localPath += File.separator + userId;
        File dir = new File(localPath);
        if (!dir.exists())
            dir.mkdirs();
        return localPath;
    }

    /**
     * 根据字符串获得url对应路径
     *
     * @return File
     * @author ZhaoWei
     * @version 2015年12月30日 下午2:51:56
     */
    private static String getUrlPath(String urlPath, Long userId) {
        urlPath = transforUrl(urlPath);
        urlPath += getDateFolder();
        if (userId != null)
            urlPath += "/" + userId;
        return urlPath;
    }

    /**
     * 转换文件路径<br/>
     * 文件是否以分隔符结尾,若不是,则加分隔符
     *
     * @param localPath
     * @return
     */
    public static String transforDir(String localPath) {
        return transfor(localPath, File.separator);
    }

    /**
     * 转换UTL路径<br/>
     * URL是否以分隔符结尾,若不是,则加分隔符
     *
     * @param urlPath
     * @return
     */
    public static String transforUrl(String urlPath) {
        return transfor(urlPath, "/");
    }

    private static String transfor(String path, String separator) {
        if (!path.substring(path.length() - 1, path.length()).equals("/"))
            path += separator;
        return path;
    }

    /**
     * 删除文件或图片
     *
     * @param pathDir
     * @author ZhaoWei
     * @date 2016年1月29日 上午10:57:34
     */
    public static boolean remove(String pathDir) {
        File file = new File(pathDir);
        if (file.exists())
            file.delete();
        return true;
    }

}
