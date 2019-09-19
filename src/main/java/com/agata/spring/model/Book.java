package com.agata.spring.model;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    private Long id;
    private String title;
    private BigDecimal publishingYear;

    @ManyToMany
    @JoinColumn(name="author_id")
    private Set<Author> authors;

    @ManyToOne
    @JoinColumn(name="publisher_id")
    private Publisher publisher;

    public Book(String title, BigDecimal publishingYear) {
        this.title = title;
        this.publishingYear = publishingYear;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(BigDecimal publishingYear) {
        this.publishingYear = publishingYear;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishingYear=" + publishingYear +
                ", authors=" + authors +
                ", publisher=" + publisher +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(title, book.title) &&
                Objects.equals(publishingYear, book.publishingYear) &&
                Objects.equals(authors, book.authors) &&
                Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, publishingYear, authors, publisher);
    }
}
