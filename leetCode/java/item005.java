public class item005 {
    /**
     * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
     * <p>
     * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户
     *
     * @param accounts
     * @return
     */
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int i : account) {
                sum += i;
            }
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        item005 item005 = new item005();
        System.out.println( item005.maximumWealth(new int[][] {{1, 2}, {2, 3}}));
    }

}


