package design_patterns.tank02;

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
