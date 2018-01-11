package bookstore.shopping.domain;

import bookstore.books.domain.Book;

public class CartItem {
    private String bid;
    private String bname;
    private String price;
    private String author;
    private String image;
    private String count;

    @Override
    public String toString() {
        return "CartItem{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", price='" + price + '\'' +
                ", author='" + author + '\'' +
                ", image='" + image + '\'' +
                ", count='" + count + '\'' +
                '}';
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public CartItem() {

    }

    public CartItem(String bid, String bname, String price, String author, String image, String count) {

        this.bid = bid;
        this.bname = bname;
        this.price = price;
        this.author = author;
        this.image = image;
        this.count = count;
    }
}
