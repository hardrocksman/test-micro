package com.zhl.test.provider.user.rest;

import com.zhl.test.provider.user.UserFeign;
import com.zhl.test.provider.user.model.UserVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class TestUserRest implements UserFeign {


    @Override
    @GetMapping(value = "/get/{id}")
    public UserVo get(@PathVariable("id") Integer id) {
        return UserVo.builder().id(id.longValue()).name("name-".concat(id.toString())).build();
    }

    @Override
    @GetMapping(value = "/list")
    public List<UserVo> list(UserVo entityVo) {
        return null;
    }
}
