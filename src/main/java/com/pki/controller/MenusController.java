package com.pki.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.pki.entity.Menu;
import com.pki.entity.User;
import com.pki.service.IMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("menu")
@Controller
public class MenusController extends BaseController {
    @Resource
    private IMenuService menuService;

    /**
     * 菜单控制权限
     *
     * @param request
     * @return
     */
    @RequestMapping("menus")
    @ResponseBody
    public List<Menu> list(HttpServletRequest request) {
        User user = getconcurrentUser(request);
        if (user == null) {
            user = new User();
            user.setUType(3);
        }
        return menuService.getMenuByuserType(user.getUType());
    }
}
