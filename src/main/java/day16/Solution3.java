package day16;

import java.io.*;

// 섬의 개수 - 4963번
public class Solution3 {
    static int[] dx = {1,-1,0,0,1,-1,1,-1};
    static int[] dy = {0,0,1,-1,-1,1,1,-1};

    static boolean[][] visited;

    static int[][] island;
    static int count;

    public static void main(String[] args) throws IOException {
        // 입력
        // 지도의 너비 w, 지도의 높이 h
        // 다음줄 부터 ~h 까지 지도의 정보
        // 1은 땅 / 0은 바다
        // 마지막 입력줄 0 0 ->  입력받기 종료

        //초기화
        // visited 배열 초기화
        // island 배열 초기화


        //출력
        //count

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){

            String line = br.readLine();
            if(line.equals("0 0")){
                break;
            }
            // 입력 종료 조건
            String[] lineBr = line.split(" ");
            // 사각형 너비
            int w = Integer.parseInt(lineBr[0]);
            int h = Integer.parseInt(lineBr[1]);

            //초기화
            island = new int[h][w];
            visited = new boolean[h][w];
            count = 0;

            //배열 채우기
            for(int i = 0;i < island.length;i++){
                lineBr = br.readLine().split(" ");
                for(int j = 0;j < island[0].length;j++){
                    island[i][j] = Integer.parseInt(lineBr[j]);
                }
            }
            // 탐색
            // 모든 좌표에서 dfs 시작
            // 1 만나면 count
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (island[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    // 가로 세로 대각선 방향으로 이동가능
    // 조건 : w*h 범위를 벗어나면안됨

    // 1을 만났을경우 dfs돌면서 탐색
    // DFS로 섬 탐색
    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < island.length && ny < island[0].length) {
                if (island[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
