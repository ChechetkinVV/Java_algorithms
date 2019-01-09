import java.util.HashMap;
import java.util.Map;

public class DP {
    public static long strong (int i, int k){
        long [] dp = new long [Math.max(i,k)+1];
        dp[1] = 1;
        for (int j = 1; j <= k; j++) {
            for (int l = 0; l < j; l++) {
                dp[j] +=dp[l];
            }
        }
        for (int j = k+1; j <= i; j++) {
            for (int l = 1; l <= k; l++) {
                dp[j] += dp[j-l];

            }
        }
        return dp[i];
    }

    static int fib1Counter = 0;
    static int fib2Counter = 0;
    public static long fib1 (int i){
        fib1Counter++;
        if (i <= 2){
            return 1;
        }
        return fib1(i-1) + fib1 (i-2);
    }
    public static Map<Integer, Long> solved = new HashMap<>();
    public static long fib2 (int i){
        fib2Counter++;
        if (i <= 2){
            return 1;
        }
        if (solved.containsKey(i)){
            return solved.get(i);
        }
        long ans = fib2(i-1) + fib2(i-2);
        solved.put(i,ans);
        return ans;
    }
    public static long fib3 (int i){
        long [] dp = new long[i+1];
        dp[1] = 1;
        dp[2] = 1;
        for (int j = 3; j <= i; j++) {
            dp[j] = dp[j-1] + dp [j-2];
        }
        return dp[i];
    }

    public static void main(String[] args) {
        System.out.println(fib1(25)+"  "+fib1Counter);
        System.out.println(fib2(25)+"  "+fib2Counter);
        System.out.println(fib3(25));

        System.out.println(strong(6,2));


    }
}
