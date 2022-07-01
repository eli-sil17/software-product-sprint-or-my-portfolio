package com.google.sps.servlets;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
@WebServlet("/data")
public class formData extends HttpServlet {
    @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Sanitize user input to remove HTML tags and JavaScript.
    //String title = Jsoup.clean(request.getParameter("fname"), Whitelist.none());
    String fname = request.getParameter("fname");
    String Lname = request.getParameter("lname");
    String email = request.getParameter("email");
    //String Lname = Jsoup.clean(request.getParameter("lname"), Whitelist.none());
    //String email = Jsoup.clean(request.getParameter("email"), Whitelist.none());
    long timestamp = System.currentTimeMillis();
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Task");
    FullEntity taskEntity =
    Entity.newBuilder(keyFactory.newKey())
        .set("First Name", fname)
        .set("Last Name", Lname)
        .set("Email", email)
        .set("timestamp", timestamp)
        .build();
    datastore.put(taskEntity);
  }
    
}
