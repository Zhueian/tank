package tank04;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * @Auther: qiucy
 * @Date: 2019-06-09 19:48
 * @Description:游戏都是先启动加载静态资源的，不能要一个才去硬盘读一个
 */

public class ResoueceMgr {
    public static BufferedImage tankL,tankR,tankU,tankD;
    public static BufferedImage bulletL,bulletD,bulletR,bulletU;
    public static BufferedImage[] explodes = new BufferedImage[16];
    static {
        try {
            //TODO 优化坦克图片有问题我操
//            tankU = ImageIO.read(ResoueceMgr.class.getClassLoader().getResourceAsStream("image/BadTank1.png"));
//            tankD = ImageUtil.rotateImage(tankU,180);
//            tankL = ImageUtil.rotateImage(tankU,-90);
//            tankR = ImageUtil.rotateImage(tankU,90);
            //子弹
//            bulletU = ImageIO.read(ResoueceMgr.class.getClassLoader().getResourceAsStream("image/bulletU.png"));
//            bulletL = ImageUtil.rotateImage(bulletU,-90);
//            bulletR = ImageUtil.rotateImage(bulletU,90);
//            bulletD = ImageUtil.rotateImage(bulletU,180);
            //坦克
            tankD = ImageIO.read(ResoueceMgr.class.getClassLoader().getResourceAsStream("image/tankD.gif"));
            tankU = ImageIO.read(ResoueceMgr.class.getClassLoader().getResourceAsStream("image/tankU.gif"));
            tankL = ImageIO.read(ResoueceMgr.class.getClassLoader().getResourceAsStream("image/tankL.gif"));
            tankR = ImageIO.read(ResoueceMgr.class.getClassLoader().getResourceAsStream("image/tankR.gif"));
//            //子弹
            bulletL = ImageIO.read(ResoueceMgr.class.getClassLoader().getResourceAsStream("image/bulletL.gif"));
            bulletR = ImageIO.read(ResoueceMgr.class.getClassLoader().getResourceAsStream("image/bulletR.gif"));
            bulletU = ImageIO.read(ResoueceMgr.class.getClassLoader().getResourceAsStream("image/bulletU.gif"));
            bulletD = ImageIO.read(ResoueceMgr.class.getClassLoader().getResourceAsStream("image/bulletD.gif"));
            //爆炸
            for (int i = 0; i < 16; i++) explodes[i] = ImageIO.read(ResoueceMgr.class.getClassLoader().getResourceAsStream("image/e"+(i+1)+".gif"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
