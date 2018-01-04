package homework.users;

public class Books {
    private String bookName;
    private  String author;
    private  String price;

    @Override
    public String toString() {
        return "Books{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Books() {

    }

    public Books(String bookName, String author, String price) {

        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }
}
