//╔═══════════════════════════════════════════════════════════╗
//║					CHE - HOMEBANKING						  ║
//╚═══════════════════════════════════════════════════════════╝
package com.mindhub.homebanking.DTO;

import com.mindhub.homebanking.Models.Account;
import com.mindhub.homebanking.Models.Client;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountDTO {
    private Long id;
    private String number;
    private LocalDate date;
    private double balance;
    private Set<TransactionDTO> transactions = new HashSet<>();
    private Client owner;

    public AccountDTO(Account account) {
        this.id = account.getId();
        this.number = account.getNumber();
        this.date = account.getDate();
        this.balance = account.getBalance();
        this.transactions = account.getTransactions().stream().map(transaction -> new TransactionDTO(transaction)).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }
    public String getNumber() {
        return number;
    }
    public LocalDate getDate() {
        return date;
    }
    public double getBalance() {
        return balance;
    }
    public Set<TransactionDTO> getTransactions() {
        return transactions;
    }
}