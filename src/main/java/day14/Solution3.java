package day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 점프왕 쩰리 (Small) - 16173번
public class Solution3 {

    static int N;
    static int[][] arr;

    // 방문 체크 배열
    static  boolean[][] visited;

    public static void main(String[] args) throws IOException {
        // 젤리가 최대한으로 이동할수 있는거리 = N-1

        //가로가 N도달시 y == N 오른쪽으로 탐색하지 않는다
        //세로가 N도달시 x == N 아래쪽으로 탐색하지 않는다

        // x,y = N 이될 경우  HaruHaru 출력
        // 아닐경우 Hing출력
        // 다음으로 탐색해야하는 숫자가
        // 가로 => y - N-1 이상의수는 탐색하지 않음
        // 세로 => x - N-1 이상의수는 탐색하지 않음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // N크기의 정사각형
        arr = new int[N][N];
        visited = new boolean[N][N];

        // 배열어 입력값 담기
        for(int i=0;i<arr.length;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = false;
            }
        }
        // 배열 탐색
        bfs();
    }

    static void bfs(){
        // 큐를 이용 - 인접배열
        Queue<int[]> queue = new LinkedList<>();
        boolean success = false;
        queue.offer(new int[]{0,0}); //시작

        while (!queue.isEmpty()){ //큐가 빌때까지

            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];

            visited[r][c] = true; //방문

            if(arr[r][c] == -1){
                success = true;
                break;
            }

            int bottomEnd = r +arr[r][c];
            int rightEnd = c + arr[r][c];

            if(bottomEnd < N && !visited[bottomEnd][c]){
                queue.offer(new int[] {bottomEnd, c});
                visited[bottomEnd][c] =true;
            }
            if(rightEnd < N && !visited[r][rightEnd]){
                queue.offer(new int[] {r, rightEnd});
                visited[r][rightEnd] = true;
            }

        }
        if(success){
            System.out.println("HaruHaru");
        }else{
            System.out.println("Hing");
        }

    }

}
