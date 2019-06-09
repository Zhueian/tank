package tank03;

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
    private static final int TANK_WIDTH = 30;
    private static final int TANK_HIGHT = 30;

    public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }
    public void paint(Graphics g) {
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
        switch (dir){
            case LEFT:
                tankFrame.bullets.add(new Bullet(this.x, this.y+(TANK_HIGHT/2)+3, this.dir,this.tankFrame));
                break;
            case RIGHT:
                tankFrame.bullets.add(new Bullet(this.x+TANK_WIDTH, y+(TANK_HIGHT/2)+3, this.dir,this.tankFrame));
                break;
            case UP:
                tankFrame.bullets.add(new Bullet(this.x+(TANK_WIDTH/2)+3, this.y, this.dir,this.tankFrame));
                break;
            case DOWN:
                tankFrame.bullets.add(new Bullet(this.x+(TANK_WIDTH/2)+3, this.y+TANK_HIGHT, this.dir,this.tankFrame));
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
