package com.pki.controller;

import com.pki.entity.User;
import com.pki.enums.UserType;
import com.pki.service.Impl.UserService;
import com.pki.utils.ZStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author by twjitm on 2018/12/21/11:06
 */
@RequestMapping("users")
@Controller
public class UserController extends BaseController {
    @Autowired
    private UserService userService;


    @RequestMapping("register")
    public String register(HttpServletRequest request, User user) {
        if (user == null || user.getUName() == null && user.getUType() == null) {
            return "register";
        } else {
            //重复注册
            User logUser = userService.login(user.getUName(), user.getUPsd());
            if (logUser != null) {
                return "register";
            }
            if (user.getUType().equals(UserType.valueOf(1).getDiscribe())) {
                setconcurrentUser(user, request);
                return "login";
            } else {
                setconcurrentUser(user, request);
                return "login";
            }
        }
    }

    //登陆

    @RequestMapping("login")
    public String login(HttpServletRequest request, String uName, String uPsd) {
        if (ZStringUtil.isEmptyStr(uName) && ZStringUtil.isEmptyStr(uPsd)) {
            return "login";
        }
        User user = userService.login(uName, uPsd);
        if (user == null) {
            return "login";
        }
        if (user.getUType().equals(UserType.PTUSER.getDiscribe())) {
            setconcurrentUser(user, request);
            return "success";
        }
        setconcurrentUser(user, request);
        return "admin";

    }

}
