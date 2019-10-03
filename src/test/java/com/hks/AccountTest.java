package com.hks;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class AccountTest {

    @Test
    public void should_increase_balance_when_make_deposit() {
        Account account = Account.create();

        account.deposit(30L);

        assertThat(account.getBalance()).isEqualTo(30L);
    }

    @Test
    public void should_throw_exception_when_make_deposit_with_negative_amount() {
        Account account = Account.create();

        assertThatThrownBy(() -> account.deposit(-30L))
                .isInstanceOf(NegativeAmountException.class)
                .hasMessage("Business Error: Negative amounts are not allowed.");
    }

    @Test
    public void should_decrease_account_balance_when_withdraw() {
        Account account = Account.create();
        account.deposit(50L);

        account.withdraw(20L);

        assertThat(account.getBalance()).isEqualTo(30L);
    }

}
