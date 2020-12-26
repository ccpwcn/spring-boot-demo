package net.srwasu.us.controller;

import com.alibaba.fastjson.JSON;
import net.srwasu.us.properties.PasswordConf;
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

    @GetMapping("/password")
    public String password() {
        return passwordConf.getSaltType();
    }
}
