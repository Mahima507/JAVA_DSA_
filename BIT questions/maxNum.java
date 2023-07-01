public class maxNum {
    static int help(int n) {
        int cnt = 0;
        for (int x = 0; x <= n; x++) {
            int res = n & x;
            if (res == x) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(help(5));
    }
}
