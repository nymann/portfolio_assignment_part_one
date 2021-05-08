package dev.nymann;


import dev.nymann.presentation.Client;
public class Main {
    public static void main(String[] args) {
        try {
            new Client();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}