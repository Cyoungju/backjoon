package day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Best Grass - 6186번
public class Solution1 {
    static boolean[][] used;
    // 방문 체크 확인

    public static void main(String[] args) throws IOException {
        // 너비우선탐색 BFS
        // 상하좌우 탐색 #이 있는지 확인
        // 없다면 이어진 목초지 덩어리가 없으니까 count++

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stNum = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(stNum.nextToken());
        int Y = Integer.parseInt(stNum.nextToken());

        int[][] arr = new int[X][Y];
        used  = new boolean[X][Y];

        // 입력받은 문자 배열에 넣어주기  # 이 있을경우 1로 / 아닐경우 0으로 넣어주기
        for(int i = 0;i<X;i++){
            String line = br.readLine();
            for(int j=0;j<line.length();j++){
                Character c = line.charAt(j);
                if(c == '#'){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = 0;
                }

            }
        }
        int count = 0;
        for(int i = 0;i<X;i++) {
            for (int j = 0; j < Y; j++) {
                // #이 있고, 방문했던 곳이 아닐경우 탐색
                if(arr[i][j] == 1 && !used[i][j]){
                    count++;
                    dfs(i,j,arr);
                }
            }
        }
        System.out.println(count);
    }

    static void dfs(int x, int y, int[][] num){
        used[x][y] = true;

        //입력받은 행과 열의 범위를 넘어가면안됨!

        // 상
        if (x + 1 < num.length && num[x + 1][y] == 1 && !used[x + 1][y]) {
            dfs(x + 1, y, num);
        }

        // 하
        if (x - 1 >= 0 && num[x - 1][y] == 1 && !used[x - 1][y]) {
            dfs(x - 1, y, num);
        }

        // 좌
        if (y - 1 >= 0 && num[x][y - 1] == 1 && !used[x][y - 1]) {
            dfs(x, y - 1, num);
        }

        // 우
        if (y + 1 < num[0].length && num[x][y + 1] == 1 && !used[x][y + 1]) {
            dfs(x, y + 1, num);
        }


    }

}
