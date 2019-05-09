package com.emotte.cloud.app.user.emerp.mapper.writer;

import com.emotte.cloud.app.user.emerp.model.User;
import org.springframework.stereotype.Component;

@Component("wrEmerpUserMapper")
public interface WrEmerpUserMapper {

    public int inserUser(User user);


}
