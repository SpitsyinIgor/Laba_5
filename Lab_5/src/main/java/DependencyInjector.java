import annotation.AutoInjectable;

import java.io.FileInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Properties;

public class DependencyInjector {
    private Properties config = new Properties();
    private FileInputStream resourceFile;

    public DependencyInjector() {
        try {
            resourceFile = new FileInputStream("src/main/resources/props.properties");
            config.load(resourceFile);
        } catch (Exception e) {
            System.out.println("Unable to locate properties file!");
        }
    }

  
}
