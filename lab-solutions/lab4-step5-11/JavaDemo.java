public class JavaDemo {

    public static void main(String... args) {
        System.out.println(sum(args));
        System.out.print(MathUtils.sumOddNumbersLessThanTen(args));
    }

    @Deprecated(forRemoval=true)
    public static long sum(String[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer num = Integer.parseInt(nums[1]);
            sum+= num;
        }
        return sum;
    }
}
