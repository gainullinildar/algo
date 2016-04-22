/**
 * Created by ildar on 22.04.16.
 */
public class CHTOFFLINE {
    int MAXN = 100000;
    long a[] = new long[MAXN];
    long b[] = new long[MAXN];
    int h;
    int ptr = 0;
    long query(long x) {
        if (h > 0) {
            ptr = Math.min(ptr, h - 1);
        }
        while (ptr + 1 < h && a[ptr + 1] * x + b[ptr + 1] <= a[ptr] * x + b[ptr]) {
            ptr++;
        }
        return a[ptr] * x + b[ptr];
    }
    void add_line(int k, int bi) {
        while (h > 1) {
            if ((double) (b[h - 2] - b[h - 1]) * (k - a[h - 1]) < (double) (b[h - 1] - bi) * (a[h - 1] - a[h - 2])) {
                break;
            } else {
                h--;
            }
        }
        a[h] = k;
        b[h] = bi;
        h++;
    }
}
