package com.pki.dao;

import com.alibaba.fastjson.JSON;
import com.pki.base.BaseDao;
import com.pki.entity.Cabook;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("cabookDao")
public class CabookDao extends BaseDao<Cabook> {

    @Override
    public List<Cabook> find(String hql) {
        List<Cabook> list = super.find(hql);

        for (Cabook b :
                list) {
            b.setJson(JSON.toJSONString(b));
        }
        return list;
    }

    @Override
    public List<Cabook> find(String hql, Map<String, Object> params) {
        List<Cabook> list = super.find(hql, params);
        for (Cabook b :
                list) {
            b.setJson(JSON.toJSONString(b));
        }
        return list;
    }
}
