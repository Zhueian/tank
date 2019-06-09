package tank03;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * @Auther: qiucy
 * @Date: 2019-06-09 19:48
 * @Description:游戏都是先启动加载静态资源的，不能要一个才去硬盘读一个
 */

public class ResoueceMgr {
    public static BufferedImage tankL,tankR,tankU,tankD;
    public static BufferedImage bulletL,bulletD,bulletR,bulletU;
    static {
        try {

            tankD = ImageIO.read(ResoueceMgr.class.getClassLoader().getResourceAsStream("image/tankD.gif"));
            tankU = ImageIO.read(ResoueceMgr.class.getClassLoader().getResourceAsStream("image/tankU.gif"));
            tankL = ImageIO.read(ResoueceMgr.class.getClassLoader().getResourceAsStream("image/tankL.gif"));
            tankR = ImageIO.read(ResoueceMgr.class.getClassLoader().getResourceAsStream("image/tankR.gif"));
            bulletL = ImageIO.read(ResoueceMgr.class.getClassLoader().getResourceAsStream("image/bulletL.gif"));
            bulletR = ImageIO.read(ResoueceMgr.class.getClassLoader().getResourceAsStream("image/bulletR.gif"));
            bulletU = ImageIO.read(ResoueceMgr.class.getClassLoader().getResourceAsStream("image/bulletU.gif"));
            bulletD = ImageIO.read(ResoueceMgr.class.getClassLoader().getResourceAsStream("image/bulletD.gif"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
