package learn.collection;

import java.util.AbstractCollection;
import java.util.List;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.collection
 * company: SiBu
 * create_date: 2017/10/26
 * description :
 * @author suzheng
 */
public abstract class AbstractMyList<E> extends AbstractCollection<E> implements List<E>{
    @Override
    public boolean add(E e) {
        return super.add(e);
    }

    @Override
    public void add(int index, E element) {

    }
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE - 8);
    }
}
