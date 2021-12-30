package cn.wxb.kotlin;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 1.java有什么特性，继承有什么用处，多态有什么用处
 * 2.反射是什么，在哪里用到，怎么利用反射创建一个对象
 *      反射可以实现在 运行时 可以知道 任意一个类 的属性和方法
 *      T.class/t.getClass()/Class.forName("com.wx.T")
 * 3.代理模式与装饰模式的区别，手写一个静态代理，一个动态代理
 * 4.对象加载的过程，属性先加载还是方法先加载
 *      父类静态成员变量/静态方法块-》子类静态成员变量/静态方法块 -》 父类普通成员变量 -》 父类构造方法
 *      -》子类普通成员变量 -》 子类构造方法
 * 5.垃圾回收机制与jvm结构
 * 6.自定义View,事件分发机制讲一讲
 * 7.http与https有什么区别
 *      http是超文本传输协议，信息是明文传输；https则是具有安全性传输协议的ssl/tls加密传输协议t
 *      http/https连接方式不同，http端口8080，https端口443
 *      http的连接很简单，是无状态的；HTTPS协议是由SSL/TLS+HTTP协议构建的可进行加密传输、身份认证的网络协议，比http协议安全。
 *      https需要CA证书
 *      https优点可以防止数据在传输过程中不被盗窃/篡改/完整性
 *      https缺点 握手阶段比较费时/证书需要花钱/缓存不如http高效
 * 8.Activity启动模式，以及各启动模式生命周期问题
 * 9.静态方法，静态对象为什么不能继承
 * 10.Activity怎么启动Service，Activity与Service交互，Service与Thread的区别
 * 11.介绍一下android动画
 * 12.Launcher启动App的流程，中间有几种跨进程通信(socket)
 * 13.Handler通信，Binder通信
 * 14.你碰到过什么内存泄漏，怎么处理
 * 15.RXJava怎么切换线程
 * 16.Fragment hide show生命周期
 * 17.平常有用到什么锁，synchronized底层原理是什么
 *
 * 1.简单描述下Handler,Handler是怎么切换线程的,Handler同步屏障
 * 2.Glide的缓存，有用过Glide的什么深入的API，自定义model是在Glide的什么阶段
 * 3.讲讲mvc,mvp模式，presenter内存泄漏的问题
 * 4.ANR了解过吗？有没有实际的ANR定位问题的经历
 * 5.性能优化你做过哪些？
 * 6.有什么实际解决UI卡顿优化的经历
 * 7.有做过什么Bitmap优化的实际经验
 * 8.项目搭建过程中有什么经验,有用到什么gradle脚本，分包有做什么操作
 * 9.组件化有详细了解过吗？ARouter详细原理
 * 10.讲一下事件分发机制,RecyclerView是怎么处理内部ViewClick冲突的
 * 11.mainfest中配置LargeHeap，真的能分配到大内存吗？
 *
 * 1.一个大致有序的数组如何排序，最快时间复杂度
 * 2.如果叫你实现，你会怎样实现一个多主题的效果
 * 3.如何自定义实现一个FlexLayout
 * 4.tinker的原理是什么,还用过什么热修复框架，robust的原理是什么？
 * 5.说说你对注解的了解，是怎么解析的
 * 6.synchronized是公平锁还是非公平锁,ReteranLock是公平锁吗？是怎么实现的
 * 7.泛型是怎么解析的，比如在retrofit中的泛型是怎么解析的
 * 8.mvp与mvvm的区别，mvvm怎么更新UI,databinding用得多吗,databinding的原理？
 * 9.kotlin ?的原理
 * 10.在项目中有直接使用tcp,socket来发送消息吗
 *      TCP向上层提供面向连接的可靠服务 ，UDP向上层提供无连接不可靠服务。
 *      虽然 UDP 并没有 TCP 传输来的准确，但是也能在很多实时性要求高的地方有所作为
 *      对数据准确性要求高，速度可以相对较慢的，可以选用TCP
 *
 *      UDP协议全称是用户数据报协议，在网络中它与TCP协议一样用于处理数据包，是一种无连接的协议
 *       a. 面向无连接 - 想发数据就可以开始发送了，并且也只是数据报文的搬运工，不会对数据报文进行任何拆分和拼接操作
 *       b. UDP 不止支持一对一的传输方式，同样支持一对多，多对多，多对一的方式，也就是说 UDP 提供了单播，多播，广播的功能
 *       c. UDP是面向报文的 - 发送方的UDP对应用程序交下来的报文，在添加首部后就向下交付IP层。
 *          UDP对应用层交下来的报文，既不合并，也不拆分，而是保留这些报文的边界。因此，应用程序必须选择合适大小的报文
 *       d. 不可靠性 - 首先不可靠性体现在无连接上，通信都不需要建立连接，想发就发,并且收到什么数据就传递什么数据，并且也不会备份数据，
 *          发送数据也不会关心对方是否已经正确接收到数据了
 *       e. 头部开销小，传输数据报文时是很高效的
 *      Tcp特点：
 *        a. 面向连接 - 发送数据之前必须在两端建立连接。建立连接的方法是“三次握手”，这样能建立可靠的连接
 *        b. 仅支持单播传输 - 只能进行点对点的数据传输
 *        c. 面向字节流 - TCP不像UDP一样那样一个个报文独立地传输，而是在不保留报文边界的情况下以字节流方式进行传输
 *        d. 可靠传输 - 对于可靠传输，判断丢包，误码靠的是TCP的段编号以及确认号
 *        e. 提供拥塞控制 - 当网络出现拥塞的时候，TCP能够减小向网络注入数据的速率和数量，缓解拥塞
 *        f. TCP提供全双工通信 - TCP允许通信双方的应用程序在任何时候都能发送数据，因为TCP连接的两端都设有缓存，用来临时存放双向通信的数据
 * 11.如何在网络框架里直接避免内存泄漏，不需要在presenter中释放订阅
 * 12.生命周期都是通过什么调用的？有用过AIDL吗？
 * 13.讲一下RecyclerView的缓存机制,滑动10个，再滑回去，会有几个执行onBindView
 * 14.如何实现RecyclerView的局部更新，用过payload吗,notifyItemChange方法中的参数？
 * 15.讲讲LinkedHashMap的数据结构
 * 16.put post有什么区别
 * 17.A Activity打开B Activity的生命周期变化，会有什么方法打断吗？
 * 18.Fragment hide show生命周期变化
 * 19.Fragment replace生命周期变化
 *
 * 1.介绍一下你们项目的架构
 * 2.Rxjava是怎么实现线程切换的
 * 3.Rxjava自定义操作符
 * 4.ARouter的原理
 * 5.ARouter怎么实现接口调用
 * 6.ARouter怎么实现页面拦截
 * 7.MVP怎么处理内存泄漏
 *      内存泄漏通常是P在执行耗时任务时，未完成就退出了activity,而P持有activity的引用无法释放，造成内存泄漏
 *      解决方法：
 *          a。baseActivity中在oncreate/onDestroy中创建和释放p中的引用释放掉
 *          b。p实现lifeCycleObserver接口，activity监听
 * 8.OkHttp怎么实现连接池
 *      频繁的进行建立Sokcet连接（TCP三次握手）和断开Socket（TCP四次分手）是非常消耗网络资源和浪费时间的，
 *      HTTP中的keepalive连接对于 降低延迟和提升速度有非常重要的作用
 *      Okhttp支持5个并发KeepAlive，默认链路生命为5分钟(链路空闲后，保持存活的时间)，
 *      连接池有ConectionPool实现，对连接进行回收和管理
 *
 * 9.如果让你来实现一个网络框架，你会考虑什么
 * 10.你做过什么性能优化的工作
 * 11.热修复的原理，资源的热修复的原理,会不会有资源冲突的问题
 * 12.ViewPager中嵌套ViewPager怎么处理滑动冲突
 * 13.android源码中有哪些设计模式
 * 14.说说binder机制的原理
 *      Binder是一种进程间通信机制
 *      android系统通过动态添加一个内核模块运行在内核空间（叫binder驱动），用户进程之间通过这个内核模块作为桥梁来实现通信。
 *      操作系统mmap()是一中内存映射的方法，内存映射简单的讲就是将用户空间的一块内存区域映射到内核空间，
 *      映射关系建立后用户空间/内核空间修改后可以即时反应给对方
 *      内存映射可以减少数据拷贝次数
 * 1.ViewPager2原理
 * 2.LifeCycle的原理是怎样的？
 * 3.ViewModel为什么在旋转屏幕后不会丢失状态
 * 4.Drawable与View有什么区别,Drawable有哪些子类
 * 5.属性动画更新时会回调onDraw吗？
 * 6.OkHttp网络拦截器，应用拦截器?OKHttp有哪些拦截器，分别起什么作用
 * 7.自定义实现一个九宫格如何实现
 * 8.PathClassLoader与DexClassLoader有什么区别
 * 9.这些年有做一些什么比较难的工作？
 * 10.编译时注解与运行时注解，为什么retrofit要使用运行时注解？什么时候用运行时注解？
 * 11.kotlin lazy使用,lazy viewmodel
 * 12.有没有看一下Google官方的ViewModel demo
 * 13.ViewModel在Activity初始化与在Fragment中初始化，有什么区别？
 *      ViewModel 在 Fragment 中不会因配置改变而销毁的原因其实是因为其声明的 ViewModel 是存储在 FragmentManagerViewModel 中的，
 *      而 FragmentManagerViewModel 是存储在宿主 Activity 中的 ViewModelStore 中，
 *      又因 Activity 中 ViewModelStore不会因配置改变而销毁，故 Fragment 中 ViewModel 也不会因配置改变而销毁。
 *
 * 14.kotlin与Java互相调用有什么问题？
 * 15.retrofit怎么做post请求
 * 16.界面优化的一些方法，ConstraintLayout实现三等分,ConstraintLayout动画.
 * 17.CoordinatorLayout自定义behavior,可以拦截什么？
 *
 *
 * 1.你们的项目中做过什么比较难的工作？
 * 2.视频播放,一个player怎么实现预加载，避免loading
 * 2.webView加载本地图片，如何从安全方面考虑
 * 3.http1.0,http1.1,http1.2有什么区别
 * 4.https与http有什么区别
 * 5.有用过什么加密算法？AES,RAS什么原理？
 * 6.android跨进程通信了解吗？共享内存用过吗？binder怎么验证pid?binder驱动了解吗？
 * 7.SharedParence可以跨进程通信吗？如何改造成可以跨进程通信的.commit和apply的区别.
 * 8.Seriazable与Parceable的区别
 * 9.Bundle是什么数据结构?利用什么传递数据
 * 10.Jvm的内存结构，Jvm的垃圾回收，方法区有什么东西？
 * 11.h5与native交互，webView.loadUrl与webView.evaluateUrl区别
 *
 * 1.项目中的Webview与native通信
 * 2.项目中对WebView的功能进行了怎样的增强
 * 3.synchronized跟ReentranLock有什么区别？
 * 4.synchronized与ReentranLock发生异常的场景.
 * 5.算法,删除数组中的重复元素
 * 6.手写双检查单例模式，各个步骤有什么区别
 * 7.Activity生命周期
 *
 * String类为什么具有不可变性？其如何实现不可变性的？
 *      a。将String类修饰为final的，保证其不能被继承，防止由于继承破坏其不可变性
 *      b。将所有成员变量都修饰为private final的，private保证了外部不可修改，final保证了内部也不能修改value指向的引用
 *          String通过在所有方法里都不去主动修改valu中值这个原则来保证String的不可变性
 * 1.string,equals,==有什么区别
 *      a。equals 是方法， == 是操作符
 *      b。基本类型变量只能用 == 比较的是值
 *      c。引用类型变量都是继承Object，默认不重写的话equals和==是一样的，都是比较内存中的引用地址
 *      d. String类重写类equals方法，比较的是值
 * 2.AsyncTask内存泄露
 * 3.dispatchTouchEvent,onInterceptEvent,onTouchEvent顺序，关系
 *    viewGroup的dispatchTouchEvent满足如下两个条件，则继续传递事件:
 *              a. MotionEvent.ACTION_DOWN事件或者mFirstTouchTarget非空也就是有子view在处理事件
 *              b.子view没有做拦截，也就是没有调用ViewParent#requestDisallowInterceptTouchEvent(true)
 * 4.onMeasure,onLayout,onDraw关系
 * 5.算法题，反转数组
 * 6.算法题，链表求和
 * 7.说说你对协程的理解
 *      协程就是切线程；
 *      挂起就是可以自动切回来的切线程
 *      挂起的非阻塞式指的是它能用看起来阻塞的代码写出非阻塞的操作
 *      suspend标记这个方法是耗时的，需要在协程里调用
 *
 *      CoroutineDispatcher 协程运行的线程调度器，有 4种线程模式：
 *          Dispatchers.Default
 *          Dispatchers.IO -
 *          Dispatchers.Main - 主线程
 *          Dispatchers.Unconfined - 没指定，就是在当前线程
 *
 *      Job - 协程构建函数的返回值，可以把 Job 看成协程对象本身
 *          job.start() - 启动协程，除了 lazy 模式，协程都不需要手动启动
 *          job.join() - 等待协程执行完毕
 *          job.cancel() - 取消一个协程
 *          job.cancelAndJoin() - 等待协程执行完毕然后再取消
 *
 *      async 返回的是 Deferred 类型，Deferred 继承自 Job 接口，Job有的它都有，增加了一个方法 await ，
 *      这个方法接收的是 async 闭包中返回的值，async 的特点是不会阻塞当前线程，但会阻塞所在协程，也就是挂起
 *      launch 更多是用来发起一个无需结果的耗时任务，这个工作不需要返回结果。
 *      async 函数则是更进一步，用于异步执行耗时任务，并且需要返回值（如网络请求、数据库读写、文件读写），
 *             在执行完毕通过 await() 函数获取返回值
 *
 * 作者：不思进取的码农
 * 链接：https://www.jianshu.com/p/1dc67a300b6b
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 8.协程怎么取消
 * 9.说说MVP与MVVM的区别
 *
 * 1.算法题，二叉树的最大深度
 * 2.如果android端和IOS端调一个接口，一个通了一个没通，你会如何解决
 * 3.如果android端和IOS端调一个接口，一个比较慢，一个比较快，有什么思路
 * 4.ARouter的原理是什么？如果不用ARouter，你会怎么去解藕。接口？设计接口有什么需要注意的？
 * 5.h5与native交互做过什么工作？
 * 6.登陆功能，登陆成功然后跳转到一个新Activity，中间涉及什么？从事件传递，网络请求,AMS交互角度分析
 * 7.AMS交互调用生命周期是顺序的吗？
 * 8.binder进程间通信可以调用原进程方法吗？
 * 9.mvp与mvvm有什么区别？
 * 10.token放在本地如何保存？如何加密比较好？
 *
 *
 * 1.viewModel的原理，为什么可以在Activity销毁后保存数据
 * 2.mvvm双向数据绑定的原理是怎样的？ViewModel
 * 3.说说你们项目中的难点是怎样的？
 * 4.伪代码实现一个长按事件
 * 5.实现一个下载功能的接口
 *
 * 1.泛型有什么优点？
 *      a。对值类型使用非泛型集合类，在把值类型转换为引用类型，和把引用类型转换为值类型时，需要进行装箱和拆箱操作。
 *          装箱和拆箱的操作很容易实现，但是性能损失较大。假如使用泛型，就可以避免装箱和拆箱操作
 *      b. 泛型的好处是在编译的时候检查类型安全，并且所有的强制转换都是自动和隐式的，提高代码的重用率
 * 2.动态代理有什么作用？
 * 3.拉圾回收的GCRoot是什么？
 *      可达性分析算法：通过一系列的名为“GC Root”的对象作为起点，从这些节点向下搜索，
 *      搜索所走过的路径称为引用链(Reference Chain)，当一个对象到GC Root没有任何引用链相连时，
 *      则该对象不可达，该对象是不可使用的，垃圾收集器将回收其所占的内存
 *
 *      在java语言中，可作为GCRoot的对象包括以下几种：
 *      a. java虚拟机栈(栈帧中的本地变量表)中的引用的对象。
 *      b.方法区中的类静态属性引用的对象。
 *      c.方法区中的常量引用的对象。
 *      d.本地方法栈中JNI本地方法的引用对象。
 *

 * 4.Handler机制了解吗？一个线程有几个Looper？为什么？
 * 5.你了解协程吗？协程有什么作用？可以完全取代rxjava吗？
 *      挂起函数在执行完成之后，协程会重新切回它原先的线程
 *      协程的好处：a。节省cpu，避免系统内核级的线程频繁切换，造成cpu资源浪费，而协程是用户态的线程，用户可以自行控制协程的创建/销毁，
 *                  极大程度避免了系统级线程上下文切换造成的资源浪费
 *                b。节约内存，在 64 位的 Linux 中，一个线程需要分配 8MB 栈内存和 64MB 堆内存，而协程只需要几十KB
 *                c。稳定性，线程间通过内存来共享数据，这样任何一个线程出错时，所有线程都会崩溃
 *                d。开发效率，协程可以将一些耗时的IO操作异步化。
 *
 * 6.你们用的什么消息通信机制
 * 7.你的项目有什么难点？介绍一下？
 * 8.算法题，二叉树最长结点集合
 *
 *
 * 1.说说HashMap的原理
 * 2.说说Java的内存分区
 * 3.讲讲你对垃圾回收机制的了解，老年代有什么算法？
 * 4.说说你对volatile字段有什么用途？
 *      保证可见性和有序性
 *      volatile实现原理？
 *          a。变量的内存可见性是基于内存屏障实现的（LoadLoad,LoadStore,StoreLoad,StoreStore）
 *          b。synchronized靠操作系统内核互斥锁实现的，相当于jvm中的lock和unlock，退出代码块时一定会刷新变量到主内存
 *          c。volatile靠插入内存屏障指令后面指令跑到前边去的
 * 5.说说事件分发机制，怎么写一个不能滑动的ViewPager
 * 6.说说你对类加载机制的了解？DexClassLoader与PathClassLoader的区别
 * 7.说说插件化的原理，资源的插件化id重复如何解决？
 * 8.mvp与mvvm模式的区别是什么？
 * 9.JetPack组件用过哪些？lifeCycle的原理是什么？如果在onStart里面订阅，会回调onCreate吗？
 * 10.单例模式有什么缺点？
 *      优点：提供了对唯一实例的受控访问；避免对共享资源的多重占用
 *      缺点：单例类的职责过重，在一定程度上违背了“单一职责原则”；
 * 11.说说App的启动过程,在ActivityThread的main方法里面做了什么事，什么时候启动第一个Activity？
 * 12.说说你对Handler机制的了解，同步消息，异步消息等
 *      nativePollOnce(ptr, nextPollTimeoutMillis)，这是一个native方法，
 *      实际作用就是通过Native层的MessageQueue阻塞nextPollTimeoutMillis毫秒的时间。
 *      1.如果nextPollTimeoutMillis=-1，一直阻塞不会超时。
 *      2.如果nextPollTimeoutMillis=0，不会阻塞，立即返回
 *      3.如果nextPollTimeoutMillis>0，最长阻塞nextPollTimeoutMillis毫秒(超时)，如果期间有程序唤醒会立即返回。
 * 13.说说你对屏幕刷新机制的了解，双重缓冲，三重缓冲，黄油模型
 * 14.onCreate,onResume,onStart里面，什么地方可以获得宽高
 * 15.为什么view.post可以获得宽高，有看过view.post的源码吗？
 * 16.attachToWindow什么时候调用？
 * 17.DataBinding的原理了解吗？
 *
 *
 * 1.JVM类加载机制了解吗，类什么时候会被加载？类加载的过程具体生命周期是怎样的？
 * 2.Handler内存泄漏的GCRoot是什么？
 *      当直接在activity中声明handler时，由于后面的匿名内部类，使handler持有了activity的引用。
 *       当任务未执行完，即message未被执行完时，message持有了messageQueue的引用。
 *      messageQueue持有了mLooper的引用。
 *      mLooper持有sThreadLocal 的引用。
 *      sThreadLocal 是一个静态变量，无法被回收，最终导致了activity无法被回收，造成了内存泄漏
 *
 * 3.动画里面用到了什么设计模式？
 * 4.OkHttp里面用到了什么设计模式？
 * 5.OkHttp连接池是怎么实现的？里面怎么处理SSL？
 * 6.泛型为什么要擦除？kotlin的泛型了解吗？泛型的pecs原则
 * 7.同步屏障
 * 8.性能优化做过什么工作？
 * 9.RecyclerView的缓存结构是怎样的？缓存的是什么？cachedView会执行onBindView吗?
 * 10.RecyclerView嵌套RecyclerView，NestScrollView嵌套ScrollView滑动冲突
 * 11.ViewGroup在Action_Move时onIntercept返回true，事件怎么传递
 * 12.Launcher启动图标，有几个进程？
 * 13.JMM可见性，原子性，有序性，synchronized 可以保证什么？
 *      a，synchronized修饰在非静态方法上和synchronized(this){} 同步代码块效果是一样的
 *      b，synchronized修饰在静态方法上和 synchronized (SyncTest1.class) {} 同步代码块效果是一样的
 *      c，synchronized修饰在非静态方法表示锁的是当前对象，修饰静态方法表示锁的是类对象(一个类在jvm中只有一个class对象)
 *      d. 另外：volatitle 只能保证可见性和有序性，但不能保证原子性；synchronized/Locked接口/Atomic类型保证原子性和可见性
 *
 * 14.源码中有哪里用到了AtomicInt
 * 15.AQS了解吗？
 * 16.Activity内LinearLayout红色wrap_content,包含View绿色wrap_content,求界面颜色
 * 17.ViewModel的使用中有什么坑？
 * 18.有用DSL,anko写过布局吗？
 * 19.HashMap查找的时间复杂度是多少？
 *     时间复杂度是要区分增删改查的。。主要看查询的时间复杂度
 *     数组的查询时间复杂度是O(n)
 *     链表的查询时间复杂度是O(n)
 *     hashMap的查询时间复杂度  最理想状态(桶中链表长度为1)是O(1),最差是O(n)
 * 20.阿里编程规范不建议使用线程池，为什么？
 *
 *      核心线程 -》 任务队列 》 非核心线程 -》 达到最大线程数时执行拒绝策略
 *      当提交一个任务时，线程池创建一个新线程执行任务，直到当前线程数等于corePoolSize,
 *      即使有其他空闲线程能够执行新来的任务, 也会继续创建线程；
 *      如果当前线程数为corePoolSize，继续提交的任务被保存到阻塞队列中，等待被执行；
 *      如果执行了线程池的prestartAllCoreThreads()方法，线程池会提前创建并启动所有核心线程
 *
 *
 *      1）newFixedThreadPool和newSingleThreadExecutor:
 *         主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至OOM。
 *         因为，创建了一个无界队列LinkedBlockingQueuesize，是一个最大值为Integer.MAX_VALUE的线程阻塞队列，
 *         当添加任务的速度大于线程池处理任务的速度，可能会在队列堆积大量的请求，消耗很大的内存，甚至导致OOM
 *      2）newCachedThreadPool和newScheduledThreadPool:
 *         主要问题是线程数最大数是Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至OOM。
 *         创建的线程池允许的最大线程数是Integer.MAX_VALUE，空闲线程存活时间为0，
 *         当添加任务的速度大于线程池处理任务的速度，可能会创建大量的线程，消耗资源，甚至导致OOM
 *
 * 21.四种线程池原理？
 *      //存放任务的阻塞队列
 *      private final BlockingQueue<Runnable> workQueue;
 *      //worker的集合,用set来存放
 *      private final HashSet<Worker> workers = new HashSet<Worker>();
 *      //历史达到的worker数最大值
 *      private int largestPoolSize;
 *      //当队列满了并且worker的数量达到maxSize的时候,执行具体的拒绝策略
 *      private volatile RejectedExecutionHandler handler;
 *      //超出coreSize的worker的生存时间
 *      private volatile long keepAliveTime;
 *      //常驻worker的数量
 *      private volatile int corePoolSize;
 *      //最大worker的数量,一般当workQueue满了才会用到这个参数
 *      private volatile int maximumPoolSize;
 *      newCachedThreadPool——可缓存线程池
 *      newFixedThreadPool————指定线程数量
 *      newSingleThreadExecutor————单线程的Executor
 *      newScheduleThreadPool——定时线程池
 * 22.了解哪些算法？
 * 23.IdleHandler用过吗？
 *
 * 1.如何封装一个字符串转数字的工具类
 * 2.如何求当前Activity View的深度
 * 3.多进程怎么实现？如果启动一个多进程APP，会有几个进程运行？
 * 4.反射可以反射final修饰的字段吗？
 *      static final修饰字段时，要想通过反射修改字段需要先通过反射去掉final修饰符才能修改成功，否则会报异常错误;
 *      如果final字段值是运行时赋值的，则修改后无论通过何种方式访问获得的都是新值;
 *      基本类型、String类型直接赋值时由于JVM编译优化，编译时期用到字段的地方会直接被字段值替换,
 *      导致通过反射修改字段值后用到字段的地方仍是原值，但通过反射访问获取到的是新值
 *
 *      构造方法赋值：
 *          构造方法赋值在JVM编译期不会优化，运行时决定字段的值，修改后通过反射和其他方式访问到的都是新值。
 *       直接赋值：
 *          基本类型、String类型：JVM编译期会优化成常量，导致修改后的值通过反射可以访问到新值，其他方式访问到的仍是旧值。
 *          对象类型：JVM编译期不会优化，运行时决定字段的值，修改后通过反射和其他方式访问到的都是新值。
 *       间接赋值：
 *          间接赋值在JVM编译期不会优化，运行时决定字段的值，修改后通过反射和其他方式访问到的都是新值。
 * 5.Activity与AppCompactActivity区别，Activity会打包到包里面去吗？
 * 6.如何让两个线程循环交替打印
 * 7.怎么中止一个线程，Thread.Interupt一定有效吗？
 *      a。 使用退出标志终止线程,并使用Java关键字volatile，这个关键字的目的是使exit同步，
 *      也就是说在同一时刻只能由一个线程来修改exit的值.
 *      public class ThreadSafe extends Thread {
 *          public volatile boolean exit = false;
 *               public void run() {
 *               while (!exit){
 *                  //do something
 *              }
 *          }
 *      }
 *
 *      b. interupt方法中断，分阻塞和非阻塞两种情况
 *          public class ThreadSafe extends Thread {
 *              public void run() {
 *                  while (!isInterrupted()){ //非阻塞过程中通过判断中断标志来退出
 *                      try{
 *                            Thread.sleep(5*1000);//阻塞过程捕获中断异常来退出
 *                      }catch(InterruptedException e){
 *                           e.printStackTrace();
 *                           break;//捕获到异常之后，执行break跳出循环。
 *                       }
 *                   }
 *               }
 *          }
 * 8.动画连续调用的原理是什么？
 * 9.做过一些SDK的操作吗？
 * 10.协程可以在Java项目中使用吗？
 * 11.SharedPreference原理？读取xml是在哪个线程?
 * 12.了解APK打包的过程吗？
 * 13.class文件的组成？常量池里面有什么内容？
 * 14.自动装箱发生在什么时候？编译期还是运行期
 *      自动装箱拆箱机制其实是编译器自动完成的替换，装箱阶段自动替换为了 valueOf 方法，拆箱阶段自动替换为了 xxxValue 方法。
 *      对于 Integer 类型的 valueOf 方法参数如果是 -128~127 之间的值会直接返回内部缓存池中已经存在对象的引用，参数是其他范围值则返回新建对象；
 *      而 Double 类型与 Integer 类型一样会调用到 Double 的 valueOf 方法，但是 Double 的区别在于不管传入的参数值是多少都会
 *      new 一个对象来表达该数值（因为在指定范围内浮点型数据个数是不确定的，整型等个数是确定的，所以可以 Cache）。
 *      注意：Integer、Short、Byte、Character、Long 的 valueOf 方法实现类似，而 Double 和 Float 比较特殊，每次返回新包装对象。
 *      对于两边都是包装类型的比较 = = 比较的是引用，equals 比较的是值，
 *      对于两边有一边是表达式（包含算数运算）则 = = 比较的是数值（自动触发拆箱过程），对于包装类型 equals 方法不会进行类型转换
 *
 * 15.bugly日志收集的原理是什么？
 * 16.启动优化做过什么工作？如果首页就要用到的初始化？
 * 17.DataBinding原理
 *
 *
 * 1.插件化的原理是什么？有没有什么非运行时插件化的解决方案？
 * 2.ARouter的原理是怎样的？注解处理器是处理java还是字节码
 * 3.java和字节码有什么区别？
 *      java是源代码
 *      字节码是Java虚拟机的机器语言，是Java编译器编译Java源文件（.java）产生的“目标文件
 * 4.kotlin空安全的原理是什么？
 * 5.性能优化做过什么工作?有用过什么工具？有没有精确测量的工具？
 * 6.kotlinc与javac编译字节码有什么区别？
 * 7.你在团队中是怎样一个角色？
 * 8.你有没有做什么推进项目的工作
 * 9.说说热修复的原理？
 *
 *
 *
 * 字节跳动
 * 1.你们的项目中有什么难点？
 * 2.你们项目的稳定性如何？有做过什么稳定性优化的工作？
 * 3.WebView性能优化做过什么工作？
 * 4.AIDL in out oneWay代表什么意思？
 * 5.线程池了解多少？拒绝策略有几种,为什么有newSingleThread
 *      Android中单线程可用于数据库操作，文件操作，应用批量安装，应用批量删除等不适合并发但可能IO阻塞性的操作
 *       1、缓存线程、进行池化，可实现线程重复利用、避免重复创建和销毁所带来的性能开销。
 *       2、当线程调度任务出现异常时，会重新创建一个线程替代掉发生异常的线程。
 *       3、任务执行按照规定的调度规则执行。线程池通过队列形式来接收任务。再通过空闲线程来逐一取出进行任务调度。即线程池可以控制任务调度的执行顺序。
 *       4、可制定拒绝策略。即任务队列已满时，后来任务的拒绝处理规则。
 *       这些对于singleThreadExecutor来说也是适用的。普通线程和线程池中创建的线程其最大的区别就是有无一个管理者对线程进行管理。
 *
 * 6.跨进程通信了解多少？管道了解吗？
 * 7.协程介绍一下，讲一个协程的scope与context，协程的+号代表什么
 * 8.Handler休眠是怎样的？epoll的原理是什么？如何实现延时消息，如果移除一个延时消息会解除休眠吗？
 * 9.算法斐波那契台阶
 * 10.手写生产者消息者模型
 * 11.IdleHandler应用场景
 *      ActivityThread 就向主线程 MessageQueue 添加了一个 GcIdler，用于在主线程空闲时尝试去执行 GC 操作
 *      我们可以通过向 MessageQueue 添加 IdleHandler 的方式，来实现在 Loop 线程处于空闲状态的时候执行一些优先级不高的任务。
 *      例如，假设我们有个需求是希望当主线程完成界面绘制等事件后再执行一些 UI 操作，那么就可以通过 IdleHandler 来实现，
 *      这可以避免拖慢用户看到首屏页面的速度
 *
 * 字节跳动2面
 * 1.自定义圆角图片
 * 2.自定义LinearLayout，怎么测量子View宽高
 * 3.setFactory和setFactory2有什么区别？
 *      LayoutInflater.Factory2 继承自 LayoutInflater.Factory
 *      factory2.onCreateView多一个参数parent，可以对创建 View 的 Parent 进行控制
 * 4.插件化换肤方案
 * 5.插件化的原理，startActivity hook了哪个方法
 * 6.手势操作ActionCancel后怎么取消
 * 7.怎么优化xml inflate的时间，涉及IO与反射。了解compose吗？
 * 8.算法题：二叉树的每一层最左边节点
 * 9.RecyclerView 缓存结构，RecyclerView预取，RecyclerView局部刷新
 *      当你使用局部刷新时，前后都是同一个 ViewHolder ，如果位置没有变化，就不会执行动画效果
 *      ；而当你不使用局部刷新时，使用的不是同一个 ViewHolder ，不管位置是否变化，都会执行相关动画，
 *      所以你看到的 itemView 会闪烁一下。当我们多次调用 notifyItemChange() 方法时，
 *      也不会多次触发 requestLayout() 和回调 bindViewHolder()
 *
 *      notifyItemChange(position, payload-Object)
 *      通过对payload设置不同的值，在item刷新时可以通过判断payload分别处理不同view控件的刷新
 *
 * 11.setOnTouchListener,onClickeListener和onTouchEvent的关系
 *
 * 12. Thread、Process的区别
 *      a. 一个程序至少有一个进程,一个进程至少有一个线程
 *      b. 线程的划分尺度小于进程，使得多线程程序的并发性高
 *      c. 进程在执行过程中拥有独立的内存单元，而多个线程共享内存，从而极大地提高了程序的运行效率
 *      e. 线程在执行过程中与进程还是有区别的。每个独立的线程有一个程序运行的入口、顺序执行序列和程序的出口。
 *          但是线程不能够独立执行，**必须依存在应用程序中，由应用程序提供多个线程执行控制
 *      f. 多线程的意义在于一个应用程序中，有多个执行部分可以同时执行
 * 13. singleThreadpool什么场景下使用，只有一个线程为什么不直接使用new Thread（）
 *      a.  缓存线程、进行池化，可实现线程重复利用、避免重复创建和销毁所带来的性能开销
 *      b. 当线程调度任务出现异常时，会重新创建一个线程替代掉发生异常的线程
 *      c. 线程池通过队列形式来接收任务。再通过空闲线程来逐一取出进行任务调度。即线程池可以控制任务调度的执行顺序
 *      d. 可制定拒绝策略。即任务队列已满时，后来任务的拒绝处理规则
 *
 * 14. kotlin和java比的异同点
 *      kotlin相比于java的优点：
 *      a. 空安全 - kotlin中用一个操作符“ ？”来明确指定一个对象，或者一个属性变量是否可以为空
 *      b. 拓展方法的支持
 *      c. 我们可以给任何类添加函数，它比那些我们项目中典型的工具类更加具有可读性
 *      d. 函数式支持
 *
 *      kotlin相比于java的缺点：虽然很多时候方便了代码的编写、减少了代码量，但是会降低可读性
 *
 * 15。 Java的参数传递分为：值传递和引用传递
 * 在 Java 中，除了基本数据类型（元类型）之外，还存在 类的实例对象 这个引用数据类型。而一般使用 『 = 』号做赋值操作的时候。
 * 对于基本数据类型，实际上是拷贝的它的值，但是对于对象而言，其实赋值的只是这个对象的引用，将原对象的引用传递过去，
 * 他们实际上还是指向的同一个对象。
 *
 * 而浅拷贝和深拷贝就是在这个基础之上做的区分，如果在拷贝这个对象的时候，只对基本数据类型进行了拷贝，而对引用数据类型只是进行了引用的传递，
 * 而没有真实的创建一个新的对象，则认为是浅拷贝（方法中传入的实参默认就是浅拷贝）。反之，在对引用数据类型进行拷贝的时候，
 * 创建了一个新的对象，并且复制其内的成员变量，则认为是深拷贝。
 *
 * 所以想要实现在java方法中传入对象的拷贝而不是引用，就应该考虑使用深拷贝
 */
public class Doc {

    public static void main(String[] args) {
        double i = Double.NaN;
        double j = i;
        System.out.println(">>> " + (i > j || i <= j));
//        ThreadPoolExecutor

        List<Integer> primes = Arrays.asList(new Integer[]{2, 3,5,7});
        int factor = 2;
        //lambda表达式有个限制，那就是只能引用 final 或 final 局部变量，这就是说不能在lambda内部修改定义在域外的变量
//        primes.forEach(element -> { System.out.println(factor++);});

    }
}
