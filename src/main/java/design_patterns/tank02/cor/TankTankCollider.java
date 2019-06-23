package design_patterns.tank02.cor;

import design_patterns.tank02.Bullet;
import design_patterns.tank02.GameObject;
import design_patterns.tank02.Tank;

/**
 * @Auther: qiucy
 * @Date: 2019-06-23 23:31
 * @Description:
 */
public class TankTankCollider implements Collider {
    /**
     * 有点servlet的doGet() doPost()的味道了
     * @param o1
     * @param o2
     */
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank){
            Tank t1  =(Tank)o1;
            Tank t2 = (Tank)o2;
            if (t1.getRectangle().intersects(t2.getRectangle())){
                t1.stop();
//                t2.stop();
            }
        }
            return true;
    }
}
