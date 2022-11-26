import java.util.*;

public class findKthLargest {
    /**
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     * <p>
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * <p>
     * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(Integer[] nums, int k) {
//        首先对int进行由大到小的排序  然后拿出第K个值即可。
        //   排序能够使O(n) 的时间复杂度的有哪些呢？ （学到了排序库函数）
        Arrays.sort(nums);//正序
//        Arrays.sort(nums, Comparator.reverseOrder());//倒序
        return nums[nums.length - k];
    }


    public static void main(String[] args) {
        findKthLargest item008 = new findKthLargest();
        System.out.println(item008.findKthLargest(new Integer[]{1, 1, 1, 19, 1, 1, 2, 3}, 1));
    }

}
