//╔══════════════════════════════════════════════════════════════╗
//║					CHE - HOMEBANKING       ║
//╚══════════════════════════════════════════════════════════════╝

package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.DTO.AccountDTO;
import com.mindhub.homebanking.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	private AccountRepository accountRepository;

	@GetMapping("/accounts")
	public List<AccountDTO> getAccounts() {
		return accountRepository.findAll().stream().map(client -> new AccountDTO(client)).collect(Collectors.toList());
	}

	@GetMapping("/accounts/{id}")
	public AccountDTO getAccountById(@PathVariable long id){
		return new AccountDTO(accountRepository.findById(id).get());
	}
}
