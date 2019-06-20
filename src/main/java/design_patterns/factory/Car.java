package design_patterns.factory;

/**
 * @Auther: qiucy
 * @Date: 2019-06-17 20:58
 * @Description:
 */
public class Car implements Movable{
    @Override
    public void go(){
        System.out.println("car go...");
    }
}
