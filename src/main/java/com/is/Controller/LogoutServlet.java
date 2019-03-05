package com.is.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if(session!=null){
            session.invalidate();
            req.setAttribute("errMessage", "You have logged out successfully");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Login.jsp");
            requestDispatcher.forward(req, resp);
            System.out.println("Logged out");
        }
    }
}
