package day16;

import java.io.*;

// 그림 - 1926번
public class Solution4 {
    // 가로 세로로만 연결된곳만 count
    static int[] dx = {1,-1,0, 0};
    static int[] dy = {0,0,1, -1};

    static int[][] draw;
    static boolean[][] visited;

    static int maxCount;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] lineBr = br.readLine().split(" ");
        // 사각형 너비
        int w = Integer.parseInt(lineBr[0]);
        int h = Integer.parseInt(lineBr[1]);

        draw = new int[w][h];
        visited = new boolean[w][h];
        int count = 0;
        maxCount = 0;

        for(int i = 0;i < draw.length;i++){
            lineBr = br.readLine().split(" ");
            for(int j = 0;j < draw[0].length;j++){
                draw[i][j] = Integer.parseInt(lineBr[j]);
            }
        }


        // 탐색
        // 모든 좌표에서 dfs 시작
        // 1 만나면 count
        for (int i = 0; i < draw.length; i++) {
            for (int j = 0; j < draw[0].length; j++) {
                if (draw[i][j] == 1 && !visited[i][j]) {
                    int widthDraw = dfs(i, j);
                    count++;
                    if(maxCount <widthDraw){
                        maxCount = widthDraw;
                    }
                }
            }
        }
        System.out.println(count);
        System.out.println(maxCount);

    }
    static int dfs(int x, int y) {
        visited[x][y] = true;
        int area = 1; //현재 칸 카운팅

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < draw.length && ny < draw[0].length) {
                if (draw[nx][ny] == 1 && !visited[nx][ny]) {
                   area+= dfs(nx, ny);
                }
            }
        }
        return area;
    }
}
