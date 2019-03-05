package com.is.Dao;

import com.is.Model.UserModel;
import com.is.Util.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDao {

    public String authentificateUser(UserModel userModel){

        String userName = userModel.getUserName();
        String password = userModel.getPassword();

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String userNameDB = "";
        String passwordDB = "";

        try {
            con = DBConnection.createConnection();
            st = con.createStatement();
            rs = st.executeQuery("select userName,password from tenderusers");

            while (rs.next()){
                userNameDB = rs.getString("userName");
                passwordDB = rs.getString("password");

                if(userName.equals(userNameDB) && password.equals(passwordDB)){
                    return "SUCCESS";
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return "Invalid user credentials";
    }
}
