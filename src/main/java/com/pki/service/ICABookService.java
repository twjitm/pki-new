package com.pki.service;


import com.pki.entity.Cabook;

import java.util.List;

public interface ICABookService {
   public void Save(Cabook book);

   public void update(Cabook book);

   public List<Cabook>getBookByStart(Integer start);

   public Long getBookByStartLong(int start);

   public List<Cabook> getBookByUId(int Uid, Integer start);
   
   public Long getBookByUIdLong(int start);
   
   public void delete(Cabook bookCabook);
  	
}
