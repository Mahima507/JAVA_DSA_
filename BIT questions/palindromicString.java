class palindromicString {
    static int INT_MAX = 2147483647;

    static int isKthBitSet(int x, int k) {
        return ((x & (1 << (k - 1))) > 0) ? 1 : 0;
    }

    // Returns the position of
    // leftmost set bit in the
    // binary representation
    static int leftmostSetBit(int x) {
        int count = 0;
        while (x > 0) {
            count++;
            x = x >> 1;
        }
        return count;
    }

    // Finds whether the integer
    // in binary representation is
    // palindrome or not
    static int isBinPalindrome(int x) {
        int l = leftmostSetBit(x);
        int r = 1;

        // One by one compare bits
        while (l > r) {

            // Compare left and right
            // bits and converge
            if (isKthBitSet(x, l) != isKthBitSet(x, r))
                return 0;
            l--;
            r++;
        }
        return 1;
    }

    static int findNthPalindrome(int n) {
        int pal_count = 0;

        // Start from 1, traverse
        // through all the integers
        int i = 0;
        for (i = 1; i <= INT_MAX; i++) {
            if (isBinPalindrome(i) > 0) {
                pal_count++;
            }

            // If we reach n,
            // break the loop
            if (pal_count == n)
                break;
        }

        return i;
    }

    // Driver code
    public static void main(String[] args) {
        int n = 9;

        // Function Call
        System.out.println(findNthPalindrome(n));
    }
}