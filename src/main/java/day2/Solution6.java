package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6 {
    public static void main(String[] args) throws IOException {
        // 수들의 합5 - 2018번
        // 배열을 순서대로 탐색해야함
        // 투포인터

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int [] arr = new int[num];

        //배열 저장
        for(int i =0 ; i < num; i++){
            arr[i] = i+1;
        }


        // 탐색
        int sum = 0, start = 0, end = 0, count = 0;

        while (true){
            if(sum >= num){ //합이 num 보다 크거나 같다면
                sum -= arr[start++]; // 값을 빼주고 start++
            }else if(end == num){ //end가 맨 끝에 도착했을 경우
                break; //반복문 끝냄
            }else { //합이 num 보다 작다면
                sum += arr[end++];
            }

            if(sum == num){ //start가 num 과 일치 한다면
                count++; // count증가
            }
        }

        System.out.println(count);

    }
}
