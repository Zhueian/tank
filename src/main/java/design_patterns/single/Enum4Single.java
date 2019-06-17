package design_patterns.single;

/**
 * @Auther: qiucy
 * @Date: 2019-06-16 01:31
 * @Description:effective java 创始人之一
 *  懒加载，线程安全, 防止反序列化:
 *      TODO java能用class文件反射出new instance，不能挡住反射new实例；
 *              枚举类没构造方法，其反序列化返回的还是同一个instance；
 *              反编译之后枚举十个abstrace class，无构造器，无法实例
 */
public enum  Enum4Single {
    INSTANCE;
    public void m(){}
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->
                    System.out.println(
                            Thread.currentThread().getName()
                            +"::"
                            +Enum4Single.INSTANCE.hashCode()
                    )).start();
        }
    }
}
