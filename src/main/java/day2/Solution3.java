package day2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) throws IOException {
        // 별찍기8 - 2445번
        // 첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력

        // 중첩 반복문 두개 사용
        // 공백도 같이 출력해주기

        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int inputNum = sc.nextInt();

        for(int i = 1; i <= inputNum; i++) {
            for(int j = 0; j < i; j++){
                bw.write("*");
            }

            for(int j = 0; j < (inputNum*2)-(i*2); j++){
                bw.write(" ");
            }

            for(int j = 0; j < i; j++){
                bw.write("*");
            }

            bw.write("\n");
        }

        for(int i = 1; i <= inputNum-1; i++) {
            for(int j = 0; j < inputNum-i; j++){
                bw.write("*");
            }

            for(int j = 0; j < (inputNum*2)-(inputNum-i)*2; j++){
                bw.write(" ");
            }

            for(int j = 0; j < inputNum-i; j++){
                bw.write("*");
            }

            bw.write("\n");
        }

        bw.close();


    }
}
