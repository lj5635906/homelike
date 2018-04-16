package com.homelike.security.demo.rest;

import com.homelike.common.web.vo.ResultVo;
import com.homelike.security.demo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-16 14:25
 **/
@RestController
@RequestMapping("/user")
public class UserRest {

    @GetMapping("/{userId}")
    public ResultVo getUserDetail(@PathVariable(name = "userId") Long userId){
        User user = new User();
        user.setUserId(1L);
        user.setUsername("homelike");
        user.setGender(1);
        user.setBirthday(LocalDateTime.now());
        return ResultVo.ok(user);
    }

}
