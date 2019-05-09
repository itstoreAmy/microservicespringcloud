package com.emotte.cloud.app.user.emotte.mapper.writer;

import com.emotte.cloud.app.user.emerp.model.User;
import org.springframework.stereotype.Component;

@Component("wrUserMapper")
public interface WrUserMapper {

    public int inserUser(User user);


}
