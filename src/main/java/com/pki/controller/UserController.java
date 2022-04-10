package com.pki.controller;

import com.pki.entity.RestfulVo;
import com.pki.entity.User;
import com.pki.enums.UserType;
import com.pki.service.Impl.UserService;
import com.pki.utils.ZStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author by twjitm on 2018/12/21/11:06
 */
@RequestMapping("users")
@Controller
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping("welcome")
    public String welcome(HttpServletRequest request) {
        return "index/welcome";
    }

    @RequestMapping("index")
    public String index(HttpServletRequest request) {
        return "index/index";
    }

    @RequestMapping("registerGo")
    public String goRegister(HttpServletRequest request) {
        return "register";
    }

    @RequestMapping("loginUI")
    public String loginUI() {
        return "login";
    }

    @RequestMapping("register")
    public String register(HttpServletRequest request, User user) {
        if (user == null || user.getUId() == null) {
            userService.register(user);
            return "login";
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
    @ResponseBody
    public RestfulVo login(HttpServletRequest request, String uName, String uPsd) {
        RestfulVo restfulVo = new RestfulVo();

        if (ZStringUtil.isEmptyStr(uName) && ZStringUtil.isEmptyStr(uPsd)) {
            restfulVo.setCode(200);
            restfulVo.setSuccessful(false);
            return restfulVo;
        }
        User user = userService.login(uName, uPsd);
        if (user == null) {
            restfulVo.setCode(200);
            restfulVo.setSuccessful(false);
            return restfulVo;
        }
        restfulVo.setSuccessful(true);
        setconcurrentUser(user, request);
        return restfulVo;

    }

    @RequestMapping("logout")
    public String logOut(HttpServletRequest request) {
        request.getSession().removeAttribute(request.getSession().getId());
        removeconcurrentUser(request);
        return "login";
    }

    @RequestMapping("user")
    public String user(HttpServletRequest request) {
        request.setAttribute("infos", getconcurrentUser(request));
        return "/users/user";
    }
}
