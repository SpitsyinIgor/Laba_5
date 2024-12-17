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

  
    public <T> T injectDependencies(T target) {
        try {
            Class<?> targetClass = target.getClass();
            Object instance = targetClass.getDeclaredConstructor().newInstance();
            Field[] fields = targetClass.getDeclaredFields();

            for (Field field : fields) {
                Annotation[] fieldAnnotations = field.getAnnotations();
                if (Arrays.stream(fieldAnnotations).anyMatch(annotation -> annotation.annotationType() == AutoInjectable.class)) {
                    field.setAccessible(true);
                    Class<?> fieldType = field.getType();
                    String typeName = fieldType.getName();

                    Object dependencyName = this.config.get(typeName);
                    String dependencyClassName = dependencyName.toString();

                    Class<?> dependencyClass = Class.forName(dependencyClassName);
                    Object dependencyInstance = dependencyClass.getDeclaredConstructor().newInstance();
                    field.set(instance, dependencyInstance);
                }
            }
            return (T) instance;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
