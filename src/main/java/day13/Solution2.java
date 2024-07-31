package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 신입사원 1946번
public class Solution2 {
    public static void main(String[] args) throws IOException {
        // 1차의 1등의 2차 점수보다 높아야함
        // 면접과 서류 둘다 어떤사람보다 숫자가 낮으면 무조건 탈락
        // 아니라면 합격할수 있기 때문에
        // A(1,4) / B(1,5) 라면 탈락!이기때문에
        // 2차도 동일

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        for(int i = 0;i < T; i++){
            int N = Integer.parseInt(br.readLine());

            int[][] score = new int[N][2];
            for(int j=0;j<N;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                score[j][0] = Integer.parseInt(st.nextToken());
                score[j][1] = Integer.parseInt(st.nextToken());
            }


            // 오름차순 정렬
            Arrays.sort(score, (a,b) -> {
                if(a[0] == b[0]){
                    return Integer.compare(a[1],b[1]);
                }else {
                    return Integer.compare(a[0],b[0]);
                }
            });

            // 탈락의 조건
            // 서류 1등의 면접 점수 보다 높아야함

            int top = score[0][1]; // 서류 1등의 면접 등수
            int count = 0;
            for(int j = 1;j<N;j++){
                if(top < score[j][1]){ //서류 등수가 더 높은 지원자보다 면접등수가 낮으면 탈락
                    count++;
                    continue;
                }
                top = score[j][1];
            }

            sb.append(N-count).append("\n");
        }
        System.out.println(sb);
    }

    // 316884kb / 3176ms
}
