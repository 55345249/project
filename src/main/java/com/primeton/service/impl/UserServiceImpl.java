package com.primeton.service.impl;

import com.primeton.domain.CapUser;
import com.primeton.domain.PageInfo;
import com.primeton.repository.UserMapper;
import com.primeton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    public List<CapUser> selectUser(Integer startNum, Integer viewNum) {
        return userMapper.selectUser(startNum,viewNum);
    }


    public void insert(CapUser user) {
        userMapper.insert(user);
    }

    @Override
    public List<CapUser> queryUser(PageInfo pageInfo) {

        List<CapUser> capUserList = userMapper.listUser(pageInfo);
        return capUserList;
    }

    @Override
    public Integer totalCount() {
        int totalCount = userMapper.queryTotalCount();
        return totalCount;
    }

    /*@Override
    public PageInfo<CapUser> queryLimitedUser(String username,Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        Example example = new Example(CapUser.class);
        if (!StringUtils.isEmpty(username)) {
            example.createCriteria().andEqualTo("username", username);
        }
        List<CapUser> users = userMapper.selectByExample(example);
        return new PageInfo<>(users);

    }*/
}
