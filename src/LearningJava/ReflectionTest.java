package LearningJava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Calendar;
import java.util.Deque;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
//        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
//
//        Class<?> aClass = Class.forName(name);
//        Class<?> superclass = aClass.getSuperclass();
//        String modifier = Modifier.toString(aClass.getModifiers());
//
//        if (modifier.length() > 0) System.out.println(modifier);
//        System.out.println("class " + name);
//
//        if (superclass != null && superclass != Object.class) System.out.println("extend " + superclass.getName());
//
//        ReflectionTest.printConstructors(aClass);
//        ReflectionTest.printFields(aClass);

//        Evaluate evaluate = new Evaluate();
//        Class<? extends Evaluate> aClass = evaluate.getClass();
//
//        Field declaredFields = aClass.getDeclaredField("test");
//        declaredFields.setAccessible(true);
//        Object o = declaredFields.get(evaluate);
//        declaredFields.set(evaluate, 99);
        Class<?> aClass = Class.forName("LearningJava.TalkingClock$TimePrinter");
        printFields(aClass);
        printConstructors(aClass);
        Class<?> bClass = Class.forName("LearningJava.TalkingClock");
        printFields(bClass);
        printConstructors(bClass);
    }

    public static void printConstructors(Class cl) {
        Constructor[] declaredConstructors = cl.getDeclaredConstructors();
        for (Constructor co : declaredConstructors) {

            String type = Modifier.toString(co.getModifiers());
            String name = co.getName();

            System.out.print(type + " " + name + "(");
            //print parameter Type
            Class[] parameterTypes = co.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {

                System.out.print(parameterTypes[i].getName());
                if (parameterTypes.length > 1) System.out.print(",");
            }
            System.out.println(");");

        }
    }

    public static void printFields(Class cl) {
        Field[] declaredFields = cl.getDeclaredFields();
        for (Field fields : declaredFields) {
            String modifier = Modifier.toString(fields.getModifiers());
            String dateType = fields.getType().getName();
            String fieldName = fields.getName();
            System.out.println(modifier + " " + dateType + " " + fieldName);

        }
    }
    public static void printMethods(Class cl){
        Method[] declaredMethod = cl.getDeclaredMethods();
        for (Method method: declaredMethod){
            String typeName = Modifier.toString(method.getModifiers());
            Class<?> returnType = method.getReturnType();
            String returnTypeName = returnType.getName();
        }

    }
}
