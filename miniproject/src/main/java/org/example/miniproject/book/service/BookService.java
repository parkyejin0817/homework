package org.example.miniproject.book.service;

import lombok.RequiredArgsConstructor;
import org.example.miniproject.book.domain.Book;
import org.example.miniproject.book.repository.BookDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookDao bookdao;


    // 새 Book 데이터 저장 or 수정할 때도 사용
    public Book save(Book book) {
        return bookdao.save(book);
    }

    // 모든 책 목록 가져오기
    public List<Book> findAll() {
        return bookdao.findAll();
    }

    // id로 책 삭제
    public void delete(Long id) {
        bookdao.deleteById(id);
    }

    // 기존 데이터 불러와 값 바꾸고 save()로 덮어쓰기
    public Book update(Book book) {
        return bookdao.save(book);

    }

    // Id 상세보기
    public Book findById(Long id) {
        return bookdao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException
                        ("Error: " + id + "는 없는 ID 입니다."));
    }



}



