/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuce.login;

import java.io.IOException;
import java.io.PrintWriter;
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

public class LogoutHttpServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        Cookie ck1 = new Cookie("username", "");
//        Cookie ck2 = new Cookie("password", "");
//        ck1.setMaxAge(0);
//        ck2.setMaxAge(0);
//        response.addCookie(ck1);
//        response.addCookie(ck2);
        HttpSession session = request.getSession(false);
        session.setAttribute("username", "");
        session.setAttribute("password", "");

        response.sendRedirect(request.getContextPath());
    }
}
