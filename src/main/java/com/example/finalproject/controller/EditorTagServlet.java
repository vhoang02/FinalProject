package com.example.finalproject.controller;

import com.example.finalproject.beans.Tag;
import com.example.finalproject.beans.TagHasArticles;
import com.example.finalproject.service.TagHasArtService;
import com.example.finalproject.service.TagService;
import com.example.finalproject.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditorTagServlet", value = "/Editor/Tag/*")
public class EditorTagServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }

        switch (path) {
            case "/Index":
                int editID = 3;
                /*int editID = Integer.parseInt(request.getParameter("editID"));*/
                List<TagHasArticles> listTagArt = TagHasArtService.getByEditor(editID);
                List<Tag> list = TagService.findAll();
                int t = TagService.counTag();
                request.setAttribute("tags", list);
                request.setAttribute("count", t);
                request.setAttribute("ltag", listTagArt);
                ServletUtils.forward("/views/vwEditorManager/Editor-tag.jsp", request, response);
                break;

            case "/Add":
                ServletUtils.forward("/views/vwEditorManager/Editor-tag-add.jsp", request, response);
                break;
            case "/Delete":
                deleteTag(request, response);
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
                addTags(request, response);
                break;

            case "/Update":
                updateTag(request, response);
                break;

            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }

    private static void addTags(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String val = request.getParameter("TagVal");
        Tag t = new Tag(0, val);
        TagService.addTag(t);
        ServletUtils.forward("/views/vwEditorManager/Editor-tag-add.jsp", request, response);
    }


    private static void updateTag(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("TagID"));
        String name = request.getParameter("TagVal");
        Tag c = new Tag(id, name);
        TagService.update(c);
        ServletUtils.redirect("/Editor/Tag", request, response);
    }

    private static void deleteTag(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("TagID"));
        TagHasArtService.delete(id);
        ServletUtils.redirect("/Editor/Tag", request, response);
    }
}

