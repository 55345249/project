package com.primeton.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.primeton.domain.CapUser;
import com.primeton.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service("userService")
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

    @Override
    public List<CapUser> selectByExample(Example example) {
        return null;
    }

    /*@Override
    public List<CapUser> list(Map<String, Object> map) {
        return userMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return userMapper.count(map);
    }*/

    @Override
    public PageInfo<CapUser> queryLimitedUser(String username,Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        Example example = new Example(CapUser.class);
        if (!StringUtils.isEmpty(username)) {
            example.createCriteria().andEqualTo("username", username);
        }
        List<CapUser> users = userMapper.selectByExample(example);
        return new PageInfo<>(users);

    }
}
