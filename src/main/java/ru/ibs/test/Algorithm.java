package ru.ibs.test;

import org.apache.commons.lang3.math.NumberUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Algorithm {

    List<String> lines;
    File file;

    public Algorithm() {
    }

    public Algorithm(File file) throws FileNotFoundException {
        this.file = file;
        this.lines = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();
    }

    public String changeLine() {
        StringBuffer sb = new StringBuffer();
        for (String line : lines) {
            int num = Integer.parseInt(line);
            boolean divideTree = (num % 3) == 0;
            boolean divideFive = (num % 5) == 0;
            if (divideTree)
                sb.append("Fizz");
            if (divideFive)
                sb.append("Buzz");
            if (!divideTree && !divideFive)
                sb.append(num);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void checkFile(Scanner scanner) throws MyException {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!NumberUtils.isCreatable(line)) {
                scanner.close();
                throw new MyException("file is not OK");
            }
        }
        scanner.close();
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }
}
