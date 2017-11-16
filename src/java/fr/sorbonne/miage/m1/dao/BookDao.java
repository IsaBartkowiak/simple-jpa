package fr.sorbonne.miage.m1.dao;

import fr.sorbonne.miage.m1.beans.Book;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;


/**
 *
 * @author isa
 */
public class BookDao implements DAO<Book> {

    private EntityManager em;
    
    public BookDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("livre");
        this.em = emf.createEntityManager();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void create(Book b) {
        this.em.getTransaction().begin();
        this.em.persist(b);
        this.em.getTransaction().commit();
        this.em.close();
    }

    @Override
    public Book findById(int id) {
        return this.em.find(Book.class, id);
    }

    @Override
    public void update(Book obj) {
        this.em.getTransaction().begin();
        this.em.merge(obj);
        this.em.getTransaction().commit();
        this.em.close();
    }

    @Override
    public void delete(Book obj) {
        this.em.getTransaction().begin();
        this.em.remove(obj);
        this.em.getTransaction().commit();
        this.em.close();
    }

    @Override
    public List<Book> findAll() {
        List<Book> listBook = this.em.createQuery("Select b FROM Book b").getResultList();
        return listBook;
    }



}
