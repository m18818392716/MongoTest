package com.tnaot.api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * @author Susanna
 * @date 2020/9/17 13:40
 */
public class Md5Util {
    private static MessageDigest mDigest = null;

    static {
        try {
            mDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对key进行MD5加密，如果无MD5加密算法，则直接使用key对应的hash值。
     */
    public static String toMD5(String key) {
        //获取MD5算法失败时，直接使用key对应的hash值
        if (mDigest == null) {
            return String.valueOf(key.hashCode());
        } else {
            return toMD5(key.getBytes());
        }
    }

    public static String toMD5(byte[] bytes) {
        if (mDigest == null) {
            return "";
        }
        String cacheKey;
        mDigest.update(bytes);
        cacheKey = bytesToHexString(mDigest.digest());
        return cacheKey;
    }


    private static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }


    public static void main(String[] args){
        System.out.println(toMD5(new byte[]{1,2,3}));
    }
}
