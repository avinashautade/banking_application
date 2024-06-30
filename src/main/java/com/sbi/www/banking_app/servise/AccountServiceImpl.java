package com.sbi.www.banking_app.servise;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbi.www.banking_app.entity.Account;
import com.sbi.www.banking_app.mapping.AccountMapping;
import com.sbi.www.banking_app.models.AccountModel;
import com.sbi.www.banking_app.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountrepository;

	@Override
	public AccountModel createAccount(AccountModel accountmodel) {

		Account account = AccountMapping.mapToAccount(accountmodel);

		Account saveaccount = accountrepository.save(account);

		return AccountMapping.mapToAccountModel(saveaccount);

	}

	@Override
	public AccountModel getAccountById(Long id) {

		Account account = accountrepository.findById(id)
				.orElseThrow(() -> new RuntimeException("account is nt preszent"));

		return AccountMapping.mapToAccountModel(account);
	}

	@Override
	public AccountModel deposite(Long id, double ammount) {
		// TODO Auto-generated method stub

		Account account = accountrepository.findById(id)
				.orElseThrow(() -> new RuntimeException("account is nt preszent"));

		double total = account.getBalance() + ammount;

		account.setBalance(total);

		Account abc = accountrepository.save(account);

		return AccountMapping.mapToAccountModel(abc);
	}

	@Override
	public AccountModel withdraw(Long id, double ammount) {

		Account account = accountrepository.findById(id)
				.orElseThrow(() -> new RuntimeException("account is nt preszent"));

		if (account.getBalance() < ammount) {
			throw new RuntimeException("less balance");
		}

		double total = account.getBalance() - ammount;

		account.setBalance(total);

		Account savedacc = accountrepository.save(account);

		return AccountMapping.mapToAccountModel(savedacc);
	}

	@Override
	public List<AccountModel> allAccounts() {

		List<Account> allAccount= accountrepository.findAll();
		
		return allAccount.stream().map((Account) -> AccountMapping.mapToAccountModel(Account) ).collect(Collectors.toList());
		
	}

	@Override
	public void deleteAccount(Long id) {
		// TODO Auto-generated method stub
		
		Account account = accountrepository.findById(id)
				.orElseThrow(() -> new RuntimeException("account is nt preszent"));
		
		accountrepository.deleteById(id);
		
	}

}
