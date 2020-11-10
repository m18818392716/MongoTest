import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Susanna
 * @date 2020/8/26 17:12
 */
public class MongoDBJDBC {


    public static void main(String args[]) {
        try {

            // 连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
            // ServerAddress()两个参数分别为 服务器地址 和 端口
            ServerAddress serverAddress = new ServerAddress("192.168.1.248", 7017);
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();
            addrs.add(serverAddress);

            // MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
            MongoCredential credential = MongoCredential.createScramSha1Credential("mongtest","admin","GsQtLPwyg3s9D".toCharArray());
//            MongoCredential credential = MongoCredential.createMongoCRCredential("mongtest","admin","GsQtLPwyg3s9D".toCharArray());

            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            credentials.add(credential);
            // 通过连接认证获取MongoDB连接
            MongoClient mongoClient = new MongoClient(addrs, credentials);
            System.out.println("mongodb连接成功");
            MongoDatabase db = mongoClient.getDatabase("tnaot");
            System.out.println("Connect to database successfully");
            System.out.println(db.getName() + "包含如下集合：");

            System.out.println("数据库连接成功");
//            MongoCollection collection = db.getCollection("usermsg");
            MongoCollection<Document> collection = db.getCollection("usermsg");
            System.out.println("集合 usermsg 选择成功");

//            BasicDBObject searchObj = new BasicDBObject();
//            searchObj.put("_id", "1317695932858406");
            System.out.println("------------111");

//            FindIterable<Document> oneUser = collection.find(searchObj);
//            MongoCursor<Document> mongoCursor = oneUser.iterator();
//            String result = mongoCursor.next().get("newsTitle").toString();
//            System.out.println("资讯标题为：" + result);



            // 检索所有文档
            /**
             * 1. 获取迭代器FindIterable<Document>
             * 2. 获取游标MongoCursor<Document>
             * 3. 通过游标遍历检索出的文档集合
             */
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            System.out.println("------------111");
            while (mongoCursor.hasNext()) {
                Document doc = mongoCursor.next();
                System.out.println(doc.toJson());


//                Document studentDocument = mongoCursor.next();
                System.out.println(doc.getString("newsTitle") +", " );
            }
            System.out.println("------------111");
            mongoClient.close();


//            // 更新文档 将文档中likes=100的文档修改为likes=200
//            collection.updateMany(Filters.eq("_id", "1317695932858406"), new Document("$set", new Document("newsTitle", "朱一龙的铁粉")));
//            mongoClient.close();
//
//            collection.deleteOne(Filters.eq("likes", 200));  //删除符合条件的第一个文档
//            collection.deleteMany(Filters.eq("likes", 200));  //删除所有符合条件的文档
//
//            // 文档插入数据
//            Document document = new Document("title", "MongoDB").append("description", "database").append("likes", 100);  //新建文档
//            List<Document> documents = new ArrayList<Document>();
//            documents.add(document);
//            collection.insertMany(documents);  //添加文档（对应的BSON数据）
//            System.out.println("文档插入成功");



        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
