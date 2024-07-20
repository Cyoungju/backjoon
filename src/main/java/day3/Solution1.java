package day3;

import java.io.IOException;
import java.util.Scanner;

public class Solution1 {
    static int count1, count2;
    static int[] f;

    public static void main(String[] args) throws IOException {
        // 알고리즘 수업 - 피보나치 수 1 - 24416번

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        f = new int[num];

        count1 = 0;
        count2 = 0;


        fib(num);
        fibonacci(num);

        System.out.println(count1 +","+ count2);

    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            count1++;
            return f[n] = 1;
        }
        else {
            return (fib(n - 1) + fib(n - 2));
        }
    }

    static int fibonacci(int n) {
        f[0] = 1;
        f[1] = 1;

        for(int i = 2; i < n; i++){
            f[i] = f[i - 1] + f[i - 2];
            count2 ++;
        }
        return f[n-1];
    }
}
