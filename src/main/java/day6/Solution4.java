package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution4 {
    // 인사성 밝은 곰곰이 25192번
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int num = Integer.parseInt(br.readLine());
        int count = 0;

        // 조건 다음 Enter가 나올때까지 카운트한다
        // 단, 동일한 이름이 나올시에는 중복 제거 한다

        HashSet<String> set = new HashSet<>();

        for(int i=0;i < num;i++){
            String line = br.readLine();
            if(line.equals("ENTER")){
                //set 비우기
                if(!set.isEmpty()){
                    set.clear();
                }
            }else { // ENTER가 아닐경우
                if(!set.contains(line)){
                    set.add(line);
                    count++;
                }
            }
        }
        System.out.println(count);

    }

}
