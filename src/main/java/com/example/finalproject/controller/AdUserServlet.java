package com.example.finalproject.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.finalproject.beans.Articles;
import com.example.finalproject.beans.Tag;
import com.example.finalproject.beans.User;
import com.example.finalproject.service.*;
import com.example.finalproject.utils.ServletUtils;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "AdUserServlet", value = "/Admin/Account/*")
public class AdUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }

        switch (path) {
            case "/Index":


                List<User> list = UserService.getAll();
                int count = UserService.countUser();
                int countAd = UserService.countAdmin();
                int countEd = UserService.countEditor();
                int countWr = UserService.countWriter();
                int countRd = UserService.countReader();
                request.setAttribute("listUser", list);
                request.setAttribute("count", count);
                request.setAttribute("countAd", countAd);
                request.setAttribute("countEd", countEd);
                request.setAttribute("countWr", countWr);
                request.setAttribute("countRd", countRd);
                ServletUtils.forward("/views/vwDashboard/Admin-account.jsp", request, response);
                break;

            case "/Download":
                int id = 0;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                } catch (NumberFormatException e) {
                }
                User u = UserService.get(id);
                response.setContentType("application/pdf");

                LocalDateTime i = u.getIssue_at();
                LocalDateTime d = u.getDob();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
                String birth = d.format(formatter);
                String iss = i.format(formatter);

                response.setHeader(
                        "Content-disposition",
                        "inline; filename='User.pdf'");
                try {

                    Document document = new Document();
                    PdfWriter.getInstance(
                            document, response.getOutputStream());

                    document.open();
                    document.add(new Paragraph(
                            "User Information"));
                    document.add(new Paragraph("ID: " + u.getUser_id()));
                    document.add(new Paragraph("Username: " + u.getUsername()));
                    document.add(new Paragraph("Password: " + u.getPassword()));
                    document.add(new Paragraph("Name: " + u.getName()));
                    document.add(new Paragraph("Issue at: " + iss));
                    document.add(new Paragraph("Exp: " + u.getExpiration()));
                    document.add(new Paragraph("Role? 0:Admin - 1: Editor - 2: Writer - 3: Reader"));
                    document.add(new Paragraph("Role: " + u.getRole()));
                    document.add(new Paragraph("2nd Name: " + u.getSecond_name()));
                    document.add(new Paragraph("Dob: " + birth));
                    document.add(new Paragraph("Email: " + u.getEmail()));

                    document.close();
                } catch (DocumentException de) {
                    throw new IOException(de.getMessage());
                }
                ServletUtils.redirect("/Admin/Account", request, response);
                break;
            case "/IsAvailable":
                String username = request.getParameter("user");
                User user = UserService.getByUName(username);
                boolean isAvailable = (user == null);

                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");

                out.print(isAvailable);
                out.flush();
                break;
            case "/Add":
                ServletUtils.forward("/views/vwDashboard/Admin-account-Add.jsp", request, response);
                break;


            case "/Edit":
                int uId = 0;
                try {
                    uId = Integer.parseInt(request.getParameter("uID"));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd LLLL yyyy");
                User us = UserService.get(uId);
                String begin = us.getIssue_at().format(fm);
                String birthD = us.getDob().format(fm);
                String ro = null;
                if (us.getRole() == 0) {
                    ro = "Admin";
                } else if (us.getRole() == 1) {
                    ro = "Editor";
                } else if (us.getRole() == 2) {
                    ro = "Writer";
                } else if (us.getRole() == 3) {
                    ro = "Reader";
                }


                if (us != null) {
                    request.setAttribute("user", us);
                    request.setAttribute("begin", begin);
                    request.setAttribute("birthD", birthD);
                    request.setAttribute("rol", ro);
                    ServletUtils.forward("/views/vwDashboard/Admin-account-edit.jsp", request, response);
                } else {
                    ServletUtils.redirect("/Admin/Account", request, response);
                }
                break;
            case "/Delete":
                deleteUser(request, response);
                break;
            case "/GetPremium":
                getPremium(request, response);
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
                addUser(request, response);
                break;

            case "/Update":
                updateUser(request, response);
                break;

            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String rawpwd = request.getParameter("txtPass");
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, rawpwd.toCharArray());

        String strDob = request.getParameter("txtDob") + " 00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dob = LocalDateTime.parse(strDob, df);
        int exp = Integer.parseInt(request.getParameter("txtExp"));
        int rol = Integer.parseInt(request.getParameter("txtRole"));
        String secName = request.getParameter("txtSec");
        String username = request.getParameter("txtUser");
        String name = request.getParameter("txtName");
        String email = request.getParameter("txtEmail");
        User n = new User(0, username, bcryptHashString, name, dob, exp, rol, secName, dob, email, name, dob);
        UserService.add(n);
        ServletUtils.forward("/views/vwDashboard/Admin-account-edit.jsp", request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("txtID"));
        String rawpwd = request.getParameter("txtPass");
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, rawpwd.toCharArray());
        int exp = Integer.parseInt(request.getParameter("txtExp"));
        int rol = Integer.parseInt(request.getParameter("txtRole"));
        String secName = request.getParameter("txtSec");
        String username = request.getParameter("txtUser");
        String name = request.getParameter("txtName");
        String email = request.getParameter("txtEmail");
        User n = new User(id, username, bcryptHashString, name, null, exp, rol, secName, null, email, null, null);
        UserService.Update(n);
        ServletUtils.redirect("/Admin/Account", request, response);
    }

    private static void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("uID"));
        List<Articles> listAr = ArticleService.getBywId(id);
        for (int i = 0; i < listAr.size(); i++) {
            CommentService.DeleteByAID(listAr.get(i).getArticles_id());
        }
        ArticleService.DeleteByWId(id);
        CommentService.DeleteByUid(id);
        UserService.Delete(id);
        ServletUtils.redirect("/Admin/Account", request, response);
    }

    private static void getPremium(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("uId"));
        UserService.get7DayPre(id);
        ServletUtils.redirect("/Admin/Account", request, response);
    }


}
