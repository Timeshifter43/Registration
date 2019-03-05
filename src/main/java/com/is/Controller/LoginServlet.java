package com.is.Controller;

import com.is.Dao.LoginDao;
import com.is.Model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        UserModel userModel = new UserModel();

        userModel.setUserName(userName);
        userModel.setPassword(password);

        LoginDao loginDao = new LoginDao();

        String userValidate = loginDao.authentificateUser(userModel);

        if(userValidate.equals ("SUCCESS")) {
            req.setAttribute("userName", userName);
            req.getRequestDispatcher("/Home.jsp").forward(req, resp);
        }else {
            req.setAttribute("errMessage", userValidate);
            req.getRequestDispatcher("/Login.jsp").forward(req, resp);
        }

    }
}
