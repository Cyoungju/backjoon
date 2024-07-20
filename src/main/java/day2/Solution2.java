package day2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        // 별찍기1 - 2438번
        // 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제

        // 중첩 반복문을 사용

        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int inputNum = sc.nextInt();

        for(int i = 1; i <= inputNum; i++) {
            for(int j = 0; j < i; j++){
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.close();


    }
}
