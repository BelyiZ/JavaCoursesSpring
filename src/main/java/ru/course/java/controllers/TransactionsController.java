package ru.course.java.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.course.java.model.Transaction;
import ru.course.java.services.TransactionService;

@Api(value = "Работа с транзакциями", tags = {"Транзакции"})
@RestController
public class TransactionsController {

    @Autowired
    private TransactionService transactionService;

    @ApiOperation("Добавление новой транзакции")
    @PostMapping("/transactions")
    public ResponseEntity<Object> addTransaction(@RequestBody Transaction transaction) {
        transactionService.addTransaction(transaction);
        return ResponseEntity.ok(transaction);
    }

    @ApiOperation("Получение списка транзакций")
    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getListTransaction() {
        return ResponseEntity.ok(transactionService.getAll());
    }

    @ApiOperation("Редактирование транзакции")
    @PutMapping("/transactions")
    public ResponseEntity updateTransaction(@RequestBody Transaction transaction) {
        try {
            transactionService.update(transaction);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation("Удаление транзакции")
    @DeleteMapping("/transactions/{id}")
    public ResponseEntity deleteTransaction(@PathVariable int id) {
        transactionService.delete(id);
        return ResponseEntity.ok().build();
    }


}
