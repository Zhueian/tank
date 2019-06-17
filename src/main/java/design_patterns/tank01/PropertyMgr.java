package design_patterns.tank01;

import java.io.IOException;
import java.util.Properties;

/**
 * @Auther: qiucy
 * @Date: 2019-06-15 23:06
 * @Description:
 */
public class PropertyMgr {
    private PropertyMgr(){}
    //volatitle最重要防止JIT，防止指令重排。
    static volatile Properties props = new Properties();
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
