package com.caihua.service;

import com.caihua.bean.Classes;

public interface ClassesService {

    public void addClasses(Classes classes);

    public  void delClasses(int cid);

    public void updateClasses(Classes classes);

    public Classes findClasses(String cname);
}
