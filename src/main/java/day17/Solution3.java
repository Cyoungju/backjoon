package day17;

import java.io.*;

// 음식물 피하기 -  1743번
public class Solution3 {
    static int[] dx = {1,-1,0, 0};
    static int[] dy = {0,0,1, -1};

    static int[][] arr;
    static boolean[][] visited;

    static int maxCount;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] lineBr = br.readLine().split(" ");
        // 사각형 너비
        int N = Integer.parseInt(lineBr[0]);
        int M = Integer.parseInt(lineBr[1]);
        int K = Integer.parseInt(lineBr[2]);

        arr = new int[N][M];
        visited = new boolean[N][M];
        maxCount = 0;

        // 0 으로 초기화
        for(int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr[0].length;j++){
                arr[i][j] = 0;
            }
        }
        // 쓰레기위치 1로 체크
        for(int i = 0;i <K;i++){
            lineBr = br.readLine().split(" ");
            int x = Integer.parseInt(lineBr[0]);
            int y = Integer.parseInt(lineBr[1]);
            arr[x-1][y-1] = 1;
        }


        // 탐색
        // 모든 좌표에서 dfs 시작
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    int widthArea = dfs(i, j);
                    if(maxCount <widthArea){
                        maxCount = widthArea;
                    }
                }
            }
        }
        System.out.println(maxCount);

    }
    static int dfs(int x, int y) {
        visited[x][y] = true;
        int area = 1; //현재 칸 카운팅

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length) {
                if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                    area+= dfs(nx, ny);
                }
            }
        }
        return area;
    }
}
