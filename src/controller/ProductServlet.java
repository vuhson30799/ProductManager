package controller;

import model.Product;
import service.ProductManager;
import service.ProductMangerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet",urlPatterns ="/list")
public class ProductServlet extends HttpServlet {
    private ProductManager productManger = new ProductMangerImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                break;
            default:
                showListProduct(request,response);
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

        String message;

        try {
            productManger.addProduct(id,name,date,number,price);
            message = "Create successfully";
        } catch (Exception e) {
            e.printStackTrace();
            message = "Error!!" + e.getMessage();
        }
        request.setAttribute("message",message);
        dispatcher(request,response,"/create.jsp");

    }

    private void editProduct(HttpServletRequest request,HttpServletResponse response) {
        String id = request.getParameter("id"),
                date = request.getParameter("date"),
                name = request.getParameter("name"),
                number = request.getParameter("number"),
                price = request.getParameter("price");

        String errMess = null;
        try{
            productManger.updateProduct(id,name,date,number,price);
            String message = "Update successful";
            request.setAttribute("message",message);
        }catch (NumberFormatException e){
            e.printStackTrace();
            if (e.getMessage().equals("Price is invalid")){
                errMess = "Price is invalid";
            }else {
                errMess = "Number is invalid";
            }
        }catch (Exception e){
            e.printStackTrace();
            errMess = "Date is invalid";
        }
        request.setAttribute("errMess",errMess);
        request.setAttribute("product",productManger.findProductById(id));
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
