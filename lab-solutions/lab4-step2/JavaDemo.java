public class JavaDemo {

    public static void main(String... args) {
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            Integer num = Integer.parseInt(args[1]);
            sum+= num;
        }
        System.out.println(sum);
    }
}
