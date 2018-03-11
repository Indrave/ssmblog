package com.ssmblog.core.admin;

import com.ssmblog.core.entity.User;
import com.ssmblog.core.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author wangyj
 * @date 2018/3/11
 * @description
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    //日志文件
    private static final Logger log = Logger.getLogger(UserController.class);

    /**
     * 登录
     * @param user
     * @param request
     * @return
     */
    public String login(User user, HttpServletRequest request){
        return "";
    }



}
