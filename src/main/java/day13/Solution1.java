package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 보물 - 1026번
public class Solution1 {
    public static void main(String[] args) throws IOException {

        // b는 순서를 변경할수 없음
        // a를 변경
        // a[0]*b[0] + a[1]*b[1] ...
        // ** 문제 해결
        // ** b의 제일작은수 * a의 제일 큰수 를 계산해야 제일 작은 숫자를 얻을수 있음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        // A 배열
        Integer[] arrA = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < N; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        // A 배열 내림차순 정렬
        Arrays.sort(arrA, Collections.reverseOrder());

        // B 배열
        Integer[] arrB = new Integer[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 0;i < N; i++){
            arrB[i] = Integer.parseInt(st2.nextToken());
        }

        int sum =0;
        boolean[] used = new boolean[N];

        for(int i = 0;i < N; i++){
            int minB = Integer.MAX_VALUE;
            int minIndex = -1;

            // 사용되지 않은 B의 최소값 찾기
            for(int j=0;j<N;j++){
                if (!used[j] && arrB[j] < minB) {
                    minB = arrB[j];
                    minIndex = j;
                }
            }

            used[minIndex] = true; // 해당 인덱스를 사용했음을 표시
            sum += arrA[i] *minB; // A의 i번째 큰 수와 B의 최소값 곱하기
        }

          System.out.println(sum);
    }

    // 14196kb / 132ms

}
