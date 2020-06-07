import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 */
public class MyBuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, indexMap, 0, n - 1, 0, n-1);
    }
    //根据根节点从中序遍历数组中确定左右子树，递归循环
    private TreeNode myBuildTree(int[] preorder, Map<Integer, Integer> indexMap, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int preRoot = preLeft;
        int inRoot = indexMap.get(preorder[preRoot]);
        TreeNode root = new TreeNode(preorder[preRoot]);
        root.left = myBuildTree(preorder, indexMap, preLeft + 1, preLeft + 1 + (inRoot - 1 - inLeft), inLeft, inRoot - 1);
        root.right = myBuildTree(preorder, indexMap, preLeft + inRoot - inLeft + 1, preRight, inRoot + 1, inRight);
        return root;
    }
}
