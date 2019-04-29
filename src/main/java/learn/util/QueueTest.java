package learn.util;

import java.util.AbstractQueue;
import java.util.Iterator;

/**
 * @author suzheng
 * @version v.1.0
 */
public class QueueTest extends AbstractQueue {
    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean offer(Object o) {
        return false;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }
}
