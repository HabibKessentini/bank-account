package com.hks;

import com.hks.core.Console;

import java.util.List;

public class StatementPrinter {

    private static final String HEADER = "| operation | date | amount | balance |";

    private Console console;

    private StatementPrinter(Console console) {
        this.console = console;
    }

    static StatementPrinter create(Console console) {
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
