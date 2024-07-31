package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 단어 정렬 1181번
public class Solution4 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String [] word = new String[N];

        //배열에 담기
        for(int i=0;i<N;i++){
            String line = br.readLine();
            word[i] = line;
        }

        // 중복삭제
        String[] uniqueArray = Arrays.stream(word).distinct().toArray(String[]::new);

        Arrays.sort(uniqueArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 1. 길이별로 정렬
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                    // +면 내림차순 // - 오름차순
                }
                // 2. 길이가 같을 경우 사전 순으로 정렬
                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String line : uniqueArray){
            sb.append(line).append("\n");
        }

        System.out.println(sb);


    }

}
