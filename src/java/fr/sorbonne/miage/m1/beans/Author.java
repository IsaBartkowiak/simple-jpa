/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sorbonne.miage.m1.beans;

import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author isa
 */
@Entity(name="Author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column( name = "firstname", length = 255)
    private String firstname;
    
    @Column( name = "lastname" , length = 255)
    private String lastname;
    
    @ManyToMany(mappedBy = "authors")
    private Collection<Book> books ;
    
    public Author(){
        
    }
    
    public Author(String firstname, String lastname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return this.firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }
    
    public String getLastName() {
        return this.lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

   public void addBook(Book b){
        this.books.add(b);
    }
    
}

