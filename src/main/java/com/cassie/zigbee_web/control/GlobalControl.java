package com.cassie.zigbee_web.control;

import com.cassie.zigbee_dao.entity.User;
import com.cassie.zigbee_work.work.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller("globalController")
public class GlobalControl {

    @Autowired
    private Global global;

    @RequestMapping("/to_login")
    private String toLogin(){
        return "/WEB-INF/views/login.jsp";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam Integer userNum, @RequestParam String userPassword){
        User user = global.login(userNum,userPassword);
        if (user == null){
            return "redirect:to_login";
        }
        session.setAttribute("user",user);
        System.out.println(user.getUserNum());
        return "redirect:self";
    }

    @RequestMapping("/self")
    public String self(){
        return "/WEB-INF/views/self.jsp";
    }

    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.setAttribute("user",null);
        return "redirect:to_login";
    }

    @RequestMapping("/to_change_password")
    public String toChangePassword(){
        return "/WEB-INF/views/change_password.jsp";
    }

    @RequestMapping("/change_password")
    public String changePassword(HttpSession session,@RequestParam String old,@RequestParam String new1,@RequestParam String new2){
        User user = (User) session.getAttribute("user");
        if (user.getUserPassword().equals(old)){
            if (new1.equals(new2)){
                user.setUserPassword(new1);
                global.changePassword(user);
                return "redirect:self";
            }
        }
        return "redirect:to_change_password";
    }
}
