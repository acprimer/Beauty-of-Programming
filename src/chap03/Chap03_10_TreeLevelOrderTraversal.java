package chap03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yaodh on 2015/1/9.
 */
public class Chap03_10_TreeLevelOrderTraversal {
    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int x) {
            data = x;
            left = right = null;
        }
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int curLevel = 1;
        int nextLevel = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            curLevel--;
            System.out.printf("%d ", node.data);
            if (node.left != null) {
                queue.offer(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevel++;
            }
            if (curLevel == 0) {
                System.out.println();
                curLevel = nextLevel;
                nextLevel = 0;
            }
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<TreeNode> level = new ArrayList<TreeNode>();
        List<TreeNode> nextLevel = new ArrayList<TreeNode>();
        level.add(root);
        while(true){
            if (level.isEmpty() || level.get(0) == null){
                break;
            }
            List<Integer> currentLevel = new ArrayList<Integer>();
            nextLevel.clear();

            for (TreeNode node : level){
                currentLevel.add(node.data);
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }
            result.add(currentLevel);
            level = nextLevel;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new Chap03_10_TreeLevelOrderTraversal().generateTree();
        new Chap03_10_TreeLevelOrderTraversal().traversal(root);
    }

    public TreeNode generateTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node6.left = node2;
        node6.right = node7;
        node2.left = node1;
        node2.right = node4;
        node4.left = node3;
        node4.right = node5;
        node7.right = node9;
        node9.left = node8;
        return node6;
    }
}
