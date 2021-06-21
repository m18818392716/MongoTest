

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Susanna
 * @date 2021/1/22 16:14
 */
public class jsonDemo2 {

    public static void main(String[] args){
        String jsonString = "{\"key1\":\"1\",\"key2\":\"2\"}";
//        String str = "[{\"key1\":\"1\"},{\"key2\":\"2\"}]";
         Map<String, Object> map = toMap(jsonString);
         for (Map.Entry<String, Object> entry : map.entrySet()){
             String key = entry.getKey();
             Object value = entry.getValue();
             System.out.println(key + ":" + value);
         }
    }
    public static <T> Map<String, T> toMap(String json){
        Map<String, T> map = new HashMap<String, T>();
        JSONObject jsonObject = JSONObject.fromObject(json, new JsonConfig());
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()){
            String key = keys.next();
            Object value = jsonObject.get(key);
            map.put(key, (T) value);
        }
        return map;
    }
}
