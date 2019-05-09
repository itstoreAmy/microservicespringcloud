package com.emotte.cloud.app.user.emerp.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Component
public class User implements Serializable {


    private int id;

    private String username;

    private String name;

    private Short age;

    private BigDecimal balance;

    //不序列化
    private transient String desc;

}
