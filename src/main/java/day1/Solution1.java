package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        // a,b 변수 선업
        // BufferedReader - Scanner보다 시간 성능이 좋음
        // IOException 추가 해줘야함
        // 공백을 기준으로 입력을 받아야함 - StringTokenizer

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str, " ");

        ArrayList<Integer> array = new ArrayList<>();

        while (st.hasMoreTokens()) {
            array.add(Integer.parseInt(st.nextToken()));
        }

        int a = array.get(0);
        int b = array.get(1);
        if(a > b){
            System.out.println(">");
        }else if(a < b){
            System.out.println("<");

        }else {
            System.out.println("==");
        }

    }
}
