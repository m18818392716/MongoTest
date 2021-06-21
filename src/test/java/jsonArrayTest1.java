

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Susanna
 * @date 2021/1/22 11:05
 */
public class jsonArrayTest1 {


    public static void main(String[] args) {
        String loginResInfo = "{\"name\":\"小名\",\"age\":19,\"subTradeList\":[{\"balance\":\"2083.63\",\"money\":\"0.01\",\"tradeDesc\":\"工资\",\"tradeTime\":\"2018-12-07 11:51:01\",\"tradeType\":\"1\",\"queryTime\":\"2018-12-07 15:33:07\",\"recAccount\":\"410350248160111\",\"recAccountName\":\"（特约）中金支付（资金结算）\",\"tradeAddress\":null},{\"balance\":\"2083.63\",\"money\":\"0.01\",\"tradeDesc\":\"代付\",\"tradeTime\":\"2018-12-07 11:50:58\",\"tradeType\":\"1\",\"queryTime\":\"2018-12-07 15:33:07\",\"recAccount\":\"410350248160111\",\"recAccountName\":\"（特约）中金支付（资金结算）\",\"tradeAddress\":null}]}";
        System.out.println("原始字符串:" + loginResInfo);
//        String replaceAll = loginResInfo.replaceAll("\\\\", "");
//        System.out.println("replaceAll:"+replaceAll);

//        String substring = loginResInfo.substring(1, loginResInfo.length() - 1);
//        System.out.println("substring:"+substring);
        String jsonArrayList = "{\"newsType\":1,\"objectId\":9009266,\"readNews\":[{\"newsType\":1,\"objectId\":9009266,\"readTime\":15}],\"readTime\":15}";


        System.out.println(sortAsciiJson(loginResInfo));
        System.out.println("原始字符串:" + jsonArrayList);
        System.out.println(sortAsciiJson(jsonArrayList));

    }

    /**
     * 按ASCII码给json对象排序（规定：升序）
     * @param json
     * @return
     */
    public  static String sortAsciiJson(String json){
        String res = "";
        try {
            JSONObject jsonObject = JSONObject.fromObject(json,new JsonConfig());
            ArrayList nameList = new ArrayList();
            Iterator keys = jsonObject.keys();
            while(keys.hasNext()) {
                String key = keys.next().toString();
                nameList.add(key);
            }
            //key排序，升序
            Collections.sort(nameList);
//            Collections.sort(nameList,new ASCIICompartor());
            StringBuffer sb = new StringBuffer();
            sb.append("{");
            for (int i = 0; i < nameList.size(); i++) {
                String name = nameList.get(i).toString();
                String value = jsonObject.getString(name);
                if(i != 0)sb.append(",");
                //添加键值对，区分字符串与json对象
                if(value.startsWith("{")||value.startsWith("[")){
                    sb.append(String.format("\"%s\":%s",name,value));
                }else{
                    sb.append(String.format("\"%s\":\"%s\"",name,value));
                }
            }
            sb.append("}");
            res = sb.toString();

        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }


        return res;

    }

}
