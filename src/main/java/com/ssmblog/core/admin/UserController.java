package com.ssmblog.core.admin;

import com.ssmblog.core.entity.PageBean;
import com.ssmblog.core.entity.User;
import com.ssmblog.core.service.UserService;
import com.ssmblog.core.util.MD5Util;
import com.ssmblog.core.util.ResponseUtil;
import com.ssmblog.core.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/list")
    public String list(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows") String rows,
                       User s_user, HttpServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<>();
        if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
        map.put("userName", StringUtil.formatLike(s_user.getUserName()));
        List<User> userList = userService.findUser(map);
        Long total = userService.getTotalUser(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(userList);
        result.put("rows", jsonArray);
        result.put("total", total);
        log.info("request:user/list,map:" + map.toString());
        ResponseUtil.write(response,result);
        return null;
    }

    /**
     * 修改密码
     * @param user 用户
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/modifyPassword")
    public String modifyPassword(User user,HttpServletResponse response) throws IOException {
        String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
        user.setPassword(MD5pwd);
        int resultToal = userService.updateUser(user);
        JSONObject result = new JSONObject();
        if(resultToal>0){
            result.put("success", true);
        }else{
            result.put("success", false);
        }
        log.info("request:user/modifyPassword,user:"+user.getUserName());
        ResponseUtil.write(response,result);
        return null;
    }


}
