package learn.java.extendtest;

import java.util.ArrayList;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.java.extendtest
 * company: SiBu
 * create_date: 2017/03/01
 * description :
 */
public class A {
    public String pu ="a_pu";
    protected String po ="a_po";
    private String pr ="a_pr";

    public static void main(String[] args) {
        ArrayList<A> arrayList = new ArrayList();
        arrayList.add(new B());
    }
}


