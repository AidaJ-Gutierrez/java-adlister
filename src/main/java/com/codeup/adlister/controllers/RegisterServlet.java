package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // TODO: show the registration form
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO: ensure the submitted information is valid
        // TODO: create a new user based off of the submitted information
        // TODO: if a user was successfully created, send them to their profile



        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // need add one more if a confirmation for email is added : String passwordConfirm = req.getParameter(password-confirm)

        boolean validUsername = username.length() <= 50 && username.length() > 5;
        boolean validEmail = email.length() <= 50 && email.length() > 5 && email.contains("@");
        boolean validPassword = password.length() <= 50 && password.length() > 5 && !password.contains(username);


        if (validEmail && validPassword && validUsername) {
            User user = new User(0, username, email, password);
            long r = DaoFactory.getUsersDao().insert(user);
            if (r > 0) {
                request.getSession().setAttribute("user", DaoFactory.getUsersDao().findByUsername(username));
                response.sendRedirect("/profile");
            }
        } else {
            response.sendRedirect("/register");
        }


        //David's solution:
//        String username = request.getParameter("username");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//
//        if (username.trim().isEmpty()||email.trim().isEmpty() || password.trim().isEmpty() || !passwordConfirm.equals(password)|| DaoFactory.getUsersDao().findByUsername(username).getUsername() !=null){
//          response.sendRedirect("/register");
//        }else{
        // User user = new User(username, email, password)
//       DAoFactory.getUsersDao().insert(user);
        //request.getSession().setAttribute("user", username);

    }
}
