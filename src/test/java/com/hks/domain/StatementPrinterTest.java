package com.hks.domain;

import com.hks.core.ConsolePrinter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterTest {

    @Mock
    private ConsolePrinter console;

    @Test
    public void should_print_statements() {
        StatementPrinter statementPrinter = StatementPrinter.create(console);
        List<Statement> statements = newArrayList(
                Statement.createDeposit(Amount.of(50L), "2019-09-09", Balance.of(0L)),
                Statement.createWithdrawal(Amount.of(30L), "2019-09-10", Balance.of(50L)),
                Statement.createDeposit(Amount.of(20L), "2019-09-11", Balance.of(20L)),
                Statement.createDeposit(Amount.of(60L), "2019-09-12", Balance.of(40L))
        );

        statementPrinter.print(statements);

        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).printLine("| operation | date | amount | balance |");
        inOrder.verify(console).printLine("| DEPOSIT | 2019-09-09 | 50 | 0 |");
        inOrder.verify(console).printLine("| WITHDRAWAL | 2019-09-10 | 30 | 50 |");
        inOrder.verify(console).printLine("| DEPOSIT | 2019-09-11 | 20 | 20 |");
        inOrder.verify(console).printLine("| DEPOSIT | 2019-09-12 | 60 | 40 |");
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void should_print_header_when_statements_is_empty() {
        StatementPrinter statementPrinter = StatementPrinter.create(console);

        statementPrinter.print(newArrayList());

        verify(console, times(1)).printLine("| operation | date | amount | balance |");
    }

}
