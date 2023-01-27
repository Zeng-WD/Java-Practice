package demo;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Zeng-WD
 * @date 17:42 2023/1/17
 */
@RunWith(JUnit4.class)
public class JUnitDemo {

    @Test
    public void listToArray() {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        System.out.println(Arrays.toString(arr.stream().mapToInt(Integer::valueOf).toArray()));
    }

    @Test
    public void arrayToList() {
        int[] arr = {1, 2, 3};
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(arrList);
//        String[] arr = {"你", "我", "他"};
//        List<String> arrList = new ArrayList<>(Arrays.asList(arr));
//        System.out.println(arrList);
    }

    @Test
    public void bloomFilterTest() {
        int total = 1_000_000; // 总数量
        BloomFilter<CharSequence> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), total, 0.01);
        // 初始化 1000000 条数据到过滤器中
        for (int i = 0; i < total; i++) {
            bf.put("" + i);
        }
        // 判断值是否存在过滤器中
        int count = 0;
        for (int i = 0; i < total + 10_000; i++) {
            if (bf.mightContain("" + i)) {
                count++;
            }
        }
        System.out.println("已匹配数量 " + count);

    }

    @Test
    public void subListTest() {
        List<String> arrayList = new ArrayList<String>() {{
            add("one");
            add("two");
            add("three");
        }};
//        ArrayList<String> strings = (ArrayList<String>) arrayList.subList(0, 1);
        List<String> collect = arrayList.stream().skip(1).limit(1).collect(Collectors.toList());
        System.out.println(collect);

    }

    @Test
    public void readFile() {
        // 默认相对路径是src
        String filePath = "./text/test.txt";
//        File file = new File(filePath);
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            String s;
//            while ((s = br.readLine()) != null) {
//                System.out.println(s);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

