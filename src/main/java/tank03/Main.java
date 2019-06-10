package tank03;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-06-05 20:40
 * @Description:
 */
public class Main {
    private static Random r = new Random();
    public static void main(String[] args) {
        TankFrame tankFrame = new TankFrame();
        for (int i = 0; i < 5; i++) {
            //TODO tank 死了搞个多线程生产者生产点人机。消费者已经有了
            tankFrame.tanks.add(new Tank(r.nextInt(TankFrame.GAME_WIDTH-Tank.TANK_WIDTH),
                    r.nextInt(TankFrame.GAME_HIGHT-Tank.TANK_HIGHT),Dir.DOWN,tankFrame));
        }
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tankFrame.repaint();
        }
        //TODO 02 作业：搞出一个排敌人坦克并且挨个排干掉他们。年薪百万的人写这种都是半天就写好了！！
    }
}
