package design_patterns.tank01;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Auther: qiucy
 * @Date: 2019-06-15 20:16
 * @Description:
 */
public class ImageUtil {
    public static BufferedImage rotateImage(final BufferedImage buf,final int degree){
        int w = buf.getWidth();
        int h = buf.getHeight();
        int type = buf.getColorModel().getTransferType();
        BufferedImage img;
        Graphics2D g2D;
        (g2D = (img = new BufferedImage(w,h,type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2D.rotate(Math.toRadians(degree),w/2,h/2);
        g2D.drawImage(buf,0,0,null);
        g2D.dispose();
        return img;
    }
}
