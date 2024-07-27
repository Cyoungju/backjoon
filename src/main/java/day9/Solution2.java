package day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution2 {
    // 최소 힙 - 1927번
    public static void main(String[] args) throws IOException {
        // 배열에 x를 넣는다
        // 배열에서 가장 작은 값을 출력하고 그 값을 제거한다
        // 처음에 비어있는 배열에서 시작

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //첫번째 줄 - 연산의 개수 N
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // N개 연산
        for(int i =0;i < N;i++){
            int x = Integer.parseInt(br.readLine());

            if(x > 0){
                priorityQueue.add(x);
            }else if(x == 0){
                if(!priorityQueue.isEmpty()) {
                     x = priorityQueue.poll();
                }
                sb.append(x).append("\n");
            }
            // x 가 자연수 - add
            // x 가 0 - 배열에서 가장 작은 값을 출력후 제거

        }

        // 입력에서 0이 주어진 횟수 만큼 출력
        System.out.println(sb.toString());
    }

}
