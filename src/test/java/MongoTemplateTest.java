import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import org.junit.Test;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteResult;

//import bean.Book;
//import bean.Good;
//import bean.ShopDO;
//import net.sf.json.JSONObject;

/**
 * @author Susanna
 * @date 2020/8/26 17:49
 */
public class MongoTemplateTest {

//    public static MongoTemplate mongoTemplate = getMongoTemplate();
//
//    public static void main(String[] args) {
//        System.out.println(mongoTemplate.getCollectionNames());
//    }
//
//    public static MongoTemplate getMongoTemplate(){
//        String host = "192.168.16.121";
//        int port = 27017;
//        String databaseName = "test";
//        String username = "root";
//        String password = "123456Ab";
//
//        //ServerAddress(host,port)两个参数分别为 IP地址 端口号
//        ServerAddress serverAddress = new ServerAddress(host,port);
//        List<ServerAddress> addrs = new ArrayList<ServerAddress>();
//        addrs.add(serverAddress);
//
//        //MongoCredential.createScramSha1Credential(username,source,password)三个参数分别为 用户名 数据库名称 密码
//        MongoCredential credential = MongoCredential.createScramSha1Credential(username, databaseName, password.toCharArray());
//        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
//        credentials.add(credential);
//
//        //通过连接认证获取MongoDB连接
//        MongoClient mongoClient = new MongoClient(addrs,credentials);
//        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClient, databaseName);
//        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
//
//        return mongoTemplate;
//    }
//
//    /**
//     * 插入数据
//     */
//    @Test
//    public void save(){
//        ShopDO shop1 = new ShopDO(100L,"菜鸟教程");
//        ShopDO shop2 = new ShopDO(101L,"有道笔记");
//        mongoTemplate.save(shop1,"col");
//        mongoTemplate.save(shop2,"col");
//        System.out.println("mongoDB插入数据成功,集合为col,文档为："+mongoTemplate.getCollection("col"));
//    }
//
//    @Test
//    public void save1(){
//        Book book = new Book(22L,"英语","32.5");
//        mongoTemplate.save(book,"col");
//    }
//
//    @Test
//    public void save2(){
//        Good good = new Good(new HashMap<String,String>(){{put("id","1");put("name","动物");}});
//        mongoTemplate.save(good,"col");
//    }
//
//    @Test
//    public void save3(){
//        mongoTemplate.save(JSONObject.fromObject("{\"这样\":\"we\",\"好吧\":\"hai\"}"),"col");
//        System.out.println("mongoDB插入数据成功,集合为col,文档为："+mongoTemplate.getCollection("col"));
//    }
//
//    /**
//     * 查询所有
//     */
//    @Test
//    public void findAll(){
//        List<ShopDO> list = mongoTemplate.findAll(ShopDO.class,"col");
//        System.out.println("mongoDB查询数据成功,集合为col,文档为：");
//        for (ShopDO shopDO:list){
//            System.out.println(shopDO.getNo()+"/"+shopDO.getName());
//        }
//    }
//
//    /**
//     * 单条件查询
//     */
//    @Test
//    public void simpleQuery(){
//        Query query = Query.query(Criteria.where("no").is(100L));
//        List<ShopDO> list = mongoTemplate.find(query,ShopDO.class,"col");
//        System.out.println("mongoDB按条件ID查询数据成功,集合为col,文档为：");
//        for (ShopDO shopDO:list){
//            System.out.println(shopDO.getNo()+"/"+shopDO.getName());
//        }
//    }
//
//    /**
//     * 多条件查询
//     */
//    @Test
//    public void muchQuery(){
//        Criteria criteria = new Criteria();
//        //or是条件或查询，and是条件与查询
//        criteria.orOperator(
//                Criteria.where("no").is(100),
//                Criteria.where("name").is("菜鸟教程"));
//        Query query = new Query(criteria);   //组合查询放入query
//        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC,"no"));  //结果集进行排序
//        query.with(sort);
//        List<ShopDO> list = mongoTemplate.find(query,ShopDO.class,"col");
//        System.out.println("mongoDB组合查询数据成功,集合为col,文档为：");
//        for (ShopDO shopDO:list){
//            System.out.println(shopDO.getNo()+"/"+shopDO.getName());
//        }
//    }
//
//    /**
//     * 分页查询
//     */
//    @Test
//    public void LimitQuery(){
//        Query query = new Query();
//        query.skip(1).limit(3);
//        List<ShopDO> list = mongoTemplate.find(query,ShopDO.class,"col");
//        System.out.println("mongoDB分页查询下标为1开始总共3行数据,集合为col,文档为：");
//        for (ShopDO shopDO:list){
//            System.out.println(shopDO.getNo()+"/"+shopDO.getName());
//        }
//    }
//
//    /**
//     * 模糊查询
//     */
//    @Test
//    public void LikeQuery(){
//        Query query = new Query(Criteria.where("name").regex("菜鸟"));
//        List<ShopDO> list = mongoTemplate.find(query,ShopDO.class,"col");
//        System.out.println("mongoDB查询名称叫菜鸟的数据成功,集合为col,文档为：");
//        for (ShopDO shopDO:list){
//            System.out.println(shopDO.getNo()+"/"+shopDO.getName());
//        }
//        Update update = new Update();
//        update.set("name","菜鸟教程old");
//        WriteResult wr = mongoTemplate.updateMulti(query,update,"col");
//        System.out.println("mongoDB更新数据成功,集合为col,行数为：" + wr.getN());
//    }
//
//    /**
//     * 更新
//     */
//    @Test
//    public void update(){
//        Query query = new Query(Criteria.where("no").is(100));
//        List<ShopDO> list = mongoTemplate.find(query,ShopDO.class,"col");
//        System.out.println("mongoDB查询no为100的数据成功,集合为col,文档为：");
//        for (ShopDO shopDO:list){
//            System.out.println(shopDO.getNo()+"/"+shopDO.getName());
//        }
//        Update update = new Update();
//        update.set("name","菜鸟教程new");
//        WriteResult wr = mongoTemplate.updateFirst(query,update,"col");
//        System.out.println("mongoDB更新数据成功,集合为col,行数为：" + wr.getN());
//    }
//
//    /**
//     * 删除
//     */
//    @Test
//    public void delete(){
//        Query query = new Query(Criteria.where("no").is(1));
//        WriteResult result = mongoTemplate.remove(query, "col");
//        System.out.println("mongoDB删除数据成功,集合为col,行数为：" + result.getN() + "删除的ID为"+result.getUpsertedId());
//    }
}
