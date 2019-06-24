package design_patterns.tank02;

import java.awt.*;

/**
 * @Auther: qiucy
 * @Date: 2019-06-24 22:28
 * @Description:
 */
public class Wall extends GameObject {
    int w,h;
    public Rectangle rect;

    public Wall(int w, int h,int x,int y) {
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;

        this.rect = new Rectangle(x,y,w,h);
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x,y,w,h);
        g.setColor(color);
    }
}
