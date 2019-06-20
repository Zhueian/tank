package jdk8;

/**
 * @Auther: qiucy
 * @Date: 2019-06-18 23:25
 * @Description:
 */
@FunctionalInterface
 interface Test_FunctionInterface {
    /**
     * qweqw
     */
    @Override
    String toString();

    /**
     * adsa
     */
    void test();
//    void wait();
//    void tets2();
}

public class Test4FunctionInterface{
   void t(Test_FunctionInterface a){
      System.out.println("1");
      a.test();
      System.out.println("2");
   }
   public static void main(String[] args) {
      Test4FunctionInterface t = new Test4FunctionInterface();
      t.t(()->{
         System.out.println("mytest4interfaceTestMethod");
      });
   }
}

