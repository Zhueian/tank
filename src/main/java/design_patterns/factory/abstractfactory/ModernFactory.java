package design_patterns.factory.abstractfactory;

/**
 * @Auther: qiucy
 * @Date: 2019-06-17 21:57
 * @Description:
 */
public class ModernFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AKM();
    }
}
