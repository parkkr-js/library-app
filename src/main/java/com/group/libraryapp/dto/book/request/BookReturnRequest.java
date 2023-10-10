package com.group.libraryapp.dto.book.request;

import lombok.Data;
import lombok.Getter;

@Getter
public class BookReturnRequest {

    private String userName;
    private String bookName;
}
