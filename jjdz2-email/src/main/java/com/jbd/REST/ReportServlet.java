package com.jbd.REST;

import com.jbd.Report;
import com.jbd.authorization.SessionData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@WebServlet(urlPatterns = "/App/createReport")
public class ReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet!");

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("http://localhost:8081/reporting/reportApi/")
                .path("users")
                .path("name");

        Response response1 = target.request()
                .get();

        List<Report> reportList = new ArrayList<>();

        Report[] reports = response1.readEntity(Report[].class);

        for (int i =0; i < reports.length; i++ ){
         reportList.add(reports[i]);
        }

        request.setAttribute("reportList", reportList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/App/AdminConsole.jsp");
        dispatcher.forward(request,response);


    }
}
