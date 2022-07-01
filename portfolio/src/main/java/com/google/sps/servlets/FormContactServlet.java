package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contact-form")
public class FormContactServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String email = request.getParameter("email");
    

    // Print the value so you can see it in the server logs.
    System.out.print("You submitted: " + fname);
    System.out.print(" " + lname);
    System.out.print(" " + email);

    // Write the value to the response so the user can see it.
    response.getWriter().print("You submitted: " + fname);
    response.getWriter().print(" " + lname );
    response.getWriter().print(" " + email );
  }
}