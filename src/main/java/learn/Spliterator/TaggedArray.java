package learn.Spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author suzheng
 * @version v.1.0
 */
public class TaggedArray<T> {
    private final Object[] elements;

    public TaggedArray(T[]data, Object[] elements) {
        this.elements = elements;
    }

    public Spliterator<T> spliterator(){
        return  null;
    }

    static class  TaggedArraySpliterator<T> implements Spliterator<T>{
        private final T[] array;
        private int origin;
        private final int fence;

        public TaggedArraySpliterator(T[] array, int origin, int fence) {
            this.array = array;
            this.origin = origin;
            this.fence = fence;
        }

        @SuppressWarnings("unchecked")
        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            for (;origin<fence;origin +=2){
                action.accept((T)array[origin]);
            }
        }

        @SuppressWarnings("unchecked")
        @Override
        public boolean tryAdvance(Consumer<? super T> action) {
            if(origin < fence){
                action.accept((T)array[origin]);
                origin +=2;
                return true;
            }
            return false;
        }

        @Override
        public Spliterator<T> trySplit() {
            int lo = origin;
            int mid = ((lo + fence)>>>1)&~1;
            if(lo < mid){
                origin = mid;
                return  new TaggedArraySpliterator<T>(array,lo,mid);
            }
            return null;
        }

        @Override
        public long estimateSize() {
            return (long)((fence-origin)/2);
        }

        @Override
        public int characteristics() {
            return ORDERED | SIZED | IMMUTABLE | SUBSIZED;
        }

        public static void main(String[] args) {
            int i  = 2;
            int i1 = 3;
            System.out.println(i|i1);
            String[] arrayStr = {"a","b","a","b","a","b","a","b"};
            TaggedArraySpliterator spliterator = new TaggedArraySpliterator<String>(arrayStr,0,arrayStr.length);
            System.out.println(Integer.toHexString(Spliterator.ORDERED)+"二进制："+Integer.toBinaryString(Spliterator.ORDERED));
            System.out.println(Integer.toHexString(Spliterator.SIZED)+"二进制："+Integer.toBinaryString(Spliterator.SIZED));
            System.out.println("二进制："+Integer.toBinaryString(ORDERED | SIZED )+ " ORDERED | SIZED "+Integer.toHexString(ORDERED | SIZED ));
            System.out.println("二进制："+Integer.toBinaryString((ORDERED | SIZED)& SIZED ));
            System.out.println(Integer.toHexString(Spliterator.IMMUTABLE));
            System.out.println(Integer.toHexString(Spliterator.SUBSIZED));
            System.out.println(Integer.toHexString(spliterator.characteristics()));

            int lo = 0;
            int fence = 112;
//            int lo = origin;
//            int mid = ((lo + fence)>>>1)&~1;
//            if(lo < mid){
//                origin = mid;
//                return  new TaggedArraySpliterator<T>(array,lo,mid);
//            }

            System.out.println(Integer.toBinaryString(lo + fence));
            System.out.println(Integer.toBinaryString(~1));
            System.out.println(Integer.toBinaryString((lo + fence)>>1));
            System.out.println((lo + fence)>>>1);
            System.out.println((lo + fence)>>>1&~1);
        }
    }
}
