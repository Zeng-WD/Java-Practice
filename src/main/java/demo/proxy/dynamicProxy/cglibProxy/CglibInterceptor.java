package demo.proxy.dynamicProxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Zeng-WD
 * @date 14:11 2023/1/17
 * CglibInterceptor 用于对方法调用拦截以及回调
 */
public class CglibInterceptor implements MethodInterceptor {

    /**
     * CGLIB 增强类对象，代理类对象是由 Enhancer 类创建的
     * Enhancer 是 CGLIB 的字节码增强器，可以很方便的对类进行扩展
     */
    private final Enhancer enhancer = new Enhancer();

    /**
     * 使用动态代理创建一个代理对象
     */
    public Object newProxyInstance(Class<?> c) {
        // 设置产生的代理对象的父类
        enhancer.setSuperclass(c);
        // 定义代理逻辑对象为当前对象，要求当前对象实现 MethodInterceptor 接口
        enhancer.setCallback(this);
        // 使用默认无参数的构造函数创建目标对象，这是一个前提，被代理的类要提供无参构造方法
        return enhancer.create();
    }

    /**
     * @param o           被代理的对象
     * @param method      代理的方法
     * @param objects     方法的参数
     * @param methodProxy CGLIB方法代理对象
     * @return CGLIB生成用来代替Method对象的一个对象，使用MethodProxy比调用JDK自身的Method直接执行方法效率会有提升
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法调用前");
        Object obj = methodProxy.invokeSuper(o, objects);
        System.out.println("方法调用后");
        return obj;
    }

}
