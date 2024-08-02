package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 스피카 -  21316번
public class Solution3 {

    // spica 의 특징
    // 정점 3개와 연결 되어있음
    // 연결된 정점이 각각 1개/2개/3개의 정점과 연결되어있음 => 합이 6이됨

    // 필요한 변수
    // 각각의 정점을 연결한 정보가 담긴 연결리스트
    // 정점의 개수를 담을 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<ArrayList<Integer>> list  = new ArrayList<>();
        int[] arr = new int[13];

        for(int i = 0; i< 13;i++){
            list.add(new ArrayList<>());
        }//초기화

        // 배열에 인접정점과 정점에 연결된 개수 넣기
        for(int i = 1; i< 13;i++){
            StringTokenizer st =  new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a]++;
            arr[b]++;
            
            list.get(a).add(b);
            list.get(b).add(a);
        }


        // 탐색
        // arr에 수가 3인 index를 찾는다
        // 찾은 idx를 가지고 ArrayList에서 탐색
        // idx에 가지고 있는 수에 해당하는 arr의 수를 다 더해서 6이 나오는지 확인
        for(int i = 1; i< 13;i++){
            if(arr[i] != 3){
                continue;
            }

            // arr에 3인 index를 찾았을경우 아래 로직 수행
            int sum = 0;
            for(int j=0;j< 3; j++){
                sum += arr[list.get(i).get(j)];
            }

            if(sum == 6){
                System.out.println(i);
                break;
            }
        }
    }

    // 	14300kb	128ms
}
