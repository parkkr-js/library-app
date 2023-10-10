package com.group.libraryapp.dto.user.request;

import lombok.Data;
import lombok.Getter;

@Getter
public class UserCreateRequest {

  private String name;
  private Integer age;

}
