package com.agata.spring.repository;
import com.agata.spring.model.Book;
import com.agata.spring.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


@org.springframework.stereotype.Repository
@Transactional
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}

