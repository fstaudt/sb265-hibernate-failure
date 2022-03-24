package com.spring.reproducer.sb265.hibernate.failure.resource;

import com.spring.reproducer.sb265.hibernate.failure.model.User;
import com.spring.reproducer.sb265.hibernate.failure.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    private final UserRepository repository;

    public UserResource(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @ResponseBody
    public List<User> findAllByPartialName(
            @RequestParam(name = "partialName") String partialName) {
        return repository.findAllByNameContaining(partialName);
    }
}
