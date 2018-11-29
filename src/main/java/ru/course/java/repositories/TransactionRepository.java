package ru.course.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.course.java.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
