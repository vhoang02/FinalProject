package com.example.finalproject.controller;

import com.example.finalproject.beans.Articles;
import com.example.finalproject.beans.Category;
import com.example.finalproject.beans.Tag;
import com.example.finalproject.service.ArticleService;
import com.example.finalproject.service.CategoryService;
import com.example.finalproject.service.TagService;
import com.example.finalproject.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "WriterProjectServlet", value = "/Writer/Project/*")
public class WriterProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }

        switch (path) {
            case "/Index":
                int wId = 1;
                /*int wId = Integer.parseInt(request.getParameter("wId"));*/
                List<Articles> list = ArticleService.getBywId(wId);
                int countArt = ArticleService.countByEID(wId);
                int coutDraft = ArticleService.countDrafPubByWid(wId,100001);
                int countPub = ArticleService.countDrafPubByWid(wId,100002);
                request.setAttribute("allart", list);
                request.setAttribute("countArt", countArt);
                request.setAttribute("coutDraft", coutDraft);
                request.setAttribute("countPub", countPub);
                ServletUtils.forward("/views/vwWriter/Writer-project.jsp", request, response);
                break;
            case "/Add":
                int id = Integer.parseInt(request.getParameter("wId"));
                List<Category> cateList = CategoryService.getAll();
                List<Tag> listTag = TagService.findAll();
                request.setAttribute("category", cateList);
                request.setAttribute("tags", listTag);
                ServletUtils.forward("/views/vwWriter/Writer-project-add.jsp", request, response);
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
