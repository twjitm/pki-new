package com.pki.service.Impl;


import com.pki.dao.CabookDao;
import com.pki.entity.Cabook;
import com.pki.enums.CAState;
import com.pki.service.ICABookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("cABookService")

public class CABookService implements ICABookService {
    @Autowired
    private CabookDao cabookDao;


    @Override
    public void Save(Cabook book) {
        cabookDao.Save(book);
    }

    @Override
    public void update(Cabook book) {
        String hql = "update Cabook c set c.caStart=:start,c.caUrl=:url where c.caId=:id";
        Map<String, Object> params = new HashMap<>();
         params.put("url", book.getCaUrl());
        params.put("start", book.getCaStart());
        params.put("id", book.getCaId());
        cabookDao.update(hql, params);
    }

    @Override
    public List<Cabook> getBookByStart(Integer start) {
        String hql = "from Cabook c where c.caStart=:start order by c.caId desc";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", start);
        return cabookDao.find(hql, map);
    }


    public List<Cabook> getBookByStart() {
        String hql = "from Cabook";
        return cabookDao.find(hql);
    }

    @Override
    public Long getBookByStartLong(int start) {
        String start1 = CAState.valueOf(start).getDiscribe();
        String hql = "count(*) from Cabook c where c.caStart=" + start1;
        return cabookDao.count(hql);
    }

    @Override
    public List<Cabook> getBookByUId(int Uid, Integer start) {
        System.out.println("-------------" + Uid + start);
        String hql = "from Cabook c where c.UId=" + Uid + " and c.caStart=:start";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", start);
        List<Cabook> list = cabookDao.find(hql, map);
        for (Cabook cabook : list) {
            System.out.println(cabook.getCaC());
        }
        return list;
    }

    public List<Cabook> getBooKById(int UId) {

        String hql = "from Cabook c where c.UId=" + UId;
        List<Cabook> list = cabookDao.find(hql);
        return list;
    }

    @Override
    public Long getBookByUIdLong(int UId) {
        String hql = "from Cabook c where c.UId=" + UId;

        return cabookDao.count(hql);
    }

    @Override
    public void delete(Cabook bookCabook) {
        cabookDao.delete("delete from Cabook c where c.caId=" + bookCabook.getCaId());

    }

    public Cabook getCaBookById(int caBId) {
        String hql = "from Cabook c where c.caId=" + caBId;
        return cabookDao.Get(hql);

    }
}
