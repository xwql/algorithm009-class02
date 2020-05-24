/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *

 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapPairsLink {
    //迭代
    public ListNode swapPairs2(ListNode head) {
        ListNode curr = head;
        ListNode pre = new ListNode(0);//指向下一个需要交换的节点对(pre赋值为交换完节点对的第二个节点)
        if(head == null)
            return null;
        if (head.next != null) {
            head = head.next;
        }
        while (curr != null && curr.next != null) {
            //if(curr.next == null) return head;
            ListNode tmp = curr.next.next;
            //开始交换两个节点
            ListNode currTmp = curr.next;
            curr.next = tmp;
            currTmp.next = curr;
            pre.next = currTmp;//pre
            //两个节点交换完成
            curr = tmp;
            pre = pre.next.next;//交换完成的第二个节点
        }
        return head;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
