package learn.java.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.java.rmi
 * company: SiBu
 * create_date: 2017/08/12
 * description :
 */
public interface MyRemote extends Remote{
    void print(String s) throws RemoteException;
}
