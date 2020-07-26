import java.util.*;
//计算最好叶子节点的路径
public class Haoyezi {
    int num = 0;
    public int test(TreeNode root, int distance) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int count = 0;
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(i) - list.get(j) < distance)
                    count++;
            }
        }
        return count;
    }
    //num记录了遍历顺序而不是路径，这里错了
    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return ;
        dfs(root.left, list);
        if (root.left == null && root.right == null)
            list.add(num);
        num++;
        dfs(root.right, list);
    }
}
