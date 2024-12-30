package com.douyin.catchbarragepublic.controller;

import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;
import sun.net.www.http.HttpClient;

import java.nio.charset.StandardCharsets;

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

    @PostMapping("/aceLogin")
    @SneakyThrows
    public String testNetInterface(){
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://116.196.120.162:30001/dongdong/sys/login");
        post.setHeader("Content-Type", "application/json;charset=UTF-8");
        StringEntity stringEntity = new StringEntity(JSON.toJSONString(new LoginReq()), StandardCharsets.UTF_8);
        post.setEntity(stringEntity);
        CloseableHttpResponse response = client.execute(post);
        HttpEntity responseEntity = response.getEntity();
        String s = EntityUtils.toString(responseEntity);
        return s;
    }

    @Data
    private class LoginReq{
        private String loginAccount = "admin";
        private String password = "XYT5NPWIKuGSRRm9X0eJoWlyz3e8ZkbpHULY574eTnSuA+pIu0w+gEjwUwBgPq0x74RtXkfWPBEzGgO1BewIePaEpCR34bm6+uXjt5B8AwhOgAb00pL1iD6PNJ/jQJwECrNO6Px+iyxEtGfoxF5txAb0v51bZCmy4FrrwmyzdKk=";
    }
}
