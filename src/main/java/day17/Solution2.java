package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 영상처리 -  21938번
public class Solution2 {
    static boolean[][] visited;
    static int N;
    static int M;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static int[][] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        //입력
        // 첫번째줄
        // N*M
        // 방문 체크 배열
        // 3개씩 받아서 평균을 내서 arr에 넣어주기

        //기능
        // BFS를 이용해 너비우선탐색하기
        // 다음 탐색 - 마지막 경계값과 비교해 255일 경우 count+1 / 0 일경우


        //출력
        // count출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        arr = new int[M][N];
        visited = new boolean[M][N];

        //배열에 담기
        for (int i = 0; i < arr.length; i++) {
            String[] line = br.readLine().split(" ");
            int num = 0;
            for (int j = 0; j < arr[0].length; j++) {
                int sum = averageNum(num, line);
                num += 3;
                arr[i][j] = sum;
            }
        }


        int resultNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] >= resultNum){
                    arr[i][j] = 255;
                }else{
                    arr[i][j] = 0;
                }
            }
        }
        br.close();

        // 탐색
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] == 255) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    static void bfs(int startX, int startY) {

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{startX, startY});
        visited[startX][startY] = true;


        while(!deque.isEmpty()){
            int[] now = deque.poll();
            int x = now[0];
            int y = now[1];


            visited[x][y] = true;

            for(int k = 0;k<4;k++) { //상하좌우 탐색
                int nowx = x + dx[k];
                int nowy = y + dy[k];

                if(nowx >=0 && nowy>=0 && nowx < arr.length && nowy < arr[0].length){
                    if (!visited[nowx][nowy] && arr[nowx][nowy] == 255) {
                        visited[nowx][nowy] = true;
                        deque.offer(new int[]{nowx, nowy});
                    }
                }
            }

        }

    }

    private static int averageNum(int num, String[] line){
        int sum = 0;
        for (int k = num; k < num + 3; k++) {
            sum += Integer.parseInt(line[k]);
        }
        sum /= 3;
        return sum;
    }
}