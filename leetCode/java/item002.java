import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class item002 {

    public boolean canConstruct(String ransomNote, String magazine) {

        List<String> ransomNotes = Arrays.asList(ransomNote.split(""));
        List<String> magazines = Arrays.asList(magazine.split(""));

        ArrayList<Integer> indexs = new ArrayList<>();
        Boolean res = true;

        label:
        for (String ran : ransomNotes) {
            Boolean isequal = false;
            for (int i = 0; i < magazines.size(); i++) {
                if (ran.equals(magazines.get(i)) && !indexs.contains(i)) {
                    isequal = true;
                    //记录一下当前的元素位置
                    indexs.add(i);
                    continue label;
                }
            }
            res = res && isequal;
        }
        return res;
    }


    /**
     * 解析： 这个解法主要就是利用str.indexOf(c,n) 返回str中字符c在位置n之后出现的下标位置，没有则返回-1 根据如此我建立一个字母表数组  记录循环中最后一个字母出现的位置，
     *        如果全部循环完成，则说明magazine中的字符是完全符合ransomNote的字符需求的。
     *        利用循环和ransomNote.charAt(i) 方法 获取ransomNote中的每个字符，然后使用 c-'a' 换算成0-25下标位置并找出对应chars[c-'a']中当前字母最后一次出现的下标(此处应该是重新遍历的起始位置  因为它将index+1了，而indexOf方法允许从n开始)，然后向后寻找对应字符出现的位置，并将（index+1=下次重新遍历的起始位置）更新在chars[]中。
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct_minTime(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] chars = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int index = magazine.indexOf(c, chars[c - 'a']);
            if (index == -1) {
                return false;
            }
            chars[c - 'a'] = index + 1;
        }
        return true;
    }

}
