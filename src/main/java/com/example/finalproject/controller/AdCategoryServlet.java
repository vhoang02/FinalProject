package com.example.finalproject.controller;

import com.example.finalproject.beans.Category;
import com.example.finalproject.beans.User;
import com.example.finalproject.service.CategoryService;
import com.example.finalproject.service.UserService;
import com.example.finalproject.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdCategoryServlet", value = "/Admin/Category/*")
public class AdCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }

        switch (path) {
            case "/Index":
                List<Category> list = CategoryService.getAll();
                int count = CategoryService.countCat();
                request.setAttribute("categories", list);
                request.setAttribute("count", count);
                ServletUtils.forward("/views/vwDashboard/Admin-category.jsp", request, response);
                break;

            case "/Add":
                response.setContentType("text/html;charset=UTF-8");
                request.setCharacterEncoding("UTF-8");
                List<User> listU = UserService.getAll();
                request.setAttribute("editor", listU);
                ServletUtils.forward("/views/vwDashboard/Admin-category-add.jsp", request, response);
                break;

            case "/Edit":
                int id = 0;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                } catch (NumberFormatException ignored) {
                }

                Category c = CategoryService.get(id);
                if (c != null) {
                    request.setAttribute("category", c);
                    ServletUtils.forward("/views/vwDashboard/Admin-category-edit.jsp", request, response);
                } else {
                    ServletUtils.redirect("/Admin/Category", request, response);
                }
                break;

            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path) {
            case "/Add":
                addCategory(request, response);
                break;

            case "/Delete":
                deleteCategory(request, response);
                break;

            case "/Update":
                updateCategory(request, response);
                break;

            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }

    private static void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("CatName");
        String parId = request.getParameter("parID");
        int pid = Integer.parseInt(parId);

        Category c = new Category(0, name, pid);
        CategoryService.add(c);
        ServletUtils.forward("/views/vwDashboard/Admin-category-add.jsp", request, response);
    }

    private static void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("CatID"));
        CategoryService.delete(id);
        ServletUtils.redirect("/Admin/Category", request, response);
    }

    private static void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("CatID"));
        String name = request.getParameter("CatName");
        String parId = request.getParameter("parID");
        int pid = Integer.parseInt(parId);
        Category c = new Category(id, name, pid);
        CategoryService.update(c);
        ServletUtils.redirect("/Admin/Category", request, response);
    }
}
