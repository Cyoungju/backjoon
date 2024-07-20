package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution4 {
    static int [][][] num = new int[21][21][21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1){
                break;
            }

            sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(dp(a ,b ,c)).append('\n');
        }
        System.out.println(sb);
    }

    // -> 동적 프로그래밍
    static int dp(int a, int b, int c){

        // 기저 조건: a, b, c 중 하나라도 0 이하일 때 1을 반환
        if(a <= 0 || b <= 0 || c <= 0){
            return 1;
        }

        // 기저 조건: a, b, c 중 하나라도 20을 초과할 때 w(20, 20, 20)을 호출
        if(a > 20 || b > 20 || c > 20){
            return dp(20,20,20);
        }

        // 메모이제이션: 이미 계산된 값이 있는 경우 그 값을 반환
        if(num[a][b][c] != 0){
            return num[a][b][c];
        }

        // a < b < c 인 경우의 재귀 호출
        if(a < b && b < c){
            num[a][b][c] = dp(a, b, c - 1) + dp(a, b - 1, c - 1) - dp(a, b - 1, c);
        }else{
            // 그 외의 경우에 대한 재귀 호출
            num[a][b][c] = dp(a - 1, b, c) + dp(a - 1, b - 1, c) + dp(a - 1, b, c - 1) - dp(a - 1, b - 1, c - 1);
        }

        // 계산된 값을 반환
        return num[a][b][c];
    }
    // 똑같이 재귀를 쓰지만 메모지네이션 활용
    // 처음 방문하는 재귀라면 계산을 통해 얻은 값을 메모리에 저장하고, 이후 재방문 할 경우 다시 계산하는 것이 아닌 저장된 값을 가지고 오는방법
    // 동적 프로그래밍
    //


}
