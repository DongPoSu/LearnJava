package learn.rmi;

import java.rmi.Naming;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.rmi
 * company: SiBu
 * create_date: 2017/08/12
 * description :
 */
public class MyRemoteClient {
    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    private void go() {
        try {
            MyRemote myRemote = (MyRemote)Naming.lookup("rmi://192.168.130.148:60608/MyRemote");
            for (int i = 0; i < 10; i++) {
                myRemote.print("rmi接口调用成功");
            }
//            String[] list = Naming.list("rmi://192.168.130.148:60608/MyRemote");
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
