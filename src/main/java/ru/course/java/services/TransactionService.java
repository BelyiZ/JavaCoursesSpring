package ru.course.java.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.course.java.model.Transaction;
import ru.course.java.repositories.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public void addTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    public void update(Transaction transaction) {
        boolean exists = transactionRepository.existsById(transaction.getId());
        if (exists) {
            transactionRepository.save(transaction);
        } else {
            throw new EntityNotFoundException("transaction not found!");
        }
    }

    public void delete(int id) {
        transactionRepository.deleteById(id);
    }

    public void streamDemo() {
        List<Transaction> transactions = getAll();

        List<Transaction> result = new ArrayList<>();
        int skipCount = 0;
        for (Transaction transaction : transactions) {
            if (Objects.nonNull(transaction)) {
                if (transaction.getPrice() > 100) {
                    if (transaction.getName().startsWith("А")) {
                        if (skipCount > 10) {
                            result.add(transaction);
                            if (result.size() == 10) {
                                break;
                            }
                        } else {
                            skipCount++;
                        }
                    }
                }
            }
        }

        transactions
                .stream()
                .filter(this::myTest)
                .filter(transaction -> Objects.nonNull(transaction))
                .filter(new Predicate<Transaction>() {
                    @Override
                    public boolean test(Transaction transaction) {
                        return Objects.nonNull(transaction);
                    }
                })
                .skip(30)
                .limit(10)
                .collect(Collectors.toList());
    }

    public boolean myTest(Object o) {
        return o.toString().length() > 10;
    }

}

