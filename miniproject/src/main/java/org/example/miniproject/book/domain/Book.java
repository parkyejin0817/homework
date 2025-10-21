package org.example.miniproject.book.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("books")
@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Book {
    @Id
    private Long id;

    @NotBlank(message = "제목을 입력하세요")
    private String title;

    @NotBlank(message = "저자를 입력하세요")
    private String author;
}


