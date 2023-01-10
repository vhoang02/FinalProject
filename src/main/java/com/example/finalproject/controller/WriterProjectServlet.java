package com.example.finalproject.controller;

import com.example.finalproject.beans.*;
import com.example.finalproject.service.ArticleService;
import com.example.finalproject.service.CategoryService;
import com.example.finalproject.service.TagHasArtService;
import com.example.finalproject.service.TagService;
import com.example.finalproject.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "WriterProjectServlet", value = "/Writer/Project/*")
@MultipartConfig(
        fileSizeThreshold = 2 * 1024 * 1024,
        maxFileSize = 50 * 1024 * 1024,
        maxRequestSize = 50 * 1024 * 1024
)
public class WriterProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }

        switch (path) {
            case "/Index":
                HttpSession session = request.getSession();
                User Author = (User) session.getAttribute("authUser");

                int wId = Author.getUser_id();
                List<Articles> list = ArticleService.getBywId(wId);
                int countArt = ArticleService.countByEID(wId);
                int coutDraft = ArticleService.countDrafPubByWid(wId, 100001);
                int countPub = ArticleService.countDrafPubByWid(wId, 100002);
                request.setAttribute("allart", list);
                request.setAttribute("countArt", countArt);
                request.setAttribute("coutDraft", coutDraft);
                request.setAttribute("countPub", countPub);
                ServletUtils.forward("/views/vwWriter/Writer-project.jsp", request, response);
                break;
            case "/Add":
                List<Category> cateList = CategoryService.getAll();
                List<Tag> listTag = TagService.findAll();
                request.setAttribute("category", cateList);
                request.setAttribute("tags", listTag);
                ServletUtils.forward("/views/vwWriter/Writer-project-Add.jsp", request, response);
                break;
            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Add";
        }
        switch (path) {
            case "/Add":
                postArticles(request, response);
                postTagArticle(request,response);
                break;
            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }

    private void postArticles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("tit");

        int views = 0;

        String abstracts = request.getParameter("abstr");
        String content = request.getParameter("cont");
        int caId = Integer.parseInt(request.getParameter("catID"));
        boolean premium = false;
        int pr = Integer.parseInt(request.getParameter("pre"));
        if (pr == 0) {
            premium = false;
        } else if (pr == 1) {
            premium = true;
        }

        HttpSession session = request.getSession();
        User Author = (User) session.getAttribute("authUser");

        int writer_id = Author.getUser_id();
        int status_id = 100002;


        Articles a = new Articles(0, title, null, views, abstracts, content,
                caId, premium, writer_id, status_id);
        ArticleService.addNews(a);


        ServletUtils.redirect("/Writer/Project?wId="+writer_id, request, response);
    }
    private void postTagArticle(HttpServletRequest request, HttpServletResponse response) {
        Articles art = ArticleService.findArtNew();
        int article_id = art.getArticles_id();
        String[] tagValue = request.getParameterValues("value");
        int size = tagValue.length;
        for (int i=0 ;i<size;i++){
            Tag tag = TagService.findByval(tagValue[i]);
            int tags_id = tag.getTag_id();

            TagHasArticles t = new TagHasArticles(0,tags_id,article_id);
            TagHasArtService.addTagInArt(t);
        }
    }
}
