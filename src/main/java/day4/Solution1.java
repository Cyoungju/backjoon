package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        // 문자열 반복 2675번
        // String S = 문자열 입력
        // R번 반복
        // p 새문자열 만들기
        // 출력
        // while문
        // 첫번째 문자 R번 반복
        // 두번째 문자 R번 반복

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 첫번째줄 숫자
        int totalNum = Integer.parseInt(br.readLine());

        while (totalNum != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            // i번째 문자 num만큼 반복하기
            for (int i = 0; i < str.length(); i++) {
                char s = str.charAt(i);
                for (int j = 0; j < num; j++) {
                    sb.append(s);
                }
            }
            sb.append("\n");
            totalNum--;
        }
        System.out.println(sb.toString());
    }
}
