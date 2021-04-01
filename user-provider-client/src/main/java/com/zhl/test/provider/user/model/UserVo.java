package com.zhl.test.provider.user.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserVo {

    private Long id;

    private String name;
}
