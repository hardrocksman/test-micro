package com.zhl.test.provider.user;

import com.zhl.test.provider.user.model.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "nacos-provider", path = "/user/")
@Component
public interface UserFeign {

    @RequestMapping(value = "get/{id}")
    UserVo get(@PathVariable("id") Integer id);

    @RequestMapping(value = "list", method = RequestMethod.GET)
    List<UserVo> list(@RequestBody UserVo entityVo);
}
