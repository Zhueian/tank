package tank04;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-06-05 20:40
 * @Description:
 */
public class Main {
    //TODO 学学kotlin？
    //TODO 所有动作，背景音乐，图片优化
    //TODO 发射炮弹，炮管要爆炸和收缩效果
    //TODO bad1 tank和bad2 tank要交互闪烁
    //TODO 加入buff和debuff道具，汽油加速（图片淡化慢慢显示，不是一下就显示生成）一段时间，炮弹威力加大一段时间，
    //TODO tank要有护甲值
    //TODO 游戏音乐的切换
    //TODO 可见度加入，不是整个图所有敌人都能看到(随中心逐渐阴暗)，黑森里法则
    //TODO java2exe
    private static Random r = new Random();
    public static void main(String[] args) {
        TankFrame tankFrame = new TankFrame();
        int initTankCount = Integer.parseInt(PropertyMgr.get("initTankCount")+"");
        for (int i = 0; i < initTankCount; i++) {
            tankFrame.tanks.add(new Tank(r.nextInt(TankFrame.GAME_WIDTH- Tank.TANK_WIDTH),
                    r.nextInt(TankFrame.GAME_HIGHT- Tank.TANK_HIGHT), Dir.DOWN, Group.BAD,tankFrame));
        }
        new Thread(()->{
            new Audio("Audio/war1.wav").loop();
        }).start();
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tankFrame.repaint();
        }
    }
}
