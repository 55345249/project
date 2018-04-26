package com.primeton.controller;


import com.primeton.domain.SystemDO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

@Controller
public class SystemController {


    @RequestMapping("/system")
    public String systemInit(Model model) {

        Properties props = System.getProperties(); //系统属性



        model.addAttribute("id", UUID.randomUUID());


        Map<String,String> map = new HashMap<String,String>();

        setSystemMap(map,props);

        model.addAttribute("systemInfo",map);

/*        SystemDO systemDO = new SystemDO();

        setSystemDO(systemDO,props);

        model.addAttribute("systemDO", systemDO);*/

        return "/zelda/systemConfig";
    }

    private void setSystemDO(SystemDO systemDO,Properties props) {

        systemDO.setJavaClassPath(props.getProperty("java.class.path"));

        systemDO.setJavaExtDirs(props.getProperty("java.ext.dirs"));

        systemDO.setJavaHome(props.getProperty("java.home"));

        systemDO.setJavaIoTmpdir(props.getProperty("java.io.tmpdir"));

        systemDO.setJavaLibraryPath(props.getProperty("java.library.path"));

        systemDO.setJavaVendor(props.getProperty("java.vendor"));

        systemDO.setJavaVendorUrl(props.getProperty("java.vendor.url"));

        systemDO.setJavaVersion(props.getProperty("java.version"));

        systemDO.setOsArch(props.getProperty("os.arch"));

        systemDO.setOsName(props.getProperty("os.name"));

        systemDO.setOsVersion(props.getProperty("os.version"));

        systemDO.setUserHome(props.getProperty("user.home"));

        systemDO.setUserName(props.getProperty("user.name"));

        systemDO.setUserDir(props.getProperty("user.dir"));
    }

    private void setSystemMap(Map map, Properties props)
    {
    //    map.put("Java的类路径：",props.getProperty("java.class.path"));
    //    map.put("一个或多个扩展目录的路径：",props.getProperty("java.ext.dirs"));
    //    map.put("Java的安装路径：",props.getProperty("java.home"));
    //    map.put("默认的临时文件路径：",props.getProperty("java.io.tmpdir"));
    //    map.put("加载库时搜索的路径列表：",props.getProperty("java.library.path"));

        map.put("Java的运行环境供应商：",props.getProperty("java.vendor"));
        map.put("Java供应商的URL：",props.getProperty("java.vendor.url"));
        map.put("Java的运行环境版本：",props.getProperty("java.version"));
        map.put("操作系统的构架：",props.getProperty("os.arch"));
        map.put("操作系统的名称：",props.getProperty("os.name"));

        map.put("操作系统的版本：",props.getProperty("os.version"));
        map.put("用户的主目录：",props.getProperty("user.home"));
        map.put("用户的账户名称：",props.getProperty("user.name"));
        map.put("用户的当前工作目录：",props.getProperty("user.dir"));

    }


}
