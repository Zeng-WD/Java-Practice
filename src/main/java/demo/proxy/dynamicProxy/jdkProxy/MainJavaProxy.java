package demo.proxy.dynamicProxy.jdkProxy;

/**
 * @author Zeng-WD
 * @date 12:02 2023/1/17
 */
public class MainJavaProxy {
    public static void main(String[] args) {
        JavaProxyInvocationHandler proxyInvocationHandler = new JavaProxyInvocationHandler(new HelloService());
        IHelloService helloService = (IHelloService) proxyInvocationHandler.newProxyInstance();
        helloService.sayHello("wade");
        helloService.sayByeBye("wade");
    }
}
