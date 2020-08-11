package com.wl.javaSpringBoot.test.controller;

import com.wl.javaSpringBoot.test.vo.ApplicationTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 汪林
 * @date 2020/8/10 11:20
 */
@Controller
@RequestMapping("/test")
public class TestController {
    /**
     * 127.0.0.1:8080/test/testDesc ---- get
     */
    @Value("${server.port}")
    private int port;
    @Value("${com.name}")
    private String name;
    @Value("${com.age}")
    private int age;
    @Value("${com.desc}")
    private String desc;
    @Value("${com.random}")
    private String random;

    @Autowired
    private ApplicationTest applicationTest;
    //注意：如果配置文件和全局配置文件key值一样，将被覆盖，修改applicationTest的key值
    //定义日志属性--用于输出测试日志系统
    private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);
    @RequestMapping("/config")
    @ResponseBody
    public String configTest(){
        StringBuffer sb = new StringBuffer();
            sb.append(port).append("----")
                .append(name).append("----")
                .append(age).append("----")
                .append(desc).append("----")
                .append(random).append("----").append("<br>");
            sb.append(applicationTest.getPort()).append("----")
                .append(applicationTest.getName()).append("----")
                .append(applicationTest.getAge()).append("----")
                .append(applicationTest.getDesc()).append("----")
                .append(applicationTest.getRandom()).append("----").append("<br>");
        return sb.toString();
    }

    @GetMapping("/testDesc")
    @ResponseBody
    public String testDesc(){
        return "i am wanglin";
    }

    /**测试日志
     * 127.0.0.1:8085/test/logTest ---- get
     */
    @GetMapping("/logTest")
    @ResponseBody
    public String logTest() {
        LOGGER.trace("This is trace log");
        LOGGER.debug("This is debug log");
        LOGGER.info("This is info log");
        LOGGER.warn("This is warn log");
        LOGGER.error("This is error log");
        return "This is log test!";
    }
}
