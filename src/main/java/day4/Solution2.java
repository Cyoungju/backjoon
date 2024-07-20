package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        // 단어의 개수 1152번

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //공백 기준으로 단어들을 자름
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //최종 갯수 count
        int count=0;

        while (st.hasMoreTokens()){
            st.nextToken();
            count++;
        }

        System.out.println(count);

    }
}
