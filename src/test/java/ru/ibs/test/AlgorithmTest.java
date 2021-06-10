package ru.ibs.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmTest {

    private Algorithm algorithm;
    final Scanner mockedScanner = Mockito.mock(Scanner.class);


    @BeforeEach
    void init() {
        algorithm = new Algorithm();
        Mockito.when(mockedScanner.hasNextLine()).thenReturn(true);
    }

    @Test
    void testChangeLine1() {
        algorithm.setLines(Arrays.asList("1"));
        assertEquals("1\n", algorithm.changeLine());
    }

    @Test
    void testChangeLine2() {
        algorithm.setLines(Arrays.asList("2"));
        assertEquals("2\n", algorithm.changeLine());
    }

    @Test
    void testChangeLine3() {
        algorithm.setLines(Arrays.asList("2", "3", "45", "55"));
        assertEquals("2\nFizz\nFizzBuzz\nBuzz\n", algorithm.changeLine());
    }

    @Test
    void checkFile1() {
        Mockito.when(mockedScanner.nextLine()).thenReturn("lalala");
        MyException thrown = assertThrows(MyException.class, () -> {
            algorithm.checkFile(mockedScanner);
        });
        assertTrue(thrown.getMessage().equals("file is not OK"));
    }

    @Test
    void checkFile2() {
        Mockito.when(mockedScanner.nextLine()).thenReturn("12").thenReturn("15").thenReturn("lalala");
        MyException thrown = assertThrows(MyException.class, () -> {
            algorithm.checkFile(mockedScanner);
        });
        assertTrue(thrown.getMessage().equals("file is not OK"));
    }
}