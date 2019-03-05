package com.is.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.is.Model.UserModel;
import com.is.Util.DBConnection;

public class RegistrationDao {
    public String registerUser(UserModel userModel) {

        String firstName = userModel.getFirstName();
        String lastName = userModel.getLastName();
        String patronymic = userModel.getPatronymic();
        String userName = userModel.getUserName();
        String password = userModel.getPassword();

        Connection con = null;
        PreparedStatement ps = null;

        try {

            con = DBConnection.createConnection();

            String query = "insert into tenderusers(id,firstName,lastName,patronymic,userName,password) values (NULL,?,?,?,?,?)";

            ps = con.prepareStatement(query);

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, patronymic);
            ps.setString(4, userName);
            ps.setString(5, password);


            int i = ps.executeUpdate();

            if (i != 0) return "SUCCESS";
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "error");

        }
        return "Oops,lost connection";
    }
}
