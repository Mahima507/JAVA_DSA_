class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length, ans = 0;

        for (int i = 0; i < n; i++) {

            ans += mat[i][i];

            if (i != n - i - 1)
                ans += mat[i][n - i - 1];
        }
        return ans;
    }
}
