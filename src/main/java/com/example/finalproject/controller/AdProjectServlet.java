package com.example.finalproject.controller;

import com.example.finalproject.beans.Articles;
import com.example.finalproject.beans.Category;
import com.example.finalproject.beans.User;
import com.example.finalproject.service.ArticleService;
import com.example.finalproject.service.CategoryService;
import com.example.finalproject.service.UserService;
import com.example.finalproject.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdProjectServlet", value = "/Admin/Project/*")
public class AdProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }

        switch (path) {
            case "/Index":
                List<Articles> list = ArticleService.findAll();
                int countArt = ArticleService.countArt();
                int coutDraft = ArticleService.countArtDraft();
                int countPub = ArticleService.countArtPublish();
                int countPubPre = ArticleService.countPubPre();
                int countDraftPre = ArticleService.countDraftPre();
                request.setAttribute("allart", list);
                request.setAttribute("countArt", countArt);
                request.setAttribute("coutDraft", coutDraft);
                request.setAttribute("countPub", countPub);
                request.setAttribute("countPubPre", countPubPre);
                request.setAttribute("countDraftPre", countDraftPre);
                ServletUtils.forward("/views/vwDashboard/Admin-project.jsp", request, response);
                break;

            case "/Detail":
                int id = 0;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                } catch (NumberFormatException ignored) {
                }

                Articles c = ArticleService.get(id);
                if (c != null) {
                    request.setAttribute("dtl", c);
                    ServletUtils.forward("/views/vwDashboard/Admin-project-add.jsp", request, response);
                } else {
                    ServletUtils.redirect("/Admin/Project", request, response);
                }
                break;
            case "/Delete":
                deleteArticle(request, response);
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
            case "/Public":
                updateDraft(request, response);
                break;

            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }

    private void updateDraft(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("artID"));
        ArticleService.UpdateDraft(id);
        ServletUtils.redirect("/Admin/Project", request, response);
    }

    private void deleteArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ArticleService.Delete(id);
        ServletUtils.redirect("/Admin/Delete", request, response);
    }



}
