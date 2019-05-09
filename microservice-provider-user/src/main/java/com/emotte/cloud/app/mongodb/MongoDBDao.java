package com.emotte.cloud.app.mongodb;

public interface MongoDBDao {

    public String saveUser(MongoPojo user);

    public MongoPojo findUserByUserName(String userName);
}
