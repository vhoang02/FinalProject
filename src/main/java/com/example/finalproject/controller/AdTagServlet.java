package com.example.finalproject.controller;

import com.example.finalproject.beans.Tag;
import com.example.finalproject.service.TagService;
import com.example.finalproject.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdTagServlet", value = "/Admin/Tag/*")
public class AdTagServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }

        switch (path) {
            case "/Index":
                List<Tag> list = TagService.findAll();
                int t = TagService.counTag();
                request.setAttribute("tags", list);
                request.setAttribute("count", t);
                ServletUtils.forward("/views/vwDashboard/Admin-tag.jsp", request, response);
                break;

            case "/Add":
                ServletUtils.forward("/views/vwDashboard/Admin-tag-add.jsp", request, response);
                break;

            case "/Delete":
                deleteTag(request, response);
                break;

            case "/Edit":
                int id = 0;
                try {
                    id = Integer.parseInt(request.getParameter("TagID"));
                } catch (NumberFormatException ignored) {
                }

                Tag c = TagService.findById(id);
                if (c != null) {
                    request.setAttribute("Tagg", c);
                    ServletUtils.forward("/views/vwDashboard/Admin-tag-edit.jsp", request, response);
                } else {
                    ServletUtils.redirect("/Admin/Tag", request, response);
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
        ServletUtils.forward("/views/vwDashboard/Admin-tag-add.jsp", request, response);
    }

    private static void deleteTag(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("TagID"));
        TagService.delete(id);
        ServletUtils.redirect("/Admin/Tag", request, response);
    }

    private static void updateTag(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("TagID"));
        String name = request.getParameter("TagVal");
        Tag c = new Tag(id, name);
        TagService.update(c);
        ServletUtils.redirect("/Admin/Tag", request, response);
    }
}
