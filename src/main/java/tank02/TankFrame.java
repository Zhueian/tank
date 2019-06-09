package tank02;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: qiucy
 * @Date: 2019-06-05 21:01
 * @Description:
 */
public class TankFrame extends Frame {
//    int x = 300,y=300;
//    Dir dir = Dir.DOWN;
//    //这种内部用的没必要每个对象都初始化一次，而且是外部不用不被改变的值
//    private static final int SPEED = 1;
    Tank myTank = new Tank(300,300,Dir.DOWN,this);
    List<Bullet> bullets = new ArrayList<Bullet>();
    Bullet bullet = new Bullet(300,300,Dir.UP,this);
    static final int GAME_WIDTH = 600;
    static final int GAME_HIGHT = 600;

    public TankFrame(){
        this.setSize(GAME_WIDTH,GAME_HIGHT);
        setResizable(false);
        setTitle("tank war!");
        setVisible(true);
        addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new MyKeyListener());
    }
    //解决刷缓冲闪烁问题,游戏概念。
    //画面刷新特别快，但是源码计算逻辑cpu跟不上。
    //比如说一个特高清大图，屏幕是一条条刷新的。
    //直接在内存创建一个buffer，一次性从内存刷出到显存。
    //一般做游戏开发这部分都封装到游戏引擎

    //内存定一个图片，还没画出来
    Image offScreenImage = null;
    // update() 在 paint() 前调用
    @Override
    public void update(Graphics g){
        //用画笔把背景重新画一遍
        if (offScreenImage == null) offScreenImage = this.createImage(GAME_WIDTH,GAME_HIGHT);
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color color = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HIGHT);
        gOffScreen.setColor(color);
        //tank画画逻辑
        paint(gOffScreen);
        //最后画到屏幕
        g.drawImage(offScreenImage,0,0,null);
    }
    @Override
    public void paint(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.white);
        g.drawString("子弹适量"+bullets.size(),10,60);
        g.setColor(color);
        myTank.paint(g);
//        bullet.paint(g);
        // java.util.ConcurrentModificationException
//        for (Bullet b: bullets){
//            b.paint(g);
//        }
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
    }

    class MyKeyListener extends KeyAdapter{
        Boolean bL = false;
        Boolean bU = false;
        Boolean bR = false;
        Boolean bD = false;
        //TODO break去掉，枚举加四个斜线方向。
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            //设置主战坦克方向
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;

                case KeyEvent.VK_SPACE:
                    myTank.fire();
                    break;

                default:
                    break;
            }
            //设置主战坦克方向
            setMainTankDir();
        }
        private void setMainTankDir(){
            if (!bL && !bU && !bD && !bR) myTank.setMoving(false);
            else {
                myTank.setMoving(true);
                if (bL) myTank.setDir(Dir.LEFT);
                if (bR) myTank.setDir(Dir.RIGHT);
                if (bU) myTank.setDir(Dir.UP);
                if (bD) myTank.setDir(Dir.DOWN);
            }
        }

    }
}
