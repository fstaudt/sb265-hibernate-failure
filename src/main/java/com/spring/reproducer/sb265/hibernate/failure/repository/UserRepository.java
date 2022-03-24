package com.spring.reproducer.sb265.hibernate.failure.repository;

import com.spring.reproducer.sb265.hibernate.failure.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByNameContaining(String partialName);
}
