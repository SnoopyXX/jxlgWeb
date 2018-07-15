package com.jxlg.dao;

import com.jxlg.entity.Clazz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClazzDO {

    //新增
    public int save(Clazz clazz){
        int result = 0;
        String[] objs = {clazz.getId(),clazz.getName()};
        try {
            result= new DBUtils().getPre("insert into clazz values(?,?)",objs).executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    //修改
    public int update(Clazz clazz){
        int result = 0;
        String[] objs = {clazz.getName(),clazz.getId()};
        try {
            result= new DBUtils().getPre("update clazz set name = ? where id = ?",objs).executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    //删除
    public int delete(String id){
        int result = 0;
        String[] objs = {id};
        return result= new DBUtils().doUpdate("delete from clazz where id = ?",objs);
    }


    //查询
    public List<Clazz> find(List<Object> objects){
        List<Clazz> list = new ArrayList<Clazz>();
//        String[] objs = {condition};
        try {
            ResultSet rs = new DBUtils().find("select * from clazz where like ?",objects);
            while(rs.next()){
                Clazz clazz = new Clazz();
                clazz.setName(rs.getString(2));
                list.add(clazz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
