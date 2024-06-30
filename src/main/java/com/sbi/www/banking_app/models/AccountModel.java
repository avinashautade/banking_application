package com.sbi.www.banking_app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class AccountModel {



		private Long id;

		private String accountHolderName;

		private Double balance;

	

}
