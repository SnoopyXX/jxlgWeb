package com.jxlg.service;

import com.jxlg.dao.ClazzDO;
import com.jxlg.entity.Clazz;

import java.util.ArrayList;
import java.util.List;

public class ClazzService {
    ClazzDO clazzDO = new ClazzDO();

    /*
        @param id 用户填写id
        @param name 用户填写的name
     */
    public boolean isLogin(String id,String name){
        //1  获取id和name,将他们放到一个list对象里面
        List<Object> list = new ArrayList<Object>();
        list.add(id);
        list.add(name);
        //2 调用findClazz的方法来执行查询，查询的结果是方法一个Clazz对象
        Clazz clazz = clazzDO.findClazz(list);
        //3 根据返回的clazz对象来做判断，如果true，表示判断通过
        if (clazz != null & name.equals(clazz.getName())){
            return true;
        }
        return false;
    }

    /*
        condition 有内容，根据condition做条件查询
        无内容，做全查
     */
    public List<Clazz> findAll(String condition){
        List<Object> list = new ArrayList<Object>();
        list.add(condition);
        List<Clazz> clazzes = clazzDO.findAll(list);
        return clazzes;
    }
}
