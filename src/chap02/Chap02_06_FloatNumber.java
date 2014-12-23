package chap02;

/**
 * Created by yaodh on 2014/12/23.
 */
public class Chap02_06_FloatNumber {
    public int[] floatNubmer(String number) {
        int[] fraction = new int[2];
        int pre = 0, cycle = 0;
        int powerPre =1, powerCycle=1;
        boolean flag = false;
        for(int i=2;i<number.length() && number.charAt(i)!=')';i++) {
            if(number.charAt(i)=='(') {
                flag = true;
                continue;
            }
            if(flag) {
                cycle = cycle * 10 + number.charAt(i)-'0';
                powerCycle*=10;
            } else {
                pre = pre * 10 + number.charAt(i) - '0';
                powerPre*=10;
            }
        }
        if(flag) {
            fraction[0] = pre * (powerCycle - 1) + cycle;
            fraction[1] = powerPre * (powerCycle - 1);
        } else {
            fraction[0] = pre;
            fraction[1] = powerPre;
        }
        int d = gcd(fraction[0], fraction[1]);
        fraction[0] /= d;
        fraction[1] /= d;
        return fraction;
    }

    private int gcd(int a, int b) {
        if(a==0) return b;
        return gcd(b%a, a);
    }

    public static void main(String[] args) {
        int[] ans = new Chap02_06_FloatNumber().floatNubmer("0.1(2)");
        System.out.printf(ans[0] + "/" + ans[1]);
    }
}
