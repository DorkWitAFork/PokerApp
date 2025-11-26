package org.example;
import database.CreateTable;
import ui.MainFrame;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!");
        System.out.println("Attempting to create DB tables");
        CreateTable.initialize();

        System.out.println("Attempting to create a main frame");
        new MainFrame();
    }
}
