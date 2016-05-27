import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.JclObjectFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class ClassReload {

    public static String JAR;


    public static void setJar(String jarName){
        JAR = jarName;
    }

    public static Optional<Object> getInstance(String qualifiedClassName) {

        Optional<Object> obj = Optional.empty();
        try {
            JarClassLoader JCL = new JarClassLoader();
            JCL.add(new FileInputStream(JAR));
            JclObjectFactory factory = JclObjectFactory.getInstance();
            obj = Optional.of(factory.create(JCL, qualifiedClassName));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return obj;
    }

    public static Object response(String className) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Optional<Object> instance = ClassReload.getInstance(className);

        if (instance.isPresent()) {
            Object o = instance.get();
            return o.getClass().getMethod("process").invoke(o);
        }

        return "";
    }
}
