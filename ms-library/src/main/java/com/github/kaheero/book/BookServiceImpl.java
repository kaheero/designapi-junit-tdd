package com.github.kaheero.book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{

  private BookRepository repository;

  @Override
  public BookEntity save(BookEntity book){
    return repository.save(book);
  }

}
