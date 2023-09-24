package LearningJava.GenericClass;

import LearningJava.ReflectionTest;

import java.time.LocalDate;

public class DateInterval extends Pair<LocalDate> {
    @Override
    public void setSecond(LocalDate second) {
        if (second.compareTo(getFirst())>=0)
            super.setSecond(second);
    }

    public static void main(String[] args) {
         ReflectionTest.printMethods(DateInterval.class);
    }
}
