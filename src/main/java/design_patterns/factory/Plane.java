package design_patterns.factory;

/**
 * @Auther: qiucy
 * @Date: 2019-06-17 20:57
 * @Description:
 */
public class Plane implements Movable{
    @Override
    public void go(){
        System.out.println("plane flying..");
    }
}
