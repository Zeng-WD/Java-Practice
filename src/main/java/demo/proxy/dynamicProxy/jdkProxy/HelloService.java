package demo.proxy.dynamicProxy.jdkProxy;

/**
 * @author Zeng-WD
 * @date 11:53 2023/1/17
 */
public class HelloService implements IHelloService {
    @Override
    public String sayHello(String userName) {
        System.out.println(userName + " hello");
        return userName + " hello";
    }

    @Override
    public String sayByeBye(String userName) {
        System.out.println(userName + " ByeBye");
        return userName + " ByeBye";
    }
}
