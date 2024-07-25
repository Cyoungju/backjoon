package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution5 {
    // 스택 - 10828번
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i< N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            switch (line){
                //push X: 정수 X를 스택에 넣는 연산이다.
                case "push" :
                    int num = Integer.parseInt(st.nextToken());
                    stack.add(num);
                    break;

                //pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "pop" :
                    if(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;

                //size: 스택에 들어있는 정수의 개수를 출력한다.
                case "size" :
                    sb.append(stack.size()).append("\n");;
                    break;

                //empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
                case "empty" :
                    if(stack.isEmpty()){
                        sb.append(1);
                    }else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;

                //top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "top" :
                    if(!stack.isEmpty()){
                        sb.append(stack.peek());
                    }else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
            }

        }


        System.out.println(sb.toString());

    }
}
