package com.group.libraryapp.repository.book;

import com.group.libraryapp.entity.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

  Optional<Book> findByName(String name);

}
