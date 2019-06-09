package tank01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-06-05 20:40
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
//        //只在内存
//        Frame frame = new Frame();
//        frame.setSize(800,900);
//        //窗口大小不能改
//        frame.setResizable(false);
//        frame.setTitle("tank war!");
//        //这就可见了
//        frame.setVisible(true);
//        //win监听器
//        frame.addWindowListener(new WindowAdapter() {
//            //监听win Close这事件
//            @Override
//            public void windowClosing(WindowEvent e) {
//                //win closing那就执行jvm退出
//                System.exit(0);
//            }
//        });
        TankFrame tankFrame = new TankFrame();
        while (true){
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tankFrame.repaint();
        }
        //TODO 根据boolean，计算坦克方向，坦克能控制停止启动，或者鼠标控制方向！
    }
}
