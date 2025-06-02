package BookReview.app.main.java.ui;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import BookReview.app.main.java.data.BookRepository;
import BookReview.app.main.java.model.Book;
import java.util.List;

public class BookViewModel extends AndroidViewModel {
  private final BookRepository repo;

  public BookViewModel(Application app) {
    super(app);
    repo = new BookRepository(app);
  }

  public LiveData<List<Book>> getBooks() {
    return repo.getBooks();
  }

  public void saveFavorite(Book book) {
    repo.saveFavorite(book);
  }

  public LiveData<List<Book>> getFavorites() {
    return repo.getFavorites();
  }
}
