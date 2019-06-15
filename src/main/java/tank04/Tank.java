package tank04;

import java.awt.*;
import java.util.Random;

/**
 * @Auther: qiucy
 * @Date: 2019-06-09 11:58
 * @Description:
 */

public class Tank{
    private int x,y;

    private boolean live = true;

    private Random r = new Random();
    private Group group = Group.BAD;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private Dir dir = Dir.DOWN;
    private static final int SPEED = 4;
    private boolean moving = true;
    private TankFrame tankFrame = null;
    public static final int TANK_WIDTH = ResoueceMgr.tankD.getWidth(),TANK_HIGHT=ResoueceMgr.tankD.getHeight();

    public Tank(int x, int y, Dir dir,Group group, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;
    }
    public void paint(Graphics g) {
        if (!live) tankFrame.tanks.remove(this);
        switch (dir){
            case LEFT:
                g.drawImage(ResoueceMgr.tankL,x,y,null);
                break;
            case UP:
                g.drawImage(ResoueceMgr.tankU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResoueceMgr.tankR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResoueceMgr.tankD,x,y,null);
                break;
                default: break;
        }
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
        if (this.group == Group.BAD && r.nextInt(50)>47) this.fire();
        if (this.group==Group.BAD && r.nextInt(100)>93)  randomDir();
        boundCheck();
    }

    private void boundCheck() {
        if (this.x<2) x = 2;
        if (this.y<28) y=28;
        if (this.x>TankFrame.GAME_WIDTH-Tank.TANK_WIDTH-2) x=TankFrame.GAME_WIDTH-Tank.TANK_WIDTH-2;
        if (this.y>TankFrame.GAME_HIGHT-Tank.TANK_HIGHT-2) y=TankFrame.GAME_HIGHT-Tank.TANK_HIGHT-2;
    }

    private void randomDir() {
        this.dir = Dir.values()[r.nextInt(4)];
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void fire() {
        int bX = this.x+ Tank.TANK_WIDTH/2-Bullet.WIDTH/2;
        int bY = this.y+ Tank.TANK_HIGHT/2 - Bullet.HIGHT/2;
        tankFrame.bullets.add(new Bullet(bX,bY,dir,this.group,this.tankFrame));
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

    public void die() {
        this.live = false;
    }
}
