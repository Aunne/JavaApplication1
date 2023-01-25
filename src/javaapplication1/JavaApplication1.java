//
//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永無BUG
//
//
//


package javaapplication1;

import static javaapplication1.myLib.*;

public class JavaApplication1 {

    public static void main(String[] args) {
    /*
        執行題目
     */
        topic16();

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
        //
        // 兩數差值
        //
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

        myList = bubble(myList);

        int max, min;
        String num = "";
        for (int i = 0; i < myList.length; i++) {
            num = num + myList[i];
        }
        max = Integer.parseInt(num);
        num = "";

        for (int i = myList.length - 1; i >= 0; i--) {
            num = num + myList[i];
        }
        min = Integer.parseInt(num);

        System.out.printf("最大值數列與最小值數列差值為: %d", (max - min));
    }

    public static void topic7() {
        //
        //通話費率
        //
        String typeAndMoney = input("輸入月租費型式及通話費時間為: ");
        int splitPoint = typeAndMoney.indexOf(',');
        String theType = typeAndMoney.substring(0, splitPoint);
        float sec = Float.parseFloat(typeAndMoney.substring(splitPoint + 1, typeAndMoney.length()));
        int money = 0;

        switch (theType) {
            case "186":
                money = (int) (Math.round(sec * 0.09));
                if (money < 186) {
                    money = 186;
                } else if (money <= 372) {
                    money = ((int) Math.round(money * 0.9f));
                } else {
                    money = ((int) Math.round(money * 0.8f));
                }
                break;
            case "386":
                money = (int) (Math.round(sec * 0.08));
                if (money < 386) {
                    money = 386;
                } else if (money <= 772) {
                    money = ((int) Math.round(money * 0.8f));
                } else {
                    money = ((int) Math.round(money * 0.7f));
                }
                break;
            case "586":
                money = (int) (Math.round(sec * 0.07));
                if (money < 586) {
                    money = 586;
                } else if (money <= 1172) {
                    money = ((int) Math.round(money * 0.7f));
                } else {
                    money = ((int) Math.round(money * 0.6f));
                }
                break;
            case "986":
                money = (int) (Math.round(sec * 0.06));
                if (money < 986) {
                    money = 986;
                } else if (money <= 1972) {
                    money = ((int) Math.round(money * 0.6f));
                } else {
                    money = ((int) Math.round(money * 0.5f));
                }
                break;
            default:
                System.out.println("未輸入或錯誤的輸入");
        }
        System.out.printf("通話費為: %d", money);
    }

    public static void topic8() {
        //
        // 檢查數值是否有重複
        //
        int num = Integer.parseInt(input("輸入第一行正整數為: "));
        String originList = input("第二行中數列中的數字為: ");

        int[] numList = new int[num];
        int indexCount = 0;

        for (int i = 0; i < originList.length(); i++) {
            if (Character.isDigit(originList.charAt(i))) {
                numList[indexCount] = Character.getNumericValue(originList.charAt(i));
                indexCount++;
            }
        }
        numList = bubble(numList);
        int count = 1;
        int[] countList = new int[numList.length];
        countList[0] = 1;

        for (int i = 1; i < numList.length; i++) {
            if (numList[i - 1] == numList[i]) {
                count++;
            } else {
                count = 1;
            }
            countList[i] = count;
        }

        int maxCount = max(countList);

        if (maxCount == 1) {
            System.out.println("每個數字剛好只出現一次");
        } else {
            int maxNumber = 0;
            for (int i = 0; i < numList.length; i++) {
                if (countList[i] == maxCount) {
                    maxNumber = numList[i];
                    break;
                }
            }
            System.out.printf("最大出現次數的數字為: %d\n", maxNumber);
            System.out.printf("出現次數為: %d\n", maxCount);
        }
    }

