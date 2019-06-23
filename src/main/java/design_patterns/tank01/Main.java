package design_patterns.tank01;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-06-05 20:40
 * @Description:
 */
public class Main {
    //TODO 策略模式：对if else switch的封装，多态的应用，
    //TODO 策略1：打出普通子弹，策略2：核弹：策略3：四方向打子弹。
    //TODO 开火策略写在配置文件，但是先不改。
    //TODO 用工厂，搞一族坦克，一族子弹，一族爆炸，暴露到配置文件，
    //TODO 设计模式精通了都是随心所欲，名字只是用来和人沟通的
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
