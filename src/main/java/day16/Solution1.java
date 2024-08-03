package day16;

import java.util.*;
import java.io.*;

// 헌내기는 친구가 필요해 - 21736번
public class Solution1 {
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};

    static boolean[][] visited;

    static int N;
    static int M;

    static int count;

    public static void main(String[] args) throws IOException {
        //입력
        // 첫번째줄
        // N*M = 캠퍼스의 크기
        // 상하좌우로 이동 dx, dy 배열지정 - (0,1), (0,-1), (1,0), (-1,0)
        // o 빈공간, I 도연, P는 사람, X 벽
        // 방문 체크 배열

        // count

        //기능
        // 조건 : 캠퍼스 밖으로 이동할수 없음 : 범위 지정해주기
        // I에서 모든곳들 들리면서 P가 있는곳을 다 둘러보기 - 단 X는 지나갈수 없음
        // dfs를 이용 - 재귀

        //출력
        // 도연이가 만날수 있는 사람수출력
        // 사람을 못만나면 TT출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        String [][] arr = new String[N][M];
        visited = new boolean[N][M];

        count = 0;
        int x =-1;
        int y =-1;

        //배열에 담기
        for(int i = 0;i<arr.length;i++){
            String line = br.readLine();
            for(int j = 0;j<arr[0].length;j++) {
                String map = String.valueOf(line.charAt(j));
                arr[i][j] = map;

                if(arr[i][j].equals("I")){
                    x = i;
                    y = j;
                }else if(arr[i][j].equals("X")){
                    visited[i][j] = true;
                }
            }
        }

        //기능
        dfs(x, y, arr);

        //출력
        if(count ==0){
            System.out.println("TT");
        }else {
            System.out.println(count);
        }
    }

    // dfs를 이용
    static void dfs(int x, int y, String [][] arr){
        visited[x][y] = true;
        //방문확인

        if(arr[x][y].equals("P")){
            count++;
        }

        // 상하좌우 탐색
        for(int i =0; i < 4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx >= 0 && ny >=0 && nx < arr.length && ny < arr[0].length && !visited[nx][ny]){
                dfs(nx,ny,arr);
            }
        }

    }
}