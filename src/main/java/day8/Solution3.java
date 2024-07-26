package day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution3 {
    // 전주 듣고 노래 맞히기 - 31562번
    public static void main(String[] args) throws IOException {

        // 첫번째 줄
        // - 정환이 음을 아는 노래 개수 N
        // - 정환이 맞히기를 시도할 노래 개수 M
        //
        // 두번째줄~N개
        // 노래 제목의 길이 T
        // 영어 대소문자로 이루어진 노래제목 S
        // 일곱개의 음이름

        // 여러개 있을경우 - 노래 모를때 ?
        // 저장한 노래가 없을때 !
        // 찾았을때 이름 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // (노래제목 ,3개음)
        HashMap<String, String> hashMap1 = new HashMap<>();
        // (3개음, 개수)
        HashMap<String, Integer> hashMap2 = new HashMap<>();

        // 2~N번째줄
        // hashMap1, hashMap2 에 넣어주기
        for(int i=0;i<N;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            st1.nextToken();
            String neme = st1.nextToken();
            StringBuilder note = new StringBuilder();
            for(int j = 0; j < 3; j++){
                note.append(st1.nextToken());
            }
            String noteSt = note.toString();
            hashMap1.put(neme, noteSt);
            hashMap2.put(noteSt, hashMap2.getOrDefault(noteSt, 0)+1);
        }

        // N+1 ~ M까지
        StringBuilder result = new StringBuilder();
        for(int i=0;i<M;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            StringBuilder note = new StringBuilder();
            for(int j = 0; j < 3; j++){
                note.append(st2.nextToken());
            }
            String noteSt = note.toString();

            // 찾는 노래가 없을때
            if (!hashMap2.containsKey(noteSt)) {
                result.append("!");
            }else if(hashMap2.get(noteSt) > 1){ // 음이 한개이상일때
                result.append("?");
            }else {
                for(String key : hashMap1.keySet()){
                    if(hashMap1.get(key).equals(noteSt)){
                        result.append(key);
                    }
                }
            }
            result.append("\n");
        }

        System.out.println(result.toString());

    }

}
