package com.primeton.service.impl;

import com.primeton.domain.CapUser;
import com.primeton.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<CapUser> selectUser(Integer startNum, Integer viewNum) {
        return userMapper.selectUser(startNum,viewNum);
    }

    @Override
    public void insert(CapUser user) {
        userMapper.insert(user);
    }
}
