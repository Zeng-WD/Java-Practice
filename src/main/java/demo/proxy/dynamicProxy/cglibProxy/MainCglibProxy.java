package demo.proxy.dynamicProxy.cglibProxy;

/**
 * @author Zeng-WD
 * @date 14:48 2023/1/17
 */
public class MainCglibProxy {

    public static void main(String[] args) {
        CglibInterceptor cglibInterceptor = new CglibInterceptor();
        CglibHelloClass cglibHelloClass = (CglibHelloClass) cglibInterceptor.newProxyInstance(CglibHelloClass.class);
        cglibHelloClass.sayHello("wade");
        cglibHelloClass.sayByeBye("wade");
    }

}
