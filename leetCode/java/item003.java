import java.util.ArrayList;
import java.util.List;

public class item003 {

    public List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<>();
        for (Integer i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                list.add("Fizz");
            }
            else if (i % 3 != 0 && i % 5 == 0) {
                list.add("Buzz");
            }
            else if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            }
            else {
                list.add(i.toString());
            }
        }
        return list;
    }

}
