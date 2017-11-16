package fr.sorbonne.miage.m1.servlets;

import fr.sorbonne.miage.m1.beans.Author;
import fr.sorbonne.miage.m1.beans.Book;
import fr.sorbonne.miage.m1.dao.AuthorDao;
import fr.sorbonne.miage.m1.dao.DAO;
import fr.sorbonne.miage.m1.dao.BookDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author isa
 */
public class AddAuthorServlet extends HttpServlet {
    

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
        
        request.getRequestDispatcher("/add_author.jsp").forward(request, response);
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
        
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        
        
        //Si les champs ne sont pas tous remplis
	if(firstname.isEmpty() || lastname.isEmpty()){
            String msg_error = "Veuillez saisir le(s) champs suivants : ";
            
            //si le prénom est manquant
            if(firstname.isEmpty()){
		msg_error += "Prénom ";
            }
            //si le nom est manquant
            if(lastname.isEmpty()){
		msg_error += "Nom ";
            }
            
            request.setAttribute( "firstname", firstname );
            request.setAttribute( "lastname", lastname );
            request.setAttribute( "msg_error", msg_error );
            
            doGet(request, response);
            
        }else{
            Author a = new Author(firstname, lastname);
            AuthorDao authorDao = new AuthorDao();
            authorDao.create(a);
            request.setAttribute( "msg_success", "Auteur bien ajouté !");
            
            javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("/author");
            rd.forward(request,response);
        }
       

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "IndexServlet";
    }// </editor-fold>

}
