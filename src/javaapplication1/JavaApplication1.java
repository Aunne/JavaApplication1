package javaapplication1;

import java.util.Scanner;

public class JavaApplication1 {

    public static void main(String[] args) {
    /*
        執行題目
     */
        topic6();
    }

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

    public static void topic1() {
        //
        // 找出數字字串中最大的質數
        //
        String str = input("輸入一個正整數: ");
        int strLenth = str.length();
        int number;
        int maxPrime = 0;
        for (int numLen = strLenth; numLen >= 0; numLen--) {
            for (int i = 0; i + numLen < strLenth; i++) {
                number = Integer.parseInt(str.substring(i, (i + numLen + 1)));
                if (isPrime(number)) {
                    if (number > maxPrime) {
                        maxPrime = number;
                    }
                }
            }
            if (maxPrime != 0) {
                break;
            }
        }
        if (maxPrime != 0) {
            System.out.println("最大質數為: " + maxPrime);
        } else {
            System.out.println("No prime found");
        }
    }

    public static void topic2() {
        //
        // 電費計算
        //
        float summer = 0f;
        float nonSummer = 0f;
        int degree = 0;

        degree = Integer.parseInt(input("輸入一個正整數: "));

        if (degree <= 120) {
            summer = 2.10f * (float) degree;
            nonSummer = 2.10f * (float) degree;
        } else if (degree <= 330) {
            summer = 252 + 3.02f * ((float) (degree - 120));
            nonSummer = 252 + 2.68f * ((float) (degree - 120));
        } else if (degree <= 500) {
            summer = 886.2f + 4.39f * ((float) (degree - 330));
            nonSummer = 814.8f + 3.61f * ((float) (degree - 330));
        } else if (degree <= 700) {
            summer = 1632.5f + 4.97f * ((float) (degree - 500));
            nonSummer = 1428.5f + 4.01f * ((float) (degree - 500));
        } else {
            summer = 2626.5f + 5.63f * ((float) (degree - 700));
            nonSummer = 2230.5f + 4.50f * ((float) (degree - 700));
        }
        System.out.printf("summer month: %.2f\n", summer);
        System.out.printf("non-summer month: %.2f\n", nonSummer);
    }

    public static void topic3() {
        //
        //生肖
        //
        String[] zodiac = {"rat", "ox", "tiger", "rabbit", "dragon", "snake", "horse", "sheep", "monkey", "rooster", "dog", "pig"};

        int year;
        year = Integer.parseInt(input("輸入一個正整數: ")) - 4;
        int zodiacIndex = year % 12;
        if (zodiacIndex < 0) {
            zodiacIndex += 12;
        }
        System.out.println(zodiac[zodiacIndex]);
    }

    public static void topic4() {
        //
        // 2D座標判斷及計算離原點距離
        //

        int x, y;
        x = Integer.parseInt(input("X坐標軸: "));
        y = Integer.parseInt(input("Y坐標軸: "));

        if (x == 0) {
            if (y == 0) {
                System.out.println("該點位於原點");
            } else {
                if (y > 0) {
                    System.out.printf("此點位於上半平面Y軸上，離原點距離為根號 %d\n", (y * y));
                } else {
                    System.out.printf("此點位於下半平面Y軸上，離原點距離為根號 %d\n", (y * y));
                }
            }
        } else {
            if (x > 0) {
                if (y == 0) {
                    System.out.printf("該點位於右半平面X軸上，離原點距離為根號 %d\n", (x * x));
                } else {
                    if (y > 0) {
                        System.out.printf("此點位於第一象限，離原點距離為根號 %d\n", (x * x + y * y));
                    } else {
                        System.out.printf("此點位於第四象限，離原點距離為根號 %d\n", (x * x + y * y));
                    }
                }
            } else {
                if (y == 0) {
                    System.out.printf("該點位於左半平面X軸上，離原點距離為根號 %d\n", (x * x));
                } else {
                    if (y > 0) {
                        System.out.printf("此點位於第二象限，離原點距離為根號 %d\n", (x * x + y * y));
                    } else {
                        System.out.printf("此點位於第三象限，離原點距離為根號 %d\n", (x * x + y * y));
                    }
                }
            }
        }
    }

    public static void topic5() {
        //
        //階層判斷
        //
        int M = Integer.parseInt(input("輸入階層值M: "));
        int i = 0, N = 1;

        while (M > N) {
            N *= ++i;
        }
        System.out.printf("超過M為%d的最小階層N為%d", M, i);
    }

    public static void topic6() {
        String myString = input("輸入值為: ");
        int count = 0;
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) != ',') {
                count++;
            }
        }

        int[] myList = new int[count];
        int times = 0;
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) != ',') {
                myList[times] = Character.getNumericValue(myString.charAt(i));
                times++;
            }
        }
        int n = myList.length;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (myList[j - 1] > myList[j]) {
                    temp = myList[j - 1];
                    myList[j - 1] = myList[j];
                    myList[j] = temp;
                }
            }
        }

        int max, min;
        String num = "";
        for (int i = 0; i < myList.length; i++) {
            num = num + myList[i];
        }
        min = Integer.parseInt(num);
        num = "";

        for (int i = myList.length - 1; i >= 0; i--) {
            num = num + myList[i];
        }
        max = Integer.parseInt(num);

        System.out.printf("最大值數列與最小值數列差值為: %d", (max - min));
    }
}

