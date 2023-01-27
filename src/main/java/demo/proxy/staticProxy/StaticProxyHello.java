package demo.proxy.staticProxy;

/**
 * @author Zeng-WD
 * @date 11:20 2023/1/12
 * 代理类
 */
public class StaticProxyHello implements IHelloService {
    private IHelloService helloService = new HelloService();

    @Override
    public String sayHello(String userName) {
        // 代理对象可以在此处包装一下
        System.out.println("代理对象包装礼盒...");
        return helloService.sayHello(userName);
    }
}
