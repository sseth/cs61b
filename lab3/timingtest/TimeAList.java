package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        final int N = 7;
        AList<Integer> ns = new AList<>();
        AList<Double> times = new AList<>();

        ns.addLast(1000);
        for (int i = 1; i <= N; i++) {
            ns.addLast((int) Math.pow(2, i) * ns.get(0));
        }

        for (int i = 0; i < ns.size(); i++) {
            AList<Integer> test = new AList<>();
            Stopwatch s = new Stopwatch();
            for (int j = 0; j < ns.get(i); j++) {
                test.addLast(1);
            }
            times.addLast(s.elapsedTime());
            // System.out.println("Done: " + ns.get(i));
        }

        printTimingTable(ns, times, ns);
    }
}
