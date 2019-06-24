package design_patterns.tank02.cor;

import design_patterns.tank02.Bullet;
import design_patterns.tank02.GameObject;
import design_patterns.tank02.Tank;
import design_patterns.tank02.Wall;

/**
 * @Auther: qiucy
 * @Date: 2019-06-23 23:31
 * @Description:
 */
public class BulletWallCollider implements Collider {
    /**
     * 有点servlet的doGet() doPost()的味道了
     * @param o1
     * @param o2
     */
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall){
            Bullet b  =(Bullet)o1;
            Wall w = (Wall)o2;
            //TODO 把collideWith copy
            if (b.rectangle.intersects(w.rect)){
                b.die();
            }
        }else if (o2 instanceof Bullet && o1 instanceof Wall){
            return collide(o2,o1);
        }
        return true;
    }
}
