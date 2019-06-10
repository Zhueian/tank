package tank03;

import java.awt.*;

/**
 * @Auther: qiucy
 * @Date: 2019-06-09 11:58
 * @Description:
 */

public class Tank{
    private int x,y;

    private boolean live = true;

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
    private static final int SPEED = 1;
    private boolean moving = false;
    private TankFrame tankFrame = null;
    public static final int TANK_WIDTH = ResoueceMgr.tankD.getWidth(),TANK_HIGHT=ResoueceMgr.tankD.getHeight();

    public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }
    public void paint(Graphics g) {
        if (!live) tankFrame.tanks.remove(this);
        //3D游戏引擎就是图片旋转的想GL引擎
        Color color = g.getColor();
//        g.setColor(Color.GREEN);
//        g.fillRect(x,y,TANK_WIDTH,TANK_HIGHT);
//        g.setColor(color);
        //第四个参数十个观察着observer，null就行。
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
    }

    public void fire() {
        //TODO 子弹出弹位置优化，
        // 做一个雷电游戏或者跳一跳，
        // 子弹坦克再加四个斜线方向，
        // 加碉堡，
        // 加地雷，
        // 加碉堡，
        // 加墙，
        // 加不同炮弹威力射速不同，
        // 加不同坦克移数攻速不同
        // 微信游戏引擎的碰撞：图形比较复杂动物形状等等而不是几何形状？？
        int bX = this.x+Tank.TANK_WIDTH/2-Bullet.WIDTH/2;
        int bY = this.y+Tank.TANK_HIGHT/2 - Bullet.HIGHT/2;
        tankFrame.bullets.add(new Bullet(bX,bY,dir,this.tankFrame));
//        switch (dir){
//            case LEFT:
//                tankFrame.bullets.add(new Bullet(this.x, this.y+(TANK_HIGHT/2)+3, this.dir,this.tankFrame));
//                break;
//            case RIGHT:
//                tankFrame.bullets.add(new Bullet(this.x+TANK_WIDTH, y+(TANK_HIGHT/2)+3, this.dir,this.tankFrame));
//                break;
//            case UP:
//                tankFrame.bullets.add(new Bullet(this.x+(TANK_WIDTH/2)+3, this.y, this.dir,this.tankFrame));
//                break;
//            case DOWN:
//                tankFrame.bullets.add(new Bullet(this.x+(TANK_WIDTH/2)+3, this.y+TANK_HIGHT, this.dir,this.tankFrame));
//                break;
//            default:break;
//        }
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
