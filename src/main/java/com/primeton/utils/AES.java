package com.primeton.utils;

import com.primeton.constant.CreateSecretKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AES {
    private static final Logger logger = LoggerFactory.getLogger(AES.class);
    //随机生成秘钥
    public static String getKey() {
        try {
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            //要生成多少位，只需要修改这里即可128, 192或256
            SecretKey sk = kg.generateKey();
            byte[] b = sk.getEncoded();
            String s = byteToHexString(b);
            logger.info(s);
            logger.info("十六进制密钥长度为"+s.length());
            logger.info("二进制密钥的长度为"+s.length()*4);
            return s;
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.info("没有此算法");
            return null;
        }
    }
    //使用指定的字符串生成秘钥
    public static String getKeyByPass() {
        //秘钥
        String password= CreateSecretKey.SECRET_KEY;
        try {
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            // kg.init(128);//要生成多少位，只需要修改这里即可128, 192或256
            //SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以生成的秘钥就一样。
            kg.init(128, new SecureRandom(password.getBytes()));
            SecretKey sk = kg.generateKey();
            byte[] b = sk.getEncoded();
            String s = byteToHexString(b);
            logger.info(s);
            logger.info("十六进制密钥长度为"+s.length());
            logger.info("二进制密钥的长度为"+s.length()*4);
            return s;
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.info("没有此算法");
            return null;
        }
    }
    /**
     * byte数组转化为16进制字符串
     * @param bytes
     * @return
     */
    public static String byteToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String strHex=Integer.toHexString(bytes[i]);
            if(strHex.length() > 3) {
                sb.append(strHex.substring(6));
            } else {
                if(strHex.length() < 2) {
                    sb.append("0" + strHex);
                } else {
                    sb.append(strHex);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //getKey();
        getKeyByPass();
    }
}
