package day10;

import java.io.*;
import java.util.StringTokenizer;

public class Solution2 {
    // Yangjojang of The Year - 11557번
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //테스트 케이스 개수
        int N = Integer.parseInt(br.readLine());

        for(int i = 0;i <N;i++){
            // 학교 수
            int M = Integer.parseInt(br.readLine());

            // 가장 큰수
            long max = 0;
            // 가장 큰 수를 가진 학교이름
            String maxName = "";

            for(int j = 0;j <M;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                long num = Long.parseLong(st.nextToken());

                // 입력받은 숫자가 num 보다 크면 max바꾸기 / 학교이름도 저장
                if(max < num){
                    maxName = name;
                    max = num;
                }
            }
            sb.append(maxName).append("\n");
        }

        br.close();
        System.out.println(sb);

    }

}
