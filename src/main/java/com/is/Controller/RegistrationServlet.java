package com.is.Controller;

import com.is.Dao.RegistrationDao;
import com.is.Model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String patronymic = req.getParameter("patronymic");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        UserModel userModel = new UserModel();

        userModel.setFirstName(firstName);
        userModel.setLastName(lastName);
        userModel.setPatronymic(patronymic);
        userModel.setUserName(userName);
        userModel.setPassword(password);

        RegistrationDao regDao = new RegistrationDao();

        String userRegistered = regDao.registerUser(userModel);

        System.out.println(userRegistered);

        if (userRegistered.equals("SUCCESS")) {
            req.getRequestDispatcher("/Home.jsp").forward(req, resp);
        } else {
            req.setAttribute("err", regDao);
            req.getRequestDispatcher("/Register.jsp").forward(req, resp);
        }


    }
}

