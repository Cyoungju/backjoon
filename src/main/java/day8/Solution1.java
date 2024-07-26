package day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution1 {
    // 민균이의 비밀번호 - 9933번
    public static void main(String[] args) throws IOException {

        // 모든 단어의 길이 홀수
        // 비밀번호를 뒤집어서 쓴 문자열도 포함

        // 입력받은 값을 모두 넣어주기
        // 모든 단어들을 뒤집어서 들어가있는 문자가 있는지 확인

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet <String> set = new HashSet<>();
        // Set<String> set = new HashSet<>();
        // 확장성면에서는 set이 더 좋을수가있음

        // 입력만은 값이 중복된 문자열이 없도록 hashset에 넣어주기
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            set.add(line);
        }
        br.close();

        StringBuilder sb1 = new StringBuilder();

        // set을 돌아보면서 뒤집은 문자열과 겹치는 문자가 있는지 확인하기
        for(String arr : set){
            StringBuilder sb = new StringBuilder(arr);
            // 문자열 뒤집기
            String reverse = String.valueOf(sb.reverse());

            //뒤집은 문자열이 set에 존재 하는지 확인 - 있다면 해당 문자열의 길이와 중간 문자 출력
            if(set.contains(reverse)){
                int length = reverse.length();
                sb1.append(length).append(" ").append(reverse.substring(length/2, length/2+1));
                break;
            }
        }
        System.out.println(sb1.toString());

        // util클래스 사용하는 것들 전부 - null항상 체크해주기

    }

}
