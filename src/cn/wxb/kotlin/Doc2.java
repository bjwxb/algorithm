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
 * 4.一个线程可以有几个Handler,几个Looper,几个MessageQueue对象
 * 5.Message对象创建的方式有哪些 & 区别？Message.obtain()怎么维护消息池的？
 * Handler 有哪些发送消息的方法
 * Handler的post与sendMessage的区别和应用场景
 * handler postDealy后消息队列有什么变化，假设先 postDelay 10s, 再postDelay 1s, 怎么处理这2条消息
 * MessageQueue是什么数据结构
 * Handler怎么做到的一个线程对应一个Looper，如何保证只有一个MessageQueue，ThreadLocal在Handler机制中的作用
 * HandlerThread是什么 & 好处 &原理 & 使用场景
 * IdleHandler及其使用场景
 * 消息屏障,同步屏障机制
 * 子线程能不能更新UI
 * 为什么Android系统不建议子线程访问UI
 * Android中为什么主线程不会因为Looper.loop()里的死循环卡死，MessageQueue#next 在没有消息的时候会阻塞，如何恢复？
 * Handler消息机制中，一个looper是如何区分多个Handler的，当Activity有多个Handler的时候，怎么样区分当前消息由哪个Handler处理，处理message的时候怎么知道是去哪个callback处理的
 * Looper.quit/quitSafely的区别
 * 通过Handler如何实现线程的切换
 * Handler 如何与 Looper 关联的
 * Looper 如何与 Thread 关联的
 * Looper.loop()源码
 * MessageQueue的enqueueMessage()方法如何进行线程同步的
 * MessageQueue的next()方法内部原理
 * 子线程中是否可以用MainLooper去创建Handler，Looper和Handler是否一定处于一个线程
 * ANR和Handler的联系
 * 6.View绘制
 * View绘制流程
 * MeasureSpec是什么
 * 子View创建MeasureSpec创建规则是什么
 * 自定义Viewwrap_content不起作用的原因
 * 在Activity中获取某个View的宽高有几种方法
 * 为什么onCreate获取不到View的宽高
 * View#post与Handler#post的区别
 * Android绘制和屏幕刷新机制原理
 * Choreography原理
 * 什么是双缓冲
 * 为什么使用SurfaceView
 * 什么是SurfaceView
 * View和SurfaceView的区别
 * SurfaceView为什么可以直接子线程绘制
 * SurfaceView、TextureView、SurfaceTexture、GLSurfaceView
 * getWidth()方法和getMeasureWidth()区别
 * invalidate() 和 postInvalidate() 的区别
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
 * onTouch 和onTouchEvent 的区别
 * ACTION_CANCEL什么时候触发
 * 事件是先到DecorView还是先到Window
 * 点击事件被拦截，但是想传到下面的View，如何操作
 * 如何解决View的事件冲突
 * 在 ViewGroup 中的 onTouchEvent 中消费 ACTION_DOWN 事件，ACTION_UP事件是怎么传递
 * Activity ViewGroup和View都不消费ACTION_DOWN,那么ACTION_UP事件是怎么传递的
 * 同时对父 View 和子 View 设置点击方法，优先响应哪个
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
 * APK的安装流程
 * 22.序列化
 * 什么是序列化
 * 为什么需要使用序列化和反序列化
 * 序列化的有哪些好处
 * Serializable 和 Parcelable 的区别
 * 什么是serialVersionUID
 * 为什么还要显示指定serialVersionUID的值?
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
 * Glide缓存机制,内存缓存，磁盘缓存
 * Glide与Picasso的区别
 * LruCache原理
 * Retrofit源码流程,动态代理
 * LeakCanary弱引用,源码流程
 * Eventbus
 * Rxjava
 */
public class Doc2 {
}
