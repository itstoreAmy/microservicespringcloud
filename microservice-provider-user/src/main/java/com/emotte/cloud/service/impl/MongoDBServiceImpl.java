package com.emotte.cloud.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.emotte.cloud.app.mongodb.MongoDBDao;
import com.emotte.cloud.app.mongodb.MongoPojo;
import com.emotte.cloud.service.MongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("mongoDBService")
public class MongoDBServiceImpl implements MongoDBService {

    @Resource
    private MongoDBDao mongoDBDao;


    @Override
    public String save(MongoPojo pojo) {

        return mongoDBDao.saveUser(pojo);
    }

    @Override
    public String find(MongoPojo pojo) {
        MongoPojo mongoPojo = mongoDBDao.findUserByUserName(pojo.getName());
        return JSONObject.toJSONString(mongoPojo);
    }
}
