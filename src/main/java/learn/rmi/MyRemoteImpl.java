package learn.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.rmi
 * company: SiBu
 * create_date: 2017/08/12
 * description :
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{


    protected MyRemoteImpl() throws RemoteException {
    }

    @Override
    public void print(String s) throws RemoteException {
        System.out.println(s);
    }

    public static void main(String[] args) {

        try {
            MyRemote myRemote = new MyRemoteImpl();
            LocateRegistry.createRegistry(60608);
            Naming.rebind("rmi://192.168.130.148:60608/MyRemote", myRemote);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
