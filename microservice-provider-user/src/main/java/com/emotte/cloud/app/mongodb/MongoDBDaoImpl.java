package com.emotte.cloud.app.mongodb;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class MongoDBDaoImpl implements MongoDBDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     * @param user
     */
    @Override
    public String saveUser(MongoPojo user) {
        mongoTemplate.save(user);
        DB db = mongoTemplate.getDb();
        return db.toString();
    }


    @Override
    public MongoPojo findUserByUserName(String userName) {

        Query query=new Query(Criteria.where("name").is(userName));
        MongoPojo user =  mongoTemplate.findOne(query , MongoPojo.class);
        return user;
    }

}
