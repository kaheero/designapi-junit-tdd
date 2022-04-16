package com.github.kaheero.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
  private Long id;
  private String title;
  private String author;
  private String isbn;
}
