/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sorbonne.miage.m1.dao;

import fr.sorbonne.miage.m1.beans.Author;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author isa
 */
public class AuthorDao implements DAO{
    
    private EntityManager em;

    public AuthorDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("livre");
        this.em = emf.createEntityManager();
    }

    public Author findById(int id) {
        return this.em.find(Author.class, id);
    }

    public List<Author> findAll() {
        List<Author> listAuthor = (List<Author>) this.em.createQuery("Select a FROM Author a").getResultList();
        return listAuthor;
    }

    @Override
    public void create(Object obj) {
        this.em.getTransaction().begin();
        this.em.persist(obj);
        this.em.getTransaction().commit();
        this.em.close();
    }

    @Override
    public void update(Object obj) {
        this.em.getTransaction().begin();
        this.em.merge(obj);
        this.em.getTransaction().commit();
        this.em.close();
    }

    @Override
    public void delete(Object obj) {
        this.em.getTransaction().begin();
        this.em.remove(obj);
        this.em.getTransaction().commit();
        this.em.close();
    }


    
}
