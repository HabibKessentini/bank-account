package com.hks;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void should_increase_balance_when_make_deposit() {
        Account account = Account.create();

        account.deposit(30L);

        assertThat(account.getBalance()).isEqualTo(30L);
    }

    @Test
    public void should_decrease_account_balance_when_withdraw() {
        Account account = Account.create();
        account.deposit(50L);

        account.withdraw(20L);

        assertThat(account.getBalance()).isEqualTo(30L);
    }

}
