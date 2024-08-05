package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 양 - 3184번
public class Solution4 {
    static int[] dx = {1,-1,0, 0};
    static int[] dy = {0,0,1, -1};

    static String[][] yard; //마당의 배열
    static boolean[][] visited;

    static int totalSheep = 0; // 총 양
    static int totalWolves = 0; // 총 늑대
    static int maxCount;
    public static void main(String[] args) throws IOException {
        // . 필드 / # 울타리 / o 양 / v 늑대
        // 수평 수직으로만 이동가능 - 울타리를 지나지 않은다면 같은칸으로 간주
        // 탈출 칸은 count하지않음
        // 영역안의 양의 수가 늑대의 수보다 많다면 이김
        // 반대라면 늑대가 잡아먹음
        // 탐색 - 영역안에 늑대와 양의 수

        // R C 마당의 행과 열
        // 탐색중 v를 만난다면 v count
        // o를 만난다면 o count
        // 영역 탐색이 끝나면 o와 c의 수를 비교
        // 큰 수의 동물을 count


        // 출력
        // 양과 늑대의 수


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] lineBr = br.readLine().split(" ");
        // 사각형 너비
        int R = Integer.parseInt(lineBr[0]);
        int C = Integer.parseInt(lineBr[1]);

        yard = new String[R][C];
        visited = new boolean[R][C];

        // 배열 채우기
        for(int i = 0;i < yard.length;i++){
            String str = br.readLine();
            for(int j = 0;j < yard[0].length;j++){
                yard[i][j] = str.substring(j,j+1);
            }
        }

        // 탐색
        // 모든 좌표에서 dfs 시작
        for(int i = 0;i < yard.length;i++){
            for(int j = 0;j < yard[0].length;j++){
                if (!visited[i][j] && !yard[i][j].equals("#")) {
                    int[] result = dfs(i, j);
                    if (result[0] > result[1]) {
                        totalSheep += result[0];
                    } else {
                        totalWolves += result[1];
                    }
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolves);

    }
    static int[] dfs(int startX, int startY){
        int sheepCount = 0;
        int wolfCount = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!stack.isEmpty()){
            int[] now = stack.pop();
            int x = now[0];
            int y = now[1];

            if (yard[x][y].equals("o")) {
                sheepCount++;
            } else if (yard[x][y].equals("v")) {
                wolfCount++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                boolean withinBounds = nx >= 0 && ny >= 0 && nx < yard.length && ny < yard[0].length;
                if (withinBounds && !visited[nx][ny] && !yard[nx][ny].equals("#")) {
                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                }
            }
        }
        return new int[]{sheepCount, wolfCount};
    }
}
