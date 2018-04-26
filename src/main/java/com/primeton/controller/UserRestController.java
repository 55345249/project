package com.primeton.controller;


import com.primeton.domain.CapUser;
import com.primeton.service.impl.UserServiceImpl;
import com.primeton.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class UserRestController {
    @Autowired
    private UserServiceImpl userService;
    private static final Logger logger = LoggerFactory.getLogger(TestControler.class);

    @RequestMapping("/insertUser")
    public void insertUser(){

        int count = 0;

        logger.info("##########开始时间：" + DateUtil.getDateForSS());
        String operatorId = DateUtil.getDateForSS();
        String hostAdress = "";
        try {
            InetAddress address = InetAddress.getLocalHost();
            hostAdress = address.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            logger.info("未识别主机IP");
        }
        for(int i = 0; i<10000 ;i ++) {
            StringBuffer sb = new StringBuffer("");
            String operValue = (sb.append(operatorId).append(hostAdress.replace(".","")).append(String.valueOf(count))).toString();
            //logger.info("operValue:"+operValue);
            CapUser user = new CapUser(operValue, "01", "001", "monkey", "123456", "2013-03-16 11:58:31", "2013-03-16 11:58:31", "2013-03-16 11:58:31");
            userService.insert(user);
            count++ ;
        }
        logger.info("##########结束时间：" + DateUtil.getDateForSS());
    }

    @RequestMapping("/selectUser/{startNum}/{viewNum}")
    public List<CapUser> selectUser(@PathVariable("startNum") Integer startNum, @PathVariable("viewNum") Integer viewNum){
        logger.info("起始条数：" + String.valueOf(startNum) + ",显示条数：" +String.valueOf(viewNum));
        return userService.selectUser(startNum,viewNum);
    }
}
