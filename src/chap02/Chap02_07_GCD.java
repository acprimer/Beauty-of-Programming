package chap02;

import java.math.BigInteger;

/**
 * Created by yaodh on 2014/12/24.
 */
public class Chap02_07_GCD {
    public static final BigInteger BIG_TWO = BigInteger.valueOf(2);
    public int gcd(int x, int y) {
        if(y==0) {
            return x;
        }
        return gcd(y, x%y);
    }

    public BigInteger gcd(BigInteger x, BigInteger y) {
        if(x.compareTo(y) < 0) {
            return gcd(y,x);
        }
        if(y.equals(BigInteger.ZERO)) {
            return x;
        }

        if(isEven(x)) {
            if(isEven(y)) { // x is even, y is even
                return gcd(x.divide(BIG_TWO), y.divide(BIG_TWO)).multiply(BIG_TWO);
            } else { // x is even, y is odd
                return gcd(x.divide(BIG_TWO), y);
            }
        } else {
            if(isEven(y)) { // x is odd, y is even
                return gcd(x, y.divide(BIG_TWO));
            } else { // x is odd, y is odd
                return gcd(y, x.subtract(y));
            }
        }
    }

    public boolean isEven(BigInteger x) {
        return x.mod(BIG_TWO).equals(BigInteger.ZERO);
    }

    public static void main(String[] args) {
        BigInteger ans = new Chap02_07_GCD().gcd(BigInteger.valueOf(1100100210001L), BigInteger.valueOf(120200021));
        System.out.println(ans);
    }
}
