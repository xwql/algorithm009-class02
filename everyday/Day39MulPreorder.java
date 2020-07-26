import java.util.ArrayList;
import java.util.List;

public class Day39MulPreorder {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root != null) {
            list.add(root.val);
            root.children.stream().forEach(this::preorder);
        }
        return list;
    }
}
