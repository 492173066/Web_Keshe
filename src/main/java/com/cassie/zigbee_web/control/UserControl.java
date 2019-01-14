package com.cassie.zigbee_web.control;

import com.cassie.zigbee_dao.entity.User;
import com.cassie.zigbee_work.work.UserWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("userController")
@RequestMapping("/user")
public class UserControl {

    @Autowired
    private UserWork userWork;

   @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("list",userWork.getAll());
        return "/WEB-INF/views/user_list.jsp";
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("user",new User());
        return "/WEB-INF/views/user_add.jsp";
    }

    @RequestMapping("/add")
    public String add(User user){
       userWork.add(user);
       return "redirect:list";
    }

    @RequestMapping(value = "/to_update",params = "userNum")
    public String toUpdate(Integer userNum,Map<String,Object> map){
        map.put("user",userWork.get(userNum));
        return "/WEB-INF/views/user_update.jsp";
    }

    @RequestMapping("/update")
    public String update(User user){
       userWork.edit(user);
       return "redirect:list";
    }

    @RequestMapping(value = "/remove",params = "userNum")
    public String remove(Integer userNum){
       userWork.remove(userNum);
       return "redirect:list";
    }
}
