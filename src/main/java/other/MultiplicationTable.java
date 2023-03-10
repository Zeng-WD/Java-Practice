package other;

/**
 * @author Zeng-WD 406927572@qq.com
 * @date 2023/3/10 16:41
 * @Description
 */
public class MultiplicationTable {

    public static void main(String[] args) {
        MultiplicationTable.printMultiplicationTable();
    }

    public static void printMultiplicationTable() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " * " + i + " = " + i * j + '\t');
            }
            System.out.println();
        }
    }

}
