package com.sbi.www.banking_app.rest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.www.banking_app.models.AccountModel;
import com.sbi.www.banking_app.servise.AccountService;

@RestController
@RequestMapping("/api/acoount")
public class AcoountController {
	
	@Autowired
	private AccountService accountsaervice;
	
	@PostMapping("/save")
	public ResponseEntity<AccountModel> createAccount(@RequestBody AccountModel accountmodel){
		
		AccountModel acc  =      accountsaervice.createAccount(accountmodel);
		
		return new ResponseEntity<AccountModel>(acc, HttpStatus.OK);
	}
	
	@GetMapping("/acc/{id}")
	public ResponseEntity<AccountModel> getAccount(@PathVariable Long id){
		 
		AccountModel acc =  accountsaervice.getAccountById(id);
		
		return ResponseEntity.ok(acc);
}
	
	
	@PutMapping("/{id}/deposite")
	public ResponseEntity<AccountModel> deposite(@PathVariable Long id, @RequestBody Map<String, Double> request){
	
		Double amount= request.get("amount");
		
		AccountModel accountmodel =accountsaervice.deposite(id, amount);
		
		return ResponseEntity.ok(accountmodel);
		
	}
	
	
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountModel> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request){
		
		Double amount =request.get("amount");
		
		AccountModel accountmodel =accountsaervice.withdraw(id,amount );
		
		
		return ResponseEntity.ok(accountmodel);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<AccountModel>> getAllAccounts(){
		
		List<AccountModel> accountmodel =  accountsaervice.allAccounts();
		
		return ResponseEntity.ok(accountmodel);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAccountByid( @PathVariable Long id){
	
		accountsaervice.deleteAccount(id);
		return ResponseEntity.ok("account sussfully deleted");
		
	}
	
	
	
	
}