package jdk8;

import java.util.Optional;

/**
 * @Auther: qiucy
 * @Date: 2019-06-19 14:08
 * @Description:
 */
public class OptionalTest {
    public static void main(String[] args) {
        OptionalTest test = new OptionalTest();
        Integer v1 = null;
        Integer v2 = null;
        Optional<Integer> op1 = Optional.ofNullable(v1);
        Optional<Integer> op2 = Optional.ofNullable(v2);
        System.out.println(op1.isPresent());
        System.out.println(op2.isPresent());

    }
}
