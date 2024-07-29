package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution4 {
    // 세준세비 - 1524번
    public static void main(String[] args) throws IOException {

        // point!
        // 제일큰수를 가지고있는 사람찾기

        // 정렬을해서두사람을 비교해서 더 큰 수를 가진사람이 이김
        // 둘다 같은값을 가지고있을경우 세준이 이김

        System.out.println("입력");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //테스트 케이스 개수
        int test = Integer.parseInt(br.readLine());


        for(int i = 0;i <test;i++){
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            //세준이의 병사 수
            int N = Integer.parseInt(st.nextToken());
            //세비의 병사 수
            int M = Integer.parseInt(st.nextToken());


            int maxSj = 0;
            int maxSb = 0;

            StringTokenizer sb1 = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int nowNum = Integer.parseInt(sb1.nextToken());
                if (maxSj < nowNum){
                    maxSj = nowNum;
                }
            }

            StringTokenizer sb2 = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int nowNum = Integer.parseInt(sb2.nextToken());
                if (maxSb < nowNum){
                    maxSb = nowNum;
                }
            }
            if(maxSj >= maxSb){
                sb.append("S");
            }else {
                sb.append("B");
            }
            sb.append("\n");
        }
        br.close();



        System.out.println(sb.toString());
    }
}
