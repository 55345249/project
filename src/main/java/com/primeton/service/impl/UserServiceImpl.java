package com.primeton.service.impl;

import com.primeton.domain.CapUser;
import com.primeton.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class UserServiceImpl implements UserMapper {

    @Autowired
    private UserMapper userMapper;
    /*public UserServiceImpl(CapUser user){
        insert(user);
    }*/

    @Override
    public String insert(CapUser user) {
        userMapper.insert(user);
        return "执行插入操作";
    }
}
