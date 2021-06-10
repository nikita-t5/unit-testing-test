package ru.ibs.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String path = args[0];
        File file = new File(path);
        Algorithm algorithm = null;
        try {
            algorithm = new Algorithm(file);
            Scanner scanner = new Scanner(file);
            algorithm.checkFile(scanner);
            System.out.println(algorithm.changeLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MyException myExeption) {
            System.out.println(myExeption.getMessage());
        }
    }
}
