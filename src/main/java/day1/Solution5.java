package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5 {
    public static void main(String[] args) throws IOException {
        // 입력 받은 숫자들을 비교하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = 0;
        if(a == b && a == c){ // 같은 수가 3개인 경우
            result = 10000 + (a*1000);
        }else if(a == b || a==c){ // 같은수 3개 x / 두개라도 맞는지 비교함
            result = 1000 + (a*100);
        }else if(b == c){
            result = 1000 + (c*100);
        }else { // 셋다 다른경우 - 제일 큰값 Math.max 이용해서 찾기
            int max = Math.max(a,Math.max(b,c));
            result = max * 100;
        }
        System.out.println(result);
    }
}
