package chap02;
import java.util.Stack;
/**
 * Created by yaodh on 2014/12/20.
 */
public class Chap02_03_WaterKing {
    /**
     * 给一个ID数组，其中一个ID超过数组长度的一半，求出这个ID。
     * Time: O(n)
     * @param ids ID数组
     * @return 超过数组长度一般的ID
     */
    public int findMost(int[] ids) {
        int candidate = -1, count = 0;
        for (int i = 0; i < ids.length; i++) {
            if (count == 0) {
                candidate = ids[i];
                count = 1;
            } else {
                if (ids[i] == candidate) count++;
                else count--;
            }
        }
        return candidate;
    }
    public int findMostStack(int[] ids) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<ids.length;i++) {
            if(stack.isEmpty()) {
                stack.push(ids[i]);
            } else {
                if(stack.peek()==ids[i]) stack.push(ids[i]);
                else stack.pop();
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        int ans = new Chap02_03_WaterKing().findMost(new int[]{1, 2, 3, 4});
        System.out.println(ans);
    }
}
