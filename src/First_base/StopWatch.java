package First_base;

/**
 * 该类返回返回执行时间
 */
public class StopWatch {
    private final Long start;

    public StopWatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return now - start;
    }
}
