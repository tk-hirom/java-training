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
     * @return
     */
    public List<Book> シチュエーション1_本のリストに重複なく本を足したい(List<Book> books, Book... toBeAdded) {
        return Arrays.asList(toBeAdded)
            .stream()
            .distinct()
            .filter(doesNotExistInBooks(books));
    }

    private Callable isSameAs(Book actualAddition) {
        return (Book book) -> {actualAddition.sameAs(book);};
    }

    private Callable doesNotExistInBooks(List<Book> books) {
        return (Book addedBook) ->{ books
            .stream()
            .filter(isSameAs(addedBook))
            .findFirst();};
    }
}
