package design_patterns.factory.abstractfactory;

/**
 * @Auther: qiucy
 * @Date: 2019-06-17 21:49
 * @Description:
 */
public abstract class AbstractFactory {
    abstract Food createFood();
    abstract Vehicle createVehicle();
    abstract Weapon createWeapon();
}
