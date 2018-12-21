package com.pki.controller;

import com.pki.entity.User;
import com.pki.enums.UserType;
import com.pki.service.Impl.UserService;
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


    //注册
    public String register(HttpServletRequest request, User user) {
        if (user == null && user.getUName() == null && user.getUType() == null) {
            return "register";
        } else {


            User logUser = userService.login(user.getUName(), user.getUPsd());
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

    public String login(HttpServletRequest request, String UName, String UPsd) {
        if (UName == null && UPsd == null) {
            return "login";
        } else {
            User loginuser = userService.login(UName, UPsd);
            if (null == loginuser) {
                return "login";
            }

            if (loginuser.getUType().equals(UserType.valueOf(1).getDiscribe())) {
                setconcurrentUser(loginuser, request);
                return "success";
            }
            setconcurrentUser(loginuser, request);
            return "admin";
        }
    }

}
