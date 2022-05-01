package ru.job4j.tracker.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus (int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {

        int result = sum(10);
        System.out.println(result);

        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(10);
        System.out.println(rsl);

        int rslMinus = minus(10);
        System.out.println(rslMinus);

        Calculator calcDiv = new Calculator();
        int rslDiv = calcDiv.divide(10);
        System.out.println(rslDiv);
        int rslSumAll = calcDiv.sumAllOperation(10);
        System.out.println(rslSumAll);
    }
}
