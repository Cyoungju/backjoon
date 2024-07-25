package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution8 {
    // 요세푸스 문제 - 1158번
    public static void main(String[] args) throws IOException {

        // 요세푸스 문제
        // 원을 이루면서 사람들이 서있음
        // 주어진 K가 나올때까지 빼서 다시 큐에 넣는다
        // K가 나오면 빼고 읽는다
        // 큐가 빌때까지 반복


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        br.close();
        Queue<Integer> queue = new LinkedList<>();

        // 1~N 까지의 수를 큐에 넣기
        for(int i = 1;i <= N;i++){
            queue.add(i);
        }

        sb.append("<");
        while (!queue.isEmpty()){
            for(int i = 0; i <K-1;i++){
                queue.add(queue.poll());
            }

            sb.append(queue.poll());
            if(!queue.isEmpty()){
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb.toString());

    }
}
