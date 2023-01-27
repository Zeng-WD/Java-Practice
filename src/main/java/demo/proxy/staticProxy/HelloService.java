package demo.proxy.staticProxy;

/**
 * @author Zeng-WD
 * @date 11:20 2023/1/12
 * 委托实现类
 */
public class HelloService implements IHelloService {
    @Override
    public String sayHello(String userName) {
        System.out.println("helloService " + userName);
        return "HelloService " + userName;
    }
}
