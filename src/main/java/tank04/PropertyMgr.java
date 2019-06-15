package tank04;

import java.io.IOException;
import java.util.Properties;

/**
 * @Auther: qiucy
 * @Date: 2019-06-15 23:06
 * @Description:
 */
public class PropertyMgr {
    private PropertyMgr(){}
    static Properties props = new Properties();
    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object get(String key){
        if (props == null) return null;
        return props.get(key);
    }

}
