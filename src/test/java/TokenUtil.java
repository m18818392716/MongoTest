import com.tnaot.api.Md5Util;

import java.net.URLEncoder;
import java.util.*;

import org.apache.commons.lang.StringUtils;

/**
 * @author Susanna
 * @date 2020/9/17 13:44
 */
public class TokenUtil {
    /**
     * 时间步长 单位:毫秒 作为口令变化的时间周期
     */
    private static final long STEP = 15000;

    /**
     * 共享密钥
     */
    public static final String SECRET_KEY = "zhqyd0ic?gReoBP%9";


    /**
     *
     * 方法用途: 对所有传入参数按照字段名的Unicode码从小到大排序（字典序），并且生成url参数串<br>
     * 实现步骤: <br>
     *
     * @param paraMap   要排序的Map对象
     * @param urlEncode   是否需要URLENCODE
     * @param keyToLower    是否需要将Key转换为全小写
     *            true:key转化成小写，false:不转化
     * @return
     */
    public static String formatUrlMap(Map<String, String> paraMap, boolean urlEncode, boolean keyToLower)
    {
        String buff = "";
//        Map<String, String> tmpMap = paraMap;

        Map tmpMap = new HashMap();
        tmpMap = paraMap;
        try
        {
            List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(tmpMap.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>()
            {
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2)
                {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });
            // 构造URL 键值对的格式
            StringBuilder buf = new StringBuilder();
            for (Map.Entry<String, String> item : infoIds)
            {
                if (StringUtils.isNotBlank(item.getKey()))
                {
                    String key = item.getKey();
                    String val = item.getValue();
                    if (urlEncode)
                    {
                        val = URLEncoder.encode(val, "utf-8");
                    }
                    if (keyToLower)
                    {
                        buf.append(key.toLowerCase() + "=" + val);
                    } else
                    {
                        buf.append(key + "=" + val);
                    }
                    buf.append("&");
                }

            }
            buff = buf.toString();
            if (buff != null)
            {
                buff = buff.substring(0, buff.length() - 1);
            }
        } catch (Exception e)
        {
            return null;
        }
        return buff;
    }
//
//
//
//    //path=/api/home/login
//    public static String getUrlValidateToken(String path, Map<String, Object> mapParam, String uuid, Long time) {
//        String token = path + formatUrlMap(mapParam, false, false) + "&key=" + SECRET_KEY + "&uuid=" + uuid + "&timeStamp=" + time / STEP;
////        if (!TnaotApplication.Companion.instance().isRelease()) {
////            KLog.v("getUrlValidateToken", token);
////        }
//        return Md5Util.toMD5(token).toUpperCase();
//    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //字典序列排序
//        Map<String,String> paraMap = new HashMap<String,String>();

        Map paraMap = new HashMap();
//        paraMap.put("total_fee","200");
//        paraMap.put("appid", "wxd678efh567hg6787");
//        paraMap.put("body", "腾讯充值中心-QQ会员充值");
//        paraMap.put("out_trade_no","20150806125346");
//        paraMap.put("user_name","18054290040");
//        paraMap.put("pwd", "707b68e814b355091e9b49c4de3856d0");
//        paraMap.put("area_code", "86");

//        paraMap.put("user_name","18054290040");
//        paraMap.put("pwd", "707b68e814b355091e9b49c4de3856d0");
//        paraMap.put("area_code", "86");

//        paraMap.put("newsType","1");
//        paraMap.put("objectId", "9448423");
//        paraMap.put("readNews", "15");
//        paraMap.put("readTime", "15");

//        paraMap.put("pwd","1");
//        paraMap.put("withdrawType", "9448423");
//        paraMap.put("withdrawMenuId", "15");
//        paraMap.put("applyCashAmount", "15");
//        paraMap.put("withdrawAccount", "15");

        paraMap.put("accountType","1");
        paraMap.put("accountNum", "9448423");
        paraMap.put("ownerName", "15");

        String url = formatUrlMap(paraMap, false, false);
        System.out.println(url);
    }


}
