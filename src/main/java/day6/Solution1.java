package day6;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution1 {
    // N과 M (1) - 15649번
    // 1~N까지 중 중복 없이 M개 고른 수열 - 순열 - 백트래킹/ 재귀 사용

    // 방문 체크리스트
    static boolean [] visit;

    //배열
    static int [] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        arr = new int[M];

        // depth의 처음 시작은 0 부터
        dfs(N,M,0);

    }

    static void dfs(int N, int M, int depth){
        // 종료 조건 넣어주기 - 무조건 넣어줘야함
        if(depth == M){
            for (int arrs : arr){
                System.out.print(arrs+ " ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < N;i++){
            if(!visit[i]){
                visit[i] = true; // 해당 depth에서 동일한 번호는 사용하면 안되기 때문에 true로 변경
                arr[depth] = i+1;
                dfs(N,M,depth+1);
                visit[i] = false; // 다른 depth에서 사용해야하기 때문에
            }

        }

    }
}
