package day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 상근이의 여행 - 9372번
public class Solution4 {

    public static void main(String[] args) throws IOException {
         // 국가의 개수만큼 간선이 존재
        // 국가 수-1 = 간선의수 => 최소신장트리의 성질을 이용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            for(int j = 0;j < M;j++){
                br.readLine();
            }
            sb.append(N-1).append("\n");
        }
        br.close();

        System.out.println(sb);
    }

}
