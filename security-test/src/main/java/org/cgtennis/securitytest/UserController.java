package org.cgtennis.securitytest;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @GetMapping("/")
    public String home() {
        return "home endpoint is not secure";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome page, secured for all users";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile (allowed for USER)";
    }

    @GetMapping("/admin")
    public String adminProfile() {
        return "Welcome to Admin Profile (only allowed for ADMIN)";
    }

    @GetMapping("/info")
    @PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_OTHER')")
    public String info() {
        return "Welcome to info page (allowed for USER, OTHER) ";
    }

}
