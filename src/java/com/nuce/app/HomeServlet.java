/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuce.app;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

/**
 *
 * @author Phan
 */
public class HomeServlet implements Servlet{
    ServletConfig conf;
    
    public void init(ServletConfig conf){
        this.conf = conf;
        System.out.println("1");
    }
    
    public void service(ServletRequest req, ServletResponse resp) throws ServletException,IOException{
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeServlet at  ");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public void destroy(){
        System.out.println("3");
    }
    public ServletConfig getServletConfig(){
        return this.conf;
    }
    public String getServletInfo(){
        return "anime";
    }
}
