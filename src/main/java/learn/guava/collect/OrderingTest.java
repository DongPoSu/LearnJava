package learn.guava.collect;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.Comparator;
import java.util.List;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.guava.util
 * company: SiBu
 * create_date: 2017/07/31
 * description :
 */
public class OrderingTest {

    private static void testStaticOrdering(){
        List<String> list = Lists.newArrayList();
        list.add("peida");
        list.add("jerry");
        list.add("harry");
        list.add("eva");
        list.add("jhon");
        list.add("neron");

        System.out.println("list:"+ list);

        Ordering<String> naturalOrdering = Ordering.natural();
        Ordering<Object> usingToStringOrdering = Ordering.usingToString();
        Ordering<Object> arbitraryOrdering = Ordering.arbitrary();
        Ordering<String> orderingString = Ordering.from((o1, o2) ->  o1.length()> o2.length()?0:1);
//        orderingString.nullsFirst().reverse().onResultOf();
//
        System.out.println("naturalOrdering:"+ naturalOrdering.sortedCopy(list));
        naturalOrdering.compound(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
//        System.out.println("usingToStringOrdering:"+ usingToStringOrdering.sortedCopy(list));
//        System.out.println("arbitraryOrdering:"+ arbitraryOrdering.sortedCopy(list));
//
//        List<LiveSortedImgResponse> liveSortedImgResponses = Lists.newArrayList();
//        liveSortedImgResponses.add(new LiveSortedImgResponse(45));
//        liveSortedImgResponses.add(new LiveSortedImgResponse(222));
//        liveSortedImgResponses.add(new LiveSortedImgResponse(943));
//        liveSortedImgResponses.add(new LiveSortedImgResponse(3));
//        liveSortedImgResponses.add(new LiveSortedImgResponse(93));
//
//        Ordering<String> byLengthOrdering = new Ordering<String>() {
//            public int compare(String left, String right) {
//                return Ints.compare(left.length(), right.length());
//            }
//        };


    }

    public static void main(String[] args) {
        testStaticOrdering();

    }
}
