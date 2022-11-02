package dp.lc91;

/**
 * @author WanJie
 * @describe
 * @since 2022/10/14 14:52
 */
public class DP {
    public int numDecodings(String s) {
        // f[i] 考虑前i个数字解码数
        // 三种情况
        // 1.只能单个组合 f[i] = f[i-1]                               1<=a<=9
        // 2.只能和前一个组合成两位 f[i] = f[i-2]                   10<=b<=26
        // 3.既能单个组合又能和前一个组合 f[i] = f[i] + f[i-2]     1<=a<=9, 10<=b<=26

        // 使用前导空格作为哨兵，使得f数组索引从1开始，简化索引判断与省略前导0特殊判断。
        int n = s.length();
        s = " " + s;
        char[] ca = s.toCharArray();
        int[] f = new int[n + 1];
        // 单个组合初始化
        f[0] = 1;

        // 字符计算，'number' - '0' 可得到数值
        char o = '0';
        for (int i = 1; i <= n; i++) {
            // a : 代表「当前位置」单独形成 item
            // b : 代表「当前位置」与「前一位置」共同形成 item

            int a = ca[i] - o;
            int b = (ca[i - 1] - o) * 10 + (ca[i] - o);
            // 情况一
            if (a >= 1 && a <= 9) {
                f[i] = f[i - 1];
            }

            // 情况二/情况三合并，当a b同时满足条件时，进入此if为情况三
            /// 当上一个if不满足时，f[i]=0,f[i]+=f[i-2] => f[i] = 0 + f[i-2]
            if (b >= 10 && b <= 26) {
                // 合并情况二/三
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}
