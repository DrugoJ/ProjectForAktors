/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.webproject.controller;

import com.company.webproject.controller.session.ClientFacade;
import com.company.webproject.controller.session.OrderFacade;
import com.company.webproject.controller.session.ProductFacade;
import com.company.webproject.entites.Client;
import com.company.webproject.entites.Order;
import com.company.webproject.entites.Product;
import com.company.webproject.entites.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Comparator.comparing;
import java.util.GregorianCalendar;
import java.util.List;
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
@WebServlet(name = "OrderServlet", urlPatterns = {
    "/addClient",
    "/addOrder",
    "/addProduct",
    "/createClient",
    "/createProduct",
    "/createOrder",
    "/getOrder",
    "/sortByName",
    "/sortByDate",
    "/sortByOrderId",
    "/sortByProductName"})
public class OrderServlet extends HttpServlet {
    @EJB private ClientFacade clientFacade;
    @EJB private ProductFacade productFacade;
    @EJB private OrderFacade orderFacade;
    
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
        if(session == null){
            request.setAttribute("info", "You need in sign in");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        User reqUser = (User) session.getAttribute("reqUser");
        if(reqUser == null){
            request.setAttribute("info", "You need in sign in");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        String path = request.getServletPath();
        if(path==null){
            return;
        }
        switch (path) {
            case "/addClient":
                request.getRequestDispatcher("/addClient.jsp").forward(request, response);
                break;
            case "/addProduct":
                request.getRequestDispatcher("/addProduct.jsp").forward(request, response);
                break;
            case "/addOrder":
            {
                List<Product> listProducts = productFacade.findAll();
                request.setAttribute("listProducts", listProducts);
                List<Client> listClients = clientFacade.findAll();
                request.setAttribute("listClients", listClients);
                request.getRequestDispatcher("/addOrder.jsp").forward(request, response);
                break;
            }
            case "/createClient":
            {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String phone = request.getParameter("phone");
                String country = request.getParameter("country");
                String address = request.getParameter("address");
                
                Client client = new Client(null,name,surname,phone,country,address);
                clientFacade.create(client);
                
                request.setAttribute("info", "Add a new client - "+client.getName()+" "+client.getSurname());
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            }
            case "/createProduct":
            {
                String name = request.getParameter("name");
                String baseprice = request.getParameter("baseprice");
                String description = request.getParameter("description");
                String date = request.getParameter("releaseDate");
                String[] dmy = date.split("/");
                int day = Integer.parseInt(dmy[0]);
                int month = Integer.parseInt(dmy[1]);
                int year = Integer.parseInt(dmy[2]);

                Calendar c1 = new GregorianCalendar();
                c1.set(Calendar.MONTH, month-1);
                c1.set(Calendar.DATE, day);
                c1.set(Calendar.YEAR, year);
                
                Product product = new Product(null,name,Integer.parseInt(baseprice),description,c1.getTime());
                productFacade.create(product);
                
                request.setAttribute("info", "Add a new product - "+product.getName()+" Price - "+product.getBasePrice());
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            case "/createOrder":
            {
                String productId = request.getParameter("productId");
                Product product = productFacade.find(Long.parseLong(productId));
                String clientId = request.getParameter("clientId");
                Client client = clientFacade.find(Long.parseLong(clientId));
                Calendar c = new GregorianCalendar();
                
                Order order = new Order(null, product, client, c.getTime(),product.getBasePrice());
                orderFacade.create(order);
                
                request.setAttribute("info",
                        "Add a new order. Client name - " + client.getName()
                        + ". Product - " + product.getName()
                        + " Product price - " + product.getBasePrice());
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            case "/getOrder":
            {
                List<Order> listOrders = orderFacade.findAll();
                request.setAttribute("listOrders", listOrders);
                request.getRequestDispatcher("/getOrder.jsp").forward(request, response);
            }
            case "/sortByName":
            {
                List<Order> listOrders = orderFacade.findAll();
                listOrders.sort(comparing((Order order1) -> order1.getClient().getName()));
                request.setAttribute("listOrders", listOrders);
                request.getRequestDispatcher("/getOrder.jsp").forward(request, response);
            }
            case "/sortByDate":
            {
                List<Order> listOrders = orderFacade.findAll();
                listOrders.sort(comparing((Order order1) -> order1.getDate()));
                request.setAttribute("listOrders", listOrders);
                request.getRequestDispatcher("/getOrder.jsp").forward(request, response);
            }
            case "/sortByOrderId":
            {
                List<Order> listOrders = orderFacade.findAll();
                listOrders.sort(comparing((Order order1) -> order1.getId()));
                request.setAttribute("listOrders", listOrders);
                request.getRequestDispatcher("/getOrder.jsp").forward(request, response);
            }
            case "/sortByProductName":
            {
                List<Order> listOrders = orderFacade.findAll();
                listOrders.sort(comparing((Order order1) -> order1.getProduct().getName()));
                request.setAttribute("listOrders", listOrders);
                request.getRequestDispatcher("/getOrder.jsp").forward(request, response);
            }
                
            default:
                break;
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
