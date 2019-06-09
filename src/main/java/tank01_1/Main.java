package tank01_1;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-06-05 20:40
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        TankFrame tankFrame = new TankFrame();

        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tankFrame.repaint();
        }
        //TODO 根据boolean，计算坦克方向，坦克能控制停止启动。或者鼠标控制方向！
    }
}
