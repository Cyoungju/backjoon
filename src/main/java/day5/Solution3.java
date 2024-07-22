package day5;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution3 {

    // 숫자 카드 10815번
    // 가지고 있는 숫자가 있는지 확인
    // HashSet
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째 줄 - 상근이가 가지고 있는 카드 개수
        int N = Integer.parseInt(br.readLine());

        // 숫자 카드가 적혀있는 정수
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        // 카트를 담을 Hashset
        HashSet<Integer> cards = new HashSet<>();

        // hashset 넣기
        for(int i= 0; i < N;i++){
            cards.add(Integer.valueOf(st1.nextToken()));
        }
        // 세번째 줄 - M
        int M = Integer.parseInt(br.readLine());

        // 네번째 줄 - 숫자 카드가 적혀있는 정수
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        br.close();
        StringBuilder sb = new StringBuilder();

        // 가지고 있는 카드만 hasCard에 넣어주기
        for(int i= 0; i < M;i++) {
            int line = Integer.parseInt(st2.nextToken());
            if(cards.contains(line)){
                sb.append(1);
            }else {
                sb.append(0);
            }
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());

    }

}
