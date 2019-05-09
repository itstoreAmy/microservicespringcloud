package com.emotte.cloud.app.user.emotte.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Component
public class EmerpUser {


    private Long id;

    private String username;

    private String name;

    private Short age;

    private BigDecimal balance;

}
