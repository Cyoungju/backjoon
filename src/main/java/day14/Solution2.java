package day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 바닥 장식 - 1388번
public class Solution2 {
    static boolean[][] visited;

    static int X;
    static int Y;

    static int count;
    // 방문 체크 확인

    public static void main(String[] args) throws IOException {
        // - 가 가로로 연달아 있을 경우 하나로 침
        // | 가 세로로 연달아 있을 경우 하나로 침
        // dsf 사용

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stNum = new StringTokenizer(br.readLine());
        X = Integer.parseInt(stNum.nextToken());
        Y = Integer.parseInt(stNum.nextToken());

        String[][] tile = new String[X][Y];
        visited  = new boolean[X][Y];

        count=0;

        // 입력받은 문자 배열에 넣어주기
        for(int i = 0;i<X;i++){
            String line = br.readLine();
            for(int j=0;j<line.length();j++){
                String c = String.valueOf(line.charAt(j));
                tile[i][j] = c;
            }
        }

        for(int i = 0;i<X;i++){
            for(int j=0;j<Y;j++){
                if(!visited[i][j]){
                    dfs(i,j, tile);
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(int x, int y, String[][] tile){
        visited[x][y] = true;
        // 방문확인

        // - y확인
        // 확인하려고 하는 순번이 (0,0)일경우
        // -는 옆에 있는 곳을 확인해야하기 떄문에
        // (0,1)확인 x,y중 y값을 +1 해서 확인
        if(tile[x][y].equals("-")){
            // y값이 배열의 마지막번호일경우
            // 더이상 갈곳이 없기 때문에 +1 해주기
            if(y == Y-1){
                count++;
                return;
            }

            // 방문 배열이 false이고, 옆칸의 문자가 - 일 경우 계속 탐색
            if(!visited[x][y+1] && tile[x][y + 1].equals("-")){
                dfs(x,y+1, tile);
            }else {
                count++;
                return;
            }
        }

        // | x확인
        if(tile[x][y].equals("|")) {
            if (x == X-1) {
                count++;
                return;
            }

            if (!visited[x + 1][y] && tile[x + 1][y].equals("|")) {
                dfs(x + 1, y, tile);
            } else {
                count++;
                return;
            }
        }
    }

}
