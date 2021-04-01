package com.zhl.test.user.consumer.controller;


import com.zhl.test.provider.user.UserFeign;
import com.zhl.test.provider.user.model.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Slf4j
public class UserController {


    @Autowired
    UserFeign userFeign;


    @GetMapping("/consumer/test-consumer")
    public ResponseEntity<UserVo> test() {

        UserVo u = userFeign.get(1);
        log.info("结果：[{}]", u);
        return ResponseEntity.of(Optional.of(u));
    }
}
