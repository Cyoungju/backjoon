package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5 {
    public static void main(String[] args) throws IOException {
        // 수들의 합2 - 2003번
        // 배열을 순서대로 탐색해야함

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int [] array = new int[num1];
        String[] line = br.readLine().split(" ");

        int sum = 0, start = 0, end = 0, count = 0;


        //배열 저장
        for(int i =0 ; i < num1; i++){
            array[i] = Integer.parseInt(line[i]);
        }

        //탐색
        while (true){
            if(sum >= num2){ //합이 num 보다 크거나 같다면
                sum -= array[start++]; // 값을 빼주고 start++
            }else if(end == num1){ //end가 맨 끝에 도착했을 경우
                break; //반복문 끝냄
            }else { //합이 num 보다 작다면
                sum += array[end++];
            }

            if(sum == num2){ //start가 num 과 일치 한다면
                count++; // count증가
            }
        }

        System.out.println(count);

    }
}
