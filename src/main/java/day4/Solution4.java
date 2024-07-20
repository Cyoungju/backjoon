package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution4 {
    public static void main(String[] args) throws IOException {
        // 상수 2908번
        // 수의 크기비교
        // 세자리수 두개 - 큰수 말하기
        // StringBuilder reverse - 숫자 비교

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");


        int N = Integer.parseInt(new StringBuilder(tokenizer.nextToken()).reverse().toString());
        int M = Integer.parseInt(new StringBuilder(tokenizer.nextToken()).reverse().toString());

        if(N < M){
            System.out.println(M);
        }else {
            System.out.println(N);
        }
    }
}
