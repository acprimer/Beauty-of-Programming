package chap02;

import java.math.BigInteger;

/**
 * Created by yaodh on 2014/12/24.
 */
public class Chap02_07_GCD {
    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }

    public int gcd2(int x, int y) {
        while(y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }

    public BigInteger gcd(BigInteger x, BigInteger y) {
        if (x.compareTo(y) < 0) {
            return gcd(y, x);
        }
        if (y.equals(BigInteger.ZERO)) {
            return x;
        }

        if (isEven(x)) {
            if (isEven(y)) { // x is even, y is even
                return gcd(x.shiftRight(1), y.shiftRight(1)).shiftLeft(1);
            } else { // x is even, y is odd
                return gcd(x.shiftRight(1), y);
            }
        } else {
            if (isEven(y)) { // x is odd, y is even
                return gcd(x, y.shiftRight(1));
            } else { // x is odd, y is odd
                return gcd(y, x.subtract(y));
            }
        }
    }

    public boolean isEven(BigInteger x) {
        return !x.testBit(0);
    }

    public static void main(String[] args) {
        BigInteger ans = new Chap02_07_GCD().gcd(BigInteger.valueOf(120), BigInteger.valueOf(42));
        System.out.println(ans);
    }
}
