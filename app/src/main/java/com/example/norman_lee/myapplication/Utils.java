package com.example.norman_lee.myapplication;

public class Utils {
    static void checkInvalidInputs(String value) {
        if (value.equals("0") || value.substring(0,1).equals("-")) {
            throw new IllegalArgumentException("please enter a positive number");
        }
        else if (value.isEmpty()) {
            throw new NumberFormatException();
        }
    };
}
