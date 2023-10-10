package com.group.libraryapp.entity.user.loanhistory;

import com.group.libraryapp.entity.user.User;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserLoanHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JoinColumn(nullable = false)
  @ManyToOne
  private User user;

  private String bookName;

  private boolean isReturn;

  public UserLoanHistory(User user, String bookName) {
    this.user = user;
    this.bookName = bookName;
    this.isReturn = false;
  }

  public void doReturn() {
    this.isReturn = true;
  }
}
