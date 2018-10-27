package learn.jvmClass;

/**
 * @author suzheng
 * @version v.1.0
 */
public class FileClassLoader extends ClassLoader {

    static {
        System.out.println("class load");
    }
    @Override
     public Class<?> findClass(String name) throws ClassNotFoundException {
        throw new ClassNotFoundException(name);
    }
}
