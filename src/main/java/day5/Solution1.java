package day5;

import java.io.*;

public class Solution1 {

    // 알고리즘 수업 - 알고리즘의 수행 시간 4 24265번
    // int [] A = 0;
    // int n
    // int sum = 0
    // for(i =1;i < n-1; i++){
    //  for(int j = i+1; j < n){
    //      sum = sum +A[i] * A[j]
    //  }
    // }
    // n=7
    // 6+5+4+3+2+1

    // (n-1) + (n-2) + ... + (n-n-1)
    // n ~ 1까지의 합 => n * (n+1) / 2
    // n-1 ~1 까지의 합 => n *(n-1) / 2
    // O((n^2-n) / 2) => n^2
    // 등차수열
    // 1 2 3 4 5 6 7 8 9 10
    // 10 9 8 7 6 5 4 3 2 1
    // ----------------------- /2 ->
    // 모두 11(n+1) -> 원소개수만큼 * n / 2 ->총합값

    // 시간복잡도에 대한 이해
    // 최고차항 -> 빅오표기법 - n이 몇제곱인지
    // 지수 제외!
    // 시간복잡도 문제마다 생각해보기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long result = (long) n *(n-1)/2;

        bw.write( result+ "\n" + 2);
        br.close();
        bw.close();
    }

}
