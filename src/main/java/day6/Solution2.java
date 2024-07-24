package day6;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution2 {

    // 알고리즘 수업 - 점근적 표기 1 24313번
    // 함수 f(n) = a1n+a0 = O(g(n))
    // 첫번째 줄 정수 a1 / a0
    // 두번째 줄 정수 c
    // 세번째 줄 n0
    // 모든 n ≥ n0에 대하여 f(n) ≤ c × g(n)인

    // 7 7
    // 8
    // 1

    // f(n) = 7n+7
    // g(n) = n
    // c = 8;
    // n0 = 1
    // f(1) = 14
    // c* g(1) = 8
    //

    public static void main(String[] args) {

        // n을 구하는 공식
        // g(n) = n

        // n0 = 세번째줄

        // f(n)  ≤ c × g(n)
        // f(n) = a1 + a0 => 첫번째줄 숫자 2개

        // c = 두번째줄

        // n > n0
        // a1*n + a0 ≤ c * n; -> 해당 값이 맞는지 확인 하기



        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(sc.nextLine());
        int n0 = Integer.parseInt(sc.nextLine());

        sc.close();

        // a0 <= c*n - a1*n
        // a0 <= (c - a1) *n
        // c는 양의 정수 이기 때문에 c > a1
        //
        if (c >= a1 && a0 <= (c - a1) * n0) { // 참이면
           System.out.println(1);
       }else {
           System.out.println(0);
       }
    }
}
