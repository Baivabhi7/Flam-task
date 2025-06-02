package BookReview.app.main.java.utils;

import BookReview.app.main.java.model.Book;
import java.util.ArrayList;
import java.util.List;

public class FakeBookApi {
  public static List<Book> getBooks() {
    List<Book> books = new ArrayList<>();
    Book book = new Book();
    book.id = 1;
    book.title = "The Great Gatsby";
    book.author = "F. Scott Fitzgerald";
    book.description = "A classic novel set in the Roaring Twenties.";
    book.rating = 4.3f;
    book.thumbnail = ""; // Placeholder
    book.isFavorite = false;
    books.add(book);
    return books;
  }
}
