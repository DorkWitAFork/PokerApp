package org.example;
import database.CreateTable;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!");
        System.out.println("Attempting to create DB tables");
        CreateTable.initialize();
    }
}
