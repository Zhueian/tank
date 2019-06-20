package design_patterns.factory;

/**
 * @Auther: qiucy
 * @Date: 2019-06-17 21:17
 * @Description:
 */
public class CarFactory {
    public Movable create(){
        System.out.println("create a car");
        return new Car();
    }
}
