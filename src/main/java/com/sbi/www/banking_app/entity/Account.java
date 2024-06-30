package com.sbi.www.banking_app.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name="accounts")
public class Account {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="account_holder_name")
	private String accountHolderName;
	
	@Column
	private Double balance;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
	
	

}
