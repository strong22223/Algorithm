package First_base;

import java.util.Scanner;

public class Counter {
    private final String name;
    private int count;

    /**
     * 创建一个名为 id 的计数器
     *
     * @param id
     */
    public Counter(String id) {
        this.name = id;
    }

    public Counter() {
        this.name = "This name is null";
    }

    /**
     * 将计数器加一
     */
    public void increment() {
        count++;
    }

    /**
     * 计数器的值
     *
     * @return
     */
    public int tally() {
        return count;
    }

    /**
     * 对象的字符串表示
     *
     * @return
     */
    public String toString() {
        return count + " " + name;
    }

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println("请输入一个数字，用于表示两个计数器所累加的总和\n");
        int i = in.nextInt();

        Counter head = new Counter("head");
        Counter tails = new Counter("tails");

        for (int t = 0; t < i; t++) {
            if (Math.random() < 0.5)
                head.increment();
            else tails.increment();
        }
        System.out.println(head);
        System.out.println(tails);

        int arguments = head.tally() - tails.tally();
        System.out.println(arguments);

    }

}
