package learn.jvmClass;

import com.sun.jmx.snmp.ThreadContext;

import java.sql.SQLException;

/**
 * @author suzheng
 * @version v.1.0
 */
public class SpiJdbc {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
//        Connection connection = DriverManager.getConnection("jdbc:mysql://120.76.190.48/sibu_shop?characterEncoding=utf8&useUnicode=true","sibu_wesale","emIFhtPc6tKiniwfvNC6");
//        connection.setAutoCommit(false);
//        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
//        for (Driver d:
//             serviceLoader) {
//            d.getParentLogger();
//        }
//        Class cls = Class.forName(FileClassLoader.class.getName(),false,ClassLoader.getSystemClassLoader());
//        cls.newInstance();
        Class cls = Thread.currentThread().getContextClassLoader().loadClass(FileClassLoader.class.getName());
        cls.newInstance();
    }
}
