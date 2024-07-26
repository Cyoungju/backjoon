package day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution2 {
    // 국회의원 선거 - 1417번
    public static void main(String[] args) throws IOException {
        // 다솜이는 1번
        // 매수해야하는 최소한의 사람수
        // 내 득표수를 구하기
        // 최대값을 구해서 +1만큼 얻어야함

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 총 후보의 수
        int N = Integer.parseInt(br.readLine());

        // 다솜의 득표수
        int M = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);

        // 다른 후보들의 득표수 넣어주기
        for(int i = 1; i< N; i++){
            int num = Integer.parseInt(br.readLine());
            queue.add(num);
        }

        br.close();

        // 매수한 사람수
        int num = 0;

        // 최대득표를 가지고 있는 사람한테서 표 뺏어오면됨
        while (!queue.isEmpty() && queue.peek() >= M){
            M++;
            queue.add(queue.poll()-1);
            num++;
        }

        System.out.println(num);


    }

}
