package learn.dynamicProxy;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.dynamicProxy
 * company: SiBu
 * create_date: 2017/08/12
 * description :
 */
public interface UserService{
    void print(String msg);
    default String get(){
        return "2343";
    }
}
