package learn.java.dynamicProxy;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.java.dynamicProxy
 * company: SiBu
 * create_date: 2017/08/12
 * description :
 */
public class UserServiceImpl implements UserService{
    private String msg;
    @Override
    public void print(String msg) {
        this.msg = msg;
        System.out.println("UserServiceImpl: "+ msg);
    }

    public String get(){
        return this.msg;
    }
}
