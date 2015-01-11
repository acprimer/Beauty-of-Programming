package chap03;

/**
 * Created by yaodh on 2015/1/10.
 */
public class Chap03_11_DebugCode {
    /**
     * 二分查找，返回相等的任意下标
     *
     * @param A      按照升序排列的有序数组
     * @param target 要查找的目标值
     * @return 返回任意一个下标i, st. A[i]=target。不存在返回-1。
     */
    int bsearch(int[] A, int target) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找，返回相等的最小下标
     *
     * @param A      按照升序排列的有序数组
     * @param target 要查找的目标值
     * @return 返回最小下标i, st. A[i]=target。不存在返回-1。
     */
    int bsearch2(int[] A, int target) {
        int left = -1, right = A.length;
        while (right - left > 1) {
            int mid = (left + right) >>> 1;
            if (A[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (A[right] == target) {
            return right;
        }
        return -1;
    }

    /**
     * 二分查找，返回相等的最大下标
     *
     * @param A      按照升序排列的有序数组
     * @param target 要查找的目标值
     * @return 返回最大下标i, st. A[i]=target。不存在返回-1。
     */
    int bsearch3(int[] A, int target) {
        int left = -1, right = A.length;
        while (right - left > 1) {
            int mid = (left + right) >>> 1;
            if (A[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A[left] == target) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = new int[]{};
        System.out.println(new Chap03_11_DebugCode().bsearch2(A, 4));
        System.out.println(new Chap03_11_DebugCode().bsearch3(A, 4));
    }
}
