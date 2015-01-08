package chap03;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yaodh on 2015/1/8.
 */
public class Chap03_07_MaxQueue {
    Queue<Integer> queue = new LinkedList<Integer>();
    List<Integer> max = new LinkedList<Integer>();
    void push(int x) {
        queue.offer(x);
        if(max.size()==0 || x<=max.get(max.size()-1)) {
            max.add(x);
        } else {
            max.remove(max.size()-1);
            max.add(x);
        }
    }
    int pop() {
        int x = queue.poll();
        if(x==max.get(0)) {
            max.remove(0);
        }
        return x;
    }
    int maxElement() {
        return max.get(0);
    }

    public static void main(String[] args) {
        Chap03_07_MaxQueue queue = new Chap03_07_MaxQueue();
        queue.push(1);
        queue.push(2);
        queue.push(4);
        queue.push(4);
        queue.push(2);
        queue.push(3);
        System.out.println("max: " + queue.maxElement());
        System.out.println("pop: " + queue.pop());
        System.out.println("max: " + queue.maxElement());
        System.out.println("pop: " + queue.pop());
        System.out.println("max: " + queue.maxElement());
        System.out.println("pop: " + queue.pop());
        System.out.println("max: " + queue.maxElement());
        System.out.println("pop: " + queue.pop());
        System.out.println("max: " + queue.maxElement());
        System.out.println("pop: " + queue.pop());
        System.out.println("max: " + queue.maxElement());
        System.out.println("pop: " + queue.pop());
    }
}
