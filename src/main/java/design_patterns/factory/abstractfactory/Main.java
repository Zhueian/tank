package design_patterns.factory.abstractfactory;


/**
 * @Auther: qiucy
 * @Date: 2019-06-17 20:58
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        //现代工厂
        AbstractFactory factory = new ModernFactory();
        Vehicle car = factory.createVehicle();
        Food bread = factory.createFood();
        Weapon akm = factory.createWeapon();
        //魔法工厂
        AbstractFactory factory2 = new MagicFactory();
        Vehicle broom = factory2.createVehicle();
        Food mushroom = factory2.createFood();
        Weapon magicStick = factory2.createWeapon();
        //火星工厂
    }
}
