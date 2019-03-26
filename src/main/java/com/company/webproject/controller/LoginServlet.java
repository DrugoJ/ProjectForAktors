/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.webproject.controller;

import com.company.webproject.controller.session.ClientFacade;
import com.company.webproject.controller.session.UserFacade;
import com.company.webproject.entites.Client;
import com.company.webproject.entites.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GoD
 */
@WebServlet(name = "LoginServlet", urlPatterns = {
    "/showLogin",
    "/login",
    "/logout",
    "/showRegistration",
    "/registration"})
public class LoginServlet extends HttpServlet {
    @EJB
    private ClientFacade clientFacade;
    @EJB
    private UserFacade userFacade;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession(false);
        String path = request.getServletPath();
        if (path != null) {
            switch (path) {
                case "/showLogin":
                {
                    request.getRequestDispatcher("/showLogin.jsp").forward(request, response);
                    break;
                }                  
                case "/login":
                {
                    String login = request.getParameter("login");
                    String password = request.getParameter("password");
                    User reqUser = userFacade.findByLogin(login);
                    if (reqUser==null){
                        request.getRequestDispatcher("/showLogin.jsp").forward(request, response);
                        request.setAttribute("info", "is not existed User");
                        break;
                    }
                    if(!password.equals(reqUser.getPassword())){
                        request.getRequestDispatcher("/showLogin.jsp").forward(request, response);
                        request.setAttribute("info", "Login or Password is incorrect");
                        break;
                    }
                    session = request.getSession(true);
                    session.setAttribute("reqUser", reqUser);
                    request.setAttribute("info", "Sign in");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    break;
                }

                case "/logout":
                {
                    if(session != null){
                        session.invalidate();
                    }
                    request.setAttribute("info", "Sign out");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
                    
                case "/showRegistration": {
                    request.getRequestDispatcher("/showRegistration.jsp").forward(request, response);
                    break;
                }

                case "/registration": {
                    String name = request.getParameter("name");
                    String surname = request.getParameter("surname");
                    String phone = request.getParameter("phone");
                    String country = request.getParameter("country");
                    String address = request.getParameter("address");
                    Client client = new Client(null, name, surname, phone, country, address);
                    clientFacade.create(client);
                    String login = request.getParameter("login");
                    String password1 = request.getParameter("password1");
                    String password2 = request.getParameter("password2");
                    
                    if (!password1.equals(password2)) {
                        request.setAttribute("info", "Your passwords are not the same");
                        request.setAttribute("name", name);
                        request.setAttribute("surname", surname);
                        request.setAttribute("phone", phone);
                        request.setAttribute("country", country);
                        request.setAttribute("address", address);
                        request.getRequestDispatcher("/showRegistration.jsp").forward(request, response);
                        break;
                    }
                    
                                    
                    User reqUser = new User(login, password1, client);
                    userFacade.create(reqUser);
                    
                    request.setAttribute("info", "Created user login is "+reqUser.getLogin());
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    break;
                }

                default:
                    break;

            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
