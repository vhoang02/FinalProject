package com.example.finalproject.controller;

import com.example.finalproject.beans.Articles;
import com.example.finalproject.beans.Category;
import com.example.finalproject.service.ArticleService;
import com.example.finalproject.service.CategoryService;
import com.example.finalproject.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ArticleServlet", value = "/Article/*")
public class ArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path) {
            case "/ByCat":
                int catId = Integer.parseInt(request.getParameter("id"));
                List<Articles> listByCat = ArticleService.getByCatID(catId);
                request.setAttribute("listByCat", listByCat);
                ServletUtils.forward("/views/vwHome/detail.jsp", request, response);
                break;
            case "/Detail":
                int article_id = Integer.parseInt(request.getParameter("id"));
                Articles article = ArticleService.get(article_id);
                if (article == null) {
                    ServletUtils.redirect("/Home", request, response);
                } else {
                    request.setAttribute("article", article);
                    ServletUtils.forward("/views/vwHome/detail.jsp", request, response);
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
