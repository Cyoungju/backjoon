package day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution3 {
    // 크리스마스 선물 - 14235번
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);

        //첫번째 줄 - 연산의 개수 N
        int N = Integer.parseInt(br.readLine());

        // N개 연산
        for(int i =0;i < N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            // 0은 아이들을 만나서 선물을줌
            if(a == 0){
                // 큐가 비어있다면 -1 출력
                if (queue.isEmpty()){
                    sb.append(-1).append("\n");
                }else { // 비어있지 않다면  우선순위가 제일 큰 거부터 출력
                    sb.append(queue.poll()).append("\n");
                }

            }else {
                // 큐에 넣어주기
                while (st.hasMoreTokens()){
                    queue.add(Integer.valueOf(st.nextToken()));
                }
            }
        }
        br.close();
        System.out.println(sb.toString());
    }

}
