package actualcombat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**作者：LeetCode
        链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/solution/er-cha-shu-de-xu-lie-hua-yu-fan-xu-lie-hua-by-leet/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return rserialize(root, sb).toString();
    }
    //深度优先递归序列化
    private StringBuilder rserialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
        } else {
            sb.append(root.val).append(",");
            rserialize(root.left, sb);
            rserialize(root.right, sb);
        }
        return sb;
    }

    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }
    //递归添加到树中
    private TreeNode rdeserialize(List<String> list) {
        if (list.isEmpty()) return null;
        if ("null".equals(list.get(0))) {
            list.remove(0);
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        treeNode.left = rdeserialize(list);
        treeNode.right = rdeserialize(list);
        return treeNode;
    }

}
