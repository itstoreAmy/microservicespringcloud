package com.emotte.cloud.app.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "mongo_pojo")
public class MongoPojo {

    /**
     *@Document用于指定数据库的conllection
     *
     * @field用于指定数据库字段
     *
     * @id用于标识主键
     *
     * @GeneratedValue 自动生成id
     */

    @Id
    String id;
    @Field
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
