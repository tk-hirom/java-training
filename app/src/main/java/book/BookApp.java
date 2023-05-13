package book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream;
import java.util.concurrent.Callable;

public class BookApp {

    /**
     * 
     * @param books
     * @param toBeAdded
     * @return List<Book> 
     */
    public List<Book> シチュエーション1_本のリストに重複なく本を足したい(BookShelf bookShelf, Book... toBeAdded) {
        bookShelf.gain(toBeAdded);
        return bookShelf.books();
    }

}
