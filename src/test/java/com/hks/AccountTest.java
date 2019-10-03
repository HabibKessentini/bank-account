package com.hks;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class AccountTest {

    @Test
    public void should_increase_balance_when_make_deposit() {
        Account account = Account.create();

        account.deposit(30L, "2019-09-10");

        assertThat(account.getBalance()).isEqualTo(30L);
    }

    @Test
    public void should_throw_exception_when_make_deposit_with_negative_amount() {
        Account account = Account.create();

        assertThatThrownBy(() -> account.deposit(-30L, "2019-09-10"))
                .isInstanceOf(NegativeAmountException.class)
                .hasMessage("Business Error: Negative amounts are not allowed.");
    }

    @Test
    public void should_decrease_account_balance_when_make_withdraw() {
        Account account = Account.create();
        account.deposit(50L, "2019-09-10");

        account.withdraw(20L, "2019-09-10");

        assertThat(account.getBalance()).isEqualTo(30L);
    }

    @Test
    public void should_throw_exception_when_make_withdraw_with_negative_amount() {
        Account account = Account.create();
        account.deposit(50L, "2019-09-10");

        assertThatThrownBy(() -> account.withdraw(-30L, "2019-09-10"))
                .isInstanceOf(NegativeAmountException.class)
                .hasMessage("Business Error: Negative amounts are not allowed.");
    }

    @Test
    public void should_store_history_of_all_statements() {
        Account account = Account.create();
        account.deposit(50L, "2019-09-09");
        account.withdraw(30L, "2019-09-10");
        account.deposit(20L, "2019-09-11");
        account.deposit(40L, "2019-09-12");

        List<Statement> statements = account.getStatements();

        assertThat(statements).containsExactly(
                new Statement(Amount.of(50L), "2019-09-09", Balance.of(0L), "deposit"),
                new Statement(Amount.of(30L), "2019-09-10", Balance.of(50L), "withdraw"),
                new Statement(Amount.of(20L), "2019-09-11", Balance.of(20L), "deposit"),
                new Statement(Amount.of(40L), "2019-09-12", Balance.of(40L), "deposit")
        );
    }


}
