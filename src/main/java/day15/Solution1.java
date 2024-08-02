package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 그녀를 찾아서 -  16502번
public class Solution1 {

    // 인접 리스트
    static List<HashMap<Integer, Double>> adj  = new ArrayList<>();
    // 정점 번호, 확률 저장할 HashMap이 담긴 인접 리스트 생성
    static int time;

    // 각 정점의 확률을 저장할 배열
    static double[] doubles = new double[4];


    // 확률을 구할때, 해당 경우의수가 나올수 있는 확률을 모두 더한다.
    public static void main(String[] args) throws IOException {
        // 재귀 - dfs
        // 인접 리스트

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        time = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        // 각 정점에 대한 HashMap 초기화
        for (int i = 0; i < 4; i++) {
            adj.add(new HashMap<>());
        }

        // 간선의 정보 입력 받기
        for(int i = 0;i < edge;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char startEdge = st.nextToken().charAt(0);
            char endEdge = st.nextToken().charAt(0);
            double per = Double.parseDouble(st.nextToken());

            adj.get(startEdge - 'A').put(endEdge - 'A', per);
        }

        int count = 0;

        // 매장은 A,B,C,D 네개로 정해져있음
        for (int i = 0; i < 4; i++) {
            //탐색
            dfs(i, 0.25, count);
        }


        // 절대/상대 오차는 10-2까지 허용 -> 소수점 2번째까지 출력
        for (int i = 0; i < 4; i++) {
            System.out.printf("%.2f",doubles[i]);
            System.out.println();
        }

    }

    // DFS로 탐색해서 모든 경우를 구하고, count한다
    // count한 결과가 time과 같을때 종료되는 기저조건을 작성한다
    // 마지막에 종료될때 모든 경우에수에 나온 확률을 더해서 출력한다.
    static void dfs(int now, double v, int count){
        if(time == count){
            doubles[now] += v * 100;
            return;
        }

        // Map 의 전체 내용 출력
        for(Map.Entry<Integer, Double> entry : adj.get(now).entrySet()){
            int entryKey = entry.getKey();
            double entryValue = entry.getValue();

            dfs(entryKey, v*entryValue, count+1);

        }
    }

    // 14400kb	136ms
}
