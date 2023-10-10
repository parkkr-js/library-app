package com.group.libraryapp.dto.book.request;

import lombok.Data;
import lombok.Getter;

@Getter
public class BookLoanRequest {

    private String userName;
    private String bookName;
}
