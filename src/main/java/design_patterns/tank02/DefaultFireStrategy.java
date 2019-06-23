package design_patterns.tank02;

/**
 * @Auther: qiucy
 * @Date: 2019-06-16 19:23
 * @Description:
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.getX()+ Tank.TANK_WIDTH/2- Bullet.WIDTH/2;
        int bY = t.getY()+ Tank.TANK_HIGHT/2 - Bullet.HIGHT/2;
        new Bullet(bX,bY,t.getDir(),t.getGroup(),t.gm);
        if (t.getGroup() == Group.GOOD)
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
    }
}
