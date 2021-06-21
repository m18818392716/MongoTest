/**
 * @author Susanna
 * @date 2021/1/19 9:04
 */
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class jsonArraySort {

    public static void main(String[] args) {
        String jsonArrStr = "[{\"ID\":\"A01\",\"Name\":\"张三\",\"Score\":88},{\"ID\":\"A02\",\"Name\":\"李四\",\"Score\":99},{\"ID\":\"A01\",\"Name\":\"王五\",\"Score\":77}]";
        System.out.println("排序前：" + jsonArrStr);
        String jsonArraySort = jsonArraySort(jsonArrStr);
        System.out.println("排序后：" + jsonArraySort);
    }


    public static String jsonArraySort(String jsonArrStr) {
        // json字符串转为JSONArray
        JSONArray jsonArr = JSON.parseArray(jsonArrStr);
        //存放排序结果json数组
        JSONArray sortedJsonArray = new JSONArray();
        // 用于排序的list
        List<JSONObject> list = new ArrayList<JSONObject>();
        //遍历待排序的json数组，并将数据放入list
        for (int i = 0; i < jsonArr.size(); i++) {
            list.add(jsonArr.getJSONObject(i));
        }

        Collections.sort(list, new Comparator<JSONObject>() {
            //排序字段
            private static final String KEY_NAME1 = "ID";
            private static final String KEY_NAME2 = "Score";

            public int compare(JSONObject a, JSONObject b) {
                String valA1 = new String();
                String valA2 = new String();
                String valB1 = new String();
                String valB2 = new String();
                try {
                    valA1 = a.getString(KEY_NAME1);
                    valA2 = b.getString(KEY_NAME1);
                    valB1 = a.getString(KEY_NAME2);
                    valB2 = b.getString(KEY_NAME2);
                } catch (JSONException e) {
                    System.out.println(e);
                }
                // 设置排序规则
                int i = valA1.compareTo(valA2);
                if (i == 0) {
                    int j = valB1.compareTo(valB2);
                    return j;
                }
                return i;
            }
        });
        //将排序后结果放入结果jsonArray
        for (int i = 0; i < jsonArr.size(); i++) {
            sortedJsonArray.add(list.get(i));
        }
        return sortedJsonArray.toString();
    }
}
