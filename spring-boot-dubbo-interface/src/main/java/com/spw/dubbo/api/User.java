package com.spw.dubbo.api;

import lombok.*;

import java.io.Serializable;

/**
 * @Description 用户信息
 * @Author spw
 * @Date 2021/5/30
 */
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User implements Serializable {
    private Integer id;
    private String name;
    private String addr;
}
