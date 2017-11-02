package learn.guava.basic;


import com.google.common.base.Preconditions;

import java.util.Optional;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.guava.basic
 * company: SiBu
 * create_date: 2017/07/31
 * description :
 */
public class PreconditionsTest {
    public static void main(String[] args) {
//        Preconditions.checkArgument(false);
//        Preconditions.checkArgument(false,"string");
        // 检查集合中元素下标正确且小于集合大小，同时size也会被检查,index必须小于size
        Preconditions.checkElementIndex(1,10);
        // 检查集合中元素下标正确且小于集合大小，size也会被检查,index可以小于等于size
        Preconditions.checkPositionIndex(1,2);

        Preconditions.checkArgument(true,"%s","Order delivery info must not be null");
        Optional<Integer> optional = Optional.ofNullable(null);
        Preconditions.checkNotNull(optional.isPresent(),"optional is null");
//        Preconditions.checkState();
    }
}