    public static void topic9() {
        //
        // 字根與子字根
        //

        String s1 = input("輸入s1為: ");
        String s2 = input("輸入s2為: ");
        String established = "NO";

        if (s1.length() < s2.length()) {
            for (int i = 0; i <= (s2.length() - s1.length()); i++) {
                if (s2.startsWith(s1, i)) {
                    established = "YES";
                    break;
                }
            }
        }

        System.out.println(established);
    }

    public static void topic10() {
        //
        // 轉置矩陣
        //

        String sizeA = input("輸入N 及 M為: ");
        int N = Integer.parseInt(sizeA.split(" ")[0]);
        int M = Integer.parseInt(sizeA.split(" ")[1]);

        if (N == 0 || M == 0) {
            return;
        }

        int[][] originArr = new int[N][M];
        int[][] newArr = new int[M][N];
        String[] rowArr = new String[N];

        for (int i = 0; i < N; i++) {
            rowArr = input("輸入矩陣數值第" + (i + 1) + "列為: ").split(" ");
            for (int j = 0; j < rowArr.length; j++) {
                originArr[i][j] = Integer.parseInt(rowArr[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newArr[j][i] = originArr[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            System.out.print("輸出矩陣數值第" + (i + 1) + "列為: ");
            for (int j = 0; j < N; j++) {
                System.out.print(newArr[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void topic11() {
        //
        // 星座查詢
        // 與電費類似
        //
    }

    public static void topic12() {
        //
        // 過半元素
        //
        String[] originNum = input("輸入一整數序列為: ").split(" ");
        int count = 1;
        String reNum = "NO";
        for (int i = 0; (i < originNum.length - 1); i++) {
            for (int j = (i + 1); j < originNum.length; j++) {
                if (originNum[i].equals(originNum[j])) {
                    count += 1;
                    if ((count * 2) > originNum.length) {
                        break;
                    }
                }
            }

            if ((count * 2) > originNum.length) {
                reNum = originNum[i];
                break;
            } else {
                count = 1;
            }
        }
        System.out.println("過半元素為: " + reNum);
    }

    public static void topic13() {
        //
        // 回文問題
        //
        String[] originChar = input("輸入一字元為: ").split("");
        int lenIdx = originChar.length - 1;
        String reChar = "yes";

        for (int i = 0; i < (lenIdx / 2); i++) {
            if (!originChar[i].equals(originChar[lenIdx - i])) {
                reChar = "NO";
                break;
            }
        }

        System.out.println(reChar);
    }

    public static void topic14() {
        //
        // 輸入字串算字元
        //
        String str = input("輸入一字元為: ");
        System.out.println("There are " + str.length() + " characters");
    }

    public static void topic15() {
        //
        // 數字加密
        //
        String[] strNumArr = input("輸入一組四位數字為: ").split("");
        int[] numArr = new int[4];
        for (int i = 0; i < 4; i++) {
            numArr[i] = (Integer.parseInt(strNumArr[i]) + 7) % 10;
        }
        int tmp;
        tmp = numArr[0];
        numArr[0] = numArr[2];
        numArr[2] = tmp;

        tmp = numArr[1];
        numArr[1] = numArr[3];
        numArr[3] = tmp;

        for (int i = 0; i < 4; i++) {
            System.out.print(numArr[i]);
        }
    }

    public static void topic16() {
        //
        // 撲克遊戲
        //

        int isContinue = 0;
        String[][] deck = new String[2][];
        int res;
        int[] deckType = new int[2];

        /*
        while (isContinue >= 0) {
            res = -1;
            deck[0] = pokerSort(input("").split(" "));
            deck[1] = pokerSort(input("").split(" "));
            isContinue = Integer.parseInt(input(""));

            deckType[0] = deckType(deck[0]);
            deckType[1] = deckType(deck[1]);


            System.out.println(res);
        }
         */
        deck[0] = pokerSort(input("").split(" "));
        System.out.println(isFullHouse(deck[0]));


    }
}

