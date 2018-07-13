package com.jxlg.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/*
       接收页面的请求，并将服务器的响应返回给页面

       jsp页面  --------  数据库操作代码(jdbc)
       jsp页面  -----> servlet <------jdbc
 */
@WebServlet(name = "FirstServlet",value = "/first")
public class FirstServlet extends HttpServlet {

    /*
        jsp页面请求的方法是post方法
        doPost()方法里面写请求的处理逻辑
 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("userpwd");
        String sex = request.getParameter("sex");
        String[] inters = request.getParameterValues("interster");
        String address = request.getParameter("address");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");

        out.print("姓名是：" + name + "<br/>");
        out.println("密码是：" + password +"<br/>");
        out.println("性别是:" + sex +"<br/>");
        out.println("地址是:" + address +"<br/>");
        out.println("兴趣是：");
        for (int i = 0; i < inters.length; i++) {
            out.println(inters[i]);
        }
    }

    /*
            jsp页面请求的方法是get方法
            doGet()方法里面写请求的处理逻辑
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("userpwd");
        /*
            request 对象传递的数据 只能在两个页面或者servlet之间传递
         */
        request.setAttribute("name",name);
        request.setAttribute("pwd",password);
        /*
            session 会话
         */
        HttpSession session = request.getSession();
        session.setAttribute("username",name);
        session.setAttribute("userpwd",password);

        if(name.equals("admin") && password.equals("123")){
            response.sendRedirect("banner.jsp");//页面跳转，重定向
            //请求转发 传递数据
//            request.getRequestDispatcher("banner.jsp")
//                                        .forward(request,response);
        }else{
            response.sendRedirect("index.jsp");
        }
    }
}
