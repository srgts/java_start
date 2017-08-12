package ru.firstProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public Main() {
        start();
    }

    protected final int min = -273;
    protected final int max = 5526;
    protected final int res = startResultVal(min, max);


    public int getRes() {
        return res;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] numArr = main.getNumArr();
        int res = main.getRes();
        res = main.takeRes(numArr, res);
        main.result(res);
    }

    protected int takeRes(int[] numArr, int res) {
        for (int i = 0; i < numArr.length; i++) {
            int x = numArr[i];
            if (isCorrectNum(x)) {
                if (Math.abs(x) < Math.abs(res) || Math.abs(x) == Math.abs(res) && x > res) {
                    res = x;
                }
            } else {
                printError();
                res = 0;
            }
        }
        return res;
    }


    protected boolean isCorrectNum(int val) {
        if (val > max || val < min) {
            return false;
        }
        return true;
    }

    protected void printError() {
        System.out.println("Введены некорректные данные");
    }

    private int startResultVal(int a, int b) {
        if (Math.abs(a) > Math.abs(b)) {
            return a;
        } else return b;
    }

    public int[] getNumArr() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numArr[];
        try {
            String input = br.readLine();
            String strArr[] = input.split(" ");
            numArr = new int[strArr.length];

            for (int i = 0; i < strArr.length; i++) {
                numArr[i] = Integer.parseInt(strArr[i]);
            }
            return numArr;
        } catch (Exception e) {
            printError();
            int res = 0;
            result(res);
            System.exit(0);
        }
        return null;
    }

    public void start() {
        System.out.println("Введите целые числа от " + getMin() + " до " + getMax() + " через пробел:");
    }

    protected void result(int res) {
        System.out.println("Результат = " + res);
    }

}