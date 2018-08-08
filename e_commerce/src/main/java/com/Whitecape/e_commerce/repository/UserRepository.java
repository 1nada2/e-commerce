package com.Whitecape.e_commerce.repository;

import com.Whitecape.e_commerce.model.User;

import reactor.core.publisher.Mono;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:4200")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    Mono<User> findByUsername(String username);

    @Override
    void delete(User user);

}
