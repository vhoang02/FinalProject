package com.example.finalproject.controller;

import com.example.finalproject.beans.Articles;
import com.example.finalproject.beans.Category;
import com.example.finalproject.service.ArticleService;
import com.example.finalproject.service.CategoryService;
import com.example.finalproject.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/Home/*")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }
        switch (path) {
            case "/Index":
                List<Articles> listtop3 = ArticleService.getTop3InWeek();
                List<Articles> listtop10view = ArticleService.getTop10();
                List<Articles> listtop10new = ArticleService.getTop10new();
                List<Category> listAllCate = CategoryService.getAll();
                request.setAttribute("listtop10new", listtop10new);
                request.setAttribute("listtop3", listtop3);
                request.setAttribute("listtop10view", listtop10view);
                request.setAttribute("listAllCate", listAllCate);
                ServletUtils.forward("/views/vwHome/Index.jsp", request, response);
                break;
            case "/Contact":
                ServletUtils.forward("/views/vwHome/Contact.jsp", request, response);
                break;
            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
