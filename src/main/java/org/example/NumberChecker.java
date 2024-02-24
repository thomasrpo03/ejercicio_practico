package org.example;

import java.util.Scanner;

public class NumberChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un número positivo");
        int number = scanner.nextInt();

        if (number % 2 != 0){
            System.out.println("Quipux");
        } else {
            if(number >= 2 && number <= 5){
                System.out.println("No Quipux");
            } else if (number >= 6 && number <= 20 ) {
                System.out.println("Quipux");
            } else {
                System.out.println("No Quipux");
            }
        }
    }
}
