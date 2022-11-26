public class item006 {

    /**
     * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
     * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
     */

    public int removeDuplicates(int[] nums) {
        int fast = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[fast] != nums[i]) {
                nums[++fast] = nums[i];
            }
        }
        return fast + 1;

    }


    public static void main(String[] args) {
        item006 item006 = new item006();
        System.out.println(item006.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

}
