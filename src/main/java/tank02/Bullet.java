package tank02;

import java.awt.*;

/**
 * @Auther: qiucy
 * @Date: 2019-06-09 12:47
 * @Description:
 */
public class Bullet {
    private static final int SPEED = 10;
    private int x,y;
    private static int WIDTH = 5,HIGHT = 5;
    private Dir dir;

    public Bullet(int x, int y,Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    public void paint(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HIGHT);
        g.setColor(color);
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
            default:break;
        }
    }
}
