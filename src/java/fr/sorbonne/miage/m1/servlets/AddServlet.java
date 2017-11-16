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
public class AddServlet extends HttpServlet {
    

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
        
        AuthorDao authorDao = new AuthorDao();
        List<Author> authors = authorDao.findAll();
        request.setAttribute("authors", authors);
        request.getRequestDispatcher("/add.jsp").forward(request, response);
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
        
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String price = request.getParameter("price");
        String author = request.getParameter("author");
        
        
        //Si les champs ne sont pas tous remplis
	if(isbn.isEmpty() || title.isEmpty() || price.isEmpty() || author.isEmpty()){
            String msg_error = "Veuillez saisir le(s) champs suivants : ";
            //si le isbn est manquant
            if(isbn.isEmpty()){
		msg_error += "ISBN ";
            }
            //si le title est manquant
            if(title.isEmpty()){
		msg_error += "Titre ";
            }
            //si le prix est manquant
            if(price.isEmpty()){
		msg_error += "Prix ";
            }
            
            if(author.isEmpty()){
		msg_error += "Auteur ";
            }
            
            
            request.setAttribute( "title", title );
            request.setAttribute( "isbn", isbn );
            request.setAttribute( "price", price );
            request.setAttribute( "msg_error", msg_error );
            
            
            
        }else{
            Book b = new Book(Integer.parseInt(isbn), title, Float.parseFloat(price));
            BookDao bookdao = new BookDao();
            AuthorDao authordao = new AuthorDao();
            Author a = authordao.findById(Integer.parseInt(author));
            b.addAuthor(a);           
            bookdao.create(b);

            request.setAttribute( "msg_success", "Livre bien ajouté !");
            
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
        return "IndexServlet";
    }// </editor-fold>

}
