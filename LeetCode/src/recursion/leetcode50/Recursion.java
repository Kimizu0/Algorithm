package recursion.leetcode50;

/** Pow(x, n
 *
 * @author WanJie
 * @describe https://leetcode.cn/problems/powx-n/solution/powx-n-by-leetcode-solution/
 * 时间复杂度：O(logn)
 * 空间复杂度：O(logn)
 * @since 2022/10/10 22:51
 */
public class Recursion {

    public double myPow(double x, int n) {
        // 只考虑自然数情况，负数取倒数
        return n > 0 ? computed(x, n) : 1.0d / computed(x, n);
    }

    private double computed(double x, int n) {
        if (n == 0) {
            return 1.0d;
        }

        // 每次计算其平方
        double y = computed(x, n / 2);
        // 如果指数为偶数，则计算 y * y
        // 奇数，则还要乘以自身
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
