package design_patterns.tank02;

import java.awt.*;

/**
 * @Auther: qiucy
 * @Date: 2019-06-15 15:24
 * @Description:
 */
public class Explode extends GameObject {
    public static int WIDTH = ResoueceMgr.explodes[0].getWidth();
    public static int HIGHT = ResoueceMgr.explodes[0].getHeight();
    private int x,y;
//    private boolean live = true;
//    TankFrame tf = null;
    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
       GameModel.getGameModel().add(this);
        new Thread(()->{
            new Audio("Audio/explode.wav").play();
        }).start();

    }

    private int boomStep = 0;

    @Override
    public void paint(Graphics g){
        g.drawImage(ResoueceMgr.explodes[boomStep++],x,y,null);
        if (boomStep >= ResoueceMgr.explodes.length) GameModel.getGameModel().remove(this);
    }
}
