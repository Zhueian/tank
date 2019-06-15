package tank03_1;

import lombok.Getter;

import java.awt.*;

/**
 * @Auther: qiucy
 * @Date: 2019-06-10 09:19
 * @Description:
 */
//@Getter
public class Obstacle {
    public final static int WIDTH = ResoueceMgr.obstacle.getWidth();
    public final static int HIGHT = ResoueceMgr.obstacle.getHeight();

    private int x,y;

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
    //TODO 随机生成的敌队坦克和障碍物要做碰撞检测,子弹碰撞障碍物得消失，坦克碰撞障碍物，方向移动被禁止。
    public void paintObstacleGroup(Graphics g){
        g.drawImage(ResoueceMgr.obstacle,150,150,null);
        g.drawImage(ResoueceMgr.obstacle,TankFrame.GAME_WIDTH-150,150,null);
        g.drawImage(ResoueceMgr.obstacle,150,TankFrame.GAME_HIGHT-150,null);
        g.drawImage(ResoueceMgr.obstacle,TankFrame.GAME_WIDTH-650,TankFrame.GAME_HIGHT-150,null);
    }
}
