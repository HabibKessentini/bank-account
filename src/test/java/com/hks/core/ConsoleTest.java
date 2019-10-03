package com.hks.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConsoleTest {

    private Console console;
    private PrintStream sysOut;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        console = new Console();
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(sysOut);
    }

    @Test
    public void should_print_line() {
        console.printLine("Test print");

        assertThat(outContent.toString()).isEqualToIgnoringNewLines("Test print");
    }

}
