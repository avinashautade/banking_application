package com.sbi.www.banking_app.mapping;

import com.sbi.www.banking_app.entity.Account;
import com.sbi.www.banking_app.models.AccountModel;

public class AccountMapping {
	
	
	public static Account mapToAccount(AccountModel accountmodel) {
		
		Account account = new Account(
				
				accountmodel.getId(),
				accountmodel.getAccountHolderName(),
				accountmodel.getBalance()
			);
		
		return account;
		
	}
	
	public static AccountModel mapToAccountModel(Account account) {
		
		
		   AccountModel accountmodel = new  AccountModel (
				   
				   
				   account.getId(),
				   account.getAccountHolderName(),
				   account.getBalance()
				   
				   
				   );
				   
				   
		
		
		
		return accountmodel ;
		
	}

}
