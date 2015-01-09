package chap03;

/**
 * Created by yaodh on 2015/1/9.
 */
public class Chap03_09_ConstructBinaryTree {
    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int x) {
            data = x;
            left = right = null;
        }
    }

    public TreeNode buildTree(String preorder, String inorder) {
        if (preorder == null) {
            return null;
        }
        char val = preorder.charAt(0);
        TreeNode node = new TreeNode(val);
        int idx = inorder.indexOf(val);
        if (idx > 0) {
            node.left = buildTree(preorder.substring(1, idx + 1), inorder.substring(0, idx));
        }
        if (idx < inorder.length() - 1) {
            node.right = buildTree(preorder.substring(idx + 1), inorder.substring(idx + 1));
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root2 = new Chap03_09_ConstructBinaryTree().buildTree("abdcef", "dbaecf");
        dfs(root2);
    }

    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println((char) root.data);
        dfs(root.left);
        dfs(root.right);
    }
}
