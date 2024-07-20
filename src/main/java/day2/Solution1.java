package day2;

import java.io.IOException;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        // 구구단 - 2739번
        // 입력받은 N 으로 N단의 구구단 출력
        // n * 1 = n;
        // n * 2 = n * 2;
        // n * 3 = n * 3;
        // ...
        // 반복문을 사용하여 i값을 증감시켜 구구단 출력하기
        // 입력받는 데이터가 작기 때문에 Scanner사용

        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();

        for(int i = 1; i <= 9; i++) System.out.println(inputNum + " * " + i + " = " +  inputNum*i);

    }
}
