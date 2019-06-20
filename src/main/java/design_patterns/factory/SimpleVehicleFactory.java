package design_patterns.factory;

/**
 * @Auther: qiucy
 * @Date: 2019-06-17 21:13
 * @Description:简单工厂，可扩展性不好。
 */
public class SimpleVehicleFactory {
    public Car createCar(){
        //TODO 权限，日志等等前置方法
        return new Car();
    }
    public Plane createPlane(){
        //TODO 权限，日志等等前置方法
        return new Plane();
    }
}
