package org.cgtennis.securitytest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

}
