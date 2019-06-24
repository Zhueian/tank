package design_patterns.tank02.cor;

import design_patterns.tank02.Bullet;
import design_patterns.tank02.Explode;
import design_patterns.tank02.GameObject;
import design_patterns.tank02.Tank;

/**
 * @Auther: qiucy
 * @Date: 2019-06-23 23:31
 * @Description:
 */
public class BulletTankCollider implements Collider {
    /**
     * 有点servlet的doGet() doPost()的味道了
     * @param o1
     * @param o2
     */
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank){
            Bullet b = (Bullet)o1;
            Tank t = (Tank)o2;
            if (b.getGroup() == t.getGroup()) return true;
            if (b.rectangle.intersects(t.getRectangle())){
                t.die();
                b.die();
                int eX = t.getX() + Tank.TANK_WIDTH/2 - Explode.WIDTH/2;
                int eY = t.getY() + Tank.TANK_HIGHT/2 - Explode.HIGHT/2;
                new Explode(eX, eY);
                return false;
            }
        }else if (o2 instanceof Bullet && o1 instanceof Tank){
            return collide(o2,o1);
        }
        return true;
    }
}
