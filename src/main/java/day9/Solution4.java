package day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution4 {
    // 패션왕 신해빈 - 9375번
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //첫번째 줄 - 테스트 케이스 개수 N
        int N = Integer.parseInt(br.readLine());

        //테스트 케이스
        for(int i =0;i < N;i++){
            Map<String ,Integer> map = new HashMap<>();
            // 첫번째 - 의상 개수 M
            int M = Integer.parseInt(br.readLine());

            // 두번째~ M개까지
            for(int j=0;j < M;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); //의상의 이름은 버려주기
                String word = st.nextToken(); //의상 종류 map에 넣고 count해준다
                map.put(word,map.getOrDefault(word, 0)+1);
            }

            // map에 들어간 value를 읽어와서 해당 숫자에 +1
            // 예제1)
            // headgear 2개 / eyewear 1개
            // 1. headgear가 가지는 경우의수
            // headgear1, headgear2, 아무것도 선택하지 않은경우 --> 3가지 (중복으로 가질수 없기때문에 하나씩만 선택해줌)
            // 2. eyewear가 가지는 경우의수 -> 2
            // eyewear1, 아무것도 하지 않음
            // 최종 경우의 수 -> (3*2) => 6 / 여기서 둘다 아무것도 착용하지 않은 경우의수 -1해줘야한다!

            int result = 1;
            for(int count : map.values()){
                result = result * (count+1);
            }
            result-=1;
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

}
