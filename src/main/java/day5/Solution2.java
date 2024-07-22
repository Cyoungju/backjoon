package day5;

import java.io.*;

public class Solution2 {

    // 알고리즘 수업 - 알고리즘의 수행 시간 6 24265번
    // int [] A = 0;
    // int n
    // int sum = 0

    // for(i =1;i <= n-2; i++){
    //  for(int j = i+1; j <= n-1;j++){
    //      for(int k = j+1; j <= n;k++){
    //      sum = sum +A[i] * A[j] * A[k]
    //  }
    // }
    // for문이 3번도니까 대략 n^3정도겠구나

    // n=7
    // i=1 / j= 2~7 / k = 3~7
    // n * (n-1) * (n-2)
    // 조합의 공식? => 사실 잘 이해 안감
    // n!/(n-3)!3! => n(n-1)(n-2) / 6
    // (n^2-n)(n-2) => n^3-n^2+2n^2-2n => O(n^3)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long result = (long) n * (n-1) * (n-2) / 6;

        bw.write( result+ "\n" + 3);
        br.close();
        bw.close();
    }

}
