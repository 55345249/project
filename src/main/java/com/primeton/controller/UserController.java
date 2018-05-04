package com.primeton.controller;

import com.primeton.domain.CapUser;
import com.primeton.domain.PageInfo;
import com.primeton.repository.user.UserMapper;
import com.primeton.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserMapper userMapper;
    private static final Logger logger = LoggerFactory.getLogger(TestControler.class);

    @RequestMapping("/main1")
    public String queryUser(Model model,PageInfo pageInfo, HttpServletRequest request){
        pageInfo.setBegin(1);
        pageInfo.setEnd(5);
        pageInfo.setPerPageRecordCount(5);
        pageInfo.setCurrentPage(0);

        List<CapUser> userList = userService.queryUser(pageInfo);
        Integer totalCounts = userService.totalCount();
        pageInfo.setTotalRecordCount(totalCounts);

        model.addAttribute("userList", userList);

        model.addAttribute("pageInfo",pageInfo);

        return "/zelda/userList";
    }

    @RequestMapping("/currentPage")
    public String currentPage(Model model,PageInfo pageInfo, HttpServletRequest request){

        int currentPage = Integer.parseInt(request.getParameter("page"));
        //int perCount = Integer.parseInt(request.getParameter("perPageRecordCount"));

        pageInfo.setBegin(1 + currentPage*5);
        pageInfo.setEnd(5 + currentPage*5);
        pageInfo.setPerPageRecordCount(5);

        /*pageInfo.setBegin(1 + currentPage*perCount);
        pageInfo.setEnd(perCount + currentPage*perCount);
        pageInfo.setPerPageRecordCount(perCount);*/

        pageInfo.setCurrentPage(currentPage);

        List<CapUser> userList = userService.queryUser(pageInfo);
        Integer totalCounts = userService.totalCount();
        pageInfo.setTotalRecordCount(totalCounts);

        model.addAttribute("userList", userList);

        model.addAttribute("pageInfo",pageInfo);

        return "/zelda/userList";
    }

    @RequestMapping("/perPageCount")
    public String perPageCount(Model model,PageInfo pageInfo, HttpServletRequest request){
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int perCount = Integer.parseInt(request.getParameter("perPageRecordCount"));

        pageInfo.setPerPageRecordCount(perCount);

        pageInfo.setBegin(1 + currentPage*perCount);
        pageInfo.setEnd(perCount + currentPage*perCount);
        pageInfo.setCurrentPage(currentPage);

        List<CapUser> userList = userService.queryUser(pageInfo);
        Integer totalCounts = userService.totalCount();
        pageInfo.setTotalRecordCount(totalCounts);

        model.addAttribute("userList", userList);

        model.addAttribute("pageInfo",pageInfo);

        return "/zelda/userList";
    }

}
