
<pre><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
              pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<script>
function validate() {
    var firstName = document.form.firstName.value;
    var lastName = document.form.lastName.value;
    var patronymic = document.form.patronymic.value;
    var userName = document.form.userName.value;
    var password = document.form.password.value;
    var conpassword = document.form.conpassword.value;

    if (firstName == null || firstName == "") {
        alert("Full Name can't be blank");
        return false;
    }
    else if (lastName == null || lastName == "") {
        alert("LastName can't be blank");
        return false;
    }
    else if (patronymic == null || patronymic == "") {
        alert("Patronymic can't be blank");
        return false;
    }
    else if (userName == null || userName == "") {
        alert("Username can't be blank");
        return false;
    }
    else if (password.length < 6) {
        alert("Password must be at least 6 characters long.");
        return false;
    }
    else if (password != conpassword) {
        alert("Confirm Password should match with the Password");
        return false;
    }
}
</script>
</head>
<body>
<center><h2>Java Registration application using MVC and MySQL </h2></center>
<form name="form" action="RegistrationServlet" method="post" onsubmit="return validate()">
<table align="center">
<tr>
<td>First Name</td>
<td><input type="text" name="firstName"/></td>
</tr>
    <tr>
<td>Last Name</td>
<td><input type="text" name="lastName"/></td>
</tr>
    <tr>
    <td>Patronymic</td>
<td><input type="text" name="patronymic"/></td>
    </tr>
<tr>
<td>Username</td>
<td><input type="text" name="userName"/></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password"/></td>
</tr>
<tr>
<td>Confirm Password</td>
<td><input type="password" name="conpassword"/></td>
</tr>
<tr>
<td><%=(request.getAttribute("errMessage") == null) ? ""
        : request.getAttribute("errMessage")%></td>
</tr>
<tr>
<td></td>
<td>
    <input type="submit" value="Register">
    <input type="reset" value="Reset">
</td>
</tr>
</table>
</form>
</body>
</html>