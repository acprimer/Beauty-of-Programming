package chap04;

/**
 * Created by yaodh on 2015/1/18.
 */
public class Chap04_08_TestTriangle {
    byte testTriangle(int A, int B, int C) {
        byte ans = 0;
        if (A > C) {
            int t = A;
            A = C;
            C = t;
        }
        if (B > C) {
            int t = B;
            B = C;
            C = t;
        }
        if (A + B <= C) {
            return ans;
        }
        ans |= (1 << 7);
        long c2 = C * C;
        long ab2 = A * A + B * B;
        if (c2 == ab2) {
            ans |= (1 << 4);
        } else if (c2 < ab2) {
            ans |= (1 << 3);
        } else {
            ans |= (1 << 2);
        }
        int count = 0;
        if (A == B) {
            count++;
        }
        if (A == C) {
            count++;
        }
        if (B == C) {
            count++;
        }
        if (count == 3) {
            ans |= (1 << 1);
        }
        if (count == 1) {
            ans |= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        byte ans = new Chap04_08_TestTriangle().testTriangle(3, 4, 5);
        System.out.printf("%x", ans);
    }
}
