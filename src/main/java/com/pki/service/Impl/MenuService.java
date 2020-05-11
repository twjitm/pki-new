package com.pki.service.Impl;


import java.util.List;

import javax.annotation.Resource;

import com.pki.dao.MenuDao;
import com.pki.dao.PowerDao;
import com.pki.entity.Menu;
import com.pki.entity.Power;
import com.pki.service.IMenuService;
import org.springframework.stereotype.Service;


/**
 * 菜单管理
 *
 * @author 文江
 */
@Service
public class MenuService implements IMenuService {
    @Resource
    private PowerDao powerDao;
    @Resource
    private MenuDao menuDao;

    @Override
    public List<Menu> getMenuByuserType(Integer uType) {
        List<Power> powers = powerDao.getPowerByuserType(uType);
        if (powers == null || powers.size() == 0) return null;
        Integer[] ids = new Integer[powers.size()];
        for (int i = 0; i < powers.size(); i++) {
            ids[i] = powers.get(i).getMenuId();
        }
        List<Menu> firstMenu = menuDao.getFirstMenus(ids);//first
        for (int i = 0; i < firstMenu.size(); i++) {
            List<Menu> chilMenu = menuDao.getMenuByParentId(firstMenu.get(i).getId());
            firstMenu.get(i).setMenus(chilMenu);
        }

        return firstMenu;
    }


}
