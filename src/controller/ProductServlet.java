package controller;

import model.Product;
import service.ProductManger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ProductServlet",urlPatterns ="/list")
public class ProductServlet extends HttpServlet {
    private ProductManger productManger = new ProductManger();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //parameter lay bien action o dau ? o ca jsp va url?
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateProductForm(request, response);
                break;
            case "edit":
                showEditProductForm(request, response);
                break;
            case "delete":
                showDeleteProductForm(request, response);
            default:
                showListProduct(request, response);

        }
    }

    private void showListProduct(HttpServletRequest request,HttpServletResponse response) {
        request.setAttribute("products",productManger.getListProduct().values());
        dispatcher(request,response,"list.jsp");

    }

    private void showDeleteProductForm(HttpServletRequest request,HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product = productManger.findProductById(id);
        request.setAttribute("product",product);
        dispatcher(request,response,"delete.jsp");
    }

    private void showEditProductForm(HttpServletRequest request,HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product = productManger.findProductById(id);
        request.setAttribute("product",product);

        dispatcher(request,response,"edit.jsp");
    }

    private void showCreateProductForm(HttpServletRequest request,HttpServletResponse response) {
        dispatcher(request,response,"/create.jsp");

    }

    private void createProduct(HttpServletRequest request,HttpServletResponse response) {
        String id = request.getParameter("id"),
                date = request.getParameter("date"),
                name = request.getParameter("name"),
                number = request.getParameter("number"),
                price = request.getParameter("price");
        Product product = new Product(Integer.parseInt(id),name,Double.parseDouble(price),Integer.parseInt(number),date);

        productManger.addProduct(product);

        String message = "Create successfully";
        request.setAttribute("message",message);

        dispatcher(request,response,"/create.jsp");

    }

    private void editProduct(HttpServletRequest request,HttpServletResponse response) {
        String id = request.getParameter("id"),
                date = request.getParameter("date"),
                name = request.getParameter("name"),
                number = request.getParameter("number"),
                price = request.getParameter("price");

        Product product = productManger.findProductById(id);
        product.setName(name);
        product.setPrice(Double.parseDouble(price));
        product.setNumber(Integer.parseInt(number));
        product.setDate(date);

        productManger.updateProduct(product,id);

        String message = "Update successful";
        request.setAttribute("message",message);

        dispatcher(request,response,"/edit.jsp");

    }

    private void deleteProduct(HttpServletRequest request,HttpServletResponse response) {
        String id = request.getParameter("id");
        productManger.deleteProduct(id);
        try {
            response.sendRedirect("/list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dispatcher (HttpServletRequest request,HttpServletResponse response,String url){
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
