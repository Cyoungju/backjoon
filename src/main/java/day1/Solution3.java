package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3 {
    public static void main(String[] args) throws IOException {
        // 시작시간 입력받음
        // StringTokenizer 로 잘라서 현재 시간 구하기
        // 첫번째 = 0 < HH < 23
        // 두번째 = 0 < MM < 59
        // 세번째 = 0 < SS < 59
        // 23시 29분 29초 오버시 0 0 0으로 변함


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫번재 줄
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int d = Integer.parseInt(br.readLine());


        //1분은 60초 - d에 입력받은 값을 더해줌
        b += d/60;
        c += d%60;

        //60초가 넘는 시간대를 분으로 올려줌
        b += c/60;
        c = c%60;

        //60분이 넘는 시간대를 시간으로 올려줌
        a += b/60;
        b = b%60;

        a = a%24;

        System.out.printf("%d\t%d\t%d",a,b,c);


    }
}
