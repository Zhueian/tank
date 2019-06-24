package design_patterns.tank02;

import java.awt.*;
import java.util.Random;

/**
 * @Auther: qiucy
 * @Date: 2019-06-09 11:58
 * @Description:
 */

public class Tank extends GameObject{
    private int x,y;
    int prevX,prevY;

    private boolean live = true;

    private Random r = new Random();
    private Group group = Group.BAD;

    Rectangle rectangle = new Rectangle();

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
    public Rectangle getRectangle() {
        return rectangle;
    }


    private Dir dir = Dir.DOWN;
    private static final int SPEED = 1;
    private boolean moving = true;
    TankFrame tankFrame = null;
    public static final int TANK_WIDTH = ResoueceMgr.tankD.getWidth(),TANK_HIGHT= ResoueceMgr.tankD.getHeight();

//    FireStrategy fs = new DefaultFireStrategy();
    FireStrategy fs;
//    GameModel gm;
//    FireStrategy fs = new FourDirFireStrategy();

    public Tank(int x, int y, Dir dir, Group group/*, GameModel gm*/) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
//        this.gm = gm;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = Tank.TANK_WIDTH;
        rectangle.height = Tank.TANK_HIGHT;

        if (this.getGroup() == Group.GOOD) fs = new FourDirFireStrategy();
        else fs = new DefaultFireStrategy();
//        GameModel.getGameModel().add(this);
    }
    @Override
    public void paint(Graphics g) {
        if (!live) GameModel.getGameModel().remove(this);
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
        prevX = x;
        prevY = y;
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
        if (this.group== Group.BAD && r.nextInt(100)>93)  randomDir();
        boundCheck();
        //更新碰撞矩形放在边界检测以后更好
        rectangle.x = this.x;
        rectangle.y = this.y;
    }

    private void boundCheck() {
        if (this.x<2) x = 2;
        if (this.y<28) y=28;
        if (this.x> TankFrame.GAME_WIDTH- Tank.TANK_WIDTH-2) x= TankFrame.GAME_WIDTH- Tank.TANK_WIDTH-2;
        if (this.y> TankFrame.GAME_HIGHT- Tank.TANK_HIGHT-2) y= TankFrame.GAME_HIGHT- Tank.TANK_HIGHT-2;
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
        //开火的策略，方法传参最好策略的实现做成单例；成员变量上作用域太大；

//        int bX = this.x+ Tank.TANK_WIDTH/2- Bullet.WIDTH/2;
//        int bY = this.y+ Tank.TANK_HIGHT/2 - Bullet.HIGHT/2;
//        tankFrame.bullets.add(new Bullet(bX,bY,dir,this.group,this.tankFrame));
        this.fs.fire(this);

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
    public void stop(){
        this.moving = false;
    }
    //TODO 初始化就碰撞了会有bug
    public void back(){
        x = prevX;
        y = prevY;
    }
}
