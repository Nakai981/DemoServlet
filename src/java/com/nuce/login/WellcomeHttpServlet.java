/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuce.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Phan
 */
public class WellcomeHttpServlet extends HttpServlet{
    
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
    
        response.setContentType("text/html"); 
//        Cookie ck[] = request.getCookies();
//        try{
//             if (ck[0].getValue().equals("") || ck[0].getValue() == null){
//                response.sendRedirect(request.getContextPath());
//            }else{
//                RequestDispatcher rd = request.getRequestDispatcher("link.html");
//                PrintWriter pw = response.getWriter();
//                pw.print("Hello,"+ ck[0].getValue());
//                rd.include(request, response);
//                pw.close();
//            }
//            
//        }catch(Exception e){
//            response.sendRedirect(request.getContextPath());
//        }
       
        
        try{
            HttpSession session = request.getSession(false);
            String username = (String) session.getAttribute("username");
            if (username.equals("")|| username == null || !username.equals("user")){
                response.sendRedirect(request.getContextPath());
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("link.html");
                PrintWriter pw = response.getWriter();
                pw.print("Hello,"+ username);
                rd.include(request, response);
                pw.close();
            }
        }catch(Exception e){
             response.sendRedirect(request.getContextPath());
        }
        
        }
}
