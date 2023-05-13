package book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 重複した書籍を含まない。というのは本棚の規則
public class BookShelf {// 作成される時に、重複チェック 本足される時に重複チェックというコード
    private List<Book> books = new ArrayList<Book>();

    private BookShelf(List<Book> books) {
        this.books = books;
    }

    /**
     * 本棚のファクトリメソッド
     * 
     * @param books
     * @return BookShelf
     */
    public static BookShelf contain(List<Book> books) {
        return new BookShelf(BookShelf.uniqueBooks(books));
    }

    /**
     * booksのゲッター
     * @return
     */
    public List<Book> books() {
        return books;
    }

    /**
     * 本棚に書籍を追加するメソッド
     * @param toBeAdded
     */
    public void gain(Book... toBeAdded) {
        this.books.addAll(
            BookShelf.uniqueBooks(Arrays.asList(toBeAdded))
                .stream()
                .filter(book -> isNotOnBookShelf(book))
                .collect(Collectors.toList())
        );
    }

    // TODO メソッドの切り方がまずいのか、良い名前が浮かばなかった 
    // 本棚に重複した書籍がないのは本棚の規則　ただ、重複をなくすのは「’本棚の責務で良いのか？
    /**
     * 追加する本の重複を排除するメソッド
     * @param toBeAdded
     * @return List<Book>
     */ 
    private static List<Book> uniqueBooks(List<Book> toBeAdded) {
        return toBeAdded
             .stream()
             .distinct()
             .collect(Collectors.toList());
    }

    /**
     * 本棚に同じ本がすでにないか判定する関数を返すメソッド
     * @return　boolean
     */
    private boolean isNotOnBookShelf(Book toBeAdded) {
        return books
            .stream()
            .anyMatch(book -> book.sameAs(toBeAdded));
    }

}