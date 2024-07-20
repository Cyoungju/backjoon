package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3 {
    public static void main(String[] args) throws IOException {
        // 할리갈리 27160번

        // 4종류의 과일이 최대 5개까지 그려진 카드
        // 첫번째줄 - 펼쳐진 카드의 개수 N
        // 두번째줄 ~ N번째 줄 - 카드의 정보
        // STRAWBERRY, BANANA, LIME, PLUM

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째줄 숫자 받음
        int num = Integer.parseInt(br.readLine());
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;

        for(int i = 0; i < num; i++){
            // 두번쩨~ N번째 line받음
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            // name 저장
            String name = tokenizer.nextToken();
            int count = Integer.parseInt(tokenizer.nextToken());
            if(name.equals("STRAWBERRY")){
                count1 = count1 + count;
            }else if(name.equals("BANANA")){
                count2 = count2 + count;
            }else if(name.equals("LIME")){
                count3 = count3 + count;
            }else {
                count4 = count4 + count;
            }
        }
        if (count1 == 5 || count2 == 5 || count3 == 5 || count4 == 5){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
