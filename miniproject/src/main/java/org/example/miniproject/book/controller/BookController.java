package org.example.miniproject.book.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.miniproject.book.domain.Book;
import org.example.miniproject.book.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    // 도서 등록 폼
    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "books/addform";
    }

    // 도서 등록 처리
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book,
                          BindingResult result) {
        if (result.hasErrors()) {
            return "books/addform";
        }
        service.save(book);
        return "redirect:/books";
    }

    // 전체 조회
    @GetMapping
    public String booksList(Model model) {
        List<Book> books = service.findAll();
        model.addAttribute("books", books);
        return "books/list";
    }

    // 상세보기(수정) 폼
    @GetMapping("/{id}")
    public String showBookDetail(@PathVariable Long id, Model model) {
        Book book = service.findById(id); // ID로 책 하나 가져오기
        model.addAttribute("book", book);
        return "books/book"; // book.html 열기
    }

    // 삭제
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        service.delete(id);
        return "redirect:/books";
    }

    // 수정
    @PostMapping("/{id}/update")
    public String updateBook(@PathVariable Long id,
                             @Valid @ModelAttribute("book") Book book,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "books/book";
        }

        book.setId(id);
        service.update(book);
        return "redirect:/books";
    }
}




