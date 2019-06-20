package design_patterns.factory.abstractfactory;

import design_patterns.factory.Movable;

/**
 * @Auther: qiucy
 * @Date: 2019-06-17 20:58
 * @Description:
 */
public class Car extends Vehicle{
    @Override
    public void go(){
        System.out.println("car go...");
    }
}
