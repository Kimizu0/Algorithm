package recursion.interview0806;

import java.util.List;

/**
 * 面试题 汉诺塔问题
 *
 * @author WanJie
 * @describe
 * @since 2022/10/8 15:37
 */
public class Recursion {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(n, A, B, C);
    }

    private void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(0, A.remove(0));
            return;
        }
        // 把n-1个盘子从A -> B
        move(n - 1, A, C, B);
        // 把第n个盘子(最大的盘子)从A -> C
        C.add(0, A.remove(0));
        // 把n-1个盘子从B -> C
        move(n - 1, B, A, C);
    }
}
