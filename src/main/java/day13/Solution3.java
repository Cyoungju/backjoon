package day13;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 좌표 압축 18870번
public class Solution3 {
    public static void main(String[] args) throws IOException {
        // 수의 범위가 매우 큰 상황에서 수의 값에 무관하게 좌표들 사이의 대소만 알게될때, 좌표 앞축을 이용하면 수의 범위를 줄일 수있다

        //좌표 압축 알고리즘이란?
        //: 모든 구간이 아니라, 중요한 구간이나, 숫자만 들고있는 기법.
        //→ 순위가 중요한 알고리즘에서 입력값의 개수 < 입력값의 범위일때 사용한다.

        // 본인의 수보다 작은 숫자의 개수를 출력하는 문제

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine()); // 좌표의 개수

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] notSortArr = new int[N]; //정렬하기 전에 저장할 배열

        for(int i = 0; i < N; i++){
            notSortArr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        // 기존 배열은 순서가 변하면 안되기 때문에 clone해줌
        int[] sortArr = notSortArr.clone(); //기존 배열의 값을 복사해서 넣음

        Arrays.sort(sortArr); // 정렬
        //중복값인 경우는 같은 값을 가지므로 HashMap으로 중복값을 체크해준다.
        Map<Integer, Integer> map = new HashMap<>(); // 값과 요소의 순서(출력해야하는 값)을 쌍으로 저장

        int index = 0;
        // 비교할 배열 만들기
        for(int i : sortArr){ //sortArr정렬된 배열 반복문을 돎
            if(!map.containsKey(i)){ // map에 중복된 키가 없을 경우
                //해당 정렬된 값이 key가 된다.
                map.put(i, index++); //해당 값과 해당 요소의 순서를 map에 쌍으로 저장
            }
        }

        for(int i : notSortArr){ // 실질적인 출력값을 버퍼에 저장하기
            bw.write(map.get(i) + " "); //키로 값(앞축된 좌표, map 에 저장된 index를 넣어준다)
        }

        bw.flush();
        bw.close();

    }

}
