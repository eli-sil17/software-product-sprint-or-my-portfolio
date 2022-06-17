package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.google.gson.*;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    //response.setContentType("text/html;");
    ArrayList<String>  facts = new ArrayList<String>();
    facts.add("My favorite disney movie is toy story");
    facts.add("I like the color blue");
    facts.add("I have a bunch of stuff animals");
    String json = convertToJsonUsingGson(facts);
    System.out.println(json);
    response.setContentType("application/json;");
    //return json;
    //response.getWriter().println("Hello Eli!");
    response.getWriter().println(json);
  }
  public String convertToJson (  ArrayList<String> facts) throws IOException {
    String json = "{";
    for (String fact: facts)
    {
        json += "\"fact\": ";
        json += fact;
    }
    json += "}";
    return json;
  }
  private String convertToJsonUsingGson( ArrayList<String> facts) {
    Gson gson = new Gson();
    String json = gson.toJson(facts);
    return json;
  }
}
