package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution2 {
    // 단어 순서 뒤집기 - 12605번
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Stack<String> stack = new Stack<>();
            // 스택에 넣어주기
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                stack.add(word);
            }
            sb.append("Case #").append(i+1).append(": ");
            // 스택이 빌때까지 빼주기
            while (!stack.isEmpty())
                sb.append(stack.pop()).append(" ");
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

}
