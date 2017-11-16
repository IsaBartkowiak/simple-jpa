/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sorbonne.miage.m1.servlets;

import fr.sorbonne.miage.m1.beans.Author;
import fr.sorbonne.miage.m1.beans.Book;
import fr.sorbonne.miage.m1.dao.AuthorDao;
import fr.sorbonne.miage.m1.dao.BookDao;
import fr.sorbonne.miage.m1.dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author isa
 */
@WebServlet(name = "EditBookServlet", urlPatterns = {"/edit"})
public class EditBookServlet extends HttpServlet {
    
    private DAO<Book> bookDao;
    private Book b;

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
        
        request.getRequestDispatcher("/edit.jsp").forward(request, response);
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
        String id = request.getParameter("id");
        this.bookDao = new BookDao();
        this.b = bookDao.findById(Integer.parseInt(id));
        request.setAttribute("book", this.b);
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
        
        String title = request.getParameter("title");
        String price = request.getParameter("price");
        
        //Si les champs ne sont pas tous remplis
	if(title.isEmpty() || price.isEmpty()){
            String msg_error = "Veuillez saisir le(s) champs suivants : ";
  
            //si le title est manquant
            if(title.isEmpty()){
		msg_error += "Titre ";
            }
            //si le prix est manquant
            if(price.isEmpty()){
		msg_error += "Prix ";
            }
            
            request.setAttribute( "title", title );
            request.setAttribute( "price", price );
            request.setAttribute( "msg_error", msg_error );
            
        }else{
            BookDao bookdao = new BookDao();
            this.b.setTitle(title);
            this.b.setPrice(Float.parseFloat(price));
            bookdao.update(this.b);

            request.setAttribute( "msg_success", "Livre bien modifié !");
            
        }
        doGet(request, response);
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
