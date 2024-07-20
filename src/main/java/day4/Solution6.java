package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution6 {
    public static void main(String[] args) throws IOException {
        // 회사에 있는 사람 7785번

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 첫번째줄 숫자
        int num = Integer.parseInt(br.readLine());

        HashSet<String> arr = new HashSet<>();

        for(int i=0;i < num;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String status = st.nextToken();
            if(status.equals("enter")){
                arr.add(name);
            }else if (status.equals("leave")) {
                arr.remove(name);
            }
        }

        ArrayList<String> sortedList = new ArrayList<>(arr);
        Collections.sort(sortedList, Collections.reverseOrder());

        for(String name : sortedList){
            sb.append(name).append("\n");
        }

        System.out.println(sb.toString());
    }

}
