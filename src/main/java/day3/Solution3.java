package day3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {
    static String [][] num;
    static int x,y;
    public static void main(String[] args) throws IOException {
        // 별찍기 19 - 10994번

        // 01234
        // 0   4
        // 0 2 4
        // 0   4
        // 01234

        // 행y 열x +2 씩
        // 첫번째/ 마지막 열에는 전부 다 찍기
        // 나머지 열에는 첫번째와 마지막만 찍기



        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        num = new String[4 * (n - 1) + 1][4 * (n - 1) + 1];
        x=0; //x축 죄표
        y=0; //y축 좌표

        int total = 4 * (n - 1) + 1;

        // null 값이 안들어가게 공백(" ") 넣어주기
        for(int i = 0;i < total; i++){
            for(int j = 0;j < total; j++){
                num[i][j] = " ";
            }
        }

        line(n);

        // 출력
        for(int i = 0;i < total; i++){
            for(int j = 0;j < total; j++){
                System.out.print(num[i][j]);
            }
            System.out.println();
        }

    }

    // * 모양 배열에 넣어주는 함수
    static void line(int n){
        if(n!=0){
            int total = 4 * (n - 1) + 1; // n값의 별의 길이

            // 첫번째 모든 자리 * 넣기
            for (int i = 0; i <total; i++) {
                //첫번째줄 출력
                num[x][y+i] = "*";
                // 마지막줄 출력
                num[x+total -1][y+i] = "*";
            }
            // 나머지 가장자리 찍어주기
            for (int i = 0; i < total -1; i++) {
                num[x+1+i][y] = "*";
                num[x+1+i][y+total-1] = "*";
            }

            x +=2;
            y +=2;
            line(n - 1);
        }

    }
}
