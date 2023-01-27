package demo.test;

/**
 * @author Zeng-WD
 * @date 10:14 2022/12/7
 */
public class Man extends Person<Woman> implements Runnable {

    {
        init();
    }

    @Override
    public void init() {
        getList().add(new Woman());
    }

    @Override
    public void run() {

    }
}
