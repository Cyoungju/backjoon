package day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution6 {
    // 가운데를 말해요 - 1655번
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //첫번째 줄
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);

       // 외칠때마다 중간수를 말해야함
        for(int i=0;i < N;i++){
            int M = Integer.parseInt(br.readLine());
            // 큐에 저장
            // 무조건 minHeap이 크거나 같아야함
            // 짝수일때는 더 작은 값을 출력해야하기 때문에
            if(maxHeap.size() <= minHeap.size()){
                maxHeap.offer(M);
            }else{
                minHeap.offer(M);
            }

            // 탐색
            // 무조건 minHeap은 들어가있음
            // max의 제일 작은 값이
            // min의 제일 큰값 보다 크다면 두 수를 바꿔야함
            if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
                int maxRoot = maxHeap.poll();
                int minRoot = minHeap.poll();
                maxHeap.add(minRoot);
                minHeap.add(maxRoot);
            }

            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.println(sb.toString());
    }

}
