package jdk8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @Auther: qiucy
 * @Date: 2019-06-18 23:15
 * @Description:
 */
public class SteamTest {
    public static void main(String[] args) {
//        List<Integer> l = Arrays.asList(1,2,3,4,5,5,6,6,7,8,90);
//        for (int i = 0; i < l.size(); i++) {
//            System.out.print(l.get(i));
//        }
//        System.out.println();
//        System.out.println("===============1");
//        for (Integer integer : l) {
//            System.out.print(integer);
//        }
//        System.out.println();
//        System.out.println("===============2");
//        l.stream().forEach((i)->{
//            System.out.print(i);
//        });
//        System.out.println();
//        System.out.println("===============3");
//        l.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.print(integer);
//            }
//        });
//        System.out.println();
//        System.out.println("===============4");
//        l.forEach((i)->{
//            System.out.print(i);
//        });
        test();
    }
    public static void test(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        strings.stream().filter(string->!string.isEmpty()).collect(Collectors.toList());
        System.out.println(strings);

        Random random = new Random();
        random.ints(4).limit(10).forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> collect = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println(collect);

        long count = strings.stream().filter(s -> s.isEmpty()).count();
        System.out.println(count);

        random.ints(4).sorted().forEach((System.out::println));

        long count1 = strings.parallelStream().filter(s -> s.isEmpty()).count();
        System.out.println(count1);

        String merget = strings.parallelStream().filter(s -> !s.isEmpty()).collect(Collectors.joining("!"));
        System.out.println(merget);

        IntSummaryStatistics sts = numbers.parallelStream().distinct().mapToInt(x -> x).summaryStatistics();
        System.out.println("max:"+sts.getMax());
        System.out.println("min:"+sts.getMin());
        System.out.println("avg:"+sts.getAverage());
        System.out.println("sum:"+sts.getSum());
        System.out.println("count:"+sts.getCount());
    }
}
