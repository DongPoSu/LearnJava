package learn.util;

import java.util.BitSet;

/**
 * @author suzheng
 * @version v.1.0
 */
public class TreeSetTest {

    private Integer t;

    public TreeSetTest(Integer t) {
        this.t = t;
    }

    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(3);
        bitSet.set(4);
        bitSet.set(65);

        System.out.println(Long.toBinaryString(2<<1L));
        System.out.println(Long.toBinaryString(2<<1L));
    }


}
