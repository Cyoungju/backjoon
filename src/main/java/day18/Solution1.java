package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 숨바꼭질 - 1697번
public class Solution1 {
    //입력
    // 수빈이의 위치 N
    // 동생의 위치 K
    // 걸을 때 X-1 / X+1
    // 순간이동 2*X

    //기능
    //BFS
    //1초후의 경우의수 +1 / -1 / N*2
    //depth 들어갈때 마다 count -> 초수


    //출력

    // 중복되면 안됨 - 방문배열 필요
    static boolean[] visited = new boolean[100001];

    static int N;
    static int K;

    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); // 수빈이의 위치
        K = Integer.parseInt(input[1]); // 동생의 위치

        // 탐색
        bfs(N);

        // 출력
        System.out.println(count);

    }
    static void bfs(int start){
        Queue<int[]> queue = new LinkedList<>();
        // 수빈이의 위치를 첫시작으로 넣어줌
        queue.offer(new int[]{start,0});
        visited[start] = true;
        //현재 노드 방문 체크

        while (!queue.isEmpty()) {
            // 현재 데이터 숫자
            int data = queue.peek()[0];
            // 노드의 깊이 = 걸린 초수
            int depth = queue.peek()[1];
            queue.poll();

            // 종료조건
            if(data == K){ // 동생의 위치와 data가 같을때 종료
                count = depth;
                break;
            }

            //방향 탐색
            //탐색할 방향 설정 -1/+1/*2
            int a = data - 1;
            int b = data + 1;
            int c = data * 2;

            // 각각의 유효성 검사
            if(a >= 0 && a <= 100000 && !visited[a]){
                visited[a] = true;
                queue.offer(new int[]{a, depth+1});
            }
            if(b >= 0 && b <= 100000 && !visited[b]){
                visited[b] = true;
                queue.offer(new int[]{b, depth+1});
            }
            if(c >= 0 && c <= 100000 && !visited[c]){
                visited[c] = true;
                queue.offer(new int[]{c, depth+1});
            }

        }

    }
}