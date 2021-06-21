import net.sf.json.JSONObject;

/**
 * @author Susanna
 * @date 2021/1/22 14:15
 */
public class jsonDemo1 {
    public static void main(String[] args) {

        String aa = "{\"success\":\"true\",\"data\":[{\"shop_uid\":\"123\"},{\"shop_name\":\"张三\"}]}";
        String result = "{\"success\":\"true\",\"returnAddress\":\"123\"}";
        JSONObject jsonObject= JSONObject.fromObject(result); //转换成object

        System.out.println(jsonObject.getString("returnAddress")); //获取object中returnAddress字段;

//        JSONArray detail = JSON.parseArray(result);
//        for (int i=0; i<detail.size();i++){
//            if(detail.get(i)!=null||!detail.get(i).equals("")){
//                JSONArray detailChild =detail.getJSONArray(i);
//                if(detailChild.getInteger(1)>Integer.valueOf(ship.get("shiptime").toString())){
//                    ship.put("shiptime",detailChild.getInteger(1));
//                    ship.put("desc",detailChild.getString(0));
//                }
//            }
//        }

    }
}
