package com.springcloud.sso.client2.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaomai
 * @date 2022/5/28
 */
@RestController
public class IndexController {

    @GetMapping("/index")
    public Object getCurrentUser(Authentication authentication) {
        return authentication;
    }

    @GetMapping("auth/test1")
    @PreAuthorize("hasAuthority('user')")
    public String authTest1(){
        return "您拥有'user'权限";
    }

    @GetMapping("auth/test2")
    @PreAuthorize("hasAuthority('admin')")
    public String authTest2(){
        return "您拥有'admin'权限";
    }

}
