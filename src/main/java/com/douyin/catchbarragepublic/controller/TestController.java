package com.douyin.catchbarragepublic.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @title: TestController
 * @Author liwjak
 * @Date: 2024/12/30 16:55
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value = "测试",httpMethod = "POST")
    @PostMapping("/postTest")
    public String testPostOut(@RequestParam String req){
        return "您触发了测试POST接口，入参内容："+req;
    }

    @ApiOperation(value = "测试",httpMethod = "GET")
    @GetMapping("/getTest")
    public String testGETOut(@RequestParam String req){
        return "您触发了测试GET接口，入参内容："+req;
    }
}
