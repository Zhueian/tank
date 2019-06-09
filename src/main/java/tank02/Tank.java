package tank02;

import java.awt.*;

/**
 * @Auther: qiucy
 * @Date: 2019-06-09 11:58
 * @Description:
 */

public class Tank{
    private int x,y;
    private Dir dir =Dir.DOWN;
    private static final int SPEED = 1;

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    //tank最知道怎么画自己，封装设计的思想
    public void paint(Graphics g) {
        g.fillRect(x,y,30,30);
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
        //这里有点意思
//        g.fillRect(x,y,30,30);
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
}
