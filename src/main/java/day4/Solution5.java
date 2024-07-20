package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution5 {
    public static void main(String[] args) throws IOException {
        // 단어 공부 1157번

        // 입력받은 문자열 가지고 오기
        // 문자 길이 만큼 for문으로 탐색하기
        // 문자를 저장할 ArrayList
        // String s = st.carAt(i);
        // s와 동일한 equalsIgnoreCase 있는지 확인 count++

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().toUpperCase();
        String[] s = new String[line.length()];

        // 입력받은 문자열 배열에 저장
        for(int i=0;i < s.length;i++){
            s[i] = line.substring(i,i+1);
        }

        // 문자의 빈도를 저장할 HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // HashMap에 문자의 빈도를 저장
        for(String key : s) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // 최대 빈도수 찾기
        int maxValue = Collections.max(map.values());
        // 최대 빈도수를 가지는 문자의 갯수를 세기 위한 변수
        int maxCount = 0;
        // 최대 빈도수를 가지는 문자를 저장하기 위한 변수
        String maxKey ="";


        //HashMap을 순환하면서 최대 빈도수를 가지고 있는 문자 찾기
        for(String key : map.keySet()){
            //문자가 있으면 maxCount ++
            if(map.get(key) == maxValue){
                maxCount++;
                maxKey = key;
            }
        }

        //최대 빈도수를 가지는 문자가 여러개일 경우
        if(maxCount > 1){
            System.out.println("?");
        }else {
            System.out.println(maxKey);
        }

    }
}
