import java.util.HashMap;


public class TwoNums {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] twoSum(int[] nums, int target) {
        int[] two = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    two[0] = i;
                    two[1] = j;
                }
            }
        }
        return two;
    }

    /**
     * Map实现
     */
    public int[] twoSumV2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                return new int[]{index, i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        TwoNums twoNums = new TwoNums();
        int[] ints = twoNums.twoSum(nums, 6);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode tmpL = l, first = l1, second = l2;
        //复制链一
        while (first != null) {
            tmpL.val = first.val;
            first = first.next;
            if (first != null) {
                tmpL.next = new ListNode(0);
            }
            tmpL = tmpL.next;
        }
        tmpL = l;
        int mark = 0; //进位数
        //和链二求和
        while (second != null) {
            int i = tmpL.val + second.val + mark;
            if (i >= 10) {
                tmpL.val = i % 10;
                mark = 1;
            } else {
                tmpL.val = i;
                mark = 0;
            }
            second = second.next;
            if ((tmpL.next == null && second != null) || (mark == 1 && tmpL.next == null)) {
                tmpL.next = new ListNode(0);
            }
            tmpL = tmpL.next;
        }
        //对剩余部分或进数求和
        while (mark == 1) {
            int i = tmpL.val + mark;
            if (i >= 10) {
                tmpL.val = i % 10;
                if (tmpL.next == null) {
                    tmpL.next = new ListNode(0);
                }
                tmpL = tmpL.next;
            } else {
                tmpL.val = i;
                mark = 0;
            }
        }
        return l;
    }
}
