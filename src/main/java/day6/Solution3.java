package day6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solution3 {
    // 1~N까지 중 중복 없이 M개 고른 수열 - 백트래킹/ 재귀 사용
    // 단, 오름차순했을때 중복되는값이 들어가서는 안됨
    // n, n+1, n+2 ... => M개 / 앞 숫자는 뒤 숫자 보다 작음!

    //배열
    static int [] arr;

    static int N;
    static int M;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        // depth의 처음 시작은 0 부터
        dfs(1,0);

    }

    static void dfs(int at, int depth){

        StringBuilder sb = new StringBuilder();
        // 종료 조건 넣어주기 - 무조건 넣어줘야함
        if(depth == M){
            for (int arrs : arr){
                sb.append(arrs).append(" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }
        for(int i = at; i <= N;i++){
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }

    }
}
