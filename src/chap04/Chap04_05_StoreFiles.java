package chap04;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yaodh on 2015/1/14.
 */
public class Chap04_05_StoreFiles {
    class File {
        int length;
        double probability;

        File(int len, double p) {
            this.length = len;
            this.probability = p;
        }
    }

    double expectation(File[] files) {
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                if (f1.probability / f1.length > f2.probability / f2.length) {
                    return 1;
                }
                return -1;
            }
        });
        double exp = 0.0;
        int total = 0;
        for (int i = 1; i < files.length; i++) {
            total += files[i - 1].length;
            exp += total * files[i].probability;
        }
        return exp;
    }
}
