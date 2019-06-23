package design_patterns.tank02;

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
//    private static GameModel gameModel = new GameModel();
//    private GameModel(){}
//    public static GameModel getGameModel(){
//        return gameModel;
//    }

    java.util.List<Tank> tanks = new ArrayList<Tank>();
    Tank myTank = new Tank(300,300, Dir.DOWN, Group.GOOD,this);
    java.util.List<Bullet> bullets = new ArrayList<Bullet>();
    List<Explode> explodes = new ArrayList<>();

    public GameModel() {
        Random r = new Random();
        int initTankCount = Integer.parseInt(PropertyMgr.get("initTankCount")+"");
        for (int i = 0; i < initTankCount; i++) {
            tanks.add(new Tank(r.nextInt(TankFrame.GAME_WIDTH- Tank.TANK_WIDTH),
                    r.nextInt(TankFrame.GAME_HIGHT- Tank.TANK_HIGHT), Dir.DOWN, Group.BAD,this));
        }
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.white);
        g.drawString("此时此刻子弹数量："+bullets.size(),5,40);
        g.setColor(Color.red);
        g.drawString("此时此刻敌人数量："+tanks.size(),5,60);
        g.setColor(Color.yellow);
        g.drawString("此时此刻爆炸数量："+explodes.size(),5,80);
        g.setColor(color);
        myTank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
        for (int i = 0;i < tanks.size();i++){
            tanks.get(i).paint(g);
        }
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }
        //collision detect
        for (int i = 0; i < bullets.size(); i++){
            for (int j = 0;j < tanks.size();j++){
                bullets.get(i).collideWith(tanks.get(j));
            }
        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
