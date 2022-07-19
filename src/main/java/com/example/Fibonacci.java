package com.example;


import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Please enter a number: ");

            try {
                int userNumber = input.nextInt();
                printFibonacciUpTo(userNumber);
            } catch (InputMismatchException e) {
                BigInteger userNumber = input.nextBigInteger();
                printFibonacciUpTo(userNumber);
            }

        } catch (Exception ignored) {

        }
    }

    // Print Fibonacci up to and including the inputted number
    public static void printFibonacciUpTo(int series) {
        Stream<Integer> fibonacci = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).map(n -> n[0]).takeWhile(z -> z <= series);
        String results = fibonacci.map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(results);
    }

    // Overloaded method to also print Fibonacci up to and including the inputted number if it's too big to be an int
    public static void printFibonacciUpTo(BigInteger series) {
        Stream<BigInteger> fibonacci = Stream.iterate(new BigInteger[]{BigInteger.valueOf(0), BigInteger.valueOf(1)}, t
                -> new BigInteger[]{t[1], t[0].add(t[1])}).map(n -> n[0]).takeWhile(z -> z.compareTo(series) <= 0);
        String results = fibonacci.map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(results);
    }

}
