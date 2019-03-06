import java.util.Arrays;

public class MathUtils {

    @Deprecated
    public static long sumOddNumbersLessThanTen(String[] nums) {
        return Arrays.stream(nums)
                .mapToInt(Integer::parseInt)
                .filter(n -> n < 10)
                .filter(n -> n%2 ==1)
                .sum();
    }
}
