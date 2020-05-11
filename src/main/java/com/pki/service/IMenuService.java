package com.pki.service;

import com.pki.entity.Menu;

import java.util.List;


public interface IMenuService {
    /**
     * 根据用户类型获取用户菜单
     *
     * @param uType
     * @return
     */
    public List<Menu> getMenuByuserType(Integer uType);


}
