package com.group.libraryapp.repository.user.userLoanHistory;

import com.group.libraryapp.entity.user.loanhistory.UserLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {

  // select * from user_loan_history where book_name = ? and is_return = ?
  boolean existsByBookNameAndIsReturn(String name, boolean isReturn);

}
