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
        //没必要线程池了，线程池的创建不仅限线程！
        new Thread(()->{
            new Audio("Audio/explode.wav").play();
        }).start();

    }

    private int boomStep = 0;


    public void paint(Graphics g){
        g.drawImage(ResoueceMgr.explodes[boomStep++],x,y,null);
        if (boomStep >= ResoueceMgr.explodes.length) boomStep = 0;
    }
}
