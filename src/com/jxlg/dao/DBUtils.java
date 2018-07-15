package com.jxlg.dao;

import java.sql.*;
import java.util.List;

public class DBUtils {

    Connection connection = null;
    PreparedStatement pspt = null;
    ResultSet rs = null;
    //获取连接对象
    public DBUtils(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
            //2 创建Connection对象
            connection =
                    DriverManager.getConnection(url,"root",
                            "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //获取PrepareStatement对象
    public PreparedStatement getPre(String sql,Object[] objects){
        try {
            pspt = connection.prepareStatement(sql);
            for (int i = 0; i <objects.length; i++) {
                pspt.setObject(i+1,objects[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pspt;
    }

    //新增、删除、修改操作
    public int doUpdate(String sql,Object[] objects){
        int result = 0;
        try {
            pspt = connection.prepareStatement(sql);
            for (int i = 0; i <objects.length; i++) {
                pspt.setObject(i+1,objects[i]);
            }
            result = pspt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultSet find(String sql,List<Object> objects){
        try {
            pspt = connection.prepareStatement(sql);
            if(sql.contains("like")){
                for (int i = 0; i <objects.size(); i++) {
                    pspt.setObject(i+1,"%"+objects.get(i)+"%");
                }
            }else{
                for (int i = 0; i <objects.size(); i++) {
                    pspt.setObject(i+1,objects.get(i));
                }
            }
            rs = pspt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //获取ResultSet对象
    public ResultSet getResultSet(){
        try {
            rs = pspt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //关闭所有的对象
    public void close(){
        try {
            rs.close();
            pspt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
