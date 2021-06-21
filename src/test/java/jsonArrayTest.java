/**
 * @author Susanna
 * @date 2021/1/19 9:06
 */
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Comparator;

public class jsonArrayTest {
    public static void main(String[] args) {
        String str = "[{\"score\":77,\"id\":\"A04\"},{\"score\":88,\"id\":\"A01\"},{\"score\":66,\"id\":\"A01\"}]";
        System.out.println("排序前: " + str);
        JSONArray array = JSON.parseArray(str);

        for (Object arr : array) {
            System.out.println(arr);
        }

        // 方式一
//        array.sort(Comparator.comparing(obj -> ((JSONObject)obj).getInteger("score")));
//        array.sort(Comparator.comparing(e-> ((JSONObject)e).getString("id")));
        // 方式二：单字段排序
//        array.sort((a, b) -> ((JSONObject) a).getString("id").compareTo(((JSONObject) b).getString("id")));
        // 方式二：多字段排序
//        array.sort((a, b) -> {
//            int i = ((JSONObject) a).getString("id").compareTo(((JSONObject) b).getString("id"));
//            if (i == 0) {
//                int j = ((JSONObject) a).getInteger("score").compareTo(((JSONObject) b).getInteger("score"));
//                return j;
//            }
//            return i;
//        });
//        System.out.println("排序后: " + array);
//
//        for (Object arr : array) {
//            System.out.println(arr);
//        }
    }
}
