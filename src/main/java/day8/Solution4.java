package day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution4 {
    // Hashing - 15829번
    public static void main(String[] args) throws IOException {
        //알파벳 소문자
        // a = 97

        // 받은 문자열을 아스키코드로 변환 - 96 => 해당 철자의 번호

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long base = 1;
        long hash = 31;
        long sum = 0;
        String line = br.readLine();

        for(int j =0; j < N; j++){
            String st = line.substring(j,j+1);
            int a = st.charAt(0) - 96;
            sum += a * base;

            base = (base * hash) % 1234567891;

        }

        System.out.println(sum % 1234567891);

    }

}
