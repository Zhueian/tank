package tank03;

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
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tankFrame.repaint();
        }
        //TODO 02 作业：搞出一个排敌人坦克并且挨个排干掉他们。年薪百万的人写这种都是半天就写好了！！
    }
}
