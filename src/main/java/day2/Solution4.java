package day2;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution4 {
    public static void main(String[] args) throws IOException {
        // 뜨거운 붕어빵 - 11945번
        // 행과 열 - 다차원 배열
        // 한행의 데이터를 거꾸로 뒤집어야함
        // 반복문을 사용
        // 거꾸로 뒤집어서 복사할 배열 만들어주기
        // 받은 입력과 출력을 해야하기때문에 BufferedReader / BufferedWriter

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        int[][] array = new int[row][column];
        int[][] reverseArr = new int[row][column];


        // 한줄씩 읽어서 array배열에 넣어줌
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < column; j++) {
                array[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
            //원본 배열의 마지막 인덱스 (array[i][j].length -1)부터 탐색하기
            //거꾸로 배열 순서대로 값 세팅
            for(int k = array[i].length -1, q = 0; k >=0;k--,q++){
                reverseArr[i][q] = array[i][k];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sb.append(reverseArr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
