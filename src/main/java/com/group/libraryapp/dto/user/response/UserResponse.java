package com.group.libraryapp.dto.user.response;

import com.group.libraryapp.entity.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse {
  private long id;
  private String name;
  private Integer age;

  public UserResponse(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.age = user.getAge();
  }

  public UserResponse(long id, User user) {
    this.id = id;
    this.name = user.getName();
    this.age = user.getAge();
  }
}
