package com.hks.domain;

import com.hks.core.ConsolePrinter;

import java.util.List;

public class StatementPrinter {

    private static final String HEADER = "| operation | date | amount | balance |";

    private ConsolePrinter console;

    private StatementPrinter(ConsolePrinter console) {
        this.console = console;
    }

    static StatementPrinter create(ConsolePrinter console) {
        return new StatementPrinter(console);
    }

    void print(List<Statement> statements) {
        console.printLine(HEADER);
        statements.forEach(this::printLine);
    }

    private void printLine(Statement statement) {
        String line = "| " + statement.getOperationType() +
                " | " + statement.getDate() +
                " | " + statement.getAmount().getValue() +
                " | " + statement.getInitialBalance().getValue() + " |";
        console.printLine(line);
    }


}
