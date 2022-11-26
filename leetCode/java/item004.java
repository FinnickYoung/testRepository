public class item004 {

    /**
     * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。
     * 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
     *
     * @param num
     * @return
     */
    public int numberOfSteps(int num) {
        int count = 0;
        if (num >= 1) {
            while (num != 0) {
                if (num % 2 == 1) {
                    num = num - 1;
                }
                else if (num % 2 == 0) {
                    num = num / 2;
                }
                count += 1;
            }
        }
        return count;
    }
}
