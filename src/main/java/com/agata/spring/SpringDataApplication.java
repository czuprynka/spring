package com.agata.spring;

import com.agata.spring.model.Author;
import com.agata.spring.model.Book;
import com.agata.spring.model.Publisher;
import com.agata.spring.repository.AuthorRepository;
import com.agata.spring.repository.BookRepository;
import com.agata.spring.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Inject
    AuthorRepository authorRepository;
    @Inject
    BookRepository bookRepository;
    @Inject
    PublisherRepository publisherRepository;

    @Override
    public void run(String... args) {
        saveBooks();
    }

    public void saveBooks() {
        Publisher publisher1 = new Publisher("PWN");
        Publisher publisher2 = new Publisher("Idylla");
        publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);

        Book book1 = new Book("Przygody Natalii", new BigDecimal(2019));
        Book book2 = new Book("Tomcio Paluch", new BigDecimal(1880));
        Book book3 = new Book("Kraina pod słoncem", new BigDecimal(2012));
        book1.setPublisher(publisher1);
        book2.setPublisher(publisher1);
        book3.setPublisher(publisher2);

        Author author1 = new Author("Julian", "Król");
        Author author2 = new Author("Annna", "Wilczek");
        Author author3 = new Author("Krzysztof", "Zareba");
        Author author4 = new Author("Mica", "Janowa");

        Set<Book> author1books = null;
        author1books.add(book1);
        author1books.add(book2);

        Set<Book> author2books = new HashSet<>();
        author2books.add(book1);
        author2books.add(book3);

        Set<Book> author3books =  new HashSet<>();
        author3books.add(book1);

        Set<Book> author4books =  new HashSet<>();
        author4books.add(book3);

        author1.setBooks(author1books);
        author2.setBooks(author2books);
        author3.setBooks(author3books);
        author4.setBooks(author4books);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.save(author3);
        authorRepository.save(author4);
    }

}

