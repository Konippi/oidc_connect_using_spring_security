package com.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@RequiredArgsConstructor
@Controller
public class LoginController {
    /**
     * root page
     *
     * @return success page or login page
     */
    @GetMapping("/")
    public String index(@AuthenticationPrincipal final OidcUser loginUser) {
        // logged in user
        if (Objects.nonNull(loginUser)) {
            return "redirect:/success";
        }
        return "redirect:/login";
    }

    /**
     * success
     *
     * @return login success page
     */
    @GetMapping("/success")
    public String success(Model model) {
        model.addAttribute("message", "Login Success");
        return "index";
    }
}
