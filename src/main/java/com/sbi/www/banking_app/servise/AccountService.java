package com.sbi.www.banking_app.servise;

import java.util.List;

import com.sbi.www.banking_app.models.AccountModel;

public interface AccountService {
	
	AccountModel createAccount (AccountModel accountmodel);
	AccountModel getAccountById(Long id);
	AccountModel deposite(Long id, double ammount);
	AccountModel withdraw(Long id, double ammount);
	List<AccountModel> allAccounts ();
	public void deleteAccount(Long id);

}
