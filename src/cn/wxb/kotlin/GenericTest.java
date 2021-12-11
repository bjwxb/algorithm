package cn.wxb.kotlin;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型相关
 *  1. Java中的泛型是什么 ? 使用泛型的好处是什么?
 *      提供了编译期的类型安全，确保你只能把正确类型的对象放入集合中，避免了在运行时出现ClassCastException
 *      a. 保证了类型的安全性：泛型在编译器约束了变量的类型，保证了类型的安全性，如List的使用
 *      b. 避免了类型的强制转换
 *      c. 提高方法的复用性
 *      d. 避免了不必要的装箱、拆箱操作，提高程序的性能：泛型变量固定了类型，使用的时候就已经知道是值类型还是引用类型，
 *                 避免了不必要的装箱、拆箱操作
 *
 *  2. Java的泛型是如何工作的 ? 什么是类型擦除 ?
 *      泛型是通过类型擦除来实现的，编译器在编译时擦除了所有类型相关的信息，所以在运行时不存在任何类型相关的信息
 *
 *  3.  List<? extends T>和List <? super T>之间有什么区别 ?
 *      List<? extends T>可以接受任何继承自T的类型的List，而List<? super T>可以接受任何T的父类构成的List。
 *      例如List<? extends Number>可以接受List<Integer>或List<Float>
 *
 *  4. 你可以把List<String>传递给一个接受List<Object>参数的方法吗？
 *      不可以，会导致编译错误，因为List<Object>可以存储任何类型的对象包括String, Integer等等，而List<String>却只能用来存储String
 *
 *  5。 Array中可以用泛型吗?
 *      不可以，所以List可以提供编译期的类型安全保证，而Array却不能
 *
 *
 *  6. Java 的上界通配符和下界通配符符合 PECS 原则
 *      PECS 原则即 Producer Extends，Consumer Super 。如果参数化类型是一个生产者，则使用 <? extends T>；
 *      如果它是一个消费者，则使用 <? super T>
 *      其中，生产者表示频繁往外读取数据 T，而不从中添加数据。消费者表示只往里插入数据 T，而不读取数据
 */
public class GenericTest {

    public static void main(String[] args) {

        //如果 A 是 B 的子类型，并且Generic<A> 也是 Generic<B> 的子类型，那么 Generic<T> 可以称之为一个协变类。
        List<Animal> animals = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();
//        animals = dogs;// error
//        dogs = animals;// error

        //Java 的协变通过上界通配符实现， kotlin中的List使用来out，即List<out E>,
        List<? extends Animal> l3 = new ArrayList<>();
        //List<Dog>是List<? extends Animal>的子类型
        l3 = dogs;
//        dogs = l3;//error
        //l3.add(new Dog());//error, 因为是协变的，无法添加新的对象


        //Java 的逆变通过下界通配符实现
        List<? super Animal> l4 = new ArrayList<>();
        //l4 = dogs;//error,
        //? super Animal 表示 Animal 及其父类 。所以 l4 可以接收所有 Animal 的子类添加至该列表中。
        l4.add(new Dog());

    }
}

class Animal{

}

class Dog extends Animal{

}