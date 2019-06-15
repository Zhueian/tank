package tank01;


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: qiucy
 * @Date: 2019-06-05 21:01
 * @Description:
 */
public class TankFrame extends Frame {
    //volatle
    int x = 200,y=200,paintMethodInvokeCount=0;
    //TODO niubi
    public TankFrame(){
        //只在内存
//        Frame frame = new Frame();
        this.setSize(800,900);
        //窗口大小不能改
        setResizable(false);
        setTitle("tank war!");
        //这就可见了
        setVisible(true);
        //键盘监听
        addKeyListener(new MyKeyListener());
        //win监听器
        addWindowListener(new WindowAdapter() {
            //监听win Close这事件
            @Override
            public void windowClosing(WindowEvent e) {
                //win closing那就执行jvm退出
                System.exit(0);
            }
        });
    }
    //TODO niubi
    //窗口对象有的内存字节码有改变时候调用，setSize，setTitle等,会把背景清一遍在画！
    @Override
    public void paint(Graphics g){
        //Graphics系统给的画笔
        System.out.println("paint count = "+paintMethodInvokeCount);
        //填充一矩形
        g.fillRect(x,y,50,50);
//        x += 10;
//        y += 10;
        paintMethodInvokeCount++;
    }

    //自己用不暴露，就内部吧
    class  MyKeyListener extends KeyAdapter{
        Boolean bL;
        Boolean bU;
        Boolean bR;
        Boolean bD;
        @Override
        public void keyPressed(KeyEvent e) {

            System.out.println("key press");
            //调用paint(),刷新window
//            repaint();
            //coder无法初始化画笔
//            paint();
//            x += 10;
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
//                    x += 10;
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
//                    x -= 10;
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
//                    y -= 10;
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
//                    y += 10;
                    bD = true;
                    break;
                default:
                    break;

            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key release");
//            repaint();
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
//                    x += 10;
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
//                    x -= 10;
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
//                    y -= 10;
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
//                    y += 10;
                    bD = false;
                    break;
                default:
                    break;
            }
        }

    }
}
