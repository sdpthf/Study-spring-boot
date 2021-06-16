package com.dsm.library.controller;

import com.dsm.library.controller.request.RegistrationBookRequest;
import com.dsm.library.controller.response.Book;
import com.dsm.library.controller.response.BookResponse;
import com.dsm.library.service.BookRegistrationService;
import com.dsm.library.service.BookSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookRegistrationService bookRegistrationService;
    private final BookSearchService bookSearchService;

    @PostMapping("/book")
    public void registerBook(@RequestBody RegistrationBookRequest request) throws Exception {
        bookRegistrationService.createBook(request.getTitle(), request.getLibraryId());
    }

    @GetMapping("/book")
    public BookResponse searchBook() {
        List<Book> books = bookSearchService.test()
                .stream()
                .map(book -> new Book(book.getTitle(), book.getLibrary()))
                .collect(Collectors.toList());

        return new BookResponse(books);
    }

}