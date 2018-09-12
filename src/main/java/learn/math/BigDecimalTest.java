package learn.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/**
 * @author suzheng
 * @version v.1.0
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        System.out.println(new BigDecimal(new BigInteger("111111111111111111111111111111111111111111111111",10)).toString());
    }
}
