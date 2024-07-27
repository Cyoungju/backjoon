package day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution5 {
    // 두 배열의 합 - 2143번
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //첫번째 줄 - 두배열을 합해서 얻을 수
        int N = Integer.parseInt(br.readLine());

        int[] a = new int[Integer.parseInt(br.readLine())];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0;i< a.length; i++){
            int arr = Integer.parseInt(st1.nextToken());
            a[i] = arr;
        }

        int[] b = new int[Integer.parseInt(br.readLine())];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0;i< a.length; i++){
            int arr = Integer.parseInt(st2.nextToken());
            b[i] = arr;
        }

    }

}
