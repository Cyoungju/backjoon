package day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution4 {

    // 숫자 카드2 20816번
    // HashMap getordefault
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째 줄 - 상근이가 가지고 있는 카드 개수
        int N = Integer.parseInt(br.readLine());

        // 숫자 카드가 적혀있는 정수
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        // 카트를 담을 HashMap
        HashMap<Integer,Integer> card = new HashMap<>();

        // 카드 갯수 담기
        for(int i= 0; i < N;i++){
            int line = Integer.parseInt(st1.nextToken());
            card.put(line, card.getOrDefault(line, 0)+1);
        }
        // 세번째 줄 - M
        int M = Integer.parseInt(br.readLine());

        // 네번째 줄 - 숫자 카드가 적혀있는 정수
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        br.close();


        // 최종 결과가 List
        LinkedList<Integer> list = new LinkedList<>();


        for(int i= 0; i < M;i++) {
            int s = Integer.parseInt(st2.nextToken());
            // card에 key = s있는지 확인
            if(card.containsKey(s)){
                //있다면 key = s 인 value가지고와서 추가하기
                 list.add(card.get(s));
             }else {
                // 없으면 0넣기
                 list.add(0);
             }
            // card에 key = s있는지 확인
            //=> list.add(card.getOrDefault(s, 0));

            //containsKey -> O(1) : key값으로 바로접근해서 찾기때문에
            //containsValue -> O(N)


        }

        // map을 이용해 출력
        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));


    }

}
