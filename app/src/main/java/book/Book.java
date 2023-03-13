package book;

public class Book {
    private final String title;
    private final String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String title() {
        return this.title;
    }

    public String author() {
        return this.author;
    }

    @Override
    public boolean equals(Object comparisonBook) {
        if(this == subject) return true;
        if(subject instanceof Book) {
            return this.sameBook();
        }else{
            return false;
        }

    }

    /**
     * この世界ではタイトルと著者名が同じ本は同じ本とみなす
     * @param comparisonBook
     * @return 同じであればtrue
     */
    public boolean sameAs(Book comparisonBook) {
        return this.title() == comparisonBook.title() 
            && this.author() == comparisonBook.author();
    }
}
