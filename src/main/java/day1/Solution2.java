package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        // BufferedReader로 입력받음
        // StringTokenizer 공백을 기준으로 입력 받기

        // 최종 결과 result
        // st에 저장된 값이 없을때까지 잘라서 들고오기 num
        // 5개의 숫자만 필요하기 때문에 for문으로 5번 조건식 부여

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        int num = 0;

        for(int i = 0;i < 5; i++){
            while (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
                result = result + (num * num);
            }
        }

        result = result % 10;

        System.out.println(result);

    }
}
