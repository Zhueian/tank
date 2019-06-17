package design_patterns.single;

/**
 * @Auther: qiucy
 * @Date: 2019-06-16 01:27
 * @Description:
 */
public class Inner4Single {
    private Inner4Single(){}
    //外部类加载时候，内部类不加载来进行懒加载
    private static class Inner{
        //JVM保证static Class对象唯一
        private final static Inner4Single instance = new Inner4Single();
    }

    public static Inner4Single getInstance(){
        return Inner.instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->
                    System.out.println(Thread.currentThread().getName()+"::"+Inner4Single.getInstance().hashCode())).start();
        }
    }
}
