package LearningJava;

import java.util.Comparator;

/**
 * 使用长度比较器来对需要的
 */
public class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
