package com.pki.dao;

import java.util.List;

import com.pki.base.BaseDao;
import com.pki.entity.Menu;
import org.springframework.stereotype.Repository;



@Repository("menuDao")
public class MenuDao extends BaseDao<Menu> {

	public List<Menu> getFirstMenus(Integer[] id) {
		String str="";
		for(int i=0;i<id.length;i++){
			str=str+id[i]+",";
		}
		str=str.substring(0, str.length()-1);
		String hql="from Menu where id in("+str+") and parentId=0 order by orderNum";
		return this.find(hql);
	}

	public List<Menu> getMenuByParentId(Integer parentId) {
		String hql="from Menu where parentId="+parentId;
		return this.find(hql);
	}

}
