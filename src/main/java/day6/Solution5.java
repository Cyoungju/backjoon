package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution5 {
    // 덱 10866번

    static Deque<Integer> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int num = Integer.parseInt(br.readLine());
        deque = new LinkedList<>();

        for(int i = 0;i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String line = st.nextToken();

            if(line.equals("push_front")){
                pushFront(Integer.parseInt(st.nextToken()));
            }else if(line.equals("push_back")){
                pushBack(Integer.parseInt(st.nextToken()));
            }else if(line.equals("pop_front")){
                popFront();
            }else if(line.equals("pop_back")){
                popBack();
            }else if(line.equals("size")){
                size();
            }else if(line.equals("empty")){
                isEmpty();
            }else if(line.equals("front")){
                peekFront();
            }else if(line.equals("back")){
                peekBack();
            }
        }


    }

    // push_front X: 정수 X를 덱의 앞에 넣는다.
    static void pushFront(int n){
        deque.addFirst(n);
    }

    // push_back X: 정수 X를 덱의 뒤에 넣는다.
    static void pushBack(int n){
        deque.addLast(n);
    }

    // pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    static void popFront(){
        if(!deque.isEmpty()){
            System.out.println(deque.pollFirst());
        }else {
            System.out.println(-1);
        }
    }

    // pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    static void popBack(){
        if(!deque.isEmpty()){
            System.out.println(deque.pollLast());
        }else {
            System.out.println(-1);
        }
    }

    // size: 덱에 들어있는 정수의 개수를 출력한다.
    static void size(){
        System.out.println(deque.size());
    }

    // empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
    static void isEmpty(){
        if(deque.isEmpty()){
            System.out.println(1);
        }else {
            System.out.println(0);
        }

    }

    // front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    static void peekFront(){
        if(!deque.isEmpty()){
            System.out.println(deque.peekFirst());
        }else {
            System.out.println(-1);
        }
    }

    // back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    static void peekBack(){
        if(!deque.isEmpty()){
            System.out.println(deque.peekLast());
        }else {
            System.out.println(-1);
        }
    }


}
