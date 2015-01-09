package chap03;

/**
 * Created by yaodh on 2015/1/8.
 */
public class Chap03_08_MaxDistInBinaryTree {
    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int x) {
            data = x;
            left = right = null;
        }
    }

    int ans = 1;

    public int maxDist(TreeNode root) {
        maxHeight(root);
        return ans - 1;
    }

    public int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDist = maxHeight(root.left);
        int rightDist = maxHeight(root.right);
        ans = Math.max(ans, leftDist + rightDist + 1);
        return Math.max(leftDist, rightDist) + 1;
    }

    void morrisTraversal(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                System.out.println(cur.data);
                cur = cur.right;
                continue;
            }
            TreeNode pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            if (pre.right == null) {
                System.out.println(cur.data);
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
//                System.out.println(cur.data);
                cur = cur.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new Chap03_08_MaxDistInBinaryTree().generateTree();
        new Chap03_08_MaxDistInBinaryTree().morrisTraversal(root);
        int ans = new Chap03_08_MaxDistInBinaryTree().maxDist(root);
        System.out.println(ans);
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
        node6.left=node2;
        node6.right=node7;
        node2.left=node1;
        node2.right=node4;
        node4.left=node3;
        node4.right=node5;
        node7.right=node9;
        node9.left=node8;
        return node6;
    }
}
