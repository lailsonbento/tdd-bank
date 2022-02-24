package org.lailsonbento.bank;

import java.math.BigDecimal;

public class Account {

	private BigDecimal balance;

	public Account() {
		this.balance = BigDecimal.ZERO;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void deposit(BigDecimal amount) {
		this.balance = this.balance.add(amount);
	}

	public void withdraw(BigDecimal amount) {
		this.balance = this.balance.subtract(amount);
	}

	public void transfer(BigDecimal transferAmount, Account receivingAccount) {
		if (transferAmount.compareTo(balance) <= 0) {
			this.withdraw(transferAmount);
			receivingAccount.deposit(transferAmount);
		}
	}
}
