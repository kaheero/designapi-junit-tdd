package com.github.kaheero.book;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureMockMvc
@ComponentScan(basePackages = "com.github.kaheero")
class BookControllerTest{

  private static final String API_PATH_BOOKS = "/books";

  @Autowired
  MockMvc mvc;

  @MockBean
  private BookService bookService;

  @Test
  @DisplayName("Deve criar um livro com sucesso.")
  void createBookTest() throws Exception{

    BookDTO bookDTO = BookDTO.builder()
        .title("As aventuras")
        .author("Artur")
        .build();

    BookEntity bookSave = BookEntity.builder()
        .id(1L)
        .title("As aventuras")
        .author("Artur")
        .build();

    BDDMockito
        .given(bookService.save(Mockito.any(BookEntity.class)))
        .willReturn(bookSave);

    String json = new ObjectMapper().writeValueAsString(bookDTO);

    MockHttpServletRequestBuilder request = MockMvcRequestBuilders
        .post(API_PATH_BOOKS)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(json);

    mvc.perform(request)
        .andExpect(status().isCreated())
        .andExpect(jsonPath("id").isNotEmpty())
        .andExpect(jsonPath("title").value(bookDTO.getTitle()))
        .andExpect(jsonPath("author").value(bookDTO.getAuthor()))
        .andExpect(jsonPath("isbn").value(bookDTO.getIsbn()));
  }

//  @Test
//  @DisplayName("Deve lançar erro de validação quando não houver dados suficientes para a criação.")
//  void createInvalidBookTest(){
//
//  }

}
