package day7;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution6 {
    // 에디터 - 1406번
    public static void main(String[] args) throws IOException {

        // 영어 소문자만 기록할수 있는 편집기
        // 최대 600000

        // 길이가 L
        // 커서가 위치 할 수 있는곳 L+1
        // L 왼쪽으로 한칸
        // D 오른쪽으로 한칸
        // 커서 왼쪽에 있는 문자 삭제
        // $ 문자를 커서 왼쪽에 추가

        //스택을 두개 만들기
        // 스택 1 -> 기본 제공되는 문자열 넣기
        // 스택1 : p-> offer(X)
        // L -> 스택1 -> 스택2
        // D -> 스택2 -> 스택1
        // B -> 스택1 remove


        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        for(int i = 0;i < line.length();i++){
            String A = line.substring(i,i+1);
            stack1.push(A);
        }

        int N = Integer.parseInt(br.readLine());

        for(int i = 0;i <N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            switch (word) {
                case "P":
                    String X = st.nextToken();
                    stack1.push(X);
                    break;
                case "L":
                    if (!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                    break;
                case "D" :
                    if (!stack2.isEmpty()) {
                        stack1.push(stack2.pop());
                    }
                    break;
                case "B" :
                    if (!stack1.isEmpty()) {
                        stack1.pop();
                    }
                    break;
            }
        }

        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        while (!stack2.isEmpty()){
            sb.append(stack2.pop());
        }
        System.out.println(sb.toString());

    }
}
