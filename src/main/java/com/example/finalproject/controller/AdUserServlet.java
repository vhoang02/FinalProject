package com.example.finalproject.controller;

import com.example.finalproject.beans.User;
import com.example.finalproject.service.UserService;
import com.example.finalproject.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdUserServlet", value = "/Admin/Account/*")
public class AdUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }

        switch (path) {
            case "/Index":


                List<User> list = UserService.getAll();
                request.setAttribute("listUser", list);
                ServletUtils.forward("/views/vwDashboard/Admin-account.jsp", request, response);
                break;

            /*case "/Add":
                ServletUtils.forward("/views/vwCategory/Add.jsp", request, response);
                break;

            case "/Edit":
                int id = 0;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                } catch (NumberFormatException e) {
                }

                Category c = CategoryModel.findById(id);
                if (c != null) {
                    request.setAttribute("category", c);
                    ServletUtils.forward("/views/vwCategory/Edit.jsp", request, response);
                } else {
                    ServletUtils.redirect("/Admin/Category", request, response);
                    // ServletUtils.forward("/views/204.jsp", request, response);
                }
                break;*/

            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
