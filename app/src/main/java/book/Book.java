package book;

public class Book {
    private final String title;
    private final String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String title() {
        return title;
    }

    public String author() {
        return author;
    }

    // TODO 見様見真似で書いてみたがこれで良いのか。ビットシフトなどあまり把握できていない
    @Override
    public int hashCode() {
        final int coefficient = 31;
        return title.hashCode() * coefficient
             + author.hashCode() * coefficient;
    }

    @Override
    public boolean equals(Object comparisonBook) {
        if(this == comparisonBook) return true;
        if(comparisonBook instanceof Book) {
            return sameAs((Book) comparisonBook);
        }else{
            return false;
        }

    }

    /**
     * この世界ではタイトルと著者名が同じ本は同じ本とみなす
     * @param comparisonBook
     * @return 
     */
    public boolean sameAs(Book comparisonBook) {
        return title == comparisonBook.title() 
            && author == comparisonBook.author();
    }
}
