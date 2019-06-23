package design_patterns.tank02;

import java.awt.*;

/**
 * @Auther: qiucy
 * @Date: 2019-06-23 22:38
 * @Description:名词用抽象类，副词形容词用接口
 */
public abstract class GameObject {
    int x,y;
    public abstract void paint(Graphics g);
}
