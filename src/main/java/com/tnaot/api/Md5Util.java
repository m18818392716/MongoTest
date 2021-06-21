package com.tnaot.api;

import org.apache.commons.lang.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

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

    public static String test(Map<String,String> paraMap) {
        String[] sortedKeys = paraMap.keySet().toArray(new String[]{});
        Arrays.sort(sortedKeys);// 排序请求参数
        StringBuilder s2 = new StringBuilder();
        for (String key : sortedKeys) {
            s2.append(key).append("=").append(paraMap.get(key)).append("&");
        }
        s2.deleteCharAt(s2.length() - 1);
        System.out.println(s2);
        return s2.toString();

    }

//    /**
//     * sign 签名 （参数名按ASCII码从小到大排序（字典序）+key+MD5+转大写签名）
//     * @param map
//     * @return
//     */

//    public static String encodeSign(SortedMap<String,String> map, String key){
//        if(StringUtils.isEmpty(key)){
//            throw new RuntimeException("签名key不能为空");
//        }
//        Set<Map.Entry<String, String>> entries = map.entrySet();
//        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
//        List<String> values =new ArrayList();
//
//        while(iterator.hasNext()){
//            Map.Entry entry = (Map.Entry) iterator.next();
//            String k = String.valueOf(entry.getKey());
//            String v = String.valueOf(entry.getValue());
//            if (StringUtils.isNotEmpty(v) && entry.getValue() !=null && !"sign".equals(k) && !"key".equals(k)) {
//                values.add(k + "=" + v);
//            }
//        }
//        values.add("key="+ key);
//        System.out.println("参数名按ASCII码从小到大排序（字典序）:"+values);
//        String sign = StringUtils.join(values, "&");
//        return encodeByMD5(sign).toUpperCase();
//    }

//    /**
//     * 通过MD5加密
//     *
//     * @param algorithmStr
//     * @return String
//     */
//    public static String encodeByMD5(String algorithmStr) {
//        if (algorithmStr==null) {
//            return null;
//        }
//        try {
//            MessageDigest messageDigest = MessageDigest.getInstance("md5");
//            messageDigest.update(algorithmStr.getBytes("utf-8"));
//            return getFormattedText(messageDigest.digest());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    private static String getFormattedText(byte[] digest){
//        StringBuffer buffer = new StringBuffer();
//        //把每一个byte，做一个与运算，0xff
//        for (byte b :
//                digest) {
//            int number=b & 0xff;//加盐
//            String str = Integer.toHexString(number);
//            if (str.length() == 1){
//                buffer.append("0");
//            }
//            buffer.append(str);
//        }
//        //标准的md5加密后的结果
//        return buffer.toString();
//    }




    public static void main(String[] args){

        System.out.println(toMD5(new byte[]{1,2,3}));

//        TreeMap<String, String> stringStringTreeMap = new TreeMap<String, String>();
//        stringStringTreeMap.put("cardAccNum","2");
//        stringStringTreeMap.put("liquidationDate","20170101");
//        stringStringTreeMap.put("amount","100.00");
//        stringStringTreeMap.put("sourceChannel","1");
//        stringStringTreeMap.put("serialNum","29199388433");
//        stringStringTreeMap.put("eWalletId","1");
//        stringStringTreeMap.put("accNum","2");
//        stringStringTreeMap.put("user_name","18054290040");
//        stringStringTreeMap.put("pwd", "707b68e814b355091e9b49c4de3856d0");
//        stringStringTreeMap.put("area_code", "86");

//        String s = encodeSign(stringStringTreeMap, "123456");
//        System.out.println(s);
//        System.out.println(s.equals("322C77067A392E9A8960CDEBCE147B5E"));

    }
}
