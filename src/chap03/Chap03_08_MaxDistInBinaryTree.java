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

    public static void main(String[] args) {
        TreeNode root = new Chap03_08_MaxDistInBinaryTree().generateTree();
        int ans = new Chap03_08_MaxDistInBinaryTree().maxDist(root);
        System.out.println(ans);
    }

    public TreeNode generateTree() {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node3.right = node4;
        return root;
    }
}
