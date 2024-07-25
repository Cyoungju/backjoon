package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1 {
    // 막대기 - 17608번
    public static void main(String[] args) throws IOException {

        // 스택을 이용

        // 입력 정수가 100000까지 담겨야 하기 때문에 Buffered 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        // 스택에 추가
        for(int i = 0;i<N;i++){
            int h = Integer.parseInt(br.readLine());
            stack.add(h);
        }

        int count = 1; // 제일 높은 막대기는 무조건 보이기 때문에 1로 설정
        int maxHeight = stack.pop(); // 첫번째 막대기 제일 높은값으로 초기 설정

        while (!stack.isEmpty()) {
            int height = stack.pop();
            if (height > maxHeight) { // 다음 막대기가 maxHeight보다 클 경우 카운트 해주기
                // 중간에 가려서 안보이는 막대기는 카운트 하면 안되기 때문에 앞에 막대기가 나보다 작을때만 카운트
                count++;
                maxHeight = height; //그리고 maxHeight 해당 막대기의 높이로 바꾸기
            }
        }

        System.out.println(count);
    }

}
