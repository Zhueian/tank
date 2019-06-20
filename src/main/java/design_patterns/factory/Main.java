package design_patterns.factory;

/**
 * @Auther: qiucy
 * @Date: 2019-06-17 20:58
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Movable m = new Plane();
        m.go();
    }
}
