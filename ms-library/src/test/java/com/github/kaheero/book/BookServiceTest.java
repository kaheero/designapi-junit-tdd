package com.github.kaheero.book;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class BookServiceTest{

  private BookService bookService;

  @MockBean
  private BookRepository repository;

  @BeforeEach
  public void setup(){
    this.bookService = new BookServiceImpl(repository);
  }

  @Test
  @DisplayName("Deve salvar um livro.")
  void saveBookTest(){
    // cenário
    BookEntity book = BookEntity.builder()
        .title("Vinte mil léguas submarinas.")
        .author("Julio Verne")
        .isbn("123")
        .build();

    Mockito
        .when(repository.save(book))
        .thenReturn(BookEntity.builder()
            .id(1L)
            .title("Vinte mil léguas submarinas.")
            .author("Julio Verne")
            .isbn("123")
            .build());

    // execução
    BookEntity saveBook = bookService.save(book);

    // verificação
    assertThat(saveBook.getId()).isNotNull();
    assertThat(saveBook.getTitle()).isEqualTo(book.getTitle());
    assertThat(saveBook.getAuthor()).isEqualTo(book.getAuthor());
    assertThat(saveBook.getIsbn()).isEqualTo(book.getIsbn());
  }

}
