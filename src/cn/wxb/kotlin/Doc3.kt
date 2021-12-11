package cn.wxb.kotlin

/**
 * 一个大致有序的数组如何排序，最快时间复杂度

如果叫你实现，你会怎样实现一个多主题的效果

如何自定义实现一个FlexLayout

tinker的原理是什么,还用过什么热修复框架，robust的原理是什么？

说说你对注解的了解，是怎么解析的

synchronized是公平锁还是非公平锁,ReteranLock是公平锁吗？是怎么实现的
        ReentrantLock 默认采用非公平锁，除非在构造方法中传入参数 true
        synchronized是非公平锁，没有浪费线程唤醒阶段的时间，执行新调用的方法，增加吞吐量，缺点是可能会造成饥饿锁
        公平锁：
        获取不到锁的时候，会自动加入队列，等待线程释放后，队列的第一个线程获取锁
        非公平锁:
        获取不到锁的时候，会自动加入队列，等待线程释放锁后所有等待的线程同时去竞争
        非公平锁和公平锁的两处不同：
        非公平锁在调用 lock 后，首先就会调用 CAS 进行一次抢锁，如果这个时候恰巧锁没有被占用，那么直接就获取到锁返回了。
        非公平锁在 CAS 失败后，和公平锁一样都会进入到 tryAcquire 方法，在 tryAcquire 方法中，如果发现锁这个时候被释放了（state == 0），
        非公平锁会直接 CAS 抢锁，但是公平锁会判断等待队列是否有线程处于等待状态，如果有则不去抢锁，乖乖排到后面。
        公平锁和非公平锁就这两点区别，如果这两次 CAS 都不成功，那么后面非公平锁和公平锁是一样的，都要进入到阻塞队列等待唤醒。
        相对来说，非公平锁会有更好的性能，因为它的吞吐量比较大。当然，非公平锁让获取锁的时间变得更加不确定，
        可能会导致在阻塞队列中的线程长期处于饥饿状态

泛型是怎么解析的，比如在retrofit中的泛型是怎么解析的

mvp与mvvm的区别，mvvm怎么更新UI,databinding用得多吗,databinding的原理？

kotlin ?的原理

在项目中有直接使用tcp,socket来发送消息吗

如何在网络框架里直接避免内存泄漏，不需要在presenter中释放订阅

生命周期都是通过什么调用的？有用过AIDL吗？

讲一下RecyclerView的缓存机制,滑动10个，再滑回去，会有几个执行onBindView

如何实现RecyclerView的局部更新，用过payload吗,notifyItemChange方法中的参数？

讲讲LinkedHashMap的数据结构

put post有什么区别

A Activity打开B Activity的生命周期变化，会有什么方法打断吗？

Fragment hide show生命周期变化

Fragment replace生命周期变化

B站二面
为什么考虑换工作

屏幕适配做过什么工作？

你们网络框架用的什么？为什么？

如果让你来开发B站的一个页面，哪一个页面可以很快入手

性能优化你做过什么工作？

h5与native通信你做过什么工作？

插件化的主要优点和缺点是什么？

你觉得B站目前的APP有什么问题？

如果产品要求你开发一个音频播放功能，你会怎么着手？预计会有什么坑？

ViewPager切换Fragment什么最耗时？

线程间同步的方法

锁之间的区别

B站三面
介绍一下你自已和项目

说说为什么考虑离职

说说对你们原来公司的印象

为什么想来B站？你在B站上常常在看什么？

期望薪资是多少？

你对搬到上海有什么想法？

腾讯
介绍一下你们项目的架构

Rxjava是怎么实现线程切换的

Rxjava自定义操作符

ARouter的原理

ARouter怎么实现接口调用

ARouter怎么实现页面拦截

MVP怎么处理内存泄漏

OkHttp怎么实现连接池

如果让你来实现一个网络框架，

《Android学习笔记总结+最新移动架构视频+大厂安卓面试真题+项目实战源码讲义》

【docs.qq.com/doc/DSkNLaERkbnFoS0ZF】 完整内容开源分享

你会考虑什么

你做过什么性能优化的工作

热修复的原理，资源的热修复的原理,会不会有资源冲突的问题

ViewPager中嵌套ViewPager怎么处理滑动冲突

android源码中有哪些设计模式

说说binder机制的原理

腾讯二面
为什么考虑换一份工作？

在你们公司这几年感觉怎么样？

技术选型上，为什么这么考虑？从开发效率，产品性能，产品质量，产品体验等方面考虑

你们的产品为什么被砍掉，从哪方面考虑

在这几年里，你有做过什么觉得最有价值的工作

你还有什么要问我的吗？目前有几个offer，倾向性是怎样的？

网易云音乐
ViewPager2原理

LifeCycle的原理是怎样的？

ViewModel为什么在旋转屏幕后不会丢失状态
        配置变更主要是指：横竖屏切换、分辨率调整、权限变更、系统字体样式变更
        在配置发生变化时，onRetainNonConfigurationInstance（）保存状态，getLastNonConfigurationInstance()恢复。

        当Activity配置发生了变化，执行了ActivityThread#performDestroyActivity方法时，
        会把ViewModelStore存储在NonConfigurationInstances ，然后把NonConfigurationInstances 存储在ActivityClientRecord。
        然后重启Activity时，会在attach方法，把ActivityClientRecord的NonConfigurationInstances给Activity

Drawable与View有什么区别,Drawable有哪些子类
        Bitmap 是位图信息的存储，就是一个矩形图像每个像素的颜色信息的存储器。

        2.1.Drawable是一种可以在Canvas上进行绘制的抽象的概念。Drawable 是一个可以调用Canvas来进行绘制的上层工具。
                Drawable.draw(canvas)可以将Drawable设置的绘制内容绘制到Canvas中。
        2.2.Drawable的内部存储的是绘制规则，这个规则可以是一个具体的Bitmap，也可以是一个纯粹的颜色，甚至可以是一个抽象。
                灵活的描述。Drawable可以不含有具体的像素信息，只要它含有的信息足以在draw(canvas)方法中被调用时进行绘制就够了。
                也就是说，颜色、图片等都可以是一个Drawable
        2.3.Drawable 可以通过XML定义，或者通过代码构建
        2.4.Android 中 Drawable是一个抽象类，每个具体的Drawable都是其子类。
        2.5.由于Drawable存储的只是绘制规则，因此他在draw()方法被调用前，需要先调用Drawable.setBounds()来为它设置绘制边界。
        drawable优点：1.使用简单，比自定义View的成本低；2.非图片类的Drawable所占用空间小，能减小apk大小

属性动画更新时会回调onDraw吗？

OkHttp网络拦截器，应用拦截器?OKHttp有哪些拦截器，分别起什么作用

自定义实现一个九宫格如何实现

PathClassLoader与DexClassLoader有什么区别

这些年有做一些什么比较难的工作？

编译时注解与运行时注解，为什么retrofit要使用运行时注解？什么时候用运行时注解？
        retrofit的底层采用动态代理获取接口函数，然后获取对应的注解来实现
        内建注解
        元注解：@Target： 表示该注解用于什么地方
               @Retention： 表示在什么级别保存该注解信息
               @Documented： 将此注解包含在 javadoc
               @Inherited： 允许子类继承父类中的注解
        自定义注解：判断注解自身是否存在，来提供信息；获取注解中的元数据

        Annotation（注解）是被动的元数据，永远不会有主动行为，所以我们需要通过使用反射，才能让我们的注解产生意义
        1. 源码注解（RetentionPolicy.SOURCE）： 注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃。
        2. 编译时注解（RetentionPolicy.CLASS）： 注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期。
        3. 运行时注解（RetentionPolicy.RUNTIME）： 注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在。

        运行时注解： 通过 反射 机制获取注解对象
        编译时注解： 通过 APT 方式获取注解对象
                APT是一种处理注解的工具，确切的说它是 javac 的一个工具，它用来在编译时扫描和处理注解，
                一个注解的注解处理器，以 java 代码（或者编译过的字节码）作为输入，生成 .java 文件作为输出，
                核心是交给自己定义的处理器去处理


kotlin lazy使用,lazy viewmodel

有没有看一下Google官方的ViewModel demo

ViewModel在Activity初始化与在Fragment中初始化，有什么区别？
        ViewModel 在 Fragment 中不会因配置改变而销毁的原因其实是因为其声明的
        ViewModel 是存储在 FragmentManagerViewModel 中的，而 FragmentManagerViewModel 是存储在宿主 Activity 中的
        ViewModelStore 中，又因 Activity 中 ViewModelStore不会因配置改变而销毁，
        故 Fragment 中 ViewModel 也不会因配置改变而销毁


kotlin与Java互相调用有什么问题？

retrofit怎么做post请求

界面优化的一些方法，ConstraintLayout实现三等分,ConstraintLayout动画.

CoordinatorLayout自定义behavior,可以拦截什么？

网易云音乐二面
你们的项目中做过什么比较难的工作？

视频播放,一个player怎么实现预加载，避免loading

webView加载本地图片，如何从安全方面考虑

http1.0,http1.1,http1.2有什么区别

https与http有什么区别

有用过什么加密算法？AES,RAS什么原理？

android跨进程通信了解吗？共享内存用过吗？binder怎么验证pid?binder驱动了解吗？

SharedParence可以跨进程通信吗？如何改造成可以跨进程通信的.commit和apply的区别.

Seriazable与Parceable的区别

Bundle是什么数据结构?利用什么传递数据

Jvm的内存结构，Jvm的垃圾回收，方法区有什么东西？

h5与native交互，webView.loadUrl与webView.evaluateUrl区别

网易云音乐三面
有没有做过什么WebView秒开的一些优化

你们的项目中有什么难点？

native如何对h5进行鉴权，让某些页面可以调，某些页面不能调

有看过哪些框架的源码吗？

viewModel是怎么实现双向数据绑定的？
        ViewModel 类让数据可在发生屏幕旋转等配置更改后继续留存(在横竖屏切换时，可以保留数据)，
        在actvity的onDestroy时/Fragment的onDetach时就会clear

        LiveData 是单向数据观察者可以感知生命周期：处于活动状态才会更新数据；配置改变时可以立即接受最新可用数据；无内存泄漏，不用手动处理订阅

        viewmodel + dataBinding + liveData 实现双向数据绑定
        DataBindingUtil.setContentView -> return activityBinding
        viewModel持有LiveData包装的数据发生变化时通知view，而dataBinding通过设置lifeCyclerOwner

viewModel怎么实现自动处理生命周期？

图片加载优化有什么经验吗？

viewpager切换掉帧有什么处理经验？

一个wrap_content的ImageView，加载远程图片，传什么参数裁剪比较好?

两个getDrawable取得的对象，有什么区别？

补间动画与属性动画的区别，哪个效率更高？

jsBridge实现方式

平常是怎么了解一些新知识与业界动态的，最近有什么印象深刻的文章

平常抓包用什么工具？

Mvp与Mvvm有什么区别?

跟谁学
项目中的Webview与native通信

项目中对WebView的功能进行了怎样的增强

synchronized跟ReentranLock有什么区别？

synchronized与ReentranLock发生异常的场景.

算法,删除数组中的重复元素

手写双检查单例模式，各个步骤有什么区别

Activity生命周期

快手
string,equals,==有什么区别

AsyncTask内存泄露

dispatchTouchEvent,onInterceptEvent,onTouchEvent顺序，关系

onMeasure,onLayout,onDraw关系

算法题，反转数组

算法题，链表求和

说说你对协程的理解

协程怎么取消

说说MVP与MVVM的区别

快手二面
算法题，二叉树的最大深度

如果android端和IOS端调一个接口，一个通了一个没通，你会如何解决

如果android端和IOS端调一个接口，一个比较慢，一个比较快，有什么思路

ARouter的原理是什么？如果不用ARouter，你会怎么去解藕。接口？设计接口有什么需要注意的？

h5与native交互做过什么工作？

登陆功能，登陆成功然后跳转到一个新Activity，中间涉及什么？从事件传递，网络请求,AMS交互角度分析

AMS交互调用生命周期是顺序的吗？

binder进程间通信可以调用原进程方法吗？

mvp与mvvm有什么区别？

token放在本地如何保存？如何加密比较好？

快手三面
viewModel的原理，为什么可以在Activity销毁后保存数据

mvvm双向数据绑定的原理是怎样的？ViewModel

说说你们项目中的难点是怎样的？

伪代码实现一个长按事件

实现一个下载功能的接口

猿辅导
泛型有什么优点？
        保证了类型的安全性：泛型在编译器约束了变量的类型，保证了类型的安全性，如List的使用
        避免了类型的强制转换
        提高方法的复用性
        避免了不必要的装箱、拆箱操作，提高程序的性能：泛型变量固定了类型，使用的时候就已经知道是值类型还是引用类型，
                避免了不必要的装箱、拆箱操作
动态代理有什么作用？

拉圾回收的GCRoot是什么？

Handler机制了解吗？一个线程有几个Looper？为什么？

你了解协程吗？协程有什么作用？可以完全取代rxjava吗？

你们用的什么消息通信机制

你的项目有什么难点？介绍一下？

算法题，二叉树最长结点集合

猿辅导2面
你们项目中的难点是什么？

编译期注解处理的是字节码还是java文件
        简单来说注解的作用就是将我们的需要的数据储存起来，在以后的某一个时刻（可能是编译时，也可能是运行时）去调用它
        Annotation Processing Tool注解处理器是 javac 自带的一个工具，用来在编译时期扫描处理注解信息
        一个特定注解的处理器以 java 源代码（或者已编译的字节码）作为输入，然后生成一些文件（通常是.java文件）作为输出

你在项目中有用到什么设计模式吗？

ARouter的原理是怎样的？

插件化的原理是怎样的？

算法题，K个一组反转链表

广播与RxBus的区别，全局广播与局部广播区别

猿辅导3面
你们项目中有什么难点？

@JavaScriptInterface为什么不通过多个方法来实现？

为什么不利用同步方法来做jsBridge交互？同步可以做异步，异步不能做同步

网络封装怎么实现？

算法题，不同面值的几个硬币，怎么求满足条件的最小值

斗鱼
说说HashMap的原理

说说Java的内存分区

讲讲你对垃圾回收机制的了解，老年代有什么算法？

说说你对volatile字段有什么用途？

说说事件分发机制，怎么写一个不能滑动的ViewPager

说说你对类加载机制的了解？DexClassLoader与PathClassLoader的区别

说说插件化的原理，资源的插件化id重复如何解决？

mvp与mvvm模式的区别是什么？

JetPack组件用过哪些？lifeCycle的原理是什么？如果在onStart里面订阅，会回调onCreate吗？

单例模式有什么缺点？

说说App的启动过程,在ActivityThread的main方法里面做了什么事，什么时候启动第一个Activity？

说说你对Handler机制的了解，同步消息，异步消息等

说说你对屏幕刷新机制的了解，双重缓冲，三重缓冲，黄油模型

onCreate,onResume,onStart里面，什么地方可以获得宽高

为什么view.post可以获得宽高，有看过view.post的源码吗？

attachToWindow什么时候调用？

DataBinding的原理了解吗？

滴滴一面
JVM类加载机制了解吗，类什么时候会被加载？类加载的过程具体生命周期是怎样的？

Handler内存泄漏的GCRoot是什么？

动画里面用到了什么设计模式？

OkHttp里面用到了什么设计模式？

OkHttp连接池是怎么实现的？里面怎么处理SSL？

泛型为什么要擦除？kotlin的泛型了解吗？泛型的pecs原则

同步屏障

性能优化做过什么工作？

RecyclerView的缓存结构是怎样的？缓存的是什么？cachedView会执行onBindView吗?

RecyclerView嵌套RecyclerView，NestScrollView嵌套ScrollView滑动冲突

ViewGroup在Action_Move时onIntercept返回true，事件怎么传递

Launcher启动图标，有几个进程？

JMM可见性，原子性，有序性，synchronized可以保证什么？

源码中有哪里用到了AtomicInt

AQS了解吗？

Activity内LinearLayout红色wrap_content,包含View绿色wrap_content,求界面颜色

ViewModel的使用中有什么坑？

有用DSL,anko写过布局吗？

HashMap查找的时间复杂度是多少？

阿里编程规范不建议使用线程池，为什么？

四种线程池原理？

了解哪些算法？

IdleHandler用过吗？

滴滴二面
如何封装一个字符串转数字的工具类

如何求当前Activity View的深度

多进程怎么实现？如果启动一个多进程APP，会有几个进程运行？

反射可以反射final修饰的字段吗？

Activity与AppCompactActivity区别，Activity会打包到包里面去吗？

如何让两个线程循环交替打印

怎么中止一个线程，Thread.Interupt一定有效吗？

动画连续调用的原理是什么？

做过一些SDK的操作吗？

协程可以在Java项目中使用吗？

SharedPreference原理？读取xml是在哪个线程?

了解APK打包的过程吗？

class文件的组成？常量池里面有什么内容？

自动装箱发生在什么时候？编译期还是运行期

bugly日志收集的原理是什么？

启动优化做过什么工作？如果首页就要用到的初始化？

DataBinding原理

滴滴3面
插件化的原理是什么？有没有什么非运行时插件化的解决方案？

ARouter的原理是怎样的？注解处理器是处理java还是字节码

java和字节码有什么区别？

kotlin空安全的原理是什么？

性能优化做过什么工作?有用过什么工具？有没有精确测量的工具？

kotlinc与javac编译字节码有什么区别？

你在团队中是怎样一个角色？

你有没有做什么推进项目的工作

说说热修复的原理？

字节跳动
你们的项目中有什么难点？

你们项目的稳定性如何？有做过什么稳定性优化的工作？

WebView性能优化做过什么工作？

AIDL in out oneWay代表什么意思？

线程池了解多少？拒绝策略有几种,为什么有newSingleThread

跨进程通信了解多少？管道了解吗？

协程介绍一下，讲一个协程的scope与context，协程的+号代表什么

Handler休眠是怎样的？epoll的原理是什么？如何实现延时消息，如果移除一个延时消息会解除休眠吗？

算法斐波那契台阶

手写生产者消息者模型

IdleHandler应用场景

字节跳动2面
自定义圆角图片

自定义LinearLayout，怎么测量子View宽高

setFactory和setFactory2有什么区别？

插件化换肤方案

插件化的原理，startActivity hook了哪个方法

手势操作ActionCancel后怎么取消

怎么优化xml inflate的时间，涉及IO与反射。了解compose吗？
 */
class Doc3 {
}