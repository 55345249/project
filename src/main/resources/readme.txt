代码层的结构

根目录：com.primeton

1.工程启动类(ApplicationServer.java)置于com.primeton.build包下

2.实体类(domain)置于com.primeton.domain

3.数据访问层(Dao)置于com.primeton.repository

4.数据服务层、业务服务层(Service)、置于com,primeton.service,数据服务的实现接口(serviceImpl)至于com.primeton.service.impl

5.前端控制器、页面访问控制(Controller)置于com.primeton.controller

6.工具类(utils)置于com.primeton.utils

7.常量接口类(constant)置于com.primeton.constant

8.配置信息类(config)置于com.primeton.config

9.数据传输类(vo)置于com.primeton.vo

10.第三方置于com.primeton.third

资源文件的结构

根目录:src/main/resources

1.配置文件(.properties/.json等)置于config文件夹下

2.国际化(i18n))置于i18n文件夹下

3.spring.xml置于META-INF/spring文件夹下

4.页面以及js/css/image等置于static文件夹下的各自文件下
