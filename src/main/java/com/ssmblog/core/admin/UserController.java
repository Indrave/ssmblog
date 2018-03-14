package com.ssmblog.core.admin;

import com.ssmblog.core.entity.User;
import com.ssmblog.core.service.UserService;
import com.ssmblog.core.util.MD5Util;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author wangyj
 * @DATE 2018/3/11
 * @description 用户注册
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
     *
     * @param user    用户
     * @param request 请求
     * @return 结果
     */
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {
        //将密码进行md5加密
        try {
            String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
            user.setPassword(MD5pwd);
        } catch (Exception e) {
            user.setPassword("");
        }
        User resultUser = userService.login(user);
        log.info("request:user/login,user: " + user.toString());
        if (resultUser == null) {
            request.setAttribute("user", user);
            request.setAttribute("errorMsg", "请认真核对账号、密码！");
            return "login";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", resultUser);
            MDC.put("userName", user.getUserName());
            return "redirect:/main.jsp";
        }
    }


}
