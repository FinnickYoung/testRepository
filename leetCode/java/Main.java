public class Main {

    public static void main(String[] args) throws Exception {


        item004 item = new item004();

        long  startTime  = System.currentTimeMillis();
        System.out.println(item.numberOfSteps(123));
        long  endTime  = System.currentTimeMillis();
        System.out.println(endTime - startTime);

    }

}
