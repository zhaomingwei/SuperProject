package com.zw.cn.common;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

/**
 * 原web的发送邮件方法,未做修改,暂不做优化处理
 *
 * @author Administrator
 */
public class EmailSenderUtils {

    private final static String protocol = "smtp";
    private final static String emailFromHostName = "mail.shenyundata.com";
    private final static String emailFromHostPort = "465";
    private final static String emailFrom = "account@shenyundata.com";
    private final static String emailFromPwd = "shenyundata@2016SY";

    /**
     * 发送邮件
     *
     * @param subject           邮件主题
     * @param content           邮件内容
     * @param emailTos          收件人列表
     * @param emailCcs          抄送人列表
     * @param protocol          发送邮件协议
     * @param emailFromHostName 发送邮件服务器名称
     * @param emailFromHostPort 发送邮件服务器端口
     * @param emailFrom         发件人
     * @param emailFromPwd      发件人登录邮件服务器密码
     * @param ifHtml            是否为html邮件
     * @throws GeneralSecurityException
     * @throws MessagingException
     * @throws Exception
     */
    public static void sendMail(String subject, String content, String[] emailTos, String[] emailCcs, String protocol,
                                String emailFromHostName, String emailFromHostPort, final String emailFrom, final String emailFromPwd,
                                boolean ifHtml) throws GeneralSecurityException, MessagingException {

        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", protocol);
        properties.put("mail.smtp.host", emailFromHostName);
        properties.put("mail.smtp.socketFactory.port", emailFromHostPort);
        properties.put("mail.smtp.auth", "true");
        // properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.checkserveridentity", "false");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        properties.put("mail.debug", "true");
        // 创建Session实例对象
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailFrom, emailFromPwd);
            }
        });
        // 创建邮件内容
        MimeMessage message = new MimeMessage(session);
        // 邮件主题,并指定编码格式
        message.setSubject(subject, "utf-8");
        // 发件人
        message.setFrom(new InternetAddress(emailFrom));
        // 收件人
        for (String to : emailTos) {
            message.addRecipient(RecipientType.TO, new InternetAddress(to));
        }
        // 抄送
        if (emailCcs != null) {
            for (String cc : emailCcs) {
                message.addRecipient(RecipientType.CC, new InternetAddress(cc));
            }
        }
        // 发送时间
        message.setSentDate(new Date());
        if (ifHtml) {
            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setContent(content, "text/html; charset=utf-8");
            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(bodyPart);
            message.setContent(multipart);
        } else {
            message.setText(content, "utf-8");
        }
        // 保存并生成最终的邮件内容
        message.saveChanges();
        Transport.send(message);
    }

    /**
     * 发送邮件
     *
     * @param subject  邮件主题
     * @param content  邮件内容
     * @param emailTos 收件人列表
     * @throws MessagingException
     * @throws GeneralSecurityException
     * @throws Exception
     */
    public static void sendMail(String subject, String content, String[] emailTos)
            throws GeneralSecurityException, MessagingException {

        sendMail(subject, content, emailTos, null);
    }

    /**
     * 发送邮件
     *
     * @param subject  邮件主题
     * @param content  邮件内容
     * @param emailTos 收件人列表
     * @param emailCcs 抄送人列表
     * @throws MessagingException
     * @throws GeneralSecurityException
     * @throws Exception
     */
    public static void sendMail(String subject, String content, String[] emailTos, String[] emailCcs)
            throws GeneralSecurityException, MessagingException {

        sendMail(subject, content, emailTos, emailCcs, protocol, emailFromHostName, emailFromHostPort, emailFrom,
                emailFromPwd, true);
    }

}
