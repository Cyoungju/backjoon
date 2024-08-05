package day17;

import java.io.*;

// 침투 - 13565번
public class Solution1 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        //입력
        // 첫번째줄
        // M*N = 섬유물질
        // 상하좌우로 이동 dx, dy 배열지정 - (0,1), (0,-1), (1,0), (-1,0)
        // 방문 체크 배열
        // 위쪽 바깥쪽(outer side) - visited[0][i]
        // 아래쪽 안쪽(inner side) - visited[M][i]
        // 0은 전류가 동함 - 이동가능
        // 1은 전류가 통하지 않음 - 이동 불가능

        //기능
        // 조건 : 섬유물질 밖으로 이동할수 없음 : 범위 지정해주기
        // 4방향으로 둘러보기
        // dfs를 이용 - 재귀

        //출력
        // 아래쪽 안쪽(inner side) - visited[M][i]
        // 안쪽에 visited -true가 있으면 YES
        // 없으면 NO

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        int [][] arr = new int[M][N];
        visited = new boolean[M][N];

        //배열에 담기
        for(int i = 0;i<arr.length;i++){
            String line = br.readLine();
            for(int j = 0;j<arr[0].length;j++) {
                int map = Integer.parseInt(line.substring(j,j+1));
                arr[i][j] = map;
            }
        }
        for(int j = 0;j< arr[0].length;j++){
            if (!visited[0][j] && arr[0][j] == 0) {
                //기능
                dfs(0, j, arr);
            }

        }

        boolean right = false;

        for(int j = 0;j< arr[0].length;j++){
            if(visited[M-1][j]){
                right = true;
                break;
            }
        }

        //출력
        System.out.println(right ? "YES" : "NO");
    }

    // dfs를 이용
    static void dfs(int x, int y, int [][] arr){
        visited[x][y] = true;
        //방문확인

        // 상하좌우 탐색
        for(int i =0; i < 4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            boolean withinBounds = nx >= 0 && ny >= 0 && nx < M && ny < N;
            if(withinBounds && !visited[nx][ny] && arr[nx][ny] == 0){
                dfs(nx,ny,arr);
            }
        }
    }
}