package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 구호물자 - 11581번
public class Solution2 {
    //입력
    // 교차로의 수 N
    // 다음줄 1~ N-1 의 노드 수만큼 두줄씩 정보제공 (노드의 번호가 i가로 가정)
    // 첫번째줄 i의 노드와 다른 노드가 연결된 교차로의 수
    // 두번재줄 i의 노드에서 갈수 있는 노드의 번호

    //기능
    //사이클검증

    //출력
    // 지나갔던 교차로를 다시 방문할 경우 CYCLE
    // 방문하지 않을경우 NO CYCLE
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new boolean[N + 1][N + 1];
        for(int i = 1;i <N;i++){
            int e = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0;j <e;j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][num] = true;
            }
        }
        // 플로이드 워셜 알고리즘 사용해 기록 남기기
        for (int k = 1; k < N; k++) {
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (arr[i][k] && arr[k][j]) {
                        arr[i][j] = true;
                    }
                }
            }
        }

        boolean flag = false; // No CYCLE;

        for(int i = 1;i<N;i++){
            if(arr[1][i] && arr[i][i]){
                flag = true;
                break;
            }
        }

        System.out.println(flag ? "CYCLE" : "NO CYCLE");
    }

}