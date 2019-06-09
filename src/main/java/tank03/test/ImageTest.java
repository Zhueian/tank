package tank03.test;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @Auther: qiucy
 * @Date: 2019-06-09 19:06
 * @Description:
 */
public class ImageTest {
    @Test
    public void test(){
        try {
            BufferedImage read = ImageIO.read(new File(""));
            assertNotNull(read);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
