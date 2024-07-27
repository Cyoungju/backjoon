package day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    // 서로 다른 부분 문자열의 개수 - 11478번
    public static void main(String[] args) throws IOException {

        // 문자열 S가 주어졌을 때, S의 서로 다른 부분 문자열의 개수를 구하는 프로그램
        // 부분 문자열 = 연속된 일부분 , 길이가 1보다 크거나 같아야함

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        //중복된 값은 들어가면 안되기 때문에 HashSet
        Set<String> set = new HashSet<>();

        //n~1, n~2, ... n~n-1 까지 문자열 잘라서 set에 넣어주기
        for(int i = 0; i < N.length(); i++){
            // 두번째에 오는 i+j값이 길이를 넘어가면 안되기때문에 조건문 작성
            for(int j = 1; i+j <= N.length(); j++){
                set.add(N.substring(i,i+j));
            }
        }

        // set에 들어가 있는 size 출력
        System.out.println(set.size());

    }

}
