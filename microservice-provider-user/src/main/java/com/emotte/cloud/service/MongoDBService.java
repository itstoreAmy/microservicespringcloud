package com.emotte.cloud.service;

import com.emotte.cloud.app.mongodb.MongoPojo;

public interface MongoDBService {

    String save(MongoPojo pojo);

    String find(MongoPojo pojo);
}
