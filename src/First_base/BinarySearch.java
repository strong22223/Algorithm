package First_base;

public class BinarySearch {

    /**
     * 接受所有数据类型的数组，并且在arrays 中查找key，找到返回数组下标
     * return -1：代表未找到
     * return >=0的时间表示返回数组的下标
     *
     * @param key
     * @param arrays
     * @return
     */
    public static int rank(Object key, Object arrays) throws ClassNotFoundException {
//        Class<?> aClass = arrays.getClass();
//        if (!aClass.isArray()) return -1;
//
//        Class<?> componentType = aClass.getComponentType();
//        int length = Array.getLength(arrays);
//
////        Class<?> aClass1 = Class.forName(componentType.getName());
////        Object target = Array.newInstance(componentType, length);
////        System.arraycopy(arrays, 0, target, 0, length);
//
//        int left = 0;
//        int right = length - 1;
//        int mid = left + (right - left) / 2;
//        while (left <= right) {
//            Object midNumber = Array.get(arrays, mid);
//            if (key == midNumber) return mid;
//            else (key<=midNumber)
//
//
//        }
        return -1;
    }

    /**
     * 找到的时间返回数组的下标，未找到的时间返回 -1 表示失败
     *
     * @param key
     * @param arrays
     * @return
     */
    public static int rank(int key, int[] arrays) {
        int length = arrays.length;
        int left = 0;
        int right = length - 1;
        int mid = left + (right - left) / 2;

        while (left <= right) {
            int midNumber = arrays[mid];
            if (key == midNumber) return mid;
            else if (key < midNumber) right = mid - 1;
            else left = mid + 1;
            mid = left + (right - left) / 2;
        }
        return -1;//未找到 返回 -1
    }

}
