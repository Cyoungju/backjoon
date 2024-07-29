package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3 {
    // 콘서트 - 16466번
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //테스트 케이스 개수
        int N = Integer.parseInt(br.readLine());


        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        //배열에 넣기
        for(int i =0;i< arr.length;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        for(int i =1; i<= arr.length;i++){
            // i = 1,2,3,4,5...
            // arr[i-1] = i;
            // 같을경우 다음으로 넘어가기
            // 다를 경우 해당 값의 arr[i-1] 출력
            if(arr[i-1] != i){
                sb.append(i == 1 ? 1 : arr[i-2] + 1);
                break;
            }else if(i == arr.length){ // 마지막까지 다 돌경우
                sb.append(arr[i-1] +1);
            }
        }
        System.out.println(sb);

    }

}
