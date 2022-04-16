package com.github.kaheero.book;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

  private final BookService bookService;
  private final ModelMapper mapper;

  public BookController(BookService bookService, ModelMapper mapper){
    this.bookService = bookService;
    this.mapper = mapper;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BookDTO create(@RequestBody BookDTO bookDTO){
    BookEntity entity = mapper.map(bookDTO, BookEntity.class);
    return mapper.map(bookService.save(entity), BookDTO.class);
  }

}
