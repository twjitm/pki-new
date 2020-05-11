package com.pki.dao;

import java.util.List;

import com.pki.base.BaseDao;
import com.pki.entity.Power;
import org.springframework.stereotype.Repository;


@Repository("powerDao")
public class PowerDao extends BaseDao<Power> {

    public List<Power> getPowerByuserType(Integer type) {
        String hql = "from  Power p where p.userType=" + type;
        return find(hql);
    }

}
