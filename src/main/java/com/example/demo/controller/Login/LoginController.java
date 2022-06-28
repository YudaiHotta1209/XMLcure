package com.example.demo.controller.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {

	/* ①トップページ画面遷移 */
    @GetMapping
    public String top() {
        return "top-board";
    }

	/* ②ログインページ画面遷移 */
    @GetMapping("/login")
    public String showLoginForm() {
        return "Login/form";
    }
    /* ③ログアウト確認画面遷移 */
    @GetMapping("/logout")
    public String showLogoutForm() {
        return "Login/logout";
    }

}