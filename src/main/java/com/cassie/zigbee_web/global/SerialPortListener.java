package com.cassie.zigbee_web.global;
import com.cassie.zigbee_dao.entity.ErrorSensor;
import com.cassie.zigbee_dao.entity.Sensor;
import com.cassie.zigbee_dao.global.Contact;
import com.cassie.zigbee_web.serialports.SerialPortUtils;
import com.cassie.zigbee_web.untils.DBUtils;
import com.cassie.zigbee_work.work.SensorWork;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class SerialPortListener implements ServletContextListener {

    /**
     * 当web容器启动时，首先执行监听器的初始化方法（即本方法）
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final SerialPortUtils serialPort = SerialPortUtils.getIsSerialPort();
        serialPort.openSerialPort();
        final SensorWork sensorWork = null;

        // 定义一个实现一个Runnable接口的类，重写该类的run()方法。该类作为 Thread() 的参数传入，用于开启一条新线程
        class StorageData implements Runnable{
            private double humi;
            private double temp;
            private double light;

            public StorageData(String temp,String humi,String light){

                String[] humis = humi.split(" ");
                int humiCal = Integer.parseInt(humis[1] + humis[0],16);
                this.humi = humiCal / 100.0;

                String[] temps = temp.split(" ");
                int tempCal = Integer.parseInt(temps[1] + temps[0],16);
                this.temp = tempCal / 100.0;

                String[] lights = light.split(" ");
                int lightCal = Integer.parseInt(lights[1] + lights[0],16);
                this.light = lightCal / 100.0;

            }

            @Override
            public void run() {
                String test = serialPort.dataAll.get(serialPort.sensor.get(Contact.SENSOR_TEMP));
                System.out.println("");
                StorageData sd = new StorageData(
                        serialPort.dataAll.get(serialPort.sensor.get(Contact.SENSOR_TEMP)), // String temp
                        serialPort.dataAll.get(serialPort.sensor.get(Contact.SENSOR_HUMI)),
                        serialPort.dataAll.get(serialPort.sensor.get(Contact.SENSOR_LIGHT)));
                String tempd = String.valueOf(sd.temp);
                String humid = String.valueOf(sd.humi);
                String lightd = String.valueOf(sd.light);
                double error_temp = Double.parseDouble(tempd);
                double error_light = Double.parseDouble(lightd);
                Date date = new Date();
                SimpleDateFormat simDate = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
                String dated = simDate.format(date);
                String request = "01";
                String EXECUTEB = serialPort.sensor.get(Contact.SENSOR_EXECUTEB).replace(" ","");  //去掉空格
                if (error_temp > 580 | error_light < 200){
                    String error_info = "";
                    if (error_temp > 580 & error_light < 200){
                        error_info = "温度过高，光照强度过低";
                    }else if (error_temp > 580 & error_light > 200){
                        error_info = "温度过高";
                    }else if (error_temp < 580 & error_light < 200){
                        error_info = "光照强度过低";
                    }
                    if (!serialPort.dataAll.get(serialPort.sensor.get(Contact.SENSOR_EXECUTEB)).equals(request)){
                        serialPort.sendToPort(EXECUTEB,"09");
                    }
                    ErrorSensor errorSensor = new ErrorSensor(dated,tempd,lightd,error_info);
                    DBUtils.insertError(errorSensor);
                }else {
                    serialPort.sendToPort(EXECUTEB,"00");
                }
                System.out.println("湿度：" + humid + "。温度：" + tempd + "。时间：" + dated + "。光照度：" + lightd);
                Sensor sensor = new Sensor(dated,tempd,humid,lightd);
                DBUtils.insert(sensor);

            }
        }


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    while (true){
//                        Thread.sleep(1000);
//                        String str = serialPort.sensor.get(Contact.SENSOR_TEMP); // debug TODO
//                        Map tempMap = serialPort.dataAll;
//                        String test = serialPort.dataAll.get(serialPort.sensor.get(Contact.SENSOR_TEMP));
//                        new Thread(new StorageData(
//                                serialPort.dataAll.get(serialPort.sensor.get(Contact.SENSOR_TEMP)),
//                                serialPort.dataAll.get(serialPort.sensor.get(Contact.SENSOR_HUMI)),
//                                serialPort.dataAll.get(serialPort.sensor.get(Contact.SENSOR_LIGHT))
//                        )).start();
//                    }
//                } catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    new Thread(new StorageData(serialPort.dataAll.get(serialPort.sensor.get(Contact.SENSOR_TEMP)),
                            serialPort.dataAll.get(serialPort.sensor.get(Contact.SENSOR_HUMI)),
                            serialPort.dataAll.get(serialPort.sensor.get(Contact.SENSOR_LIGHT)))).start();
                }
            }
        }).start();
   }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        SerialPortUtils.closePort(SerialPortUtils.mSerialPort);
    }
}

