public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    //封装链表 this 代表当前类的和  this.val = val 一样的意思;
    public ListNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = nums[0];
        ListNode curr = this;
        for (int i = 1; i < nums.length; i++) {
            /**
             * 此处直接引用了
             * ListNode(int x) {
             *         val = x;
             *     }
             * 将赋予val 值。
             */
            curr.next = new ListNode(nums[i]);
            //有点蒙！！！
            curr = curr.next;
        }
    }

    public ListNode() {

    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            s.append(cur.val);
            s.append(" -> ");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}

class Solution {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        // int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        Solution solution = new Solution();
        ListNode res = solution.middleNode(head);
        System.out.println(res);
    }
}

//作者：liweiwei1419
//        链接：https://leetcode.cn/problems/middle-of-the-linked-list/solutions/165152/kuai-man-zhi-zhen-zhu-yao-zai-yu-diao-shi-by-liwei/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。