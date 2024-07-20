package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution7 {
    public static void main(String[] args) throws IOException {
        // 파일정리 20291번
        // 확장자 별로 몇개씩 있는지 알려줘 - HashMap
        // 사전순으로 정렬 sort
        // .을 기준으로 split

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 첫번째줄 숫자
        int num = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0;i < num;i++) {
            // 마침표 기준으로 나누기 위해서는 . 이 아니라 \\. 를 사용해야함
            String[] line = br.readLine().split("\\.");
            // map에 추가
            map.put(line[1], map.getOrDefault(line[1], 0) + 1);
        }

        ArrayList<String> stArr = new ArrayList<>(map.keySet());
        // 정렬
        Collections.sort(stArr);

        for(String s : stArr){
            sb.append(s).append(" ").append(map.get(s)).append("\n");
        }

        System.out.println(sb.toString());
    }

}
