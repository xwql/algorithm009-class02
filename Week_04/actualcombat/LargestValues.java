package actualcombat;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 */
public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.pollFirst();
                if (max < treeNode.val) max = treeNode.val;
                if (treeNode.left != null) queue.offerLast(treeNode.left);
                if (treeNode.right != null) queue.offerLast(treeNode.right);
            }
            res.add(max);
        }
        return res;
    }
}
