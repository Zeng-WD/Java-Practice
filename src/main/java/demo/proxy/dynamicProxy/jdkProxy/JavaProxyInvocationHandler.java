package demo.proxy.dynamicProxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Zeng-WD
 * @date 11:47 2023/1/17
 * 中间类
 */
public class JavaProxyInvocationHandler implements InvocationHandler {

    /**
     * 中间类持有委托类对象的引用，这里会构建成一种静态代理关系
     */
    private final Object obj;

    /**
     * 有参构造，传入委托类的对象
     */
    public JavaProxyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    /**
     * 动态生成代理类对象，Proxy.newProxyInstance
     *
     * @return 返回代理类对象爱那个
     */
    public Object newProxyInstance() {
        return Proxy.newProxyInstance(
                // 指定代理对象的类加载器
                obj.getClass().getClassLoader(),
                // 代理对象需要实现的接口，可以同时指定多个接口
                obj.getClass().getInterfaces(),
                // 方法调用的实际处理者，代理对象的方法调用全部都会转发到这里
                this);
    }

    /**
     * 调用处理
     *
     * @param proxy  代理类对象
     * @param method 标识具体调用的是代理类的哪个方法
     * @param args   代理类方法的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke before");
        Object result = method.invoke(obj, args);
        System.out.println("invoke after");
        return result;
    }
}
