package com.cassie.zigbee_web.untils;

import com.cassie.zigbee_dao.entity.ErrorSensor;
import com.cassie.zigbee_dao.entity.Sensor;

import java.sql.*;

public class DBUtils {

    public final static String DRIVERNAME = "com.mysql.jdbc.Driver";  //加载JDBC驱动
    public final static String DBURL = "jdbc:mysql://localhost:3306/keshe?useSSL=false";
    public final static String USERNAME = "root";
    public final static String USERPASSWORD = "0328";

    public Statement statement = null;
    public ResultSet resultSet = null;

    private static Connection getConn(){
        Connection connection = null;
        try{
            Class.forName(DRIVERNAME);
            connection = DriverManager.getConnection(DBURL,USERNAME,USERPASSWORD);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    private static void close(Connection connection,PreparedStatement ps,ResultSet rs){
        try{
            if (rs != null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }
            if (connection != null){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }




    public static int insert(Sensor sensor){
        Connection connection = getConn();
        System.out.println(connection);



        int i = 0;
        String sql = "insert into sensor(time,temp,humi,light) values(?,?,?,?)";
        PreparedStatement pstmt = null;
        try{
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,sensor.getTime());
            pstmt.setString(2,sensor.getTemp());
            pstmt.setString(3,sensor.getHumi());
            pstmt.setString(4,sensor.getLight());

            i = pstmt.executeUpdate();
            pstmt.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    public static int insertError(ErrorSensor errorSensor){
        Connection connection = getConn();
        int i = 0;
        String sql = "insert into error(error_time,error_temp,error_light,error_info) values(?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,errorSensor.getError_time());
            pstmt.setString(2,errorSensor.getError_temp());
            pstmt.setString(3,errorSensor.getError_light());
            pstmt.setString(4,errorSensor.getError_info());

            i = pstmt.executeUpdate();
            pstmt.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }


}
