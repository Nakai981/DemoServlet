/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuce.auth;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Phan
 */
public class LoginFilter implements Filter{
    private FilterConfig fc;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest hsr = (HttpServletRequest)request;
        HttpServletResponse hsr1 = (HttpServletResponse)response;
        HttpSession hs = hsr.getSession();

        HttpSession session = hsr.getSession();
        session.setAttribute("username", hsr.getParameter("username"));
        session.setAttribute("password", hsr.getParameter("password"));
        
        String checkUser = this.fc.getInitParameter("user");
        String checkPass = this.fc.getInitParameter("pass");
        String user = hsr.getParameter("username") ;
        if(user.equals(checkUser)){
            chain.doFilter(request, response);
            
        }else{
            hsr1.sendRedirect(hsr.getContextPath()+"/demo");
        }
        
        
    }

    @Override
    public void destroy() {
    }
    
}
