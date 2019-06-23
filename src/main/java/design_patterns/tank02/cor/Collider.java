package design_patterns.tank02.cor;

import design_patterns.tank02.GameObject;

/**
 * @Auther: qiucy
 * @Date: 2019-06-23 23:27
 * @Description:
 */
public interface Collider {
    boolean collide(GameObject o1,GameObject o2);
}
