import org.checkerframework.checker.units.qual.A;
import struct.AVLTree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Zeng-WD
 * @date 23:42 2020/12/15
 */
public class Test {


    public static void main(String[] args) throws InterruptedException {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(4);
        tree.add(33);
        tree.add(21);
        tree.add(66);
        tree.add(100);
        tree.inPrevOrder();
    }

}
