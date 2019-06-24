package design_patterns.tank02.cor;

import design_patterns.tank02.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: qiucy
 * @Date: 2019-06-24 00:38
 * @Description:
 */
public class ColliderChain implements Collider{
    /**
     * 没有查询操作，即是通过index偏移量来取值，而且linked空间利用率高。
     */
    private List<Collider> colliders = new LinkedList<>();
    public void add(Collider c){
        colliders.add(c);
    }

    public ColliderChain() {
        add(new BulletTankCollider());
        add(new TankTankCollider());
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        //第一个链点要是碰撞了，就die了，就没必要走下一个链点了，否则会有不可预知的bug
        for (int i = 0; i < colliders.size(); i++) {
            if(!colliders.get(i).collide(o1,o2)) return false;
        }
        return true;
    }
}
