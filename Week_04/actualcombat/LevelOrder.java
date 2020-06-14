package actualcombat;

import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        dfs(list, root, 0);
        return list;
    }

    private void dfs(List<List<Integer>> list, TreeNode root, int level) {
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        if (root.left != null)
            dfs(list, root.left, level + 1);
        if (root.right != null)
            dfs(list, root.right, level + 1);
    }

    public List<List<Integer>> levelOrderV2(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                tmpList.add(poll.val);
                if (poll.left != null)
                    queue.offer(poll.left);
                if (poll.right != null)
                    queue.offer(poll.right);
            }
            list.add(tmpList);
        }
        return list;
    }
}
