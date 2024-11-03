package com.mahmud.spring_webflux_practice.repositories;

import com.mahmud.spring_webflux_practice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
