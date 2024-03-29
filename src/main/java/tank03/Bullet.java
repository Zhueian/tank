package tank03;

import java.awt.*;

/**
 * @Auther: qiucy
 * @Date: 2019-06-09 12:47
 * @Description:
 */
public class Bullet {
    private static final int SPEED = 10;
    private int x,y;
    public static int WIDTH = ResoueceMgr.bulletD.getWidth(),HIGHT = ResoueceMgr.bulletD.getHeight();
    private Dir dir;
    private boolean live = true;
    TankFrame tf = null;
    private Group group = Group.BAD;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tankFrame;
    }
    public void paint(Graphics g){
        if (!live){
            tf.bullets.remove(this);
        }
//        Color color = g.getColor();
//        g.setColor(Color.RED);
//        g.fillOval(x,y,WIDTH,HIGHT);
//        g.setColor(color);
        switch (dir){
            case LEFT:
                g.drawImage(ResoueceMgr.bulletL,x,y,null);
                break;
            case UP:
                g.drawImage(ResoueceMgr.bulletU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResoueceMgr.bulletR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResoueceMgr.bulletD,x,y,null);
                break;
            default: break;
        }
        move();
    }

    private void move() {
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
//            default:break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HIGHT){
            live = false;
        }

    }
    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    // TODO 坦克之间碰撞检测也会死
    public void collideWith(Tank tank) {
        if (this.group ==tank.getGroup()) return;
        //TODO Rectangle 要写成single，记录子弹的位置，GC太频繁
        Rectangle bModel = new Rectangle(x,y,WIDTH,HIGHT);
        Rectangle tModel = new Rectangle(tank.getX(),tank.getY(),Tank.TANK_WIDTH,Tank.TANK_HIGHT);
        boolean isCollided = bModel.intersects(tModel);
        if (isCollided){
            this.die();
            tank.die();
        }

    }

    //FIXME 子弹连发打中的话画面有点不对劲
    private void die() {
        live = false;
    }
}
