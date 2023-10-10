package com.group.libraryapp.service.book;

import com.group.libraryapp.entity.book.Book;
import com.group.libraryapp.repository.book.BookRepository;
import com.group.libraryapp.entity.user.User;
import com.group.libraryapp.repository.user.UserRepository;
import com.group.libraryapp.repository.user.userLoanHistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {

  private final BookRepository bookRepository;
  private final UserLoanHistoryRepository userLoanHistoryRepository;
  private final UserRepository userRepository;

  private static final String BOOK_NOT_FOUND = "책을 찾을 수 없습니다.";
  private static final String USER_NOT_FOUND = "사용자를 찾을 수 없습니다.";
  private static final String BOOK_ALREADY_LOANED = "이미 대출되어 있는 책입니다.";

  @Transactional
  public void saveBook(BookCreateRequest request) {
    bookRepository.save(new Book(request.getName()));
  }

  @Transactional
  public void loanBook(BookLoanRequest request) {
    Book book = findBookByName(request.getBookName());
    validateBookNotLoaned(book.getName());
    User user = findUserByName(request.getUserName());
    user.loanBook(book.getName());
  }

  @Transactional
  public void returnBook(BookReturnRequest request) {
    User user = findUserByName(request.getUserName());
    user.returnBook(request.getBookName());
  }

  private Book findBookByName(String bookName) {
    return bookRepository.findByName(bookName)
            .orElseThrow(() -> new IllegalArgumentException(BOOK_NOT_FOUND));
  }

  private void validateBookNotLoaned(String bookName) {
    if (userLoanHistoryRepository.existsByBookNameAndIsReturn(bookName, false)) {
      throw new IllegalArgumentException(BOOK_ALREADY_LOANED);
    }
  }

  private User findUserByName(String userName) {
    return userRepository.findByName(userName)
            .orElseThrow(() -> new IllegalArgumentException(USER_NOT_FOUND));
  }
}
