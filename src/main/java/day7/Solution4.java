package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution4 {
    // 큐 - 10845번
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        int queueIdx = 0;

        for(int i=0;i< N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            switch (line){
                //push X: 정수 X를 큐에 넣는 연산이다.
                case "push" :
                    int num = Integer.parseInt(st.nextToken());
                    queue.add(num);
                    queueIdx = num;
                    break;

                //pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "pop" :
                    if(!queue.isEmpty()){
                        sb.append(queue.poll());
                    }else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;

                //size: 큐에 들어있는 정수의 개수를 출력한다.
                case "size" :
                    sb.append(queue.size()).append("\n");;
                    break;

                //empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
                case "empty" :
                    if(queue.isEmpty()){
                        sb.append(1);
                    }else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;

                //front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "front" :
                    if(!queue.isEmpty()){
                        sb.append(queue.peek());
                    }else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
                //back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "back" :
                    if(!queue.isEmpty()){
                        sb.append(queueIdx);
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
