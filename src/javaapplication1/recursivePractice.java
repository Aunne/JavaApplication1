package javaapplication1;

public class recursivePractice {
    public static void main(String[] args) {
        recursionHanoiTower();
    }

    public static void recursionFee() {
        int tmp1 = 1;
        int tmp2 = 1;
        int sum = 0;
        int n = 5;

        for (int i = 2; i <= n; i++) {
            sum = tmp2 + tmp1;
            tmp1 = tmp2;
            tmp2 = sum;
        }

        System.out.println(sum);
        System.out.println(fibonacci(5));
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 0)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void recursionHanoiTower() {
        hanoiTower(3, 'A', 'B', 'C');
    }

    public static void hanoiTower(int n, char from, char tmp, char to) {
        if (n <= 1)
            System.out.printf("Disk %d from %c to %c\n", n, from, to);
        else {
            hanoiTower(n - 1, from, to, tmp);
            System.out.printf("Disk %d from %c to %c\n", n, from, to);
            hanoiTower(n - 1, tmp, from, to);
        }
    }

}
