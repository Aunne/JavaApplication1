package javaapplication1;

import java.util.Scanner;

public class myLib {
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String input(String str) {
        System.out.print(str);
        String str1 = "";
        Scanner scan = new Scanner(System.in);
        if (scan.hasNext()) {
            str1 = scan.nextLine();
        }
        return str1;
    }

    public static int[] bubble(int[] numList) {
        int temp = 0;
        for (int i = 0; i < numList.length; i++) {
            for (int j = 1; j < (numList.length - i); j++) {
                if (numList[j - 1] < numList[j]) {
                    temp = numList[j - 1];
                    numList[j - 1] = numList[j];
                    numList[j] = temp;
                }
            }
        }
        return numList;
    }

    public static int max(int[] num) {
        int maxNum = num[0];
        for (int i = 0; i < num.length; i++) {
            if (maxNum < num[i]) {
                maxNum = num[i];
            }
        }
        return maxNum;
    }

    public static int min(int[] num) {
        int minNum = num[0];
        for (int i = 0; i < num.length; i++) {
            if (minNum > num[i]) {
                minNum = num[i];
            }
        }
        return minNum;
    }
}
