package com.example.finalproject.controller;

import com.example.finalproject.beans.User;
import com.example.finalproject.service.UserService;
import com.example.finalproject.utils.ServletUtils;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
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
                request.setAttribute("listUser", list);
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
                    document.add(new Paragraph("ID: "+ u.getUser_id()));
                    document.add(new Paragraph("Username: "+ u.getUsername()));
                    document.add(new Paragraph("Password: "+ u.getPassword()));
                    document.add(new Paragraph("Name: "+ u.getName()));
                    document.add(new Paragraph("Issue at: "+ u.getIssue_at()));
                    document.add(new Paragraph("Exp: "+ u.getExpiration()));
                    document.add(new Paragraph("Role? 0:Admin - 1: Editor - 2: Writer - 3: Reader"));
                    document.add(new Paragraph("Role: "+ u.getRole()));
                    document.add(new Paragraph("2nd Name: "+ u.getSecond_name()));
                    document.add(new Paragraph("Dob: "+ u.getDob()));
                    document.add(new Paragraph("Email: "+ u.getEmail()));

                    document.close();
                }
                catch (DocumentException de) {
                    throw new IOException(de.getMessage());
                }
                ServletUtils.redirect("/Admin/Account", request, response);
                break;
            case "/Add":
                ServletUtils.forward("/views/vwDashboard/Admin-account-Add.jsp", request, response);
                break;


           /* case "/Edit":
                int id = 0;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                } catch (NumberFormatException e) {
                }

                Category c = CategoryModel.findById(id);
                if (c != null) {
                    request.setAttribute("category", c);
                    ServletUtils.forward("/views/vwCategory/Edit.jsp", request, response);
                } else {
                    ServletUtils.redirect("/Admin/Category", request, response);
                    // ServletUtils.forward("/views/204.jsp", request, response);
                }
                break;*/

            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
