package com.example.finalproject.controllers;

import com.example.finalproject.beans.Tag;
import com.example.finalproject.service.TagService;
import com.example.finalproject.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminTagServlet", value = "/Admin/Tag/*")
public class AdminTagServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String path = request.getPathInfo();
      if (path == null || path.equals("/")) {
        path = "/Index";
      }

      switch (path) {
        case "/Index":

          List<Tag> list = TagService.findAll();
          request.setAttribute("tags", list);
            ServletUtils.forward("/views/vwDashboard/Admin-tag.jsp", request, response);
          break;

  //      case "/HomeTag":
  //        ServletUtils.forward("/views/vwTags/HomeTag.jsp", request, response);
  //        break;


        case "/Add":
          ServletUtils.forward("/views/vwTags/Add.jsp", request, response);
          break;

        case "/Edit":
          int id = 0;
          try {
            id = Integer.parseInt(request.getParameter("id"));
          } catch (NumberFormatException e) {
          }

          Tag c = TagService.findById(id);
          if (c != null) {
            request.setAttribute("tag", c);
            ServletUtils.forward("/views/vwTags/Edit.jsp", request, response);
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
        addTag(request, response);
        break;

      case "/Delete":
        deleteTag(request, response);
        break;

      case "/Update":
        updateTag(request, response);
        break;

      default:
        ServletUtils.forward("/views/404.jsp", request, response);
        break;
    }
  }

  private void addTag(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("value");
    Tag c = new Tag(name);
    TagService.add(c);
    ServletUtils.forward("/views/vwTags/Add.jsp", request, response);
  }

  private void updateTag(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    int id = Integer.parseInt(request.getParameter("tag_id"));
    String name = request.getParameter("value");
    Tag c = new Tag(id, name);
    TagService.update(c);
    ServletUtils.redirect("/Admin/Tag", request, response);
  }

  private void deleteTag(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("tag_id"));
    TagService.delete(id);
    ServletUtils.redirect("/Admin/Tag", request, response);
  }

}
