package LearningJava;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    /**
     * 当前方法采用递归调用的形式来将 obj 的数组类型的 字段输出
     *
     * @param obj
     * @return
     */
    public String
    toString(Object obj) throws IllegalAccessException {
//        1.首先非空判断
        if (obj == null) return null;
//        2.其次判断当前是否已经存在于 visited 中
        if (visited.contains(obj)) return "...";
//        3.首先判断obj的数据类型，如果是String 类的话直接返回当前类
        Class<?> objClass = obj.getClass();

        if (String.class == objClass) return (String) obj;
//        4.开始获取当前累的数据类型，判断当前类是否我数组
        if (objClass.isArray()) {
            //1.首先获得数组的名称
            StringBuilder arrayName = new StringBuilder(objClass.getComponentType() + "[]{ ");

            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) arrayName.append(",");
                Object o = Array.get(obj, i);
                if (objClass.getComponentType().isPrimitive()) arrayName.append(o);
                else this.toString(o);
            }
            return arrayName + "}";
        }


        String name = objClass.getName();
        do {
            name += "[";
            Field[] declaredField = objClass.getDeclaredFields();
            for (Field a :
                    declaredField) {
                if (!Modifier.isStatic(a.getModifiers())) {
                    if (!name.endsWith("[")) name += ",";
                    name += a.getName() + "=";
                    Class<?> t = a.getType();
                    Object val = a.get(obj);
                    if (t.isPrimitive()) name += val;
                    else name += toString(val);
                }
            }
            name += "]";
            objClass = objClass.getSuperclass();
        }
        while (objClass != null);
        return name;

    }
}
