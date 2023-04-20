package com.phantom.provider.controller;


import com.alibaba.nacos.shaded.com.google.common.collect.Lists;
import com.alibaba.nacos.shaded.com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huan.fu 2021/8/23 - 下午5:58
 */
@RestController
public class UserController {

    private final List<String> users = Lists.newCopyOnWriteArrayList();

    {
        users.add("张三");
    }

    @GetMapping("/addUser")
    public String addUser(@RequestParam("userName") String userName) {
        this.users.add(userName);
        return "添加用户:[" + userName + "]成功.";
    }

    @GetMapping("/findAllUsers")
    public Map<String, Object> findAllUsers(@RequestHeader("tokenInfo") String tokenInfo) {
        HashMap<String, Object> result = Maps.newHashMap();
        result.put("users", this.users);
        result.put("tokenInfo", tokenInfo);
        return result;
    }
}
