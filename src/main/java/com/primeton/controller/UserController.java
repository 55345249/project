package com.primeton.controller;

import com.github.pagehelper.PageInfo;
import com.primeton.domain.CapUser;
import com.primeton.service.impl.UserServiceImpl;
import com.primeton.utils.PageUtils;
import com.primeton.utils.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    private static final Logger logger = LoggerFactory.getLogger(TestControler.class);

    @RequestMapping("/main1")
    //@ResponseBody
    public String main1(Model model,@RequestParam Map<String, Object> params, HttpServletResponse response) {
        logger.info("执行查询操作前");
        List<CapUser> userList = userService.selectUser(0,10);
        logger.info("数据库查询结束");
        model.addAttribute("userList",userList);
        return "/zelda/userList";
    }

    /*@RequestMapping("/main1")
    public String index(Model model,@RequestParam(required = false) String username, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "3") Integer pageSize) {
        PageInfo<CapUser> pageInfo = userService.queryLimitedUser(username,pageNum, pageSize);
        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());
        model.addAttribute("userList", pageInfo.getList());

        return "zelda/userList";
    }*/

    /*@GetMapping("/list")
    @ResponseBody
    PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        List<CapUser> userList = userService.list(query);
        int total = userService.count(query);
        PageUtils pageUtil = new PageUtils(userList, total);
        return pageUtil;
    }*/

}
