package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {
    // 3의배수 - 1769번

    public static void main(String[] args) throws IOException {
        // 정수 X는 3의 배수인가?
        // 1107 -> 1+1+0+7=9 Y는 3의 배수인가?
        // X로 받은 숫자가 3,6,9가 될때까지 각 자리수를 잘라서 더한다
        // X가 3,6,9가 나온다면 3의 배수이다

        // 몇번을 계산해야 한자리수가 나오는가


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();
        int count = 0;

        // 한자리 수가 나올때 까지 반복해주기
        while (true){
            //처음 계산하는 값은 0으로 초기화
            long sum = 0;
            if(num.length() == 1) {
                break;
            }

            // 각 자리 수 잘라서 더해주기
            for(int i=0;i<num.length();i++){
                int N =  Integer.parseInt(num.substring(i,i+1));
                sum += N;
            }
            // 계산 카운트 하기
            count++;

            num = String.valueOf(sum);
        }

        System.out.println(count);
        System.out.println(Integer.parseInt(num) % 3 == 0 ? "YES" : "NO");
    }

}
