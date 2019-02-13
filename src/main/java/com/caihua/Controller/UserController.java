package com.caihua.Controller;

import com.alibaba.fastjson.JSON;
import com.caihua.bean.User;
import com.caihua.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping( "/user")
public class UserController {

    private Logger logger=LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public String addUser(User user) {
        userService.addUser(user);
        return "success";
    }

    @RequestMapping("/del")
    public String delUser(int id) {
        userService.delUser(id);
        logger.warn("已开除学生"+id);
        return "success";
    }

    @RequestMapping(value = "/update",produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String updateUser(User user) {
        user.getClasses().setCid(1);
        userService.updateUser(user);
        logger.warn("已修改学生信息"+user.getName());
        User userR=userService.findUser(user.getId());
        String u = JSON.toJSONString(userR);
        return u;
    }

    @RequestMapping("/findByName")
    public String findUser(String name, Model model) {
        logger.info("根据姓名开始查找学生");
        List<User> users = userService.findUsers(name);
        model.addAttribute("users",users);
        if(users.size()==0){
            logger.error("要查找的学生不存在");
        }else {
            logger.info("查到了"+users.size()+"位学生");
        }
        return "user";
    }

    @RequestMapping("/findById")
    public String findUser(int id,Model model) {
        logger.info("根据id开始查找学生");
        User user = userService.findUser(id);
        List<User> users = new ArrayList<>();
        users.add(user);
        if(users.size()==0){
            logger.error("要查找的学生不存在");
        }else {
            logger.info("查到了"+users.size()+"位学生");
        }
        model.addAttribute("users",users);
        return "user";
    }
}
