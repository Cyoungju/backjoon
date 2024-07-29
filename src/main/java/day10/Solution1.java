package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1 {
    // 일곱 난쟁이 - 2309번
    public static void main(String[] args) throws IOException {
        // 아홉개의 난쟁이의 키
        // 일곱난장이의 합이 100
        // 답이 여러개인 경우 아무거나 출력 (오름차순)

        // 입력받은 값을 모두 다 더해서 두가지를 빼준뒤 100이되는 수를 찾기
        // 전체를 찾는거보다  N^2으로 풀수있음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 난쟁이들의 키를 담을 배열
        int[] arr = new int[9];

        // 난쟁이들의 키의 합
        int sum = 0;

        // 배열에 입력받은 값 넣어주기
        for(int i = 0 ;i < 9;i++){
            int M = Integer.parseInt(br.readLine());
            arr[i] = M;
            sum += arr[i];
        }

        //배열 오름차순 정렬
        Arrays.sort(arr);

        // 난쟁이가 아닌 두명 찾기
        int x = 0;
        int y = 0;

        // 이중 for문을 돌면서 sum에서 두가지를 뺐을때 100이 되는 두 수를 찾기
        for(int i = 0;i < arr.length-1;i++){
            for(int j=i+1;j< arr.length;j++){
                if (sum - arr[i] - arr[j] == 100){
                    x = arr[i];
                    y = arr[j];
                    break;
                }
            }
        }

        //출력
        for(int shorted : arr){
            if(shorted != x && shorted != y){
                System.out.println(shorted);
            }
        }

    }

}
