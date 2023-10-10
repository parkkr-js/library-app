package com.group.libraryapp.repository.user;

import com.group.libraryapp.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByName(String name);

}
