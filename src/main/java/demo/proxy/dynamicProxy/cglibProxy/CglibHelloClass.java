package demo.proxy.dynamicProxy.cglibProxy;

/**
 * @author Zeng-WD
 * @date 14:09 2023/1/17
 * 委托类
 */
public class CglibHelloClass {
    public String sayHello(String userName) {
        System.out.println("目标对象的方法执行了");
        return userName + " sayHello";
    }

    public String sayByeBye(String userName) {
        System.out.println("目标对象的方法执行了");
        return userName + " sayByeBye";
    }
}
