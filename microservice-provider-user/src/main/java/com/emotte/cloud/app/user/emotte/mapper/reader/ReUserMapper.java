package com.emotte.cloud.app.user.emotte.mapper.reader;

import com.emotte.cloud.app.user.emerp.model.User;
import org.springframework.stereotype.Component;

@Component("reUserMapper")
public interface ReUserMapper {

    public User getById(long id);


}
