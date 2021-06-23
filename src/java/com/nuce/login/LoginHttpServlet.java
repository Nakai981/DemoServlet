/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuce.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Phan
 */
//@WebServlet(name="login",urlPatterns = "/demo")
public class LoginHttpServlet extends HttpServlet{
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
//        String username = request.getParameter("username");        
//        String password = request.getParameter("password");
//        
        ServletConfig cof = getServletConfig();
         HttpSession session = request.getSession(false);
            
//            
        if(session.getAttribute("username").equals(cof.getInitParameter("username")) && session.getAttribute("password").equals(cof.getInitParameter("password"))){
//            List<Cookie> ck = new ArrayList<>();
//            ck.add(new Cookie("username",cof.getInitParameter("username")));
//            ck.add(new Cookie("password",cof.getInitParameter("password")));
//            response.addCookie(ck.get(0));
//            response.addCookie(ck.get(1));

//            HttpSession session = request.getSession();
//            session.setAttribute("username", cof.getInitParameter("username"));
//            session.setAttribute("password", cof.getInitParameter("password"));
//            
            response.sendRedirect(request.getContextPath()+"/wellcome");
          
        }else{
            response.sendRedirect(request.getContextPath()+"/");

        }
    }
}
