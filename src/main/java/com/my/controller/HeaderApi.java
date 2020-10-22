package com.my.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author hutf
 * @createTime 2020年10月22日 14:09:00
 */
@RestController
@RequestMapping("/header")
public class HeaderApi {

    /**
     * 处理request header部分的注解：
     * RequestHeader 携带http Headers 中数据
     * CookieValue 携带 http Cookie 中信息
     */
    @RequestMapping("/testApi")
    public String testApi(@RequestHeader(value = "Accept-Encoding") String coding, @CookieValue(value = "JSESSIONID") String CookieValue) {
        System.out.println(CookieValue);
        System.out.println(coding);

        return "OK";
    }

    /**
     * 处理request body部分的注解：、@RequestBody
     * @RequestParam 处理 application/x-www-form-urlencoded 表单提交方式
     * 数据被编码为名称/值对。这是标准的编码格式
     *
     * @RequestBody 处理 application/json JSON
     * 消息主体是序列化后的 JSON 字符串
     * 格式提交  适合复杂的数据结构
     */
    @RequestMapping("/testParam")
    public String testBody(@RequestBody String name) {
        System.out.println(name);
        return "OK";
    }

    @PutMapping("/put")
    public String testPut(@RequestBody String name) {
        System.out.println(name);
        return "OK";
    }
}
