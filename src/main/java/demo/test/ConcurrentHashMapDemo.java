package demo.test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Zeng-WD 406927572@qq.com
 * @date 2024/7/14 下午6:24
 * @Description
 */
public class ConcurrentHashMapDemo {
    private static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                if (i % 2 == 0) {
//                    map.put("countTwo", map.getOrDefault("countTwo", 0) + 1);
                    map.merge("countTwo", 1, Integer::sum);
                }
                if (i % 3 == 0) {
//                    map.put("countThree", map.getOrDefault("countThree", 0) + 1);
                    map.merge("countThree", 1, Integer::sum);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                if (i % 2 == 0) {
//                    map.put("countTwo", map.getOrDefault("countTwo", 0) + 1);
                    map.merge("countTwo", 1, Integer::sum);
                }
                if (i % 3 == 0) {
//                    map.put("countThree", map.getOrDefault("countThree", 0) + 1);
                    map.merge("countThree", 1, Integer::sum);
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("countTow: " + map.get("countTwo"));
        System.out.println("countThree: " + map.get("countThree"));
    }


}
