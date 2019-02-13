package com.caihua.service;

import com.caihua.bean.Classes;
import com.caihua.mapper.ClassesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public void addClasses(Classes classes) {
        classesMapper.addClasses(classes);
    }

    @Override
    public void delClasses(int cid) {
        classesMapper.delClasses(cid);
    }

    @Override
    public void updateClasses(Classes classes) {
        classesMapper.updateClasses(classes);
    }

    @Override
    public Classes findClasses(String cname) {
        return classesMapper.findClasses(cname);
    }
}
