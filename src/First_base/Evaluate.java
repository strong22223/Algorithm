package First_base;

import TheBaseDateType.Stack;

public class Evaluate extends Counter {

    private int test;

    String testString;



    public static double calculateStringExpression(String expression) {
        //1.首先获取两个栈队的数据结构
        Stack<Double> numbers = new Stack<>();
        Stack<String> ops = new Stack<>();

        //2.将输入的字符串 转换为所对应的 计算符号和数字
//        Scanner in = new Scanner(System.in);
//        String words = in.nextLine();
//        String[] s = words.split(" ");
        String[] expressions = expression.split(" ");
        double a = 0;
        for (String word : expressions) {

            if (word.matches("-?\\d+(\\.\\d+)?")) {
                numbers.push(Double.parseDouble(word));// 匹配整数或小数
            } else {
                switch (word) {
                    case "(" -> {
                    }
                    case "+", "-", "*", "/" -> ops.push(word);
                    case ")" -> {
                        String pop = ops.pop();
                        switch (pop) {
                            case "+" -> a = numbers.pop() + numbers.pop();
                            case "-" -> a = -(numbers.pop() - numbers.pop());
                            case "*" -> a = numbers.pop() * numbers.pop();
                            case "/" -> a = 1 / (numbers.pop() / numbers.pop());
                        }
                        numbers.push(a);
                    }


                }
            }

        }
        return numbers.pop();

    }

    void kk() {
    }

//    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        double v = Evaluate.calculateStringExpression("( 1 + ( ( 2 + 32 ) * ( 4 * 9 ) ) )");
//        Class<?> aClass = Class.forName("First_base.Evaluate");
//        System.out.println(aClass);
//        Class<Evaluate> evaluateClass = Evaluate.class;
//        Evaluate evaluate = evaluateClass.getConstructor().newInstance();
//        evaluate.kk();
//
//    }
}


