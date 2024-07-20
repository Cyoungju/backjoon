package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution8 {
    public static void main(String[] args) throws IOException {
        // 서로다른 부분 문자열의 개수
        // 문자열 S
        // S의 서로다른 부분 문자열의 개수를 구하는 프로그램
        // 부분 문자열 = 연속된 일부분 , 길이가 1보다 크거나 같아야함

        //substring(0,2)
        //substring(1,3)
        //substring(2,4)
        //substring(3,5)

        //substring(0,2)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        HashSet<String> arrayList = new HashSet<>();

        for(int i=0; i < line.length();i++){
            for(int j=1; i + j <= line.length();j++) {
                arrayList.add(line.substring(i, i+j));
            }
        }

        System.out.println(arrayList.size());


    }

}