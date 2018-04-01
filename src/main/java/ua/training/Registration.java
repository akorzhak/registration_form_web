/*
 * Registration
 *
 * Description: This servlet is a part of the web app,
 * that provides registration form, takes input,
 * checks it for validity and records to database.
 *
 * By: Alyona Korzhakova
 *
 * Created: 2018/03/22
 *
 * Updated: 2018/03/25
 */
package ua.training;

import javax.servlet.http.*;
import java.io.*;

public class Registration extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IllegalArgumentException, IOException {

        Database database = new Database();
        String name, age, email, login, password;
        name = request.getParameter("name");
        age = request.getParameter("age");
        email = request.getParameter("email");
        login = request.getParameter("login");
        password = request.getParameter("password");
        User user = new User(name, age, email, login, password);
        try {
            if (! user.isValidUser())
                throw new IOException();
            else {
                if (! database.addUser(user))
                    throw new IllegalArgumentException();
                else {
                    response.getWriter().print("User has been successfully created");
                }
            }
        } catch (IOException e) {
            response.sendRedirect("invaliddata.jsp");
        } catch (IllegalArgumentException e) {
            response.sendRedirect("retry.jsp");
        }
    }
}