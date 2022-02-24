package org.lailsonbento.bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

	@Test
	public void depositAnAmountToIncreaseBalance() {
		Account account = new Account();
		account.deposit(BigDecimal.TEN);

		assertEquals(account.getBalance(), BigDecimal.TEN);
	}

	@Test
	public void createAccountAndBalanceIsZero() {
		Account account = new Account();
		assertEquals(account.getBalance(), BigDecimal.ZERO);
	}

	@Test
	public void depositingMultipleAmounts() {
		Account account = new Account();
		account.deposit(BigDecimal.valueOf(100));
		account.deposit(BigDecimal.valueOf(300));
		assertEquals(account.getBalance(), BigDecimal.valueOf(400));
	}

	@Test
	public void withdrawAmount() {
		Account account = new Account();
		account.withdraw(BigDecimal.valueOf(100));
		assertEquals(account.getBalance(), BigDecimal.valueOf(100).negate());
	}

	@Test
	public void depositAndWithdrawAmount() {
		Account account = new Account();
		account.deposit(BigDecimal.valueOf(400));
		account.withdraw(BigDecimal.valueOf(100));
		assertEquals(account.getBalance(), BigDecimal.valueOf(300));
	}

	@Test
	public void transferAmountFromAccountToAnother() {
		Account account1 = new Account(), account2 = new Account();
		account1.deposit(BigDecimal.valueOf(100));
		account1.transfer(BigDecimal.valueOf(100), account2);
		assertEquals(account1.getBalance(), BigDecimal.ZERO);
		assertEquals(account2.getBalance(), BigDecimal.valueOf(100));

	}
}