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
 *
 *  7. Java 中 ++ 操作符是线程安全的吗
 *     不是，个指令，如读取变量值，增加，然后存储回内存，这个过程可能会出现多个线程交差
 *
 *  8。 a = a + b 与 a += b 的区别
 *      += 隐式的将加操作的结果类型强制转换为持有结果的类型。如果两这个整型相加，如 byte、short 或者 int，
 *      首先会将它们提升到 int 类型，然后在执行加法操作。
 *
 *  9. 我能在不进行强制转换的情况下将一个 double 值赋值给 long 类型的变量吗?
 *      不能，因为 double 类型的范围比 long 类型更广，所以必须要进行强制转换
 *
 *  10。 3*0.1 == 0.3 将会返回什么? true 还是 false
 *      false，因为有些浮点数不能完全精确的表示出来
 *
 *  11. 有没有可能两个不相等的对象有有相同的 hashcode?
 *       有可能，两个不相等的对象可能会有相同的 hashcode 值，这就是为什么在 hashmap 中会有冲突。
 *       相等 hashcode 值的规定只是说如果两个对象相等，必须有相同的hashcode 值，但是没有关于不相等对象的任何规定。
 *
 * 12. 为什么在重写 equals 方法的时候需要重写 hashCode 方法?
 *      因为有强制的规范指定需要同时重写 hashcode 与 equal 是方法，许多容器类，
 *      如 HashMap、HashSet 都依赖于 hashcode 与 equals 的规定
 *      根据 Java 规范，两个使用 equal() 方法来判断相等的对象，必须具有相同的 hash code。
 *
 *  13. “a==b”和”a.equals(b)”有什么区别?
 *      如果 a 和 b 都是对象，则 a==b 是比较两个对象的引用，只有当 a 和 b 指向的是堆中的同一个对象才会返回 true，
 *      而 a.equals(b) 是进行逻辑比较，所以通常需要重写该方法来提供逻辑一致性的比较
 *
 *  14. 为什么需要多线程?
 *      CPU、内存、I/O 设备的速度是有极大差异的，为了合理利用 CPU 的高性能，平衡这三者的速度差异
 *      ，计算机体系结构、操作系统、编译程序都做出了贡献，主要体现为:
 *      a.  CPU 增加了缓存，以均衡与内存的速度差异；// cpu缓存导致 可见性问题 - 一个线程对共享变量的修改，另外一个线程能够立刻看到
 *      b. 操作系统增加了进程、线程，以分时复用 CPU，进而均衡 CPU 与 I/O 设备的速度差异；// 导致 原子性问题
 *      c. 编译程序优化指令执行次序，使得缓存能够得到更加合理地利用。// 导致 有序性问题
 *
 *  15. 类的生命周期
 *       其中类加载的过程包括了加载、验证、准备、解析、初始化五个阶段。在这五个阶段中，加载、验证、准备和初始化这四个阶段发生的顺序是确定的，
 *       而解析阶段则不一定，它在某些情况下可以在初始化阶段之后开始，这是为了支持Java语言的运行时绑定(也成为动态绑定或晚期绑定)
 *       注：这里的几个阶段是按顺序开始，而不是按顺序进行或完成，因为这些阶段通常都是互相交叉地混合进行的，
 *       通常在一个阶段执行的过程中调用或激活另一个阶段。
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
        Animal a = new Animal();
        Animal b = new Dog();
        Dog d = new Dog();

        byte b1 = 1;
        byte b2 = 22;
        //b1 = b1 + b2;//error,因为 a+b 操作会将 a、b 提升为 int 类型，所以将 int 类型赋值给 byte 就会编译出错
        b1 += b2;//+= 隐式的将加操作的结果类型强制转换为持有结果的类型

    }

    public Class<?> loadClass(String name)throws ClassNotFoundException {
        return loadClass(name, false);
    }

    //双亲委托模式加载类 1。 系统类防止内存中出现多份同样的字节码； 2。保证Java程序安全稳定运行
    protected synchronized Class<?> loadClass(String name, boolean resolve)throws ClassNotFoundException {
        // 首先判断该类型是否已经被加载
        Class c = null;//findLoadedClass(name);
//        if (c == null) {
//            //如果没有被加载，就委托给父类加载或者委派给启动类加载器加载
//            try {
//                if (parent != null) {
//                    //如果存在父类加载器，就委派给父类加载器加载
//                    c = parent.loadClass(name, false);
//                } else {
//                    //如果不存在父类加载器，就检查是否是由启动类加载器加载的类，通过调用本地方法native Class findBootstrapClass(String name)
//                    c = findBootstrapClass0(name);
//                }
//            } catch (ClassNotFoundException e) {
//                // 如果父类加载器和启动类加载器都不能完成加载任务，才调用自身的加载功能
//                c = findClass(name);
//            }
//        }
//        if (resolve) {
//            resolveClass(c);
//        }
        return c;
    }

}

class Animal{

}

class Dog extends Animal{

}