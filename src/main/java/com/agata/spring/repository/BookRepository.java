package com.agata.spring.repository;
import com.agata.spring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


@org.springframework.stereotype.Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {

}

