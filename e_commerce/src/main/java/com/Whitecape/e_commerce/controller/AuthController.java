package com.Whitecape.e_commerce.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController {

    public AuthController() {
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/user")
    public Mono<Map> current(@AuthenticationPrincipal Mono<Principal> principal) {
        return principal
                .map( user -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", user.getName());
                    map.put("roles", AuthorityUtils.authorityListToSet(((Authentication) user)
                            .getAuthorities()));
                    return map;
                });
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/logout")
    public Mono<Void> logout(WebSession session) {
        return session.invalidate();
    }

}

