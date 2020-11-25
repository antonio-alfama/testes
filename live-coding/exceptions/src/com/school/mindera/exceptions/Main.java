package com.school.mindera.exceptions;

public class Main {

    public static void main(String[] args) {
        try {
            readFile("batata.txt");
        } catch (CustomException ex) {
            System.out.println("Error");
        } finally {
            System.out.println("Always runs!");
        }
    }

    private static void readFile(String fileName) throws CustomException {
        throw new CustomException(fileName);
    }
}


