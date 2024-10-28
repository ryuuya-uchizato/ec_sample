package com.example.demo;

import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.auth.AuthenticatedUser;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RootController {

	@GetMapping("/top")
	public String hello() {

		return "top";
	}

	@GetMapping("/login")
	public String onLoginRequested(Model model, AuthenticatedUser user) {

		return "login";

	}

	@GetMapping(value = "/login", params = "error")
	public String viewWithError(Model model, AuthenticatedUser user, HttpSession session) {
		Exception errorInfo = (Exception) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		model.addAttribute("message", errorInfo.getMessage());
		model.addAttribute("isError", true);

		return "login";
	}

	@GetMapping("/signup")
	public String signup() {

		return "signup";
	}
}
