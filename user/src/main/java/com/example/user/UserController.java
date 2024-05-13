package com.example.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserFromRequestParam(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PostMapping
    public User getUserFromJsonRequestBody(@RequestBody User user) {
        return userService.getUser(user.getId());
    }
}
