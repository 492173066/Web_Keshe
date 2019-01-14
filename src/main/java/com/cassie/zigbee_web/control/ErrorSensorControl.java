package com.cassie.zigbee_web.control;

import com.cassie.zigbee_dao.entity.ErrorSensor;
import com.cassie.zigbee_work.work.ErrorSensorWork;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller("errorSensorController")
@RequestMapping("/error")
public class ErrorSensorControl {

    @Autowired
    private ErrorSensorWork errorSensorWork;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("list",errorSensorWork.getAll());
        return "/WEB-INF/views/error_list.jsp";
    }

    @RequestMapping("/json")
    public void list(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<ErrorSensor> list = errorSensorWork.getAll();
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        List<ErrorSensor> list1 = errorSensorWork.getAll();
        JSONArray jsonArray = JSONArray.fromObject(list1);
        out.print(jsonArray.toString());
        out.flush();
        out.close();
    }

    @RequestMapping(value = "/remove",params = "id")
    public String remove(Integer id){
        errorSensorWork.remove(id);
        return "redirect:list";
    }

    public void send(HttpServletRequest request,HttpServletResponse response) throws IOException{
        //监听数据库
    }
}
