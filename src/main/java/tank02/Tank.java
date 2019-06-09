package tank02;

import java.awt.*;

/**
 * @Auther: qiucy
 * @Date: 2019-06-09 11:58
 * @Description:
 */

public class Tank{
    //private set/get 能控制属性可以读写权限的开放切换
    private int x,y;
    private Dir dir =Dir.DOWN;
    private static final int SPEED = 1;
    private boolean moving = false;
    private TankFrame tankFrame = null;
    private static final int TANK_WIDTH = 29;
    private static final int TANK_HIGHT = 29;

    public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }
    //tank最知道怎么画自己，封装设计的思想
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.GREEN);
        g.fillRect(x,y,TANK_WIDTH,TANK_HIGHT);
        g.setColor(color);
        move();
        //这里有点意思
//        g.fillRect(x,y,30,30);
    }

    private void move() {
        if (!moving) return;
        switch (dir){
            case LEFT:
                x-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
            default:break;
        }
    }

    public void fire() {
        switch (dir){
            case LEFT:
                tankFrame.bullets.add(new Bullet(this.x, this.y+(TANK_HIGHT/2), this.dir,this.tankFrame));
                break;
            case RIGHT:
                tankFrame.bullets.add(new Bullet(this.x+TANK_WIDTH, y+(TANK_HIGHT/2), this.dir,this.tankFrame));
                break;
            case UP:
                tankFrame.bullets.add(new Bullet(this.x+(TANK_WIDTH/2), this.y, this.dir,this.tankFrame));
                break;
            case DOWN:
                tankFrame.bullets.add(new Bullet(this.x+(TANK_WIDTH/2), this.y+TANK_HIGHT, this.dir,this.tankFrame));
                break;
            default:break;
        }
//         tankFrame.bullets.add(new Bullet(this.x, this.y, this.dir,this.tankFrame));
//        tankFrame.bullet = new Bullet(this.x, this.y, this.dir);
    }
    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}
