public class MaximalSquare {
    //写好了  但是有个例子超时了   我草！！！


    //    在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
    public int maximalSquare(char[][] matrix) {
        Integer maxSquare = 0;
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    //判定上下及其对角线是否1 判定方式 优先判定对角线 然后再判定上边和左边
                    if (maxSquare < Math.min(matrix.length - i, matrix[i].length - j)) {
                        for (int k = 1; k < Math.min(matrix.length - i, matrix[i].length - j); k++) {
                            if (judgeSquare(matrix, i, j, k)) {
                                if (maxSquare < k)
                                    maxSquare = k;
                            }
                            else {
                                break;
                            }
                        }
                    }
                    res = (int) Math.pow((maxSquare + 1), 2);
                }
            }
        }
        System.out.println(res);
        return res;
    }

    public Boolean judgeSquare(char[][] matrix, int i, int j, int k) {
        // 判定对角线
        // 判定左边和上边
        //TODO 要想找到唯一的一个结果  可以使用 或的方式 以及结果的反向。
        //如下  我想找到 matrix[i + k][j + k] == '1' && matrix[i + k][j + l] == '1' && matrix[i + l][j + k] == '1' 的情况  可以通过下面的代码找出。
        for (int l = 0; l < k; l++) {
            if (matrix[i + k][j + k] == '0' || matrix[i + k][j + l] == '0' || matrix[i + l][j + k] == '0') {
                return false;
            }
        }
        return true;
    }


    public int maximalSquare_minTime(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        // 动态规划
        int m = matrix.length, n = matrix[0].length;
        // dp[i][j]代表以以ij位置为正方形右下角的最大正方形的边长
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    //这一部分 主要是为了控制上和左的数值正确
                    // 防止后面计算相邻位置dp[i][j]时候出现 0-1 的情况。
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }
                    else {
                        //这个式子 有点意思
                        /**
                         * dp(i,j) 的值由其上方、左方和左上方的三个相邻位置的 dp[i][j] 值决定。
                         * 具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 1，
                         *
                         * 作者：力扣官方题解
                         * 链接：https://leetcode.cn/problems/maximal-square/solutions/234964/zui-da-zheng-fang-xing-by-leetcode-solution/
                         * 来源：力扣（LeetCode）
                         */
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(dp[i][j], maxSide);
                }
            }
        }
        System.out.println(Math.pow(maxSide, 2));
        return (int) Math.pow(maxSide, 2);
    }

    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        long start = System.currentTimeMillis();
        maximalSquare.maximalSquare(new char[][]{
                {'0', '1', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'}});
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        long start1 = System.currentTimeMillis();

        maximalSquare.maximalSquare_minTime(new char[][]{
                {'0', '1', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'}});
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);
    }

}
