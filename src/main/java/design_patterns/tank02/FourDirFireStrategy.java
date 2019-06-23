package design_patterns.tank02;

/**
 * @Auther: qiucy
 * @Date: 2019-06-16 19:40
 * @Description:
 */
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.getX()+ Tank.TANK_WIDTH/2- Bullet.WIDTH/2;
        int bY = t.getY()+ Tank.TANK_HIGHT/2 - Bullet.HIGHT/2;
        Dir[] dirs = Dir.values();
        for (Dir d:dirs){
            new Bullet(bX,bY,d,t.getGroup(),t.gm);
        }
        if (t.getGroup() == Group.GOOD)
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();

    }
}
