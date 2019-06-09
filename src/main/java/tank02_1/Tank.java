package tank02_1;

import java.awt.*;

/**
 * @Auther: qiucy
 * @Date: 2019-06-09 11:58
 * @Description:
 */

public class Tank{
    private int x,y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 1;
    private boolean moving = false;
    private TankFrame tankFrame = null;
     static final int TANK_WIDTH = 20;
     static final int TANK_HIGHT = 20;

    public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.GREEN);
        g.fillRect(x,y,TANK_WIDTH,TANK_HIGHT);
        g.setColor(color);
        move();
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
