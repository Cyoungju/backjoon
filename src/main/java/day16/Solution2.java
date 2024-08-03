package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// n단 논법 - 15723번
public class Solution2 {

    static Map<String, String> map;

    public static void main(String[] args) throws IOException {
        // 입력
        // 첫번째줄 n개의 전재
        // a -> b -> c -> d
        // HashMap을 이용해 정보들 저장
        // 기준 알파벳 , 연결된 알파벳

        // 기능
        // 큐를 이용 bsf
        // 단방향 표
        // 기준 알파벳 , n단 논법에 적용될 알파벳들 저장


        // 출력
        // m개의 줄에 걸쳐 각 줄에 결론이 참인지 거짓인지 출력
        //참일 경우 T, 거짓일 경우 F

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" is ");
            String start = line[0];
            String end = line[1];

            // 입력받은 값들 hashmap에 넣기
            map.put(start, end);
        }

        StringBuilder sb = new StringBuilder();

        //출력
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" is ");
            String start = line[0];
            String end = line[1];

            // 출력
            if (bfs(start, end)) { // 조건이 맞을 경우
                sb.append("T").append("\n");
            } else {
                sb.append("F").append("\n");
            }
        }

        System.out.println(sb);

    }

    static boolean bfs(String start, String end) {
        Queue<String> queue = new LinkedList<>();
        Set<String> arr = new HashSet<>();
        queue.offer(start);
        arr.add(start);


        while (!queue.isEmpty()) {
            String now = queue.poll();
            if (now.equals(end)) {
                return true;
            }

            if (map.containsKey(now)) {
                String next = map.get(now);
                if (!arr.contains(next)) {
                    queue.offer(next);
                    arr.add(next);
                }
            }
        }
        return false;
    }
}