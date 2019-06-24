package design_patterns.tank02;

import java.awt.*;

/**
 * @Auther: qiucy
 * @Date: 2019-06-09 12:47
 * @Description:
 */
public class Bullet extends GameObject{
    private static final int SPEED = 5;
    private int x,y;

    public Rectangle rectangle = new Rectangle();

    public static int WIDTH = ResoueceMgr.bulletD.getWidth(),HIGHT = ResoueceMgr.bulletD.getHeight();
    private Dir dir;
    private boolean live = true;
//    TankFrame tf = null;
//    GameModel gm = null;
    private Group group = Group.BAD;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    //gm单例耦合度又降低一级
    public Bullet(int x, int y, Dir dir, Group group/*, GameModel gm*/) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
//        this.gm = gm;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HIGHT;

        GameModel.getGameModel().add(this);
    }
    public void paint(Graphics g){
        if (!live){
//            gm.remove(this);
            GameModel.getGameModel().remove(this);
        }
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

        rectangle.x = this.x;
        rectangle.y = this.y;

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

//    public boolean collideWith(Tank tank) {
//        if (this.group ==tank.getGroup()) return false;
//        boolean isCollided = rectangle.intersects(tank.rectangle);
//        if (isCollided){
//            this.die();
//            tank.die();
//            int eX = tank.getX() + Tank.TANK_HIGHT/2 - Explode.WIDTH/2;
//            int eY = tank.getY() + Tank.TANK_HIGHT/2 - Explode.HIGHT/2;
//            gm.add(new Explode(eX, eY, gm));
//            return true;
//        }
//        return false;
//    }

    public void die() {
        live = false;
    }
}
