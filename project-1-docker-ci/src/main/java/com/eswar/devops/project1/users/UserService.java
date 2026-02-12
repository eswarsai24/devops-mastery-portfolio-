package com.eswar.devops.project1.users;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * In-memory user store (intentionally simple for Project 1).
 * In later projects we'll replace this with a DB and add migrations.
 */
@Service
public class UserService {

  private final List<User> users = Collections.synchronizedList(new ArrayList<>());

  public List<User> listUsers() {
    // Copy to avoid exposing internal list reference
    synchronized (users) {
      return List.copyOf(users);
    }
  }

  public User createUser(CreateUserRequest req) {
    User user = new User(UUID.randomUUID().toString(), req.name(), req.email());
    users.add(user);
    return user;
  }
}
