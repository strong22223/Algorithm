package LearningJava;

import java.lang.reflect.Array;

public class CopyArray {
    protected int Protest;
    protected void Protesttest(){}
    public static Object goodCopy(Object object, int newLength) {
        Class<?> aClass = object.getClass();
        //如果 object 不是一个数组的话直接返回
        if (!aClass.isArray()) return object;
        Class<?> componentType = aClass.getComponentType();
        int length = Array.getLength(object);

        Object newArray = Array.newInstance(componentType, newLength);

        System.arraycopy(object, 0, newArray, 0, Math.min(length, newLength));
        return newArray;

    }
}
