package com.cassie.zigbee_web.control;

import com.cassie.zigbee_dao.entity.Sensor;
import com.cassie.zigbee_dao.global.Contact;
import com.cassie.zigbee_web.serialports.SerialPortUtils;
import com.cassie.zigbee_work.work.SensorWork;
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

@Controller("sensorController")
@RequestMapping("/sensor")
public class SensorControl {

    @Autowired
    private SensorWork sensorWork;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("list",sensorWork.getAll());
        System.out.println(sensorWork.getAll().toString());
        return "/WEB-INF/views/sensor_list.jsp";
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("sensor",new Sensor());
        return "/WEB-INF/views/sensor_add.jsp";
    }

    @RequestMapping("/json")
    public void list(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Sensor> list = sensorWork.getAll();
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        List<Sensor> list1 = sensorWork.getAll();
        JSONArray jsonArray = JSONArray.fromObject(list1);
        out.print(jsonArray.toString());
        out.flush();
        out.close();
    }

    @RequestMapping("/add")
    public String add(Sensor sensor){
        sensorWork.add(sensor);
        return "redirect:list";
    }

    @RequestMapping(value = "/remove",params = "id")
    public String remove(Integer id){
        sensorWork.remove(id);
        return "redirect:list";
    }

    @RequestMapping("/to_send")
    public String toSend(){
        return "/WEB-INF/views/sensor_control.jsp";
    }

    @RequestMapping(value = "/send",params = "request")
    public String send(String request){
        String oldRequest = "00";
        String newRequest = request;
        SerialPortUtils serialPort = SerialPortUtils.getIsSerialPort();
        //去掉空格
        String EXECUTEB = serialPort.sensor.get(Contact.SENSOR_EXECUTEB).replace(" ","");
        if (request.equals("00")){
            serialPort.sendToPort(EXECUTEB,newRequest);
            return "/WEB-INF/views/sensor_control.jsp";
        }
        if (!serialPort.dataAll.get(serialPort.sensor.get(Contact.SENSOR_EXECUTEB)).equals(oldRequest)){
            oldRequest = serialPort.dataAll.get(serialPort.sensor.get(Contact.SENSOR_EXECUTEB));
            int oldNum = Integer.valueOf(oldRequest);
            int newNum = Integer.valueOf(request);
            Integer tempNum = oldNum | newNum;
            newRequest = "0" + Integer.toHexString(tempNum);
        }
        if (serialPort.dataAll.get(serialPort.sensor.get(Contact.SENSOR_EXECUTEB)).equals("09")|
                serialPort.dataAll.get(serialPort.sensor.get(Contact.SENSOR_EXECUTEB)).equals("01")|
                serialPort.dataAll.get(serialPort.sensor.get(Contact.SENSOR_EXECUTEB)).equals("08")){
            oldRequest = serialPort.dataAll.get(serialPort.sensor.get(Contact.SENSOR_EXECUTEB));
            int oldNum = Integer.valueOf(oldRequest);
            int newNum = Integer.valueOf(request);
            Integer tempNum = oldNum ^ newNum;
            newRequest = "0" + Integer.toHexString(tempNum);
        }
        serialPort.sendToPort(EXECUTEB,newRequest);
        return "/WEB-INF/views/sensor_control.jsp";
    }
}
