package tank02_1;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Auther: qiucy
 * @Date: 2019-06-05 21:01
 * @Description:
 */
public class TankFrame extends Frame {
    static final int GAME_WIDTH = 600;
    static final int GAME_HIGHT = 600;
    //TODO 无界队列
    List<Tank> Enemys = new ArrayList<Tank>();
    static Random r = new Random();
    {
        for (int i = 0; i < 20; i++) {
            Enemys.add(new Tank(r.nextInt(GAME_HIGHT-Tank.TANK_HIGHT),r.nextInt(GAME_WIDTH-Tank.TANK_WIDTH),Dir.DOWN,this));
        }
    }
    Tank myTank = new Tank(300,300, Dir.DOWN,this);
    List<Bullet> bullets = new ArrayList<Bullet>();
    Bullet bullet = new Bullet(300,300, Dir.UP,this);


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
    Image offScreenImage = null;
    @Override
    public void update(Graphics g){
        if (offScreenImage == null) offScreenImage = this.createImage(GAME_WIDTH,GAME_HIGHT);
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color color = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HIGHT);
        gOffScreen.setColor(color);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }
    @Override
    public void paint(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.white);
        g.drawString("子弹数量"+bullets.size(),10,60);
        g.setColor(color);
        myTank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
        for (int i = 0; i < Enemys.size(); i++) {
            Enemys.get(i).paint(g);
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
