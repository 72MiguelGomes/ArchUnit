package com.example.arch.users.core;

import com.example.arch.users.repo.UserRepository;

public class UserCore {

  private final UserRepository userRepository;

  public UserCore(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
}
