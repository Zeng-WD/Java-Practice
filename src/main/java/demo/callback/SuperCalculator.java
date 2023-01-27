package demo.callback;

/**
 * @author Zeng-WD
 * @date 12:20 2022/12/23
 */
public class SuperCalculator {

    public void add(int a, int b, doJob customer) {
        int result = a + b;
        customer.fillBlank(a, b, result);
    }

}
