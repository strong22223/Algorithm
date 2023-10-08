# java 21 学

# 泛型编程

1. 泛型转换方法

   在类型擦除的过程中, 遇到子类继承父类的过程中户遇到多态的问题, 例如 没有被类型限定的 Pair 类中会被擦除为 Object 类.

   ```java
   public void setSecond(Object obj)
   ```

   但是继承他的Sub类 在类型限定的时间hi生产出方法,来解决 多态的问题

   ```java
   public void setSecond( 限定类 obj)
   
   public void setSecond(Object obj)//这个是合成的 桥方法,在调用Sub 类的实例的setSecond方法的时间,会直接去调用他的 **新生成的桥方法**,因为多态的问题必须又相同额参数列表和方法名.
   {
   	setSecond( (限定类) obj);//调用子类生成的 限定类参数的方法
   }
   
   ```


2. 泛型类型的继承规则
   1. Pair <Sub> 不是 Pair<Father> 的子类, 并且Pair <Father > 不能接受 Pair <Sub> 的对象. 
   2. 对于数组而言 
      ```java
      Father[] father =new Sub[N];
      //利用father 插入一个 Sub 对象的时间, 会弹出一个 ArrayStoreEXveption 异常
      ```
3. 通配符类型
   1. Pair< ? extend Father> 是 Pair<Sub> 的父类,前者可以接收 后者的对象, 但是不能够通过前者的引用来 修改后者的数值
   ```java
   //具体我们来看一下 Pair 的代码
    ```
   2.直观地来讲 ? super Class 允许你接受一个泛型对象, 带有? extend Class 允许你 读去一个泛型对象.