/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseKGroup { //pre 和head的命名稍微有点问题，导致后面看的有点乱
    public ListNode reverseKGroup(ListNode head, int k) {
        int i = 1;
        ListNode pre = head;//头
        while (head != null) {//判断长度
            if (i == k) break;
            head = head.next;
            i++;
        }
        //ListNode tail = head;
        if (i < k || head == null)
            return pre;
        i = 0;
        ListNode tmpHead = pre;      //翻转链头
        ListNode tmpPre = null;
        while (i != k) {  //排序k个节点
            ListNode tmp = tmpHead.next;
            if (i == 0) {
                tmpHead.next = reverseKGroup(head.next, k);// 翻转链后面的部分  //剩下的节点调用递归
            } else {
                tmpHead.next = tmpPre;
            }
            tmpPre = tmpHead;
            tmpHead = tmp;
            i++;
        }
        pre = tmpPre;
        return pre;
    }
}
