package cn.wxb.kotlin;

/**
 * 1.java有什么特性，继承有什么用处，多态有什么用处
 * 2.反射是什么，在哪里用到，怎么利用反射创建一个对象
 * 3.代理模式与装饰模式的区别，手写一个静态代理，一个动态代理
 * 4.对象加载的过程，属性先加载还是方法先加载
 * 5.垃圾回收机制与jvm结构
 * 6.自定义View,事件分发机制讲一讲
 * 7.http与https有什么区别
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
 * 8.OkHttp怎么实现连接池
 * 9.如果让你来实现一个网络框架，你会考虑什么
 * 10.你做过什么性能优化的工作
 * 11.热修复的原理，资源的热修复的原理,会不会有资源冲突的问题
 * 12.ViewPager中嵌套ViewPager怎么处理滑动冲突
 * 13.android源码中有哪些设计模式
 * 14.说说binder机制的原理
 *
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
 * 1.string,equals,==有什么区别
 * 2.AsyncTask内存泄露
 * 3.dispatchTouchEvent,onInterceptEvent,onTouchEvent顺序，关系
 * 4.onMeasure,onLayout,onDraw关系
 * 5.算法题，反转数组
 * 6.算法题，链表求和
 * 7.说说你对协程的理解
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
 * 2.动态代理有什么作用？
 * 3.拉圾回收的GCRoot是什么？
 * 4.Handler机制了解吗？一个线程有几个Looper？为什么？
 * 5.你了解协程吗？协程有什么作用？可以完全取代rxjava吗？
 * 6.你们用的什么消息通信机制
 * 7.你的项目有什么难点？介绍一下？
 * 8.算法题，二叉树最长结点集合
 *
 *
 * 1.说说HashMap的原理
 * 2.说说Java的内存分区
 * 3.讲讲你对垃圾回收机制的了解，老年代有什么算法？
 * 4.说说你对volatile字段有什么用途？
 * 5.说说事件分发机制，怎么写一个不能滑动的ViewPager
 * 6.说说你对类加载机制的了解？DexClassLoader与PathClassLoader的区别
 * 7.说说插件化的原理，资源的插件化id重复如何解决？
 * 8.mvp与mvvm模式的区别是什么？
 * 9.JetPack组件用过哪些？lifeCycle的原理是什么？如果在onStart里面订阅，会回调onCreate吗？
 * 10.单例模式有什么缺点？
 * 11.说说App的启动过程,在ActivityThread的main方法里面做了什么事，什么时候启动第一个Activity？
 * 12.说说你对Handler机制的了解，同步消息，异步消息等
 * 13.说说你对屏幕刷新机制的了解，双重缓冲，三重缓冲，黄油模型
 * 14.onCreate,onResume,onStart里面，什么地方可以获得宽高
 * 15.为什么view.post可以获得宽高，有看过view.post的源码吗？
 * 16.attachToWindow什么时候调用？
 * 17.DataBinding的原理了解吗？
 *
 *
 * 1.JVM类加载机制了解吗，类什么时候会被加载？类加载的过程具体生命周期是怎样的？
 * 2.Handler内存泄漏的GCRoot是什么？
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
 * 13.JMM可见性，原子性，有序性，synchronized可以保证什么？
 * 14.源码中有哪里用到了AtomicInt
 * 15.AQS了解吗？
 * 16.Activity内LinearLayout红色wrap_content,包含View绿色wrap_content,求界面颜色
 * 17.ViewModel的使用中有什么坑？
 * 18.有用DSL,anko写过布局吗？
 * 19.HashMap查找的时间复杂度是多少？
 * 20.阿里编程规范不建议使用线程池，为什么？
 * 21.四种线程池原理？
 * 22.了解哪些算法？
 * 23.IdleHandler用过吗？
 *
 * 1.如何封装一个字符串转数字的工具类
 * 2.如何求当前Activity View的深度
 * 3.多进程怎么实现？如果启动一个多进程APP，会有几个进程运行？
 * 4.反射可以反射final修饰的字段吗？
 * 5.Activity与AppCompactActivity区别，Activity会打包到包里面去吗？
 * 6.如何让两个线程循环交替打印
 * 7.怎么中止一个线程，Thread.Interupt一定有效吗？
 * 8.动画连续调用的原理是什么？
 * 9.做过一些SDK的操作吗？
 * 10.协程可以在Java项目中使用吗？
 * 11.SharedPreference原理？读取xml是在哪个线程?
 * 12.了解APK打包的过程吗？
 * 13.class文件的组成？常量池里面有什么内容？
 * 14.自动装箱发生在什么时候？编译期还是运行期
 * 15.bugly日志收集的原理是什么？
 * 16.启动优化做过什么工作？如果首页就要用到的初始化？
 * 17.DataBinding原理
 *
 *
 * 1.插件化的原理是什么？有没有什么非运行时插件化的解决方案？
 * 2.ARouter的原理是怎样的？注解处理器是处理java还是字节码
 * 3.java和字节码有什么区别？
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
 * 6.跨进程通信了解多少？管道了解吗？
 * 7.协程介绍一下，讲一个协程的scope与context，协程的+号代表什么
 * 8.Handler休眠是怎样的？epoll的原理是什么？如何实现延时消息，如果移除一个延时消息会解除休眠吗？
 * 9.算法斐波那契台阶
 * 10.手写生产者消息者模型
 * 11.IdleHandler应用场景
 *
 * 字节跳动2面
 * 1.自定义圆角图片
 * 2.自定义LinearLayout，怎么测量子View宽高
 * 3.setFactory和setFactory2有什么区别？
 * 4.插件化换肤方案
 * 5.插件化的原理，startActivity hook了哪个方法
 * 6.手势操作ActionCancel后怎么取消
 * 7.怎么优化xml inflate的时间，涉及IO与反射。了解compose吗？
 * 8.算法题：二叉树的每一层最左边节点
 * 9.RecyclerView 缓存结构，RecyclerView预取，RecyclerView局部刷新
 * 11.setOnTouchListener,onClickeListener和onTouchEvent的关系
 */
public class Doc {
}