package demo.callback;

import lombok.Data;

/**
 * @author Zeng-WD
 * @date 12:21 2022/12/23
 */
@Data
public class Student {
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public class doHomeWork implements doJob {
        @Override
        public void fillBlank(int a, int b, int result) {
            System.out.println(name + "求助小红计算:" + a + " + " + b + " = " + result);
        }
    }

    public void callHelp(int a, int b) {
        new SuperCalculator().add(a, b, new doHomeWork());
    }

}
