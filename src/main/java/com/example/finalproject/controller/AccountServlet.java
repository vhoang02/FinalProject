package com.example.finalproject.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.finalproject.beans.User;
import com.example.finalproject.models.UserModel;
import com.example.finalproject.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "AccountServlet", value = "/Account/*")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path){
            case "/Register":
                ServletUtils.forward("/views/Login-Register/Register.jsp", request, response);
                break;
            case "/Login":
                ServletUtils.forward("/views/Login-Register/Login.jsp", request, response);
                break;
            case "/Profile":
                ServletUtils.forward("/",request,response);
            case "/IsAvailable":
                String username = request.getParameter("user");
                User user = UserModel.findByUsername(username);
                boolean isAvailable = (user == null);

                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");

                out.print(isAvailable);
                out.flush();
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path){
            case "/Register":
                registerUser(request, response);
                break;
            case "/Login":
                login(request,response);
                break;
            case "/Logout":
                logout(request,response);
                break;
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setCharacterEncoding("utf-8");
        String rawpwd = request.getParameter("rawpwd");
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, rawpwd.toCharArray());

        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String second_name = request.getParameter("second_name");
        String email = request.getParameter("email");
        String re_pass = request.getParameter("re_pass");


        String strDob = request.getParameter("dob") + " 00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dob = LocalDateTime.parse(strDob, df);

        LocalDateTime issue_at = LocalDateTime.now();

        int expiration = 7;
        int role = 0;

        String otp = null;
        LocalDateTime otp_exp = null;

        User c = new User(0, username, bcryptHashString, name, issue_at, expiration,role, second_name, dob, email, otp, otp_exp);
        UserModel.add(c);
        ServletUtils.forward("/views/Login-Register/Register.jsp", request,response);

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.setAttribute("auth", false);
        session.setAttribute("authUser", new User());

        String url = request.getHeader("referer");
        if(url == null)
            url = "/Home";
        ServletUtils.redirect(url, request, response);
    }
}
