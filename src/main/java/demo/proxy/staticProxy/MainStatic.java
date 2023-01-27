package demo.proxy.staticProxy;

/**
 * @author Zeng-WD
 * @date 11:22 2023/1/12
 * 测试静态代理类
 */
public class MainStatic {
    public static void main(String[] args) {
        StaticProxyHello staticProxyHello = new StaticProxyHello();
        staticProxyHello.sayHello("wade");
    }
}
