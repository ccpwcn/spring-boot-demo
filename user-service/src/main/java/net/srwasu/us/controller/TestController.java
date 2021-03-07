package net.srwasu.us.controller;

import cn.srwasu.commons.api.ApiRes;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import net.srwasu.us.properties.PasswordConf;
import net.srwasu.us.service.QueryService;
import net.srwasu.us.service.UserService;
import net.srwasu.us.vo.UserUpdateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lidawei
 * @Date 2020/12/26 9:21
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private PasswordConf passwordConf;

    @Autowired
    private QueryService queryService;

    @Autowired
    private UserService userService;

    @GetMapping("/password")
    public ApiRes<String> password() {
        return ApiRes.ok(passwordConf.getSaltType());
    }

    @GetMapping("/query")
    public ApiRes<String> query(String keyword) {
        return queryService.query(keyword);
    }

    @PostMapping("/updateById")
    public ApiRes<Integer> updateById(UserUpdateVo vo) {
        log.info("updateById request param: {}", JSON.toJSONString(vo));
        return userService.updateById(vo);
    }
}
