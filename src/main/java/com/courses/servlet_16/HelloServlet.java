package com.courses.servlet_16;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by VSulevskiy on 06.10.2015.
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String html = "<HTML>"+
                "<HEAD>" +
                "<TITLE>" +
                "First page" +
                "</TITLE>" +
                "</HEAD>" +
                "<BODY>" +
                "<H1>" +
                "Hello" +
                "<H1>" +
                "</BODY>" +
                "";
        resp.getWriter().println(html);
    }
    @Override
    public void init() throws ServletException
    {
        System.out.println("Servlet " + this.getServletName() + " has started.");
    }
    @Override
    public void destroy()
    {
        System.out.println("Servlet " + this.getServletName() + " has stopped.");
    }
}
