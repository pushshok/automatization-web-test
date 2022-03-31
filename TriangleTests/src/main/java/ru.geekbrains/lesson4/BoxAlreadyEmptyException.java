package ru.geekbrains.lesson4;

public class BoxAlreadyEmptyException extends Exception {
        public BoxAlreadyEmptyException(String s) {
            System.out.println(s);
        }
}
