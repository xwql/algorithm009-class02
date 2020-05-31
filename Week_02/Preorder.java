import java.util.ArrayList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 */
public class Preorder {
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root != null) {
            list.add(root.val);
            List<Node> children = root.children;
            for (Node chil : children ) {
                if(chil != null) preorder(chil);
            }
        }
        return list;
    }
}
