package com.caihua.Controller;

import com.caihua.bean.Classes;
import com.caihua.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("classes")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @RequestMapping("add")
    public String addClasses(Classes classes) {
        classesService.addClasses(classes);
        return "success";
    }

    @RequestMapping("del")
    public String delClasses(int cid) {
        classesService.delClasses(cid);
        return "success";
    }

    @RequestMapping("update")
    public String updateClasses(Classes classes) {
        classesService.updateClasses(classes);
        return "success";
    }

    @RequestMapping("find")
    public String findClasses(String cname, Model model) {
        Classes classes=classesService.findClasses(cname);
        model.addAttribute("classes",classes);
        return  "classes";
    }
}
