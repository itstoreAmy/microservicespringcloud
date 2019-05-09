package com.emotte.cloud.app.user.emerp.mapper.reader;

import com.emotte.cloud.app.user.emerp.model.User;
import org.springframework.stereotype.Component;

@Component("reEmerpUserMapper")
public interface ReEmerpUserMapper {

    public User getById(long id);


}
