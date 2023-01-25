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

    public static int suitSwipe(char suit) {
        int numCode;

        switch (suit) {
            case 'S':
                numCode = 3;
                break;
            case 'H':
                numCode = 2;
                break;
            case 'D':
                numCode = 1;
                break;
            case 'C':
                numCode = 0;
                break;
            default:
                numCode = -1;
        }

        return numCode;
    }

    public static String[] pokerSort(String[] deck) {
        String temp;

        for (int i = 0; i < deck.length; i++) {
            for (int j = 1; j < (deck.length - i); j++) {
                int D1 = Integer.parseInt(deck[j - 1].substring(1));
                int D2 = Integer.parseInt(deck[j].substring(1));
                if (D1 < D2) {
                    temp = deck[j - 1];
                    deck[j - 1] = deck[j];
                    deck[j] = temp;
                }
            }
        }

        for (int i = 0; i < deck.length; i++) {
            for (int j = 1; j < deck.length; j++) {
                String D1 = deck[j - 1].substring(1);
                String D2 = deck[j].substring(1);

                if (D1.equals(D2)) {
                    if (suitSwipe(deck[j - 1].charAt(0)) < suitSwipe(deck[j].charAt(0))) {
                        temp = deck[j - 1];
                        deck[j - 1] = deck[j];
                        deck[j] = temp;
                    }
                }
            }
        }

        return deck;
    }

    public static boolean isStraightFlush(String[] deck) {
        char suit = deck[0].charAt(0);
        boolean isFlush = true;
        for (int i = 1; i < deck.length; i++) {
            if (suit != deck[i].charAt(0)) {
                isFlush = false;
                break;
            }
        }
        int cd1, cd2;

        for (int i = 0; i < deck.length - 1; i++) {
            cd1 = Integer.parseInt(deck[i].substring(1)) + 12;
            cd2 = Integer.parseInt(deck[i + 1].substring(1)) + 12;
            if (cd1 - cd2 != 1) {
                isFlush = false;
                break;
            }
        }

        return isFlush;
    }

    public static int deckSum(String[] deck) {
        int sum = 0;
        for (int i = 0; i < deck.length; i++) {
            sum += Integer.parseInt(deck[i].substring(1));
        }
        return sum;
    }

    public static Boolean isFourOfKind(String[] deck) {
        Boolean isFour = false;
        int count;

        for (int i = 0; i < deck.length; i++) {
            count = 1;
            for (int j = 0; j < deck.length; j++) {
                if (i != j && deck[i].substring(1).equals(deck[j].substring(1))) {
                    count += 1;
                }
            }
            if (count == 4) {
                isFour = true;
                break;
            }
        }
        return isFour;
    }

    public static Boolean isFullHouse(String[] deck) {
        Boolean isFull = false;
        int[] numList = new int[5];
        int numCount = 1;
        int tempCount = 1;
        int typeCount = 1;
        int num;

        for (int i = 0; i < deck.length; i++) {
            numList[i] = Integer.parseInt(deck[i].substring(1));
        }

        for (int i = 0; i < numList.length - 1; i++) {
            if (numList[i] != numList[i + 1]) {
                typeCount += 1;
                numCount = 1;
            } else {
                numCount += 1;
                if (tempCount < numCount) {
                    tempCount = numCount;
                }
            }
        }

        if (typeCount == 2 && tempCount == 3) {
            isFull = true;
        }

        return isFull;
    }


    public static int deckType(String[] deck) {
        int code = 0;

        if (isStraightFlush(deck)) {
            code = 8;
        } else if (isFourOfKind(deck)) {
            code = 7;
        } else if (isFullHouse(deck)) {
            code = 6;
        }/* else if (isStraight(deck)) {
            code = 5;
        } else if () {
            code = 4;
        } else if () {
            code = 3;
        } else if () {
            code = 2;
        } else if () {
            code = 1;
        }
       */

        return code;
    }
}
