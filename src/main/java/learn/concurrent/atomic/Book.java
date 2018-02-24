package learn.concurrent.atomic;

/**
 * @author suzheng
 * @version v.1.0
 */
public class Book {
    private String name;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
