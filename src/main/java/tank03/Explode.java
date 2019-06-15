package tank03;

import java.awt.*;

/**
 * @Auther: qiucy
 * @Date: 2019-06-15 15:24
 * @Description:
 */
public class Explode {
    public static int WIDTH = ResoueceMgr.explodes[0].getWidth();
    public static int HIGHT = ResoueceMgr.explodes[0].getHeight();
    private int x,y;
    private boolean live = true;
    TankFrame tf = null;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Audio("Audio/explode.wav").play();
    }

    private int boomStep = 0;


    public void paint(Graphics g){
        g.drawImage(ResoueceMgr.explodes[boomStep++],x,y,null);
        if (boomStep >= ResoueceMgr.explodes.length) boomStep = 0;
    }
}
