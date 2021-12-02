package cn.wxb.kotlin;

/**
 * 1.Activity
 * Activity的启动流程
 * onSaveInstanceState(),onRestoreInstanceState的掉用时机
 * activity的启动模式和使用场景
 * Activity A跳转Activity B，再按返回键，生命周期执行的顺序
 * 横竖屏切换,按home键,按返回键,锁屏与解锁屏幕,跳转透明Activity界面,启动一个 Theme 为 Dialog 的 Activity，弹出Dialog时Activity的生命周期
 * onStart 和 onResumeonPause 和 onStop 的区别
 * Activity之间传递数据的方式Intent是否有大小限制，如果传递的数据量偏大，有哪些方案
 * Activity的onNewIntent()方法什么时候会执行
 * 显示启动和隐式启动
 * scheme使用场景,协议格式,如何使用
 * ANR 的四种场景
 * onCreate和onRestoreInstance方法中恢复数据时的区别
 * activty间传递数据的方式
 * 跨App启动Activity的方式,注意事项
 * Activity任务栈是什么
 * 有哪些Activity常用的标记位Flags
 * Activity的数据是怎么保存的,进程被Kill后,保存的数据怎么恢复的
 * 2.Service
 * service 的生命周期，两种启动方式的区别
 * Service启动流程
 * Service与Activity怎么实现通信
 * IntentService是什么,IntentService原理，应用场景及其与Service的区别
 * Service 的 onStartCommand 方法有几种返回值?各代表什么意思?
 * bindService和startService混合使用的生命周期以及怎么关闭
 * 3.BroadcastReceiver
 * 广播的分类和使用场景
 * 广播的两种注册方式的区别
 * 广播发送和接收的原理
 * 本地广播和全局广播的区别
 * 4.ContentProvider
 * 什么是ContentProvider及其使用
 * ContentProvider[,]ContentObserver之间的关系
 * ContentProvider的实现原理* 4.ContentProvider的优点* 5.Uri 是什么
 * 5.Handler
 * Handler的实现原理
 * 子线程中能不能直接new一个Handler,为什么主线程可以
 * 主线程的Looper第一次调用loop方法,什么时候,哪个类
 * 3.Handler导致的内存泄露原因及其解决方案
 *      原因：非静态内部类，或者匿名内部类。使得Handler默认持有外部类的引用。
 *      在Activity销毁时，由于Handler可能有未执行完/正在执行的Message，
 *      导致Handler持有Activity的引用。进而导致GC无法回收Activity
 *
 *      解决方法：a。Activity销毁时，清空Handler中，未执行或正在执行的Callback以及Message
 *              b. 静态内部类+弱引用
 *                  private static class AppHandler extends Handler {
 *                      //弱引用，在垃圾回收时，被回收
 *                      WeakReference<Activity> activity;
 *
 *                      AppHandler(Activity activity){
 *                          this.activity=new WeakReference<Activity>(activity);
 *                      }
 *
 *                       public void handleMessage(Message message){
 *                           switch (message.what){
 *                              //todo
 *                          }
 *                       }
 *                  }
 * 4.一个线程可以有几个Handler,几个Looper,几个MessageQueue对象
 * 5.Message对象创建的方式有哪些 & 区别？Message.obtain()怎么维护消息池的？
 *      new Message 每次创建新对象，堆内存开辟空间，使用完后jvm垃圾回收
 *      handler.obtainMessage
 *      Message.obtain  给对象加锁（Object - sPoolSync），保证同一时刻只有一个线程使用Message
 *                      如果消息池sPool为空则new Message()
 *                      否则取出头节点Message 重置message，message.next = null, message.flag = 0;
 *                      sPoolSize--；消息池 最大数为50
 *      重复的利用message，减少了每次获取Message时去申请空间的时间,减少了gc，提高了效率
 * Handler 有哪些发送消息的方法
 *    handler常用场景- 异步更新ui/延时任务处理
 * Handler的post与sendMessage的区别和应用场景
 *      两者无区别post会吧runnable封装成message(赋值给callBack属性)然后调用sendMessageDelayed方法
 *      sendMessage 也是调用sendMessageDelayed
 *      消息处理区别：
 *      区别就是调用post方法的消息是在post传递的Runnable对象的run方法中处理，
 *      而调用sendMessage方法需要重写handleMessage方法或者给handler设置callback
 *      ，在callback的handleMessage中处理并返回true
 * handler postDealy后消息队列有什么变化，假设先 postDelay 10s, 再postDelay 1s, 怎么处理这2条消息
 * MessageQueue是什么数据结构
 * Handler怎么做到的一个线程对应一个Looper，如何保证只有一个MessageQueue，ThreadLocal在Handler机制中的作用
 * HandlerThread是什么 & 好处 &原理 & 使用场景
 *      handlerThread是一个封装了looper的thread，可以通过消息重复使用当前线程
 * IdleHandler及其使用场景
 *       Handler 机制提供的一种，可以在 Looper 事件循环的过程中，当出现空闲的时候，允许我们执行任务的一种机制。
 *       message=null 或消息延迟执行时，执行idleHandler消息
 * 消息屏障,同步屏障机制
 * 子线程能不能更新UI
 * 为什么Android系统不建议子线程访问UI
 * Android中为什么主线程不会因为Looper.loop()里的死循环卡死，MessageQueue#next 在没有消息的时候会阻塞，如何恢复？
 * Handler消息机制中，一个looper是如何区分多个Handler的，当Activity有多个Handler的时候，怎么样区分当前消息由哪个Handler处理，处理message的时候怎么知道是去哪个callback处理的
 * Looper.quit/quitSafely的区别
 * 通过Handler如何实现线程的切换
 *      主线程创建handler，子线程发送消息 -》 MessageQueue.enqueueMessage(msg.target = this-handler)->Loop.loop 调用handler的回调方法
 * Handler 如何与 Looper 关联的
 *      不传入looper对象时，默认使用的是创建handler线程的looper（Looper.myLooper() - ThreadLocal存储的 ）
 *      Handler.mQueue 引用了looper的queue
 * Looper 如何与 Thread 关联的
 * Looper.loop()源码
 * MessageQueue的enqueueMessage()方法如何进行线程同步的
 *      enqueueMessage 和 next 方法通过synchronized来保证了线程的安全性
 * MessageQueue的next()方法内部原理
 *      for(;;)遍历msgQueue
 *      1。msg.target = null 同步屏障消息，此时处理异步消息
 *      2。取出当前要执行的消息（when字段判断）或者阻塞等待消息执行
 *      3。msgQueue队列为空，则遍历执行idleHandler消息
 * 子线程中是否可以用MainLooper去创建Handler，Looper和Handler是否一定处于一个线程
 * ANR和Handler的联系
 * 6.View绘制
 * View绘制流程
 * MeasureSpec是什么
 *      MeasureSpec代表一个32位int值，高2位代表SpecMode(测量模式），低30位代表SepcSize(指在某种测量模式下的规格大小)
 *      AT_MOST:父容器指定了一个可用大小即SpecSize，View的大小不能大于这个值，具体是什么值要看不同View的具体实现。
 *      它对应于LayoutParams中的wrap_content
 *
 *      EXACTLY：父容器已经检测出View所需要的精确大小，这个时候View的最终大小就是SpecSize所指定的值。
 *      它对应于LayoutParams中的match_parent和具体的数值这两种模式
 *
 *      UNSPECIFIED:父容器不对VIew有任何限制，要多大给多大，这种情况一般用于系统内部，表示一种测量的状态。
 *
 * 子View创建MeasureSpec创建规则是什么
 * 自定义Viewwrap_content不起作用的原因
 *      在getDefaultSize（）的默认实现中，当View的测量模式是AT_MOST或EXACTLY时，
 *      View的大小都会被设置成子View MeasureSpec的specSize。因为AT_MOST对应wrap_content；EXACTLY对应match_parent，
 *      所以，默认情况下，wrap_content和match_parent是具有相同的效果的
 * 在Activity中获取某个View的宽高有几种方法
 * 为什么onCreate获取不到View的宽高
 * View#post与Handler#post的区别
 *      View.post 将runnable先存起来(HandlerActionQueue, 默认数组是4)，等viewRootImpl.performTraversals调用时，将其加入主线程的messageQueue中，
 *      因performTraversals也是被加入messageQueue中进行处理的，
 *      所以等performTraversals方法执行完onMeasure/onLayout/onDraw执行完之后，才会执行view.post发送的runnable，
 *      此时是可以获取到view的宽高的。
 * Android绘制和屏幕刷新机制原理
 * Choreography原理
 * 什么是双缓冲
 * 为什么使用SurfaceView
 * 什么是SurfaceView
 * View和SurfaceView的区别
 * SurfaceView为什么可以直接子线程绘制
 * SurfaceView、TextureView、SurfaceTexture、GLSurfaceView
 * getWidth()方法和getMeasureWidth()区别
 *      View的高宽是由View本身和Parent容器共同决定的。
 *      getMeasuredWidth()和getWidth()分别对应于视图绘制的measure和layout阶段。
 *      getMeasuredWidth()获取的是View原始的大小，也就是这个View在XML文件中配置或者是代码中设置的大小。
 *      getWidth()获取的是这个View最终显示的大小，这个大小有可能等于原始的大小，也有可能不相等。
 *
 * invalidate() 和 postInvalidate() 的区别
 *    invalidate，在UI线程自身中刷先ui
 *    postInvalidate，在非UI线程中刷新，实际是通过handler实现，最后调用的还是invalidate
 * Requestlayout，onlayout，onDraw，DrawChild区别与联系
 * LinearLayout、FrameLayout 和 RelativeLayout 哪个效率高
 * LinearLayout的绘制流程
 * 自定义 View 的流程和注意事项
 * 自定义View如何考虑机型适配
 * 自定义控件优化方案
 * invalidate怎么局部刷新
 * View加载流程（setContentView）
 * 7.View事件分发
 * View事件分发机制
 * view的onTouchEvent，OnClickListerner和OnTouchListener的onTouch方法 三者优先级
 *      onTouch:指的是View设置的OnTouchListener接口的onTouch（）方法
 *      onTouchEvent：指的是事件分发中的重要方法（dispatchTouchEvent，onInterceptTouchEvent，onTouchEvent）
 *      onClick：指的是View设置的OnClickListener接口的onClick（）方法
 *
 *      onTouch（dispatchTouchEvent中处理）>onTouchEvent>onClick（onTouchEvent中处理）
 * onTouch 和onTouchEvent 的区别
 * ACTION_CANCEL什么时候触发
 *      当子View至始至终没有事件处理权时，该事件是不会发生的；当子View的事件处理权从有到无时，
 *      在失去处理权的那一刻子View会被告知，也就是收到cancel事件
 *      在子View处理事件的过程中，父View对事件拦截
 * 事件是先到DecorView还是先到Window
 *      ViewRootImpl——>DecorView——>Activity——>PhoneWindow——>DecorView——>ViewGroup
 * 点击事件被拦截，但是想传到下面的View，如何操作
 * 如何解决View的事件冲突
 * 在 ViewGroup 中的 onTouchEvent 中消费 ACTION_DOWN 事件，ACTION_UP事件是怎么传递
 *      -> Activity.dispatchTouchEvent()
 *      -> ViewGroup1.dispatchTouchEvent()
 *      -> ViewGroup1.onTouchEvent()
 *
 * Activity ViewGroup和View都不消费ACTION_DOWN,那么ACTION_UP事件是怎么传递的
 *      都不消费action_down，其事件传递如下：
 *      -> Activity.dispatchTouchEvent()
 *      -> ViewGroup1.dispatchTouchEvent()
 *      -> ViewGroup1.onInterceptTouchEvent()
 *      -> view1.dispatchTouchEvent()
 *      -> view1.onTouchEvent()
 *      -> ViewGroup1.onTouchEvent()
 *      -> Activity.onTouchEvent();
 *
 *      action_up/action_move事件如下：
 *      -> Activity.dispatchTouchEvent()
 *      -> Activity.onTouchEvent();
 *
 *
 *      为什么子 View 不消费 ACTION_DOWN,之后的所有事件都不会向下传递了？
 *      mFirstTouchTarget。当子 view 对事件进行处理的时，那么 mFirstTouchTarget 就会被赋值，
 *      若是子 view 不对事件进行处理，那么 mFirstTouchTarget 就为 null，之后 VIewGroup 就会默认拦截所有的事件
 *。
 *
 * 同时对父 View 和子 View 设置点击方法，优先响应哪个
 *          优先响应子 view，原因很简单，如果先响应父 view，那么子 view 将永远无法响应，
 *          父 view 要优先响应事件，必须先调用 onInterceptTouchEvent 对事件进行拦截，
 *          那么事件不会再往下传递，直接交给父 view 的 onTouchEvent 处理
 *
 * requestDisallowInterceptTouchEvent的调用时机
 * 8.RecycleView
 * RecyclerView的多级缓存机制,每一级缓存具体作用是什么,分别在什么场景下会用到哪些缓存
 * RecyclerView的滑动回收复用机制
 * RecyclerView的刷新回收复用机制
 * RecyclerView 为什么要预布局
 * ListView 与 RecyclerView区别
 * RecyclerView性能优化
 * 9.Viewpager&Fragment
 * Fragment的生命周期 & 结合Activity的生命周期
 * Activity和Fragment的通信方式， Fragment之间如何进行通信
 * 为什么使用Fragment.setArguments(Bundle)传递参数
 * FragmentPageAdapter和FragmentStatePageAdapter区别及使用场景
 * Fragment懒加载
 * ViewPager2与ViewPager区别
 * Fragment嵌套问题
 * 10.WebView
 * 如何提高WebView加载速度
 * WebView与 js的交互
 * WebView的漏洞
 * JsBridge原理
 * 11.动画
 * 动画的类型
 * 补间动画和属性动画的区别
 * ObjectAnimator，ValueAnimator及其区别
 * TimeInterpolator插值器，自定义插值器
 * TypeEvaluator估值器
 * 12.Bitmap
 * Bitmap 内存占用的计算
 * getByteCount() & getAllocationByteCount()的区别
 * Bitmap的压缩方式
 * LruCache & DiskLruCache原理
 * 如何设计一个图片加载库
 * 有一张非常大的图片,如何去加载这张大图片
 * 如果把drawable-xxhdpi下的图片移动到drawable-xhdpi下，图片内存是如何变的。
 * 如果在hdpi、xxhdpi下放置了图片，加载的优先级。如果是400800，10801920，加载的优先级。
 * 13.mvc&mvp&mvvm
 * MVC及其优缺点
 * MVP及其优缺点
 * MVVM及其优缺点
 * MVP如何管理Presenter的生命周期，何时取消网络请求
 * 14.Binder
 * Android中进程和线程的关系,区别
 * 为何需要进行IPC,多进程通信可能会出现什么问题
 * Android中IPC方式有几种、各种方式优缺点
 * 为何新增Binder来作为主要的IPC方式
 * 什么是Binder
 * Binder的原理，Binder Driver 如何在内核空间中做到一次拷贝的？
 * 使用Binder进行数据传输的具体过程
 * Binder框架中ServiceManager的作用
 * 什么是AIDL
 * AIDL使用的步骤
 * AIDL支持哪些数据类型
 * AIDL的关键类，方法和工作流程
 * 如何优化多模块都使用AIDL的情况
 * 使用 Binder 传输数据的最大限制是多少，被占满后会导致什么问题
 * Binder 驱动加载过程中有哪些重要的步骤
 * 系统服务与bindService启动的服务的区别
 * Activity的bindService流程
 * 不通过AIDL，手动编码来实现Binder的通信
 * 15.内存泄漏&内存溢出
 * 什么是OOM & 什么是内存泄漏以及原因
 * Thread是如何造成内存泄露的，如何解决？
 * Handler导致的内存泄露的原因以及如何解决
 * 如何加载Bitmap防止内存溢出
 * MVP中如何处理Presenter层以防止内存泄漏的
 * 16.性能优化
 * 内存优化
 * 启动优化
 * 布局加载和绘制优化
 * 卡顿优化
 * 网络优化
 * 17.Window&WindowManager
 * 什么是Window
 * 什么是WindowManager
 * 什么是ViewRootImpl
 * 什么是DecorView
 * Activity，View，Window三者之间的关系
 * DecorView什么时候被WindowManager添加到Window中
 * 18.WMS
 * 什么是WMS
 * WMS是如何管理Window的
 * IWindowSession是什么，WindowSession的创建过程是怎样的
 * WindowToken是什么
 * WindowState是什么
 * Android窗口大概分为几种？分组原理是什么
 * Dialog的Context只能是Activity的Context，不能是Application的Context
 * App应用程序如何与SurfaceFlinger通信的，View 的绘制是如何把数据传递给 SurfaceFlinger 的
 * 共享内存的具体实现是什么
 * relayout是如何向SurfaceFlinger申请Surface
 * 什么是Surface
 * 19.AMS
 * ActivityManagerService是什么？什么时候初始化的？有什么作用？
 * ActivityThread是什么?ApplicationThread是什么?他们的区别
 * Instrumentation是什么？和ActivityThread是什么关系？
 * ActivityManagerService和zygote进程通信是如何实现的
 * ActivityRecord ProcessRecord
 * ActivityManager ，ActivityManagerProxy的关系
 * 手写实现简化版AMS
 * 20.系统启动
 * android系统启动流程
 * SystemServer，ServiceManager，SystemServiceManager的关系
 * 孵化应用进程这种事为什么不交给SystemServer来做，而专门设计一个Zygote
 * Zygote的IPC通信机制为什么使用socket而不采用binder
 * 21.App启动&打包&安装
 * 应用启动流程
 * apk组成和Android的打包流程
 * Android的签名机制，签名如何实现的,v2相比于v1签名机制的改变
 *      签名是摘要与非对称密钥加密相相结合的产物，摘要就像内容的一个指纹信息，一旦内容被篡改，摘要就会改变
 *      V1签名靠META_INFO文件夹下的签名文件
 *      V2签名依靠中央目录前的V2签名快，ZIP的目录结构不会改变，当然结尾偏移要改
 *      多渠道打包的切入点原则：附加信息不影响签名验证
 * APK的安装流程
 * 22.序列化
 * 什么是序列化
 *      Java序列化是指把Java对象转换为字节序列的过程，而Java反序列化是指把字节序列恢复为Java对象的过程
 *      序列化：对象序列化的最主要的用处就是在传递和保存对象的时候，保证对象的完整性和可传递性。
 *          序列化是把对象转换成有序字节流，以便在网络上传输或者保存在本地文件中。核心作用是对象状态的保存与重建
 *      反序列化：客户端从文件中或网络上获得序列化后的对象字节流，根据字节流中所保存的对象状态及描述信息，通过反序列化重建对象
 * 为什么需序列化和反序列化要使用
 *      序列化是指把一个Java对象变成二进制内容，本质上就是一个byte[]数组
 *      因为序列化后可以把byte[]保存到文件中，或者把byte[]通过网络传输到远程
 * 序列化的有哪些好处
 * Serializable 和 Parcelable 的区别
 * 什么是serialVersionUID
 * 为什么还要显示指定serialVersionUID的值?
 *      当对同一个实体序列化反序列化时，需要serialVersionUID值一致才能成功。如果我们不显示指定serialVersionUID，
 *      在序列化时会自动生成一个serialVersionUID。当实体类改动了，反序列化时，会生成一个新serialVersionUID。
 *      这两个serialVersionUID的值肯定不一致，从而反序列化会失败。但是如果显示指定，就不会生成新serialVersionUID值了。
 *      反序列化的serialVersionUID就是原序列化的serialVersionUID
 *
 * 23.Art & Dalvik 及其区别
 * Art & Dalvik 及其区别
 * 24.模块化&组件化
 * 什么是模块化
 * 什么是组件化
 * 组件化优点和方案
 * 组件独立调试
 * 组件间通信
 * Aplication动态加载
 * ARouter原理
 * 25.热修复&插件化
 * 插件化的定义
 * 插件化的优势
 * 插件化框架对比
 * 插件化流程
 * 插件化类加载原理
 * 插件化资源加载原理
 * 插件化Activity加载原理
 * 热修复和插件化区别
 * 热修复原理
 * 26.AOP
 * AOP是什么
 * AOP的优点
 * AOP的实现方式,APT,AspectJ,ASM,epic,hook
 * 27.jectpack
 * Navigation
 * DataBinding
 * Viewmodel
 * livedata
 * liferecycle
 * 28.开源框架
 * Okhttp源码流程,线程池
 * Okhttp拦截器,addInterceptor 和 addNetworkdInterceptor区别
 * Okhttp责任链模式
 * Okhttp缓存怎么处理
 * Okhttp连接池和socket复用
 * Glide怎么绑定生命周期
 *
 *      1、Glide通过高度封装之后，通过外观模式对外提供了非常简洁的API调用，貌似外观模式的很多库都很受欢迎；
 *      2、Glide自动感知生命周期，很节约资源，不会内存泄漏；
 *      3、超级强大的缓存机制；
 *      4、各种图片转换，超级方便
 *
 *      Glide中一个重要的特性，就是Request可以随着Activity或Fragment的onStart而resume，onStop而pause，onDestroy而clear。
 *      从而节约流量和内存，并且防止内存泄露
 *      基于当前Activity添加无UI的Fragment，通过Fragment接收Activity传递的生命周期。
 *      Fragment和RequestManager基于Lifecycle建立联系，并传递生命周期事件，实现生命周期感知
 *
 *      Glide：库提供对外调用方法的类，传入页面引用。
 *      RequestManagerRetriever：一个处理中间类，获取RequestManager和RequestManagerFragment，并将两者绑定
 *      RequestManagerFragment：无UI的fragment，与RequestManager绑定，感知并传递页面的生命周期
 *      RequestManager：实现了LifeCycleListener，主要作用为结合Activity或Fragment生命周期，对Request进行管理，
 *                  如pauseRequests(), resumeRequests(), clearRequests()。
 *      LifecycleListener：接口，定义生命周期管理方法，onStart(), onStop(), onDestroy(). RequestManager实现了它。
 *      ActivityFragmentLifecycle：保存fragment和Requestmanager映射关系的类，管理LifecycleListener，
 *                          空白Fragment会回调它的onStart(), onStop(), onDestroy()。
 *
 * Glide缓存机制,内存缓存，磁盘缓存
 *       内存缓存的主要作用是防止应用重复将图片数据读取到内存当中；
 *       而硬盘缓存的主要作用是防止应用重复从网络或其他地方下载和读取数据。
 *
 *       Glide缓存分为弱引用+ LruCache+ DiskLruCache，其中读取数据的顺序是：弱引用 > LruCache > DiskLruCache>网络；
 *       写入缓存的顺序是：网络 --> DiskLruCache--> LruCache-->弱引用
 *
 *       内存缓存分为弱引用的和 LruCache ，其中正在使用的图片使用弱引用缓存，暂时不使用的图片用 LruCache缓存，
 *       这一点是通过 图片引用计数器（acquired变量）来实现的。
 *
 *       磁盘缓存就是通过DiskLruCache实现的，根据缓存策略的不同会获取到不同类型的缓存图片。它
 *       的逻辑是：先从转换后的缓存中取；没有的话再从原始的（没有转换过的）缓存中拿数据；再没有的话就从网络加载图片数据，
 *       获取到数据之后，再依次缓存到磁盘和弱引用。
 *
 *       为什么Glide内存缓存要设计2层，弱引用和LruCache？
 *          这是一个朋友的理解 用弱引用缓存的资源都是当前活跃资源 activeRource，
 *          资源的使用频率比较高，这个时候如果从LruCache取资源，LinkHashmap查找资源的效率不是很高的。
 *          所以他会设计一个弱引用来缓存当前活跃资源，来替Lrucache减压。
 *
 *
 * Glide与Picasso的区别
 * LruCache原理
 * Retrofit源码流程,动态代理
 * LeakCanary弱引用,源码流程
 * Eventbus
 * Rxjava
 */
public class Doc2 {
}
