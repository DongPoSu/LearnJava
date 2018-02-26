package learn.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author suzheng
 * @version v.1.0
 */
public class MyLikeBook {
    /**
     * must be volatile type
     */
    private volatile Book myLikeBook;
    private AtomicReferenceFieldUpdater<MyLikeBook, Book> updater =
            AtomicReferenceFieldUpdater.newUpdater(MyLikeBook.class, Book.class, "myLikeBook");

    public Book getMyLikeBook() {
        return myLikeBook;
    }

    public void setMyLikeBook(Book myLikeBook) {
//        this.myLikeBook = myLikeBook;
        updater.compareAndSet(this,this.myLikeBook,myLikeBook);
    }

    public static void main(String[] args) {
        MyLikeBook myLikeBook = new MyLikeBook();
        myLikeBook.setMyLikeBook(new Book("zero to one"));
        System.out.println(myLikeBook.getMyLikeBook().getName());
        myLikeBook.setMyLikeBook(new Book("ten devil"));
        System.out.println(myLikeBook.getMyLikeBook().getName());
    }
}
