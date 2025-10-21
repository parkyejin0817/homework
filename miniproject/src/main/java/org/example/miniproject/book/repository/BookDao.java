package org.example.miniproject.book.repository;

import org.example.miniproject.book.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends CrudRepository<Book, Long> {
    @Override
    List<Book> findAll();
}
