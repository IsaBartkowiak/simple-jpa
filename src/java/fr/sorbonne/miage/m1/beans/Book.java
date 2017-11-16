package fr.sorbonne.miage.m1.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

@Entity(name="Book")
public class Book {
    
    @Id
    @Column( name = "isbn" )
    private Integer isbn;
    
    @Column( name = "title" )
    private String title;
    
    @Column( name = "price" )
    private Float price;
    
    @ManyToMany
    @JoinTable(name = "compo_author_book",
    joinColumns = @JoinColumn(name = "book_isbn", referencedColumnName = "isbn"),
    inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private Collection<Author> authors;

    public Book() {
    }
    
    public Book(Integer isbn, String title, Float price) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.authors = new ArrayList<Author>();
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    
    public void addAuthor(Author a){
        this.authors.add(a);
    }
    
    public Collection<Author> getAuthors(){
        return this.authors;
    }
}
