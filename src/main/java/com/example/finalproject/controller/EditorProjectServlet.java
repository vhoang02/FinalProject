package com.example.finalproject.controller;

import com.example.finalproject.beans.Articles;
import com.example.finalproject.service.ArticleService;
import com.example.finalproject.service.CategoryService;
import com.example.finalproject.service.CommentService;
import com.example.finalproject.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditorProjectServlet", value = "/Editor/Project/*")
public class EditorProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }

        switch (path) {
            case "/Index":
                int eId = Integer.parseInt(request.getParameter("eId"));
                List<Articles> list = ArticleService.getByEditor(eId);
                int countArt = ArticleService.countByEID(eId);
                int coutDraft = ArticleService.countDraftByEID(eId);
                int countPub = ArticleService.countPubByEID(eId);
                int countPubPre = ArticleService.countPreByeID(eId);
                int countCat = CategoryService.countCatByEId(eId);
                request.setAttribute("allart", list);
                request.setAttribute("countArt", countArt);
                request.setAttribute("coutDraft", coutDraft);
                request.setAttribute("countPub", countPub);
                request.setAttribute("countPubPre", countPubPre);
                request.setAttribute("countCat", countCat);


                ServletUtils.forward("/views/vwEditorManager/Editor-project.jsp", request, response);
                break;

            case "/Delete":
                deleteArticle(request,response);
                break;
            case "/Detail":
                int id = 0;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                } catch (NumberFormatException ignored) {
                }
                String eid = request.getParameter("eId");
                Articles c = ArticleService.get(id);
                if (c != null) {
                    request.setAttribute("dtl", c);
                    ServletUtils.forward("/views/vwEditorManager/Editor-project-edit.jsp", request, response);
                } else {
                    ServletUtils.redirect("/Editor/Project?eId="+eid, request, response);
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
        String eid = request.getParameter("eId");
        ArticleService.UpdateDraft(id);
        ServletUtils.redirect("/Editor/Project?eId="+eid, request, response);
    }

    private void deleteArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String eid = request.getParameter("eId");
        ArticleService.Delete(id);
        CommentService.DeleteByAID(id);
        ServletUtils.redirect("/Editor/Project?eId="+eid, request, response);
    }
}
