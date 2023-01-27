package demo.test;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeng-WD
 * @date 10:14 2022/12/7
 */
@Data
public abstract class Person<T> {

    private String name;

    private int age;

    private List<T> list = new ArrayList<>();

    protected static String mail;

    public abstract void init();

}
