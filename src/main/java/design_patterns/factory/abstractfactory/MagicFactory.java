package design_patterns.factory.abstractfactory;

/**
 * @Auther: qiucy
 * @Date: 2019-06-17 21:58
 * @Description:
 */
public class MagicFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
