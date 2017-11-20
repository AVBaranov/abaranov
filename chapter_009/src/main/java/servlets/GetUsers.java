package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Andrey on 12.11.2017.
 */
public class GetUsers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        List<User> store = UserDaoJdbcImpl.getInstance().getAll();

        StringBuilder sb =new StringBuilder("<table style = \"border: 1px solid black\"; border : 1;>");

        sb.append(
                "<tr>" +
                        "<th>" +
                        "name" +
                        "</th>" +
                        "<th>" +
                        "login" +
                        "</th>" +
                        "<th>" +
                        "email" +
                        "</th>" +
                        "<th>" +
                        "date" +
                        "</th>" +
                        "</tr>"
        );
        for (User value : store) {
            sb.append(
                    "<tr>" +
                            "<td>" +
                            value.getName() +
                            "</td>" +
                            "<td>" +
                            value.getLogin() +
                            "</td>" +
                            "<td>" +
                            value.getEmail() +
                            "</td>" +
                            "<td>" +
                            value.getCreateDate() +
                            "</td>" +
                            "</tr>"
            );
        }

        writer.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <title></title>" +
                "</head>" +
                "<body>" +
                sb.toString() +
                "<br/>" +
                "</body>" +
                "</html>");
        writer.flush();
    }
}
