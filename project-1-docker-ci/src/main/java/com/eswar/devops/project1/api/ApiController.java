package com.eswar.devops.project1.api;

import com.eswar.devops.project1.users.CreateUserRequest;
import com.eswar.devops.project1.users.User;
import com.eswar.devops.project1.users.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ApiController {

  private final UserService userService;

  public ApiController(UserService userService) {
    this.userService = userService;
  }

  /**
   * Simple app-level health endpoint.
   * (We also expose Spring Boot Actuator health at /actuator/health)
   */
  @GetMapping("/health")
  public String health() {
    return "OK";
  }

  @GetMapping("/users")
  public List<User> listUsers() {
    return userService.listUsers();
  }

  @PostMapping("/users")
  @ResponseStatus(HttpStatus.CREATED)
  public User createUser(@Valid @RequestBody CreateUserRequest request) {
    return userService.createUser(request);
  }
}
