package com.hks;

import com.hks.core.Console;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    private Account account;

    @Mock
    private Console console;

    @Before
    public void setUp() {
        account = Account.create(console);
    }

    @Test
    public void should_increase_balance_when_make_deposit() {
        account.deposit(30L, "2019-09-10");

        assertThat(account.getBalance()).isEqualTo(30L);
    }

    @Test
    public void should_throw_exception_when_make_deposit_with_negative_amount() {
        assertThatThrownBy(() -> account.deposit(-30L, "2019-09-10"))
                .isInstanceOf(NegativeAmountException.class)
                .hasMessage("Business Error: Negative amounts are not allowed.");
    }

    @Test
    public void should_decrease_account_balance_when_make_withdraw() {
        account.deposit(50L, "2019-09-10");

        account.withdraw(20L, "2019-09-10");

        assertThat(account.getBalance()).isEqualTo(30L);
    }

    @Test
    public void should_throw_exception_when_make_withdraw_with_negative_amount() {
        account.deposit(50L, "2019-09-10");

        assertThatThrownBy(() -> account.withdraw(-30L, "2019-09-10"))
                .isInstanceOf(NegativeAmountException.class)
                .hasMessage("Business Error: Negative amounts are not allowed.");
    }

    @Test
    public void should_store_history_of_all_statements() {
        account.deposit(50L, "2019-09-09");
        account.withdraw(30L, "2019-09-10");
        account.deposit(20L, "2019-09-11");
        account.deposit(40L, "2019-09-12");

        List<Statement> statements = account.getStatements();

        Assertions.assertThat(statements).containsExactly(
                Statement.createDeposit(Amount.of(50L), "2019-09-09", Balance.of(0L)),
                Statement.createWithdrawal(Amount.of(30L), "2019-09-10", Balance.of(50L)),
                Statement.createDeposit(Amount.of(20L), "2019-09-11", Balance.of(20L)),
                Statement.createDeposit(Amount.of(40L), "2019-09-12", Balance.of(40L))
        );
    }

    @Test
    public void should_print_statements() {
        account.deposit(50L, "2019-09-09");
        account.withdraw(30L, "2019-09-10");
        account.deposit(20L, "2019-09-11");
        account.deposit(60L, "2019-09-12");

        account.printStatement();

        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).printLine("| operation | date | amount | balance |");
        inOrder.verify(console).printLine("| DEPOSIT | 2019-09-09 | 50 | 0 |");
        inOrder.verify(console).printLine("| WITHDRAWAL | 2019-09-10 | 30 | 50 |");
        inOrder.verify(console).printLine("| DEPOSIT | 2019-09-11 | 20 | 20 |");
        inOrder.verify(console).printLine("| DEPOSIT | 2019-09-12 | 60 | 40 |");
    }


}
