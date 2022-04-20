import java.time.Duration;
import java.time.Instant;

public class Hello {
    public static void main(String[] args) {
//        drawTriangle(10);
//        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
//        System.out.println(max(numbers));
        long start = System.nanoTime();
        windowPosSum(new int[]{1, 2, -3, 4, 5, 4}, 3);
        windowPosSum(new int[]{1, -1, -1, 10, 5, -1}, 2);
        long end = System.nanoTime();
        System.out.println((end - start) / 1e6);
    }

    public static void drawTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public static int max(int[] m) {
        int max = m[0];
        for (int i : m) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static void windowPosSum(int[] a, int n) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                continue;
            }
            for (int j = i + 1; j <= i + n; j++) {
                if (j >= a.length) {
                    break;
                }
                a[i] += a[j];
            }
        }

        System.out.println(java.util.Arrays.toString(a));
    }
}
