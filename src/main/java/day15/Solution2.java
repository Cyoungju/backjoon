package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 유사 라임 게임 -  24431번
public class Solution2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        for(int i = 0;i < T;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int L = Integer.parseInt(st1.nextToken());
            int F = Integer.parseInt(st1.nextToken());

            String[] word = new String[n];

            Set<String> set  = new HashSet<>();
            int count = 0; // 유사 라임 쌍의 수

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j =0; j <n;j++) {
                word[j] = st2.nextToken();
            }

            for (int j = 0; j < n; j++) {
                // 각 단어의 길이 L에서 마지막 F 글자를 추출
                String substring = word[j].substring(L - F, L);

                // 접미사가 이미 Set에 존재하는 경우, 유사 라임 쌍을 하나 만들 수 있음
                if (!set.contains(substring)) {
                    // 접미사가 Set에 없으면 추가
                    set.add(substring);
                } else {
                    // 접미사가 이미 존재하면 유사 라임 쌍을 형성할 수 있음
                    count++;
                    // 이미 존재한 접미사는 제거하여 중복 사용 방지
                    set.remove(substring);
                }
            }

            // 결과를 StringBuilder에 추가
            sb.append(count).append('\n');

        }
        // 모든 테스트 케이스에 대한 결과 출력
        System.out.print(sb);

    }


}
