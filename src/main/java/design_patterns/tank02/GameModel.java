package design_patterns.tank02;

import design_patterns.tank02.cor.BulletTankCollider;
import design_patterns.tank02.cor.Collider;
import design_patterns.tank02.cor.ColliderChain;
import design_patterns.tank02.cor.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Auther: qiucy
 * @Date: 2019-06-23 21:43
 * @Description:
 */
public class GameModel {
    //TODO 单例改造
    private static GameModel gameModel = new GameModel();
    public static GameModel getGameModel(){
        return gameModel;
    }
    /**
     * gameModel既是门面fcade对外，也是调停者mediator对内
     */
    Tank myTank;

//    List<Bullet> bullets = new ArrayList<Bullet>();
    //    List<Tank> tanks = new ArrayList<Tank>();
//    List<Explode> explodes = new ArrayList<>();

    ColliderChain chain = new ColliderChain();


    private List<GameObject> objects = new ArrayList<>();

    private GameModel() {
        myTank = new Tank(300,300, Dir.DOWN, Group.GOOD);

        Random r = new Random();
        int initTankCount = Integer.parseInt(PropertyMgr.get("initTankCount")+"");
        for (int i = 0; i < initTankCount; i++) {
            add(new Tank(r.nextInt(TankFrame.GAME_WIDTH- Tank.TANK_WIDTH),
                    r.nextInt(TankFrame.GAME_HIGHT- Tank.TANK_HIGHT), Dir.DOWN, Group.BAD));
        }
        //初始化墙
        add(new Wall(50,50,90,90));
        add(new Wall(50,300,500,80));
        add(new Wall(50,50,600,600));
        add(new Wall(350,50,50,500));
    }

    public void add(GameObject go){this.objects.add(go);}
    public void remove(GameObject go){this.objects.remove(go);}

    public void paint(Graphics g) {
        Color color = g.getColor();
//        g.setColor(Color.white);
//        g.drawString("此时此刻子弹数量："+bullets.size(),5,40);
//        g.setColor(Color.red);
//        g.drawString("此时此刻敌人数量："+tanks.size(),5,60);
//        g.setColor(Color.yellow);
//        g.drawString("此时此刻爆炸数量："+explodes.size(),5,80);
        g.setColor(color);
        myTank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }
        //碰撞检测
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i+1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                chain.collide(o1,o2);
            }
        }
        //collision detect
//        for (int i = 0; i < bullets.size(); i++){
//            for (int j = 0;j < tanks.size();j++){
//                bullets.get(i).collideWith(tanks.get(j));
//            }
//        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
