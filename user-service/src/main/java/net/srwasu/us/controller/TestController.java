package net.srwasu.us.controller;

import cn.srwasu.commons.api.ApiRes;
import net.srwasu.us.properties.PasswordConf;
import net.srwasu.us.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lidawei
 * @Date 2020/12/26 9:21
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private PasswordConf passwordConf;

    @Autowired
    private QueryService queryService;

    @GetMapping("/password")
    public ApiRes<String> password() {
        return ApiRes.ok(passwordConf.getSaltType());
    }

    @GetMapping("/query")
    public ApiRes<String> query(String keyword) {
        return ApiRes.ok(queryService.query(keyword));
    }
}
