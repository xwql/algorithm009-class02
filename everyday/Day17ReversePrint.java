import java.util.Deque;
import java.util.LinkedList;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day17ReversePrint {
    public int[] reversePrint(ListNode head) {
        if(head == null) return new int[0];
        int length = 0;
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
            length++;
        }
        int[] res = new int[length];
        int i = 0;
        while (pre != null) {
            res[i++] = pre.val;
            pre = pre.next;
        }
        return res;
    }
    public int[] reversePrintV2(ListNode head) {
        ListNode pre = head;
        int i = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (pre != null) {
            stack.addLast(pre.val);
            pre = pre.next;
            i++;
        }
        int[] res = new int[i];
        int j = 0;
        while (!stack.isEmpty()) {
            res[j++] = stack.removeLast();
        }
        return res;
    }
}
