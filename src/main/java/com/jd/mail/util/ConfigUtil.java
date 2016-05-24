package com.jd.mail.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by caozhifei on 2016/5/24.
 */
public class ConfigUtil {
    /**
     * 读取Properties配置文件
     *
     * @param @param  confPath
     * @param @return
     * @return Properties
     * @throws
     * @Title: getPropertiesFile
     * @author caozhifei
     * @date 2015-3-18 上午09:29:31
     */
    public static Properties getPropertiesFile(String confPath) throws IOException {
        InputStream is = ConfigUtil.class.getClassLoader().getResourceAsStream(confPath);
        Properties prop = new Properties();
        prop.load(is);
        is.close();
        return prop;

    }

}
