package ru.course.java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.course.java.model.Transaction;
import ru.course.java.services.TransactionService;

@Controller
public class MainPageController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("transactions", transactionService.getAll());
        return "mainPage";
    }


}
